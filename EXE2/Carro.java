public class Carro extends Veiculo {
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo);
        this.ano = ano;
    }

    public void ligar() {
        System.out.println("O carro está ligado.");
    }
}
