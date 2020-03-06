package reactivejava;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class SecondSubject {
	public static void subjectAsSubscrier(){
		Float[] temperature = {10.1f, 13.4f, 12.5f}; 
		Observable<Float> source = Observable.fromArray(temperature);// 온도 데이터를 담는 Observable
		
		AsyncSubject<Float> subject = AsyncSubject.create(); 
		subject.subscribe(data -> System.out.println(data)); // data를 수신할 수 있도록 subscribe()함수를 호출
		source.subscribe(subject); // subject 변수는 observable인 source를 구독한다.
	}


}
