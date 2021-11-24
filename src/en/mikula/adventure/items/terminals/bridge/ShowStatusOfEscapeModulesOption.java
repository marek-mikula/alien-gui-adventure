package en.mikula.adventure.items.terminals.bridge;

import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class ShowStatusOfEscapeModulesOption implements TerminalOption {

    private final Terminal terminal;

    public ShowStatusOfEscapeModulesOption(Terminal terminal) {
        this.terminal = terminal;
    }

    public int getNumber() {
        return 2;
    }

    public String getText() {
        return "Show status of escape modules";
    }

    public void handle() {
        terminal.getHandler().output(terminal, "Number of escape modules used: 11");
        terminal.getHandler().output(terminal, "Number of escape modules left: 1");
    }

}
