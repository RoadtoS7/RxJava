package ch4_5;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import reactivejava.Log;



public class Math {
	public static void run() {
		Integer[] data = {1, 2, 3, 4};
		
		// 1. count()
		// count 함수는 observable에 이어서 쓰면된다.
		Single<Long> source= Observable.fromArray(data)
				.count();
		source.subscribe(count -> Log.i("count is " + count));
		
		// 2. min() max()
		// min() 함수와 max() 함수는 to() 함수에 MathFlowable클래스의 min 함수와 max 함수를 호출하여 사용한다.
		// 참고로 to 함수는 형변환 함수라고 생각하면된다.
		// min 함수와 max 함수 둘다 반환 타입이 Flowable 타입이기 때문에 to 함수를 크게 신경쓰지 않아도 된다.
		
		Flowable.fromArray(data)
		.to(MathFlowable::min)
		.subscribe(min -> Log.i("min is " + min));
		
		Flowable.fromArray(data)
		.to(MathFlowable::max)
		.subscribe(max -> Log.i("max is " + max));
		
		// 3. sum() average()
		// min, max 함수와 동일한 패턴으로 사용한다.
		// average 함수에서 toFlowable 함수는 Observable을 Flowable로 만들기 위해 사용하는 함수이다.
		// BackpressureStrategy.BUFFER는 Flowable을 생성할 때 사용하는 배압 전략의 기본값이다. -> 8장에서 배움
		Flowable<Integer> flowable = Flowable.fromArray(data)
				.to(MathFlowable::sumInt);
		
		flowable.subscribe(sum -> Log.i("sum is " + sum));
		
		Flowable<Double> flowable2 = Observable.fromArray(data)
				.toFlowable(BackpressureStrategy.BUFFER)
				.to(MathFlowable::averageDouble);
		flowable2.subscribe(avg -> Log.i("average is " + avg));
					
	}
}
