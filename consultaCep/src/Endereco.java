import consultaCep.EnderecoViaCep;

public class Endereco implements Comparable<Endereco> {
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int ddd;

    public Endereco(EnderecoViaCep meuEnderecoViaCep){
        this.cep =meuEnderecoViaCep.cep();
        this.endereco = meuEnderecoViaCep.logradouro();
        this.complemento = meuEnderecoViaCep.complemento();
        this.bairro = meuEnderecoViaCep.bairro();
        this.cidade = meuEnderecoViaCep.localidade();
        this.estado = meuEnderecoViaCep.uf();
        this.ddd = meuEnderecoViaCep.ddd();
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getDdd() {
        return ddd;
    }

    public String getComplemento() {
        return complemento;
    }

    @Override
    public int compareTo(Endereco outroEndereco) {
        return this.getCep().compareTo(outroEndereco.getCep());
    }

    @Override
    public String toString() {
        return "Cep: " + cep + ", Endereço: " + endereco
                + ", Complemento: " + complemento + ", Bairro: " + bairro + ", Cidade: " +
                cidade + ", Estado: " + estado + ", DDD: " + ddd;
    }
}
