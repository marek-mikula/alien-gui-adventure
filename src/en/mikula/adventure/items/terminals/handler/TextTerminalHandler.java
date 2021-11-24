package en.mikula.adventure.items.terminals.handler;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.exceptions.TerminalInputException;
import en.mikula.adventure.text.AsciArt;
import en.mikula.adventure.utils.TerminalUtils;

public class TextTerminalHandler implements TerminalHandler {

    private final Game game;

    public TextTerminalHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(Terminal terminal) {
        // Set active indicator of current terminal to true
        terminal.setIsActive(true);

        // Show terminal starting screen
        System.out.println(AsciArt.companyLogoTerminalArt());

        while (terminal.isActive()) {
            // List all options to player before every input
            listOptions(terminal);

            try {
                terminal.handleInput(game.getInput().readLine());
            } catch (TerminalInputException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    @Override
    public void close(Terminal terminal) {
        terminal.setIsActive(false);
    }

    @Override
    public void output(Terminal terminal, String string) {
        System.out.println(string);
    }

    /**
     * Lists options of the given terminal
     */
    private void listOptions(Terminal terminal) {
        System.out.println("What do you wanna do?");

        terminal.getOptions().forEach((key, value) -> {
            if (!value.shouldList()) {
                return;
            }
            System.out.println(TerminalUtils.formatOptions(value));
        });
    }

}
