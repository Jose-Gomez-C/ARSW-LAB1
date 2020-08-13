/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {
	int num1, num2;
	public CountThread(int i, int j) {
       		num1=i;
       		num2=j;
    }
	@Override
	public void run() {
		for (int i= num1; i<num2; i++) {
			System.out.println(i);
		}
	}
	
}
