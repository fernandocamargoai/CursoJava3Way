public class Contadores {

	public static void main(String[] args){
		Thread thread1 = new Thread(Contadores::execute);
		thread1.setName("Thread1");
		thread1.setPriority(Thread.MAX_PRIORITY);
		Thread thread2 = new Thread(Contadores::execute);
		thread2.setName("Thread2");
		thread2.setPriority(Thread.MIN_PRIORITY);
		Thread thread3 = new Thread(Contadores::execute);
		thread3.setName("Thread3");
		Thread thread4 = new Thread(Contadores::execute);
		thread4.setName("Thread4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	private static void execute(){
		for(int i=0; i<1000; i++){
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

}
