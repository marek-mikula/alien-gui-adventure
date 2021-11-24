package en.mikula.adventure.utils;

import java.util.Arrays;

public class CaseTransformer {

    /**
     * Transforms given text in camel case to snake case
     */
    public static String camelToSnake(String text) {
        // Split string by capital letters
        String[] parts = text.split("(?=\\p{Upper})");

        // Map strings to be lower case
        parts = Arrays.stream(parts).map(String::toLowerCase).toArray(String[]::new);

        // Join string array with an underscore
        return String.join("_", parts);
    }

}
