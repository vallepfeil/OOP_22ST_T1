package alphametic;

public class ParseException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = 2703218443322787634L;

    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public ParseException(String s, int errorOffset) {
        super(s); this.errorOffset = errorOffset;
    }

    /**
     * Returns the position where the error was found.
     *
     * @return the position where the error was found
     */
    public int getErrorOffset() {
        return errorOffset;
    }

    //============ privates ============
    /**
     * The zero-based character offset into the string being parsed at which
     * the error was found during parsing.
     *
     * @serial
     */
    private final int errorOffset;
}