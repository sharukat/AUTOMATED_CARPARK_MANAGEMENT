/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated.car.parking.system;

//import com.mysql.cj.Session;


//import com.sun.xml.internal.ws.resources.SenderMessages;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Security;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author Sharuka Thirimanne
 */
public final class AppFrame extends javax.swing.JFrame {

    Color c = new Color(255, 102, 0);   //Assigning Color c as Red color
    Color c1 = new Color(51,51,255);    //Assigning Color c1 as Blue color
    String Date;
    String Time;
    String IDno;
    String Dura;
    int D1;
     
    //Declare and Initialize strings related to the automatic email sending process
    final String senderEmailID = "typesendermailid@gmail.com";
    final String senderPassword = "typesenderpassword";
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "465";
    String receiverEmailID ;
    static String emailSubject = "Test Mail";
    static String emailBody = ":)";
    
    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
        SubmitB.setContentAreaFilled(true);
        CancelB.setContentAreaFilled(true);
        Slot1.setContentAreaFilled(true);   //Setting content area filled in each button
        Slot2.setContentAreaFilled(true);
        Slot3.setContentAreaFilled(true);
        Slot4.setContentAreaFilled(true);
        Slot5.setContentAreaFilled(true);
        Slot6.setContentAreaFilled(true);
        Slot7.setContentAreaFilled(true);
        Slot8.setContentAreaFilled(true);
        Slot9.setContentAreaFilled(true);
        Slot10.setContentAreaFilled(true);
        Slot11.setContentAreaFilled(true);
        Slot12.setContentAreaFilled(true);
        Slot13.setContentAreaFilled(true);
        Slot14.setContentAreaFilled(true);
        Slot15.setContentAreaFilled(true);
        Slot16.setContentAreaFilled(true);
        Slot17.setContentAreaFilled(true);
        Slot18.setContentAreaFilled(true);
        Slot19.setContentAreaFilled(true);
        Slot20.setContentAreaFilled(true);
        TimeCheck();                         //calling the function related to checking whether the reserved time has exceeded or not
    }
   
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        DateLabel.setText(s.format(d)); //Display the system date in the 'DateLabel' label
    }

    public void showTime() {
        //Display the system time on the TimeLabel
        Thread showTime = new Thread(){
            public void run(){
                try {
                    for (;;) {
                        Date Dnew = new Date();
                        SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                        TimeLabel.setText(s.format(Dnew));
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        showTime.start();   //executing the showTime function
        
    }
    
   
    
    void S1condition(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpslots?useSSL=false", "root", "root");
            Statement s = conn.createStatement();
            for (int i =1;i<=20;i++){   //setting a for loop for all 20 buttons
                String Condition = "SELECT State from new_table WHERE SlotID='"+i+"'";
                ResultSet re =  s.executeQuery(Condition);
                while(re.next()){
                    
                    //Setting the color of the Occupied slots as red
                    if (re.getString(1).equals("Occupied")) {
                        if(i==1){
                            Slot1.setBackground(c);     }
                        else if(i==2){
                            Slot2.setBackground(c);     }
                        else if(i==3){
                            Slot3.setBackground(c);     }
                        else if(i==4){
                            Slot4.setBackground(c);     }
                        else if(i==5){
                            Slot5.setBackground(c);     }
                        else if(i==6){
                            Slot6.setBackground(c);     }
                        else if(i==7){
                            Slot7.setBackground(c);     }
                        else if(i==8){
                            Slot8.setBackground(c);     }
                        else if(i==9){
                            Slot9.setBackground(c);     }
                        else if(i==10){
                            Slot10.setBackground(c);    }
                        else if(i==11){
                            Slot11.setBackground(c);    }
                        else if(i==12){
                            Slot12.setBackground(c);    }
                        else if(i==13){
                            Slot13.setBackground(c);    }
                        else if(i==14){
                            Slot14.setBackground(c);    }
                        else if(i==15){
                            Slot15.setBackground(c);    }
                        else if(i==16){
                            Slot16.setBackground(c);    }
                        else if(i==17){
                            Slot17.setBackground(c);    }
                        else if(i==18){
                            Slot18.setBackground(c);    }
                        else if(i==19){
                            Slot19.setBackground(c);    }
                        else if(i==20){
                            Slot20.setBackground(c);    }           
                }
                    //Setting the color of the Vacant slots as blue
                    if (re.getString(1).equals("Vacant")) {
                        if(i==1){
                            Slot1.setBackground(c1);   }
                        else if(i==2){
                            Slot2.setBackground(c1);   }
                        else if(i==3){
                            Slot3.setBackground(c1);   }
                        else if(i==4){
                            Slot4.setBackground(c1);   }
                        else if(i==5){
                            Slot5.setBackground(c1);   }
                        else if(i==6){
                            Slot6.setBackground(c1);   }
                        else if(i==7){
                            Slot7.setBackground(c1);   }
                        else if(i==8){
                            Slot8.setBackground(c1);   }
                        else if(i==9){
                            Slot9.setBackground(c1);   }
                        else if(i==10){
                            Slot10.setBackground(c1);  }
                        else if(i==11){
                            Slot11.setBackground(c1);  }
                        else if(i==12){
                            Slot12.setBackground(c1);  }
                        else if(i==13){
                            Slot13.setBackground(c1);  }
                        else if(i==14){
                            Slot14.setBackground(c1);  }
                        else if(i==15){
                            Slot15.setBackground(c1);  }
                        else if(i==16){
                            Slot16.setBackground(c1);  }
                        else if(i==17){
                            Slot17.setBackground(c1);  }
                        else if(i==18){
                            Slot18.setBackground(c1);  }
                        else if(i==19){
                            Slot19.setBackground(c1);  }
                        else if(i==20){
                            Slot20.setBackground(c1);  }
                    }
            }
                
            }
        }catch (ClassNotFoundException | SQLException e) {
        }try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator15 = new javax.swing.JSeparator();
        SideBarPanel = new javax.swing.JPanel();
        RegistrationButton = new javax.swing.JButton();
        LogInButton = new javax.swing.JButton();
        SlotAvailabilityB = new javax.swing.JButton();
        PaymentButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LogInPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        UserNameTField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        LogButton = new javax.swing.JButton();
        PasswordTField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        UserDisLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        IDDisLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        RegPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        VNoLabel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        CNoLabel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        MaleRButton = new javax.swing.JRadioButton();
        FemaleRButton = new javax.swing.JRadioButton();
        SubmitB = new javax.swing.JButton();
        CancelB = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        IDNoLabel = new javax.swing.JTextField();
        UNameLabel = new javax.swing.JTextField();
        SlotCheckPanel = new javax.swing.JPanel();
        Slot1 = new javax.swing.JButton();
        Slot2 = new javax.swing.JButton();
        Slot3 = new javax.swing.JButton();
        Slot4 = new javax.swing.JButton();
        Slot5 = new javax.swing.JButton();
        Slot6 = new javax.swing.JButton();
        Slot7 = new javax.swing.JButton();
        Slot8 = new javax.swing.JButton();
        Slot9 = new javax.swing.JButton();
        Slot10 = new javax.swing.JButton();
        Slot11 = new javax.swing.JButton();
        Slot12 = new javax.swing.JButton();
        Slot13 = new javax.swing.JButton();
        Slot14 = new javax.swing.JButton();
        Slot15 = new javax.swing.JButton();
        Slot16 = new javax.swing.JButton();
        Slot17 = new javax.swing.JButton();
        Slot18 = new javax.swing.JButton();
        Slot19 = new javax.swing.JButton();
        Slot20 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Duration_Combo = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        IDDisS = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        UserDisLabelS = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        PaymentPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        CostPHour = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        TCost = new javax.swing.JLabel();
        PayName = new javax.swing.JLabel();
        TimeDura = new javax.swing.JLabel();
        PayCNo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        PayVNo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        StartDateandTime = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        EndDateandTime1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        PaymentIDTField = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        VacantButton = new javax.swing.JButton();
        PrintReceiptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SideBarPanel.setBackground(new java.awt.Color(0, 102, 153));
        SideBarPanel.setPreferredSize(new java.awt.Dimension(450, 770));

        RegistrationButton.setBackground(new java.awt.Color(0, 102, 153));
        RegistrationButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        RegistrationButton.setForeground(new java.awt.Color(255, 255, 255));
        RegistrationButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Male_User_32.png")); // NOI18N
        RegistrationButton.setText("     Registration");
        RegistrationButton.setBorder(null);
        RegistrationButton.setContentAreaFilled(false);
        RegistrationButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RegistrationButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RegistrationButton.setIconTextGap(0);
        RegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrationButtonActionPerformed(evt);
            }
        });

        LogInButton.setBackground(new java.awt.Color(0, 102, 153));
        LogInButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(255, 255, 255));
        LogInButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Key_32.png")); // NOI18N
        LogInButton.setText("     Log In");
        LogInButton.setBorder(null);
        LogInButton.setContentAreaFilled(false);
        LogInButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LogInButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LogInButton.setIconTextGap(0);
        LogInButton.setPreferredSize(new java.awt.Dimension(207, 41));
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        SlotAvailabilityB.setBackground(new java.awt.Color(0, 102, 153));
        SlotAvailabilityB.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SlotAvailabilityB.setForeground(new java.awt.Color(255, 255, 255));
        SlotAvailabilityB.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_People_in_Car_32.png")); // NOI18N
        SlotAvailabilityB.setText("     Slot Availability");
        SlotAvailabilityB.setBorder(null);
        SlotAvailabilityB.setContentAreaFilled(false);
        SlotAvailabilityB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SlotAvailabilityB.setIconTextGap(0);
        SlotAvailabilityB.setPreferredSize(new java.awt.Dimension(207, 41));
        SlotAvailabilityB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SlotAvailabilityBActionPerformed(evt);
            }
        });

        PaymentButton.setBackground(new java.awt.Color(0, 102, 153));
        PaymentButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        PaymentButton.setForeground(new java.awt.Color(255, 255, 255));
        PaymentButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Expensive_Price__32.png")); // NOI18N
        PaymentButton.setText("     Payment");
        PaymentButton.setBorder(null);
        PaymentButton.setContentAreaFilled(false);
        PaymentButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PaymentButton.setIconTextGap(0);
        PaymentButton.setOpaque(true);
        PaymentButton.setPreferredSize(new java.awt.Dimension(207, 41));
        PaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel6.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("tem");

        jLabel5.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sys");

        jLabel3.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("mated");

        jLabel2.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Auto");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout SideBarPanelLayout = new javax.swing.GroupLayout(SideBarPanel);
        SideBarPanel.setLayout(SideBarPanelLayout);
        SideBarPanelLayout.setHorizontalGroup(
            SideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarPanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RegistrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SlotAvailabilityB, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        SideBarPanelLayout.setVerticalGroup(
            SideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegistrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SlotAvailabilityB, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(PaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );

        jPanel2.setLayout(new java.awt.CardLayout());

        LogInPanel.setBackground(new java.awt.Color(36, 47, 65));
        LogInPanel.setPreferredSize(new java.awt.Dimension(1000, 770));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Password_32.png")); // NOI18N
        jLabel12.setText("Password");

        UserNameTField.setBackground(new java.awt.Color(36, 47, 65));
        UserNameTField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        UserNameTField.setForeground(new java.awt.Color(255, 255, 255));
        UserNameTField.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_User_32.png")); // NOI18N
        jLabel13.setText("User ID");

        LogButton.setBackground(new java.awt.Color(51, 51, 255));
        LogButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LogButton.setForeground(new java.awt.Color(255, 255, 255));
        LogButton.setText("Log In");
        LogButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogButton.setBorderPainted(false);
        LogButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        LogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogButtonActionPerformed(evt);
            }
        });

        PasswordTField.setBackground(new java.awt.Color(36, 47, 65));
        PasswordTField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PasswordTField.setForeground(new java.awt.Color(255, 255, 255));
        PasswordTField.setBorder(null);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_User_16.png")); // NOI18N
        jLabel14.setText("User      : ");

        UserDisLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        UserDisLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Identification_Documents_16.png")); // NOI18N
        jLabel15.setText("NIC No :");

        IDDisLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        IDDisLabel.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("New User ?");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Log");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("In");

        javax.swing.GroupLayout LogInPanelLayout = new javax.swing.GroupLayout(LogInPanel);
        LogInPanel.setLayout(LogInPanelLayout);
        LogInPanelLayout.setHorizontalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(641, 641, 641)
                        .addComponent(jLabel14)
                        .addGap(7, 7, 7)
                        .addComponent(UserDisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(641, 641, 641)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(IDDisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel13))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel12))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jButton3)
                        .addGap(103, 103, 103)
                        .addComponent(LogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(UserNameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogInPanelLayout.createSequentialGroup()
                            .addGap(352, 352, 352)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(PasswordTField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogInPanelLayout.createSequentialGroup()
                            .addGap(351, 351, 351)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );
        LogInPanelLayout.setVerticalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(UserDisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(IDDisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(80, 80, 80)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(UserNameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(13, 13, 13)
                .addComponent(PasswordTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton3))
                    .addComponent(LogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(260, 260, 260))
        );

        jPanel2.add(LogInPanel, "card3");

        RegPanel.setBackground(new java.awt.Color(36, 47, 65));
        RegPanel.setMinimumSize(new java.awt.Dimension(800, 766));
        RegPanel.setPreferredSize(new java.awt.Dimension(1000, 770));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_Secured_Letter_32.png"))); // NOI18N
        jLabel1.setText("Email Address");

        EmailLabel.setBackground(new java.awt.Color(36, 47, 65));
        EmailLabel.setFont(new java.awt.Font("SFNS Display", 0, 16)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        EmailLabel.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_Gender_32.png"))); // NOI18N
        jLabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_Identification_Documents_32.png"))); // NOI18N
        jLabel8.setText("ID / Passport No");

        VNoLabel.setBackground(new java.awt.Color(36, 47, 65));
        VNoLabel.setFont(new java.awt.Font("SFNS Display", 0, 16)); // NOI18N
        VNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        VNoLabel.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_Phone_32.png"))); // NOI18N
        jLabel9.setText("Contact No");

        CNoLabel.setBackground(new java.awt.Color(36, 47, 65));
        CNoLabel.setFont(new java.awt.Font("SFNS Display", 0, 16)); // NOI18N
        CNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        CNoLabel.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_Pickup_Front_View_32.png"))); // NOI18N
        jLabel10.setText("Vehicle No");

        MaleRButton.setBackground(new java.awt.Color(36, 47, 65));
        MaleRButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        MaleRButton.setForeground(new java.awt.Color(255, 255, 255));
        MaleRButton.setText("Male");

        FemaleRButton.setBackground(new java.awt.Color(36, 47, 65));
        FemaleRButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        FemaleRButton.setForeground(new java.awt.Color(255, 255, 255));
        FemaleRButton.setText("Female");

        SubmitB.setBackground(new java.awt.Color(51, 51, 255));
        SubmitB.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SubmitB.setForeground(new java.awt.Color(255, 255, 255));
        SubmitB.setText("Submit");
        SubmitB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SubmitB.setContentAreaFilled(false);
        SubmitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBActionPerformed(evt);
            }
        });

        CancelB.setBackground(new java.awt.Color(51, 51, 255));
        CancelB.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        CancelB.setForeground(new java.awt.Color(255, 255, 255));
        CancelB.setText("Cancel");
        CancelB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelB.setContentAreaFilled(false);
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automated/car/parking/system/icons8_User_32.png"))); // NOI18N
        jLabel11.setText("Full Name");

        IDNoLabel.setBackground(new java.awt.Color(36, 47, 65));
        IDNoLabel.setFont(new java.awt.Font("SFNS Display", 0, 16)); // NOI18N
        IDNoLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDNoLabel.setBorder(null);

        UNameLabel.setBackground(new java.awt.Color(36, 47, 65));
        UNameLabel.setFont(new java.awt.Font("SFNS Display", 0, 16)); // NOI18N
        UNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UNameLabel.setBorder(null);

        javax.swing.GroupLayout RegPanelLayout = new javax.swing.GroupLayout(RegPanel);
        RegPanel.setLayout(RegPanelLayout);
        RegPanelLayout.setHorizontalGroup(
            RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegPanelLayout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegPanelLayout.createSequentialGroup()
                        .addComponent(SubmitB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RegPanelLayout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(2, 2, 2))
                            .addComponent(IDNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel7)
                        .addGroup(RegPanelLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(RegPanelLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(MaleRButton)
                            .addGap(33, 33, 33)
                            .addComponent(FemaleRButton))
                        .addGroup(RegPanelLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(UNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegPanelLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EmailLabel)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(254, 254, 254))
        );
        RegPanelLayout.setVerticalGroup(
            RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(CNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addComponent(VNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaleRButton)
                    .addComponent(FemaleRButton))
                .addGap(36, 36, 36)
                .addGroup(RegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(RegPanel, "card2");

        SlotCheckPanel.setBackground(new java.awt.Color(36, 47, 65));
        SlotCheckPanel.setMinimumSize(new java.awt.Dimension(999, 768));
        SlotCheckPanel.setPreferredSize(new java.awt.Dimension(1000, 770));

        Slot1.setBackground(new java.awt.Color(51, 51, 255));
        Slot1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot1.setForeground(new java.awt.Color(255, 255, 255));
        Slot1.setText("Slot 01");
        Slot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot1ActionPerformed(evt);
            }
        });

        Slot2.setBackground(new java.awt.Color(51, 51, 255));
        Slot2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot2.setForeground(new java.awt.Color(255, 255, 255));
        Slot2.setText("Slot 02");
        Slot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot2ActionPerformed(evt);
            }
        });

        Slot3.setBackground(new java.awt.Color(51, 51, 255));
        Slot3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot3.setForeground(new java.awt.Color(255, 255, 255));
        Slot3.setText("Slot 03");
        Slot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot3ActionPerformed(evt);
            }
        });

        Slot4.setBackground(new java.awt.Color(51, 51, 255));
        Slot4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot4.setForeground(new java.awt.Color(255, 255, 255));
        Slot4.setText("Slot 04");
        Slot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot4ActionPerformed(evt);
            }
        });

        Slot5.setBackground(new java.awt.Color(51, 51, 255));
        Slot5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot5.setForeground(new java.awt.Color(255, 255, 255));
        Slot5.setText("Slot 05");
        Slot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot5ActionPerformed(evt);
            }
        });

        Slot6.setBackground(new java.awt.Color(51, 51, 255));
        Slot6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot6.setForeground(new java.awt.Color(255, 255, 255));
        Slot6.setText("Slot 06");
        Slot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot6ActionPerformed(evt);
            }
        });

        Slot7.setBackground(new java.awt.Color(51, 51, 255));
        Slot7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot7.setForeground(new java.awt.Color(255, 255, 255));
        Slot7.setText("Slot 07");
        Slot7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot7ActionPerformed(evt);
            }
        });

        Slot8.setBackground(new java.awt.Color(51, 51, 255));
        Slot8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot8.setForeground(new java.awt.Color(255, 255, 255));
        Slot8.setText("Slot 08");
        Slot8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot8ActionPerformed(evt);
            }
        });

        Slot9.setBackground(new java.awt.Color(51, 51, 255));
        Slot9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot9.setForeground(new java.awt.Color(255, 255, 255));
        Slot9.setText("Slot 9");
        Slot9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot9.setMaximumSize(new java.awt.Dimension(77, 27));
        Slot9.setMinimumSize(new java.awt.Dimension(77, 27));
        Slot9.setPreferredSize(new java.awt.Dimension(77, 27));
        Slot9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot9ActionPerformed(evt);
            }
        });

        Slot10.setBackground(new java.awt.Color(51, 51, 255));
        Slot10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot10.setForeground(new java.awt.Color(255, 255, 255));
        Slot10.setText("Slot 10");
        Slot10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot10ActionPerformed(evt);
            }
        });

        Slot11.setBackground(new java.awt.Color(51, 51, 255));
        Slot11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot11.setForeground(new java.awt.Color(255, 255, 255));
        Slot11.setText("Slot 11");
        Slot11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot11ActionPerformed(evt);
            }
        });

        Slot12.setBackground(new java.awt.Color(51, 51, 255));
        Slot12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot12.setForeground(new java.awt.Color(255, 255, 255));
        Slot12.setText("Slot 12");
        Slot12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot12ActionPerformed(evt);
            }
        });

        Slot13.setBackground(new java.awt.Color(51, 51, 255));
        Slot13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot13.setForeground(new java.awt.Color(255, 255, 255));
        Slot13.setText("Slot 13");
        Slot13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot13ActionPerformed(evt);
            }
        });

        Slot14.setBackground(new java.awt.Color(51, 51, 255));
        Slot14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot14.setForeground(new java.awt.Color(255, 255, 255));
        Slot14.setText("Slot 14");
        Slot14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot14ActionPerformed(evt);
            }
        });

        Slot15.setBackground(new java.awt.Color(51, 51, 255));
        Slot15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot15.setForeground(new java.awt.Color(255, 255, 255));
        Slot15.setText("Slot 15");
        Slot15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot15ActionPerformed(evt);
            }
        });

        Slot16.setBackground(new java.awt.Color(51, 51, 255));
        Slot16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot16.setForeground(new java.awt.Color(255, 255, 255));
        Slot16.setText("Slot 16");
        Slot16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot16ActionPerformed(evt);
            }
        });

        Slot17.setBackground(new java.awt.Color(51, 51, 255));
        Slot17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot17.setForeground(new java.awt.Color(255, 255, 255));
        Slot17.setText("Slot 17");
        Slot17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot17ActionPerformed(evt);
            }
        });

        Slot18.setBackground(new java.awt.Color(51, 51, 255));
        Slot18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot18.setForeground(new java.awt.Color(255, 255, 255));
        Slot18.setText("Slot 18");
        Slot18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot18ActionPerformed(evt);
            }
        });

        Slot19.setBackground(new java.awt.Color(51, 51, 255));
        Slot19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot19.setForeground(new java.awt.Color(255, 255, 255));
        Slot19.setText("Slot 19");
        Slot19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot19ActionPerformed(evt);
            }
        });

        Slot20.setBackground(new java.awt.Color(51, 51, 255));
        Slot20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Slot20.setForeground(new java.awt.Color(255, 255, 255));
        Slot20.setText("Slot 20");
        Slot20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Slot20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Slot20ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(36, 47, 65));
        jPanel4.setPreferredSize(new java.awt.Dimension(288, 70));

        jLabel18.setFont(new java.awt.Font("SFNS Display", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Drive Path");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel18)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(36, 47, 65));
        jPanel5.setPreferredSize(new java.awt.Dimension(288, 70));

        jLabel19.setFont(new java.awt.Font("SFNS Display", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Drive Path");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(203, 203, 203))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(36, 47, 65));
        jPanel6.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel6.setLayout(new java.awt.GridLayout(1, 4));

        jPanel8.setBackground(new java.awt.Color(36, 47, 65));
        jPanel8.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Tollbooth_32.png")); // NOI18N
        jLabel20.setText("Entrance");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Tollbooth_32.png")); // NOI18N
        jLabel21.setText("Exit");

        jPanel7.setBackground(new java.awt.Color(36, 47, 65));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Time_Span_16.png")); // NOI18N
        jLabel22.setText("Time         : ");

        TimeLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));

        DateLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Timesheet_16.png")); // NOI18N
        jLabel23.setText("Duration  :");

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Calendar_16.png")); // NOI18N
        jLabel24.setText("Date        :");

        Duration_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Duration_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Duration_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(36, 47, 65));

        IDDisS.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        IDDisS.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Male_User_16.png")); // NOI18N
        jLabel25.setText("User      : ");

        UserDisLabelS.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        UserDisLabelS.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sharuka Thirimanne\\Desktop\\Icons for Software\\icons8_Identification_Documents_16.png")); // NOI18N
        jLabel26.setText("NIC No :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserDisLabelS, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDDisS, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserDisLabelS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(IDDisS, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(36, 47, 65));

        jLabel27.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Slot");

        jLabel28.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("Availability");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addContainerGap())
        );

        javax.swing.GroupLayout SlotCheckPanelLayout = new javax.swing.GroupLayout(SlotCheckPanel);
        SlotCheckPanel.setLayout(SlotCheckPanelLayout);
        SlotCheckPanelLayout.setHorizontalGroup(
            SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(Slot1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel20)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(Slot6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(Slot11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(Slot16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Slot20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(848, 848, 848)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(437, 437, 437)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SlotCheckPanelLayout.setVerticalGroup(
            SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Slot1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Slot2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Slot3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Slot4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Slot5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel20))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Slot6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Slot11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(SlotCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Slot16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Slot20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SlotCheckPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel21)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(SlotCheckPanel, "card4");

        PaymentPanel.setBackground(new java.awt.Color(36, 47, 65));
        PaymentPanel.setPreferredSize(new java.awt.Dimension(1000, 770));

        jPanel11.setBackground(new java.awt.Color(36, 47, 65));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Total Cost             :");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Start Date & Time :");

        CostPHour.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        CostPHour.setForeground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Time Duration      :");

        TCost.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        TCost.setForeground(new java.awt.Color(255, 255, 255));

        PayName.setBackground(new java.awt.Color(0, 102, 204));
        PayName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PayName.setForeground(new java.awt.Color(255, 255, 255));

        TimeDura.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        TimeDura.setForeground(new java.awt.Color(255, 255, 255));

        PayCNo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PayCNo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Cost Per Hour      :");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Contact No         :");

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Vehicle  No         : ");

        PayVNo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PayVNo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Full Name            :");

        jLabel39.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("End Date & Time  :");

        StartDateandTime.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        StartDateandTime.setForeground(new java.awt.Color(255, 255, 255));

        EndDateandTime1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        EndDateandTime1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PayName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PayVNo, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TimeDura, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator10)
                                        .addComponent(PayCNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(EndDateandTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(CostPHour, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TCost, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator14)
                            .addComponent(jSeparator16)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StartDateandTime, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PayName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(PayCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(PayVNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(TimeDura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(StartDateandTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(EndDateandTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(CostPHour, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(TCost, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel33.getAccessibleContext().setAccessibleName("Contact No           :");

        jPanel12.setBackground(new java.awt.Color(36, 47, 65));

        jLabel36.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Pay");

        jLabel37.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("ments");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(0, 0, 0)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addContainerGap())
        );

        PaymentIDTField.setBackground(new java.awt.Color(36, 47, 65));
        PaymentIDTField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PaymentIDTField.setForeground(new java.awt.Color(255, 255, 255));
        PaymentIDTField.setBorder(null);

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Enter NIC No   :");

        VacantButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        VacantButton.setText("Vacant the Slot");
        VacantButton.setPreferredSize(new java.awt.Dimension(143, 31));
        VacantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VacantButtonActionPerformed(evt);
            }
        });

        PrintReceiptButton.setBackground(new java.awt.Color(51, 51, 255));
        PrintReceiptButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        PrintReceiptButton.setForeground(new java.awt.Color(255, 255, 255));
        PrintReceiptButton.setText("Print Receipt");
        PrintReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintReceiptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaymentPanelLayout = new javax.swing.GroupLayout(PaymentPanel);
        PaymentPanel.setLayout(PaymentPanelLayout);
        PaymentPanelLayout.setHorizontalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaymentPanelLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaymentIDTField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PrintReceiptButton)
                        .addGap(18, 18, 18)
                        .addComponent(VacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)))
                .addGap(205, 205, 205))
        );
        PaymentPanelLayout.setVerticalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaymentIDTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrintReceiptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(PaymentPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void RegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrationButtonActionPerformed
        // TODO add your handling code here:
        RegPanel.setVisible(true);
        LogInPanel.setVisible(false);
        SlotCheckPanel.setVisible(false);
        PaymentPanel.setVisible(false);
    }//GEN-LAST:event_RegistrationButtonActionPerformed

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        // TODO add your handling code here:
        RegPanel.setVisible(false);
        SlotCheckPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        LogInPanel.setVisible(true);
        
        
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void SlotAvailabilityBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SlotAvailabilityBActionPerformed
        // TODO add your handling code here:
        
        LogInPanel.setVisible(false);
        RegPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        SlotCheckPanel.setVisible(true);
        
        //Calling following fucntions to execute when the SlotAvailabilityB is clicked
        showDate();     //Show date in the DateLabel of the SlotCheckPanel
        showTime();     //Show date in the TimeLabel of the SlotCheckPanel
        S1condition();  //Checking for occupied slots from the MySQL database and chaning the colors of the occupied buttons to Red
        
    }//GEN-LAST:event_SlotAvailabilityBActionPerformed

    private void PaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentButtonActionPerformed
        // TODO add your handling code here:
        PaymentPanel.setVisible(true);
        LogInPanel.setVisible(false);
        RegPanel.setVisible(false);
        SlotCheckPanel.setVisible(false);
    }//GEN-LAST:event_PaymentButtonActionPerformed

    private void SubmitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBActionPerformed
        // TODO add your handling code here:
   
        //Insert information of the customer to the MySQL database
        String UName = UNameLabel.getText();    //Assigning UNameLabel text into a String name UName (Name of the custormer)
        String Email = EmailLabel.getText();    //Assigning EmailLabel text into a String name Email (Email address of the custormer)
        String ConNum = CNoLabel.getText();     //Assigning CNoLabel text into a String name ConNum (Contact number of the custormer)
        String VNum = VNoLabel.getText();       //Assigning VNoLabel text into a String name VName (Vehicle number)
        String ID = IDNoLabel.getText();        //Assigning IDNoLabel text into a String name ID (NIC number of the custormer)

        String gender="";

        if(MaleRButton.isSelected()){   //Check the selected radio button is Male
            gender = "Male";
        }
        if (FemaleRButton.isSelected()) {   //Check the selected radio button is Female
            gender = "Female";
        }
       // executing InsertUser class where defined at the end of the source code
       Thread T = new Thread(new InsertUser(UName, ID, Email, ConNum, VNum, gender) {} );
       T.start();
       UNameLabel.setText(null);
       IDNoLabel.setText(null);
       EmailLabel.setText(null);
       CNoLabel.setText(null);
       VNoLabel.setText(null);
       

    }//GEN-LAST:event_SubmitBActionPerformed

    private void CancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBActionPerformed
        // Setting following lables blank when the cancel button is clicked
        EmailLabel.setText(""); //Setting email label of the user registration(RegPanel) blank
        UNameLabel.setText(""); //Setting UserName label of the user registration(RegPanel) blank
        CNoLabel.setText("");   //Setting contact number label of the user registration(RegPanel) blank
        VNoLabel.setText("");   //Setting Vehicle number label of the user registration(RegPanel) blank
        IDNoLabel.setText("");  //Setting ID number label of the user registration(RegPanel) blank

    }//GEN-LAST:event_CancelBActionPerformed

    private void LogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogButtonActionPerformed
        // Process related to LogInPanel

        String userName = UserNameTField.getText(); //Read the text of the UserNameTField text field and assigning it to a string name userName
        String ID = PasswordTField.getText();       //Read the text of the PasswordTField text field and assigning it to a string name ID
        int a = 0;

        try {
            //Checking the Username and the ID no are matching from the Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false", "root", "root")) {
                Statement s = c.createStatement();
                String query1 = "SELECT UserName FROM userdetails";
                ResultSet result = s.executeQuery(query1);
                while(result.next()){
                    if(result.getString(1).equals(userName)){//check entered user name is equal to the user name in MySQL database
                        a++;
                        break;
                    }
                    Thread.sleep(1000);
                }
                if(a==1){
                    String query2 = "SELECT IDNo FROM userdetails WHERE UserName = '"+userName+"'"; //if the entered user name is available in the database select that user name from the database
                    Statement s1 = c.createStatement();
                    ResultSet result1 = s1.executeQuery(query2);
                    result1.next();
                    if(result1.getString(1).equals(ID)){    //check the entered ID number is equal to the ID number of the selected user from the MySQL database
                        UserDisLabel.setText(userName);     //Display userName in UserDisLabel in the LogInPanel
                        UserDisLabelS.setText(userName);    //Display userName in UserDisLabelS in the SlotCheckPanel
                        IDDisLabel.setText(ID);             //Display ID in IDDisLabel in the LogInPanel
                        IDDisS.setText(ID);                 //Display ID in IDDisS in the SlotCheckPanel
                        JOptionPane.showMessageDialog(null, "Access Granted");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid user name or password") ;
                        /*
                        If the user name or password entered is invalid make UserNameTField and PasswordTField text fields blank
                        */
                        UserNameTField.setText(null);
                        PasswordTField.setText(null);
                    }

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        }
        
        SlotCheckPanel.setVisible(true);
        LogInPanel.setVisible(false);
        RegPanel.setVisible(false);
        
        //Calling following fucntions to execute when the ProceedNextButton is clicked
        S1condition();
        showDate();
        showTime();
        
        UserNameTField.setText("");
        PasswordTField.setText("");
        UserDisLabel.setText(null);
        IDDisLabel.setText(null);
    }//GEN-LAST:event_LogButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RegPanel.setVisible(true);
        LogInPanel.setVisible(false);
        SlotCheckPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Slot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot1ActionPerformed

        
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot1.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 1 
        Thread T1 = new Thread(new Booking(Date, Time, 1, D1,IDno) {});
        T1.start(); 
    }//GEN-LAST:event_Slot1ActionPerformed

    private void Slot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot2ActionPerformed

        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date 
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot2.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 2 
        Thread T2 = new Thread(new Booking(Date, Time, 2, D1,IDno) {});
        T2.start();
        
    }//GEN-LAST:event_Slot2ActionPerformed

    private void Slot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot3ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot3.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 3 
        Thread T3 = new Thread(new Booking(Date, Time, 3, D1,IDno) {});
        T3.start();
        
    }//GEN-LAST:event_Slot3ActionPerformed

    private void Slot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot4ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot4.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 4 
        Thread T4 = new Thread(new Booking(Date, Time, 4, D1,IDno) {});
        T4.start();
        
    }//GEN-LAST:event_Slot4ActionPerformed

    private void Slot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot5ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot5.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 5 
        Thread T5 = new Thread(new Booking(Date, Time, 5, D1,IDno) {});
        T5.start();
        
    }//GEN-LAST:event_Slot5ActionPerformed

    private void Slot6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot6ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot6.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 6 
        Thread T6 = new Thread(new Booking(Date, Time, 6, D1,IDno) {});
        T6.start();
        
    }//GEN-LAST:event_Slot6ActionPerformed

    private void Slot7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot7ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        Slot7.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 7 
        Thread T7 = new Thread(new Booking(Date, Time, 7, D1,IDno) {});
        T7.start();
        
    }//GEN-LAST:event_Slot7ActionPerformed

    private void Slot8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot8ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot8.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 8 
        Thread T8 = new Thread(new Booking(Date, Time, 8, D1,IDno) {});
        T8.start();
        
    }//GEN-LAST:event_Slot8ActionPerformed

    private void Slot9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot9ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot9.setBackground(c);         //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 9 
        Thread T9 = new Thread(new Booking(Date, Time, 9, D1,IDno) {});
        T9.start();
        
    }//GEN-LAST:event_Slot9ActionPerformed

    private void Slot10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot10ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot10.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 10 
        Thread T10 = new Thread(new Booking(Date, Time, 10, D1,IDno) {});
        T10.start();
        
    }//GEN-LAST:event_Slot10ActionPerformed

    private void Slot11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot11ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot11.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 11 
        Thread T11 = new Thread(new Booking(Date, Time, 11, D1,IDno) {});
        T11.start();
    }//GEN-LAST:event_Slot11ActionPerformed

    private void Slot12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot12ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot12.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 12 
        Thread T12 = new Thread(new Booking(Date, Time, 12, D1,IDno) {});
        T12.start();
    }//GEN-LAST:event_Slot12ActionPerformed

    private void Slot13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot13ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot13.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 13 
        Thread T13 = new Thread(new Booking(Date, Time, 13, D1,IDno) {});
        T13.start();
    }//GEN-LAST:event_Slot13ActionPerformed

    private void Slot14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot14ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot14.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 14 
        Thread T14 = new Thread(new Booking(Date, Time, 14, D1,IDno) {});
        T14.start();
    }//GEN-LAST:event_Slot14ActionPerformed

    private void Slot15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot15ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot15.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 15 
        Thread T15 = new Thread(new Booking(Date, Time, 15, D1,IDno) {});
        T15.start();
    }//GEN-LAST:event_Slot15ActionPerformed

    private void Slot16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot16ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot16.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 16 
        Thread T16 = new Thread(new Booking(Date, Time, 16, D1,IDno) {});
        T16.start();
    }//GEN-LAST:event_Slot16ActionPerformed

    private void Slot17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot17ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot17.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 17 
        Thread T17 = new Thread(new Booking(Date, Time, 17, D1,IDno) {});
        T17.start();
    }//GEN-LAST:event_Slot17ActionPerformed

    private void Slot18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot18ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot18.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 18 
        Thread T18 = new Thread(new Booking(Date, Time, 18, D1,IDno) {});
        T18.start();
    }//GEN-LAST:event_Slot18ActionPerformed

    private void Slot19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot19ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot19.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 19 
        Thread T19 = new Thread(new Booking(Date, Time, 19, D1,IDno) {});
        T19.start();
    }//GEN-LAST:event_Slot19ActionPerformed

    private void Slot20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Slot20ActionPerformed
        // TODO add your handling code here:
        Date = DateLabel.getText(); //Assigning DataLabel text into a String name Date
        Time = TimeLabel.getText(); //Assigning TimeLabel text into a String name Time
        IDno = IDDisS.getText();    //Assigning IDDisS text into a String name IDno (this represents the ID number of the custormer)
        Dura = (String) Duration_Combo.getSelectedItem();   //Getting the Duration_Combo integer value as a String and assiging it to String name Dura (Duration)
        D1 = Integer.parseInt(Dura);    //Converting the string value of the Dura into an integer value and assigning it to a int name D1
        Slot20.setBackground(c);        //Chaning the button color to Red
        
        //Calling Booking abstract decleared at the end of the source code as a Thread and Occupying Slot 20 
        Thread T20 = new Thread(new Booking(Date, Time, 20, D1,IDno) {});
        T20.start();
    }//GEN-LAST:event_Slot20ActionPerformed

    private void PrintReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintReceiptButtonActionPerformed
        // TODO add your handling code here:
        try{
            //Getting the details of the parked user and the chargers for that period
            String ID = PaymentIDTField.getText();
            String PerHour = "50";
            CostPHour.setText(PerHour);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false","root","root");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpslots?useSSL=false","root","root");
            Statement s1 = con.createStatement();
            Statement s2 = con.createStatement();
            Statement s3 = con.createStatement();
            Statement s4 = con1.createStatement();
            Statement s5 = con1.createStatement();
            Statement s6 = con1.createStatement();
            String Query1 = "SELECT UserName FROM userdetails WHERE IDNo='"+ID+"'";
            String Query2 = "SELECT ContactNum FROM userdetails WHERE IDNo='"+ID+"'";
            String Query3 = "SELECT VehicleNo FROM userdetails WHERE IDNo='"+ID+"'";
            String Query4 = "SELECT Duration FROM new_table WHERE IDNo='"+ID+"'";
            String Query5 = "SELECT DTime FROM new_table WHERE IDNo='"+ID+"'";
            String Query6 = "SELECT EndTime FROM new_table WHERE IDNo='"+ID+"'";
            ResultSet result1 = s1.executeQuery(Query1);
            ResultSet result2 = s2.executeQuery(Query2);
            ResultSet result3 = s3.executeQuery(Query3);
            ResultSet result4 = s4.executeQuery(Query4);
            ResultSet result5 = s5.executeQuery(Query5);
            ResultSet result6 = s6.executeQuery(Query6);

            while(result1.next()){

                PayName.setText(result1.getString("UserName"));

            }
            while(result2.next()){

                PayCNo.setText(result2.getString("ContactNum"));

            }
            while(result3.next()){

                PayVNo.setText(result3.getString("VehicleNo"));
            }
            while(result4.next()){

                TimeDura.setText(result4.getString("Duration"));
            }
            
            while(result5.next()){

               StartDateandTime.setText(result5.getString("DTime"));
            }
            while(result6.next()){

               EndDateandTime1.setText(result6.getString("EndTime"));
            }
            int PH = Integer.parseInt(PerHour);
            String TD =TimeDura.getText();
            Integer TDInt = Integer.parseInt(TD);
            Integer Total =PH*TDInt;
            String total = Integer.toString(Total);
            TCost.setText(total);
            

        }catch(ClassNotFoundException | NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, "Insertion not completed");
        }
    }//GEN-LAST:event_PrintReceiptButtonActionPerformed

    private void VacantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VacantButtonActionPerformed
        try {
            // TODO add your handling code here:
            //Updating the Database when the user paid and exit the parking slot
            String ID = PaymentIDTField.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpslots?useSSL=false", "root", "root");
            Statement s1 = con1.createStatement();
            String I = "UPDATE new_table SET IDNo=? WHERE IDNo='"+ID+"'";
            String I2 = "UPDATE new_table SET State='Vacant' WHERE IDNo='"+ID+"'";
            String I3 = "UPDATE new_table SET Duration=0 WHERE IDNo='"+ID+"'";
            String B = "UPDATE new_table SET TimeCheck=? WHERE IDNo='" + ID + "'";
            String B1 = "UPDATE new_table SET DTime=? WHERE IDNo='" + ID + "'";
            String B2 = "UPDATE new_table SET EndTime=? WHERE IDNo='" + ID + "'";
            PreparedStatement Ia = con1.prepareStatement(I);
            PreparedStatement Ib = con1.prepareStatement(B);
            PreparedStatement Ic = con1.prepareStatement(B1);
            PreparedStatement Id = con1.prepareStatement(B2);
            s1.execute(I2);
            s1.execute(I3);
            Ib.setString(1, "");
            Ib.execute();
            Ic.setString(1, "");
            Ic.execute();
            Id.setString(1, "");
            Id.execute();
            Ia.setString(1, "");
            Ia.execute();
            

            //Making all labels blank
            PayName.setText("");
            PayCNo.setText("");
            PayVNo.setText("");
            TimeDura.setText("");
            CostPHour.setText("");
            StartDateandTime.setText("");
            EndDateandTime1.setText("");
            TCost.setText("");
            PaymentIDTField.setText("");
            JOptionPane.showMessageDialog(null, "Slot is Vacant");
        } catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Invalid NIC Number");
        }

    }//GEN-LAST:event_VacantButtonActionPerformed
public static void TimeCheck(){
    
    ActionListener timerListener = new ActionListener() {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn19 = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpslots?useSSL=false", "root", "root");
                Statement s = conn19.createStatement();
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

                for (int i = 1; i <= 20; i++) {
                    
                    Date Dnew = new Date();
                    String DT = sdf.format(Dnew);
                    Date DDT = sdf.parse(DT);
                    String Condition = "SELECT TimeCheck from new_table WHERE SlotID='" + i + "'";
                    ResultSet re1 = s.executeQuery(Condition);
                    re1.next();
                    if (re1.getString(1).equals("TimeRemaining")) {
                        String Con1 = "SELECT EndTime from new_table WHERE SlotID='" + i + "'";
                        ResultSet re = s.executeQuery(Con1);
                        while (re.next()) {
                            String FinishT = re.getString("EndTime");
                            Date d1 = sdf.parse(FinishT);

                            if (DDT.after(d1)) {
                                JOptionPane.showMessageDialog(null, "Slot No '" + i + "'Time Exceeded");
                                String T = "UPDATE new_table SET TimeCheck=? WHERE SlotID='" + i + "'";
                                PreparedStatement Da = conn19.prepareStatement(T);
                                Da.setString(1, "TimeExceeded");
                                Da.execute();
                                Statement new1 = conn19.createStatement();
                                String SS = "SELECT IDNo from new_table WHERE SlotID='" + i + "'";
                                ResultSet re2 = new1.executeQuery(SS);
                                while (re2.next()) {
                                    
                                    String ID = re2.getString("IDNo");
                                    Thread th = new Thread(new SendMail(ID));
                                    th.start();
                                    
                                    
                                }
                            }     
                        }
                    } else {
                    }
                }
                conn19.close();
            }catch (ParseException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    Timer timer = new Timer(1000, timerListener);
    // to make sure it doesn't wait one second at the start
    timer.setInitialDelay(0);
    timer.start();
} 


    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            //new AppFrame().setVisible(true);
            @Override
            public void run() {
                try {
                    AppFrame ap = new AppFrame();
                    ap.setVisible(true);
                    
                } catch (Exception e) {
                }
            }

        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNoLabel;
    private javax.swing.JButton CancelB;
    private javax.swing.JLabel CostPHour;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JComboBox<String> Duration_Combo;
    private javax.swing.JTextField EmailLabel;
    private javax.swing.JLabel EndDateandTime1;
    private javax.swing.JRadioButton FemaleRButton;
    private javax.swing.JLabel IDDisLabel;
    private javax.swing.JLabel IDDisS;
    private javax.swing.JTextField IDNoLabel;
    private javax.swing.JButton LogButton;
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JRadioButton MaleRButton;
    private javax.swing.JTextField PasswordTField;
    private javax.swing.JLabel PayCNo;
    private javax.swing.JLabel PayName;
    private javax.swing.JLabel PayVNo;
    private javax.swing.JButton PaymentButton;
    private javax.swing.JTextField PaymentIDTField;
    private javax.swing.JPanel PaymentPanel;
    private javax.swing.JButton PrintReceiptButton;
    private javax.swing.JPanel RegPanel;
    private javax.swing.JButton RegistrationButton;
    private javax.swing.JPanel SideBarPanel;
    private javax.swing.JButton Slot1;
    private javax.swing.JButton Slot10;
    private javax.swing.JButton Slot11;
    private javax.swing.JButton Slot12;
    private javax.swing.JButton Slot13;
    private javax.swing.JButton Slot14;
    private javax.swing.JButton Slot15;
    private javax.swing.JButton Slot16;
    private javax.swing.JButton Slot17;
    private javax.swing.JButton Slot18;
    private javax.swing.JButton Slot19;
    private javax.swing.JButton Slot2;
    private javax.swing.JButton Slot20;
    private javax.swing.JButton Slot3;
    private javax.swing.JButton Slot4;
    private javax.swing.JButton Slot5;
    private javax.swing.JButton Slot6;
    private javax.swing.JButton Slot7;
    private javax.swing.JButton Slot8;
    private javax.swing.JButton Slot9;
    private javax.swing.JButton SlotAvailabilityB;
    private javax.swing.JPanel SlotCheckPanel;
    private javax.swing.JLabel StartDateandTime;
    private javax.swing.JButton SubmitB;
    private javax.swing.JLabel TCost;
    private javax.swing.JLabel TimeDura;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JTextField UNameLabel;
    private javax.swing.JLabel UserDisLabel;
    public static javax.swing.JLabel UserDisLabelS;
    private javax.swing.JTextField UserNameTField;
    private javax.swing.JTextField VNoLabel;
    private javax.swing.JButton VacantButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
abstract class InsertUser implements Runnable {
    String UName,ID,Email,ConNum,VNum,gender;
    

    public InsertUser(String Uname,String id,String email,String conNum,String vNum,String Gender) {
      UName=Uname;
      ID=id;
      Email=email;
      ConNum=conNum;
      VNum=vNum;
      gender=Gender;
        
 
    }

    @Override
    public void run() {
         try{
            //Saving new registered user details in the MySQL Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false","root","root");
            Statement s = con.createStatement();
            String query = "INSERT INTO userdetails VALUES('"+UName+"','"+ID+"','"+Email+"','"+ConNum+"','"+VNum+"','"+gender+"')";
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Insertion Successful");

            con.close();
        }
         catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Insertion not completed");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InsertUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
abstract class Booking implements Runnable{
    String Condition,D,T,Q,Q1,B,IDNumber,IDInsert;
    String DateD,TimtT;
    int DurationD,II;

    public Booking(String DateN,String TimeN,int IN,int DurationN,String IDnum) {
      DateD=DateN;
      TimtT=TimeN;
      DurationD=DurationN;
      II=IN;
      IDNumber=IDnum;
 
    }

    @Override
    public void run() {
         try {
            //Checking MySQL database to check the the slot is Occupied or not. If it is Occupied a message will be appeared displaying Already booked.
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn19 = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpslots?useSSL=false", "root", "root");
            Statement s = conn19.createStatement();
            Condition = "SELECT State from new_table WHERE SlotID='" + II + "'";
            ResultSet re =  s.executeQuery(Condition);
            re.next();
            if(re.getString(1).equals("Occupied")){
                JOptionPane.showMessageDialog(null, "Already Booked");
            }
            else{
                //Insert Date and Time to the MySQL table
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss a");
                Calendar cal = new GregorianCalendar();
                Date Dnew = new Date();
                String DT = sdf.format(Dnew);
                D = "UPDATE new_table SET DTime=? WHERE SlotID='" + II + "'";
                PreparedStatement Ta = conn19.prepareStatement(D);
                Ta.setString(1, DT);
                Ta.execute();
                D=null;

                cal.setTime(Dnew);
                cal.add(Calendar.HOUR, DurationD);
                String newTime = sdf.format(cal.getTime());
                D = "UPDATE new_table SET EndTime=? WHERE SlotID='" + II + "'";
                PreparedStatement Qa = conn19.prepareStatement(D);
                Qa.setString(1, newTime);
                Qa.execute();
                D=null;
 
                D = "UPDATE new_table SET TimeCheck=? WHERE SlotID='" + II + "'";
                PreparedStatement Qb = conn19.prepareStatement(D);
                Qb.setString(1, "TimeRemaining");
                Qb.execute();
                //End of inserting time and date

                //Insert ID No to the MySQL databasde
                IDInsert = "UPDATE new_table SET IDNo=? WHERE SlotID='" + II + "'";
                PreparedStatement Ia = conn19.prepareStatement(IDInsert);
                Ia.setString(1, IDNumber);
                Ia.execute();
                /////////////

                //Insert Duration to the MySQL database
                String DU = "UPDATE new_table SET Duration=? WHERE SlotID='" + II + "'";
                PreparedStatement Du = conn19.prepareStatement(DU);
                Du.setInt(1, DurationD);
                Du.execute();
                
                ////////////
                s.executeQuery("SELECT State from new_table WHERE SlotID='" + II + "'");
                String query19 = "UPDATE new_table SET State='Occupied' WHERE SlotID='" + II + "'";
                PreparedStatement pstmt19 = conn19.prepareStatement(query19);
                pstmt19.executeUpdate();
                s.executeQuery("SELECT State FROM new_table WHERE SlotID ='" + II + "'");
                JOptionPane.showMessageDialog(null, "Booking Success");
                /////////////
 

            }
            conn19.close();

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Booking unsuccessful");
        }
         
        
        
    }

}

class SendMail implements Runnable {

    String I;
    public SendMail(String j){
        I=j;
    }

    @Override
    public void run() {
        final String username = "promodsharuk@gmail.com";
        final String password = "Computerismylife2248900";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            //JOptionPane.showMessageDialog(null, I);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false","root","root");
            Statement s = con.createStatement();
            Statement ss = con.createStatement();
            String s1 = "SELECT Email from userdetails WHERE IDNo='" + I + "'";
            String s2 = "SELECT UserName from userdetails WHERE IDNo='" + I + "'";
            ResultSet re1 = s.executeQuery(s1);
            ResultSet re2 = ss.executeQuery(s2);
            while (re1.next()) {
                String FinishT = re1.getString("Email");
                while(re2.next()){
                    String UName = re2.getString("UserName");
                    //JOptionPane.showMessageDialog(null, UName);
                    //JOptionPane.showMessageDialog(null, FinishT);
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("promodsharuk@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(FinishT));
                    message.setSubject("Automated Parking System");
                    message.setText("Dear Customer,"
                            + "\n\nCustomer Name : '"+UName+"'\nCustomer ID : '"+I+"'\nPlease remove your vehicle from the parking slot, the allocated parking time has exceeded. Please take an action within next 15 minutes otherwise the slot will be booked for an extra hour!");

                    Transport.send(message);
                    JOptionPane.showMessageDialog(null, "Email has been sent to '" + FinishT + "'");
                }
            }
            con.close();

        } catch (MessagingException e) {
            throw new RuntimeException(e); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

    

    

    

