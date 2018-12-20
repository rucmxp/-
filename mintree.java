	/**
	 * 
	 * 姓名： 莫旭鹏
	 * 学号：2016202253
	 * 
	 * 
	 * 通过邻接矩阵的方法实现，
	 * prime和Kruskal算法生成最小生成树
	 *dijkstra和flOyd算法实现最短路径
	 */

package lizi;
import java.io.IOException;
import java.util.Scanner;

public class mintree {
		
	    private int mEdgNum;        // 边的数量
	    private char[] mVexs;       // 顶点集合
	    private int[][] mMatrix;    // 邻接矩阵
	    private static final int INF = Integer.MAX_VALUE;   // 最大值,INF表示无穷大   
	    /*
	     * 创建图
	     *
	     * 参数说明：
	     *     vexs  -- 顶点数组
	     *     matrix-- 矩阵(数据)
	     */
	    public mintree(char[] vexs, int[][] matrix) {
	        
	        // 初始化"顶点数"和"边数"
	        int vlen = vexs.length;

	        // 初始化"顶点"
	        mVexs = new char[vlen];
	        for (int i = 0; i < mVexs.length; i++)
	            mVexs[i] = vexs[i];

	        // 初始化"边"
	        mMatrix = new int[vlen][vlen];
	        for (int i = 0; i < vlen; i++)
	            for (int j = 0; j < vlen; j++)
	                mMatrix[i][j] = matrix[i][j];

	        // 统计"边"
	        mEdgNum = 0;
	        for (int i = 0; i < vlen; i++)
	            for (int j = i+1; j < vlen; j++)
	                if (mMatrix[i][j]!=INF)
	                    mEdgNum++;
	    }

	    /*
	     * 返回ch位置
	     */
	    private int getPosition(char ch) {
	        for(int i=0; i<mVexs.length; i++)
	            if(mVexs[i]==ch)
	                return i;
	        return -1;
	    }

	

	    /*
	     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
	     */
	    private int firstVertex(int v) {

	        if (v<0 || v>(mVexs.length-1))
	            return -1;

	        for (int i = 0; i < mVexs.length; i++)
	            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
	                return i;

	        return -1;
	    }

	    /*
	     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
	     */
	    private int nextVertex(int v, int w) {

	        if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
	            return -1;

	        for (int i = w + 1; i < mVexs.length; i++)
	            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
	                return i;

	        return -1;
	    }


	    /*
	     * prim最小生成树
	     *
	     * 参数说明：
	     *   start -- 从图中的第start个元素开始，生成最小树
	     */
	    public void prim(int start) {
	        int num = mVexs.length;         // 顶点个数
	        int index=0;                    // prim最小树的索引，即prims数组的索引
	        char[] prims  = new char[num];  // prim最小树的结果数组
	        int[] weights = new int[num];   // 顶点间边的权值

	        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
	        prims[index++] = mVexs[start];

	        // 初始化"顶点的权值数组"，
	        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
	        for (int i = 0; i < num; i++ )
	            weights[i] = mMatrix[start][i];
	        // 将第start个顶点的权值初始化为0。
	        // 可以理解为"第start个顶点到它自身的距离为0"。
	        weights[start] = 0;

	        for (int i = 0; i < num; i++) {
	            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
	            if(start == i)
	                continue;

	            int j = 0;
	            int k = 0;
	            int min = INF;
	            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
	            while (j < num) {
	                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
	                if (weights[j] != 0 && weights[j] < min) {
	                    min = weights[j];
	                    k = j;
	                }
	                j++;
	            }

	            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
	            // 将第k个顶点加入到最小生成树的结果数组中
	            prims[index++] = mVexs[k];
	            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
	            weights[k] = 0;
	            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
	            for (j = 0 ; j < num; j++) {
	                // 当第j个节点没有被处理，并且需要更新时才被更新。
	                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
	                    weights[j] = mMatrix[k][j];
	            }
	        }

	        // 计算最小生成树的权值
	        int sum = 0;
	        for (int i = 1; i < index; i++) {
	            int min = INF;
	            // 获取prims[i]在mMatrix中的位置
	            int n = getPosition(prims[i]);
	            // 在vexs[0...i]中，找出到j的权值最小的顶点。
	            for (int j = 0; j < i; j++) {
	                int m = getPosition(prims[j]);
	                if (mMatrix[m][n]<min)
	                    min = mMatrix[m][n];
	            }
	            sum += min;
	        }
	        // 打印最小生成树
	        System.out.printf("PRIM(%c)=%d: ", mVexs[start], sum);
	        for (int i = 0; i < index; i++)
	            System.out.printf("%c ", prims[i]);
	        System.out.printf("\n");
	    }

	    /*
	     * 克鲁斯卡尔（Kruskal)最小生成树
	     */
	    public void kruskal() {
	        int index = 0;                      // rets数组的索引
	        int[] vends = new int[mEdgNum];     // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
	        EData[] rets = new EData[mEdgNum];  // 结果数组，保存kruskal最小生成树的边
	        EData[] edges;                      // 图对应的所有边

	        // 获取"图中所有的边"
	        edges = getEdges();
	        // 将边按照"权"的大小进行排序(从小到大)
	        sortEdges(edges, mEdgNum);

	        for (int i=0; i<mEdgNum; i++) {
	            int p1 = getPosition(edges[i].start);      // 获取第i条边的"起点"的序号
	            int p2 = getPosition(edges[i].end);        // 获取第i条边的"终点"的序号

	            int m = getEnd(vends, p1);                 // 获取p1在"已有的最小生成树"中的终点
	            int n = getEnd(vends, p2);                 // 获取p2在"已有的最小生成树"中的终点
	            // 如果m!=n，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
	            if (m != n) {
	                vends[m] = n;                       // 设置m在"已有的最小生成树"中的终点为n
	                rets[index++] = edges[i];           // 保存结果
	            }
	        }

	        // 统计并打印"kruskal最小生成树"的信息
	        int length = 0;
	        for (int i = 0; i < index; i++)
	            length += rets[i].weight;
	        System.out.printf("Kruskal=%d: ", length);
	        for (int i = 0; i < index; i++)
	            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
	        System.out.printf("\n");
	    }

	    /* 
	     * 获取图中的边
	     */
	    private EData[] getEdges() {
	        int index=0;
	        EData[] edges;

	        edges = new EData[mEdgNum];
	        for (int i=0; i < mVexs.length; i++) {
	            for (int j=i+1; j < mVexs.length; j++) {
	                if (mMatrix[i][j]!=INF) {
	                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
	                }
	            }
	        }

	        return edges;
	    }

	    /* 
	     * 对边按照权值大小进行排序(由小到大)
	     */
	    private void sortEdges(EData[] edges, int elen) {

	        for (int i=0; i<elen; i++) {
	            for (int j=i+1; j<elen; j++) {

	                if (edges[i].weight > edges[j].weight) {
	                    // 交换"边i"和"边j"
	                    EData tmp = edges[i];
	                    edges[i] = edges[j];
	                    edges[j] = tmp;
	                }
	            }
	        }
	    }

	    /*
	     * 获取i的终点
	     */
	    private int getEnd(int[] vends, int i) {
	        while (vends[i] != 0)
	            i = vends[i];
	        return i;
	    }
	    /*
	     * Dijkstra最短路径。
	     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
	     *
	     * 参数说明：
	     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
	     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
	     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
	     */
	    public void dijkstra(int vs, int[] prev, int[] dist) {
	        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
	        boolean[] flag = new boolean[mVexs.length];
	        
	        // 初始化
	        for (int i = 0; i < mVexs.length; i++) {
	            flag[i] = false;          // 顶点i的最短路径还没获取到。
	            prev[i] = 0;              // 顶点i的前驱顶点为0。
	            dist[i] = mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
	        }

	        // 对"顶点vs"自身进行初始化
	        flag[vs] = true;
	        dist[vs] = 0;

	        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
	        int k=0;
	        for (int i = 1; i < mVexs.length; i++) {
	            // 寻找当前最小的路径；
	            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
	            int min = INF;
	            for (int j = 0; j < mVexs.length; j++) {
	                if (flag[j]==false && dist[j]<min) {
	                    min = dist[j];
	                    k = j;
	                }
	            }
	            // 标记"顶点k"为已经获取到最短路径
	            flag[k] = true;

	            // 修正当前最短路径和前驱顶点
	            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
	            for (int j = 0; j < mVexs.length; j++) {
	                int tmp = (mMatrix[k][j]==INF ? INF : (min + mMatrix[k][j]));
	                if (flag[j]==false && (tmp<dist[j]) ) {
	                    dist[j] = tmp;
	                    prev[j] = k;
	                }
	            }
	        }

	        // 打印dijkstra最短路径的结果
	        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
	        for (int i=0; i < mVexs.length; i++)
	            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
	    }

	    /*
	     * floyd最短路径。
	     * 即，统计图中各个顶点间的最短路径。
	     *
	     * 参数说明：
	     *     path -- 路径。path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
	     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
	     */
	    public void floyd(int[][] path, int[][] dist) {

	        // 初始化
	        for (int i = 0; i < mVexs.length; i++) {
	            for (int j = 0; j < mVexs.length; j++) {
	                dist[i][j] = mMatrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
	                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
	            }
	        }

	        // 计算最短路径
	        for (int k = 0; k < mVexs.length; k++) {
	            for (int i = 0; i < mVexs.length; i++) {
	                for (int j = 0; j < mVexs.length; j++) {

	                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
	                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
	                    if (dist[i][j] > tmp) {
	                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
	                        dist[i][j] = tmp;
	                        // "i到j最短路径"对应的路径，经过k
	                        path[i][j] = path[i][k];
	                    }
	                }
	            }
	        }

	        // 打印floyd最短路径的结果
	        System.out.printf("floyd: \n");
	        for (int i = 0; i < mVexs.length; i++) {
	            for (int j = 0; j < mVexs.length; j++)
	                System.out.printf("%2d  ", dist[i][j]);
	            System.out.printf("\n");
	        }
	    }

	    // 边的结构体
	    private static class EData {
	        char start; // 边的起点
	        char end;   // 边的终点
	        int weight; // 边的权重

	        public EData(char start, char end, int weight) {
	            this.start = start;
	            this.end = end;
	            this.weight = weight;
	        }
	    };


	    public static void main(String[] args) {
	        char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F'};
	        int matrix[][] = {
	                 /*V1*//*V2*//*V3*//*V4*//*V5*//*V6*/
	          /*V1*/ { 0 ,  6 ,   1  ,   5  ,  INF ,  INF },
	          /*V2*/ { 6 , 0  ,   5  ,   INF,  3   ,  INF    },
	          /*V3*/ { 1 , 5  ,   0  ,   5  ,  6   ,   4 },
	          /*V4*/ { 5 , INF,   5  ,   0  ,  INF  ,  2 },
	          /*V5*/ {INF, 3  ,  6   ,   INF,  0    ,  6},
	          /*V6*/ {INF, INF , 4   ,   2   ,  6   ,  0}};
	       mintree pG;

	     
	        // 采用本图
	        pG = new mintree(vexs, matrix);
	        pG.prim(0);		//prime算法生成最小生成树
	        
	        
	        pG.kruskal();   // Kruskal算法生成最小生成树
	      
	        
	        
	        int[] prev = new int[pG.mVexs.length];
	        int[] dist = new int[pG.mVexs.length]; 
	        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
	        pG.dijkstra(3, prev, dist);

	        
	        int[][] path = new int[pG.mVexs.length][pG.mVexs.length];
	        int[][] floy = new int[pG.mVexs.length][pG.mVexs.length];
	        // floyd算法获取各个顶点之间的最短距离
	        pG.floyd(path, floy);
	    }
	}


