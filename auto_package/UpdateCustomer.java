package auto_package;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;

public class UpdateCustomer extends JFrame{
    
    JPanel       jPanel, jPanel6, jPanel7, jPanel8, jPanel9, jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
    JPanel       jBottomPanel, jPanelMain, jPanel66, jPanel77, jPanel11, jPanel22, jPanel33, jPanel44, jPanel55;
    JLabel       jBlank, jCreateUsername, jCreatePassword, jCustomerDetails, jCustomerName, jAddress, jMobileNo, jDefect, jCarName;
    JTextField   jTextUsername, jTextPassword, jTextCustomerName, jTextAddress, jTextMobileNo, jTextCarName;  
    JButton      jButtonSubmit, jBackButton;
    JRadioButton jCarPaint, jHeadlightChange, jWindshield, jHornBattery, jSideMirror;
    
    String       customerName, address, mobileNo, carName, carPaint, headlightChange, windshield, hornBattery, sideMirror, userName, password;
    String       yes, admin, blank;
    
    Point locked=super.getLocation();
    
    public UpdateCustomer(String user){
        
        jCustomerDetails = new JLabel("UPDATE CUSTOMER DETAILS");
        jCustomerDetails.setFont(new Font("Serif", Font.BOLD, 25));
        jCustomerDetails.setBorder(new EmptyBorder(0, 0, 50, 0));
        
        jCreateUsername = new JLabel("Username: ");
        jCreatePassword = new JLabel("Password: ");
        jBlank          = new JLabel("");
        jCustomerName   = new JLabel("Customer Name: ");
        jAddress        = new JLabel("Address: ");
        jMobileNo       = new JLabel("Mobile No.: ");
        jCarName        = new JLabel("Car Name: ");
        jDefect         = new JLabel("Defects: ");
        
        jCustomerName  .setBorder(new EmptyBorder(0, 0, 0, 7));
        jAddress       .setBorder(new EmptyBorder(0, 0, 0, 51));
        jMobileNo      .setBorder(new EmptyBorder(0, 0, 0, 41));
        jCarName       .setBorder(new EmptyBorder(0, 0, 0, 43));
        jDefect        .setBorder(new EmptyBorder(0, 0, 0, 62));
        
        jTextUsername     = new JTextField(15);
        jTextPassword     = new JTextField(15);
        jTextCustomerName = new JTextField(15);
        jTextAddress      = new JTextField(30);
        jTextMobileNo     = new JTextField(15);
        jTextCarName      = new JTextField(15);
        
        password        = new String();
        userName        = new String();
        customerName    = new String();
        address         = new String();
        mobileNo        = new String();
        carName         = new String();
        carPaint        = new String();
        headlightChange = new String();
        windshield      = new String();
        hornBattery      = new String();
        sideMirror      = new String();
    
        jCarPaint        = new JRadioButton(); 
        jHeadlightChange = new JRadioButton();
        jWindshield      = new JRadioButton();
        jHornBattery      = new JRadioButton();
        jSideMirror      = new JRadioButton();
        
        jCarPaint.setText("Car Paint");
        jHeadlightChange.setText("Replace HeadLight");
        jWindshield.setText("Replace Windshield");
        jHornBattery.setText("Replace HornBattery");
        jSideMirror.setText("Replace SideMirror");
        
        Box ob = new Box(BoxLayout.Y_AXIS);
        
        ob.add(jCarPaint);
        ob.add(jHeadlightChange);
        ob.add(jWindshield);
        ob.add(jHornBattery);
        ob.add(jSideMirror);
        
        yes = new String("Yes");
        
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
                if(rs.getString("UserName").equals(user)){
                    flag = true;
                    break;
                }
            }
            
            jTextUsername.setText(rs.getString("UserName"));
            jTextPassword.setText(rs.getString("Password"));
            jTextCustomerName.setText(rs.getString("CustomerName"));
            jTextAddress.setText(rs.getString("Address"));
            jTextMobileNo.setText(rs.getString("MobileNo"));
            jTextCarName.setText(rs.getString("CarName"));
            
            if(rs.getString("CarPaint").equals(yes))
                jCarPaint.setSelected(true);
            else
                jCarPaint.setSelected(false);
            
            if(rs.getString("HeadlightChange").equals(yes))
                jHeadlightChange.setSelected(true);
            else
                jHeadlightChange.setSelected(false);
            
            if(rs.getString("Windshield").equals(yes))
                jWindshield.setSelected(true);
            else
                jWindshield.setSelected(false);
            
            if(rs.getString("HornBattery").equals(yes))
                jHornBattery.setSelected(true);
            else
                jHornBattery.setSelected(false);
            
            if(rs.getString("SideMirror").equals(yes))
                jSideMirror.setSelected(true);
            else
                jSideMirror.setSelected(false);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        admin = new String("admin");
        blank = new String("");
        
        jPanel9 = new JPanel(new BorderLayout(2, 5));
        
        jPanel9.add(ob, BorderLayout.WEST);
        jPanel9.setBorder(new EmptyBorder(0, 110, 0, 0));
        
        jButtonSubmit = new JButton("UPDATE");
        jBackButton = new JButton("BACK");
        
        jBackButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                CustomerView customerView = new CustomerView(user);
            }
        });
        
        jButtonSubmit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                userName     = jTextUsername.getText();
                password     = jTextPassword.getText();
                customerName = jTextCustomerName.getText();
                address      = jTextAddress.getText();
                mobileNo     = jTextMobileNo.getText();
                carName      = jTextCarName.getText();
                
                if(userName.equals(blank)){
                    Toast toast = new Toast("Please enter valid name!", 150, 560);
                    toast.showtoast();
                }
                
                else{
                
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
                        if(rs.getString("UserName").equals(userName) && !rs.getString("UserName").equals(user)){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag && !userName.equals(admin)){

                        PreparedStatement ps = con.prepareStatement("update AutoDatabase set CustomerName=?, Address=?, MobileNo=?, CarName=?, CarPaint=?, HeadlightChange=?, WindShield=?, HornBattery=?, SideMirror=?, UserName=?, Password=? where UserName=?");
                        
                        if(jCarPaint.isSelected()){
                            carPaint = "Yes";
                        }
                        else{
                            carPaint = "No";
                        }
                        if(jHeadlightChange.isSelected()){
                            headlightChange = "Yes";
                        }
                        else{
                            headlightChange = "No";
                        }
                        if(jWindshield.isSelected()){
                            windshield = "Yes";
                        }
                        else{
                            windshield = "No";
                        }
                        if(jHornBattery.isSelected()){
                            hornBattery = "Yes";
                        }
                        else{
                            hornBattery = "No";
                        }
                        if(jSideMirror.isSelected()){
                            sideMirror = "Yes";
                        }
                        else{
                            sideMirror = "No";
                        }

                        ps.setString(1, customerName);
                        ps.setString(2, address);
                        ps.setString(3, mobileNo);
                        ps.setString(4, carName);
                        ps.setString(5, carPaint);
                        ps.setString(6, headlightChange);
                        ps.setString(7, windshield);
                        ps.setString(8, hornBattery);
                        ps.setString(9, sideMirror);
                        ps.setString(10, userName);
                        ps.setString(11, password);
                        ps.setString(12, user);
                        
                        ps.executeUpdate();
                        con.commit();
                        ps.close();
                        con.close();

                        // create a toast message 
                        Toast toast = new Toast("Datas Saved Successfully", 150, 560); 

                        // call the method 
                        toast.showtoast();

                        setVisible(false);

                        CustomerView customerView = new CustomerView(userName);
                    }
                    else{

                        Toast toast = new Toast("Username is already available!", 150, 560);
                        toast.showtoast();
                        jTextUsername.setText("");
                    }
                }catch (Exception ex){
                
                    Toast toast = new Toast("Some Error Occured", 150, 560); 
                    toast.showtoast();
                    
                    ex.printStackTrace();
                }
                    
                }
            }
        });
        
        jPanel     = new JPanel();
        jPanelMain = new JPanel();
        jPanel1    = new JPanel();
        jPanel2    = new JPanel();
        jPanel3    = new JPanel();
        jPanel4    = new JPanel();
        jPanel5    = new JPanel();
        jPanel6    = new JPanel();
        jPanel7    = new JPanel();
        jPanel8    = new JPanel();
        
        jPanel66 = new JPanel(new BorderLayout(2, 5));
        jPanel77 = new JPanel(new BorderLayout(2, 5));
        jPanel11 = new JPanel(new BorderLayout(2, 5));
        jPanel22 = new JPanel(new BorderLayout(2, 5));
        jPanel33 = new JPanel(new BorderLayout(2, 5));
        jPanel44 = new JPanel(new BorderLayout(2, 5));
        jPanel55 = new JPanel(new BorderLayout(2, 5));
        
        jBottomPanel = new JPanel(new BorderLayout(4, 5));
        
        jPanel6.add (jCreateUsername,     BorderLayout.WEST);
        jPanel6.add (jTextUsername, BorderLayout.EAST);
        jPanel66.add(jPanel6,           BorderLayout.WEST);
        
        jPanel7.add (jCreatePassword,     BorderLayout.WEST);
        jPanel7.add (jTextPassword, BorderLayout.EAST);
        jPanel77.add(jPanel7,           BorderLayout.WEST);
        
        jPanel8.add(jBlank);
        
        jPanel1.add (jCustomerName,     BorderLayout.WEST);
        jPanel1.add (jTextCustomerName, BorderLayout.EAST);
        jPanel11.add(jPanel1,           BorderLayout.WEST);
        
        jPanel2.add (jAddress,          BorderLayout.WEST);
        jPanel2.add (jTextAddress,      BorderLayout.EAST);
        jPanel22.add(jPanel2,           BorderLayout.WEST);
        
        jPanel3.add (jMobileNo,         BorderLayout.WEST);
        jPanel3.add (jTextMobileNo,     BorderLayout.EAST);
        jPanel33.add(jPanel3,           BorderLayout.WEST);
        
        jPanel4.add (jCarName,          BorderLayout.WEST);
        jPanel4.add (jTextCarName,      BorderLayout.EAST);
        jPanel44.add(jPanel4,           BorderLayout.WEST);
        
        jPanel5.add (jDefect,           BorderLayout.NORTH);
        jPanel55.add(jPanel5,           BorderLayout.WEST);
        
        Box object = new Box(BoxLayout.Y_AXIS);
        
        object.add(jPanel66);
        object.add(jPanel77);
        object.add(jPanel8);
        object.add(jPanel11);
        object.add(jPanel22);
        object.add(jPanel33);
        object.add(jPanel44);
        object.add(jPanel55);
        object.add(jPanel9);
        
        jPanelMain.add(object, BorderLayout.EAST);
        jPanelMain.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        jPanel.add(jCustomerDetails, BorderLayout.NORTH);
        jPanel.add(jPanelMain, BorderLayout.CENTER);
        
        jBottomPanel.add(jButtonSubmit, BorderLayout.NORTH);
        jBottomPanel.add(jBackButton, BorderLayout.SOUTH);
        
        jPanel.add(jBottomPanel, BorderLayout.SOUTH);
        //jPanelMain.setBorder(BorderFactory.createLineBorder(Color.black));
        
        /*Box box = new Box(BoxLayout.Y_AXIS);

        box.add(Box.createVerticalGlue());
        box.add(jPanel);     
        box.add(Box.createVerticalGlue());*/
        
        add(jPanel);
        
        super.addComponentListener(new ComponentAdapter(){
            public void componentMoved(ComponentEvent e) {
                if (locked!=null) 
                    UpdateCustomer.this.setLocation(locked);
            }
        });
        
        setTitle  ("Update Customer Details");
        setVisible(true);
        setSize   (500, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}