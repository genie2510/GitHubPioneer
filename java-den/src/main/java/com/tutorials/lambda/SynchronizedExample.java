package com.tutorials.lambda;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedExample {

	private final Object readLock = new Object();
	  
	  @Synchronized
	  public static void hello() {
	    System.out.println("world");
	  }
	  
	  @Synchronized
	  public int answerToLife() {
	    return 42;
	  }
	  
	  @Synchronized("readLock")
	  public void foo() {
	    System.out.println("bar");
	  }
	  
	  public static void main(String[] args) {
		  System.out.println("Lombokkk");
	}
}
