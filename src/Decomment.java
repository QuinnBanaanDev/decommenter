
import java.util.*;
import java.io.*;

public class Decomment {
    public static void main(String args[]) {
        // String fileName = StringEscapeUtils.unescapeJava("C:\Users\h_del\Desktop\test.txt");
        try {
            File file = new File("test.txt");
            Scanner inFile = new Scanner(file);
            while(inFile.hasNext()) {
                System.out.println(inFile.nextLine());
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }



}
