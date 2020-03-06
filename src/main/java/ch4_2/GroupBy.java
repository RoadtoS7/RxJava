package ch4_2;

import CommonUtils.Shape;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;


public class GroupBy {
	public static void run() {
		String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
		
		Observable<GroupedObservable<String, String>> source =
				Observable.fromArray(objs).groupBy(Shape::getShape);
		
		
		source.subscribe(obj ->{
			obj.subscribe(val -> System.out.println("GROUP: " + obj.getKey() + "VALUE: " + val));
		});
	}
	
	public static void runBall() {
		String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
		
		Observable<GroupedObservable<String, String>> source = 
				Observable.fromArray(objs).groupBy(Shape::getShape);
		
		source.subscribe(obj ->{
			obj.filter(val -> obj.getKey().equals(Shape.BALL))
			.subscribe(val -> 
				System.out.println("GROUP: " + obj.getKey() + "\t VALUE: " + val)
			);
		});
	}
}
