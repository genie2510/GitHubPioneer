package com.homework.scalatutorial

object ExtractionDemo {
  def main(args: Array[String]) {
    println("Apply method : " + apply("Zara", "gmail.com"));
    println("Unapply method : " + unapply("Zara@gmail.com"));
    println("Unapply method : " + unapply("Zara Ali"));
  }

  // The injection method (optional)
  def apply(user: String, domain: String) = {
    user + "@" + domain
  }

  // about Option
 /* val name: Option[String] = request getParameter "name"
  val upper = name map { _.trim } filter { _.length != 0 } map { _.toUpperCase }
  println(upper getOrElse "")

  Note that this is equivalent to
  val upper = for {
    name <- request getParameter "name"
    trimmed <- Some(name.trim)
    upper <- Some(trimmed.toUpperCase) if trimmed.length != 0
  } yield upper
  println(upper getOrElse "")*/

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"

    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}