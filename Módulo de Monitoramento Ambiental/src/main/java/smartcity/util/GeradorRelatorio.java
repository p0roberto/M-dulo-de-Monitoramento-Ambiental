package smartcity.util;

import smartcity.estacao.EstacaoAmbiental;
import smartcity.sensor.SensorAmbiental;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorRelatorio {
    public static void salvarRelatorio(RelatorioAmbiental relatorio, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(relatorio.toString());
            System.out.println("Relatório salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }

    public static void salvarCSV(EstacaoAmbiental estacao, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("Sensor,Localizacao,Valor\n");
            for (SensorAmbiental sensor : estacao.getSensores()) {
                try {
                    double valor = sensor.coletarDados();
                    writer.write(String.format("%s,%s,%.2f\n", 
                        sensor.getId(), 
                        sensor.getLocalizacao().getNome(),
                        valor));
                } catch (Exception e) {
                    System.err.println("Erro ao coletar dados para CSV: " + e.getMessage());
                }
            }
            System.out.println("Dados salvos em CSV: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }
}
