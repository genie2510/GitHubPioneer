package com.lambda.tutorials;

import java.awt.Shape;

import lombok.ToString;

@ToString
public class ToStringExample {
  private static final int STATIC_VAR = 10;
  private String name;
  private Shape shape = null;//new Square(5, 10);
  private String[] tags;
  @ToString.Exclude 
  private int id;
  
  public String getName() {
    return this.name;
  }
  
  @ToString(callSuper=true, includeFieldNames=true)
	public static class Square /* extends Shape */{
    private final int width, height;
    
    public Square(int width, int height) {
      this.width = width;
      this.height = height;
    }
  }
}