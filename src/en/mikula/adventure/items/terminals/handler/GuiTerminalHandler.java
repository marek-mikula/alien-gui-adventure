package en.mikula.adventure.items.terminals.handler;

import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.gui.terminal.TerminalGui;
import en.mikula.adventure.items.terminals.Terminal;

public class GuiTerminalHandler implements TerminalHandler {

    private final GuiGame game;

    private TerminalGui terminalGui;

    public GuiTerminalHandler(GuiGame game) {
        this.game = game;
    }

    @Override
    public void handle(Terminal terminal) {
        terminalGui = new TerminalGui(game, terminal);

        terminal.registerObserver(terminalGui.getTerminalOptionList());
        terminalGui.getInput().registerObserver(terminalGui);

        terminalGui.start();
    }

    @Override
    public void close(Terminal terminal) {
        terminal.unregisterObserver(terminalGui.getTerminalOptionList());
        terminalGui.getInput().unregisterObserver(terminalGui);

        terminalGui.getStage().hide();
    }

    @Override
    public void output(Terminal terminal, String string) {
        terminalGui.getOutput().write(string);
    }

}
