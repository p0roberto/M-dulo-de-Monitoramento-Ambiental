package smartcity.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerAlerta implements Observador {
    @Override
    public void atualizar(String mensagemAlerta) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String mensagemCompleta = "[" + timestamp + "] " + mensagemAlerta;
        
        // Log no console
        System.out.println(mensagemCompleta);
        
        // Log em arquivo
        try (FileWriter writer = new FileWriter("alertas.log", true)) {
            writer.write(mensagemCompleta + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
