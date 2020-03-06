package CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class Timer {
	public static void start() {
		CommonUtils.exampleStart();
		Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
			.map(notUsed ->{
					return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
									.format(new Date());
			});
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
}
