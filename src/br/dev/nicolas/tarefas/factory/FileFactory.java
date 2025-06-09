package br.dev.nicolas.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String pathFuncionarios = "C:\\Users\\25132912\\Tarefas (Celso)\\funcionarios.csv";
	
	public BufferedReader getBufferedReader(String path) throws FileNotFoundException, IOException {
		fr = new FileReader(path);
		br = new BufferedReader(fr);
		return br;
	}
	
	public BufferedWriter getBufferedWriter(String path) throws FileNotFoundException, IOException {
			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);
			
			return bw;
	}
}
