package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;

public class MultipleLambdaFunctionHandlers  {

    public String firstHandler(String input, Context context) {
        context.getLogger().log("MultipleLambdaFunctionHandlers MultipleLambdaFunctionHandlers Input: " + input);

        String output = "Hello, " + input + "!";
        System.out.println("MultipleLambdaFunctionHandlers Hi Cloud by firstHandler --------- .>>>>   "+output);
        System.out.println("This is the latest version firstHandler");
        return output;
    }
    
    public String secondHandler(String input, Context context) {
        context.getLogger().log("MultipleLambdaFunctionHandlers secondHandler Input: " + input);

        String output = "Hello, " + input + "!";
        System.out.println("MultipleLambdaFunctionHandlers Hi Cloud by secondHandler --------- .>>>>   "+output);
        System.out.println("This is the latest version from secondHandler");
        return output;
    }

}
