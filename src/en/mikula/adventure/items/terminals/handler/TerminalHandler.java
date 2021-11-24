package en.mikula.adventure.items.terminals.handler;

import en.mikula.adventure.items.terminals.Terminal;

public interface TerminalHandler {

    /**
     * Methods which handles the interaction
     * between player and summoned terminal
     *
     * @param terminal to be handled
     */
    public void handle(Terminal terminal);

    /**
     * Method which closes the terminal
     */
    public void close(Terminal terminal);

    /**
     * Outputs string into the terminal
     *
     * @param string   to be output
     */
    public void output(Terminal terminal, String string);

}
