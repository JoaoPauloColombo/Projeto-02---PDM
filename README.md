===============================================================
FECAP - CIÊNCIA DA COMPUTAÇÃO - 2024/2  
PROGRAMAÇÃO DE DISPOSITIVOS MÓVEIS - PROF. VINÍCIUS HELTAI  
===============================================================

PRIMEIRO PROJETO PARA NOTA - NI
===============================================================

REGRAS DO PROJETO
===============================================================

Entrega: 30/09/2024 - 23h59

REGRA DO PROJETO:
- Grupo de no máximo 4 pessoas;
- No envio (projeto), deve constar no projeto o arquivo ".apk";
- O código do projeto deve constar em um diretório zip (todo o projeto);
- Todos os alunos do grupo devem postar no Moodle (mesmo sendo o mesmo projeto dos demais) a fim de registrar em processo avaliativo;
- O projeto deve estar alocado em um repositório no GitHub (1 repositório para todo o grupo);
- No repositório GitHub deve constar um arquivo README do projeto (contendo o nome completo e número de matrícula de todos os integrantes e uma pequena explicação do projeto);

===============================================================

ESCOPO DO PROJETO:
===============================================================

- Melhorar o app do IMC
- Cada resultado (abaixo do peso, peso normal, sobrepeso, etc) deve ser aberto em uma tela (activity) nova.
- Como sugestão, fazer tela de login (conforme aula) e entrada de dados. Após a análise, indicar um activity que oriente e passe informações sobre aquela classificação (além do IMC).
- Deve constar um botão ou uma figura (por exemplo X) que feche a janela e volte para a anterior.

===============================================================

## Descrição do Projeto

Este é o primeiro projeto de programação de dispositivos móveis para a disciplina de Programação de Dispositivos Móveis, lecionada pelo Prof. Vinícius Heltaí. O objetivo principal deste projeto é aprimorar um aplicativo de cálculo do Índice de Massa Corporal (IMC). A aplicação atual será modificada para fornecer classificações de IMC e validar as informações inseridas pelo usuário.

## Requisitos do Projeto

- **Classificação do IMC**:
  - IMC < 18,5 kg/m²: Baixo peso.
  - IMC entre 18,5 e 24,9 kg/m²: Peso normal.
  - IMC entre 25 e 29,9 kg/m²: Sobrepeso.
  - IMC entre 30 e 34,9 kg/m²: Obesidade grau 1.
  - IMC entre 35 e 39,9 kg/m²: Obesidade grau 2.
  - IMC > 40 kg/m²: Obesidade extrema.

- **Validação das Informações**:
  - Caso o usuário insira valores incorretos, o aplicativo deverá exibir:
    - `"resultado1" -> ERRO`
    - `"resultado2" -> ENTRADA INVÁLIDA`

## Equipe

- **Membro 1**: João Paulo Souza Colombo - 23025476
- **Membro 2**: Luciano Reis Massaro - 23025304
- **Membro 3**: Ettore Grecco - 23025294
- **Membro 4**: Nycolas Pedro Lagareiro - 23025468

## Estrutura do Repositório

- `app/`: Diretório contendo o código-fonte do aplicativo.
- `gradle/`: Diretório contendo scripts de configuração do Gradle.
- `build.gradle`: Arquivo de configuração do projeto.
- `settings.gradle`: Arquivo de configuração do Gradle para o projeto.
- `gradlew`: Script para executar o Gradle no Linux/Mac.
- `gradlew.bat`: Script para executar o Gradle no Windows.
- `README.md`: Arquivo README do projeto.
- `.gitignore`: Arquivo que define os arquivos que não devem ser versionados pelo Git.
- `.idea/`: Diretório do IntelliJ IDEA.

## Como Executar o Projeto

* Clone o repositório:

```bash
git clone https://github.com/JoaoPauloColombo/Projeto-02---PDM.git
