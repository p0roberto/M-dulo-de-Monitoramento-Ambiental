package smartcity.estacao;

import smartcity.sensor.SensorAmbiental;
import smartcity.util.RelatorioAmbiental;
import smartcity.util.Localizacao;

public interface IEstacaoMonitoramento {
    RelatorioAmbiental getRelatorio();
    Localizacao getLocalizacao();
    void registrarSensor(SensorAmbiental sensor);
}
