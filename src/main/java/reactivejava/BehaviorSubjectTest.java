package reactivejava;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectTest {
	public static void runBehaviorSubjet() {
		BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
		subject.subscribe(data -> System.out.println("1: " + data));
		subject.onNext("1");
		subject.onNext("3");		
		subject.subscribe(data -> System.out.println("2: "+ data));
		subject.onNext("5");
		subject.onComplete();
	}
}
