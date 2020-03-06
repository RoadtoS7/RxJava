package reactivejava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

import CommonUtils.Shape;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Supplier;

public class Defer {
	private static Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();
	
	public static void run() {
		Supplier<Observable<String>> supplier = () -> getObservable();
		Observable<String> source = Observable.defer(supplier);
		
		source.subscribe(val -> Log.i("Subscriber #1:" + val));
		source.subscribe(val -> Log.i("Subscriber #2:" + val));
	}
	
	
	private static Observable<String> getObservable() {
		if(colors.hasNext()) {
			String color = colors.next();
			return Observable.just(
					Shape.getString(color, Shape.BALL), 
					Shape.getString(color, Shape.RECTANGLE), 
					Shape.getString(color, Shape.PENTAGON));
		}
		
		return Observable.empty();
	}
	
	public static void run2() {
		Observable<String> source = getObservable();
		source.subscribe(val -> Log.i("Subscriber #1:" + val));
		source.subscribe(val -> Log.i("Subscriber #2:" + val));
	}
}
