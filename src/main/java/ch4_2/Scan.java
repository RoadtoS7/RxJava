package ch4_2;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.Log;

public class Scan {
	public static void run() {
		String[] balls = {"1", "3", "5"};
		
		Observable<String> source = Observable.fromArray(balls)
				.scan((ball1, ball2) -> ball2 + "(" + ball1 + ")");
		source.subscribe(Log::i);
	}
}
