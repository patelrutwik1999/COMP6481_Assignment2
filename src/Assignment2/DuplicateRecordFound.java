package Assignment2;

//...............................................................
//Assignment 2
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

/**
 * DuplicateRecordFound class to raise the exception if any duplicate data is found from the file listed in log.txt while processing them.
 */
public class DuplicateRecordFound extends Exception {
    /**
     * Default constructor of DuplicateRecordFound class.
     */
    public DuplicateRecordFound() {
        super("ALERT!!!Duplicate Data Found.");
    }

    /**
     * Parametrized constructor of DuplicateRecordFound class.
     *
     * @param p_message this is message given where the exception is being created.
     */
    public DuplicateRecordFound(String p_message) {
        super(p_message);
    }
}
