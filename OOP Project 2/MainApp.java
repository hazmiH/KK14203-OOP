import java.util.Scanner;

public class MainApp{
   static Login log;
   static String username;
   static String password;
   
   public void runApp(){
      System.out.println("Welcome to Vet Registration System");      
      System.out.println("Menu:");  
      System.out.println("1. Menu 1");
      System.out.println("2. Menu 2");
   }
   
   public boolean loginInput(){
      Scanner input = new Scanner(System.in);
      System.out.print("Enter username: ");
    	username = input.next();
    	System.out.print("Enter password: ");  
      password = input.next();
      boolean status = log.doLogin(username,password);
      
      //limit login attempt
      while(!status && log.getAttempt()<=4){
         status = log.doLogin(username,password);   
      }   
      return status;
   }
   
   public void loginMessage(){
      System.out.println("Login or Register or Forget Password.");
   }
   
   public boolean loginStatus(){
      boolean status = log.checkLogin();
      return status;   
   } 
      
   public static void main(String args[]){
      //login 
      log = new Login();
      MainApp app = new MainApp();
           
      boolean logged = log.checkLogin();
      
      if(!logged)
         if(app.loginInput())
            app.runApp(); 
         else
            app.loginMessage();  
      else
         app.loginMessage();   
   }
}