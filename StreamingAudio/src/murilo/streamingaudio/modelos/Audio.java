package murilo.streamingaudio.modelos;

import murilo.streamingaudio.calculadora.Classificacao;

public class Audio {
    private String titulo;
    private int duracaoMinutos;
    private int totalReproducoes = 0;
    private boolean curtida;
    private int totalCurtidas = 0;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public void setTotalReproducoes(int totalReproducoes) {
        this.totalReproducoes = totalReproducoes;
    }

    public boolean isCurtida() {
        return curtida;
    }

    public void setCurtida(boolean curtidas) {
        this.curtida = curtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public void setTotalCurtidas(int totalCurtidas) {
        this.totalCurtidas = totalCurtidas;
    }

    public void reproduzir(){
        this.totalReproducoes++;
        System.out.println("Faixa sendo reproduzida");
    }

    public void curtir(){
        if(curtida){
            this.totalCurtidas++;
            System.out.println("Faixa curtida");
        }
    }

    public void fichaTecnica(){
        System.out.println("Nome do titulo: " + titulo);
        System.out.println("Duração da faixa (em minutos): " + getDuracaoMinutos());
        System.out.println("Total de reproduções: " + getTotalReproducoes());
        System.out.println("Total de Curtidas: " + getTotalCurtidas());

    }
}
