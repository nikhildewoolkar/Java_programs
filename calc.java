import java.util.Scanner;
import nickd.calculator;
class calc
{
    public static void main(String args[]) 
    {
    int s1,s2,ch;
    Scanner input = new Scanner(System.in);
    System.out.println("enter first element:- ");
    s1=input.nextInt();
    System.out.println("enter second element:- ");
    s2=input.nextInt();
    System.out.println("enter the choice (1:+,2:-,3:*,4:/):- ");
    ch=input.nextInt();
    calculator obj = new calculator();
    switch (ch) {
        case 1:
          obj.add(s1,s2);
          break;
        case 2:
        obj.sub(s1,s2);
          break;
        case 3:
          obj.multi(s1,s2);
          break;
        case 4:
          obj.div(s1,s2);
          break;
}
}
}