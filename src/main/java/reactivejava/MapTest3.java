package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapTest3 {
	public static void run(){
		Function<String, Integer> ballToIndex = ball ->{
			switch(ball) {
			case "RED": return 1;
			case "YELLOW": return 2;
			case "GREEN": return 3;
			case "BLUE": return 4;
			default: return -1;
			}
		};
		
		String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};
		Observable<Integer> source = Observable.fromArray(balls)
				.map(ballToIndex); // ������� Ÿ�Ժ�ȯ ���� �ٷ� ����� �� �ִ�.
		source.subscribe(System.out::println);
	}
}
