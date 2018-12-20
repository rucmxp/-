package lizi;
import java.io.*;
import java.util.Scanner;
public class Date {
   
	
		// TODO Auto-generated method stub
		public static int max(int num1, int num2) {
			   int result;
			   if (num1 > num2)
			      result = num1;
			   else
			      result = num2;

			   return result; 
			
  }
		public static void main(String[] args) {
			Scanner r=new Scanner(System.in);
			System.out.println("input:");
			Date l=new Date();
          System.out.print(l.max(44,2));
	}

}
