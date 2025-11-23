import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FuncionarioDAO dao = new FuncionarioDAO();
        Scanner sc = new Scanner(System.in);

        int op = 0;

        while (op != 3) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("1 - Funcionário | 2 - Gerente: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    System.out.print("Salário base: ");
                    double salario = sc.nextDouble();

                    if (tipo == 1) {
                        dao.inserir(new Funcionario(0, nome, idade, salario));
                    } else {
                        System.out.print("Bonus: ");
                        double bonus = sc.nextDouble();
                        dao.inserir(new Gerente(0, nome, idade, salario, bonus));
                    }

                    System.out.println("Cadastrado com sucesso!");
                }

                case 2 -> {
                    System.out.println("\n--- Lista de Funcionários ---");
                    for (Funcionario f : dao.listar()) {
                        System.out.println(f);
                    }
                }

                case 3 -> System.out.println("Encerrando...");
            }
        }

        sc.close();
    }
}