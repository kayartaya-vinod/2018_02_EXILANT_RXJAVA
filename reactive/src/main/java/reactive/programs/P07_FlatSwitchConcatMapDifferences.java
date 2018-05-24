package reactive.programs;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

public class P07_FlatSwitchConcatMapDifferences {

	public static void main(String[] args) {
		TestScheduler ts = new TestScheduler();
		
		Observable.just("a", "b", "c", "d", "e", "f")
			.flatMap(s-> { // replace with switchMap or concatMap to see the difference
				int dur = new Random().nextInt(10);
				return Observable.just(s + "*")
						.delay(dur, TimeUnit.SECONDS, ts);
			})
			.subscribe(System.out::println);
		
		ts.advanceTimeBy(1, TimeUnit.MINUTES);
		System.out.println("End of main!");
	}
}









