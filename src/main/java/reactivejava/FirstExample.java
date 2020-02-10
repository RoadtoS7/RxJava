package reactivejava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.AsyncSubject;

public class FirstExample {


	public void emit() {
		// 1.기존 Observable 에서 Single 객체로 변환하기.
		Observable<String> source = Observable.just("Hello Single");
		Single.fromObservable(source)
			.subscribe(System.out::println);
		
		// 2. Single 함수를 이용해 Single 객체 생성
		Observable.just("Hello Single")
			.single("Default ITem")
			.subscribe(System.out::println);
		
		// 3. fisrt함수를 호출해서 Single 객체 생성
		String color[] = {"Red", "Blue", "Gold"};
		Observable.fromArray(color)
		.first("default value")
		.subscribe(System.out::println);
		
		
		// 4.empty observable 에서 Single 객체 생성하기
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		// 5. take() 함수에서 Single 객체 생성하기
		Observable.just(new Order("ORD-1"), new Order("ORD-2"))
		.take(1)
		.single(new Order("default order"))
		.subscribe(System.out::println);			
		
	}
	
	public static void main(String[] args) {
		AsyncSubject<String> subject = AsyncSubject.create();
		subject.subscribe(data -> System.out.println(data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println(data));
		subject.onNext("5");
		subject.onComplete();
		
	}
}


