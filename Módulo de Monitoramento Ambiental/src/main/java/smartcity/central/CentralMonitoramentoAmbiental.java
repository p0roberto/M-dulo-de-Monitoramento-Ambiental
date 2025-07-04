package smartcity.central;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.sensor.SensorAmbiental;
import smartcity.exceptions.DataReadException;
import java.util.ArrayList;
import java.util.List;

public class CentralMonitoramentoAmbiental {
    private static CentralMonitoramentoAmbiental instance;
    private List<EstacaoAmbiental> estacoes;
    private List<String> alertas;
    
    private CentralMonitoramentoAmbiental() {
        estacoes = new ArrayList<>();
        alertas = new ArrayList<>();
    }
    
    public static CentralMonitoramentoAmbiental getInstance() {
        if (instance == null) {
            instance = new CentralMonitoramentoAmbiental();
        }
        return instance;
    }
    
    public void adicionarEstacao(EstacaoAmbiental estacao) {
        estacoes.add(estacao);
    }
    
    public List<EstacaoAmbiental> getEstacoes() {
        return new ArrayList<>(estacoes);
    }
    
    public String getRelatorioGlobal() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== RELATÓRIO GLOBAL ===\n");
        
        for (EstacaoAmbiental estacao : estacoes) {
            relatorio.append("Estação: ").append(estacao.getLocalizacao().getNome()).append("\n");
            relatorio.append(estacao.getRelatorio().toString()).append("\n\n");
        }
        
        return relatorio.toString();
    }
    
    public void monitorarTodosSensores() {
        for (EstacaoAmbiental estacao : estacoes) {
            for (SensorAmbiental sensor : estacao.getSensores()) {
                try {
                    double valor = sensor.coletarDados();
                    System.out.println("Sensor " + sensor.getId() + " valor: " + valor);
                } catch (DataReadException e) {
                    System.err.println("Erro ao ler sensor " + sensor.getId() + ": " + e.getMessage());
                }
            }
        }
    }
    
    public void adicionarAlerta(String alerta) {
        alertas.add(alerta);
        if (alertas.size() > 10) {
            alertas.remove(0);
        }
    }
    
    public List<String> getAlertas() {
        return new ArrayList<>(alertas);
    }
}
