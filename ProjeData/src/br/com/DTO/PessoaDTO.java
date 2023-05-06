package br.com.DTO;
import java.sql.Date;

public class PessoaDTO {

	private int idPessoa;
	private String nome;
	private Date dataNascimento;
	
	public int getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}


	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PessoaDTO(){
		
	}
	
}
