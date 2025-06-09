package br.dev.nicolas.tarefas.model;

import java.time.LocalDateTime;

public class Tarefa {

	private String codigo;
	private String titulo;
	private String descricao;
	private LocalDateTime dataInical;
	private LocalDateTime prazo;
	private LocalDateTime dataConclusao;
	private Status status;
	private String responsavel;
	
	//M�todos construtores
	public Tarefa(String titulo) {
		this.titulo = titulo;
	}
	
	public Tarefa() {
		
	}
	
	public Tarefa(String titulo, LocalDateTime dataInicial) {
		
	}

	//M�todos de Acesso
	public String getTitulo() {
		return titulo;
	}

	public void setNome(String titulo) {
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
	
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario funcionario) {
		this.responsavel = funcionario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	@Override
	public String toString() {
		return this.codigo + "," + this.titulo + "," + this.descricao + "\n";
	}

	
}
