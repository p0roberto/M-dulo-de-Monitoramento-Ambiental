package smartcity.sensor;

public class ColetorDados implements Runnable {
    private SensorAmbiental sensor;

    public ColetorDados(SensorAmbiental sensor) {
        this.sensor = sensor;
    }

    @Override
    public void run() {
        try {
            while(sensor.estaOperacional()) {
                double valor = sensor.coletarDados();
                System.out.println("[COLETOR] " + sensor.getLocalizacao().getNome() + 
                    " - Valor: " + valor + 
                    " - Bateria: " + sensor.getBateria() + "%");
                
                Thread.sleep(sensor.getFrequenciaColeta() * 1000);
            }
            System.out.println("Coleta interrompida em " + sensor.getLocalizacao().getNome() + 
                " - Bateria esgotada");
        } catch (Exception e) {
            System.err.println("Erro no coletor: " + e.getMessage());
        }
    }
}
