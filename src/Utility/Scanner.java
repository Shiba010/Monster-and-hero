package Utility;

public class Scanner { // this is used to scan input
    java.util.Scanner scan = new java.util.Scanner(System.in);

    public String ScanString(){
        String input = scan.next();
        scan.nextLine();
        return input;
    }
    public void close(){
        scan.close();
    }

}
