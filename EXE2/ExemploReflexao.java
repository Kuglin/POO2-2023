import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ExemploReflexao {
    public static void main(String[] args) {

        // Inspeção da classe Veiculo
        Class<?> veiculoClass = Veiculo.class;

        System.out.println("=== Classe Veiculo ===");
        System.out.println("Atributos:");

        Field[] veiculoFields = veiculoClass.getDeclaredFields();

        for (Field field : veiculoFields) {
            System.out.println(field.getName());
        }

        System.out.println("Métodos:");

        Method[] veiculoMethods = veiculoClass.getDeclaredMethods();

        for (Method method : veiculoMethods) {
            System.out.println(method.getName());
        }

        try {
            Veiculo veiculo = new Veiculo("Ford", "Mustang");
            Method acelerarMethod = veiculoClass.getDeclaredMethod("acelerar");
            acelerarMethod.invoke(veiculo);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        // Inspeção da classe Carro

        Class<?> carroClass = Carro.class;
        System.out.println("=== Classe Carro ===");
        System.out.println("Atributos:");
        Field[] carroFields = carroClass.getDeclaredFields();

        for (Field field : carroFields) {
            System.out.println(field.getName());
        }

        System.out.println("Métodos:");
        Method[] carroMethods = carroClass.getDeclaredMethods();
        for (Method method : carroMethods) {
            System.out.println(method.getName());
        }

        // Execução do método ligar da classe Carro

        try {
            Carro carro = new Carro("Toyota", "Corolla", 2021);
            Method ligarMethod = carroClass.getDeclaredMethod("ligar");
            ligarMethod.invoke(carro);

        }
        
        catch (Exception e) {
            e.printStackTrace();
        }

        // Inspeção da classe Pessoa
        Class<?> pessoaClass = Pessoa.class;
        System.out.println("=== Classe Pessoa ===");
        System.out.println("Atributos:");

        Field[] pessoaFields = pessoaClass.getDeclaredFields();

        for (Field field : pessoaFields) {
            System.out.println(field.getName());
        }

        System.out.println("Métodos:");
        Method[] pessoaMethods = pessoaClass.getDeclaredMethods();

        for (Method method : pessoaMethods) {
            System.out.println(method.getName());
        }

        // Execução do método dirigirCarro da classe Pessoa
        try {
            Carro carro = new Carro("Fiat", "Palio", 2019);
            Pessoa pessoa = new Pessoa("João", carro);
            Method dirigirCarroMethod = pessoaClass.getDeclaredMethod("dirigirCarro");
            dirigirCarroMethod.invoke(pessoa);
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
