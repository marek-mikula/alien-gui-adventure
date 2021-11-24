package en.mikula.adventure.utils;

import en.mikula.adventure.items.terminals.TerminalOption;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalUtils {

    /**
     * Formats name for an option
     */
    public static String formatOptions(TerminalOption option) {
        return "[" + option.getNumber() + "] " + option.getText();
    }

    /**
     * Extracts option number from formatted option string
     */
    public static int extractOptionNumber(String text) {
        Pattern patter = Pattern.compile("\\[([0-9]+)]");
        Matcher matcher = patter.matcher(text);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        throw new IllegalArgumentException("No option number found in string!");
    }

}
