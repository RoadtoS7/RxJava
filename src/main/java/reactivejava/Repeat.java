package reactivejava;

import io.reactivex.rxjava3.core.Observable;

public class Repeat {
	public static void run() {
		String balls[] = {"1", "3", "5"};
		
		Observable<String> source = Observable.fromArray(balls)
				.repeat(3);
		
		source.doOnComplete(() -> Log.d("onComplete"))
			.subscribe(Log::i);
		
	}
}
