package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<String, String> {

	/**
	 * handles request
	 */
    public String handleRequest(String input, Context context) {
        context.getLogger().log("LambdaFunctionHandler Input: " + input);

        String output = "Hello, " + input + "!";
        System.out.println("LambdaFunctionHandler --------- .>>>>   "+output);
        return output;
    }

}
