public abstract class Tarefa {
    private String titulo;
    private String prioridade; 
    private boolean concluida;

    public Tarefa(String titulo, String prioridade) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public String getTitulo() { return titulo; }
    public String getPrioridade() { return prioridade; }
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }

    public abstract String exibirDetalhes();
}

class TarefaPessoal extends Tarefa {
    public TarefaPessoal(String titulo, String prioridade) {
        super(titulo, prioridade);
    }

    @Override
    public String exibirDetalhes() {
        String statusSymbol = isConcluida() ? "✓ [Concluída]" : "○ [Pendente]";
        return String.format(" %s  %s  (Urgência: %s)", statusSymbol, getTitulo(), getPrioridade());
    }
}