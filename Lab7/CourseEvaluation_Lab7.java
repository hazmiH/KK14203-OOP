import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


class panel1 extends JPanel{
   private JLabel header;
   public panel1(){
      	header = new JLabel("Course Evaluation Form");
      	add(header);
   }
}

class panel2 extends JPanel implements ActionListener, ItemListener{
   //list of all UI components for the panel
   JLabel lbl_name;
   JTextField name;
   JLabel lbl_matricNo;
   JTextField matricNo;
   JLabel lbl_code;
   JComboBox<String> code;
   JLabel lbl_rating;
   JLabel lbl_outcome;
   JButton btnSubmit;
   JButton btnClear;
   JCheckBox c1;
   JCheckBox c2;
   JLabel lbl_output; 
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
   
   //global variable  
   String output="";
   String code_selection="";
   String rb_selection="";
   String cb_selection="";
   String filePath="pastRecords.txt";
      
   public panel2(){   
      setLayout(new FlowLayout(FlowLayout.LEFT));     
      
      lbl_name = new JLabel("Name");
      lbl_name.setPreferredSize(new Dimension(150, 20));
      lbl_name.setBorder(border);
      
      add(lbl_name);
      name = new JTextField(20);
      add(name);
      
      //input name will not accept any integer
      name.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
         char c=e.getKeyChar(); 
            if(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_SPACE)) {
                e = e;
            }
           else{
                e.consume();
            }
        }
   });
     
      lbl_matricNo = new JLabel("Matric No.");
      lbl_matricNo.setPreferredSize(new Dimension(150, 20));
      add(lbl_matricNo);
      matricNo = new JTextField(15);
      add(matricNo);   
      
      String[] courses={"[Select]", "KK14203 OOP", "KT14203 CAO", "KT14403 Discrete Structure"};
      
      lbl_code = new JLabel("Course Code");
      lbl_code.setPreferredSize(new Dimension(150, 20));
      add(lbl_code);
      code = new JComboBox<String>(courses);
      add(code); 
      
      //for combo box
      code.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            code_selection = (String) code.getSelectedItem();
         }
      });  
      
      lbl_rating = new JLabel("Rating");
      lbl_rating.setPreferredSize(new Dimension(150, 20));
      add(lbl_rating);
      
      JRadioButton rb1 = new JRadioButton("1");
      rb1.addActionListener(this);
      JRadioButton rb2 = new JRadioButton("2");
      rb2.addActionListener(this);
      JRadioButton rb3 = new JRadioButton("3");
      rb3.addActionListener(this);
      JRadioButton rb4 = new JRadioButton("4");
      rb4.addActionListener(this);
      JRadioButton rb5 = new JRadioButton("5");
      rb5.addActionListener(this);
      add(rb1);
      add(rb2);
      add(rb3);
      add(rb4);
      add(rb5);
      
      //to define button group
      ButtonGroup bg = new ButtonGroup();
      bg.add(rb1);
      bg.add(rb2);
      bg.add(rb3);
      bg.add(rb4);
      bg.add(rb5);
      
      lbl_outcome = new JLabel("Outcome");
      lbl_outcome.setPreferredSize(new Dimension(150, 20));
      add(lbl_outcome);
      
      c1 = new JCheckBox("Basic knowledge");
      c1.addItemListener(this);
      c2 = new JCheckBox("Advanced knowledge");
      c2.addItemListener(this);
      add(c1);
      add(c2);
      
      btnSubmit = new JButton("Submit");
      add(btnSubmit);
      btnClear = new JButton("Clear");
      add(btnClear);
      
      //for 'submit' button
      //to view the input to output label
      //write to file
      btnSubmit.addActionListener(new ActionListener(){           
         public void actionPerformed(ActionEvent e){  
            if(printOutput()){
               writeInput();  
               
               //show dialog message for succesfully saved input
               JOptionPane.showMessageDialog(null, "The data have been saved");
            }   
         }  
      });
      
      //for 'clear' button
      btnClear.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            lbl_output.setText("Output");  
            name.setText("");
            matricNo.setText(""); 
            code.setSelectedIndex(0);
            bg.clearSelection();
            c1.setSelected(false);
            c2.setSelected(false);
         }  
      });
      
      lbl_output = new JLabel("Output");
      lbl_output.setBorder(border);
      lbl_output.setVerticalAlignment(JLabel.TOP);
      
      //to add output label to scrollpane
      jsp = new JScrollPane(lbl_output);
      jsp.setPreferredSize(new Dimension(410,120));
      add(jsp);     
   }

   //for radio button selection
   public void actionPerformed(ActionEvent ae) {
      rb_selection = ae.getActionCommand();    	   
   }
   
   //for checkbox
   public void itemStateChanged(ItemEvent ie) {
      JCheckBox check = (JCheckBox)ie.getSource();
      cb_selection += check.getText() + " ";   
   }
   
   //to print output to lbl_output
   public boolean printOutput(){
      output = "<html>";
      output += "Thank you for your evaluation<br><br>"; 
      output += "Name: " + name.getText() + "<br>";
      output += "Matric: " + matricNo.getText() + "<br>";
      
      if(code_selection.equals("[Select]") || code.getSelectedItem().equals("")  || name.getText().equals("") || matricNo.getText().equals("") || rb_selection.equals("") || cb_selection.equals("")){
         JOptionPane.showMessageDialog(null, "Please fill in all of the information.");
         return false;
      }
      
      output += "Course: " + code_selection + "<br>";
      output += "Rating: " + rb_selection + "<br>";
      output += "Outcome: " + cb_selection + "<br>";
      output += "</html>";          
      lbl_output.setText(output);
      jsp.getViewport().revalidate();
      return true;
    }
    
    //to write to file
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
      
      String input = name.getText() + ", " + matricNo.getText() + ", " + code_selection + ", " + rb_selection + ", " + cb_selection;
      
      //exception implementation
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(input);
		} catch (IOException e) {			
         lbl_output.setText(e.toString());
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				lbl_output.setText(e.toString());
			}
		}
    }
}

class MenuActionListener implements ActionListener {
   panel2 p2;
   public MenuActionListener(panel2 p){
      p2 = p;
}
    
   public void actionPerformed(ActionEvent e) {      
      BufferedReader reader;
	   try {
			reader = new BufferedReader(new FileReader(p2.filePath));
			String line = reader.readLine();
         String output="<html>";
			while (line != null) {
				output += line + "<br>";
				line = reader.readLine();
			}
         output += "<br>";
         p2.lbl_output.setText(output);
			reader.close();
		} catch (IOException io) {
			p2.lbl_output.setText(io.toString());
		}
  }
}

class MenuActionListener2 implements ActionListener {
   panel2 p2;
   public MenuActionListener2(panel2 p){
      p2 = p;
}
    
   public void actionPerformed(ActionEvent e) {   
      
      //to show confirm dialog to exit application
      int response = JOptionPane.showConfirmDialog(null,"Do you really want to exit? ", 
     "Yes",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

     if (response == JOptionPane.YES_OPTION)
     {
        System.exit(0);
     } 
  }
}

public class CourseEvaluation_Lab7 {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Evaluation");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      panel1 p1 = new 	panel1();
      panel2 p2 = new panel2();
      
      JMenuBar mb = new JMenuBar(); 
     
      JMenu x = new JMenu("Menu"); 
      
      JMenuItem m1 = new JMenuItem("Load Data"); 
      m1.addActionListener(new MenuActionListener(p2));
      
      JMenuItem m2 = new JMenuItem("Exit");
      m2.addActionListener(new MenuActionListener2(p2));
 
      x.add(m1); 
      x.add(m2);
     
      mb.add(x); 
      f.setJMenuBar(mb);  
                   
      f.add(p1,BorderLayout.NORTH);
      f.add(p2, BorderLayout.CENTER);
      f.setSize(460,400);
      f.setVisible(true);
   }  
}