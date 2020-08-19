/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import org.w3c.dom.css.Counter;

/**
 *
 */
public class Control extends Thread {

	private final static int NTHREADS = 3;
	private final static int MAXVALUE = 30000000;
	private final static int TMILISECONDS = 5000;
	

	private final int NDATA = MAXVALUE / NTHREADS;

	private PrimeFinderThread pft[];
	private Timer tiempo;
	private AtomicInteger numPrimos;

	private Control() {
		super();
		numPrimos = new AtomicInteger(0);
		this.pft = new  PrimeFinderThread[NTHREADS];

		int i;
		for(i = 0;i < NTHREADS - 1; i++) {
			PrimeFinderThread elem = new PrimeFinderThread(i*NDATA, (i+1)*NDATA, numPrimos);
			pft[i] = elem;
		}
		pft[i] = new PrimeFinderThread(i*NDATA, MAXVALUE + 1, numPrimos);
		tiempo = new Timer();
	}

	public static Control newControl() {
		return new Control();
	}

	@Override
	public void  run() {
		for(int i = 0;i < NTHREADS;i++ ) {
			pft[i].start();
		}
		waitAll();
	}
	public void waitAll() {
		long timpoInicio= System.currentTimeMillis();
		boolean vivo = true;
		while (vivo) {
			if (System.currentTimeMillis() - timpoInicio>= TMILISECONDS) {
				for(int i = 0; i < NTHREADS ;i++ ) {
					pft[i].setEstado(false);
				}
				System.out.println("Primos encontrados:"+ numPrimos.toString());
				Scanner Linea = new Scanner(System.in);
                Linea.nextLine();
                for(int i = 0;i < NTHREADS;i++ ) {
					pft[i].aCorrer();
					if(pft[i].isAlive() && !vivo) {
						vivo=true;
					}
				}
                timpoInicio = System.currentTimeMillis();
			}
		}
	}

}
