import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Catch_Dish {
	static int[][] dish= new int[6][5];//掉下來的盤子
	static int[] catch_dish = new int[5];//接盤子的介面
	static int index = 2;//接盤子的位置
	static int time = 10;//遊戲時間
	static int total = 0;//分數
	public void Start() throws Exception{
		for(int[] temp1:dish)
			for(int temp2:temp1)
				temp2 = 0;
		catch_dish[index] = 1;
		showThread t1 = new showThread();
		t1.start();
		Catch t2 = new Catch();
		t2.start();
		Thread.sleep((time+2)*1000);
		t2.stop();
		//System.exit(0);
	}
	//顯示畫面
	public static void showdish(){
		System.out.println("   =====");
		//顯示盤子
		for(int i = 1;i<dish.length;i++){
			System.out.print("   ");
			for(int j = 0;j<dish[i].length;j++){
				if(dish[i][j] == 1)
					System.out.print("Q");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.print("   ");
		//顯示接的東西
		for(int temp:catch_dish){
			if(temp == 1)
				System.out.print("■");
			else
				System.out.print(" ");
		}
		System.out.println();
		System.out.println("   =====");
	}
	//東西往下掉
	public static void move(){
		//產生一個新的在最上面
		Arrays.fill(dish[0], 0);
		int rand =new Random().nextInt(5); 
		dish[0][rand] = 1;
		//接到加1
		if(dish[5][index] == 1)
			total += 1;
		//往下掉
		for(int i = 5;i>0;i--){			
			for(int j = 0;j < 5;j++){
				dish[i][j] = dish[i-1][j];
			}
		}
				
	}
}
//每秒移動一次
class showThread extends Thread{
	public void run() {
		int count = 0;
		while(count <= Catch_Dish.time){
			Catch_Dish.move();
			Catch_Dish.showdish();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		System.out.println("Score:"+Catch_Dish.total);
	}
}
//掉下來的時候       按4接住往左移  	按6接住往右移
class Catch extends Thread{
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String str = sc.next();
			str = str.charAt(0)+"";
			while(!str.matches("[4-6]")){		
				str = sc.next();
			}
			Arrays.fill(Catch_Dish.catch_dish, 0);//清空
			switch(str){
				case "4"://往左移
					if(Catch_Dish.index > 0)
						Catch_Dish.index -= 1;
					Catch_Dish.catch_dish[Catch_Dish.index] = 1;
					break;
				case "6"://往右移
					if(Catch_Dish.index < Catch_Dish.catch_dish.length-1)
						Catch_Dish.index += 1;
					Catch_Dish.catch_dish[Catch_Dish.index] = 1;
					break;
			}
			Catch_Dish.showdish();
		}
	}
}