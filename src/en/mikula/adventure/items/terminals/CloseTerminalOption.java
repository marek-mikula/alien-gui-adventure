package en.mikula.adventure.items.terminals;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class CloseTerminalOption implements TerminalOption {

    private final Terminal terminal;

    public CloseTerminalOption(Terminal terminal) {
        this.terminal = terminal;
    }

    public int getNumber() {
        return 0;
    }

    public String getText() {
        return "Close terminal";
    }

    public void handle() {
        terminal.getHandler().close(terminal);
    }

}
