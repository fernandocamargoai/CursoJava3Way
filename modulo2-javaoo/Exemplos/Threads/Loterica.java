import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Loterica {

	private static AtomicInteger contador = new AtomicInteger(0);
	private static Random random = new Random();
	private static Queue<Integer> fila = new LinkedList<>();

	public static void main(String[] args){
		Thread maquina = new Thread(Loterica::preenchaFila);

		Thread atendente1 = new Thread(Loterica::atenda);
		atendente1.setName("Atendente 1");
		Thread atendente2 = new Thread(Loterica::atenda);
		atendente2.setName("Atendente 2");
		Thread atendente3 = new Thread(Loterica::atenda);
		atendente3.setName("Atendente 3");

		maquina.start();
		atendente1.start();
		atendente2.start();
		atendente3.start();

		while (true){
			System.out.println("Contador: " + contador.get());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
		}
	}

	private static void atenda(){
		while (true){
			Integer proximo = null;
			synchronized (fila){
				while (true){
					proximo = fila.poll();
					if(proximo != null){
						break;
					}
					try {
						fila.wait();
					} catch (InterruptedException e) {

					}
				}
			}

			System.out.println(Thread.currentThread().getName() + ": atendeu a senha " + proximo);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {

			}
			contador.incrementAndGet();
		}
	}

	private static void preenchaFila(){
		for (int i=0; i< 1000; i++){
			synchronized (fila){
				fila.add(i);
				fila.notify();
			}
			try {
				Thread.sleep(random.nextInt(10000));
			} catch (InterruptedException e) {

			}
		}
	}
}
