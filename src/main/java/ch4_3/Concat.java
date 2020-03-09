package ch4_3;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class Concat {
	public static void run() {
		Action onCompleteAction = () -> Log.d("onComplete()");
		String[] data1 = {"1", "3", "5"};
		String[] data2 = {"2", "4", "6"};
		
		Observable<String> source1 = Observable.fromArray(data1)
				.doOnComplete(onCompleteAction);
		
		Observable<String> source2 = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> data2[idx])
				.take(data2.length)
				.doOnComplete(onCompleteAction);
		
		Observable<String> source = Observable.concat(source1, source2)
				.doOnComplete(onCompleteAction);
		
		source.subscribe(Log::i);
		
		CommonUtils.sleep(1000);
	}

}
