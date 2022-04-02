package Assignment2;

//...............................................................
//Assignment 2
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

import java.io.*;
import java.util.*;

public class SalesDatabase {
    static Sales[] salesArr = {};
    static int count = 0;
    static int salesArrayCount = 0;
    static int fileCount = 0;
    static String[] filesToProcess = {};
    static int fileToProcessCount = 0;
    static ArrayList<Sales> repeatedSales = new ArrayList<>();
    static ArrayList<Sales> uniqueSales = new ArrayList<>();
    static boolean repeatFound = false;
    static int binarySearchIterationCount = 0;
    static Sales[] uniqueSaleRecords = {};

    /**
     * The method performs sequential search on uniqueSaleRecords named array and find the data at given order_id of the sale.
     *
     * @param orderId is the order_id of the sale, of which data is being requested.
     */
    public static void sequentialSaleSearch(long orderId) {
        boolean flag = false;
        for (int i = 0; i < uniqueSaleRecords.length; i++) {
            if (orderId == uniqueSaleRecords[i].getOrderId()) {
                System.out.println();
                System.out.println("The order id requested is found at " + i + "th index of the array.");
                System.out.println();
                System.out.println("The record at that index is: ");
                System.out.println();
                System.out.println(uniqueSaleRecords[i]);
                System.out.println();
                System.out.println("It took " + i + " number of iterations to search the given order id.");
                System.out.println();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println();
            System.out.println("The order id, " + orderId + " is not in record. Please enter a valid Order id.");
            System.out.println();
        }
    }

    /**
     * The method helps binarySearchSale method to perform binary search on uniqueSaleRecords named array
     * and find the data at given order_id of the sale.
     *
     * @param orderId    is the order_id of the sale, of which data is being requested.
     * @param firstIndex is relatively first index.
     * @param lastIndex  is relatively last index.
     * @return index of the array at which the data is being found.
     */
    public static int binarySearch(long orderId, int firstIndex, int lastIndex) {
        binarySearchIterationCount++;
        if (firstIndex <= uniqueSaleRecords.length - 1 && lastIndex >= 1) {

            int median = (int) Math.floor(((float) (firstIndex + lastIndex)) / 2);
            if (orderId == uniqueSaleRecords[median].getOrderId()) {
                return median;
            } else if (orderId < uniqueSaleRecords[median].getOrderId()) {
                return binarySearch(orderId, firstIndex, median - 1);
            } else {
                return binarySearch(orderId, median + 1, lastIndex);
            }
        }
        return -1;
    }

    /**
     * The method performs binary search on uniqueSaleRecords with the help of binarySearch method and
     * find the data at given order_id of the sale.
     *
     * @param orderId is the order_id of the sale, of which data is being requested.
     */
    public static void binarySaleSearch(long orderId) {
        int firstIndex = 0;
        int lastIndex = uniqueSaleRecords.length - 1;
        int answer = binarySearch(orderId, firstIndex, lastIndex);
        if (answer != -1) {
            System.out.println();
            System.out.println("The order id requested is found at " + answer + "th index of the array.");
            System.out.println();
            System.out.println("The record at that index is: ");
            System.out.println();
            System.out.println(uniqueSaleRecords[answer]);
            System.out.println();
            System.out.println("It took " + binarySearchIterationCount + " number of iterations to search the given order id.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("The order id, " + orderId + " is not in the record. Please try to enter some valid key.");
            System.out.println();
        }
    }

    /**
     * This method displays the content of the file at a given input stream/path.
     *
     * @param filePath is the path of the file, which is to be read.
     */
    public static void displayFileContents(String filePath) throws InvalidFileException, EmptyFolderException {
        File displayContent = new File(filePath);
        if (displayContent.isDirectory()) {
            if (!(Objects.requireNonNull(displayContent.list()).length > 0)) {
                throw new EmptyFolderException(displayContent.getAbsolutePath() + " is the empty directory.");
            }
        }
        if (displayContent.exists()) {
            try (BufferedReader readFileContent = new BufferedReader(new FileReader(displayContent.getAbsolutePath()))) {
                String fileContent = "";
                while ((fileContent = readFileContent.readLine()) != null) {
                    System.out.println(fileContent);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new InvalidFileException(displayContent.getName() + " file does not exist.");
        }
    }

    /**
     * This method checks for duplicate data in the saleArr array. If any duplicate data is found then it is being store in repeatedData
     * arraylist whereas other unique data is stored in uniqueData.
     *
     * @param sale  is the object of Sale class.
     * @param index is the index of a particular data from saleArr array.
     * @throws DuplicateRecordFound if any same data found while reading the file.
     */
    public static void checkForDuplicate(Sales sale, int index) throws DuplicateRecordFound {
        for (int i = 0; i < salesArr.length; i++) {
            if (i != index && sale.equals(salesArr[i])) {
                repeatFound = true;
                if (!repeatedSales.contains(salesArr[i])) {
                    repeatedSales.add(salesArr[i]);
                } else {
                    throw new DuplicateRecordFound("The data " + salesArr[i].toString() + " is duplicate.");
                }
            }
        }
        if (!repeatFound) {
            uniqueSales.add(sale);
        }
        repeatFound = false;
    }

    /**
     * This method store the sale class object to salesArr array.
     *
     * @param sale is the sales class object.
     */
    public static void addRecords(Sales sale) {
        salesArr[count] = sale;
    }

    /**
     * This method stores attributes value as a Sale class object into saleArr array.
     *
     * @param line is the data to be stored which is obtained while reading the file.
     */
    public static void storingLinesToObject(String[] line) {
        Sales sale = new Sales();
        for (int i = 0; i < line.length; i++) {
            sale.setCountry(line[0]);
            sale.setItemType(line[1]);
            sale.setOrderPriority(line[2].charAt(0));
            sale.setOrderDate(new Date(line[3]));
            sale.setOrderId(Long.parseLong(line[4]));
            sale.setShipDate(new Date(line[5]));
            sale.setUnitsSold(Integer.parseInt(line[6]));
            sale.setUnitPrice(Float.parseFloat(line[7]));
            sale.setUnitCost(Float.parseFloat(line[8]));
            sale.setTotalProfit(Double.parseDouble(line[9]));
        }
        //This method is for adding sale object to salesArr array.
        addRecords(sale);
    }

    /**
     * This method is used to get the number of files in Data directory.
     *
     * @param file is the file object.
     * @return fileCount - number of files in Data directory.
     */
    public static int exploreFiles(File file) {
        for (File files : Objects.requireNonNull(file.listFiles())) {
            if (files.isDirectory()) {
                exploreFiles(files);
            } else {
                if (files.isFile()) {
                    fileCount++;
                }
            }
        }
        return fileCount;
    }

    /**
     * This method is used to write the directory and files of the Data directory into the log.txt file.
     *
     * @param desiredPath  is the path where the log.txt file is located.
     * @param logFileWrite is the printWriter object used to write into the file.
     */
    public static void listFiles(File desiredPath, PrintWriter logFileWrite) throws EmptyFolderException, InvalidFileException {
        //System.out.println(Arrays.toString(desiredPath.listFiles()));
        for (File files : Objects.requireNonNull(desiredPath.listFiles())) {
            if (files.isDirectory()) {
                File[] temp = files.listFiles();
                if (temp != null && temp.length == 0) {
                    throw new EmptyFolderException(files.getAbsolutePath() + " is an empty folder.");
                }
                logFileWrite.println("directory:" + files.getAbsolutePath());
                listFiles(files, logFileWrite);
            } else {
                if (files.isFile() && files.exists()) {
                    logFileWrite.println("\tfile:" + files.getAbsolutePath());
                } else {
                    throw new InvalidFileException(files.getName() + " does not exist.");
                }
            }
        }
    }

    /**
     * This method helps to list all path in the log.txt file and it calls listFiles method which write the content to the log.txt file.
     *
     * @param path    is the path of the directory, of whom the files and directories are to be logged.
     * @param logFile is the file in which the files and directories of path to be written in.
     */
    public static void listAllAtPathAndSave(String path, File logFile) {
        File desiredPath = new File(path);

        //System.out.println(desiredPath.getAbsolutePath());
        try (PrintWriter logFileWrite = new PrintWriter(new BufferedWriter(new FileWriter(logFile.getAbsolutePath())))) {
            if (desiredPath.isDirectory()) {
                //Creating Print Writer object to write object to the file.
                listFiles(desiredPath, logFileWrite);
            } else {
                throw new InvalidFileException(desiredPath.getName() + " does not exist.");
            }
        } catch (InvalidFileException | EmptyFolderException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to assignment 2 - part 2.");
        int caseNumber;
        do {
            System.out.println("What do you want to do?");
            System.out.println("\t" + "Case 1: List Files.");
            System.out.println("\t" + "Case 2: Process Files.");
            System.out.println("\t" + "Case 3: EXIT.");

            caseNumber = scanner.nextInt();
            scanner.nextLine();
            String logFilePath = "log/log.txt";
            //String logFilePath1 = "/Users/rutwikpatel/eclipse-workspace/COMP6481_Assignment2/log1.txt";
            switch (caseNumber) {
                case 1 -> {
                    //Creating file class object
                    File logFile = new File(logFilePath);
                    System.out.println("File Created: " + logFile.getName());

                    //Taking file that need to be written in the log.txt file.
                    System.out.println("Enter the path of which you want to list files: ");
                    String path = scanner.nextLine();
                    System.out.println("--------------writing to the log.txt file--------------");
                    System.out.println();
                    listAllAtPathAndSave(path, logFile);
                    System.out.println("All the directories and file of " + path + " directory has been logged into log.txt file.");
                    System.out.println();
                }
                case 2 -> {
                    File logFile = new File(logFilePath);
                    try {
                        //Checking if file exist. If it doesn't exist then InvalidFileException is raised.
                        if (logFile.exists()) {
                            String pathToExplore = "/Users/rutwikpatel/eclipse-workspace/COMP6481_Assignment2/data";

                            //To get the number of files in the Data directory.
                            File fileToExplore = new File(pathToExplore);
                            int fileCount = exploreFiles(fileToExplore);
                            filesToProcess = new String[fileCount];

                            //Retrieving file paths from log.txt file and then storing it in an array to process it in the future.
                            try (Scanner inputStream = new Scanner(new FileInputStream(logFile.getAbsolutePath()))) {
                                while (inputStream.hasNextLine()) {
                                    String current = inputStream.nextLine();
                                    //Checking if the directory mentioned in log.txt file is empty or not.
                                    if (current.contains("directory:")) {
                                        File dir = new File(current.substring(10));
                                        if (dir.isDirectory()) {
                                            String[] directories = dir.list();
                                            try {
                                                if (Objects.requireNonNull(directories).length > 0) {
                                                } else {
                                                    throw new EmptyFolderException(dir.getAbsolutePath() + " is the empty folder.");
                                                }
                                            } catch (EmptyFolderException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                    }
                                    if (current.contains("file:")) {
                                        File f = new File(current.substring(6));
                                        try {
                                            if (f.exists()) {
                                                filesToProcess[fileToProcessCount] = current.substring(6);
                                                fileToProcessCount++;
                                            } else {
                                                throw new InvalidFileException(f.getName() + " file does not exist.");
                                            }
                                        } catch (InvalidFileException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            //Reading files content to get the number of data/lines from it.
                            for (int i = 0; i < filesToProcess.length; i++) {
                                if (filesToProcess[i] != null) {
                                    File currentFile = new File(filesToProcess[i]);
                                    try {
                                        if (currentFile.exists() && currentFile.isFile()) {
                                            try (Scanner readFiles = new Scanner(new FileInputStream(currentFile.getAbsolutePath()))) {
                                                //To know the number of total lines in all files. Incrementing counter salesArrayCount.
                                                while (readFiles.hasNextLine()) {
                                                    String next = readFiles.nextLine();
                                                    salesArrayCount++;
                                                }
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            throw new InvalidFileException(currentFile.getName() + " does not exist at the specified location.");
                                        }
                                    } catch (InvalidFileException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }

                            System.out.println("-------Creating array name salesArr to store objects of Sales class.-------");
                            System.out.println();
                            //Assigning size to the salesArr which will store object of lines read.
                            salesArr = new Sales[salesArrayCount];

                            System.out.println("---------------Reading " + logFile.getName() + " file---------------");
                            System.out.println();
                            //Reading file content and then splitting it through "space" and then storing it in Sale class object.
                            for (String toProcess : filesToProcess) {
                                if (toProcess != null) {
                                    File currFile = new File(toProcess);
                                    try {
                                        if (currFile.exists() && currFile.isFile()) {
                                            try (Scanner readLines = new Scanner(new FileInputStream(currFile.getAbsolutePath()));) {
                                                while (readLines.hasNextLine()) {
                                                    String[] line;
                                                    line = readLines.nextLine().split("\t");
                                                    storingLinesToObject(line);
                                                    count++;
                                                }
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            throw new InvalidFileException(currFile.getName() + " does not exist at the specified location.");
                                        }
                                    } catch (InvalidFileException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }

                            System.out.println("Checking for duplicate values, if found any then it will be printed below:");
                            System.out.println();
                            //Checking for duplicates in the sale class object.
                            for (int i = 0; i < salesArr.length; i++) {
                                try {
                                    checkForDuplicate(salesArr[i], i);
                                } catch (DuplicateRecordFound e) {
                                    System.out.println(e.getMessage());
                                }
                            }


                            //Adding repeatedSales arraylist into uniqueSales arraylist.
                            uniqueSales.addAll(repeatedSales);

                            //Declaring an array to store uniqueSales arraylist data in the new array.
                            int len = 0;
                            uniqueSaleRecords = new Sales[uniqueSales.size()];

                            //Storing uniqueSales arraylist data to the array.
                            for (Sales sale : uniqueSales) {
                                uniqueSaleRecords[len] = sale;
                                len++;
                            }

                            System.out.println();
                            System.out.println("Please enter the path where we want to need to save output.txt file:");
                            String outputFilePath = scanner.nextLine();

                            //Creating PrintWriter object to write unique data in output.txt file.
                            File outputFile = new File(outputFilePath);
                            try (PrintWriter outputFileWriter = new PrintWriter(new FileWriter(outputFile.getAbsolutePath()))) {
                                //Getting order_id of all the Sale class object.
                                for (int i = 0; i < uniqueSaleRecords.length; i++) {
                                    //System.out.print(uniqueSaleRecords[i].getOrderId() + "\t");
                                    outputFileWriter.println(uniqueSaleRecords[i].toString());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            //Display file contents by reading it through BufferedFileReader.
                            System.out.println("Please enter the file name of whom you want to see content of: ");
                            String displayFile = scanner.nextLine();
                            System.out.println();
                            try {
                                displayFileContents(displayFile);
                            } catch (InvalidFileException | EmptyFolderException e) {
                                System.out.println(e.getMessage());
                            }

                            //Sorting salesArr array in ascending order as per its order_id attribute.
                            Arrays.sort(uniqueSaleRecords, (Sales o1, Sales o2) -> (int) (o1.getOrderId() - o2.getOrderId()));
                            System.out.println();

                            //Performing binary search on the data to get desired order_id.
                            System.out.println("Please enter order id of the product(Binary Search): ");
                            long orderId = scanner.nextLong();
                            System.out.println("------------------Binary Search------------------");
                            binarySaleSearch(orderId);

                            //Performing sequential search on the data to get desired order_id.
                            System.out.println("Please enter order id of the product(Sequential Search): ");
                            long order_id = scanner.nextLong();
                            System.out.println("------------------Sequential Search------------------");
                            sequentialSaleSearch(order_id);
                        } else {
                            throw new InvalidFileException(logFile.getName() + " is not found.");
                        }
                    } catch (InvalidFileException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Thank You for using our small application. We appreciate your time. Do visit again!!!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("The choice you entered is not a valid choice.");
            }
        } while (caseNumber >= 1);
    }
}
