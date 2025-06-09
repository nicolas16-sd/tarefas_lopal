package br.dev.nicolas.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.nicolas.tarefas.factory.FileFactory;
import br.dev.nicolas.tarefas.model.Funcionario;

public class FuncionarioDAO<Tarefas> {

	private Funcionario funcionario;
	private FileFactory ff = new FileFactory();

	// M�todo construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {

	
		try {

			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\25132912\\Tarefas (Celso)\\funcionarios.csv");
			bw.write(funcionario.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Funcionario> showEmployees() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			BufferedReader br = ff.getBufferedReader("C:\\Users\\25132912\\Tarefas (Celso)\\funcionarios.csv");
			String line = br.readLine();
			
			do {
				 line = br.readLine();
				 
				String[] funcionario = line != null ? line.split(",") : null;
				Funcionario f = new Funcionario();
				f.setCodigo(funcionario[0]);
				f.setNome(funcionario[1]);
				f.setEmail(funcionario[2]);
				
				funcionarios.add(f);
				 
			} while (line != null);
			
		} catch (Exception e) {
			
		}
		
		return funcionarios;
	}
	


}
