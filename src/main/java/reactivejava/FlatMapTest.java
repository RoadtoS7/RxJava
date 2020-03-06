package reactivejava;

import io.reactivex.*;
import io.reactivex.functions.Function;

public class FlatMapTest {
	
	public static void run() {
		Function<String, Observable<String>> getDoubleDiamonds =
				ball -> Observable.just(ball + "<>", ball + "<>");
				
		String[] balls = {"1", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.flatMap(getDoubleDiamonds);
		source.subscribe(Log::i);
	}
	
	public static void run2() {
		String[] balls = {"1", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.flatMap(ball -> Observable.just(ball + "<>", ball + "<>"));
		source.subscribe(System.out::println);
	}
}
