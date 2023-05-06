<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.DTO.FuncionariosDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.DAO.FuncionariosDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="style.css">

<title>Listar em Tabela</title>
</head>
<body>

<%
	FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
	ArrayList<FuncionariosDTO> lista = funcionariosDAO.listarFuncionariosGeral();

	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
	DecimalFormat df = new DecimalFormat("¤ ###,###,##0.00");
	
	DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
	double qtdSalarioMin = 0.0;
	
	double totalSalario = 0.0;
	totalSalario = funcionariosDAO.totalSalarios();
	
%>
<div>
<table class="tabela">
  <thead class="tabela">
	  <tr class="tabela">
	    <th>Nome</th>
	    <th>Data Nascimento</th>
	    <th>Salario</th>
	    <th>Função</th>
	    <th>Qtd. Salarios Min.</th>
	    <th>Editar</th>
	    <th>Excluir</th>
	  </tr>
  </thead>
  <tbody>
  
  	<% for(int i = 0; i < lista.size(); i++){
  	
  		qtdSalarioMin = (lista.get(i).getSalario() / 1212.0);
  		
  	%>
  		<tr>
  			<td><%= lista.get(i).getNome()%></td>
  			<td><%= sd.format(lista.get(i).getDataNascimento())%></td>
  			<td><%= df.format(lista.get(i).getSalario())%></td>
  			<td><%= lista.get(i).getFuncao()%></td>
  			<td><%= df2.format(qtdSalarioMin)%></td>
  			<td>
  				<a class="alterar" href='frmAlterarFuncionarioView.jsp?id=
					<%out.print(lista.get(i).getIdFuncionario());%>
					&nome=<%out.print(lista.get(i).getNome());%>
					&dataNascimento=<%out.print(sd.format(lista.get(i).getDataNascimento()));%>
					&salario=<%out.print(df.format(lista.get(i).getSalario()));%>
					&funcao=<%out.print(lista.get(i).getFuncao());%>
					'>
							<img src="../Assets/editar.png">
				</a>
  			</td>
  			<td>
  				<a href='frmDeletarFuncionárioView.jsp?id=
					<%out.print(lista.get(i).getIdFuncionario());%>
					&nome=<%out.print(lista.get(i).getNome());%>'>
							<img src="../Assets/lixeira.png">
				</a>
  			</td>
  		</tr>
  	<%}%>
  </tbody>
</table>
 <div class="input-group">
     <label for="totalSalarios">Total Dos Salários:</label>
     <input type="text" name= ""totalSalarios"" id="totalSalarios" disabled="disabled"
     value="<%=df.format(totalSalario)%>">
 </div>	
	
<div class="input-group">
	
		<div class="voltar">
			<a href="frmFuncionarioView.jsp">
				<img src="../Assets/voltar.png">			
			</a>
			<div class="btn-Aumento">
				<form action="aumentoDezPorcento.jsp" method="POST">
					<button type="submit"> 
						Aumentar 10%
					</button>			
				</form>
			</div>
			<br>
		</div>
</div>	
</div>
</body>
</html>