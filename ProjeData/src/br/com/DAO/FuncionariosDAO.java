package br.com.DAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import br.com.DTO.FuncionariosDTO;
import br.com.DTO.PessoaDTO;

public class FuncionariosDAO {

	Connection con;
	PreparedStatement pst;
	ArrayList<FuncionariosDTO> lista = new ArrayList<>();
	ResultSet rsDados;
	private HttpServletResponse response;
	
	public Date converteData(String data){
		
		String dataString = null;
		LocalDate date;
		Date dataAux;
		
		dataString = data;
		String [] dataSeparada = dataString.split("-");
		date = LocalDate.of(Integer.parseInt(dataSeparada[0]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[2]));
		dataAux = Date.valueOf(date);	
		
		
		return dataAux;
		
	}
	
	public int anoAtual(){
		
		Calendar cal = Calendar.getInstance();
		int ano = cal.get(Calendar.YEAR);				
		
		
		return ano;
		
	}
	
	public Date converteDataInvertido(String data){
		
		String dataString = null;
		LocalDate date;
		Date dataAux;
		
		dataString = data;
		String [] dataSeparada = dataString.split("/");
		date = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
		dataAux = Date.valueOf(date);	
		
		
		return dataAux;
		
	}
	
	public double converteSalario(String salarioIn){
		
		double salario = 0.0;
		salario = Double.parseDouble(salarioIn.replace(",", "."));
		
		
		return salario;
		
		
		
	}
	
	public double converteSalarioFormatado(String salarioIn){
		
		double salario = 0.0;
		salarioIn = salarioIn.replace("R", "");
		salarioIn = salarioIn.replace("$", "");
		salarioIn = salarioIn.replace(".", "");
		salario = Double.parseDouble(salarioIn.replace(",", "."));
		
		
		return salario;
		
		
		
	}
	
	
	public void cadastrarUsuario(PessoaDTO pessoa, FuncionariosDTO funcionario) throws SQLException, ClassNotFoundException{


		con = new ConexaoDAO().conexaoBD();


		StringBuilder cInsert = new StringBuilder();
		cInsert.append(" INSERT into pessoa (nome, dataNascimento) ");
		cInsert.append(" values(?,?) ");
		
		try {	

				pst= con.prepareStatement(cInsert.toString()); 
				pst.setString(1, pessoa.getNome());
				pst.setDate(2, pessoa.getDataNascimento());
				pst.executeUpdate();

				cadastrarFuncionario(pessoa.getNome(),funcionario.getSalario(),funcionario.getFuncao());

				pst.close();

		} catch (Exception e) {

			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}

	}

	public void cadastrarFuncionario(String nomeFunc, double salario, String funcao) throws SQLException, ClassNotFoundException{

		
		StringBuilder cInsert = new StringBuilder();
		cInsert.append(" INSERT into funcionario (nomeFuncionario, salario, funcao) ");
		cInsert.append(" values(?,?,?) ");

		try {	

				pst = con.prepareStatement(cInsert.toString()); 
				pst.setString(1, nomeFunc);
				pst.setDouble(2, salario);
				pst.setString(3, funcao);
				pst.executeUpdate();
				pst.close();
				

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if (pst != null) {
				pst.close();
			}
			
			
		}

	}
	
	public ArrayList<FuncionariosDTO> listarFuncionariosGeral() throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");

		con = new ConexaoDAO().conexaoBD();

		
		try {

			pst = con.prepareStatement(cQuery.toString());
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
				funcionariosDTO.setIdFuncionario(rsDados.getInt("idFuncionario"));
				funcionariosDTO.setNome(rsDados.getString("nomeFuncionario"));
				funcionariosDTO.setDataNascimento(rsDados.getDate("dataNascimento"));
				funcionariosDTO.setSalario(rsDados.getDouble("salario"));
				funcionariosDTO.setFuncao(rsDados.getString("funcao"));
				
				lista.add(funcionariosDTO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return lista;
	}
	
	public ArrayList<FuncionariosDTO> listarFuncionariosAniversario() throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" and month(p.dataNascimento) in ('10','12') ");

		con = new ConexaoDAO().conexaoBD();

		
		try {

			pst = con.prepareStatement(cQuery.toString());
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
				funcionariosDTO.setIdFuncionario(rsDados.getInt("idFuncionario"));
				funcionariosDTO.setNome(rsDados.getString("nomeFuncionario"));
				funcionariosDTO.setDataNascimento(rsDados.getDate("dataNascimento"));
				funcionariosDTO.setSalario(rsDados.getDouble("salario"));
				funcionariosDTO.setFuncao(rsDados.getString("funcao"));
				
				lista.add(funcionariosDTO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return lista;
	}
	
	public ArrayList<FuncionariosDTO> listarFuncionariosFuncao(String funcao) throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" and f.funcao = ? ");

		con = new ConexaoDAO().conexaoBD();

		
		try {

			pst = con.prepareStatement(cQuery.toString());
			pst.setString(1, funcao);
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){
				FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
				funcionariosDTO.setIdFuncionario(rsDados.getInt("idFuncionario"));
				funcionariosDTO.setNome(rsDados.getString("nomeFuncionario"));
				funcionariosDTO.setDataNascimento(rsDados.getDate("dataNascimento"));
				funcionariosDTO.setSalario(rsDados.getDouble("salario"));
				funcionariosDTO.setFuncao(rsDados.getString("funcao"));
				
				lista.add(funcionariosDTO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return lista;
	}
	

	public ArrayList<FuncionariosDTO> listarFuncionariosOrdAlfab() throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" order by 2 ");

		con = new ConexaoDAO().conexaoBD();

		
		try {

			pst = con.prepareStatement(cQuery.toString());
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
				funcionariosDTO.setIdFuncionario(rsDados.getInt("idFuncionario"));
				funcionariosDTO.setNome(rsDados.getString("nomeFuncionario"));
				funcionariosDTO.setDataNascimento(rsDados.getDate("dataNascimento"));
				funcionariosDTO.setSalario(rsDados.getDouble("salario"));
				funcionariosDTO.setFuncao(rsDados.getString("funcao"));
				
				lista.add(funcionariosDTO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return lista;
	}
	
	public ArrayList<FuncionariosDTO> listarFuncionariosMaisVelhos() throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.nomeFuncionario, p.dataNascimento dataNascimento ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" order by 2 desc ");

		con = new ConexaoDAO().conexaoBD();

		try {

			pst = con.prepareStatement(cQuery.toString());
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
				funcionariosDTO.setNome(rsDados.getString("nomeFuncionario"));
				funcionariosDTO.setDataNascimento(rsDados.getDate("dataNascimento"));
				
				lista.add(funcionariosDTO);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return lista;
	}
	
	public void deletarFuncionario(FuncionariosDTO funcionariosDTO) throws SQLException, ClassNotFoundException{


		con = new ConexaoDAO().conexaoBD();
		
		StringBuilder cDelete = new StringBuilder();
		cDelete.append(" DELETE FROM funcionario ");
		cDelete.append(" WHERE idFuncionario = ? ");
		
		StringBuilder cDelete2 = new StringBuilder();
		cDelete2.append(" DELETE FROM pessoa ");
		cDelete2.append(" WHERE idPessoa = ? ");

		try {	

			pst = con.prepareStatement(cDelete.toString()); 
			pst.setInt(1, funcionariosDTO.getIdFuncionario());
			pst.executeUpdate();
			
			pst = con.prepareStatement(cDelete2.toString()); 
			pst.setInt(1, funcionariosDTO.getIdPessoa());
			pst.executeUpdate();
			pst.close();


		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (pst != null) {
				pst.close();
			}


		}
	}
	
	public void alterarFuncionario(FuncionariosDTO funcionariosDTO) throws SQLException, ClassNotFoundException{


		con = new ConexaoDAO().conexaoBD();

		StringBuilder cUpdate = new StringBuilder();
		cUpdate.append(" UPDATE funcionario ");
		cUpdate.append(" SET nomeFuncionario = ? , ");
		cUpdate.append(" salario = ? , ");
		cUpdate.append(" funcao = ? ");
		cUpdate.append(" where idFuncionario = ? ");

		
		StringBuilder cUpdate2 = new StringBuilder();
		cUpdate2.append(" UPDATE pessoa ");
		cUpdate2.append(" SET nome = ? , ");		
		cUpdate2.append(" dataNascimento = ? ");
		cUpdate2.append(" where idPessoa = ? ");

		try {	

			
			pst = con.prepareStatement(cUpdate.toString()); 
			pst.setString(1, funcionariosDTO.getNome());
			pst.setDouble(2, funcionariosDTO.getSalario());
			pst.setString(3, funcionariosDTO.getFuncao());
			pst.setInt(4, funcionariosDTO.getIdFuncionario());
			pst.executeUpdate();
			

			pst = con.prepareStatement(cUpdate2.toString());
			pst.setString(1,funcionariosDTO.getNome());
			pst.setDate(2,funcionariosDTO.getDataNascimento());
			pst.setInt(3,funcionariosDTO.getIdPessoa());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (pst != null) {
				pst.close();
			}


		}
	}

	public Double totalSalarios() throws SQLException, ClassNotFoundException{

		StringBuilder cQuery = new StringBuilder();		
		cQuery.append(" SELECT sum(f.salario) salarioGeral ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");	

		con = new ConexaoDAO().conexaoBD();

		double salarioGeral = 0.0;
		
		try {

			pst = con.prepareStatement(cQuery.toString());
			
			
			rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				salarioGeral = rsDados.getDouble("salarioGeral");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		return salarioGeral;
	}
	
	public void aumentarDezPorcentoSalario() throws ClassNotFoundException, SQLException{
		
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.salario ");
		cQuery.append(" FROM funcionario f");

		StringBuilder cUpdate = new StringBuilder();
		cUpdate.append(" UPDATE funcionario SET salario = ? ");
		cUpdate.append(" where idFuncionario = ? ");

		con = new ConexaoDAO().conexaoBD();

		double vNovoSalario = 0.0;
		
		try {

			pst = con.prepareStatement(cQuery.toString());
			rsDados = pst.executeQuery(); 

			if (rsDados !=null){

				while(rsDados.next()){

					vNovoSalario = rsDados.getDouble("salario") + (rsDados.getDouble("salario") * 10/100);

					pst = con.prepareStatement(cUpdate.toString());
					pst.setDouble(1, vNovoSalario);
					pst.setInt(2, rsDados.getInt("idFuncionario"));
					pst.executeUpdate();


				}
			}
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{

			if (con != null) {

				con.close();

			}

		}
		
		
	}
	
}
