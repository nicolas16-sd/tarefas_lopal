package br.dev.nicolas.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.nicolas.tarefas.dao.TarefaDAO;
import br.dev.nicolas.tarefas.model.Funcionario;
import br.dev.nicolas.tarefas.model.Status;
import br.dev.nicolas.tarefas.model.Tarefa;
import br.dev.nicolas.tarefas.utils.Utils;

public class FrameTarefas {

	private JLabel lblCodigo;
	private JLabel lblTitulo;
	private JLabel lblDescricao;
	private JLabel lblFuncionario;
	private JLabel lblStatus;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JComboBox<Status> cmbStatus;
	private JComboBox<Funcionario> cmbFuncionarios;
	private List<Funcionario> funcionarios;
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameTarefas() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame("Cadastro de Funcionários");	
		tela.setLayout(null);
		tela.setSize(400, 540);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblCodigo = new JLabel("Código: ");
		lblCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 350, 30);	
		txtCodigo.setEnabled(false);
		
		lblTitulo = new JLabel("Título: ");
		lblTitulo.setBounds(20, 90, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 120, 350, 30);
		
		lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setBounds(20, 150, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 180, 350, 60);
		
		lblFuncionario = new JLabel("Funcionário: ");
		lblFuncionario.setBounds(20, 260, 200, 30);
		cmbFuncionarios = new JComboBox<Funcionario>();
		cmbFuncionarios.setBounds(20, 290, 350, 30);
		
		lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(20, 340, 200, 30);
		cmbStatus = new JComboBox<Status>();
		cmbStatus.setBounds(20, 370, 350, 30);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(20, 420, 120, 40);
		
		btnSair = new JButton("SAIR");
		btnSair.setBounds(150, 420, 120, 40);
		
		Container painel = tela.getContentPane();
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(Utils.gerarUUID());
				tarefa.setNome(txtTitulo.getText());
				tarefa.setDescricao(txtDescricao.getText());
				tarefa.setResponsavel((Funcionario) cmbFuncionarios.getSelectedItem());

				
				TarefaDAO dao = new TarefaDAO(tarefa);
				dao.gravar();
			}
		});
		
		painel.add(lblCodigo);
		painel.add(txtCodigo);
		painel.add(lblTitulo);
		painel.add(txtTitulo);
		painel.add(lblDescricao);
		painel.add(txtDescricao);
		painel.add(lblFuncionario);
		painel.add(cmbFuncionarios);
		painel.add(lblStatus);
		painel.add(cmbStatus);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		tela.setVisible(true);
		
	}
		
}
