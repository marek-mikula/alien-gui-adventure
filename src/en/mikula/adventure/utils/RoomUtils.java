package en.mikula.adventure.utils;

import en.mikula.adventure.rooms.Room;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomUtils {

    public static String formatName(Room room) {
        return room.getName() + " [" + room.getRoomCode().getNumber() + "]";
    }

    public static int extractRoomNumber(String text) {
        Pattern patter = Pattern.compile("\\[([0-9]+)]");
        Matcher matcher = patter.matcher(text);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        throw new IllegalArgumentException("No room number found in string!");
    }

}
