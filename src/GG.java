import java.util.*;
import java.util.Random;

public class GG{

	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner( System.in );
		Random ran = new Random();
		//占卜遊戲
		Divine divine = new Divine();
		int i = 0;
		while(i!=4){
			System.out.println("請選擇功能:");
			System.out.println("1.占卜");
			System.out.println("2.數字遊戲");
			System.out.println("3.研發中");
			System.out.println("4.離開");
			i=input.nextInt();//接收輸入
			if(i==1)	
				divine.Start();//占卜遊戲開始			
			else if(i==2)			
				number();		
			else if(i==3)
				System.out.println("研發中");
			else if(i != 4)
				System.out.println("輸入錯誤");
			System.out.println("=============");			
		}
	}

	public static void number(){

	Scanner input = new Scanner( System.in );
	Random ran = new Random();


	long time1,time2,timetotal;
	int a1,t1,t2,t3,t4,t5,a3,a4,r1,r2;
	float a2,t2345;
	int[][] p={
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},};

	System.out.println("遊戲說明:");
	System.out.println("有三個關卡 請用最快的時間內全部通關");
	System.out.println("會用通關時間來評價");
	System.out.println("五秒後遊戲開始");

	try{
		Thread.sleep(5000);
	}catch(InterruptedException e){
		System.out.println("錯誤");
	}

	time1 = System.currentTimeMillis();/*計時開始*/

	System.out.println("LEVEL 1:");
	System.out.println("請從1-10中猜出電腦選的數字");
	t1=ran.nextInt(10)+1;
	/*System.out.println(t1);*/
	a1=input.nextInt();
	while(a1!=t1){
	System.out.println("猜錯了 懲罰加1秒");
	try{
		Thread.sleep(1000);
	}catch(InterruptedException e){
		System.out.println("錯誤");
	}
	System.out.println("再試一次");
	a1=input.nextInt();
	}
	System.out.println("過關!");


	System.out.println("LEVEL 2:");
	System.out.println("算出以下四數的平均值");
	t2=ran.nextInt(100)+1;
	t3=ran.nextInt(100)+1;
	t4=ran.nextInt(100)+1;
	t5=ran.nextInt(100)+1;
	System.out.println(t2+"  "+t3+"  "+t4+"  "+t5);
	t2345=((float)t2+(float)t3+(float)t4+(float)t5)/4;
	/*System.out.println(t2345);*/
	a2=input.nextFloat();
	while(a2!=t2345){
	System.out.println("猜錯了 懲罰加2秒");
	try{
		Thread.sleep(2000);
	}catch(InterruptedException e){
		System.out.println("錯誤");
	}
	System.out.println("再試一次");
	a2=input.nextFloat();
	}
	System.out.println("過關!");


	System.out.println("LEVEL 3:");
	System.out.println("請找出1在哪");
	r1=ran.nextInt(10);
	r2=ran.nextInt(10);
	p[r1][r2]=1;

	for(r1=0;r1<10;r1++){
		for(r2=0;r2<10;r2++){
			System.out.print(p[r1][r2]);
			}
		System.out.println();
	}
	System.out.println("行:");
	a3=input.nextInt();
	System.out.println("列:");
	a4=input.nextInt();
	while(p[a3-1][a4-1]!=1){
		System.out.print("錯誤 懲罰2秒");
		try{
		Thread.sleep(2000);
		}catch(InterruptedException e){
		System.out.println("錯誤");
		}
		System.out.println("再試一次");
		System.out.println("行:");
		a3=input.nextInt();
		System.out.println("列:");
		a4=input.nextInt();
		}	
	System.out.println("過關!");

	time2 = System.currentTimeMillis();/*計時結束*/
	timetotal=(time2-time1)/1000;
	System.out.println("花了"+timetotal+"秒");
	if(timetotal<=13){
		System.out.println("評價S級 太神拉!!");
		}else if(timetotal<=18){
		System.out.println("評價A級 OP!");
		}else if(timetotal<=23){
		System.out.println("評價B級 馬馬虎虎");
		}else if(timetotal<=28){
		System.out.println("評價C級 有點遜");
		}else{
		System.out.println("評價D級 砍掉重練拉");
		}

	}

}