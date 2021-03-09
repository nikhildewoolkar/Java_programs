package Practical_first;

public class AddAmount {
 
    int amount,final_amount;
    AddAmount()
    {
        amount = 50;
    }
    AddAmount(AddAmount s1,int add_amount)
    {
        amount = s1.amount + add_amount;   
    }
    void display()
    {
        System.out.println("The amount in piggie bank is $" +amount);
    }
    public static void main(String[] args) 
    {
        AddAmount A = new AddAmount();
        AddAmount B = new AddAmount(A,20);
        A.display();
        B.display();
    }
}