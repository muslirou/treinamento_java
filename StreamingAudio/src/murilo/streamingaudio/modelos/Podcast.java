package murilo.streamingaudio.modelos;

import murilo.streamingaudio.calculadora.Classificacao;

public class Podcast extends Audio implements Classificacao {
    private String apresentador;
    private int numeroEpisodio;
    private String nomeEpisodio;
    private int totalVisualizacoes = 0;

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    @Override
    public int getClassificacao() {
        if (getTotalCurtidas() >= 50) {
            return 4;
        } else {
            return 2;
        }
    }

    @Override
    public void fichaTecnica() {
        super.fichaTecnica();
        System.out.println("Apresentador: " + apresentador);
        System.out.println("Título do Episódio: " + getNomeEpisodio());
        System.out.println("Número do Episódio: " + getNumeroEpisodio());
        System.out.println("Total de Visualizações: " + getTotalReproducoes());
        System.out.println("Classificação do Episódio: " + getClassificacao());
        System.out.println("");
    }
}
