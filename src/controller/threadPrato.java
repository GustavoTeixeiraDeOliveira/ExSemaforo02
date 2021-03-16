package controller;


import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class threadPrato extends Thread{
	
	private int id;
	private Semaphore semaforo;
	
	public threadPrato(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run(){
		cozinhar(this.id);
		try {
			semaforo.acquire();
			entregaPrato(this.id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	
	public void cozinhar (int id) {
		double tempoTotal;
		double tempoCozimento = 0;
		if(id%2==0) {
			tempoTotal =((Math.random()*301)+500)/1000;
			DecimalFormat df = new DecimalFormat("0.00");

			while(tempoCozimento< tempoTotal){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tempoCozimento =  tempoCozimento + 0.1;
				 System.out.println("O "+id+"ª prato Sopa de Cebola Esta "+tempoCozimento+"/"+ df.format(tempoTotal) +" concluido");
				
			}
			System.out.println("O "+id+"ª prato Sopa de Cebola Esta concluido");
			
			
		}else{
			tempoTotal =(((Math.random()*601)+600)/1000);
			DecimalFormat df = new DecimalFormat("0.00");
			df.format(tempoTotal);
			while(tempoCozimento< tempoTotal){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tempoCozimento+=0.1;
				 System.out.println("O "+id+"ª prato Lasanha a Bolonhesa Esta "+tempoCozimento+"/"+df.format(tempoTotal) +" concluido");
				
			}
			System.out.println("O "+id+"ª prato Lasanha a Bolonhesa Esta concluido");
			
		}
	}
	
	public void entregaPrato(int id) {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id%2==0) {
		  System.out.println("O "+id+"ª prato Sopa de Cebola foi entregue");
		}else {
			System.out.println("O "+id+"ª prato Lasanha a Bolonhesa foi entregue");
		}
		
	}

}
