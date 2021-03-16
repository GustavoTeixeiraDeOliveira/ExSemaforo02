package view;
import java.util.concurrent.Semaphore;

import controller.threadPrato;

public class Main {

	public static void main(String[] args) {
		 Semaphore semaforo = new Semaphore(1);
		 for(int idThread = 1; idThread< 6; idThread++) {
			 threadPrato threadPrato = new threadPrato(idThread, semaforo);
			 threadPrato.start();
         }
	}

}
