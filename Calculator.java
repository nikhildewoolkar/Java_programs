import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ItemListener,ActionListener
{   String s1,s2,s3;
    int num1,num2,ans;
    Frame f;
    Panel panel;
    Label l1,l2,l3;
    TextField t1,t2,t3;
    Button b1,b2;
    Choice c;
    public Calculator()
    {   
        super("Calculator");
        f=new Frame("nikhil");
        panel=new Panel();
        f.add(panel);
        l1=new Label("Enter the number 1:- ");
        l2=new Label("Enter the number 2:- ");
        l2=new Label("Your Answer is:- ");
        t1=new TextField(20);
        t2=new TextField(20);
        t3=new TextField(20);
        b1=new Button("ENTER");
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.addActionListener(this);
        c=new Choice();
        c.add("+");
        c.add("-");
        c.add("*");
        c.add("/");
        c.addItemListener(this);
        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(c);
        panel.add(l3);
        panel.add(t3);
        panel.add(b1);
        panel.add(b2);
        f.setSize(400,400);
        f.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)
    {
        Object obj=e.getSource();
        if(obj==c)
        {
            String opr=c.getSelectedItem();
            s1=t1.getText();
            s2=t1.getText();
            num1=Integer.parseInt(s1);
            num2=Integer.parseInt(s2);
            ans=0;
            if(opr=="+")
            {
                ans=num1+num2;
            }
            if(opr=="-")
            {
                ans=num1-num2;
            }
            if(opr=="*")
            {
                ans=num1*num2;
            }
            if(opr=="/")
            {
                ans=num1/num2;
            }
            s3=Integer.toString(ans);
            t3.setText(s3);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        Object obj=e.getSource();
        if(obj==b1)
        {
            t3.setText(s3);
        }
        if(obj==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
    public static void main(String args[])
    {
        Calculator obj=new Calculator();
    }
}