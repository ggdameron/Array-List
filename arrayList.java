import java.lang.reflect.Array;


public class arrayList <E extends hasKey> {
	
	private final int DEFCAP = 50;
	
	private int origCap;
	
	private int numElements;
	
	private E[] list;
	
	private Class<E> elementType;
	
	public arrayList(Class<E> et){
		
		elementType = et;
		origCap =5;
		list = (E[]) Array.newInstance(et, 5);
		
		
	}
	
	public arrayList(Class<E> et, int size)throws Exception{
		if(size > DEFCAP){
			new Exception("Index out of Range");
			
		}
		else{
		elementType = et;
		
		list = (E[]) Array.newInstance(et, size);
		}
		
	}
	
	public void addItem(E item){
		
		if(numElements == list.length){
			enlarge();
		}
		
		list[numElements] = item;
		
		numElements ++;
	}
	
	public boolean removeItem(E item){
		
		boolean result = false;
		
		int pos;
		
		
		if(findItem(item) != -1){
		pos = findItem(item);
		
		list[pos] = list[numElements-1];
		
		numElements --;
		
		result = true;
		
		}
		
		return result;
	}
	
	public int findItem(E Item){
		int pos = -1;
		
		for(int x =0; x< numElements; x++){
			
			if (list[x].getKey() == Item.getKey()){
				
				pos = x;
				
			}
			
		}
		
		return pos;
		
	}
	
	public boolean validateInput(int ID){
		
		boolean result = false;
		
		for(int x = 0; x < list.length; x++){
			if(list[x].getKey() == ID){
				result = true;
			}
			
		}
		
		
		return result;
	}
	
	public int findItemByKey(int key){
		
		int pos = -1;
		
		for(int x = 0; x < list.length; x++){
			if(list[x].getKey() == key){
				pos = x;	
			}
		}
		
		return pos;
		
	}
	
	public boolean isEmpty(){
	
		boolean result = false;
		
		if(numElements == 0){
			result = true;
			
		}
		
		return result;
		
	}
	
	public int lengthIs(){
	
		return numElements;
		
	}
	
	public void clear(){
		
		numElements = 0;
		
	}
	
	public E get(int index) throws Exception{
		
		E result = list[index];
		
		if(index > numElements){
			throw new Exception("Index out of Range");
		}
		
		return result;
		
	}
	
	
	@Override
	public String toString(){
		
		String result = new String();
		
		for(int x = 0; x < numElements; x++){
		result += list[x].toString() + '\n' + "\n";
		}
		
		
		return result;
	}
	
	private void enlarge(){
		
		
		if(list.length+origCap < DEFCAP){
			
			E[] larger = (E[]) Array.newInstance( elementType , list.length+origCap);
		
			for(int x = 0; x <list.length; x++){
				
				larger[x] = list[x];	
				
			}
			
			list = larger;
			
		}
	}
	
	
}
