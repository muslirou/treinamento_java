import murilo.streamingaudio.calculadora.Preferidas;
import murilo.streamingaudio.modelos.Musicas;
import murilo.streamingaudio.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musicas novaMusica = new Musicas();
        novaMusica.setTitulo("ALLIGATOR TEARS");
        novaMusica.setDuracaoMinutos(3);
        novaMusica.setCurtida(true);
        novaMusica.setCantor("Beyoncé");
        novaMusica.setAlbum("Cowboy Carter");
        novaMusica.setGenero("Country");
        novaMusica.setAnoLancamento(2024);
        novaMusica.setFaixa(13);
        novaMusica.setTotalReproducoes(98);

        novaMusica.fichaTecnica();

//        novaMusica.curtir();
//        novaMusica.reproduzir();

        //novaMusica.fichaTecnica();

        Podcast novoPodcast = new Podcast();
        novoPodcast.setTitulo("Medo e Delírio em Brasília");
        novoPodcast.setApresentador("Cristiano Botafogo");
        novoPodcast.setNumeroEpisodio(100);
        novoPodcast.setNomeEpisodio("Dias 631 a 639");
        novoPodcast.setCurtida(true);
        novoPodcast.setTotalCurtidas(300);
        novoPodcast.reproduzir();
        novoPodcast.curtir();
        novoPodcast.fichaTecnica();

        Preferidas minhasPreferidas = new Preferidas();
        minhasPreferidas.filtroPreferidas(novoPodcast);
    }
}
