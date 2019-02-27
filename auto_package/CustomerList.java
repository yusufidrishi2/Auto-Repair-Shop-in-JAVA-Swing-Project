package auto_package;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

public class CustomerList extends JFrame{
    
    JPanel jPanel;
    JLabel jBill;
    JButton jBackButton;
    JTable jTable;
    JScrollPane jScrollPane;
    
    String[][] data;
    String[]   columnNames;
    
    String yes;
    
    int tot;
    
    public CustomerList(){
        
        jBill = new JLabel("ADMIN VIEW");
        jBill.setFont(new Font("Serif", Font.BOLD, 35));
        
        data = new String[18][11];
        columnNames = new String[11];
        
        try{
                    
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
            ResultSet rs = st.executeQuery("select * from AutoDatabase");
            boolean flag = false;
            int i = 0;
            while(rs.next()){
                data[i][0] = rs.getString("CustomerName");
                data[i][1] = rs.getString("Address");
                data[i][2] = rs.getString("MobileNo");
                data[i][3] = rs.getString("CarName");
                data[i][4] = rs.getString("CarPaint");
                data[i][5] = rs.getString("HeadlightChange");
                data[i][6] = rs.getString("Windshield");
                data[i][7] = rs.getString("HornBattery");
                data[i][8] = rs.getString("SideMirror");
                data[i][9] = rs.getString("UserName");
                data[i][10] = rs.getString("Password");
                i++;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        columnNames[0] = "CUSTOMER NAME";
        columnNames[1] = "ADDRESS";
        columnNames[2] = "MOBILE NO";
        columnNames[3] = "CAR NAME";
        columnNames[4] = "CAR PAINT";
        columnNames[5] = "HEADLIGHT";
        columnNames[6] = "WINDSHIELD";
        columnNames[7] = "HORN BATTERY";
        columnNames[8] = "SIDE MIRROR";
        columnNames[9] = "USERNAME";
        columnNames[10] = "PASSWORD";
        
        jTable = new JTable(data, columnNames); 
        //jTable.setBounds(300, 1000, 300, 300);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(97);
        jTable.getColumnModel().getColumn(8).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(9).setPreferredWidth(87);
        jTable.getColumnModel().getColumn(10).setPreferredWidth(87);
        
        for(int i = 0; i<18; i++)
            jTable.setRowHeight(i, 20);
        
  
        // adding it to JScrollPane 
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        //JScrollBar bar = jScrollPane.getVerticalScrollBar();
        jScrollPane.setPreferredSize(new Dimension(998, 384));
        
        jPanel = new JPanel();
        
        jBackButton = new JButton("Logout");
        
        jBackButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });
        
        jPanel.add(jBill, BorderLayout.SOUTH);
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        jPanel.add(jBackButton, BorderLayout.NORTH);
        
        add(jPanel); 
        
        setTitle  ("Admin View");
        setVisible(true);
        setSize   (1010, 510);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}