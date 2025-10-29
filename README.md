# FinApp - Aplicativo de Gestão Financeira

Aplicativo Android desenvolvido para auxiliar usuários no gerenciamento de suas finanças pessoais, permitindo o cadastro e visualização de transações financeiras (débitos e créditos).

## 📱 Sobre o Projeto

FinApp é um aplicativo simples e intuitivo desenvolvido como projeto acadêmico para a disciplina de Desenvolvimento Mobile I. O aplicativo permite que os usuários registrem suas transações financeiras e visualizem um extrato completo de suas movimentações.

## ✨ Funcionalidades

- **Dashboard Principal**: Interface inicial com acesso rápido às principais funcionalidades
- **Cadastro de Transações**: Registro de débitos e créditos com descrição e valor
- **Extrato**: Visualização de todas as transações cadastradas em formato de lista
- **Validações**: Sistema de validação para garantir a integridade dos dados
- **Interface Intuitiva**: Design limpo e fácil de usar

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **API Level**: 28 (Android 9.0 Pie)
- **Min SDK**: 21 (Android 5.0 Lollipop)
- **Target SDK**: 28
- **IDE**: Android Studio
- **Arquitetura**: Activities com armazenamento em memória

## 📋 Requisitos

- Android Studio 3.6.4 ou superior
- JDK 8 ou superior
- Android SDK API 28
- Gradle 3.6.4

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
```

2. Abra o projeto no Android Studio

3. Aguarde o Gradle sincronizar as dependências

4. Execute o aplicativo em um emulador ou dispositivo físico

## 📱 Estrutura do Aplicativo

### Activities

- **MainActivity**: Tela principal (Dashboard) com botões de navegação
- **CadastroActivity**: Tela para cadastro de novas transações
- **ExtratoActivity**: Tela de visualização do extrato de transações

### Modelos de Dados

- **Transacao**: Data class que representa uma transação financeira
- **Tipo**: Enum que define os tipos de transação (DÉBITO/CRÉDITO)
- **TransacoesRepo**: Singleton que armazena as transações em memória

### Componentes

- **TransacaoAdapter**: Adapter customizado para exibição das transações no ListView

## 💾 Armazenamento

As transações são armazenadas em memória utilizando uma estrutura de dados `MutableList`. Isso significa que:
- Os dados são perdidos quando o aplicativo é fechado
- Não há persistência em banco de dados
- Ideal para demonstração e testes

## 🎨 Interface

O aplicativo utiliza:
- Material Design Components
- ConstraintLayout para layouts responsivos
- ListView para exibição de listas
- Cores diferenciadas para débitos (vermelho) e créditos (verde)
- Formatação de valores em Real (R$)

## 📝 Exemplos de Uso

### Cadastro de Débito
- Tipo: Débito
- Descrição: Lazer
- Valor: R$ 20,50

### Cadastro de Crédito
- Tipo: Crédito
- Descrição: Salário
- Valor: R$ 10.000,00

## 👥 Desenvolvimento

Projeto desenvolvido como trabalho acadêmico para a disciplina de Desenvolvimento Mobile I.

**Package**: `com.das.finapp` (DAS - Desenvolvimento Ágil de Software)

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.

## 🔗 Estrutura de Arquivos

```
MOB1/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/das/finapp/
│   │       │   ├── MainActivity.kt
│   │       │   ├── CadastroActivity.kt
│   │       │   ├── ExtratoActivity.kt
│   │       │   ├── Transacao.kt
│   │       │   ├── Tipo.kt
│   │       │   ├── TransacoesRepo.kt
│   │       │   └── TransacaoAdapter.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_cadastro.xml
│   │       │   │   ├── activity_extrato.xml
│   │       │   │   └── item_transacao.xml
│   │       │   └── values/
│   │       │       ├── strings.xml
│   │       │       ├── colors.xml
│   │       │       └── styles.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## 📞 Suporte

Para dúvidas ou sugestões sobre o projeto, entre em contato através do repositório no GitHub.
