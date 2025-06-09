package br.dev.nicolas.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.nicolas.tarefas.factory.FileFactory;
import br.dev.nicolas.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	private FileFactory ff = new FileFactory();
	
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void gravar() {

		try {
			
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\25132912\\Tarefa (Celso)\\tarefas.csv");

			bw.write(tarefa.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public List<Tarefa> showTasks() {

		List<Tarefa> tarefas = new ArrayList<>();

		try {
			
			BufferedReader br = ff.getBufferedReader("C:\\Users\\25132912\\Tarefas (Celso)\\tarefas.csv");
			String line = br.readLine();

			do {
				line = br.readLine();

				Tarefa t = new Tarefa();
				String[] tarefa = line != null ? line.split(",") : null;

				if (tarefa != null) {
					t.setCodigo(tarefa[0]);
					t.setNome(tarefa[1]);
					t.setResponsavel(tarefa[2]);
					
					tarefas.add(t);
				}

			} while (line != null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return tarefas;
	}
	
}
	

