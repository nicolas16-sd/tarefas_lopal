package br.dev.nicolas.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.nicolas.tarefas.dao.TarefaDAO;
import br.dev.nicolas.tarefas.model.Tarefa;

public class FrameListaTarefas {
	
	private JLabel lblTitulo;
	private JTable tblTarefas;
	private JScrollPane scrTarefas;
	private JButton btnNovo;
	private JButton btnSair;

	public FrameListaTarefas() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame("Lista de Tarefas");	
		tela.setLayout(null);
		tela.setSize(540, 540);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Cadastro de funcionários");
		lblTitulo.setBounds(10, 20, 500, 30);
		
		String[] colunas = {"Código" , "Nome" , "Responsável"};
		
		TarefaDAO dao = new TarefaDAO(null);
		
		List<Tarefa> tarefas = dao.showTasks();
		
		Object[][] dados = new Object[tarefas.size()][3];
		
		int line = 0;
		for(Tarefa t : tarefas) {
			dados[line][0] = t.getCodigo();
			dados[line][1] = t.getTitulo();
			dados[line][2] = t.getResponsavel();
			line++;
		}
		
		tblTarefas = new JTable(dados, colunas);
		scrTarefas = new JScrollPane(tblTarefas);
		scrTarefas.setBounds(10, 70, 500, 300);
		
		btnNovo = new JButton("NOVA TAREFA");
		btnNovo.setBounds(10, 380, 150, 40);
		
		btnSair = new JButton("SAIR");
		btnSair.setBounds(170, 380, 120, 40);
		
		
		//Ações dos Botões
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new FrameTarefas();
				
			}
		});

		painel.add(lblTitulo);
		painel.add(scrTarefas);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}
}

