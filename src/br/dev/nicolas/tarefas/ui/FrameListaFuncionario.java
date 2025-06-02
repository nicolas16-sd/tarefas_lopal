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

import br.dev.nicolas.tarefas.dao.FuncionarioDAO;
import br.dev.nicolas.tarefas.model.Funcionario;

public class FrameListaFuncionario {

	private JLabel lblTitulo;
	private JTable tblFuncionarios;
	private JScrollPane scrFuncionarios;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);

	public FrameListaFuncionario() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de funcion�rios");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		lblTitulo = new JLabel("Cadastro de funcion�rios");
		lblTitulo.setBounds(10, 20, 500, 30);
		lblTitulo.setFont(fontTitulo);

		// Cria��o de tabelas
		String[] colunas = { "C�digo", "Nome", "Email" };
		
		//Obter lista de funcion�rios
		FuncionarioDAO dao = new FuncionarioDAO(null);
		
		List<Funcionario> funcionarios = dao.showEmployees();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		for(Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;
		}
		
		
		tblFuncionarios = new JTable(dados, colunas);
		scrFuncionarios = new JScrollPane(tblFuncionarios);
		scrFuncionarios.setBounds(10, 70, 500, 300);
		
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(10, 380, 150, 40);

		painel.add(lblTitulo);
		painel.add(scrFuncionarios);
		painel.add(btnNovo);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
			}
		});

		tela.setVisible(true);
	}
}
