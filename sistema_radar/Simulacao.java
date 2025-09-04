package sistema_radar;

public class Simulacao {
    public static void main(String[] args) {
        System.out.println("Simulação");

        Carro bmw = new Carro("BMW2002", "320i", 2015, 0); // new para criar um novo objeto
    
        Radar radar = new Radar(60, "Pistão Sul");

        radar.avaliarVelocidade(bmw);

        bmw.acelerar(); // 10
        bmw.acelerar();
        bmw.acelerar();
        bmw.acelerar();
        bmw.acelerar();
        bmw.acelerar(); // limite da via 60
        bmw.acelerar(); // passou do limite 70

        radar.avaliarVelocidade(bmw);

        bmw.frear();

    }
}
