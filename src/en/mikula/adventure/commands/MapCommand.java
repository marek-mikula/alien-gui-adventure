package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.rooms.RoomCode;
import en.mikula.adventure.rooms.RoomConnection;

/**
 * Shows the map of the game with the current highlighted
 * room and available exits
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class MapCommand implements Command {

    private final Game game;

    public MapCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "map";
    }

    @Override
    public String fullSignature() {
        return signature();
    }

    @Override
    public String help() {
        return "Shows the map of the game, current room and possible exits.";
    }

    @Override
    public String run(String... args) {
        String[] numbers = new String[RoomCode.values().length];

        RoomCode currentRoomCode = game.getMap().getCurrentRoom().getRoomCode();

        // Loop trough all the room codes and highlight current room using ANSI escape codes
        for (RoomCode roomCode: RoomCode.values()) {
            if (currentRoomCode.equals(roomCode)) {
                numbers[roomCode.getNumber()] = "\u001B[32m" + roomCode.getNumber() + "\u001B[0m";
            } else {
                numbers[roomCode.getNumber()] = "" + roomCode.getNumber();
            }
        }

        StringBuilder map = new StringBuilder(String.join("\n", new String[]{
                "┌───────────────────────┐",
                "│ ┌───┐   ┌───┐   ┌───┐ │",
                "│ │ %s ├───┤ %s ├───┤ %s │ │",
                "│ └─┬─┘   └─┬─┘   └───┘ │",
                "│   │       |           │",
                "│   │     ┌─┴─┐   ┌───┐ │",
                "│   │     | %s ├───┤ %s │ │",
                "│   │     └─┬─┘   └─┬─┘ │",
                "│   │       |       │   │",
                "│   │     ┌─┴─┐     │   │",
                "│   │     | %s |     │   │",
                "│   │     └───┘     │   │",
                "│   │               │   │",
                "│ ┌─┴─┐           ┌─┴─┐ │",
                "│ | %s ├───────────┤ %s │ │",
                "│ └───┘           └───┘ │",
                "└───────────────────────┘",
        }));

        // Append list of available rooms
        for (RoomCode roomCode : RoomCode.values()) {
            map.append("\n").append("[").append(roomCode.getNumber()).append("]").append(" ").append(
                    game.getMap().getRoom(roomCode).getName()
            );
        }

        return String.format(map.toString(),
                numbers[RoomCode.ROOM_4.getNumber()],
                numbers[RoomCode.ROOM_1.getNumber()],
                numbers[RoomCode.ROOM_0.getNumber()],
                numbers[RoomCode.ROOM_2.getNumber()],
                numbers[RoomCode.ROOM_7.getNumber()],
                numbers[RoomCode.ROOM_3.getNumber()],
                numbers[RoomCode.ROOM_5.getNumber()],
                numbers[RoomCode.ROOM_6.getNumber()]
                );
    }

}
