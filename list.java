package lizi;

public class list {
		    public Object[] listElem;//���Ա�洢�ռ�
		    private int curlen; //�������Ա�ǰ����
		    public list(int initSize){ //����һ������ΪinitSize�����Ա�
		        curlen = 0;
		        listElem = new Object[initSize];
		    }
		    public Object get(int i) throws Exception {
		        //�ж� i �Ƿ�Ϸ�
		        if(i > 0 || i > curlen -1)
		            throw new Exception("��"+i+"��Ԫ�ز�����");
		        return listElem[i];
		    }
		    //��������������Ԫ��֮���Ԫ��λ������һ
		    public void insert(int i, Object x) throws Exception {
		        if(curlen == listElem.length)
		            throw new Exception("˳����Ѿ�����");
		        if(i < 0 || i > curlen)
		            throw new Exception("����λ�ò��Ϸ�");
		        for(int j = curlen; j > i; j--)
		            listElem[j] = listElem[j - 1];
		        listElem[i] = x;
		        //����ɹ��󣬱���+1
		        curlen++;
		    }
		    //ɾ��������ɾ����Ԫ��֮��Ԫ����ǰһ��λ��
		    public void remove(int i) throws Exception {
		        if(i < 0 || i > curlen - 1)
		            throw new Exception("ɾ��λ�ò��Ϸ�");
		        //�±��ƶ�ɾ����i��
		        for(int j = i; j < curlen - 1; j++)
		            listElem[j] = listElem[j++];
		        curlen--;
		    }
		    //ɾ����ͬԪ�أ����÷����������������ͬԪ�أ��ٰ���ͬ��Ԫ�ظ��ǵ�������Ԫ��ǰ��
		    public void delete(int i)throws Exception{
		    	 if(i < 0 || i > curlen - 1)
			            throw new Exception("ɾ��λ�ò��Ϸ�");
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
		    //���Ҳ������ҵ��򷵻��±꣬���򷵻�-1
		    public int Indexof(Object x) {
		        int j = 0;
		        //�������Ԫ��
		        while(j < curlen && !listElem[j].equals(x))
		            j++;
		        if(j < curlen)
		            return j;
		        else 
		            return -1;
		    }
		    //��ʾ����
		    public void display() {
		        //��ʾ���Ա��Ԫ��
		        for(int i = 0; i < curlen; i++)
		            System.out.println(listElem[i]);
		    }
		    //������
		    public static void main(String[] args) throws Exception{
		        //��1��3��5��7��9�������Ա���
		        list mylist = new list(10);
		        mylist.insert(0, "1");
		        mylist.insert(1, "3");
		        mylist.insert(2, "5");
		        mylist.insert(3, "7");
		        mylist.insert(4, "9");
		        int place = mylist.Indexof("3");//x�ڴ˴�������ҵ����Ա�Ԫ��,������3Ϊ��
		        if(place  != -1)
		            System.out.println("˳����е�һ�γ���'3'��λ����:"+ place );
		        else 
		            System.out.println("˳�������Ԫ��'x'");
		        mylist.insert(3,6);//�������
		        mylist.remove(3);//ɾ������
		        mylist.delete(4);//ɾ����ͬԪ��
		        mylist.display();//��ʾ����
		    }
		}




