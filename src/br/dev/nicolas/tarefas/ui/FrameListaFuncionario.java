package br.dev.nicolas.tarefas.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		tela.setTitle("Cadastro de funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Cadastro de funcionários");
		lblTitulo.setBounds(10, 20, 500, 30);
		lblTitulo.setFont(fontTitulo);
		
		String[] colunas = {"Código" , "Nome" , "Email"};
		Object[][] dados = {
				{"xxx" , "xxx" , "xxx"},
				{"" , "" , ""},
				{"" , "" , ""},
		};
		tblFuncionarios = new JTable(dados, colunas);
		scrFuncionarios = new JScrollPane(tblFuncionarios);
		scrFuncionarios.setBounds(10, 70, 500, 300);
		
		painel.add(lblTitulo);
		painel.add(scrFuncionarios);
		
		tela.setVisible(true);
	}
}
