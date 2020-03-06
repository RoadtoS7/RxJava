package reactivejava;

import javax.xml.crypto.Data;

import org.apache.commons.math3.ml.neuralnet.twod.util.TopographicErrorHistogram;

import CommonUtils.Timer;
import ch4_2.ConcatMap;
import ch4_2.GroupBy;
import ch4_2.Scan;
import ch4_2.SwitchMap;
import ch4_3.Zip;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.AsyncSubject;

public class FirstExample {
	public void runSubject() {
		AsyncSubject<String> subject = AsyncSubject.create();
		subject.subscribe(data -> System.out.println(data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println(data));
		subject.onNext("5");
		subject.onComplete();
	}
	
		public static void main(String[] args) {
			Zip.run();
	}
}


