import java.util.Scanner;

class toWrapperObj{
    // toWrapperObj(int i){
    // Integer f=new Integer(i);
    // Double f1=new Integer(i);
    // System.out.println(f);
    // System.out.println(f1);
    // }
    toWrapperObj(char ch){
    Character f=new Character(ch);

    Integer f1=Character.getNumericValue(f);

    System.out.println(f);
    System.out.println(f1);
    }   
}
public class factorynick
{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    int z=sc.nextInt();
	    char q=sc.next().charAt(0);
	    // new toWrapperObj(z);
	    new toWrapperObj(q);
	}
}