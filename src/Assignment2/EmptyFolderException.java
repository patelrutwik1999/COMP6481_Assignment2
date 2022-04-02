package Assignment2;

//...............................................................
//Assignment 2
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

/**
 * EmptyFolderException class checks for the directories which are empty. That means the number of files in the directory is zero. If
 * such a scenario is encountered then EmptyFolderException is being raised.
 */
public class EmptyFolderException extends Exception {
    /**
     * Default constructor of EmptyFolderException class.
     */
    public EmptyFolderException() {
        super("Error: Input file named XXX cannot be found");
    }

    /**
     * Parametrized constructor of EmptyFolderException class.
     *
     * @param p_message this is message given where the exception is being created.
     */
    public EmptyFolderException(String p_message) {
        super(p_message);
    }
}
