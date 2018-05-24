package reactive.programs;

import io.reactivex.Observable;

public class P05_RxJavaBasics {
	public static void main(String[] args) {
		
		Observable<String> ob = Observable.just("Hello", "World", "from", "reactive-world");
		// ob.subscribe(System.out::println);
		
		ob.doOnNext(System.out::println)
			.doOnComplete(()->System.out.println("No more data!"))
			.subscribe();
		
		Integer[] nums = {10, 20, 30, 40};
		Observable<Integer> ob1 = Observable.fromArray(nums);
		ob1.map(Math::sqrt)
			.subscribe(System.out::println);
		
		fibo(10)
			.doOnNext(n -> {
				System.out.printf("n=%d, thread=%s\n", 
						n, Thread.currentThread().getName());
				for(int i=0; i<25; i++) {
					System.out.println("*");
				}
			})
			.doOnComplete(()->System.out.println("No more fibo numbers"))
			.subscribe();
		
		line();
		
		Observable<Integer> numbersOb = Observable.range(1, 10);
		
		Observable.just("vinod", "vinay", "naveen", "ramesh")
			.map(s->s.substring(0, 3))
			.zipWith(numbersOb, 
					(name, num)->String.format("%d. %s", num, name))
			.doOnNext(System.out::println)
			.subscribe();
			

		
	}
	
	static void line() {
		System.out.println("-----------------------------");
	}

	static Observable<Integer> fibo(final int limit) {
		return Observable.create(subscriber->{
			// logic to generate and emit the fibo number 
			int a=-1, b=1, c, n=0;
			while(n++ < limit) {
				c = a + b;
				subscriber.onNext(c);
				a = b;
				b = c;
			}
			subscriber.onComplete();
		});
	}
	
	/*
		fibo(100)
			.doOnNext(n -> System.out.println(n))
			.doOnComplete(()->System.out.println("..."))
			.subscribe()
	 */
}













