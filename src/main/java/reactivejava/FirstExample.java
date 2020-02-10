package reactivejava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.AsyncSubject;

public class FirstExample {


	public void emit() {
		// 1.���� Observable ���� Single ��ü�� ��ȯ�ϱ�.
		Observable<String> source = Observable.just("Hello Single");
		Single.fromObservable(source)
			.subscribe(System.out::println);
		
		// 2. Single �Լ��� �̿��� Single ��ü ����
		Observable.just("Hello Single")
			.single("Default ITem")
			.subscribe(System.out::println);
		
		// 3. fisrt�Լ��� ȣ���ؼ� Single ��ü ����
		String color[] = {"Red", "Blue", "Gold"};
		Observable.fromArray(color)
		.first("default value")
		.subscribe(System.out::println);
		
		
		// 4.empty observable ���� Single ��ü �����ϱ�
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		// 5. take() �Լ����� Single ��ü �����ϱ�
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


