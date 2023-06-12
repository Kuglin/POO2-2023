public class Pessoa {
    private String nome;
    private Carro carro;

    public Pessoa(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }

    public void dirigirCarro() {
        System.out.println(nome + " está dirigindo o carro.");
        carro.acelerar();
    }
}
