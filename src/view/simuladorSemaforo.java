package view;

import controller.threadSemaforo;

public class simuladorSemaforo {
	public static void main(String[] args) {
		threadSemaforo semaforo = new threadSemaforo();

		for (int i = 0; i < 10; i++) {
			System.out.println(semaforo.getCor());
			semaforo.esperaCorMudar();
		}
		semaforo.desligarSemaforo();
	}
}
