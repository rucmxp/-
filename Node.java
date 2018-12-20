
package lizi;
public class Node {
	
    public int data;

    public Node next;
    
    public Node(int data){
        this.data = data; this.next=null;
    }
    public void addNode(Node node){
 
        Node temp = this;   
        while(temp.next != null){  
            temp = temp.next;        
        }
        temp.next = node;    
    }
    public int insert(int index){
    	Node a=new Node(index);
        Node temp = this;        
        while(temp.next != null){     
                temp = temp.next;                
               
            }
             temp.next=a;
             return index;
        }
    
   
    public Node findByVal(int data) {
        Node first;
		Node current = this;
        while (current.data != data) {
            if (current.next == null)
                return null;
            current = current.next;
        }
        return current;
    }
 
    public void del(int index){
           
        int length=1;
        Node temp = this;
        while(temp.next != null){
            if(index == length++){
              
                temp.next = temp.next.next;    
            }
            temp = temp.next;
        }    
    }
    public int getlen() {
        int length=0;
        Node temp = this;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public void display(){
        Node temp =this.next;
        while(temp != null){
            System.out.print(temp.data+",");
            temp = temp.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node=new Node(0);
		node.insert(1);
		node.insert(2);
		node.insert(3);
		node.insert(4);
		node.insert(5);
		node.display();
		System.out.println(node.findByVal(2).data);
		node.display();
        node.del(3);
		node.display();
		System.out.println(node.getlen());
		
	}

}
