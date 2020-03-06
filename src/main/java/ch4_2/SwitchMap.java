package ch4_2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class SwitchMap {
	public static void run() {
		// 시간을 측정하기 위해 호출
		CommonUtils.exampleStart();

		String balls[] = {"1", "3", "5"};
		Observable<String> source= Observable.interval(100L, TimeUnit.MILLISECONDS)
			.map(Long::intValue)
			.map(idx -> balls[idx])
			.take(balls.length)
			.switchMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
					.map(notUsed -> ball+"<>")
					.take(2)
			);

		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
			
	}
	
	public static  void doOnNextVer() {
		// 실제 시간을 측정하기 위해 호출
		CommonUtils.exampleStart();

		String balls[] = {"1", "3", "5"};
		Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
			.map(Long::intValue)
			.map(idx -> balls[idx])
			.take(balls.length)
			.doOnNext(Log::d) // 중간 결과 확인용 함수
			.switchMap(
				ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
					.map(notUsed -> ball+"<>")
					.take(2)
				);

		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
	}
}
