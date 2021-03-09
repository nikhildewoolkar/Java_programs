import java.io.*;
 import java.io.FileWriter;
import java.io.IOException; 

 public class filehand1
 {
     public static void main(String args[]) throws IOException
     {  FileWriter fw = new FileWriter("file.txt");
         String s;
         Scanner input = new Scanner(System.in);
    System.out.println("enter string()q to exit..");
    do{
        System.out.println("enter string()q to exit..");
    s=input.nextInt();
    fw.write(s);
    }
    while(s=="Q" || s=="q" );
    fw.flush();
    fw.close();
    System.out.println("done...");
  }