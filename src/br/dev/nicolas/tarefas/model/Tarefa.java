package br.dev.nicolas.tarefas.model;

import java.time.LocalDateTime;

public class Tarefa {

	private int codigo;
	private String titulo;
	private String descricao;
	private LocalDateTime dataInical;
	private LocalDateTime prazo;
	private LocalDateTime dataConclusao;
	private Status status;
	private Funcionario responsavel;
	
	//Métodos construtores
	public Tarefa(String titulo) {
		this.titulo = titulo;
	}
	
	public Tarefa(String titulo, LocalDateTime dataInicial) {
		
	}

	//Métodos de Acesso
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInical() {
		return dataInical;
	}

	public void setDataInical(LocalDateTime dataInical) {
		this.dataInical = dataInical;
	}

	public LocalDateTime getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDateTime prazo) {
		this.prazo = prazo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

}
