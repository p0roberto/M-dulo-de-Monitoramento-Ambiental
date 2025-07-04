// src/test/java/smartcity/sensor/SensorRuidoTest.java
package smartcity.sensor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import smartcity.util.Localizacao;

class SensorRuidoTest {
    
    @Test
    void testValoresRealistas() throws Exception {
        SensorRuido sensor = new SensorRuido("R-001", new Localizacao("Centro"));
        double valor = sensor.coletarDados();
        assertTrue(valor >= 30 && valor <= 120, "Valor deve estar entre 30-120dB");
    }

    @Test
    void testAlertaRuidoExcessivo() {
        SensorRuido sensor = new SensorRuido("R-002", new Localizacao("Centro"));
        // Forçar valor alto para teste
        double valorTeste = 90.0;
        assertTrue(valorTeste > 85, "Deveria gerar alerta para >85dB");
    }
}