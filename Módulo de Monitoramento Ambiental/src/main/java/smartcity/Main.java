package smartcity;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.util.Localizacao;
import smartcity.sensor.*;
import smartcity.central.CentralMonitoramentoAmbiental;
import smartcity.gui.PainelAmbientalGUI;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Configuração inicial
        CentralMonitoramentoAmbiental central = CentralMonitoramentoAmbiental.getInstance();
        
        // Criar estações e sensores
        EstacaoAmbiental centro = new EstacaoAmbiental(new Localizacao("Centro"));
        centro.registrarSensor(new SensorQualidadeAr("QA-001", centro.getLocalizacao()));
        centro.registrarSensor(new SensorRuido("R-001", centro.getLocalizacao()));
        
        EstacaoAmbiental norte = new EstacaoAmbiental(new Localizacao("Norte"));
        norte.registrarSensor(new SensorQualidadeAr("QA-002", norte.getLocalizacao()));
        
        central.adicionarEstacao(centro);
        central.adicionarEstacao(norte);

        // Iniciar interface
        SwingUtilities.invokeLater(() -> {
            PainelAmbientalGUI gui = new PainelAmbientalGUI();
            gui.setVisible(true);
        });
    }
}
