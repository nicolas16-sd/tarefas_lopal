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
import br.dev.nicolas.tarefas.ui.FrameFuncionario;
import br.dev.nicolas.tarefas.ui.FrameInicial;
import br.dev.nicolas.tarefas.ui.FrameListaFuncionario;
import br.dev.nicolas.tarefas.ui.FrameTarefas;
import br.dev.nicolas.tarefas.utils.Utils;

public class Main {

	// Determinando o caminho do arquivo que ser� lido
	private static String path = "C:\\Users\\25132912\\Tarefas (Celso)\\tarefas.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new FrameTarefas();
		new FrameInicial();
		//new FrameListaFuncionario();
		//new FrameFuncionario();
		
	}

	private static void gravarArquivo() {
		FileWriter file = null;
		BufferedWriter writer = null;

		try {

			file = new FileWriter(path, true);
			writer = new BufferedWriter(file);

			writer.write("Essa � a �ltima linha, por enquanto!!!!\n");
			writer.flush();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	private static void lerArquivo() {

		// Abrir o arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);

			String line = buffer.readLine();

			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}

		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo n�o encontrado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Voc� n�o tem autoriza��o para ler o arquivo.");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro gen�rico.");
			System.out.println(erro.getMessage());
		}
	}

}
