package reactivejava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapTest2 {
	public static void run() {
		Function<String, String> getDiamond = ball -> ball+"<>";

		String[] balls = {"1","2","3","5"};
		Observable<String> source = Observable.fromArray(balls)
			.map(getDiamond);
		source.subscribe(Log::i);
	}
}
