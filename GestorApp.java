import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestorApp extends JFrame {
    private JTextField entrada;
    private JComboBox<String> comboPrioridade;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaComponente;
    private JLabel lblTotal;
    private List<Tarefa> listaDeTarefas;

    private final Color COR_FUNDO = new Color(15, 23, 42);       
    private final Color COR_PAINEIS = new Color(30, 41, 59);     
    private final Color COR_TEXTO = new Color(241, 245, 249);    
    private final Color COR_BOTAO_ADD = new Color(37, 99, 235);  
    private final Color COR_LISTA_FUNDO = new Color(51, 65, 85); 
    private final Color COR_SELECAO = new Color(71, 85, 105);    

    public GestorApp() {
        listaDeTarefas = new ArrayList<>();

        setTitle("Premium Task Manager");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        JPanel painelPrincipal = new JPanel(new BorderLayout(15, 15));
        painelPrincipal.setBackground(COR_FUNDO);
        painelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(painelPrincipal);

        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelSuperior.setBackground(COR_PAINEIS);
        painelSuperior.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, COR_BOTAO_ADD));

        JLabel lblTarefa = new JLabel("Tarefa:");
        lblTarefa.setForeground(COR_TEXTO);
        
        entrada = new JTextField(12);
        entrada.setBackground(COR_FUNDO);
        entrada.setForeground(COR_TEXTO);
        entrada.setCaretColor(COR_TEXTO);
        entrada.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COR_SELECAO, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        String[] prioridades = {"Alta", "Média", "Baixa"};
        comboPrioridade = new JComboBox<>(prioridades);
        comboPrioridade.setBackground(COR_FUNDO);
        comboPrioridade.setForeground(COR_TEXTO);

        JButton btnAdicionar = new JButton("Adicionar");
        estilizarBotao(btnAdicionar, COR_BOTAO_ADD, COR_TEXTO);

        painelSuperior.add(lblTarefa);
        painelSuperior.add(entrada);
        painelSuperior.add(comboPrioridade);
        painelSuperior.add(btnAdicionar);

        modeloLista = new DefaultListModel<>();
        listaComponente = new JList<>(modeloLista);
        listaComponente.setBackground(COR_LISTA_FUNDO);
        listaComponente.setForeground(COR_TEXTO);
        listaComponente.setSelectionBackground(COR_SELECAO);
        listaComponente.setSelectionForeground(COR_TEXTO);
        listaComponente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        listaComponente.setFixedCellHeight(30); 

        JScrollPane scrollLista = new JScrollPane(listaComponente);
        scrollLista.setBorder(BorderFactory.createLineBorder(COR_PAINEIS, 2));

        JPanel painelInferior = new JPanel(new GridLayout(2, 1, 10, 10));
        painelInferior.setOpaque(false);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        painelBotoes.setOpaque(false);
        
        JButton btnConcluir = new JButton("Concluir");
        estilizarBotao(btnConcluir, new Color(16, 185, 129), COR_TEXTO); 
        
        JButton btnRemover = new JButton("Remover");
        estilizarBotao(btnRemover, new Color(239, 68, 68), COR_TEXTO);    
        
        painelBotoes.add(btnConcluir);
        painelBotoes.add(btnRemover);

        lblTotal = new JLabel("Total: 0 | Pendentes: 0 | Concluídas: 0", SwingConstants.CENTER);
        lblTotal.setForeground(COR_TEXTO);
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 13));

        painelInferior.add(painelBotoes);
        painelInferior.add(lblTotal);

        painelPrincipal.add(painelSuperior, BorderLayout.NORTH);
        painelPrincipal.add(scrollLista, BorderLayout.CENTER);
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> {
            try {
                String texto = entrada.getText().trim();
                if (texto.isEmpty()) throw new Exception();
                
                Tarefa novaTarefa = new TarefaPessoal(texto, (String) comboPrioridade.getSelectedItem());
                listaDeTarefas.add(novaTarefa);
                atualizarInterface();
                entrada.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Por favor, digite uma tarefa válida.");
            }
        });

        btnConcluir.addActionListener(e -> {
            int index = listaComponente.getSelectedIndex();
            if (index != -1) {
                listaDeTarefas.get(index).setConcluida(true);
                atualizarInterface();
            }
        });

        btnRemover.addActionListener(e -> {
            int index = listaComponente.getSelectedIndex();
            if (index != -1) {
                listaDeTarefas.remove(index);
                atualizarInterface();
            }
        });
    }

    private void abrir_estilo() {}

    private void estilizarBotao(JButton botao, Color fundo, Color texto) {
        botao.setBackground(fundo);
        botao.setForeground(texto);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 12));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void atualizarInterface() {
        modeloLista.clear();
        int concluidas = 0;
        for (Tarefa t : listaDeTarefas) {
            modeloLista.addElement(t.exibirDetalhes());
            if (t.isConcluida()) concluidas++;
        }
        int total = listaDeTarefas.size();
        lblTotal.setText("Total: " + total + " | Pendentes: " + (total - concluidas) + " | Concluídas: " + concluidas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorApp().setVisible(true));
    }
}