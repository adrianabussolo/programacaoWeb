package modelo;

import java.sql.Date;

public class Matricula {
	
	
	@Override
	public String toString() {
		return "Matricula : curso=" + curso + ", nome=" + nome
				+ ", endereco=" + endereco;
	}
	
	
	private int idmatricula;
	private String nome;
	private String curso;
	private Date dataNascimento;
	private int cpf;
	private String endereco;
	public Matricula() {
		super();
	}
	public Matricula(int idmatricula, String nome, String curso,
			Date dataNascimento, int cpf, String endereco) {
		super();
		this.idmatricula = idmatricula;
		this.nome = nome;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	public int getIdmatricula() {
		return idmatricula;
	}
	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
}