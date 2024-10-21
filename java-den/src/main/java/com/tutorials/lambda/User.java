package com.tutorials.lambda;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class User implements Serializable {

	@Setter(AccessLevel.PROTECTED)
    private Long id; 
    private String firstName;
    private String lastName;
    private int age;
    
    private final AtomicReference<Object> transactions = new AtomicReference();


}
