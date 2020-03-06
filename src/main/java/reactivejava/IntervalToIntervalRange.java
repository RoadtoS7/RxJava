package reactivejava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class IntervalToIntervalRange {
	public static void start() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(200L, TimeUnit.MILLISECONDS)
				.map(value -> value + 1);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
	
	public static void exampleStart() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(value -> value + 1)
				.take(5);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
}
