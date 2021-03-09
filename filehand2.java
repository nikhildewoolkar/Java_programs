import java.io.BufferedInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
class filehand2
{ 
    public static void main(String args[]) throws IOException 
    {  try{
        FileInputStream fin = new FileInputStream("try1.txt"); 
        BufferedInputStream bin = new BufferedInputStream(fin); 
        int ch; 
        String s="";
        while ((ch=bin.read()) != -1)
        {
            s+=(char)ch;
        }   
        for(int i=0;i < s.length();i++)
        {
        if(s.charAt(i) != 'a' && s.charAt(i)!= 'e' && s.charAt(i)!= 'i' && s.charAt(i)!= 'o' && s.charAt(i)!= 'u' && s.charAt(i) != 'a' && s.charAt(i)!= 'e' && s.charAt(i)!= 'i' && s.charAt(i)!= 'o' && s.charAt(i)!= 'u')
                { 
                    System.out.print(s.charAt(i));
                }
        }
    }
    catch(Exception e)
    {
        System.out.print("");
    } 
    } 
} 