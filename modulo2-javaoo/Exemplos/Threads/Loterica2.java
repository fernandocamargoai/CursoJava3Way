import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Loterica2 {

	private static AtomicInteger contador = new AtomicInteger(0);
	private static Random random = new Random();
	private static BlockingQueue<Integer> fila = new LinkedBlockingQueue<>();

	public static void main(String[] args){
		Thread maquina = new Thread(Loterica2::preenchaFila);

		Thread atendente1 = new Thread(Loterica2::atenda);
		atendente1.setName("Atendente 1");
		Thread atendente2 = new Thread(Loterica2::atenda);
		atendente2.setName("Atendente 2");
		Thread atendente3 = new Thread(Loterica2::atenda);
		atendente3.setName("Atendente 3");

		maquina.start();
		atendente1.start();
		atendente2.start();
		atendente3.start();

//		while (true){
//			System.out.println("Contador: " + contador.get());
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//
//			}
//		}
		try {
			maquina.join();
		} catch (InterruptedException e) {

		}
		atendente1.interrupt();
		atendente2.interrupt();
		atendente3.interrupt();

		System.out.println("Contador: " + contador.get());
	}

	private static void atenda(){
		while (true){
			Integer proximo = null;
			try {
				proximo = fila.take();
			} catch (InterruptedException e) {

			}

			System.out.println(Thread.currentThread().getName() + ": atendeu a senha " + proximo);
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
//				return;
			}
			contador.incrementAndGet();
		}
	}

	private static void preenchaFila(){
		for (int i=0; i< 100; i++){
			fila.add(i);
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {

			}
		}
	}
}
