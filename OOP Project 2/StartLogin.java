//hazmiH (Hazmi Hashim)
//bi19110034

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Throwable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

class LoginPanel extends JPanel {
   private JButton btnLogin;
   private JLabel lbl_username;
   private JLabel lbl_password;
   private JTextField username;
   private JPasswordField password;
   private JFrame frame;
   Login log;
   
   

   public LoginPanel(JFrame frame, Login login) {
      this.frame = frame;
      this.log = login;
      
      btnLogin = new JButton ("Login");     //construct components
      lbl_username = new JLabel ("Username");
      lbl_password = new JLabel ("Password");
      username = new JTextField (5);
      password = new JPasswordField (5);

      setPreferredSize (new Dimension (614, 295));     //adjust size and set layout
      setLayout (null);

      add (btnLogin);     //add components
      add (lbl_username);
      add (lbl_password);
      add (username);
      add (password);
      
      btnLogin.setBounds (360, 145, 100, 20);     //set component bounds (only needed by Absolute Positioning)
      lbl_username.setBounds (95, 80, 100, 25);
      lbl_password.setBounds (95, 110, 100, 25);
      username.setBounds (195, 80, 265, 25);
      password.setBounds (195, 110, 265, 25);
      
      btnLogin.addActionListener(new ActionListener(){     //handle button action listener
         public void actionPerformed(ActionEvent e){
            boolean status=false;
            if(!username.getText().equals("") && !password.getText().equals("")) 
               status = log.doLogin(username.getText(), password.getText());
            if(status){
               //call method
               JOptionPane.showMessageDialog(frame, "You have successfully logged in!");
               frame.getContentPane().removeAll();
               frame.getContentPane().add (new MainPanel());             
               frame.pack();
               frame.setLocationRelativeTo ( null );
               frame.setVisible (true);
            }       
         }  
      });
   }
}


class MainPanel extends JPanel {
    private JLabel jcomp1;
    private JButton btn_newPatient;
    private JButton btn_previousdata;
    private JFrame frame2;
    private JTabbedPane frame3;

    public MainPanel() {
        this.frame2 = frame2;
        jcomp1 = new JLabel ("VETERINARY REGISTRATION SYSTEM");     //construct components
        btn_newPatient = new JButton ("New Patient");
        btn_previousdata = new JButton ("Previous Records");
                       
        setPreferredSize (new Dimension (624, 335));     //adjust size and set layout
        setLayout (null);
        
        add (jcomp1);          //add components
        add (btn_newPatient);
        add (btn_previousdata);

        jcomp1.setBounds (195, 30, 245, 60);          //set component bounds
        btn_newPatient.setBounds (150, 115, 110, 85);
        btn_previousdata.setBounds (310, 115, 155, 85);
        
        btn_newPatient.addActionListener(new ActionListener(){ //handle btn_newPatient action listener 
           public void actionPerformed(ActionEvent e)
           {    
            JFrame frame2 = new JFrame("New Registration");
            frame2.getContentPane().removeAll();
            frame2.getContentPane().add (new registerPanel());             
            frame2.pack();
            frame2.setLocationRelativeTo ( null );
            frame2.setVisible (true);        
           }
         });
         
        btn_previousdata.addActionListener(new ActionListener(){ //handle btn_previousdata action listener
        public void actionPerformed(ActionEvent e)
           {   
               JFrame frame3 = new JFrame("Customer History");              
               frame3.getContentPane().removeAll();
               frame3.getContentPane().add (new historyPanel());             
               frame3.pack();
               frame3.setLocationRelativeTo ( null );
               frame3.setVisible (true);
           }
        });
    }  
}

class registerPanel extends JPanel {//implements ActionListener{//, MenuListener, KeyListener {
     private JFrame frame3;
     private JTabbedPane frame4;
     private JTabbedPane pane;
    private JPanel panel1;
     private JButton btnSaveOwner;
     private JLabel lbl_name;
     private JLabel lbl_ic;
     private JLabel lbl_age;
     private JLabel lbl_address;
     private JTextField ownerName;
     private JTextField no_ic;
     private JTextField ownerAge;
     private JTextArea ownerAddress;
    private JPanel panel2;
     private JButton btnSavePet;
     private JLabel lbl_petName;
     private JLabel lbl_type;
     private JLabel lbl_petAge;
     private JLabel lbl_Sfeature;
     private JTextField petName;
     private JTextField type;
     private JTextField petAge;
     private JTextField Sfeature;
     private JFrame frame;
    private JPanel panel3;
     private JButton btnSaveDiagnose;
     private JLabel lbl_disease;
     private JLabel lbl_medicine;
     private JLabel lbl_prescription;
     private JLabel lbl_diagnoseDate;
     private JTextField disease;
     private JTextField medicine;
     private JTextField prescription;
     private JTextField diagnoseDate;
    private JPanel panel4;
     private JButton btnSaveWard;
     private JLabel lbl_needWard;
     private JLabel lbl_wardIn;
     private JLabel lbl_wardNmbr;
     private JLabel lbl_wardOut; 
     private JLabel lbl_total;
     private JTextField needWard; 
     private JTextField wardIn;
     private JTextField wardNmbr; 
     private JTextField wardOut;
     private JTextField total;
    private JPanel panel5;
     private JButton btnSaveAll;
     private JLabel lbl_output;
     Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
     private JScrollPane jsp;
     
     String output="";
     String filePath;
    

    public registerPanel() {
        this.frame4 = frame4;
        setPreferredSize (new Dimension (624, 335));
        
        pane = new JTabbedPane();
        pane.setBounds (10, 10, 600, 300);
		  add(pane);
        
        //1st tab
        panel1 = new JPanel(new BorderLayout());
        setLayout(new BorderLayout());

         //create components
         lbl_name = new JLabel ("Full Name:");
         lbl_ic = new JLabel ("IC Number:");
         lbl_age = new JLabel ("Age:");
         lbl_address = new JLabel ("Address:");
         ownerName = new JTextField (5);
         no_ic = new JTextField (5);
         ownerAge = new JTextField (5);
         ownerAddress = new JTextArea (5, 20);
         JLabel nulls1 = new JLabel("");
         
         btnSaveOwner = new JButton ("Save");
         btnSaveOwner.addActionListener(new ActionListener(){  //handle button
               public void actionPerformed(ActionEvent e){
                     printOwner();
                     JOptionPane.showMessageDialog(frame, "Owner Profile updated.");
               }       
         });
            
            btnSaveOwner.setBounds (360, 215, 100, 20); //bounds setting
             lbl_name.setBounds (95, 50, 100, 25);
             lbl_ic.setBounds (95, 80, 100, 25);
             lbl_age.setBounds (95, 110, 100, 25);
             lbl_address.setBounds (95, 140, 100, 25);
             ownerName.setBounds (195, 50, 265, 25);
             no_ic.setBounds (195, 80, 265, 25);
             ownerAge.setBounds (195, 110, 265, 25);
             ownerAddress.setBounds (195, 140, 265, 55);
             nulls1.setBounds (195, 150, 105, 25);
             
             //add components
             panel1.add(ownerName, BorderLayout.CENTER);
             panel1.add(lbl_name, BorderLayout.CENTER);
             
             panel1.add(lbl_ic, BorderLayout.CENTER);
             panel1.add(no_ic, BorderLayout.CENTER);
             panel1.add(lbl_age, BorderLayout.CENTER);
             panel1.add(ownerAge, BorderLayout.CENTER);
             panel1.add(lbl_address, BorderLayout.CENTER);
             panel1.add(ownerAddress, BorderLayout.CENTER);
             panel1.add(nulls1, BorderLayout.CENTER);
             panel1.add(btnSaveOwner, BorderLayout.SOUTH);
             pane.addTab("Owner Details", panel1); //tab 1 title
                                            
        //2nd Tab
        panel2 = new JPanel (new BorderLayout());
         btnSavePet = new JButton ("Save"); //create components
         lbl_petName = new JLabel ("Pet's Name:");
         lbl_type = new JLabel ("Type of Animal:");
         lbl_petAge = new JLabel ("Pet's Age:");
         lbl_Sfeature = new JLabel ("Special Feature:");
         petName = new JTextField (20);
         type = new JTextField (15);
         petAge = new JTextField (15);
         Sfeature = new JTextField (15);
         JLabel nulls2 = new JLabel("");
         
          btnSavePet.setBounds (360, 215, 100, 20); //bounds setting
           lbl_petName.setBounds (95, 50, 100, 25);
           lbl_type.setBounds (95, 80, 100, 25);
           lbl_petAge.setBounds (95, 110, 100, 25);
           lbl_Sfeature.setBounds (95, 140, 100, 25);
           petName.setBounds (195, 50, 265, 25);
           type.setBounds (195, 80, 265, 25);
           petAge.setBounds (195, 110, 265, 25);
           Sfeature.setBounds (195, 140, 265, 25);
           nulls2.setBounds (195, 150, 105, 25);
           
          panel2.add(lbl_petName, BorderLayout.CENTER);
             panel2.add(petName, BorderLayout.CENTER);
             panel2.add(lbl_type, BorderLayout.CENTER);
             panel2.add(type, BorderLayout.CENTER);
             panel2.add(lbl_petAge, BorderLayout.CENTER);
             panel2.add(petAge, BorderLayout.CENTER);
             panel2.add(lbl_Sfeature, BorderLayout.CENTER);
             panel2.add(Sfeature, BorderLayout.CENTER);
             panel2.add(nulls2, BorderLayout.CENTER);
             panel2.add(btnSavePet, BorderLayout.SOUTH); 
         
          btnSavePet.addActionListener(new ActionListener(){ //handle button 
              public void actionPerformed(ActionEvent e){
                  printPet();
                  JOptionPane.showMessageDialog(frame, "Pet Profile updated.");
                  }       
          });
          
          pane.addTab("Pet Details", panel2); //tab 2 title
          
     
        //3rd tab
        panel3 = new JPanel (new BorderLayout());
         btnSaveDiagnose = new JButton ("Save");
         lbl_diagnoseDate = new JLabel ("Diagnose Date:");
         lbl_disease = new JLabel ("Disease:");
         lbl_medicine = new JLabel ("Medicine:");
         lbl_prescription = new JLabel ("Prescription:");
         diagnoseDate = new JTextField (25);
         disease = new JTextField (25);
         medicine = new JTextField (25);
         prescription = new JTextField (25);
         JLabel nulls3 = new JLabel("");
         
          btnSaveDiagnose.setBounds (360, 215, 100, 20); //bounds setting
           lbl_disease.setBounds (95, 50, 100, 25);
           lbl_medicine.setBounds (95, 80, 100, 25);
           lbl_prescription.setBounds (95, 110, 100, 25);
           lbl_diagnoseDate.setBounds (95, 140, 100, 25);
           diagnoseDate.setBounds (195, 140, 265, 25);
           disease.setBounds (195, 50, 265, 25);
           medicine.setBounds (195, 80, 265, 25);
           prescription.setBounds (195, 110, 265, 25);
           nulls3.setBounds (195, 150, 105, 25);
           
           panel3.add(lbl_diagnoseDate, BorderLayout.CENTER);
           panel3.add(diagnoseDate, BorderLayout.CENTER);
           panel3.add(lbl_disease, BorderLayout.CENTER);
           panel3.add(disease, BorderLayout.CENTER);
           panel3.add(lbl_medicine, BorderLayout.CENTER);
           panel3.add(medicine, BorderLayout.CENTER);
           panel3.add(lbl_prescription, BorderLayout.CENTER);
           panel3.add(prescription, BorderLayout.CENTER);
           panel3.add(nulls3, BorderLayout.CENTER);
           panel3.add(btnSaveDiagnose, BorderLayout.SOUTH);
              
          btnSaveDiagnose.addActionListener(new ActionListener(){ //handle button 
              public void actionPerformed(ActionEvent e){
                  printDiagnose();
                  JOptionPane.showMessageDialog(frame, "Diagnosis updated.");
                  }       
          });
          
        pane.addTab("Diagnosis", panel3); //tab 3 title
          
          
        //4th tab
        panel4 = new JPanel(new BorderLayout());
         btnSaveWard = new JButton ("Save");
         lbl_needWard = new JLabel ("Need to warded?");
         lbl_wardIn = new JLabel ("Warded Date:");
         lbl_wardNmbr = new JLabel ("Ward Number:");
         lbl_wardOut = new JLabel ("Discharge Date:");
         lbl_total = new JLabel ("Total Cost:");
         needWard = new JTextField (3);
         wardIn = new JTextField (15);
         wardNmbr = new JTextField (10);
         wardOut = new JTextField (15);
         total = new JTextField (5);
         JLabel nulls4 = new JLabel("");
          
         lbl_needWard.setBounds (95, 50, 100, 25);
         lbl_wardIn.setBounds (95, 80, 100, 25);
         lbl_wardNmbr.setBounds (95, 110, 100, 25);
         lbl_wardOut.setBounds (95, 140, 100, 25);
         lbl_total.setBounds (95, 170, 100, 25); 
         needWard.setBounds (195, 50, 265, 25);
         wardIn.setBounds (195, 80, 265, 25);
         wardNmbr.setBounds (195, 110, 265, 25);
         wardOut.setBounds (195, 140, 265, 25);
         total.setBounds (195, 170, 265, 25);
         nulls4.setBounds (195, 180, 105, 25);
          
         panel4.add(lbl_needWard, BorderLayout.CENTER); 
         panel4.add(needWard, BorderLayout.CENTER);
         panel4.add(lbl_wardIn, BorderLayout.CENTER);
         panel4.add(wardIn, BorderLayout.CENTER);
         panel4.add(lbl_wardNmbr, BorderLayout.CENTER);
         panel4.add(wardNmbr, BorderLayout.CENTER);
         panel4.add(lbl_wardOut, BorderLayout.CENTER);
         panel4.add(wardOut, BorderLayout.CENTER);
         panel4.add(lbl_total, BorderLayout.CENTER);
         panel4.add(total, BorderLayout.CENTER);
         panel4.add(nulls4, BorderLayout.CENTER);
         panel4.add(btnSaveWard, BorderLayout.SOUTH);
         
         btnSaveWard.addActionListener(new ActionListener(){ //handle button 
              public void actionPerformed(ActionEvent e){
                  printWard();
                  JOptionPane.showMessageDialog(frame, "Ward Details updated.");
                  }       
          }); 
        pane.addTab("Ward",panel4); //tab 4 title
        
        //5th tab
        panel5 = new JPanel (new BorderLayout());
        
         lbl_output = new JLabel("Output");
         lbl_output.setBorder(border);
         lbl_output.setVerticalAlignment(JLabel.TOP);
         jsp = new JScrollPane();
         JLabel nulls5 = new JLabel("");
         btnSaveAll = new JButton("Keep Record");

         jsp.setPreferredSize(new Dimension(510,220));
         panel5.add(lbl_output, BorderLayout.NORTH);
         panel5.add(jsp, BorderLayout.CENTER);
         panel5.add(nulls5, BorderLayout.CENTER);
         panel5.add(btnSaveAll, BorderLayout.SOUTH);
         
         btnSaveAll.addActionListener(new ActionListener(){ //handle button 
              public void actionPerformed(ActionEvent e){
                  writeInput();
                  }       
         });
        
        pane.addTab("View Data",panel5); //tab 5 title

    }
    
    public boolean printOwner(){
      output = "<html>"; 
      output += "Name: " + ownerName.getText() + "<br>";
      output += "IC: " + no_ic.getText() + "<br>";
      output += "Age: " + ownerAge.getText() + "<br>";
      output += "Address: " + ownerAddress.getText() + "<br>";
      output += "</html>";          
      lbl_output.setText(output);
      panel5.add(jsp);
      return true;
    }
    
    public boolean printPet(){
      output = "<html>"; 
      output += "Pet Name: " + petName.getText() + "<br>";
      output += "Animal Type: " + type.getText() + "<br>";
      output += "Pet Age: " + petAge.getText() + "<br>";
      output += "Special Feature: " + Sfeature.getText() + "<br>";
      output += "</html>";          
      lbl_output.setText(output);
      panel5.add(jsp);
      return true;
    }
    
    public boolean printDiagnose(){
      output = "<html>"; 
      output += "Disease: " + disease.getText() + "<br>";
      output += "Medicine: " + medicine.getText() + "<br>";
      output += "Prescription: " + prescription.getText() + "<br>";
      output += "Diagnose Date: " + diagnoseDate.getText() + "<br>";
      output += "</html>";          
      lbl_output.setText(output);
      panel5.add(jsp);
      return true;
    }
    
    public boolean printWard(){
      output = "<html>"; 
      output += "Pet Need to Warded? " + needWard.getText() + "<br>";
      output += "Warded Date: " + wardIn.getText() + "<br>";
      output += "Ward Number: " + wardNmbr.getText() + "<br>";
      output += "Discharge Date: " + wardOut.getText() + "<br>";
      output += "Total Treatment Cost: " + total.getText() + "<br>";
      output += "</html>";          
      lbl_output.setText(output);
      panel5.add(jsp);
      return true;
    }
    
    public void writeInput(){
         filePath = JOptionPane.showInputDialog("Data will be saved in a .txt file." +
                                                "\nPlease enter the file's name:");
         File file = new File(filePath+".txt");
         FileWriter fr = null;
		   BufferedWriter br = null;
		   PrintWriter pr = null;
         JFrame f= new JFrame();
         
         try {
            if(ownerName.getText().isEmpty() || no_ic.getText().isEmpty() || ownerAge.getText().isEmpty()|| ownerAddress.getText().isEmpty()|| 
            petName.getText().isEmpty()  || type.getText().isEmpty()|| petAge.getText().isEmpty()|| Sfeature.getText().isEmpty()||
            disease.getText().isEmpty()|| diagnoseDate.getText().isEmpty()|| medicine.getText().isEmpty()|| filePath.equals("")||
            prescription.getText().isEmpty() || total.getText().isEmpty()|| wardNmbr.getText().isEmpty()||
            needWard.getText().isEmpty()|| wardIn.getText().isEmpty()|| wardOut.getText().isEmpty()){
            throw new Exception();
            }
         
            String input = "Name: " + ownerName.getText() +"\nIC: " + no_ic.getText() +"\nAge: " + ownerAge.getText() +"\nAddress: " + ownerAddress.getText() +
                           "\nPet Name: " + petName.getText() +"\nType of Animal: " + type.getText() +"\nPet Age: " + petAge.getText() +"\nSpecial feature: " + Sfeature.getText() +
                           "\nDisease: " + disease.getText() +"\nMedicine: " + medicine.getText() +"\nPrescription: " + prescription.getText() +"\nDiagnose Date: " + diagnoseDate.getText() +
                           "\nNeed to warded? " + needWard.getText() +"\nWarded Date: " + wardIn.getText() +"\nWard Number: " + wardNmbr.getText() +"\nDischarge Date: " + wardOut.getText() +
                           "\nTotal Treatment Cost: " + total.getText();
            
            fr = new FileWriter(file,true);
   			br = new BufferedWriter(fr);
   			pr = new PrintWriter(br);
   			pr.println(input);
            JOptionPane.showMessageDialog(f,"Input has been saved");
            
            }  catch (Exception e) {			
                  JOptionPane.showMessageDialog(f,"All Field Must be Filled and file name can not be empty."); 
      		}  finally {
      			   try {
      				   pr.close();
      				   br.close();
      				   fr.close();
      			}  catch (IOException e) {
      				 JOptionPane.showMessageDialog(f,"There is an error."); 
      			}
      		}   
    }
}


class historyPanel extends JPanel{
   private JFrame frame5;
   private JButton btnDisplay;
   private JTextArea lbl_view;//===============================JLabel -> JTextArea
   private JTabbedPane pane2;
   private JPanel panelView;
   private JScrollPane jsp2;
   
   private String reading;//======================== add new global varianble to use in display button and readFile() method
   
   Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
     
     String viewFile="";
     
     public historyPanel() {
        this.frame5 = frame5;
        setPreferredSize (new Dimension (624, 555));
        setLayout(new BorderLayout());

        btnDisplay = new JButton ("Display");
        lbl_view = new JTextArea ("View");
        lbl_view.setBorder(border);
        lbl_view.setEditable(false);//=====================user cannot edit output
        jsp2 = new JScrollPane(lbl_view);
        JLabel nulls6 = new JLabel("");

         jsp2.setPreferredSize(new Dimension(550,300));
         add(lbl_view, BorderLayout.CENTER);
         add(jsp2);
         jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         add(nulls6, BorderLayout.CENTER);
         add(btnDisplay, BorderLayout.SOUTH);
         
        lbl_view.setBounds (20, 15, 580, 500);          //set component bounds
        btnDisplay.setBounds (310, 115, 155, 85);
                
        btnDisplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            reading = JOptionPane.showInputDialog("Please Enter The File's Name ");
               readFile();
            }  
        });
     
     
     }
     
     
     public void readFile(){ /// aADD new method called in display button
       BufferedReader reader;
   	   try {
   			reader = new BufferedReader(new FileReader(reading+".txt"));
   			String line = reader.readLine();
            String output="";
   			while (line != null) {
   				output += line + "\n";
   				// read next line
   				line = reader.readLine();
   			}
            output += "\n";
            lbl_view.setText(output);
   			reader.close();
   		} catch (IOException io) {
   			lbl_view.setText(io.toString());
   		}

    
    }
}

    
      
public class StartLogin{
   static Login log;
   static JFrame frame;   
  
   public static void main(String args[]){ 
      log = new Login();      
      frame = new JFrame ("Veterinary System");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
           
      MainApp app = new MainApp(); 
      boolean logged = log.checkLogin();
      if(!logged){
         frame.getContentPane().add (new LoginPanel(frame, log)); 
         frame.pack();
         frame.setLocationRelativeTo ( null );
         frame.setVisible (true); 
      } 
      else{
         frame.getContentPane().add (new MainPanel()); 
         frame.getContentPane().repaint();
         frame.pack();
         frame.setLocationRelativeTo ( null );
         frame.setVisible (true);     
      }
	
   }
  
}

