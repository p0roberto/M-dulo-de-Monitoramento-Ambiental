package smartcity.observer;

import java.util.ArrayList;
import java.util.List;

public class SensorObservable {
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void removerObservador(Observador obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores(String mensagem) {
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
        }
    }
}
