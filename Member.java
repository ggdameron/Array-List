
public class Member implements hasKey {
	
	private String name;

	private final int MAX_BOOKS = 3;
	
	private arrayList<Book> checkedOut;
	
	private int memberId;
	
	public Member(){
		
		checkedOut = new arrayList<Book>(Book.class);
		
		memberId = 0;
		
		name = "";
		
		
		
	}
	
	public Member(String n, int i){
		
		memberId = i;
		
		name = n;
		
		checkedOut = new arrayList<Book>( Book.class); 
		
		
	}
	
	
	public boolean checkout(Book b){
		
		boolean result = true;
		
		if(checkedOut.lengthIs() == MAX_BOOKS){
		
			result = false;
			
		}
		else{
			checkedOut.addItem(b);
			
			
		}
		
		return result;	
			
	}
	
	
	public boolean returnBook(Book b){
		
		boolean result;
		result = checkedOut.removeItem(b);
		
		
		return result;
	}

	public boolean equals(Member m){
		
		boolean result = false;
		
		if(m.getKey() == memberId){
		
			result = true;
		}
		return result;
	}
	
	public void printCheckedOut(){
		
		System.out.println(checkedOut.toString());
		
	}
	
	public String toString(){
		String result = new String();
		
		result += name + "\n" + memberId;
		
		return result;
		
	}
	
	
	public int getKey(){
		return memberId;
	}
	
}


