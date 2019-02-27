package auto_package;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class FirstPage extends JFrame{
        
    JPanel jPanel, j_Panel, jPanel1, jPanel2;
    JLabel jPhoto;
    JButton jLoginButton, jSignupButton;
    
    Point locked=super.getLocation();
    
    public FirstPage(){
        
        jPanel = new JPanel();
        j_Panel = new JPanel(new BorderLayout(6, 5));
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        
        jPhoto = new JLabel();
        
        jLoginButton = new JButton("LOGIN");
        jSignupButton = new JButton("SIGNUP");
        
        jLoginButton.setBorder(new EmptyBorder(5, 80, 5, 90));
        jSignupButton.setBorder(new EmptyBorder(5, 90, 5, 80));
        
        jPanel1.add(jLoginButton);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel2.add(jSignupButton);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        
        jPhoto.setIcon(new ImageIcon(getClass().getResource("LoginImage.jpg")));
        
        jLoginButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });
        
        jSignupButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                CustomerDetails customerDetails = new CustomerDetails();
            }
        });
        
        j_Panel.add(jPanel1, BorderLayout.WEST);
        j_Panel.add(jPanel2, BorderLayout.EAST);
        j_Panel.setBorder(new EmptyBorder(15, 0, 0, 0));
        
        jPanel.add(jPhoto, BorderLayout.NORTH);
        jPanel.add(j_Panel, BorderLayout.CENTER);
        
        add(jPanel);
                       
        validate(); 
        
        super.addComponentListener(new ComponentAdapter(){
            public void componentMoved(ComponentEvent e) {
                if (locked!=null) 
                    FirstPage.this.setLocation(locked);
            }
        });
        
        setTitle("Introduction Page");
        setVisible(true);
        setSize(500, 570);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        /*try{
            
            String string = getClass().getResource("").toString(), newString = new String("");
                        
            for(int i = 6; i<string.length(); i++){
                if(string.charAt(i) == '2' || string.charAt(i) == '0')
                    continue;
                if((int)string.charAt(i) == 47){
                    char ch = (char)92;
                    newString += ch;
                    newString += ch;
                }
                else if(string.charAt(i) == '%')
                    newString += " ";
                else
                    newString += string.charAt(i);
            }
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+newString+"AutoDatabase.accdb");
            Statement st = con.createStatement();
            
            PreparedStatement ps = con.prepareStatement("insert into AutoDatabase(CustomerName,Address,MobileNo,CarName,CarPaint,HeadlightChange,Windshield,HornBattery,SideMirror,UserName,Password)values(?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, "yusuf");
            ps.setString(2, "yusuf");
            ps.setString(3, "yusuf");
            ps.setString(4, "yusuf");
            ps.setString(5, "yusuf");
            ps.setString(6, "yusuf");
            ps.setString(7, "yusuf");
            ps.setString(8, "yusuf");
            ps.setString(9, "yusuf");
            ps.setString(10, "yusuf");
            ps.setString(11, "yusuf");
            
            ps.executeUpdate();
            con.commit();
            
            ResultSet rs = st.executeQuery("select * from AutoDatabase");
            while(rs.next()){
                System.out.println(rs.getString("CustomerName"));
            }*/
            
            /*st.execute("create table AutoDatabase(CustomerName varchar(50), Address varchar(50), MobileNo varchar(50), CarName varchar(50), CarPaint varchar(50), HeadlightChange varchar(50), Windshield varchar(50), HornBattery varchar(50), SideMirror varchar(50), UserName varchar(50), Password varchar(50))");*/
            
        /*}
        catch(Exception e){
            e.printStackTrace();
        }*/
        
    }
    
    public static void main(String[] args){
        
        FirstPage firstPage = new FirstPage();
    }
}