package murilo.streamingaudio.calculadora;

public class Preferidas {

    public void filtroPreferidas(Classificacao classificacao){
        if (classificacao.getClassificacao() >= 4) {
            System.out.println("Faixa em alta");
        } else if (classificacao.getClassificacao() >= 2) {
            System.out.println("Faixa bem avaliada");
        } else {
            System.out.println("Inclua na lista para escutar mais tarde");
        }
    }
}
