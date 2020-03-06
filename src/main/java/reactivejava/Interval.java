package reactivejava;


import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;


public class Interval {
	static void start() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(data -> (data + 1) * 100)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
				
	}
	
	static void start2() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
			.map(data -> data + 100)
			.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
	
	
}
