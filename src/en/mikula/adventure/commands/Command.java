package en.mikula.adventure.commands;

/**
 * Base interface for all commands
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public interface Command {

    /**
     * Gets the command signature
     *
     * @return String
     */
    public String signature();

    /**
     * Gets the command full signature
     * with arguments that user can supply
     *
     * @return String
     */
    public String fullSignature();

    /**
     * Gets the help text for a command
     *
     * @return help message
     */
    public String help();

    /**
     * Method which specifies how the command works
     *
     * @param args array of params which user entered
     * @return output of the command
     */
    public String run(String... args);

}
