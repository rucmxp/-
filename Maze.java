 /*int place[8][2]= //示例
{        7,1,//人大西门
        3,4,//明德楼
        8,15,//人文楼
        0,25,//北门
        5,23,//图书馆
        1,27,//邮局
        10,28,//东门
        2,23};//足球场*/

/*将0设为能够走通，将坐标（2，8）设为起点，设置了4个方向,结果为堆栈，所以路径需要倒着看*/
package lizi;
import java.util.*;

class Step{
	//定义坐标和方向
    int x,y,d;
    public Step(int x,int y,int d) {
        this.x = x;//横坐标
        this.y = y;//纵坐标
        this.d = d;//方向
    }
}

public class Maze {

    public static void main(String[] args) {
        // 建一个迷宫
    	 int maze[][]={
 			    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1},
 			     {1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1},
 			     {1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1},
 			     {1,1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1},
 			     {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1},
 			     {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
 			     {1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1},
 			     {1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1},
 			     {1,1,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,0,0,1,1},
 			     {1,1,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
 			     { 1,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
 			     {1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
 			     { 1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1},
 			     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
 		 //将迷宫打印出来
 		 for (int i = 0; i < maze.length; i++) {  	            
 			 for (int j = 0; j < maze[i].length; j++) {  
 				 if(maze[i][j]==1) {
 				 System.out.print("■"); }
 				 else {
 					System.out.print("□"); }
 				 }  	           
 			 System.out.println();  	       
 			 }  
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        //设置4个方向
        Stack<Step> s = new Stack<Step>();//定义栈
        int a = path(maze, move, s);
        int b=0;
        while(!s.isEmpty()){
            Step step = s.pop();
            System.out.print(step.x+","+step.y+"  ");//打印坐标值
            b++;
            if(b%5==0)
            	System.out.println();
        }
    }
    
    public static int path(int[][] maze,int[][] move,Stack<Step> s){
    	
        Step temp = new Step(7,1,-1); //起点,定义（7，1）为起点
        s.push(temp);
        while(!s.isEmpty()){
            s.pop();  //如果路走不通就出栈
            if(!s.isEmpty()){
                temp = s.peek();  //将栈顶元素设置为当前位置
            }
            int x = temp.x;
            int y = temp.y;
            int d = temp.d+1;
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 0){    //该点可以到达
                    temp = new Step(i,j,d); //到达新点
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 3&& y == 4){//将（3,4)设置为目的地
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }

}