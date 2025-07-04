package smartcity.estacao;

import smartcity.sensor.SensorAmbiental;
import smartcity.util.RelatorioAmbiental;
import smartcity.util.Localizacao;
import smartcity.exceptions.DataReadException;
import java.util.ArrayList;
import java.util.List;

public class EstacaoAmbiental implements IEstacaoMonitoramento {
    private Localizacao localizacao;
    private List<SensorAmbiental> sensores;
    
    public EstacaoAmbiental(Localizacao localizacao) {
        this.localizacao = localizacao;
        this.sensores = new ArrayList<>();
    }
    
    @Override
    public RelatorioAmbiental getRelatorio() {
        RelatorioAmbiental relatorio = new RelatorioAmbiental();
        for (SensorAmbiental sensor : sensores) {
            try {
                relatorio.adicionarDados(sensor.getId(), sensor.coletarDados());
            } catch (DataReadException e) {
                System.err.println("Erro ao coletar dados do sensor: " + e.getMessage());
            }
        }
        return relatorio;
    }
    
    public String getRelatorioLocal() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RELATÓRIO LOCAL ===\n");
        relatorio.append("Localização: ").append(localizacao.getNome()).append("\n");
        relatorio.append("Quantidade de sensores: ").append(sensores.size()).append("\n");
        
        for (SensorAmbiental sensor : sensores) {
            try {
                relatorio.append("Sensor ").append(sensor.getId())
                        .append(": ").append(sensor.coletarDados())
                        .append("\n");
            } catch (DataReadException e) {
                relatorio.append("Sensor ").append(sensor.getId())
                        .append(": ERRO - ").append(e.getMessage())
                        .append("\n");
            }
        }
        
        return relatorio.toString();
    }
    
    @Override
    public Localizacao getLocalizacao() {
        return localizacao;
    }
    
    @Override
    public void registrarSensor(SensorAmbiental sensor) {
        sensores.add(sensor);
    }
    
    public List<SensorAmbiental> getSensores() {
        return new ArrayList<>(sensores);
    }
    
    public void coletarDadosTodosSensores() {
        for (SensorAmbiental sensor : sensores) {
            try {
                double valor = sensor.coletarDados();
                System.out.println("Dados coletados do sensor " + sensor.getId() + 
                                 ": " + valor);
            } catch (DataReadException e) {
                System.err.println("Erro ao coletar dados do sensor " + 
                                 sensor.getId() + ": " + e.getMessage());
            }
        }
    }
}
