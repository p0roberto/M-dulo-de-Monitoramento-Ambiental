package smartcity.factory;

import smartcity.sensor.SensorAmbiental;
import smartcity.sensor.SensorRuido;
import smartcity.util.Localizacao;

public class RuidoFactory implements SensorAmbientalFactory {
    @Override
    public SensorRuido criarSensor(String id, Localizacao localizacao) {
        return new SensorRuido(id, localizacao);
    }
}
