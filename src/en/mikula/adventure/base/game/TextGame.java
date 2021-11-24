package en.mikula.adventure.base.game;

import en.mikula.adventure.text.GameText;

public class TextGame extends Game {

    /**
     * Main method which handles the main
     * while loop
     */
    @Override
    public void start() {
        System.out.println(GameText.startingText());

        while (!hasEnded) {
            try {
                System.out.println(commandReader.readCommand());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println(GameText.endingText());
    }

    @Override
    public String getMode() {
        return Game.MODE_TEXT;
    }

}
