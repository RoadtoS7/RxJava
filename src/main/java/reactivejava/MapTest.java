package reactivejava;

import io.reactivex.Observable;

public class MapTest {
	public static void run() {
		String[] balls = {"1","2", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.map(ball -> ball + "<>");
		source.subscribe();
		
	}
}
