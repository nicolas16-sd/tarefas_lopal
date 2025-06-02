package br.dev.nicolas.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameTarefas {

	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblTitulo;
	private JLabel lblDescricao;
	private JLabel lblFuncionario;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JButton btnSalvar;
	
	public FrameTarefas() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();	
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblCodigo = new JLabel("Código: ");
		lblCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 350, 30);	
		txtCodigo.setEnabled(false);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(20, 90, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(20, 120, 350, 30);
		
		Container painel = tela.getContentPane();
		
		painel.add(lblCodigo);
		painel.add(txtCodigo);
		painel.add(lblNome);
		painel.add(txtNome);
		
		tela.setVisible(true);
		
	}
		
}
