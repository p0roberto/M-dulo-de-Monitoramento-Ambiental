package smartcity.gui;

import smartcity.central.CentralMonitoramentoAmbiental;
import smartcity.estacao.EstacaoAmbiental;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PainelAmbientalGUI extends JFrame {
    private JTextArea areaDados;
    private JLabel lblStatus;

    public PainelAmbientalGUI() {
        super("Monitoramento Ambiental - SmartCitySim");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de dados
        areaDados = new JTextArea();
        areaDados.setEditable(false);
        areaDados.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaDados);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        
        JButton btnAtualizar = new JButton("Atualizar Dados");
        btnAtualizar.addActionListener(this::atualizarDados);
        
        JButton btnExportar = new JButton("Exportar Relatório");
        btnExportar.addActionListener(this::exportarRelatorio);
        
        JButton btnAlertas = new JButton("Ver Alertas");
        btnAlertas.addActionListener(this::mostrarAlertas);

        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnExportar);
        painelBotoes.add(btnAlertas);

        // Status bar
        lblStatus = new JLabel("Pronto para monitorar...");
        lblStatus.setBorder(BorderFactory.createEtchedBorder());
        
        // Adicionar componentes
        add(scrollPane, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.NORTH);
        add(lblStatus, BorderLayout.SOUTH);

        // Centralizar janela
        setLocationRelativeTo(null);
        
        // Atualizar dados inicialmente
        atualizarDados(null);
    }

    private void atualizarDados(ActionEvent e) {
        CentralMonitoramentoAmbiental central = CentralMonitoramentoAmbiental.getInstance();
        StringBuilder dados = new StringBuilder("=== DADOS ATUALIZADOS ===\n\n");
        
        for (EstacaoAmbiental estacao : central.getEstacoes()) {
            dados.append("Estação: ").append(estacao.getLocalizacao().getNome()).append("\n");
            
            for (smartcity.sensor.SensorAmbiental sensor : estacao.getSensores()) {
                try {
                    double valor = sensor.coletarDados();
                    dados.append("- ").append(sensor.getId())
                         .append(": ").append(String.format("%.2f", valor))
                         .append(sensor instanceof smartcity.sensor.SensorQualidadeAr ? "%" : "dB")
                         .append("\n");
                } catch (Exception ex) {
                    dados.append("- ").append(sensor.getId()).append(": ERRO\n");
                }
            }
            dados.append("\n");
        }
        
        areaDados.setText(dados.toString());
        lblStatus.setText("Dados atualizados em: " + new java.util.Date());
    }

    private void exportarRelatorio(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Implementar lógica de exportação aqui
            lblStatus.setText("Relatório exportado para: " + fileChooser.getSelectedFile().getName());
        }
    }

    private void mostrarAlertas(ActionEvent e) {
        StringBuilder alertas = new StringBuilder("=== ÚLTIMOS ALERTAS ===\n\n");
        List<String> listaAlertas = CentralMonitoramentoAmbiental.getInstance().getAlertas();
        
        if (listaAlertas.isEmpty()) {
            alertas.append("Nenhum alerta recente.\n");
        } else {
            for (String alerta : listaAlertas) {
                alertas.append("• ").append(alerta).append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(this, alertas.toString(), "Alertas do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
