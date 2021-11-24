package en.mikula.adventure.items.terminals.bridge;

import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class ShowLastDiaryEntryOption implements TerminalOption {

    private final Terminal terminal;

    public ShowLastDiaryEntryOption(Terminal terminal) {
        this.terminal = terminal;
    }

    public int getNumber() {
        return 1;
    }

    public String getText() {
        return "Show last diary entry";
    }

    public void handle() {
        terminal.getHandler().output(terminal, "18.02.2159 01:16 - The miners should be there in like an hour. There were supposed to be some ill miners as the shift leader stated that something jumped on their heads while working in the mine. At least they got it off their heads and they are on their way to Nostromo. But I am really worried about them because they were not responding for the last couple hours of the flight...");
        terminal.getHandler().output(terminal, "18.02.2159 03:16 - The ship just arrived, no one is responding. We'll go to check the ship out in the cargo space room. Ryan");
        terminal.getHandler().output(terminal, "18.02.2159 04:26 - We managed to open the ship. There were some terrible creatures inside and all the miners were dead. Autopilot navigated the ship safe to Nostromo not knowing what was inside. We locked them in the cargo space room and we will try to use escape modules quikcly. Our leading commander didn't make it. We left him in the cafeteria. As soon as we get into the escape module sector, we will block the entrance. May the God be with us.");
    }

}
