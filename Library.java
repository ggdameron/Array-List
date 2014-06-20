import java.util.Scanner;

public class Library
{
       public static void main(String[] args)
       {

               arrayList<Book> books;
               arrayList<Book> stock;
               arrayList<Member> members;
               Book t = new Book();   //Used for retrieving Class type
               Member m = new Member();
               //Declare other variables to be used
             
               boolean result= true;
               
               int memId;
               
               int bookId;
               
               boolean validate;
               
               int selection = 1;
               //Create new ArrayLists for books, stock, and members
               
               Scanner input = new Scanner(System.in);
               
			//Remember, the constructor for ArrayList that
			//takes a size throws an Exception!

               books = new arrayList<Book>(Book.class);
               stock = new arrayList<Book>(Book.class);
               members = new arrayList<Member>(Member.class);
               
               
               //Populate books ArrayList
               books.addItem(new Book("Ender's Game", "Card, Orson Scott", 812550706));
               books.addItem(new Book("Breakfast of Champions", "Vonnegut, Kurt", 385334206));
               books.addItem(new Book("The Alphabet of Manliness", "Maddox", 80652720));
               books.addItem(new Book("A Condeferacy of Dunces", "Toole, John Kennedy", 141182865));
               books.addItem(new Book("Dune", "Herbert, Frank", 441013597));
               books.addItem(new Book("History of Western Philosophy", "Russell, Bertrand", 415325056));
               books.addItem(new Book("Choke", "Palahniuk, Chuck", 307388921));
               books.addItem(new Book("Me Talk Pretty One Day", "Sedaris, David", 316776963));
               books.addItem(new Book("House of Leaves", "Danielewski, Mark", 375703768));
               books.addItem(new Book("Eats, Shoots, & Leaves", "Truss, Lynne", 1592402038));

               //Populate members ArrayList
               members.addItem(new Member("Parker, Peter", 56754));
               members.addItem(new Member("Spector, Marc", 74686));
               members.addItem(new Member("Curry, Arthur", 71245));
               members.addItem(new Member("Stark, Tony", 96785));
               members.addItem(new Member("Queen, Oliver", 45267));

               //Copy books into stock
               for(int x = 0; x < books.lengthIs(); x++)
               {
                       try
                       {
                               stock.addItem(books.get(x));
                       }
                       catch(Exception e)
                       {
                               System.out.println(e);
                       }
               }

             do{ //Implement Library User Menu
               System.out.print("Library Manager\n1. Check Out\n2. Return\n3. List Stock\n4. List Checked Out\n5. Exit\nSelection: ");
               
             
               
               switch(input.nextInt()){
               case 1:{
            	   selection =1;
            	   
            	   System.out.print(members.toString());
            	   
            	   do{
            		   
            		   System.out.print("\nMember ID: ");
            	   
            		   memId = input.nextInt();
            	   
            		   if(members.validateInput(memId) == true){
            			   validate = true;
            		   }
            		   else{
            			   System.out.println("\nInvalid ID");
            			   validate = false;
            		   }
            			
            	   
            	   
            	   }while(validate != true);
            	   
            	   
            	   
            	   
            	   
            	   System.out.print(books.toString());
            	   
            	   do{
            	   
            	   System.out.print("\nBook ISBN: ");
            	   
            	   bookId = input.nextInt();
            	   
            	   if(books.validateInput(bookId) == true){
            		   validate = true;
            	   }
            	   else{
        			   System.out.println("\nInvalid ISBN");
        			   validate = false;
            	   
            	   }
            	   }while(validate != true);
            	   
            	   
            	   try
            	   {
            		   
            		   
            		  result = (members.get(members.findItemByKey(memId))).checkout(stock.get(stock.findItemByKey(bookId)));
            	   }
            	   catch(Exception e)
            	   {
            		   System.out.println(e);
            		   
            	   }
            	  
            	  if(result == true){
            	   try{
            	   stock.removeItem(stock.get(stock.findItemByKey(bookId)));
            	   }
            	   catch(Exception e){
            		   System.out.println(e);
            		   
            	   }
            	  }
            	  if(result == false){
            		  System.out.println("Error, member has checked out maximum number of books allowed\n");
            	  }
            	  
            	   break;
            	   
               }
               
               case 2:{
            	   selection = 2;
            	   
            	   System.out.println(members.toString());
            	  

            	   do{
            		   
            		   System.out.print("\nMember ID: ");
            	   
            		   memId = input.nextInt();
            	   
            		   if(members.validateInput(memId) == true){
            			   validate = true;
            		   }
            		   else{
            			   System.out.println("\nInvalid ID");
            			   validate = false;
            		   }
            		   
            	   }while(validate != true);
            	 
            	   
            	   
            	   System.out.print(books.toString());
            	   
            	   
            	   
            	   do{
                	   
                	   System.out.print("\nBook ISBN: ");
                	   
                	   bookId = input.nextInt();
                	   
                	   if(books.validateInput(bookId) == true){
                		   validate = true;
                	   }
                	   else{
            			   System.out.println("\nInvalid ISBN");
            			   validate = false;
                	   
                	   }
                	   }while(validate != true);
            	   
            	   
            	   
            	   try{
            		   
            		 result = (members.get(members.findItemByKey(memId))).returnBook(stock.get(stock.findItemByKey(bookId)));
            		  
            	   }
            	   catch(Exception e){
            		   System.out.println(e);
            	   }
               }
               
               if(result == true){
               try{
            	   stock.addItem(books.get(books.findItemByKey(bookId)));
            	   }
            	   catch(Exception e){
            		   System.out.println(e);
            	   }
               }
               if(result == false){
            	   System.out.println("Error, member does not have that book.");
               }
               break;
               
               
               
               case 3:{
            	   selection = 3;
            	   
            	   System.out.println(stock.toString());
            	   break;
               }
               
               case 4:{
            	   
            	   selection = 4;
            	   
            	   System.out.println("\n" +members.toString());
            	   
            	   do{
            		   
            		   System.out.print("\nMember ID: ");
            	   
            		   memId = input.nextInt();
            	   
            		   if(members.validateInput(memId) == true){
            			   validate = true;
            		   }
            		   else{
            			   System.out.println("\nInvalid ID");
            			   validate = false;
            		   }
            			
            	   
            	   
            	   }while(validate != true);
            	   
            	   try{
            	   (members.get(members.findItemByKey(memId))).printCheckedOut();
            	   }
            	   catch(Exception e){
            		   System.out.println(e);
            	   }
            	   break;
            	   
            	   
               }
               
               case 5:{
            	   selection = 5;
            	   
            	   System.out.println("Exiting Library");
            	   
               }
               
               
               
               }
              }while(selection != 5);
               
       }//end main
}//end class
