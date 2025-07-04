package smartcity.sensor;

import smartcity.util.Localizacao;
import smartcity.exceptions.DataReadException;

public abstract class SensorAmbiental {
    protected String id;
    protected Localizacao localizacao;
    protected int bateria;
    protected int frequenciaColeta;

    public SensorAmbiental(String id, Localizacao localizacao) {
        this.id = id;
        this.localizacao = localizacao;
        this.bateria = 100;
        this.frequenciaColeta = 1;
    }

    public String getId() {
        return id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public int getBateria() {
        return bateria;
    }

    public int getFrequenciaColeta() {
        return frequenciaColeta;
    }

    public boolean estaOperacional() {
        return bateria > 0;
    }

    public abstract double coletarDados() throws DataReadException;
}
