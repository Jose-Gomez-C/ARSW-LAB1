package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;

public class PrimeFinderThread extends Thread{


	int a,b;
	private Timer tiempo;

	private List<Integer> primes;
	private boolean estado;
	private int tMiliseconds;
	AtomicInteger numPrimos;
	public PrimeFinderThread(int a, int b, AtomicInteger numPrimos) {
		super();
		this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
		this.numPrimos=numPrimos;
		
		estado= false; 
		
	}

	@Override
	public void run(){
		estado= true;
		for (int i= a;i < b;i++){
			para();
			if (isPrime(i)){
				primes.add(i);
				numPrimos.getAndIncrement();
				//System.out.println(i);
			}
		}	
	}

	boolean isPrime(int n) {

		boolean ans;
		if (n > 2) { 
			ans = n%2 != 0;
			for(int i = 3;ans && i*i <= n; i+=2 ) {
				ans = n % i != 0;
			}
		} else {
			ans = n == 2;
		}
		return ans;
	}
	
	public void para() {
		
		synchronized (this) {
			while(!estado) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	public List<Integer> getPrimes() {
		return primes;
	}
	public synchronized void aCorrer() {
		estado = true;
		notify();
	}
	public void setEstado(boolean status) {
		estado = status;
	}
}
