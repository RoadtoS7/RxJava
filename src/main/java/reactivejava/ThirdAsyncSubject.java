package reactivejava;

import io.reactivex.subjects.AsyncSubject;

public class ThirdAsyncSubject {
	public static void afterOnComplete() {
		AsyncSubject<Integer> subject = AsyncSubject.create();
		subject.onNext(10);
		subject.onNext(11);
		subject.subscribe(data -> System.out.println("1: " +data));
		subject.onNext(12);
		subject.onComplete();
		subject.onNext(13);
		subject.subscribe(data -> System.out.println("2: " + data));
		subject.subscribe(data -> System.out.println("3: " +data));
	}
}
