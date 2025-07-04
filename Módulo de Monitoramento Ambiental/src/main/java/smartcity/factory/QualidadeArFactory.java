package smartcity.factory;

import smartcity.sensor.SensorAmbiental;
import smartcity.sensor.SensorQualidadeAr;
import smartcity.util.Localizacao;

public class QualidadeArFactory implements SensorAmbientalFactory {
    @Override
    public SensorQualidadeAr criarSensor(String id, Localizacao localizacao) {
        return new SensorQualidadeAr(id, localizacao);
    }
}
