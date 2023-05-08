import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) throws SQLException {


		//		listarFuncionariosGeral();
		//		deletarUser("João");
		//		aumentoDezPorCento();
		//		listarFuncionariosFuncao("Operador");
		//		listarFuncionariosFuncaoAgrup();
		//		listarFuncionariosMeses();
		//		listarFuncionariosMaiorIdade();
		//		listarFuncionariosOrdAlfabet();
		//		totalSalario();
		//		salariosMinimos();					


//				Scanner sc = new Scanner(System.in);
//				System.out.println("1 - Cadastrar Funcionário -");
//				System.out.println("2 - Listar Todos os Funcionários -");
//				System.out.println("3 - Deletar Funcionário -");
//				System.out.println("4 - Aumentar 10% do Salário -");
//				System.out.println("5 - Agrupar Funcionarios -");
//				System.out.println("6 - Listar Funcionarios por Função -");
//				System.out.println("7 - Aniversariantes do mês 10 e 12 -");
//				System.out.println("8 - Funcionário de Maior Idade -");
//				System.out.println("9 - Lista em Ordem Alfabética -");
//				System.out.println("10 - Somatório dos Salários -");
//				System.out.println("11 - Quantidade de Salários Mínimos -");
//				System.out.println("12 - Encerrar Programa -");
				
				menuOperacoes();
		
				

	}

	public static void listarFuncionariosGeral() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");

		try {

			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+sd.format(rsDados.getDate("dataNascimento")) + " | "
						+df.format(rsDados.getDouble("salario")) + " | "+rsDados.getString("funcao"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void salariosMinimosInteiro() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();		
		cQuery.append(" SELECT f.nomeFuncionario nome, convert(f.salario / 1212.0 ,decimal) qtSalariosMinimos ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");		

		try {

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println("Nome Funcionário: "+rsDados.getString("nome")+" | "+"Quantidade de Salários Mínimos: "+rsDados.getBigDecimal("qtSalariosMinimos"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}
	
	public static void salariosMinimosQuebrado() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();		
		cQuery.append(" SELECT f.nomeFuncionario nome, f.salario / 1212.0  qtSalariosMinimos ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");		

		double vQtdSalarios;
		
		try {

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			
			
			while(rsDados.next()){

				vQtdSalarios = rsDados.getDouble("qtSalariosMinimos");
				
				System.out.println("Nome Funcionário: "+rsDados.getString("nome")+" | "+"Quantidade de Salários Mínimos: "+vQtdSalarios);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void totalSalario() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();		
		cQuery.append(" SELECT sum(f.salario) salarioGeral ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");		

		try {

			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println("Somatório dos Salários: "+df.format(rsDados.getDouble("salarioGeral")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}


	public static void listarFuncionariosOrdAlfabet() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" order by 1 ");

		try {

			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+sd.format(rsDados.getDate("dataNascimento")) + " | "
						+df.format(rsDados.getDouble("salario")) + " | "+rsDados.getString("funcao"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void listarFuncionariosMaiorIdade() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, convert(date_format(sysdate(),'%Y') - date_format(p.dataNascimento,'%Y'), decimal) dataNascimento ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" order by 2 desc ");

		try {

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+rsDados.getBigDecimal("dataNascimento"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void listarFuncionariosAniversario() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" and month(p.dataNascimento) in ('10','12') ");

		try {

			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+sd.format(rsDados.getDate("dataNascimento")) + " | "
						+df.format(rsDados.getDouble("salario")) + " | "+rsDados.getString("funcao"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void listarFuncionariosFuncao() throws SQLException{

		Conexao con = new Conexao();
		Scanner sc = new Scanner(System.in);
		
		String funcao;
		
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" and f.funcao = ? ");

		try {

			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			System.out.print("Digite a função que deseja listar: ");
			funcao = sc.nextLine();
			
			PreparedStatement pst = con.getCon().prepareStatement(cQuery.toString());
			pst.setString(1, funcao);

			ResultSet rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+sd.format(rsDados.getDate("dataNascimento")) + " | "
						+df.format(rsDados.getDouble("salario")) + " | "+rsDados.getString("funcao"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}

	public static void listarFuncionariosFuncaoAgrup() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.nomeFuncionario, p.dataNascimento, f.salario, f.funcao ");
		cQuery.append(" FROM funcionario f, pessoa p ");
		cQuery.append(" where f.idFuncionario = p.idPessoa ");
		cQuery.append(" order by 4 ");

		try {

			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###,##0.00");

			PreparedStatement pst = con.getCon().prepareStatement(cQuery.toString());

			ResultSet rsDados = pst.executeQuery(); 

			while(rsDados.next()){

				System.out.println(rsDados.getString("nomeFuncionario") + " | "+sd.format(rsDados.getDate("dataNascimento")) + " | "
						+df.format(rsDados.getDouble("salario")) + " | "+rsDados.getString("funcao"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();
	}	

	public static void deletarUsuario() throws SQLException{

		Conexao con = new Conexao();
		
		String nome;
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT nomeFuncionario FROM FUNCIONARIO ");
		cQuery.append(" where nomeFuncionario = ? ");
		String vNome;
		
		StringBuilder cDelete = new StringBuilder();
		cDelete.append(" Delete from funcionario ");
		cDelete.append(" WHERE nomeFuncionario = ? ");

		StringBuilder cDelete2 = new StringBuilder();
		cDelete2.append(" Delete from pessoa ");
		cDelete2.append(" WHERE nome = ? ");


		try {	
			
			System.out.println("Digite o nome do Funcionário a ser Deletado: ");
			nome = sc.nextLine();
			
			PreparedStatement pstQuery = con.getCon().prepareStatement(cQuery.toString());
			pstQuery.setString(1, nome);
			ResultSet rsDados = pstQuery.executeQuery();
			
			while(rsDados.next()){

				vNome = rsDados.getString("nomeFuncionario"); 
				
				if(!vNome.equals(nome)){
					
					System.out.println("Funcionário não existe!");
					
					throw new Exception();
					
				}

			}
			
			
			PreparedStatement pst = con.getCon().prepareStatement(cDelete.toString()); 
			pst.setString(1, nome);
			pst.executeUpdate();

			PreparedStatement pst2 = con.getCon().prepareStatement(cDelete2.toString()); 
			pst2.setString(1, nome);
			pst2.executeUpdate();	
			
			System.out.println("Funcionário Deletado Com Sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}		
		finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();

	}

	public static void aumentoDezPorCento() throws SQLException{

		Conexao con = new Conexao();
		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT f.idFuncionario, f.salario ");
		cQuery.append(" FROM funcionario f");

		StringBuilder cUpdate = new StringBuilder();
		cUpdate.append(" UPDATE funcionario SET salario = ? ");
		cUpdate.append(" where idFuncionario = ? ");

		double vNovoSalario = 0; 

		try {

			ResultSet rsDados = con.getCon().createStatement().
					executeQuery(cQuery.toString()); 

			while(rsDados.next()){

				vNovoSalario = rsDados.getDouble("salario") + (rsDados.getDouble("salario") * 10/100);

				PreparedStatement pst = con.getCon().prepareStatement(cUpdate.toString());
				pst.setDouble(1,vNovoSalario);
				pst.setInt(2,rsDados.getInt("idFuncionario"));
				pst.executeUpdate();


			}

			listarFuncionariosGeral();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}

		menuOperacoes();

	}

	public static void cadastrarPessoa() throws SQLException{
		
		Scanner sc = new Scanner(System.in);
		
		String nome;			
		String dataString;
		LocalDate date;
		Date data;
		String funcao;
		double salario;
		
		Conexao con = new Conexao();

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT max(idPessoa) + 1 newIdPessoa from pessoa ");

		int vIdPessoa = 0;

		StringBuilder cInsert = new StringBuilder();
		cInsert.append(" INSERT into pessoa (idPessoa, nome, dataNascimento) ");
		cInsert.append(" values(?,?,?) ");

		try {	

			PreparedStatement pst = con.getCon().prepareStatement(cQuery.toString());
			ResultSet rsDados = pst.executeQuery();

			while(rsDados.next()){

				System.out.println("-Cadastro de Funcionário-");
				System.out.print("Digite o nome do Funcionário: ");
				nome = sc.nextLine();
				System.out.print("Digite a data de nascimento (Ex.: 10/01/2000): ");
				dataString = sc.nextLine();
				String [] dataSeparada = dataString.split("/");
				date = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
				data = Date.valueOf(date);
				
				vIdPessoa = rsDados.getInt("newIdPessoa"); 
				PreparedStatement pst2 = con.getCon().prepareStatement(cInsert.toString()); 
				pst2.setInt(1, vIdPessoa);
				pst2.setString(2, nome);
				pst2.setDate(3, data);
				pst2.executeUpdate();
				
				System.out.print("Digite a função do Funcionário: ");
				funcao = sc.nextLine();
				System.out.print("Digite o salário do Funcionário: ");
				salario = sc.nextDouble();
				cadastrarFuncionario(nome,salario,funcao);

			}

			System.out.println("Cadastro Realizado com Sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao Cadastrar!");
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}
		menuOperacoes();

	}

	public static void cadastrarFuncionario(String nomeFunc, double salario, String funcao) throws SQLException{

		Conexao con = new Conexao();

		StringBuilder cQuery = new StringBuilder();
		cQuery.append(" SELECT max(idFuncionario) + 1 newIdFuncionario from funcionario ");

		int vIdFuncionario = 0;

		StringBuilder cInsert = new StringBuilder();
		cInsert.append(" INSERT into funcionario (idFuncionario, nomeFuncionario, salario, funcao) ");
		cInsert.append(" values(?,?,?,?) ");

		try {	

			PreparedStatement pst = con.getCon().prepareStatement(cQuery.toString());
			ResultSet rsDados = pst.executeQuery();

			while(rsDados.next()){

				vIdFuncionario = rsDados.getInt("newIdFuncionario"); 
				PreparedStatement pst2 = con.getCon().prepareStatement(cInsert.toString()); 
				pst2.setInt(1, vIdFuncionario);
				pst2.setString(2, nomeFunc);
				pst2.setDouble(3, salario);
				pst2.setString(4, funcao);
				pst2.executeUpdate();

			}



		} catch (Exception e) {
			e.printStackTrace();
		}finally{

			if (con.getCon() != null) {

				con.getCon().close();

			}

		}

	}


	public static void menuOperacoes() throws SQLException{
		
		Scanner sc = new Scanner(System.in);
		
		int valor = 0;
		System.out.println("-------------BEM-VINDO---------------");
		System.out.println("-------------------------------------");
		System.out.println("1 - Cadastrar Funcionário -");
		System.out.println("2 - Listar Todos os Funcionários -");
		System.out.println("3 - Deletar Funcionário -");
		System.out.println("4 - Aumentar 10% do Salário -");
		System.out.println("5 - Agrupar Funcionarios -");
		System.out.println("6 - Listar Funcionarios por Função -");
		System.out.println("7 - Aniversariantes do mês 10 e 12 -");
		System.out.println("8 - Funcionário de Maior Idade -");
		System.out.println("9 - Lista em Ordem Alfabética -");
		System.out.println("10 - Somatório dos Salários -");
		System.out.println("11 - Quantidade de Salários Mínimos Inteiro -");
		System.out.println("12 - Quantidade de Salários Mínimos Quebrado -");
		System.out.println("13 - Encerrar Programa -");
		System.out.println("-------------------------------------");
		
		valor = sc.nextInt(); 
		
		switch (valor) {
		case 1: {
			
			cadastrarPessoa();
			break;
		}
		case 2: {
			listarFuncionariosGeral();
			break;
		}
		case 3: {
			deletarUsuario();
			break;
		}
		case 4: {
			aumentoDezPorCento();
			break;
		}
		case 5: {
			listarFuncionariosFuncaoAgrup();
			break;
		}
		case 6: {
			listarFuncionariosFuncao();
			break;
		}
		case 7: {
			listarFuncionariosAniversario();
			break;
		}
		case 8: {
			listarFuncionariosMaiorIdade();
			break;
		}
		case 9: {
			listarFuncionariosOrdAlfabet();
			break;
		}
		case 10: {
			totalSalario();
			break;
		}
		case 11: {
			salariosMinimosInteiro();
			break;
		}
		case 12: {
			salariosMinimosQuebrado();			
			break;
		}
		case 13: {
			System.out.println("Até a Próxima!");
			System.exit(0);
			break;
		}

		default:
			System.out.println("Opção Inválida!");
			menuOperacoes();
			break;
		}
		
	}
	
}
