package com.business.thrive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadMatchData {

	static class PlayerInfo {
		String name;
		String score;

		PlayerInfo(String name, String score) {
			this.name = name;
			this.score = score;
		}
	}

	private static String excelFilePath;

	public static void main(String[] args) {

		System.out.println("ReadMatchDataReadMatchData business");
		String filePath = "src/main/resources/match_data.json";
		readJson(filePath);
	}

	private static void readJson(String filePath) {
		try {
			// Read entire file as string
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			JSONObject data = new JSONObject(content);

			// 1. Extract Match Information
			System.out.println("=== Match Summary ===");
			JSONObject teams = data.getJSONObject("match").getJSONObject("teams");

			// Collect team names dynamically without hardcoding
			Iterator<String> teamKeys = teams.keys();
			String team1 = teamKeys.hasNext() ? teamKeys.next() : "Team 1";
			String team2 = teamKeys.hasNext() ? teamKeys.next() : "Team 2";

			excelFilePath = ExcelOperations.createExcel(team1 + "vs" + team2);

			JSONObject team1Summary = teams.getJSONObject(team1);
			JSONObject team2Summary = teams.getJSONObject(team2);

			System.out.printf("%s: %d/%d in %.1f overs\n", capitalize(team1), team1Summary.getInt("score"),
					team1Summary.getInt("wickets"), team1Summary.getDouble("overs"));
			System.out.printf("%s: %d/%d in %.1f overs\n", capitalize(team2), team2Summary.getInt("score"),
					team2Summary.getInt("wickets"), team2Summary.getDouble("overs"));

			String result = team2Summary.has("result") ? team2Summary.getString("result")
					: (team1Summary.has("result") ? team1Summary.getString("result") : "N/A");
			System.out.println("Result: " + result + "\n");

			// Extract innings data dynamically (passing both teams)
			// printInningsData(data, team1, team2);
			// printInningsData(data, team2, team1);

			List<PlayerInfo> team1Players = getPlayers(data, team1);
			List<PlayerInfo> team2Players = getPlayers(data, team2);

			String winner = "";
			if (result.toLowerCase().contains(team1.toLowerCase()))
				winner = team1;
			else if (result.toLowerCase().contains(team2.toLowerCase()))
				winner = team2;

			Workbook excelSheet = ExcelOperations.createExcelTab(capitalize(team1), excelFilePath, team1Players);
			excelSheet  		= ExcelOperations.createExcelTab(capitalize(team2), excelFilePath, team2Players);
			
			//ExcelOperations.writeToExcel(capitalize(team1), team1Players, excelSheet);
			// writeToExcel(team1, team1Players, team2, team2Players, winner);

		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.fillInStackTrace());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error parsing JSON data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static List<PlayerInfo> getPlayers(JSONObject data, String teamName) {
		List<PlayerInfo> players = new ArrayList<>();
		String inningsKey = teamName + "_innings";
		if (data.has(inningsKey)) {
			JSONObject innings = data.getJSONObject(inningsKey);
			if (innings.has("batting")) {
				JSONArray batting = innings.getJSONArray("batting");
				for (int i = 0; i < batting.length(); i++) {
					JSONObject batter = batting.getJSONObject(i);
					String name = batter.optString("batsman", "");
					if (!name.equalsIgnoreCase("Extras") && !name.isEmpty()) {
						players.add(new PlayerInfo(name, String.valueOf(batter.optDouble("runs", 0.0))));
					}
				}
			}
			if (innings.has("did_not_bat")) {
				JSONArray dnb = innings.getJSONArray("did_not_bat");
				for (int i = 0; i < dnb.length(); i++) {
					players.add(new PlayerInfo(dnb.getString(i), "DNB"));
				}
			}
		}
		return players;
	}

	/*private static void writeToExcel(String team1, List<PlayerInfo> team1Players,
	  String team2, List<PlayerInfo> team2Players, String winner) { 
		File file = new
	  File(excelFilePath);
	  
	  try (Workbook workbook = file.exists() ? new XSSFWorkbook(new
	  FileInputStream(file)) : new XSSFWorkbook()) {
	  
	  String capitalizedTeam1 = capitalize(team1); Sheet sheet1 =
	  workbook.getSheet(capitalizedTeam1); if (sheet1 == null) { sheet1 =
	  workbook.createSheet(capitalizedTeam1); } //writePlayersToSheet(workbook,
	  sheet1, team1Players, winner);
	  
	  String capitalizedTeam2 = capitalize(team2); Sheet sheet2 =
	  workbook.getSheet(capitalizedTeam2); if (sheet2 == null) { sheet2 =
	  workbook.createSheet(capitalizedTeam2); } //writePlayersToSheet(workbook,
	  sheet2, team2Players, winner);
	  
	  try (FileOutputStream fos = new FileOutputStream(file)) {
	  workbook.write(fos); }
	  System.out.println("Successfully wrote players to Excel file: " +
	  excelFilePath);
	  
	  } catch (Exception e) { System.err.println("Error writing to Excel: " +
	  e.getMessage()); } }

	private static void writePlayersToSheet(Workbook workbook, Sheet sheet,
	  List<PlayerInfo> players, String winner) { 
	  CellStyle headerStyle =
	  workbook.createCellStyle(); Font headerFont = workbook.createFont();
	  headerFont.setBold(true); headerStyle.setFont(headerFont);
	  headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	  headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	  
	  sheet.createRow(0); Row header = sheet.createRow(1); Cell headerCell =
	  header.createCell(1); headerCell.setCellValue("Won  " + capitalize(winner));
	  headerCell.setCellStyle(headerStyle);
	  
	  int rowIdx = 2; // skip row 1 to match England tab pattern 
	  for (PlayerInfo p : players) {
	   	Row row = sheet.createRow(rowIdx++);
	  	row.createCell(0).setCellValue(p.name); 
	  	if (!p.score.isEmpty()) { 
	  		if(p.score.equals("DNB")) {
	  		 	row.createCell(1).setCellValue(p.score); 
	  		 }
	  		else{
	  			try { 
	  				row.createCell(1).setCellValue(Double.parseDouble(p.score)); 
	  			} catch(NumberFormatException e) { row.createCell(1).setCellValue(p.score); 
	  		} 
	  	} 
	  } 
	 }
	}*/

	private static void printInningsData(JSONObject data, String battingTeam, String bowlingTeam) throws Exception {
		System.out.println("=== " + capitalize(battingTeam) + " Innings ===");
		String inningsKey = battingTeam + "_innings";
		if (!data.has(inningsKey)) {
			System.out.println("No innings data found for " + battingTeam + "\n");
			return;
		}

		JSONObject innings = data.getJSONObject(inningsKey);
		JSONObject total = innings.getJSONObject("total");

		System.out.printf("Total: %d/%d in %.1f overs (Run Rate: %.2f)\n", total.getInt("runs"),
				total.getInt("wickets"), total.getDouble("overs"), total.optDouble("run_rate", 0.0));

		// Batting
		System.out.println("\nBatting:");
		JSONArray batting = innings.getJSONArray("batting");
		for (int i = 0; i < batting.length(); i++) {
			JSONObject batter = batting.getJSONObject(i);
			String name = batter.getString("batsman");
			int runs = batter.getInt("runs");

			if (batter.has("dismissal")) {
				int balls = batter.optInt("balls", 0);
				int fours = batter.optInt("fours", 0);
				int sixes = batter.optInt("sixes", 0);
				double sr = batter.optDouble("strike_rate", 0.0);
				String dismissal = batter.getString("dismissal");
				System.out.printf("  %-20s | %-3d (%d) | 4s: %d | 6s: %d | SR: %.2f | %s\n", name, runs, balls, fours,
						sixes, sr, dismissal);
			} else {
				System.out.printf("  %-20s | %-3d (Extras)\n", name, runs);
			}
		}

		// Did not bat (new field added in the JSON)
		if (innings.has("did_not_bat")) {
			System.out.println("\nDid Not Bat:");
			JSONArray dnb = innings.getJSONArray("did_not_bat");
			for (int i = 0; i < dnb.length(); i++) {
				System.out.println("  " + dnb.getString(i));
			}
		}

		// Fall of wickets
		System.out.println("\nFall of Wickets:");
		JSONArray fow = innings.getJSONArray("fall_of_wickets");
		for (int i = 0; i < fow.length(); i++) {
			System.out.println("  " + fow.getString(i));
		}

		// Bowling
		System.out.println("\nBowling (" + capitalize(bowlingTeam) + "):");
		JSONArray bowling = innings.getJSONArray("bowling");
		for (int i = 0; i < bowling.length(); i++) {
			JSONObject bowler = bowling.getJSONObject(i);
			String name = bowler.getString("bowler");
			double overs = bowler.getDouble("overs");
			int maidens = bowler.getInt("maidens");
			int runs = bowler.getInt("runs");
			int wickets = bowler.getInt("wickets");
			double econ = bowler.getDouble("economy");

			System.out.printf("  %-18s | %.1f overs | %d maidens | %d runs | %d wickets | Econ: %.2f\n", name, overs,
					maidens, runs, wickets, econ);
		}
		System.out.println();
	}

	public static String capitalize(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

}
