package sistema_radar;

public class Radar {
    public Integer limiteVelocidade;
    public String localizacao;

    public Radar(Integer limiteVelocidade, String localizacao){
        this.limiteVelocidade = limiteVelocidade;
        this.localizacao = localizacao;
    }

    public void avaliarVelocidade(Carro carro) {
        if(carro.getVelocidade > this.limiteVelocidade){
            // emitir notificação
            emitirnotificacao(carro.getPlaca, carro.getVelocidade());
        }
    } //carro com C maiusculo define o tipo, minusculo define o objeto
    
    public void emitirnotificacao(String placa, Integer velocidadeObservada){

        System.out.println("placa: "+placa);
        System.out.println("velocidade observada: "+ velocidadeObservada); // o simbolo de mais é como se fosse um %d
        System.out.println("limite da via: "+ this.limiteVelocidade); // tem esse this porque já é uma informação do radar


    }

}