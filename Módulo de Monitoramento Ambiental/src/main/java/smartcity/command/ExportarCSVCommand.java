package smartcity.command;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.util.GeradorRelatorio;
import java.time.LocalDateTime;

public class ExportarCSVCommand implements Command {
    private EstacaoAmbiental estacao;
    
    public ExportarCSVCommand(EstacaoAmbiental estacao) {
        this.estacao = estacao;
    }
    
    @Override
    public void execute() {
        String nomeArquivo = "dados_" + LocalDateTime.now().toString().replace(":", "-");
        GeradorRelatorio.salvarCSV(estacao, nomeArquivo);
    }
}
