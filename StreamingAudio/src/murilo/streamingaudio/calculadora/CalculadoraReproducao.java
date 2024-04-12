package murilo.streamingaudio.calculadora;

import murilo.streamingaudio.modelos.Audio;

public class CalculadoraReproducao {
    private int totalReproducao = 0;

    public int getTotalReproducao(){
        return this.totalReproducao;
    }

    public void soma (Audio a){
        this.totalReproducao += a.getTotalReproducoes();
    }
}
