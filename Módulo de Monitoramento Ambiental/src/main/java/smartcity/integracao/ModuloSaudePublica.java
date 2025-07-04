package smartcity.integracao;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.util.RelatorioAmbiental;

public class ModuloSaudePublica {
    public void enviarAlertasPopulacaoVulneravel(EstacaoAmbiental estacao) {
        RelatorioAmbiental relatorio = estacao.getRelatorio();
        System.out.println("Enviando alertas de saúde pública para a região: " 
            + estacao.getLocalizacao());
    }
}
