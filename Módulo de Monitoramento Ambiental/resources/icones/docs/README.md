# 🌱 Módulo de Monitoramento Ambiental Urbano Sustentável

Projeto desenvolvido como Trabalho Final da disciplina de **Programação Orientada a Objetos (POO)**.

## 📌 Descrição

Este sistema simula o monitoramento contínuo da qualidade do ar e dos níveis de ruído urbano em diferentes regiões de uma cidade inteligente, utilizando sensores ambientais estrategicamente distribuídos.

A proposta é fornecer **dados em tempo real** para apoiar **decisões sustentáveis**, gerar **alertas automáticos** e embasar **políticas públicas urbanas**.

---

## 🎯 Objetivos

- Monitorar ruído e poluição do ar em diferentes pontos da cidade.
- Gerar relatórios ambientais locais e globais.
- Emitir alertas automáticos em situações críticas.
- Fornecer uma interface gráfica intuitiva para acompanhamento em tempo real.
- Possibilitar integração com outros módulos da cidade inteligente (ex: transporte e saúde).

---

## 🧠 Conceitos e Padrões de Projeto

O projeto faz uso intensivo de conceitos de **POO**:

- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **Composição**
- **Interfaces e Classes Abstratas**

E aplica os seguintes **Padrões de Projeto**:

- **Factory Method**: criação de sensores ambientais.
- **Singleton**: controle centralizado na classe `CentralMonitoramentoAmbiental`.
- **Observer**: sensores notificam observadores em caso de dados críticos.
- **Command**: encapsula ações como gerar relatórios, emitir alertas e exportar dados.

---

## 💻 Funcionalidades

- Simulação de sensores de ruído e qualidade do ar com dados gerados aleatoriamente.
- Armazenamento de alertas (`alertas.log`) e relatórios (`relatorio_centro.txt`).
- Interface gráfica com Java Swing para visualização e controle da simulação.
- Integração com módulos externos:
  - Saúde pública (avisos para grupos vulneráveis).
  - Transporte (restrições de tráfego em áreas críticas).
- Exportação de relatórios em formato `.csv`.

---

## 🧪 Testes

Testes unitários com **JUnit**:

- `SensorQualidadeArTest.java`
- `SensorRuidoTest.java`
- `EstacaoAmbientalTest.java`

---

## 🖼️ Interface Gráfica

A GUI (`PainelAmbientalGUI`) exibe:

- Índices de poluição e ruído em tempo real.
- Botões para exportar relatórios e visualizar alertas.

---

## 📂 Recursos e Arquivos

- `alertas.log` – registro de alertas gerados.
- `relatorio_centro.txt` – relatório global consolidado.
- `resources/icones/` – ícones da interface.
- `sources.txt` – configuração de sensores.
- `target/` – arquivos compilados `.class`.

---

## 🚀 Execução

Para rodar o projeto:

```bash
javac -d target/classes $(find src/main/java -name "*.java")
java -cp target/classes smartcity.Main


## 👥 Autores

- Paulo Roberto de Almeida
- Luis Renato Pinto