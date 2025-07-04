package smartcity.sensor;

import smartcity.util.Localizacao;
import smartcity.exceptions.DataReadException;
import smartcity.central.CentralMonitoramentoAmbiental;

public class SensorRuido extends SensorAmbiental {
    public SensorRuido(String id, Localizacao localizacao) {
        super(id, localizacao);
    }

    @Override
    public double coletarDados() throws DataReadException {
        // Simular coleta de dados
        double nivel = 30 + (Math.random() * 90);
        
        // Gerar alertas se necessário
        if (nivel > 85) {
            CentralMonitoramentoAmbiental.getInstance()
                .adicionarAlerta("ALERTA: Nível de ruído alto em " + 
                getLocalizacao().getNome() + " (" + String.format("%.1f", nivel) + "dB)");
        }
        
        return nivel;
    }
}
