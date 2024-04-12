package murilo.streamingaudio.modelos;

public class Musicas extends Audio{
    private String cantor;
    private String album;
    private int anoLancamento;
    private int faixa;
    private String genero;

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getFaixa() {
        return faixa;
    }

    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void fichaTecnica() {
        super.fichaTecnica();
        System.out.println("Artista: " + cantor);
        System.out.println("Album: " + album);
        System.out.println("Gênero Musical: " + genero);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Faixa: " + faixa);
        System.out.println("Classificação da Faixa: " + getClassificacao());
        System.out.println("");
    }

    public int getClassificacao() {
        if (getTotalReproducoes() >= 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
