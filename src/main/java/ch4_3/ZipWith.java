package ch4_3;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.Log;

public class ZipWith {
	public static void run() {
		Observable<Integer> source = Observable.zip(
				Observable.just(100, 200, 300),
				Observable.just(10, 20, 30),
				(a, b) -> a + b)
				.zipWith(Observable.just(1, 2, 3), (ab, c) -> ab+c);
		
		source.subscribe(Log::i);
	}
}
