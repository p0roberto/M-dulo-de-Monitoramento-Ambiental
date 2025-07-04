package smartcity.command;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.util.GeradorRelatorio;

public class GerarRelatorioCommand implements Command {
    private EstacaoAmbiental estacao;
    private String nomeArquivo;

    public GerarRelatorioCommand(EstacaoAmbiental estacao, String nomeArquivo) {
        this.estacao = estacao;
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void execute() {
        GeradorRelatorio.salvarRelatorio(estacao.getRelatorio(), nomeArquivo);
    }
}
