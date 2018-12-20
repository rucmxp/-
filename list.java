package lizi;

public class list {
		    public Object[] listElem;//线性表存储空间
		    private int curlen; //定义线性表当前长度
		    public list(int initSize){ //构造一个长度为initSize的线性表
		        curlen = 0;
		        listElem = new Object[initSize];
		    }
		    public Object get(int i) throws Exception {
		        //判断 i 是否合法
		        if(i > 0 || i > curlen -1)
		            throw new Exception("第"+i+"个元素不存在");
		        return listElem[i];
		    }
		    //插入操作，插入的元素之后的元素位置向后加一
		    public void insert(int i, Object x) throws Exception {
		        if(curlen == listElem.length)
		            throw new Exception("顺序表已经满了");
		        if(i < 0 || i > curlen)
		            throw new Exception("插入位置不合法");
		        for(int j = curlen; j > i; j--)
		            listElem[j] = listElem[j - 1];
		        listElem[i] = x;
		        //插入成功后，表长度+1
		        curlen++;
		    }
		    //删除操作，删除的元素之后元素提前一个位置
		    public void remove(int i) throws Exception {
		        if(i < 0 || i > curlen - 1)
		            throw new Exception("删除位置不合法");
		        //下标移动删除第i处
		        for(int j = i; j < curlen - 1; j++)
		            listElem[j] = listElem[j++];
		        curlen--;
		    }
		    //删除相同元素，采用方法是先逐个查找相同元素，再把相同的元素覆盖掉，后面元素前移
		    public void delete(int i)throws Exception{
		    	 if(i < 0 || i > curlen - 1)
			            throw new Exception("删除位置不合法");
		    	 int m = listElem.length;
		    	 for(int j=0;j<m;j++) {
		    		 for(int k=j;k<m;k++) {
		    		 if(listElem[j]==listElem[k]) {
		    			m--;
		    			 for(int l=k;l<m;l++) {
		    				 listElem[l]=listElem[l++];
		    		 }
		    	 }
		    		 }
		    	 } 
		    	 }
		    //查找操作，找到则返回下标，否则返回-1
		    public int Indexof(Object x) {
		        int j = 0;
		        //逐个查找元素
		        while(j < curlen && !listElem[j].equals(x))
		            j++;
		        if(j < curlen)
		            return j;
		        else 
		            return -1;
		    }
		    //显示操作
		    public void display() {
		        //显示线性表各元素
		        for(int i = 0; i < curlen; i++)
		            System.out.println(listElem[i]);
		    }
		    //主函数
		    public static void main(String[] args) throws Exception{
		        //将1、3、5、7、9插入线性表中
		        list mylist = new list(10);
		        mylist.insert(0, "1");
		        mylist.insert(1, "3");
		        mylist.insert(2, "5");
		        mylist.insert(3, "7");
		        mylist.insert(4, "9");
		        int place = mylist.Indexof("3");//x在此处输入查找的线性表元素,这里以3为例
		        if(place  != -1)
		            System.out.println("顺序表中第一次出现'3'的位置是:"+ place );
		        else 
		            System.out.println("顺序表不存在元素'x'");
		        mylist.insert(3,6);//插入操作
		        mylist.remove(3);//删除操作
		        mylist.delete(4);//删除相同元素
		        mylist.display();//显示操作
		    }
		}




