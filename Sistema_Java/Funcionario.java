public class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(int id, String nome, int idade, double salario) {
        super(id, nome, idade);
        this.salario = salario;
    }

    public double getSalarioBase() {
        return salario;
    }

    public double calcularSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + " | Idade: " + idade + " | Salário: " + calcularSalario();
    }
}