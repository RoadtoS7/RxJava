package ch4_3;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.tuple.Pair;

import CommonUtils.Shape;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import reactivejava.CommonUtils;
import reactivejava.Log;

public class Zip {
	public static void run() {
		String[] shapes = {"BALL", "PENTAGON", "STAR"};
		String[] coloredTriangles = {"2-T", "6-T", "4-T"};
		
		Observable<String> source = Observable.zip(
				Observable.fromArray(shapes).map(Shape::getSuffix),
				Observable.fromArray(coloredTriangles).map(Shape::getColor),
				(suffix, color) -> color + suffix);
		
		source.subscribe(Log::i);
		
	}
	
	public static void ex1() {
		Observable<Integer> source = Observable.zip(
				Observable.just(100,  200,  300),
				Observable.just(10, 20, 30), 
				Observable.just(1, 2, 3),
				(a, b, c) -> a+b+c
				);
		
		source.subscribe(Log::i);
	}
	
	public static void ex2() {
		Observable<String> source = Observable.zip(
				Observable.just("RED", "GREEN", "BLUE"),
				Observable.interval(200L, TimeUnit.MILLISECONDS),
				(value, i) -> value
				);
		
		CommonUtils.exampleStart();
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
	}
	
	public static void ex3() {
		int index = 0;
		
		String[] data = {
				"100",
				"300"
		};
		
		Observable<Integer> basePrice = Observable.fromArray(data)
				.map(Integer::parseInt)
				.map(val ->{
					if(val <= 200) return 910;
					if(val <= 400) return 1600;
					return 7300;
				});
		
		Observable<Integer> usagePrice = Observable.fromArray(data)
				.map(Integer::parseInt)
				.map(val -> {
					double series1 = Math.min(200, val) * 93.3;
					double series2 = Math.min(200, Math.max(val - 200, 0)) * 187.9;
					double series3 = Math.min(0, Math.max(val - 400, 0)) * 280.6;
					
					return (int)(series1 + series2 + series3);
				});
		
		Observable<Integer> source = Observable.zip(
				basePrice,
				usagePrice,
				(v1, v2) -> v1 + v2
				);
		
		
		source.map(val ->new DecimalFormat("#,###").format(val))
		.subscribe(val ->{
			StringBuilder sb = new StringBuilder();
			sb.append("Usage: " + data[index] + "kwH => ");
			sb.append("Price: " + val + "원");
			Log.i(sb.toString());
			
//			index++; // 부수효과
		});			
	}
	
	public static void ex4() {
		String[] data = {
			"100",
			"300"
		};
		
		Observable<Integer> basePrice = Observable.fromArray(data)
				.map(Integer::parseInt)
				.map(val ->{
					if(val <= 200) return 910;
					if(val <= 400) return 1600;
					return 7300;
				});
		
		Observable<Integer> usagePrice = Observable.fromArray(data)
				.map(Integer::parseInt)
				.map(val ->{
					double series1 = Math.min(200, val - 200) * 93.3;
					double series2 = Math.min(200, Math.max(val - 200, 0)) * 187.9;
					double series3 = Math.max(0, Math.max(val - 400, 0)) * 280.6;
					
					return (int)(series1 + series2 + series3);
				});
		

		@NonNull Observable<Object> source = Observable.zip(
				basePrice, 
				usagePrice,
				Observable.fromArray(data),
				(v1, v2, i) -> Pair.of(i, v1+v2));
				
	}
	
	
	
}
