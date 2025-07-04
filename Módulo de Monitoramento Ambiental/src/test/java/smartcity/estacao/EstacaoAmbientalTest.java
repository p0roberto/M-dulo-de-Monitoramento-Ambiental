package smartcity.estacao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import smartcity.sensor.SensorQualidadeAr;
import smartcity.util.Localizacao;

class EstacaoAmbientalTest {
    
    @Test
    void testImplementaInterface() {
        EstacaoAmbiental estacao = new EstacaoAmbiental(new Localizacao("Centro"));
        assertTrue(estacao instanceof IEstacaoMonitoramento);
    }

    @Test
    void testRegistrarSensor() {
        EstacaoAmbiental estacao = new EstacaoAmbiental(new Localizacao("Centro"));
        SensorQualidadeAr sensor = new SensorQualidadeAr("QA-001", estacao.getLocalizacao());
        estacao.registrarSensor(sensor);
        assertEquals(1, estacao.getSensores().size());
    }
}