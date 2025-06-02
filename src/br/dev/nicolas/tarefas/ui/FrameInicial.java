package br.dev.nicolas.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameInicial {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	private JLabel lblTitle;

	//Método construtor
	public FrameInicial() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame("Tela inicial: ");
		tela.setLayout(null);
		tela.setSize(380, 180);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblTitle = new JLabel("Escolha uma opção: ");
		lblTitle.setBounds(20, 10, 140, 20);
		
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(20, 50, 160, 45);
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(190, 50, 160, 45);
		
		Container painel = tela.getContentPane();
		
		painel.add(lblTitle);
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		
		//Listener - Botão dos Funcionários
		btnFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefas();
			}
		});
		
		tela.setVisible(true);
	}
	
}


	
