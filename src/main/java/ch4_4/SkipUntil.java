package ch4_4;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class SkipUntil {
	public static void run() {
		String[] data = {"1", "2", "3", "4", "5", "6"};
		
		Observable<String> source = Observable.fromArray(data)
				.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, notUsed)-> val)
				.skipUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));
		
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
	}
}
