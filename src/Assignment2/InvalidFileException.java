package Assignment2;

//...............................................................
//Assignment 2
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

/**
 * InvalidFileException class checks for the files, if they exist at the given location or not. If not then this class raise the
 * exception.
 */
public class InvalidFileException extends Exception {
    /**
     * Default constructor of InvalidFileException class.
     */
    public InvalidFileException() {
        super("Error: Input file named XXX cannot be found");
    }

    /**
     * Parametrized constructor of InvalidFileException class.
     *
     * @param message this is message given where the exception is being created.
     */
    public InvalidFileException(String message) {
        super(message);
    }
}
