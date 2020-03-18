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
		// count �Լ��� observable�� �̾ ����ȴ�.
		Single<Long> source= Observable.fromArray(data)
				.count();
		source.subscribe(count -> Log.i("count is " + count));
		
		// 2. min() max()
		// min() �Լ��� max() �Լ��� to() �Լ��� MathFlowableŬ������ min �Լ��� max �Լ��� ȣ���Ͽ� ����Ѵ�.
		// ����� to �Լ��� ����ȯ �Լ���� �����ϸ�ȴ�.
		// min �Լ��� max �Լ� �Ѵ� ��ȯ Ÿ���� Flowable Ÿ���̱� ������ to �Լ��� ũ�� �Ű澲�� �ʾƵ� �ȴ�.
		
		Flowable.fromArray(data)
		.to(MathFlowable::min)
		.subscribe(min -> Log.i("min is " + min));
		
		Flowable.fromArray(data)
		.to(MathFlowable::max)
		.subscribe(max -> Log.i("max is " + max));
		
		// 3. sum() average()
		// min, max �Լ��� ������ �������� ����Ѵ�.
		// average �Լ����� toFlowable �Լ��� Observable�� Flowable�� ����� ���� ����ϴ� �Լ��̴�.
		// BackpressureStrategy.BUFFER�� Flowable�� ������ �� ����ϴ� ��� ������ �⺻���̴�. -> 8�忡�� ���
		Flowable<Integer> flowable = Flowable.fromArray(data)
				.to(MathFlowable::sumInt);
		
		flowable.subscribe(sum -> Log.i("sum is " + sum));
		
		Flowable<Double> flowable2 = Observable.fromArray(data)
				.toFlowable(BackpressureStrategy.BUFFER)
				.to(MathFlowable::averageDouble);
		flowable2.subscribe(avg -> Log.i("average is " + avg));
					
	}
}
