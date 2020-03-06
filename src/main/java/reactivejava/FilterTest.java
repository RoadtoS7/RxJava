package reactivejava;

import io.reactivex.*;

public class FilterTest {
	public void likeFilter() {
		Integer[] numbers = {100, 200, 300, 400, 500}
		Single<Integer> single;
		Observable<Integer> source;

		// 1. first
		single = Observable.fromArray(numbers).first(-1);
		single.subscribe(data -> System.out.println("first() value: " + data));

		// 2. last
		single = Observable.fromArray(numbers).last(999);
		single.subscribe(data -> System.out.println("last() value : " + data));
		
		// 3. take
		single = Observable.fromArray(numbers).take(3);
		single.subscribe(data -> System.out.println("take(3) value : " + data));
		
		// 4. takeLast
		single = Observable.fromArray(numbers).takeLast(3);
		single.subscribe(data -> System.out.println("takeLast(3) value : " + data));
		
		// 5. skip
		single = Observable.fromArray(numbers).skip(2);
		single.subscribe(data -> System.out.println("skip(2) value : " + data));
		
		// 6. skipLast(N)
		single = Observable.fromArray(numbers).skipLast(2);
		single.subscribe(data -> System.out.println("skipLast(2) value : " + data));
	}
}
