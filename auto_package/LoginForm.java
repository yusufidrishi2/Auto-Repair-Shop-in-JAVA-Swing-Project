package auto_package;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class LoginForm extends JFrame{
        
    JPanel jBottomPanel, jPanel, jPanel1, jPanel2, j_Panel;
    JLabel jPhoto, jUsernameText, jPasswordText;
    JTextField jUsernameTextField, jPasswordTextField;
    JButton jLoginButton, jBackButton;
    String usernameInput, passwordInput, adminUser, adminPass;
    
    Point locked=super.getLocation();
    
    public LoginForm(){
        
        jPanel = new JPanel();
        jPanel1 = new JPanel(new BorderLayout(2, 5));
        jPanel2 = new JPanel(new BorderLayout(2, 5));
        j_Panel = new JPanel(new BorderLayout(6, 5));
        jBottomPanel = new JPanel();
        
        jPhoto = new JLabel();
        
        jUsernameText = new JLabel("USERNAME: ");
        jPasswordText = new JLabel("PASSWORD: ");
        
        jUsernameTextField = new JTextField(30);
        jPasswordTextField = new JTextField(30);
        
        usernameInput = new String();
        passwordInput = new String();
        adminUser     = new String("admin");
        adminPass     = new String("password");
        
        jLoginButton = new JButton("LOGIN");
        jBackButton = new JButton("BACK");
        
        jBottomPanel.add(jBackButton);
        jBottomPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        
        jBackButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
                FirstPage firstPage = new FirstPage();
            }
        });
        
        jPhoto.setIcon(new ImageIcon(getClass().getResource("LoginImage.jpg")));
        
        jLoginButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                usernameInput = jUsernameTextField.getText();
                passwordInput = jPasswordTextField.getText();
                
                if(usernameInput.equals(adminUser) && passwordInput.equals(adminPass)){
                    
                    setVisible(false);
                    CustomerList customerList= new CustomerList();
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
                            
                            if(rs.getString("UserName").equals(usernameInput) && rs.getString("Password").equals(passwordInput)){
                            
                                flag = true;
                                break;
                            }
                        }
                        if(flag == true){
                            
                            setVisible(false);
                            CustomerView custumerView = new CustomerView(usernameInput);
                        }
                        else{
                            
                            Toast toast = new Toast("Wrong Username or Password", 150, 562);
                            toast.showtoast();
                        }
                    }
                    catch(Exception ex){
                        
                        ex.printStackTrace();    
                    }
                }
            }
        });
        
        jPanel1.add(jUsernameText, BorderLayout.WEST);
        jPanel1.add(jUsernameTextField, BorderLayout.EAST);
        
        jPanel2.add(jPasswordText, BorderLayout.WEST);
        jPanel2.add(jPasswordTextField, BorderLayout.EAST);
        
        j_Panel.add(jPanel1, BorderLayout.NORTH);
        j_Panel.add(jPanel2, BorderLayout.CENTER);
        j_Panel.add(jLoginButton, BorderLayout.SOUTH);

        jPanel.add(jPhoto, BorderLayout.NORTH);
        jPanel.add(j_Panel, BorderLayout.CENTER);
        jPanel.add(jBottomPanel, BorderLayout.SOUTH);
        
        add(jPanel);
                       
        validate(); 
        
        super.addComponentListener(new ComponentAdapter(){
            public void componentMoved(ComponentEvent e) {
                if (locked!=null) 
                    LoginForm.this.setLocation(locked);
            }
        });
        
        setTitle("Login Form");
        setVisible(true);
        setSize(500, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
    }
}