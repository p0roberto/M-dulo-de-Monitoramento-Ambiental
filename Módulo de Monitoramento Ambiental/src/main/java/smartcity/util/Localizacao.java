package smartcity.util;

public class Localizacao {
    private String nome;

    public Localizacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
