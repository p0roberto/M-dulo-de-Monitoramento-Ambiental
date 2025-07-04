package smartcity.util;

import java.util.HashMap;
import java.util.Map;

public class RelatorioAmbiental {
    private Map<String, Object> dados = new HashMap<>();

    public void adicionarDados(String chave, Object valor) {
        dados.put(chave, valor);
    }

    public Object getDado(String chave) {
        return dados.get(chave);
    }

    @Override
    public String toString() {
        return "RelatorioAmbiental{" + dados + "}";
    }
}
