package controller;

public enum corSemaforo {
	VERDE(1000), AMARELO(300), VERMELHO(2000);

	private int tempoEspera;

	corSemaforo(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}
}
