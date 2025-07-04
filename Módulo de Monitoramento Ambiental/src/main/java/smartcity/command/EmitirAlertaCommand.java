package smartcity.command;

import smartcity.estacao.EstacaoAmbiental;

public class EmitirAlertaCommand implements Command {
    private EstacaoAmbiental estacao;
    
    public EmitirAlertaCommand(EstacaoAmbiental estacao) {
        this.estacao = estacao;
    }
    
    @Override
    public void execute() {
        System.out.println("=== ALERTAS DA ESTAÇÃO " + estacao + " ===");
        estacao.coletarDadosTodosSensores();
    }
}
