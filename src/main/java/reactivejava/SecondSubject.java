package reactivejava;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class SecondSubject {
	public static void subjectAsSubscrier(){
		Float[] temperature = {10.1f, 13.4f, 12.5f}; 
		Observable<Float> source = Observable.fromArray(temperature);// �µ� �����͸� ��� Observable
		
		AsyncSubject<Float> subject = AsyncSubject.create(); 
		subject.subscribe(data -> System.out.println(data)); // data�� ������ �� �ֵ��� subscribe()�Լ��� ȣ��
		source.subscribe(subject); // subject ������ observable�� source�� �����Ѵ�.
	}


}
