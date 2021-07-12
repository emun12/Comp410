package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
      */
    test1();
    test2();

  }
  
  public static void test1(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    System.out.println(L.isEmpty());
    printList(L);
  
    bPrintList(L);
    L.clear();
    System.out.println(L.isEmpty());
    printList(L);
    bPrintList(L);
   
    L.insert(3.3,0);
    System.out.println(L.size());
    printList(L);
     bPrintList(L);
    System.out.println(L.isEmpty());
    printList(L);
    bPrintList(L);
    L.insert(1, 0);
    System.out.println(L.size());
    printList(L);
    bPrintList(L);
    L.insert(2, 0);
    System.out.println(L.size());
    printList(L);
     bPrintList(L);
    L.insert(3, 1);
    System.out.println(L.size());
    printList(L);
     bPrintList(L);
    L.insert(4, 0);
    System.out.println(L.size());
    printList(L);
    bPrintList(L);
    L.insert(5, 4);
    System.out.println(L.size());
    printList(L);
     bPrintList(L);
    L.remove(3);
    System.out.println(L.size());
    printList(L);
    bPrintList(L);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
   bPrintList(L);
    L.remove(1);
    System.out.println(L.size());
    printList(L);
     bPrintList(L);
   L.clear();
   L.insort(14);
   printList(L);
   L.insort(21);
   printList(L);
   L.insort(5);
   printList(L);
   L.insort(17);
   printList(L);
   L.insort(67);
   
//    L.insert(3.4, 0);
//    L.insert(3.5, 0);
//    L.insert(3.67, 1);
//    L.insert(3.357, 0);
//    L.insert(3.333, 3);
//    L.remove(0);
//    System.out.println(L.size());
//    printList(L);
  }

  public static void test2(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    L.insert(3.4,0);
    L.insert(3.5,1);
    L.insert(3.67,2);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }
  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    Node curr=L.headCell; // the first data node in the list... might be null
    System.out.print("List: ");
    for(int i=0; i<L.size(); i++) { 
      System.out.print(" --> " + curr.data);
      curr=curr.next;
    }
    System.out.println();
  }
  
  public static void bPrintList(LinkedListImpl L){ 
	    //note that this is a good example of how to iterate through your linked list
	    // since we know how many elements are in the list we can use a for loop
	    Node curr=L.lastCell; // the first data node in the list... might be null
	    System.out.print("List: ");
	    for(int i=0; i<L.size(); i++) { 
	      System.out.print(" --> " + curr.data);
	      curr=curr.prev;
	    }
	    System.out.println();
	  }
}