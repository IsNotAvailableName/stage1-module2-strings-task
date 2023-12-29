package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String accessModifier = null;
        String returnType = null;
        String methodName = null;
        List<MethodSignature.Argument> argumentsList = new ArrayList<>();

        String[] methodString = signatureString.split("[(]");
        String[] arrArguments = methodString[1]
                .replaceAll("[)].*", "")
                .split(",");

        for (String s : arrArguments) {
            String[] args = s.trim().split(" ");
            if (args.length == 2) {
                argumentsList.add(new MethodSignature.Argument(args[0], args[1]));
            }
        }

        String[] methodFirstPart = methodString[0].split(" ");
        if (methodFirstPart.length == 2) {
            returnType = methodFirstPart[0];
            methodName = methodFirstPart[1];
        } else if (methodFirstPart.length == 3) {
            accessModifier = methodFirstPart[0];
            returnType = methodFirstPart[1];
            methodName = methodFirstPart[2];
        }

        MethodSignature methodSignature = new MethodSignature(methodName, argumentsList);
        methodSignature.setReturnType(returnType);
        methodSignature.setAccessModifier(accessModifier);
        return methodSignature;

    }
}
