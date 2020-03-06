package reactivejava;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectTest {
	public void run() {
		ReplaySubject<String> subject = ReplaySubject.create();
		subject.subscribe(data -> System.out.println("1: " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("2: "+data));
		subject.onNext("5");
		subject.onComplete();
	}
}
