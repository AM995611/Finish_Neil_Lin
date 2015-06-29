import java.util.Random;
import java.util.Scanner;

public class Number {
	Scanner sc = new Scanner(System.in);

	public void Start() throws Exception {
		// 遊戲說明
		System.out.println("遊戲說明:");
		System.out.println("有三個關卡 請用最快的時間內全部通關");
		System.out.println("會用通關時間來評價");
		System.out.println("五秒後遊戲開始");
		// 停止五秒
		Thread.sleep(5000);
		// 開始計時
		long time1 = System.currentTimeMillis();
		// Level 1
		game1();
		System.out.println("過關!");
		// Level 2
		game2();
		System.out.println("過關!");
		// Level 3
		game3();
		System.out.println("過關!");
		// 計時結束
		long time2 = System.currentTimeMillis();
		// 計算時間及成績
		time2 -= time1;
		if (time2 <= 13)
			System.out.println("評價S級 太神拉!!");
		else if (time2 <= 18)
			System.out.println("評價A級 OP!");
		else if (time2 <= 23)
			System.out.println("評價B級 馬馬虎虎");
		else if (time2 <= 28)
			System.out.println("評價C級 有點遜");
		else
			System.out.println("評價D級 砍掉重練拉");

	}

	// 猜數字遊戲
	private void game1() throws Exception {
		System.out.println("LEVEL 1:");
		System.out.println("請從1-10中猜出電腦選的數字");
		int rand = new Random().nextInt(10) + 1;
		int input = sc.nextInt();
		while (input != rand) {
			System.out.println("猜錯了 懲罰等待1秒");
			Thread.sleep(1000);
			System.out.println("再試一次");
			input = sc.nextInt();
		}
	}

	// 快速計算遊戲
	private void game2() throws Exception {
		System.out.println("LEVEL 2:");
		System.out.println("算出以下四數的平均值(取整數):");
		int total = 0;// 所有加總
		// 顯示四個數字的平均
		int rand = getavg();
		// 讀取輸入
		int input = sc.nextInt();
		while (input != rand) {
			System.out.println("猜錯了 懲罰等待2秒");
			Thread.sleep(2000);
			System.out.println("再試一次");
			input = sc.nextInt();
		}
	}

	// 尋寶遊戲
	private void game3() throws Exception {
		System.out.println("LEVEL 3:");
		System.out.println("請找出寶藏(1)在哪");
		// 地圖大小 5 * 5
		int[][] map = new int[5][5];
		// 放入寶藏
		map[new Random().nextInt(5)][new Random().nextInt(5)] = 1;
		// 顯示地圖
		showmap(map);
		// 讀取輸入
		System.out.println("行:");
		String row = sc.next();
		while(!row.matches("[0-4]")){
			System.out.println("超出範圍 請重新輸入");
			row = sc.next();
		}
		System.out.println("列:");
		String col = sc.next();
		while(!col.matches("[0-4]")){
			System.out.println("超出範圍 請重新輸入");
			col = sc.next();
		}
		while (map[Integer.parseInt(row)][Integer.parseInt(col)] != 1) {
			//標示為猜過
			map[Integer.parseInt(row)][Integer.parseInt(col)] = 2;
			//顯示地圖
			showmap(map);
			System.out.print("猜錯囉~~ 中陷阱   持續2秒");
			Thread.sleep(2000);
			System.out.println("再試一次");
			System.out.println("行:");
			row = sc.next();
			while(!row.matches("[0-4]")){
				System.out.println("超出範圍 請重新輸入");
				row = sc.next();
			}
			System.out.println("列:");
			col = sc.next();
			while(!col.matches("[0-4]")){
				System.out.println("超出範圍 請重新輸入");
				col = sc.next();
			}
		}
		//標示為寶藏
		map[Integer.parseInt(row)][Integer.parseInt(col)] = 3;
		//顯示地圖
		showmap(map);
	}

	// 產生並計算四個數的平均
	private int getavg() {
		int rand = new Random().nextInt(100) + 1;
		int total = rand;
		System.out.print(rand + " ");
		rand = new Random().nextInt(100) + 1;
		total += rand;
		System.out.print(rand + " ");
		rand = new Random().nextInt(100) + 1;
		total += rand;
		System.out.print(rand + " ");
		rand = new Random().nextInt(100) + 1;
		total += rand;
		System.out.print(rand + "\n");
		rand = total / 4;
		return rand;
	}

	// 顯示地圖
	private void showmap(int[][] map) {
		for (int[] map1 : map) {
			for (int temp : map1) {
				if (temp == 2)
					System.out.print("X ");
				else if(temp == 3)
					System.out.print("寶 ");
				else
					System.out.print("? ");
			}
			System.out.println();
		}
	}
}
