import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Event_form_fill_up extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1,logout,Refresh;
    JComboBox<String> jc;
    String[] ar;
    ArrayList<String>a;
    //JPasswordField p1, p2;
    public Event_form_fill_up() throws ClassNotFoundException, SQLException {
        setVisible(true);

        setSize(700, 700);
        setLayout(null);
        JFrame jFrame=new JFrame();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        l1 = new JLabel("Event modification");
        l1.setForeground(Color.blue);
        l1.setBackground(Color.cyan);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Add  Event ");
        l3 = new JLabel("Delete  Event ");
        logout=new JButton("logout");
        logout.setForeground(Color.blue);
        Refresh=new JButton("Refresh");
        tf1 = new JTextField();
       // tf2 = new JTextField();
        btn1 = new JButton("OK");
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
            a=new ArrayList<String>(Arrays.asList(ar));
            jc= new JComboBox<String>(ar);

        }catch (Exception e)
        {
            System.out.println(e);
        }
        l1.setBounds(300, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        btn1.setBounds(300, 150, 100, 30);
        logout.setBounds(500, 220, 90, 17);
        Refresh.setBounds(500,35, 90, 17);
        jc.setBounds(300, 110, 200, 30);
        add(jc);
       // jc=new JComboBox<String>();
        add(jc);
        add(l1);
        add(l2);
        add(l3);
        add(tf1);
        add(Refresh);
       // add(tf2);
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
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  jFrame.revalidate();
               tf1.setText("");
           revalidate();
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {

       if (e.getSource() == btn1) {

           String item= (String) jc.getSelectedItem();

           try {
               tf1.revalidate();
               Class.forName("oracle.jdbc.driver.OracleDriver");
               Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

               if(tf1.getText().isEmpty()) {
                   PreparedStatement ps2 = con.prepareStatement("DELETE from Event where Event_Name=?");
                   ps2.setString(1, item);
                   ResultSet r1 = ps2.executeQuery();
                   int x = 0;
                   x++;
                   if (x > 0) {
                       JOptionPane.showMessageDialog(btn1, "Data Deleted Successfully");
                   } else {
                       JOptionPane.showMessageDialog(btn1, "Data Not Saved");
                   }
                
               }

                else{

                   int x = 0;
                   String Even = tf1.getText();
           // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
                   PreparedStatement ps = con.prepareStatement("insert  into Event(Event_Name) values(?)");
            PreparedStatement ps2 = con.prepareStatement("Select Event_name from Event");
                   ps.setString(1, Even);
                   ResultSet rs = ps.executeQuery();




               x++;
                   if (x > 0) {
                       JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                   }
                    btn1.revalidate();
                   btn1.repaint();

               }
       }catch (ClassNotFoundException classNotFoundException) {
               classNotFoundException.printStackTrace();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
           }


            }




    public static void main(String[] arr) throws SQLException, ClassNotFoundException {
  new Event_form_fill_up();


    }
}