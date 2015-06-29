import java.util.*;
import java.util.Random;

public class GG{

	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner( System.in );
		Random ran = new Random();
		//占卜遊戲
		Divine divine = new Divine();
		//數字遊戲
		Number number = new Number();
		//接盤子遊戲
		Catch_Dish catch_Dish = new Catch_Dish();
		int i = 0;
		while(i!=4){
			System.out.println("請選擇功能:");
			System.out.println("1.運勢占卜");
			System.out.println("2.數字遊戲");
			System.out.println("3.接盤子");
			System.out.println("4.離開");
			i=input.nextInt();//接收輸入
			if(i==1)	
				divine.Start();//占卜遊戲開始			
			else if(i==2)			
				number.Start();	
			else if(i==3)
				catch_Dish.Start();
			else if(i != 4)
				System.out.println("輸入錯誤");
			System.out.println("=============");			
		}
	}	
}