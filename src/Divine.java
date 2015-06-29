import java.util.Random;
import java.util.Scanner;


public class Divine {		
	public void Start(){
		Scanner sc = new Scanner(System.in);
		String input="";//使用者輸入
		int lucky = 0;//使用者幸運值
		//=========================================================
		//Exam 1
		System.out.print("第一題 選擇你喜歡的顏色:\n" +
				 "1.紅\t2.藍\t3.綠 \n");
		input = sc.next();
		while(!input.matches("[1-3]")){//正則式 判斷是否為1 - 3；若否則重新輸入
			System.out.println("輸入錯誤 重新輸入:");
			input = sc.next();
		}
		lucky = LuckValue(lucky,Integer.parseInt(input));//接收幸運值計算結果
		//=========================================================
		//Exam 2
		System.out.print("第二題 依直覺選擇一個自然元素:\n" +
				 "1.風\t2.水\t3.火 \n");
		input = sc.next();
		while(!input.matches("[1-3]")){//正則式 判斷是否為1 - 3；若否則重新輸入
			System.out.println("輸入錯誤 重新輸入:");
			input = sc.next();
		}
		lucky = LuckValue(lucky,Integer.parseInt(input));//接收幸運值計算結果
		//=========================================================
		//Exam 3
		System.out.print("第三題 如果今天要出去約會 請選擇約會地點:\n" +
				 "1.海邊\t2.購物中心\t3.遊樂園 \n");
		input = sc.next();
		while(!input.matches("[1-3]")){//正則式 判斷是否為1 - 3；若否則重新輸入
			System.out.println("輸入錯誤 重新輸入:");
			input = sc.next();
		}
		lucky = LuckValue(lucky,Integer.parseInt(input));//接收幸運值計算結果
		//=========================================================
		//Exam 4
		System.out.print("第四題 請選擇你中午用餐的食物:\n" +
				 "1.拉麵\t2.牛排\t3.迴轉壽司 \n");
		input = sc.next();
		while(!input.matches("[1-3]")){//正則式 判斷是否為1 - 3；若否則重新輸入
			System.out.println("輸入錯誤 重新輸入:");
			input = sc.next();
		}
		lucky = LuckValue(lucky,Integer.parseInt(input));//接收幸運值計算結果
		//=========================================================
		//Exam 5
		System.out.print("最後一題 今天在路上分成三條路 請選擇一條:\n" +
				 "1.左\t2.中\t3.右\n");
		input = sc.next();
		while(!input.matches("[1-3]")){//正則式 判斷是否為1 - 3；若否則重新輸入
			System.out.println("輸入錯誤 重新輸入:");
			input = sc.next();
		}
		lucky = LuckValue(lucky,Integer.parseInt(input));//接收幸運值計算結果
		//=========================================================
		//顯示結果
		if(lucky<6)
			System.out.println("最近運氣有點慘 請多小心...");
		else if(lucky<9)
			System.out.println("最近會有點小不順 注意一些小細節...");			
		else if(lucky<15)
			System.out.println("生活會蠻順利的 還不錯~");
		else
			System.out.println("運氣好炸了 恭喜!!");
	}
	
	//幸運值計算
	int[] L={0,0,0};
	private int LuckValue(int lucky,int input){
		Random random = new Random();
		int[] num={1,2,3};	
		int i , j ;
		//隨機分配L0 ~ L2
		for(i=0;i<=2;i++){
			j=random.nextInt(3);
			while(num[j]==0)
				j=random.nextInt(3);			
			L[i]=num[j];
			num[j]=0;
		}	
		return lucky + L[input-1];//回傳 原幸運值 + 新幸運值
	}
	
}
