import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lotetica3 {

	private List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
	private static Random random = new Random();
//	private static ExecutorService executorService = Executors.newFixedThreadPool(3);
	private static ExecutorService executorService = Executors.newCachedThreadPool();

	public static void main(String[] args){
		for(int i=0; i<1000; i++){
			executorService.execute(new Atendimento(i));
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {

			}
		}
	}

	private static class Atendimento implements Runnable {

		private int senha;

		public Atendimento(int senha) {
			this.senha = senha;
		}


		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ": atendeu a senha " + senha);
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
//				return;
			}
		}
	}

}
