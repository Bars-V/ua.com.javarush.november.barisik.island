package ua.com.Barysik.island.settings;

import java.util.HashMap;

public class Parameters {

    private static HashMap<String, HashMap<String, Integer>> parameters = new HashMap<>();

    public static void setParameter(String parameterName, String className, Integer value) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        if (parameters.containsKey(parameterName)) {
            hashMap = parameters.get(parameterName);
        }
        hashMap.put(className, value);
        parameters.put(parameterName, hashMap);
    }

    public static void setParameterDouble(String parameterName, String className, Double value) {
        int valueInteger = (int) (value * 1_000_000);
        setParameter(parameterName, className, valueInteger);
    }

    public static void setEatTable(String hunterClassName, String preyClassName, Integer chance) {
        setParameter(hunterClassName, preyClassName, chance);
    }

    public static Integer getParameter(String parameterName, String className) {
        if (parameters.get(parameterName) == null) {
            return 0;
        } else if (parameters.get(parameterName).get(className) == null) {
            return 0;
        }
        return parameters.get(parameterName).get(className);
    }

    public static Double getParameterDouble(String parameterName, String className) {
        return ((double) getParameter(parameterName, className)) / 1_000_000;
    }

    public static Integer getEatTable(String hunterClassName, String preyClassName) {
        return getParameter(hunterClassName, preyClassName);
    }
}