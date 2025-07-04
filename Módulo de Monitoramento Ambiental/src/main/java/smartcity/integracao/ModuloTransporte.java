package smartcity.integracao;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.util.RelatorioAmbiental;

public class ModuloTransporte {
    public void ajustarTrafego(EstacaoAmbiental estacao) {
        RelatorioAmbiental relatorio = estacao.getRelatorio();
        System.out.println("Ajustando tráfego na região: " 
            + estacao.getLocalizacao());
    }
}
