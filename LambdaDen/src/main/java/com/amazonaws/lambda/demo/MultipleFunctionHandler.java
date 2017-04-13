package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * 	@author ravi.routhu
 *	Handles Lambda request
 */
public class MultipleFunctionHandler implements RequestHandler<String, String> {

    public String handleRequest(String input, Context context) {
        context.getLogger().log("MultipleFunctionHandler Input: " + input);

        String output = "Hello, " + input + "!";
        System.out.println("MultipleFunctionHandler --------- .>>>>   "+output);
        return output;
    }

}
