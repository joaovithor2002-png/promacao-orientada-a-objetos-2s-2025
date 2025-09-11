public class Main {
    public static void main(String[] args) {
        Computador computador = new Computador (16, 502, 8, 23f);
        SistemaOperacional sistema = new SistemaOperacional (computador);
        
        Programa programa1 = new Programa (8, 200, 15, 1000);
        System.out.println("Executando programa 1:");
        sistema.executarPrograma(programa1);
        System.out.println();

        Programa programa2 = new Programa (32, 300, 10, 5000);
        System.out.println("Executando programa 2:");
        sistema.executarPrograma(programa2);
        System.out.println();

        Programa programa3 = new Programa (8, 300, 10, 5000);
         System.out.println("Executando programa 3:");
        sistema.executarPrograma(programa3);
        System.out.println();

    }
}