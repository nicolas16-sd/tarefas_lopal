package br.dev.nicolas.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.nicolas.tarefas.dao.FuncionarioDAO;
import br.dev.nicolas.tarefas.model.Funcionario;
import br.dev.nicolas.tarefas.model.Tarefa;

public class Main {
	
	//Determinando o caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132912\\Tarefas (Celso)\\tarefas.txt";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> frutas = new ArrayList<String>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Double> numeros = new ArrayList<>();
		
		frutas.add("maçã");
		frutas.add("banana");
		frutas.add("tomate");
		frutas.add("mexerica");
		
		numeros.add(4.9);
		numeros.add(10.13);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(4);
		funcionario.setNome("João Abóbora");
		funcionario.setMatricula("25132914");
		funcionario.setEmail("jo_abobora@gmail.com");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario.setCodigo(4);
		funcionario.setNome("Luan Melancia");
		funcionario.setMatricula("25132914");
		funcionario.setEmail("luan_melancia@gmail.com");
		
		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);
		
		System.out.println(frutas);
		System.out.println(funcionarios);
		
		for (Funcionario f : funcionarios) {
			System.out.println(f.getNome() + " - " + f.getEmail() + " - " + f.getMatricula());
		}
			
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
//
//			System.out.println(funcionario.toString());
//		
//		Tarefa t = new Tarefa("Pagar o fornecedor");
//		Funcionario f = new Funcionario();
//
	}
	
	private static void gravarArquivo() {
		FileWriter file = null;
		BufferedWriter writer = null;
		
		try {
			file = new FileWriter(path, true);
			writer = new BufferedWriter(file);
			
			writer.write("Essa é a última linha, por enquanto!!!!\n");
			writer.flush();
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	private static void lerArquivo() {
	
		//Abrir o arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String line = buffer.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = buffer.readLine();
			} 
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não encontrado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não tem autorização para ler o arquivo.");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico.");
			System.out.println(erro.getMessage());
		}
	}

}
