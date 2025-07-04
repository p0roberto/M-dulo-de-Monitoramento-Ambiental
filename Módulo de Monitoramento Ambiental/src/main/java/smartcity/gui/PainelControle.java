package smartcity.gui;

import smartcity.central.CentralMonitoramentoAmbiental;

public class PainelControle {
    public static void exibirMenu() {
        System.out.println("\n==== PAINEL DE CONTROLE ====");
        System.out.println("1. Ver relatório atual");
        System.out.println("2. Listar sensores");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void iniciar() {
        // Implementação simples via console
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        CentralMonitoramentoAmbiental central = CentralMonitoramentoAmbiental.getInstance();
        
        while(true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.println(central.getRelatorioGlobal());
                    break;
                case 2:
                    central.getEstacoes().forEach(estacao -> {
                        System.out.println("\n" + estacao.getRelatorioLocal());
                    });
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
