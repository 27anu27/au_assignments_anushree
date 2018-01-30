package LinkedHashedMap;
public class LHM<K,V> {
	private Node<K,V>[] table;
	private int capacity = 4;
	private Node<K,V> header, last;	
	
	
	@SuppressWarnings("unchecked")
	public LHM(){
		table = new Node[capacity];
	}
	
	
	public void put(K key,V value) {
		if(key == null) return;
		
		int hash = hash(key);
		
		Node<K,V> newNode = new Node<K,V>(key,value,null);
		
		maintainOrderingAfterInsert(newNode);       
	    if(table[hash] == null){
	    	table[hash] = newNode;
	    }
	    else{
	    	Node<K,V> previous = null;
	        Node<K,V> current = table[hash];
	        while(current != null){ 
	        	if(current.key.equals(key)){                  
	               if(previous==null){  
	                     newNode.next=current.next;
	                     table[hash]=newNode;
	                     return;
	               }
	               else{
	                   newNode.next=current.next;
	                   previous.next=newNode;
	                   return;
	               }
	           }
	        	previous=current;
	            current = current.next;
	         }
	        previous.next = newNode;
	    }
	}
	private void maintainOrderingAfterInsert(Node<K, V> newNode) {
		  if(header==null){
	           header=newNode;
	           last=newNode;
	           return;
	       }
	      
	       if(header.key.equals(newNode.key)){
	           deleteFirst();
	           insertFirst(newNode);
	           return;
	       }
	      
	       if(last.key.equals(newNode.key)){
	           deleteLast();
	           insertLast(newNode);
	           return;
	       }
	      
	       Node<K, V> beforeDeleteEntry=    deleteSpecificEntry(newNode);
	       if(beforeDeleteEntry==null){
	           insertLast(newNode);
	       }
	       else{
	           insertAfter(beforeDeleteEntry,newNode);
	       }
		
	}
	
	private void maintainOrderingAfterDeletion(Node<K,V> deleteNode) {
		if(header.key.equals(deleteNode.key)){
	           deleteFirst();
	           return;
	       }
	      
	       if(last.key.equals(deleteNode.key)){
	           deleteLast();
	           return;
	       }
	      
	       deleteSpecificEntry(deleteNode);
	}


	private void insertAfter(Node<K, V> beforeDeleteEntry, Node<K, V> newNode) {
		 Node<K, V> current=header;
         while(current!=beforeDeleteEntry){
                current=current.after;  //move to next node.
         }
         
         newNode.after=beforeDeleteEntry.after;
         beforeDeleteEntry.after.before=newNode;
         newNode.before=beforeDeleteEntry;
         beforeDeleteEntry.after=newNode;
		
	}


	private Node<K, V> deleteSpecificEntry(Node<K, V> newNode) {
        Node<K, V> current=header;
        while(!current.key.equals(newNode.key)){
               if(current.after==null){   //entry not found
                     return null;
               }
               current=current.after;  //move to next node.
        }
        
        Node<K, V> beforeDeleteEntry=current.before;
        current.before.after=current.after;
        current.after.before=current.before;  //entry deleted
        return beforeDeleteEntry;
	}


	private void insertLast(Node<K, V> newNode) {
	     if(header==null){
             header=newNode;
             last=newNode;
             return;
      }
      last.after=newNode;
      newNode.before=last;
      last=newNode;
		
	}


	private void deleteLast() {
		   if(header==last){
               header=last=null;
               return;
        }
        
        last=last.before;
        last.after=null;
		
	}


	private void insertFirst(Node<K, V> newNode) {
		if(header==null){ //no entry found
            header=newNode;
            last=newNode;
            return;
     }
     
     newNode.after=header;
     header.before=newNode;
     header=newNode;
		
	}


	private void deleteFirst() {
	     if(header==last){ 
             header=last=null;
             return;
      }
      header=header.after;
      header.before=null;
		
	}


	private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }


	 public V get(K key){
	        int hash = hash(key);
	        if(table[hash] == null){
	        	return null;
	        }
	        else{
	         Node<K,V> temp = table[hash];
	         while(temp!= null){
	             if(temp.key.equals(key))
	                 return temp.value;
	             temp = temp.next; 
	         }         
	         return null; 
	        }
	}
	 
	 public void display(){
	       
	       Node<K, V> currentNode=header;
	       while(currentNode!=null){
	           System.out.print("{"+currentNode.key+"="+currentNode.value+"}" +" ");
	           currentNode=currentNode.after;
	       }
	    
	    }
	 public boolean remove(K deleteKey){
	       
	       int hash=hash(deleteKey);
	              
	      if(table[hash] == null){
	            return false;
	      }else{
	       Node<K,V> previous = null;
	       Node<K,V> current = table[hash];
	        
	        while(current != null){ 
	           if(current.key.equals(deleteKey)){
	               maintainOrderingAfterDeletion(current);
	               if(previous==null){ 
	                     table[hash]=table[hash].next;
	                     return true;
	               }
	               else{
	                   previous.next=current.next;
	                   return true;
	               }
	           }
	           previous=current;
	             current = current.next;
	          }
	        return false;
	      }
	    
	    }
}
