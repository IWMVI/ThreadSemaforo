package controller;

public class threadSemaforo implements Runnable {
	private corSemaforo cor;
	private boolean parar;
	private boolean corMudou;

	public threadSemaforo() {
		this.cor = corSemaforo.VERMELHO;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!parar) {
			try {
				Thread.sleep(this.cor.getTempoEspera());
				this.mudarCor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void mudarCor() {
		switch (this.cor) {
		case VERMELHO:
			this.cor = corSemaforo.VERDE;
			break;
		case AMARELO:
			this.cor = corSemaforo.VERMELHO;
			break;
		case VERDE:
			this.cor = corSemaforo.AMARELO;
			break;
		default:
			break;
		}
		this.corMudou = true;
		notify();
	}

	public synchronized void esperaCorMudar() {
		while (!this.corMudou) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;
	}

	public synchronized void desligarSemaforo() {
		this.parar = true;
	}

	public corSemaforo getCor() {
		return cor;
	}
}
