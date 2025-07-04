package smartcity.factory;

import smartcity.sensor.SensorAmbiental;
import smartcity.util.Localizacao;

public interface SensorAmbientalFactory {
    SensorAmbiental criarSensor(String id, Localizacao localizacao);
}
