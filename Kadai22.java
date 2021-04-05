package kadai;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
public class Kadai22 {

	public static void main(String[] args) {
		/* TODO 自動生成されたメソッド・スタブ
		1から9までの数字の１つをだぶらせて表示して、それを見つけさせるゲーム。
		表示する数字はシャッフルさせておく。
		10回の表示をさせ、かかった時間を表示する。
		20秒以下でできた場合「素早いですね」
		20より多く、30秒以下の場合「まあまあですね」
		30秒より多く、40秒以下の場合「少し鈍いですね」
		40秒より長くかかった場合「鈍すぎます」
		と表示させて終了する。*/

		int tmp;
		int index;
		System.out.println("1～9の数字の中の1つを重複させて1行に表示します\n" +
							"重複した数字を入力し10回繰り返して時間を計るゲームです");
		System.out.println("それでははじめます\nよーい...");
		try { //5秒間ストップ
			 Thread.sleep(5000);
			 } catch (InterruptedException e) {
			 }
		System.out.println("スタート");
		long start = System.currentTimeMillis(); //スタート時刻取得

        for (int j = 0; j < 10; j++) { //targetArrayの要素入れ替えをfor文で10回まわす
        	int []targetArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println((j + 1) + "回目");
			Random rnd = ThreadLocalRandom.current();
	        for (int i = targetArray.length - 1; i > 0; i--) {
	            index = rnd.nextInt(i + 1);
	            tmp = targetArray[index];
	            targetArray[index] = targetArray[i];
	            targetArray[i] = tmp;
	        }

	        Random r = new Random(9); //重複させる数字をランダムで生成
	        int shuffle = targetArray[r.nextInt(9)];
	        Arrays.fill(targetArray,3,4,shuffle); //targetArrayの4番目の要素をランダムに生成した数字に置き換える
	        int overlap = targetArray[3];
	        for (int i = targetArray.length - 1; i > 0; i--) { //置き換え後再度シャッフル
	            index = rnd.nextInt(i + 1);
	            tmp = targetArray[index];
	            targetArray[index] = targetArray[i];
	            targetArray[i] = tmp;
	        }
	        System.out.println(Arrays.toString(targetArray));
	        System.out.print("重複している数字を入力してください>>>");
	        while (!(input() == overlap)) {
	        	System.out.println("ちがいます\nもう一度入力してください");
	        }
        }

        long end = System.currentTimeMillis(); //終了時刻取得
		System.out.println("かかった時間は" + TimeUnit.MILLISECONDS.toSeconds(end - start) + "秒です");
		if (TimeUnit.MILLISECONDS.toSeconds(end - start) <= 20) {
			System.out.println("素早いですね");
		} else if (TimeUnit.MILLISECONDS.toSeconds(end - start) <= 30) {
			System.out.println("まあまあですね");
		} else if (TimeUnit.MILLISECONDS.toSeconds(end - start) <= 40) {
			System.out.println("少し鈍いですね");
		} else {
			System.out.println("鈍すぎます");
		}
		System.out.println("これでプログラムを終了します");
	}

	public static int input() { //数字入力メソッド

		while (true) {
			try {
				int num = new java.util.Scanner(System.in).nextInt();
				if (num >= 1 && num <= 9) {
					return num;
				} else {
					System.out.println("1～9以外の数値が入力されました\n入力しなおしてください");
				}
			} catch (Exception e) {
				System.out.println("数字以外が入力されました\n入力しなおしてください");
			}
		}
	}
}
