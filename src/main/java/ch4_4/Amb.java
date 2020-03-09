package ch4_4;




import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class Amb {
	public static void run() {
		String[] data1 = {"1", "3", "5"};
		String[] data2 = {"2-R", "4-R"};
		
		List<Observable<String>> sources = Arrays.asList(
				Observable.fromArray(data1)
				.doOnComplete(() -> Log.d("Observable #1: onComplete()")),
				Observable.fromArray(data2)
				.delay(100L, TimeUnit.MILLISECONDS)
				.doOnComplete(() -> Log.d("Observable #2: onComplete()"))
				);
		
		Observable.amb(sources)
		.doOnComplete(() -> Log.d("Result: onComplete()"))
		.subscribe(Log::i);
		
		CommonUtils.sleep(1000);
		
	}
}