# 🌌 Premium Task Manager

Um gerenciador de tarefas moderno, elegante e intuitivo desenvolvido em Java utilizando a biblioteca **Swing**. O projeto aplica conceitos consolidados de **Programação Orientada a Objetos (POO)** — como abstração, herança e polimorfismo — aliados a um design *Dark Mode* minimalista em tons de azul escuro.

---

## 🎨 Interface e Design

O aplicativo conta com uma identidade visual premium inspirada nas paletas modernas de desenvolvimento (*Slate & Blue*):
* 🌑 **Fundo Principal:** Azul Noturno Profundo (`#0F172A`)
* 🪐 **Painéis e Elementos:** Azul Slate (`#1E293B`)
* ⚡ **Destaques e Botões:** Azul Elétrico (`#2563EB`), Verde Esmeralda (`#10B981`) para conclusões e Vermelho (`#EF4444`) para exclusões.
* ✍️ **Tipografia:** Segoe UI com espaçamentos otimizados (*paddings*) para uma leitura limpa.

---

## 🚀 Funcionalidades Principais

* **Adicionar Tarefas:** Criação rápida de tarefas com títulos customizados.
* **Classificação de Urgência:** Atribuição de prioridades (**Alta**, **Média**, **Baixa**) no momento do cadastro.
* **Gerenciamento de Status:** Altere o estado da tarefa para **Concluída** com apenas um clique.
* **Remover Tarefas:** Exclusão simplificada de itens selecionados da lista.
* **Dashboard de Indicadores:** Painel inferior com contagem em tempo real de tarefas **Totais**, **Pendentes** e **Concluídas**.

---

## 🧠 Conceitos de POO Aplicados

1. **Abstração:** A classe mãe `Tarefa` define a estrutura essencial de uma atividade sem expor sua implementação de exibição direta.
2. **Herança:** A classe `TarefaPessoal` herda todos os atributos e comportamentos base de `Tarefa`.
3. **Polimorfismo:** Sobrescrita (`@Override`) do método `exibirDetalhes()`, permitindo que cada tipo de tarefa formate seu próprio texto de exibição na interface gráfica.

---

## 🛠️ Passo a Passo: Como Executar o Projeto

### 📋 Pré-requisitos
* Ter o **Java Development Kit (JDK)** na versão 11 ou superior instalado na máquina.
* Uma IDE (como IntelliJ, Eclipse, NetBeans) ou o terminal do seu sistema.

### 🏃‍♂️ Rodando a Aplicação

1. **Criar o Arquivo:**
   Crie um arquivo chamado exatamente **`GestorApp.java`** no seu computador.

2. **Colar o Código:**
   Abra esse arquivo e cole todo o código unificado do projeto dentro dele.

3. **Compilar (via Terminal):**
   Abra o terminal na pasta onde o arquivo foi salvo e digite:
   ```bash
   javac GestorApp.java
