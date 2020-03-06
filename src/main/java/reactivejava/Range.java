package reactivejava;

import io.reactivex.rxjava3.core.Observable;

public class Range {
	public static void start() {
		Observable<Integer> source = Observable.range(1,  10)
				.filter(data -> data % 2 == 0);
		source.subscribe(Log::i);
	}
}
