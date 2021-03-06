package com.company.Project_awt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.StringTokenizer;
public class Login extends JFrame implements ActionListener
{
    JLabel l1, l2, l3,New_User;
    JTextField tf1;
    JButton btn1,Click_here;
    JPasswordField p1;

  Login()
    {

        setTitle("Login Form ");
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Login :");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        New_User=new JLabel("New User?");


        l2 = new JLabel("Enter Email:");
        l3 = new JLabel("Enter Password:");
        tf1 = new JTextField();

        p1 = new JPasswordField();
        btn1 = new JButton("Submit");
        Click_here=new JButton("Click here");
        Click_here.setForeground(Color.blue);
        New_User.setBounds(280, 190, 100, 30);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160,100 , 30);
        Click_here.setBounds(350,195,100,17);
        add(Click_here);
        add(New_User);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        btn1.addActionListener(this);
        Click_here.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration r=new Registration();
                r.setVisible(true);
                setVisible(false);


            }
        });
    }

    public void actionPerformed(ActionEvent ev) {
        showData();
    }

    public void showData()
    {

        JLabel l, l0;


        String str1 = tf1.getText();
        char[] p = p1.getPassword();
        String str2 = new String(p);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("dbc:mysql://localhost:3306/mydb", "root", "123456");
            PreparedStatement ps = con.prepareStatement("select name from STUDENT where E_Mail=? and pass=?");
            ps.setString(1, str1);
            ps.setString(2, str2);

            ResultSet rs = ps.executeQuery();

            if ("admin@gmail.com".equalsIgnoreCase(tf1.getText()) && "admin".equalsIgnoreCase(p1.getText())) {


                Event_form_fill_up ev = new Event_form_fill_up();
                ev.setVisible(true);
                ev.setSize(600, 600);
                ev.setLayout(null);
                l = new JLabel();
                l.setBounds(60, 50, 400, 30);
                ev.add(l);
                setVisible(false);

            } else if (rs.next()) {
               Event e = new Event();
                e.setVisible(true);
                e.setSize(600, 600);
                e.setLayout(null);
                l = new JLabel();
                l.setBounds(60, 50, 400, 30);
                e.add(l);
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null,
                        "Incorrect email-Id or password..Try Again with correct detail");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static void main(String arr[])
    {
        new Login();

    }
}