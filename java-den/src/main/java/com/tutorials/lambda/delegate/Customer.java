package com.tutorials.lambda.delegate;

import lombok.experimental.Delegate;

public class Customer implements HasContactInformation {

	// Whichever other User-specific attributes

	@Delegate(types = { HasContactInformation.class })
	private final ContactInformationSupport contactInformation = new ContactInformationSupport();

	// User itself will implement all contact information by delegation

}