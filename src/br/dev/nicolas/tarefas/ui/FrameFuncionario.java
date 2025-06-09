package br.dev.nicolas.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.nicolas.tarefas.dao.FuncionarioDAO;
import br.dev.nicolas.tarefas.model.Funcionario;
import br.dev.nicolas.tarefas.utils.Utils;

public class FrameFuncionario {
	
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameFuncionario(JFrame telaLista) {
		criarTela(telaLista);
	}
	
	private void criarTela(JFrame telaLista) {
		JDialog tela = new JDialog(telaLista, "Cadastro", true);
		tela.setLayout(null);
		tela.setLocationRelativeTo(telaLista);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Container painel = tela.getContentPane();
		
		lblCodigo = new JLabel("C�digo: ");
		lblCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 200, 30);
		txtCodigo.setEnabled(false);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(20, 85, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(20, 120, 340, 30);
		
		lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(20, 150, 200, 30);
		txtTelefone = new JTextField();
		txtTelefone.setBounds(20, 185, 200, 30);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(20, 220, 200, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(20, 255, 200, 30);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(200, 300, 150, 30);
		
		btnSair = new JButton("SAIR");
		btnSair.setBounds(20, 300, 150, 30);
		
		painel.add(lblCodigo);
		painel.add(txtCodigo);
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblTelefone);
		painel.add(txtTelefone);
		painel.add(lblEmail);
		painel.add(txtEmail);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		//Adicionar os ouvintes de a��o dos bot�es
		//Bot�o Salvar
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(Utils.gerarUUID());
				funcionario.setNome(txtNome.getText());
				funcionario.setTelefone(txtTelefone.getText());
				funcionario.setEmail(txtEmail.getText());
				
				FuncionarioDAO dao = new FuncionarioDAO(funcionario);
				dao.gravar();
				
				JOptionPane.showMessageDialog(tela, 
						txtNome.getText() + " gravado com sucesso!", 
						"Sucesso", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		limparFormulario();
		
		//Bot�o Sair
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confirmar a sa�da do sistema?",
						"Sair do Sistema", 
						JOptionPane.YES_NO_OPTION
						);
			System.out.println(resposta);
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		tela.setVisible(true);
	}
	
	private void limparFormulario() {
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtNome.requestFocus();
	}
	
}
