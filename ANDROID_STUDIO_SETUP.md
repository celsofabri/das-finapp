# Guia de Configuração do Android Studio

Este guia fornece instruções detalhadas para configurar o ambiente de desenvolvimento Android Studio para o projeto FinApp.

## Índice
1. [Pré-requisitos](#pré-requisitos)
2. [Instalação do Android Studio](#instalação-do-android-studio)
3. [Configuração do SDK Manager](#configuração-do-sdk-manager)
4. [Configuração do AVD (Emulador)](#configuração-do-avd-emulador)
5. [Importação do Projeto](#importação-do-projeto)
6. [Sincronização e Build](#sincronização-e-build)
7. [Execução do Aplicativo](#execução-do-aplicativo)
8. [Solução de Problemas](#solução-de-problemas)

## Pré-requisitos

Antes de começar, certifique-se de ter:
- **JDK 8 ou superior** instalado (recomendado: JDK 11)
- **Mínimo 8 GB de RAM** (recomendado: 16 GB)
- **Mínimo 4 GB de espaço em disco** para Android Studio e SDK
- **Sistema Operacional**: Windows 10/11, macOS 10.14+, ou Linux

### Verificar Instalação do JDK

```bash
# Verificar versão do Java
java -version

# Verificar JAVA_HOME (macOS/Linux)
echo $JAVA_HOME

# Verificar JAVA_HOME (Windows)
echo %JAVA_HOME%
```

Se o JDK não estiver instalado, baixe em:
- **Oracle JDK**: https://www.oracle.com/java/technologies/downloads/
- **OpenJDK**: https://adoptium.net/

## Instalação do Android Studio

### 1. Download

Acesse o site oficial do Android Studio:
- **URL**: https://developer.android.com/studio

Baixe a versão mais recente para seu sistema operacional.

### 2. Instalação

#### Windows
1. Execute o instalador `.exe` baixado
2. Siga o assistente de instalação
3. Aceite as configurações padrão (recomendado)
4. Aguarde a conclusão da instalação

#### macOS
1. Abra o arquivo `.dmg` baixado
2. Arraste o ícone do Android Studio para a pasta Applications
3. Abra o Android Studio pela primeira vez
4. Permita a execução se solicitado pelo sistema

#### Linux
1. Extraia o arquivo `.tar.gz`:
   ```bash
   tar -xzf android-studio-*.tar.gz
   ```
2. Navegue até o diretório extraído:
   ```bash
   cd android-studio/bin
   ```
3. Execute o script de instalação:
   ```bash
   ./studio.sh
   ```

### 3. Primeira Execução

Na primeira execução, o Android Studio irá:
1. Detectar configurações existentes (se houver)
2. Baixar componentes necessários
3. Configurar o Android SDK
4. Criar um emulador padrão (opcional)

**Importante**: Aceite as licenças do SDK quando solicitado.

## Configuração do SDK Manager

O projeto FinApp requer **API Level 28 (Android 9.0 Pie)**.

### 1. Abrir o SDK Manager

- **Menu**: Tools → SDK Manager
- **Atalho**: Ctrl+Alt+S (Windows/Linux) ou Cmd+, (macOS)

### 2. Instalar SDK Platform

Na aba **SDK Platforms**:

1. Marque a opção **"Show Package Details"** no canto inferior direito
2. Localize **Android 9.0 (Pie)**
3. Expanda e selecione:
   - ✅ Android SDK Platform 28
   - ✅ Sources for Android 28
4. Clique em **"Apply"** para instalar

### 3. Instalar SDK Tools

Na aba **SDK Tools**:

1. Marque a opção **"Show Package Details"**
2. Verifique se os seguintes itens estão instalados:
   - ✅ Android SDK Build-Tools 28.0.3 (ou superior)
   - ✅ Android SDK Platform-Tools
   - ✅ Android SDK Tools
   - ✅ Android Emulator
   - ✅ Intel x86 Emulator Accelerator (HAXM) - para Windows/macOS
3. Clique em **"Apply"** para instalar

### 4. Configurar Variáveis de Ambiente (Opcional)

Para usar ferramentas do SDK via linha de comando:

#### macOS/Linux
Adicione ao arquivo `~/.bash_profile` ou `~/.zshrc`:
```bash
export ANDROID_HOME=$HOME/Library/Android/sdk  # macOS
# ou
export ANDROID_HOME=$HOME/Android/Sdk  # Linux

export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
```

Recarregue o perfil:
```bash
source ~/.bash_profile  # ou ~/.zshrc
```

#### Windows
1. Abra **Painel de Controle** → **Sistema** → **Configurações Avançadas do Sistema**
2. Clique em **"Variáveis de Ambiente"**
3. Adicione nova variável de sistema:
   - Nome: `ANDROID_HOME`
   - Valor: `C:\Users\SeuUsuario\AppData\Local\Android\Sdk`
4. Edite a variável `Path` e adicione:
   - `%ANDROID_HOME%\platform-tools`
   - `%ANDROID_HOME%\tools`

## Configuração do AVD (Emulador)

### 1. Abrir o AVD Manager

- **Menu**: Tools → AVD Manager
- **Ícone**: Clique no ícone do celular com Android na barra de ferramentas

### 2. Criar um Novo Dispositivo Virtual

1. Clique em **"Create Virtual Device"**
2. Selecione uma categoria de hardware:
   - **Recomendado**: Phone → Pixel 3a
3. Clique em **"Next"**

### 3. Selecionar Imagem do Sistema

1. Na aba **"Recommended"**, localize **Pie (API Level 28)**
2. Se não estiver instalada, clique em **"Download"** ao lado
3. Aguarde o download e instalação
4. Selecione a imagem **Pie API Level 28**
5. Clique em **"Next"**

### 4. Configurar o AVD

1. Defina um nome para o emulador (ex: "Pixel_3a_API_28")
2. Configurações recomendadas:
   - **Startup orientation**: Portrait
   - **Graphics**: Automatic (ou Hardware se disponível)
   - **RAM**: 2048 MB (mínimo)
3. Clique em **"Finish"**

### 5. Testar o Emulador

1. No AVD Manager, clique no ícone ▶️ (Play) ao lado do emulador criado
2. Aguarde o emulador inicializar (pode levar alguns minutos na primeira vez)
3. Verifique se o Android é carregado corretamente

## Importação do Projeto

### 1. Clonar o Repositório

```bash
# Via HTTPS
git clone https://github.com/celsofabri/das-finapp.git

# Via SSH
git clone git@github.com:celsofabri/das-finapp.git

# Navegar para o diretório
cd das-finapp
```

### 2. Abrir no Android Studio

**Opção 1: Pela tela inicial**
1. Na tela de boas-vindas, clique em **"Open"**
2. Navegue até o diretório `das-finapp`
3. Selecione a pasta do projeto
4. Clique em **"OK"**

**Opção 2: Pelo menu**
1. File → Open
2. Navegue até o diretório `das-finapp`
3. Clique em **"OK"**

### 3. Aguardar Indexação

O Android Studio irá:
1. Indexar os arquivos do projeto
2. Analisar dependências
3. Configurar o Gradle

**Nota**: Este processo pode levar alguns minutos na primeira vez.

## Sincronização e Build

### 1. Sincronizar Gradle

Se a sincronização não iniciar automaticamente:
1. Clique no ícone 🐘 (Gradle) na barra de ferramentas
2. Ou vá em: File → Sync Project with Gradle Files

### 2. Resolver Problemas de Sincronização

Se houver erros:
1. Verifique a conexão com a internet
2. Verifique se o SDK 28 está instalado
3. Limpe o cache: File → Invalidate Caches / Restart

### 3. Build do Projeto

Para compilar o projeto:
1. **Menu**: Build → Make Project
2. **Atalho**: Ctrl+F9 (Windows/Linux) ou Cmd+F9 (macOS)

Aguarde a conclusão do build. Verifique a aba **"Build"** para mensagens de erro ou sucesso.

## Execução do Aplicativo

### 1. Selecionar Dispositivo

Na barra de ferramentas superior:
1. Clique no dropdown de dispositivos
2. Selecione o emulador criado ou um dispositivo físico conectado

### 2. Executar o App

**Opção 1: Botão Run**
- Clique no ícone ▶️ (Run) na barra de ferramentas
- Ou use o atalho: Shift+F10 (Windows/Linux) ou Ctrl+R (macOS)

**Opção 2: Menu**
- Run → Run 'app'

### 3. Aguardar Instalação

O Android Studio irá:
1. Compilar o aplicativo
2. Instalar no dispositivo/emulador
3. Iniciar o aplicativo automaticamente

### 4. Testar Funcionalidades

No aplicativo:
1. **Tela Principal**: Verifique os botões "Cadastro" e "Extrato"
2. **Cadastro**: Teste inserir valores com vírgula (ex: 20,50)
3. **Extrato**: Verifique se as transações aparecem corretamente
4. **Sair**: Teste o botão de sair

## Solução de Problemas

### Erro: "SDK location not found"

**Solução**:
1. Crie o arquivo `local.properties` na raiz do projeto
2. Adicione a linha:
   ```properties
   sdk.dir=/caminho/para/seu/Android/sdk
   ```
3. Sincronize o Gradle novamente

### Erro: "Gradle sync failed"

**Soluções**:
1. Verifique sua conexão com a internet
2. File → Invalidate Caches / Restart
3. Verifique se o JDK está configurado corretamente:
   - File → Project Structure → SDK Location
4. Tente limpar o projeto:
   - Build → Clean Project
   - Build → Rebuild Project

### Emulador não inicia

**Soluções**:
1. Verifique se a virtualização está habilitada na BIOS
2. No Windows, desabilite Hyper-V se estiver usando HAXM
3. Aumente a RAM do emulador no AVD Manager
4. Tente criar um novo AVD com configurações diferentes

### Aplicativo não instala no dispositivo físico

**Soluções**:
1. Habilite **"Opções do Desenvolvedor"** no dispositivo:
   - Configurações → Sobre o telefone
   - Toque 7 vezes em "Número da versão"
2. Habilite **"Depuração USB"**:
   - Configurações → Opções do desenvolvedor → Depuração USB
3. Conecte o dispositivo via USB
4. Aceite a solicitação de depuração USB no dispositivo

### Erro de compilação Kotlin

**Solução**:
1. Verifique se a versão do Kotlin está correta (1.3.72)
2. File → Project Structure → Project
3. Verifique se o Gradle Plugin está na versão 4.0.2

### Testes unitários não executam

**Solução**:
1. Verifique se o JUnit está nas dependências
2. Execute via linha de comando:
   ```bash
   ./gradlew test
   ```
3. Verifique os logs em `app/build/reports/tests/`

## Recursos Adicionais

### Documentação Oficial
- **Android Developers**: https://developer.android.com/docs
- **Kotlin**: https://kotlinlang.org/docs/home.html
- **Gradle**: https://docs.gradle.org/

### Comunidade
- **Stack Overflow**: https://stackoverflow.com/questions/tagged/android
- **Reddit**: r/androiddev
- **Discord**: Android Dev Community

### Atalhos Úteis do Android Studio

| Ação | Windows/Linux | macOS |
|------|---------------|-------|
| Build Project | Ctrl+F9 | Cmd+F9 |
| Run App | Shift+F10 | Ctrl+R |
| Debug App | Shift+F9 | Ctrl+D |
| Find | Ctrl+F | Cmd+F |
| Replace | Ctrl+R | Cmd+R |
| Go to Class | Ctrl+N | Cmd+O |
| Go to File | Ctrl+Shift+N | Cmd+Shift+O |
| Recent Files | Ctrl+E | Cmd+E |
| Refactor | Ctrl+Alt+Shift+T | Ctrl+T |
| Format Code | Ctrl+Alt+L | Cmd+Alt+L |

## Suporte

Para problemas específicos do projeto FinApp:
- **Repositório**: https://github.com/celsofabri/das-finapp
- **Issues**: https://github.com/celsofabri/das-finapp/issues

---

**Equipe de Desenvolvimento**:
- Celso
- Isabelle
- Rodrigo
