package reactive.programs;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

public class Test1 {
	public static void main(String[] args) throws InterruptedException {

		Observable<String> ob = Observable.just("a", "b", "c", "d", "e", "f");
		TestScheduler scheduler = new TestScheduler();
		ob.concatMap(
				s->{
					int delay = new Random().nextInt(10);
					return Observable.just(s + "x")
							.delay(delay, TimeUnit.SECONDS, scheduler);
				}
			)
			.toList()
			.subscribe(System.out::println);
	
		scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
	}
}
