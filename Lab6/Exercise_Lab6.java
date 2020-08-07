import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import javax.swing.JTextArea;

public class Exercise_Lab6 extends JPanel implements ActionListener{
    private JLabel label1;
    private JLabel label2;
    private JButton btnAdd;
    private JTextArea text_area1;
    private JComboBox combo1;
    private JButton btnOrder;
    private JButton btnSave;
    private static Cake cake;
    private static ArrayList<String> the_order;
      
    String txt = " ";
    String input = " ";
    String filePath="data.txt";
     
    public Exercise_Lab6() {
        
        String[] j_combo_items = {"[Select]"};
        label1 = new JLabel ("Cake Menu");
        label2 = new JLabel ("Topping Selection");
        btnAdd = new JButton ("Add Topping");
        btnSave = new JButton ("Save");
        text_area1 = new JTextArea (5, 5);
        JScrollPane scroll_pane1 = new JScrollPane(text_area1);
        combo1 = new JComboBox (j_combo_items);
        btnOrder = new JButton ("Order");
       
        
        btnAdd.addActionListener(this);
        btnOrder.addActionListener(this);
        btnSave.addActionListener(this);

        setPreferredSize (new Dimension (514, 325));
        setLayout (null);

        add (label1);
        add (label2);
        add (btnAdd);
        add (scroll_pane1);
        add (combo1);
        add (btnOrder);
        add (btnSave);

        label1.setBounds (195, 10, 100, 25);
        label2.setBounds (25, 55, 125, 25);
        btnAdd.setBounds (365, 55, 125, 25);
        scroll_pane1.setBounds (25, 120, 465, 180);
        combo1.setBounds (180, 55, 180, 25);
        btnOrder.setBounds (365, 90, 125, 25);
        btnSave.setBounds (220, 90, 125, 25);
    }
    
   public void actionPerformed(ActionEvent ae){
      String command = ae.getActionCommand(); 
      
      if(command.equals("Add Topping")){
         the_order.add(combo1.getSelectedItem().toString());      
         text_area1.append(combo1.getSelectedItem().toString() + "\n");   
      }
      else if(command.equals("Order")){
         String str_order[] = new String[the_order.size()]; 
   
         for (int j = 0; j < the_order.size(); j++) { 
            str_order[j] = the_order.get(j); 
         }
         
         cake.order_cake(str_order, 1, 2);
         txt = cake.print_cake_GUI();
         text_area1.append(txt);
      }   
      
      else if(command.equals("Save")){
          write_input();}
      
   }
    public void write_input(){
         File file = new File(filePath);
         FileWriter stream = null;
         PrintWriter pr = null;
      
         String input = "Order\nTopping: "+ the_order + "\nSize: " + cake.size + "\nQuantity: " + cake.quantity + "\nTotal Price: RM " + cake.get_total_price() + ". \n" ;
      
         try {
            stream = new FileWriter(file, true);
            pr = new PrintWriter(stream);
            pr.print(input);
      } 
         catch (IOException e) {			
            text_area1.append("Sorry, can't save");

      } 
         finally {
            try {
               pr.close();
               stream.close();
         } 
         catch (IOException e) {
              text_area1.append("Sorry, can't save");


        }
      }
   }
     
   public void updateCB(String[] topping){
      for(int i=0; i<topping.length; i++){
         combo1.addItem(topping[i]);
      }      
   }


   public static void main (String[] args) {
      cake = new Cake("Generic");
      the_order = new ArrayList<String>();
      
      JFrame frame = new JFrame ("MyPanel");
      String[] topping = {"Lava Chocolate", "Cream Cheese", "Butter Cream", "Fondant"};
      cake.setCake(topping, 45.00, 65.00, 80.00); 
      
      Exercise_Lab6 capp = new Exercise_Lab6(); 
      capp.updateCB(topping);
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (capp);
      frame.pack();
      frame.setVisible (true);
   }
}