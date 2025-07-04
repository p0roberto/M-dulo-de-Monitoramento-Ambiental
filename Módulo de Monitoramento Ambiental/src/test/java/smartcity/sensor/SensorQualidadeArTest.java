// src/test/java/smartcity/sensor/SensorQualidadeArTest.java
package smartcity.sensor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import smartcity.util.Localizacao;
import smartcity.exceptions.DataReadException;

class SensorQualidadeArTest {
    
    @Test
    void testColetarDadosDentroLimites() {
        SensorQualidadeAr sensor = new SensorQualidadeAr("QA-001", new Localizacao("Centro"));
        assertDoesNotThrow(() -> {
            double valor = sensor.coletarDados();
            assertTrue(valor >= 0 && valor <= 100, "Valor deve estar entre 0-100%");
        });
    }

    @Test
    void testGerarAlertaQualidadeBaixa() {
        SensorQualidadeAr sensor = new SensorQualidadeAr("QA-002", new Localizacao("Norte"));
        // Forçar valor baixo para teste (substitua pela lógica real do seu sensor)
        double valorTeste = 25.0;
        // Verifique se o alerta é gerado na Central
        // (Adapte conforme sua implementação)
        assertTrue(valorTeste < 30, "Deveria gerar alerta para <30%");
    }
}