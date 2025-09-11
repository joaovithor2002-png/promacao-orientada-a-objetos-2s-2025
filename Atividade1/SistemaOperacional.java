public class SistemaOperacional {
    private Computador computador;

    public SistemaOperacional(Computador computador) {
        this.computador = computador;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public boolean executarPrograma(Programa programa) {
        if (programa.getSSDOcupado() > computador.getSSD()) {
            System.out.println("Erro na instalação do programa!");
            return false;
        }

        if (programa.getMemoriaRAMAlocada() > computador.getMemoriaRAM()) {
            System.out.println("Erro na execução do programa!");
            return false;
        }

        float tempoExecucao = (float) programa.getQuantidadeOperacoes() /
                (computador.getOperacoesPorSegundo() * computador.getNucleos());

        System.out.println("Programa executado com sucesso.");
        System.out.printf("Tempo de execução: %.2f segundos\n", tempoExecucao);

    }
}
