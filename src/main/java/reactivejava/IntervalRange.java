package reactivejava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class IntervalRange {
	public static void start() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.intervalRange(
				1, // start
				5, // count
				100L, // initialDelay
				100L, // period
				TimeUnit.MILLISECONDS); // timeUnit
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
}
