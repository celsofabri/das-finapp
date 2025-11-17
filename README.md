# FinApp - Aplicativo de Gestão Financeira

FinApp é um aplicativo Android para gerenciamento de transações financeiras, permitindo o registro de débitos e créditos com visualização em extrato.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Usar](#como-usar)
- [Compilação via Linha de Comando](#compilação-via-linha-de-comando)
- [Testes](#testes)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Equipe](#equipe)
- [Licença](#licença)

## 🎯 Sobre o Projeto

O FinApp foi desenvolvido como parte da disciplina de Desenvolvimento de Aplicações para Sistemas Móveis. O aplicativo permite aos usuários registrar suas transações financeiras (débitos e créditos) e visualizá-las em um extrato organizado.

### Características Principais

- ✅ Interface intuitiva e responsiva
- ✅ Cadastro de transações (débito/crédito)
- ✅ Suporte a entrada de valores com vírgula como separador decimal (ex: 20,50)
- ✅ Validação de dados em tempo real
- ✅ Visualização de extrato com todas as transações
- ✅ Armazenamento em memória (sessão)
- ✅ Compatível com Android 5.0 (API 21) ou superior

## 🚀 Funcionalidades

### Tela Principal
- Acesso rápido ao cadastro de transações
- Visualização do extrato
- Opção de sair do aplicativo

### Cadastro de Transações
- Seleção do tipo de transação (Débito ou Crédito)
- Campo para descrição da transação
- Campo para valor monetário com suporte a vírgula decimal
- Validação de campos obrigatórios
- Validação de valores positivos
- Formatação automática de entrada numérica

### Extrato
- Lista de todas as transações registradas
- Exibição do tipo (Débito/Crédito)
- Descrição detalhada
- Valor formatado em moeda brasileira (R$)
- Ordenação por ordem de cadastro

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin 1.3.72
- **SDK Android**: API 28 (Android 9.0 Pie)
- **Minimum SDK**: API 21 (Android 5.0 Lollipop)
- **Build Tool**: Gradle 6.1.1
- **Android Gradle Plugin**: 4.0.2
- **IDE**: Android Studio

### Bibliotecas e Dependências

```gradle
- androidx.appcompat:appcompat:1.1.0
- com.google.android.material:material:1.0.0
- androidx.constraintlayout:constraintlayout:1.1.3
- junit:junit:4.13.2 (testes)
```

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

### Requisitos Obrigatórios

1. **JDK (Java Development Kit)**
   - Versão: JDK 8 ou superior (recomendado: JDK 11)
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://adoptium.net/)

2. **Android Studio**
   - Versão: Arctic Fox ou superior
   - Download: [Android Studio](https://developer.android.com/studio)

3. **Android SDK**
   - API Level 28 (Android 9.0 Pie) - obrigatório
   - Android SDK Build-Tools 28.0.3 ou superior
   - Android SDK Platform-Tools

4. **Git**
   - Para clonar o repositório
   - Download: [Git](https://git-scm.com/downloads)

### Requisitos de Sistema

- **RAM**: Mínimo 8 GB (recomendado: 16 GB)
- **Espaço em Disco**: Mínimo 4 GB livres
- **Sistema Operacional**: 
  - Windows 10/11 (64-bit)
  - macOS 10.14 (Mojave) ou superior
  - Linux (64-bit, testado no Ubuntu)

### Verificar Instalações

```bash
# Verificar Java
java -version

# Verificar Git
git --version

# Verificar Android SDK (após configuração)
adb --version
```

## 🔧 Instalação e Configuração

### 1. Clonar o Repositório

```bash
# Via HTTPS
git clone https://github.com/celsofabri/das-finapp.git

# Via SSH
git clone git@github.com:celsofabri/das-finapp.git

# Entrar no diretório do projeto
cd das-finapp
```

### 2. Configurar Android Studio

Para instruções detalhadas sobre como configurar o Android Studio, incluindo instalação do SDK e criação de emuladores, consulte:

📖 **[Guia Completo de Configuração do Android Studio](ANDROID_STUDIO_SETUP.md)**

### 3. Abrir o Projeto

1. Abra o Android Studio
2. Selecione **"Open an Existing Project"**
3. Navegue até o diretório `das-finapp`
4. Clique em **"OK"**

### 4. Sincronizar Dependências

O Android Studio irá automaticamente:
- Baixar as dependências do Gradle
- Sincronizar o projeto
- Indexar os arquivos

**Nota**: Este processo pode levar alguns minutos na primeira vez.

### 5. Configurar Emulador ou Dispositivo

**Opção A: Usar Emulador**
1. Tools → AVD Manager
2. Create Virtual Device
3. Selecione um dispositivo (recomendado: Pixel 3a)
4. Escolha a imagem do sistema: **Pie (API Level 28)**
5. Finalize a criação

**Opção B: Usar Dispositivo Físico**
1. Habilite as "Opções do Desenvolvedor" no dispositivo
2. Ative a "Depuração USB"
3. Conecte o dispositivo via USB
4. Aceite a autorização de depuração

### 6. Executar o Aplicativo

1. Selecione o dispositivo/emulador na barra de ferramentas
2. Clique no botão ▶️ (Run) ou pressione Shift+F10
3. Aguarde a compilação e instalação

## 💻 Como Usar

### Cadastrar uma Transação

1. Na tela principal, toque em **"Cadastro"**
2. Selecione o tipo de transação:
   - **Débito**: Para despesas/saídas
   - **Crédito**: Para receitas/entradas
3. Digite a descrição da transação
4. Digite o valor (use vírgula para decimais, ex: 20,50)
5. Toque em **"Salvar"**

### Visualizar Extrato

1. Na tela principal, toque em **"Extrato"**
2. Visualize todas as transações registradas
3. Cada item mostra:
   - Tipo (Débito/Crédito)
   - Descrição
   - Valor formatado

### Sair do Aplicativo

1. Na tela principal, toque em **"Sair"**
2. O aplicativo será fechado

## 🔨 Compilação via Linha de Comando

### Compilar o Projeto

```bash
# Limpar build anterior
./gradlew clean

# Compilar versão Debug
./gradlew assembleDebug

# Compilar versão Release
./gradlew assembleRelease

# Compilar todas as variantes
./gradlew build
```

### Instalar no Dispositivo

```bash
# Instalar versão Debug
./gradlew installDebug

# Instalar versão Release
./gradlew installRelease
```

### Executar Testes

```bash
# Executar todos os testes unitários
./gradlew test

# Executar testes com relatório detalhado
./gradlew test --info

# Visualizar relatório de testes
# Abra: app/build/reports/tests/testDebugUnitTest/index.html
```

### Comandos Úteis

```bash
# Listar todas as tarefas disponíveis
./gradlew tasks

# Verificar dependências
./gradlew dependencies

# Limpar cache do Gradle
./gradlew clean --no-daemon

# Build completo com testes
./gradlew clean build test
```

### Configurar Java para Gradle (se necessário)

```bash
# macOS/Linux - usar Java 11
export JAVA_HOME=/caminho/para/java11
./gradlew build

# Windows
set JAVA_HOME=C:\caminho\para\java11
gradlew.bat build
```

## 🧪 Testes

O projeto inclui testes unitários para validação da lógica de parsing de valores monetários.

### Executar Testes

**Via Android Studio:**
1. Navegue até `app/src/test/java/com/das/finapp/TransacaoValidationTest.kt`
2. Clique com botão direito no arquivo
3. Selecione **"Run 'TransacaoValidationTest'"**

**Via Linha de Comando:**
```bash
./gradlew test
```

### Cobertura de Testes

Os testes cobrem:
- ✅ Parsing de valores com vírgula decimal (20,50)
- ✅ Parsing de valores com ponto decimal (20.50)
- ✅ Validação de valores inválidos
- ✅ Validação de valores negativos
- ✅ Validação de valores zero
- ✅ Validação de valores muito grandes
- ✅ Tratamento de múltiplos separadores
- ✅ Tratamento de espaços em branco

### Visualizar Relatório de Testes

Após executar os testes, o relatório HTML estará disponível em:
```
app/build/reports/tests/testDebugUnitTest/index.html
```

## 📁 Estrutura do Projeto

```
das-finapp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/das/finapp/
│   │   │   │   ├── CadastroActivity.kt      # Tela de cadastro
│   │   │   │   ├── ExtratoActivity.kt       # Tela de extrato
│   │   │   │   ├── MainActivity.kt          # Tela principal
│   │   │   │   ├── Tipo.kt                  # Enum de tipos
│   │   │   │   ├── Transacao.kt             # Modelo de dados
│   │   │   │   ├── TransacaoAdapter.kt      # Adapter do RecyclerView
│   │   │   │   └── TransacoesRepo.kt        # Repositório em memória
│   │   │   ├── res/
│   │   │   │   ├── layout/                  # Arquivos de layout XML
│   │   │   │   ├── values/                  # Strings, cores, estilos
│   │   │   │   └── ...
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   │       └── java/com/das/finapp/
│   │           └── TransacaoValidationTest.kt  # Testes unitários
│   └── build.gradle                         # Configuração do módulo
├── gradle/                                  # Wrapper do Gradle
├── build.gradle                             # Configuração do projeto
├── settings.gradle                          # Configurações do Gradle
├── ANDROID_STUDIO_SETUP.md                  # Guia de configuração
└── README.md                                # Este arquivo
```

### Principais Componentes

#### Activities
- **MainActivity**: Tela inicial com navegação
- **CadastroActivity**: Formulário de cadastro de transações
- **ExtratoActivity**: Lista de transações registradas

#### Modelos
- **Transacao**: Data class para representar uma transação
- **Tipo**: Enum para tipos de transação (DEBITO, CREDITO)
- **TransacoesRepo**: Singleton para armazenamento em memória

#### Adapters
- **TransacaoAdapter**: Adapter para exibir transações no RecyclerView

## 👥 Equipe

Este projeto foi desenvolvido por:

- **Celso** - [GitHub](https://github.com/celsofabri)
- **Isabelle**
- **Rodrigo**

## 📝 Notas de Desenvolvimento

### Decisões Técnicas

1. **Armazenamento em Memória**: 
   - As transações são armazenadas em memória durante a sessão
   - Dados são perdidos ao fechar o aplicativo
   - Implementação futura pode incluir persistência com Room Database

2. **Suporte a Vírgula Decimal**:
   - Implementado TextWatcher para formatação em tempo real
   - Parsing flexível aceita vírgula ou ponto
   - Validação robusta de entrada numérica

3. **API Level 28**:
   - Mantido para compatibilidade com requisitos do projeto
   - Suporta 99%+ dos dispositivos Android ativos

### Melhorias Futuras

- [ ] Persistência de dados com Room Database
- [ ] Edição e exclusão de transações
- [ ] Filtros e busca no extrato
- [ ] Gráficos e relatórios
- [ ] Categorização de transações
- [ ] Exportação de dados (CSV, PDF)
- [ ] Backup e sincronização na nuvem
- [ ] Modo escuro
- [ ] Suporte a múltiplas moedas

## 🔗 Links Úteis

- **Repositório**: https://github.com/celsofabri/das-finapp
- **Issues**: https://github.com/celsofabri/das-finapp/issues
- **Android Developers**: https://developer.android.com/
- **Kotlin Documentation**: https://kotlinlang.org/docs/home.html

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte da disciplina de Desenvolvimento de Aplicações para Sistemas Móveis.

---

**Desenvolvido com ❤️ pela equipe FinApp**
