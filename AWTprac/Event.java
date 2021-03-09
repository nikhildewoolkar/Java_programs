import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Event extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JButton btn1,logout;
    JComboBox jc;
    String []ar;
    Event(){
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Event Panel");

        l1 = new JLabel("View Event");
        l1.setForeground(Color.blue);
        l1.setBackground(Color.cyan);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Select Event ");
        tf1 = new JTextField();
        btn1 = new JButton("OK");
        logout=new JButton("logout");
        logout.setForeground(Color.blue);
        btn1.addActionListener(this);
        for (JButton jButton : Arrays.asList(btn1)) {
            jButton.addActionListener(this);
        }
       int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("dbc:mysql://localhost:3306/mydb", "root", "123456");
            PreparedStatement ps2 = con.prepareStatement("Select Event_name from Event");
            ResultSet r1 = ps2.executeQuery();
            ar =new String[20];
            while (r1.next()) {
                String c = r1.getString("Event_Name");
                ar[i]=c;
                i++;
            }
            //a=new ArrayList<String>(Arrays.asList(ar));
            jc= new JComboBox<String>(ar);

        }catch (Exception e)
        {
            System.out.println(e);
        }

        l1.setBounds(300, 30, 400, 30);
        l2.setBounds(150, 70, 200, 30);
        jc.setBounds(300, 70, 200, 30);
        btn1.setBounds(300, 120, 100, 30);
        logout.setBounds(450,180,100,17);
        add(l1);
        add(l2);
        add(jc);
        add(btn1);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login ll=new Login();
                ll.setVisible(true);
                setVisible(false);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {


       }
        public static void main (String arr[])
        {
            Event e=new Event();


        }


    }