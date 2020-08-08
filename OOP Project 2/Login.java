class Login{
   private boolean LOGGED = false;
   private int attempt=0;

   //constructor
   public Login(){
      
   }   
   
   public boolean checkLogin(){
      if(LOGGED){
         return true;
      }      
      return false;      
   }
   
   public boolean doLogin(String username, String password){
      if(attempt<=4){
         //TO_DO: check from db/file login list
         //to check whether username and password in the file
         return true;      
      }
      return false;       
   }
   
   public int getAttempt(){
      return attempt;
   }
}