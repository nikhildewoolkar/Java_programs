import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
class filehand {
    public static void main(String args[]) {
        try (FileReader fr = new FileReader("try.txt");
             FileWriter fw = new FileWriter("second.txt")) {
            int c = fr.read();
            while(c!=-1) {
                fw.write(c);
                c = fr.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}