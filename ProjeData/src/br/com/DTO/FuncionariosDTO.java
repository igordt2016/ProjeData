package br.com.DTO;

public class FuncionariosDTO extends PessoaDTO {

	
	private int idFuncionario;
	private double salario;
	private String funcao;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public FuncionariosDTO(){
		
	}
	
}
