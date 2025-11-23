public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(int id, String nome, int idade, double salario, double bonus) {
        super(id, nome, idade, salario);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return salario + bonus;
    }

    @Override
    public String toString() {
        return "Gerente: " + nome + " | Idade: " + idade + " | Salário: " + calcularSalario();
    }
}