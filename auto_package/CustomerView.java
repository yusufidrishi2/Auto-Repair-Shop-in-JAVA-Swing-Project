package auto_package;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

public class CustomerView extends JFrame{
    
    JPanel jBackPanel, jPanel, jPanelMain, jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
    JPanel jBottomPanel, jPanel6, jPanel7, jPanelLine, jPanel8, jPanel9, jPanel10, jPanel11, jPanel12, jPanel13;
    JPanel jPanele1, jPanele2, jPanele3, jPanele4, jPanele6;
    JPanel jPanele7, jPanele8, jPanele9, jPanele10, jPanele11, jPanele12, jPanele13;
    JLabel jLine, jService, jCost, jBill, jCustomerName, jAddress, jMobileNo, jCarName, jDefect, jTotal; 
    JLabel jCarPaint, jHeadlightChange, jWindshield, jHornBattery, jSideMirror, j3000, j2000, j5000, j1000, j1500;
    JLabel jGetCusName, jGetAddress, jGetMobileNo, jGetCarName, jGetTotal;
    JButton jBackButton, jUpdateButton;
    
    String yes, temp;
    
    int tot;
    
    public CustomerView(String userName){
        
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
        while(rs.next()){
            if(rs.getString("UserName").equals(userName)){
                flag = true;
                break;
            }
        }
        
        jBill = new JLabel("WELCOME "+rs.getString("CustomerName").toUpperCase());
        jBill.setFont(new Font("Serif", Font.BOLD, 20));
        
        jCustomerName    = new JLabel("USERNAME: ");
        jAddress         = new JLabel("ADDRESS: ");
        jMobileNo        = new JLabel("MOBILE NO.: ");
        jCarName         = new JLabel("CAR NAME: ");
        jDefect          = new JLabel("DEFECTS: ");
        
        jService         = new JLabel("SERVICE");
        jCost            = new JLabel("COST");
        
        jService.setFont(new Font("Serif", Font.BOLD, 15));
        jCost.setFont(new Font("Serif", Font.BOLD, 15));
        
        jCarPaint        = new JLabel("Car Paint: ");
        jHeadlightChange = new JLabel("Headlight: "); 
        jWindshield      = new JLabel("Windshield: ");
        jHornBattery      = new JLabel("Horn Battery: "); 
        jSideMirror      = new JLabel("Side Mirror: ");
        
        j3000 = new JLabel("3000.00");
        j2000 = new JLabel("2000.00"); 
        j5000 = new JLabel("5000.00"); 
        j1000 = new JLabel("1000.00"); 
        j1500 = new JLabel("1500.00");
        
        jLine            = new JLabel("_________________________");
        jTotal           = new JLabel("Total Cost: ");
        
        jPanel     = new JPanel(); 
        jPanelMain = new JPanel();
        jPanel1    = new JPanel(); 
        jPanel2    = new JPanel();
        jPanel3    = new JPanel();
        jPanel4    = new JPanel();
        jPanel5    = new JPanel(new BorderLayout(2, 5)); 
        jPanel6    = new JPanel();
        jPanel7    = new JPanel();
        jPanel8    = new JPanel();
        jPanel9    = new JPanel();
        jPanel10   = new JPanel();
        jPanel11   = new JPanel();
        jPanel12   = new JPanel();
        jPanel13   = new JPanel();
        jPanelLine = new JPanel(new BorderLayout(2, 5));
        
        jBottomPanel = new JPanel(new BorderLayout(2, 5)); 
        jBackPanel   = new JPanel(); 
            
        jPanele1    = new JPanel(new BorderLayout(2, 5)); 
        jPanele2    = new JPanel(new BorderLayout(2, 5));
        jPanele3    = new JPanel(new BorderLayout(2, 5));
        jPanele4    = new JPanel(new BorderLayout(2, 5));
        jPanele6    = new JPanel(new BorderLayout(2, 5));
        jPanele7    = new JPanel(new BorderLayout(2, 5));
        jPanele8    = new JPanel(new BorderLayout(2, 5));
        jPanele9    = new JPanel(new BorderLayout(2, 5));
        jPanele10   = new JPanel(new BorderLayout(2, 5));
        jPanele11   = new JPanel(new BorderLayout(2, 5));
        jPanele12   = new JPanel(new BorderLayout(2, 5));
        jPanele13   = new JPanel(new BorderLayout(2, 5));
        
        jUpdateButton = new JButton("Update");
        jBackButton = new JButton("Logout");
            
        temp = new String(rs.getString("UserName"));
        
        jUpdateButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                UpdateCustomer updateCustomer = new UpdateCustomer(temp);
            }
        });    
            
        jBackButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });
            
        jBackPanel.add(jUpdateButton);
        jBackPanel.setBorder(new EmptyBorder(20, 0, 30, 0));
        
        jBottomPanel.add(jBackPanel, BorderLayout.NORTH);    
        jBottomPanel.add(jBackButton, BorderLayout.SOUTH);
        jBottomPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        
        yes = new String("Yes");
        
        jGetCusName      = new JLabel(rs.getString("UserName"));
        jGetAddress      = new JLabel(rs.getString("Address"));
        jGetMobileNo     = new JLabel(rs.getString("MobileNo"));
        jGetCarName      = new JLabel(rs.getString("CarName"));
        
        jCustomerName.setBorder(new EmptyBorder(0, 0, 0, 38));
        jAddress.setBorder(new EmptyBorder(0, 0, 0, 45));
        jMobileNo.setBorder(new EmptyBorder(0, 0, 0, 33));
        jCarName.setBorder(new EmptyBorder(0, 0, 0, 41));
        jService.setBorder(new EmptyBorder(0, 0, 0, 52));  
            
        jCarPaint.setBorder(new EmptyBorder(0, 0, 0, 60));
        jHeadlightChange.setBorder(new EmptyBorder(0, 0, 0, 60));
        jWindshield.setBorder(new EmptyBorder(0, 0, 0, 50));
        jHornBattery.setBorder(new EmptyBorder(0, 0, 0, 41));
        jSideMirror.setBorder(new EmptyBorder(0, 0, 0, 50));  
        jTotal.setBorder(new EmptyBorder(0, 0, 0, 57));   
        
        jPanel1.add(jCustomerName, BorderLayout.WEST);
        jPanel1.add(jGetCusName, BorderLayout.EAST);
        jPanele1.add(jPanel1, BorderLayout.WEST);
            
        jPanel2.add(jAddress, BorderLayout.WEST);
        jPanel2.add(jGetAddress, BorderLayout.EAST);
        jPanele2.add(jPanel2, BorderLayout.WEST);
        
        jPanel3.add(jMobileNo, BorderLayout.WEST);
        jPanel3.add(jGetMobileNo, BorderLayout.EAST);
        jPanele3.add(jPanel3, BorderLayout.WEST);
        
        jPanel4.add(jCarName, BorderLayout.WEST);
        jPanel4.add(jGetCarName, BorderLayout.EAST);
        jPanele4.add(jPanel4, BorderLayout.WEST);
        jPanele4.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        jPanel5.add(jDefect, BorderLayout.WEST);
        jPanel5.setBorder(new EmptyBorder(0, 5, 0, 0));
            
        jPanel7.add(jService, BorderLayout.WEST);
        jPanel7.add(jCost, BorderLayout.EAST);
        jPanele7.add(jPanel7, BorderLayout.WEST);
        jPanele7.setBorder(new EmptyBorder(0, 100, 8, 0));
        
        tot = 0;
        
        jPanel8.add(jCarPaint, BorderLayout.WEST);
        if(rs.getString("CarPaint").equals(yes)){
            jPanel8.add(j3000, BorderLayout.EAST);
            tot += 3000;
        }
        else{
            jPanel8.add(new JLabel("0000.00"), BorderLayout.EAST);
        }
        jPanele8.add(jPanel8, BorderLayout.WEST);
        jPanele8.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        jPanel9.add(jHeadlightChange, BorderLayout.WEST);
        if(rs.getString("HeadlightChange").equals(yes)){
            jPanel9.add(j2000, BorderLayout.EAST);
            tot += 2000;
        }
        else{
            jPanel9.add(new JLabel("0000.00"), BorderLayout.EAST);
        }
        jPanele9.add(jPanel9, BorderLayout.WEST);
        jPanele9.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        jPanel10.add(jWindshield, BorderLayout.WEST);
        if(rs.getString("Windshield").equals(yes)){
            jPanel10.add(j5000, BorderLayout.EAST);
            tot += 5000;
        }
        else{
            jPanel10.add(new JLabel("0000.00"), BorderLayout.EAST);
        }
        jPanele10.add(jPanel10, BorderLayout.WEST);
        jPanele10.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        jPanel11.add(jHornBattery, BorderLayout.WEST);
        if(rs.getString("HornBattery").equals(yes)){
            jPanel11.add(j1000, BorderLayout.EAST);
            tot += 1000;
        }
        else{
            jPanel11.add(new JLabel("0000.00"), BorderLayout.EAST);
        }
        jPanele11.add(jPanel11, BorderLayout.WEST);
        jPanele11.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        jPanel12.add(jSideMirror, BorderLayout.WEST);
        if(rs.getString("SideMirror").equals(yes)){
            jPanel12.add(j1500, BorderLayout.EAST);
            tot += 1500;
        }
        else{
            jPanel12.add(new JLabel("0000.00"), BorderLayout.EAST);
        }
        jPanele12.add(jPanel12, BorderLayout.WEST);
        jPanele12.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(tot == 0)
            jGetTotal = new JLabel("0000.00");
        else
            jGetTotal = new JLabel(String.valueOf(tot)+".00");
        
        jPanel13.add(jTotal, BorderLayout.WEST);
        jPanel13.add(jGetTotal, BorderLayout.EAST);
        jPanele13.add(jPanel13, BorderLayout.WEST);
        jPanele13.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        jPanelLine.add(jLine, BorderLayout.WEST);
        jPanelLine.setBorder(new EmptyBorder(0, 105, 0, 0));
        
        Box object = new Box(BoxLayout.Y_AXIS);
        
        object.add(jPanele1);
        object.add(jPanele2);
        object.add(jPanele3);
        object.add(jPanele4);
        object.add(jPanel5);
        
        object.add(jPanele6);
        
        object.add(jPanele7);
        
        object.add(jPanele8);
        object.add(jPanele9);
        object.add(jPanele10);
        object.add(jPanele11);
        object.add(jPanele12);
        
        object.add(jPanelLine);
        object.add(jPanele13);
        
        jPanelMain.add(object, BorderLayout.EAST);
        
        jPanel.add(jBill, BorderLayout.NORTH);
        jPanel.add(jPanelMain, BorderLayout.CENTER);
        jPanel.add(jBottomPanel, BorderLayout.SOUTH);
        
        add(jPanel);
        
        setTitle  ("Customer Page");
        setVisible(true);
        setSize   (400, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}