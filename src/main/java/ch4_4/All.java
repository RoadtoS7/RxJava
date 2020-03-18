package ch4_4;

import CommonUtils.Shape;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import reactivejava.Log;

public class All {
	public static void run() {
		String[] data = {"1", "2", "3", "4", "5", "6"};
		
		Single<Boolean> source = Observable.fromArray(data)
				.map(Shape::getShape)
				.all(Shape.BALL::equals);
		
		source.subscribe(Log::i);
		
	}
}
