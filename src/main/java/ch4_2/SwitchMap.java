package ch4_2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class SwitchMap {
	public static void run() {
		// �ð��� �����ϱ� ���� ȣ��
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
		// ���� �ð��� �����ϱ� ���� ȣ��
		CommonUtils.exampleStart();

		String balls[] = {"1", "3", "5"};
		Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
			.map(Long::intValue)
			.map(idx -> balls[idx])
			.take(balls.length)
			.doOnNext(Log::d) // �߰� ��� Ȯ�ο� �Լ�
			.switchMap(
				ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
					.map(notUsed -> ball+"<>")
					.take(2)
				);

		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
	}
}
