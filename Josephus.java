package lizi;
import lizi.Josephus.Node;
public class Josephus {
	//定义一个节点类
		    static class Node{
		        int val;
		        Node next;   
		        Node(int v){
		            val=v;
		            }        
		    }
		    public static void main(String[] args) {
		        int N=41;//表示总人数
		        int M=3;//数到3的人出列
		        Node t=new Node(1);//定义头节点，方便形成循环链表
		        Node x=t;
		        for(int i=2;i<=N;i++)
		        	x=(x.next=new Node(i));//建立单向链表
		        x.next=t;//最后一个节点的next指向第一个节点，形成循环链表
		        System.out.println("出列的人死亡序号依次为：");
		        while(x!=x.next.next){//判断条件为第一个与第三个不相等，若相等，即只剩2个人，则退出循环
		            for(int i=1;i<M;i++) 
		                x=x.next;
		                       //此时x是将出列的节点的前一个节点
		            System.out.print(x.next.val+" ");//打印出列的人序号	
		            x.next=x.next.next;//删除死亡的人
		        }
		        
		        System.out.println();
		        System.out.println("存活的人序号为 "+x.next.val+" 和 "+x.val);  //打印存活的2人  
		        }
		          
		       
		    }
		