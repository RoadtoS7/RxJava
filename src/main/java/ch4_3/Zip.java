package ch4_3;

import CommonUtils.Shape;
import io.reactivex.rxjava3.core.Observable;
import reactivejava.Log;

public class Zip {
	public static void run() {
		String[] shapes = {"BALL", "PENTAGON", "STAR"};
		String[] coloredTriangles = {"2-T", "6-T", "4-T"};
		
		Observable<String> source = Observable.zip(
				Observable.fromArray(shapes).map(Shape::getSuffix),
				Observable.fromArray(coloredTriangles).map(Shape::getColor),
				(suffix, color) -> color + suffix);
		
		source.subscribe(Log::i);
		
	}
	
	public static void ex1() {
		Observable<Integer> source = Observable.zip(
				Observable.just(100,  200,  300),
				Observable.just(10, 20, 30), source3, source4, source5, source6, source7, source8, source9, zipper)
	}
}
