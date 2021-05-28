
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.io.*;

public class Decomment {

    public static void decommenter(ArrayList<String> content, String lang) {
        String line;
        char b;
        //loop through arraylist
        for(int i = 0; i< content.size(); i++) {
            //get string from arraylist
            line = content.get(i);
            char firstChar = line.charAt(0);
            switch(firstChar) {
                case '/':
                    if (line.charAt(1) == '/' || lang != "py") {
                        content.remove(i)
                    }
                    break;
                case '#':
                    if (lang == "py") {
                        content.remove(i);Quinneke

                    }
            }
            for(int a = 0; i<line.length(); a++) {
                b = line.charAt(a);
                switch(b) {
                    case '/':
                        //check if the next character is also forward slash
                        if(line.charAt(a+1) == '/' && lang != "py") {
                            content.remove(i);
                        }
                        break;
                    case '#':
                        if (lang == "py") {
                            content.remove(i);
                        }
                        break;
                }
            }
        }

    }
    //determine language of file
    public static String determineLang(String filename) {
        // split filename into after dot and before dot
        String[] parts;
        parts = filename.split("\\.");
        // String[2] parts = filename.split("\.");
        return parts[1];
    }

    public static void writeFile(ArrayList<String> toWrite, File toDelete) {
        // save new file name
        String newFileName = toDelete.getName();
        String newFilePath = toDelete.getAbsolutePath();

        //File newFile = null;
        try {
            File newFile = new File("test1.c");
            newFile.createNewFile();
            FileWriter writeNewFile = new FileWriter(newFile);
            for(int i = 0; i < toWrite.size(); i++) {
                writeNewFile.write(toWrite.get(i));
            }
            //newFile.renameTo(new File(newFilePath));
        } catch (IOException exception){
            System.out.println("Something unexpected happened");
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //file contents are stored in here
        ArrayList<String> fileContent = new ArrayList<String>();
        //int i = 0;
        File file = null;
        try {
            file = new File("test.c");
            Scanner inFile = new Scanner(file);
            while(inFile.hasNext()) {
                // write file contents to array list
                fileContent.add(inFile.nextLine());
                //i++;
            }
        } catch(Exception ex) {
            System.out.println("fatal error" + ex);
            ex.printStackTrace();
        }
        String fileLang = determineLang(file.getName());
        decommenter(fileContent, fileLang);
        writeFile(fileContent, file);
    }




}
