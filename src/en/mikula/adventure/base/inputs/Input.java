package en.mikula.adventure.base.inputs;

/**
 * Base interface for reading the input
 *
 * @author Marek Mikula
 * @version 4/20/2021
 */
public interface Input {

    /**
     * Reads one line from input implementation
     *
     * @return the read line as string
     */
    public String readLine();

}
