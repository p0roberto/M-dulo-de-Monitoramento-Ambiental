package smartcity.sensor;

import smartcity.util.Localizacao;
import smartcity.exceptions.DataReadException;
import smartcity.central.CentralMonitoramentoAmbiental;

public class SensorQualidadeAr extends SensorAmbiental {
    public SensorQualidadeAr(String id, Localizacao localizacao) {
        super(id, localizacao);
    }

    @Override
    public double coletarDados() throws DataReadException {
        // Simular coleta de dados
        double qualidade = Math.random() * 100;
        
        // Gerar alertas se necessário
        if (qualidade < 30) {
            CentralMonitoramentoAmbiental.getInstance()
                .adicionarAlerta("ALERTA: Qualidade do ar crítica em " + 
                getLocalizacao().getNome() + " (" + String.format("%.1f", qualidade) + "%)");
        }
        
        return qualidade;
    }
}
