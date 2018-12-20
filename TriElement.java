package lizi;


//在构造中，我设置了左、右孩子编码为0、1，将权重扩大10000倍，变成整数，方便打印
public class TriElement                          //二叉树的结点类
{
    int data;                                    //数据域
    int parent,left,right;                       //父母结点和左、右孩子结点下标
	
    //构造结点，各参数 依次为 ：  指定元素、父母结点下标、左、 右孩子结点下标
	public TriElement(int data, int parent, int left, int right)
	{					
	    this.data = data;          //数据
	    this.parent = parent;      //父母
	    this.left = left;			//左孩子
	    this.right = right;			//右孩子
	}
	public TriElement(int data)                  //构造元素值为data、无父母的叶子结点
	{					
	    this(data, -1, -1, -1);
	}
    public String toString()                     //返回结点的字符串
    {
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }
    public boolean isLeaf()                                //判断是否叶子结点
    {
        return this.left==-1 && this.right==-1;
    }
}

     class HuffmanTree                                   //Huffman树类
     {
    private String charset;                                //字符集合
    private TriElement[] huftree;                          //结点数组
 
    //构造Huffman树，weights指定权值集合，数组长度为叶子结点数；默认字符集合从a开始
    public HuffmanTree(int[] weights)
    {
        this.charset = "";
        for (int i=0; i<weights.length; i++)               //默认字符集合是从'a'开始的weights.length个字符
            this.charset += (char)('a'+i);    
        
        int n = weights.length;                            //叶子结点数
        this.huftree = new TriElement[2*n-1];              //n个叶子的Huffman树共有2n-1个结点
        for(int i=0; i<n; i++)                             //Huffman树初始化n个叶子结点
            this.huftree[i] = new TriElement(weights[i]);  //构造无父母的叶子结点

        for(int i=n; i<2*n-1; i++)                         //构造n-1个2度结点
        {
            int min1=Integer.MAX_VALUE, min2=min1;         //最小和次小权值，初值为整数最大值
            int x1=-1, x2=-1;                              //最小和次小权值结点下标
            for (int j=0; j<i; j++)                        //寻找两个无父母的最小权值结点下标
                if (this.huftree[j].parent==-1)            //第j个结点无父母
                    if (this.huftree[j].data<min1)         //第j个结点权值最小
                    {
                        min2 = min1;                       //min2记得次小权值
                        x2 = x1;                           //x2记得次小权值结点下标
                        min1 = this.huftree[j].data;       //min1记得最小权值
                        x1 = j;                            //x1记得最小权值结点下标
                    }
                    else
                        if (this.huftree[j].data<min2)     //第j个结点权值次小
                        {
                            min2 = huftree[j].data; 
                            x2 = j;
                        }

            this.huftree[x1].parent = i;                   //合并两棵权值最小的子树，左孩子最小
            this.huftree[x2].parent = i;
            this.huftree[i] = new TriElement(min1+min2, -1, x1, x2); //构造结点，指定值、父母、左右孩子
        }
    }
    
    private String getCode(int i)                 //返回charset第i个字符的Huffman编码字符串
    {
        int n=10000000;
        char hufcode[] = new char[n];                      //声明字符数组暂存Huffman编码
        int child=i, parent=this.huftree[child].parent;
        for (i=n-1; parent!=-1; i--)                       //由叶结点向上直到根结点，反序存储编码
        {
            hufcode[i] = (huftree[parent].left==child) ? '0' : '1';  //左、右孩子编码为0、1
            child = parent;
            parent = huftree[child].parent;        
        }                       
        return new String(hufcode,i+1,n-1-i);    //由hufcode数组从i+1开始的n-1-i个字符构造串
    }

    public String toString()                     //返回Huffman树的编码字符串
    {
        
        String str = "Huffman编码:\n";
        for (int i=0; i<this.charset.length(); i++)        //输出所有叶子结点的Huffman编码
            str+=this.charset.charAt(i)+"："+getCode(i)+"\n";
        return str;
    }


     public static void main(String[] args)
     { 
    	//将权重放大10000倍，方便研究
    	 int[] weight1={8167,1492,2782,4253,12702,2228,2015,6094,6966,153,772,4025,2406,6749,7507,1929,95,5987,6327,9056,2758,978,2360,150,1974,74};        
         Object huffman = new HuffmanTree(weight1);             //构造Huffman树
         System.out.println(huffman.toString());     //输出Huffman树编码
      
         
       
     }   
     }