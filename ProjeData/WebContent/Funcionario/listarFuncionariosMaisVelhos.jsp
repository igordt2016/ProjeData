<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="java.math.BigDecimal"%>
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
<title>Lista Por Idade</title>
</head>
<body>

<%
FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
ArrayList<FuncionariosDTO> lista = funcionariosDAO.listarFuncionariosMaisVelhos();			

SimpleDateFormat sd = new SimpleDateFormat("yyyy");

int ano = 0;							
int anoNascimento = 0;
int vIdade = 0;

ano = funcionariosDAO.anoAtual();

%>

<div>
<table class="tabela">
  <thead class="tabela">
	  <tr class="tabela">
	    <th>Nome</th>
	    <th>Idade</th>
	  </tr>
  </thead>
  <tbody>
  
  	<% for(int i = 0; i < lista.size(); i++){
  		
  		anoNascimento = Integer.parseInt(sd.format(lista.get(i).getDataNascimento()));
  		
  		vIdade = ano - anoNascimento;
  	
  	%>
  		<tr>
  			<td><%= lista.get(i).getNome()%></td>
  			<td><%= vIdade%></td>
  		</tr>
  	<%}%>
  </tbody>
</table>
	
<div class="input-group">
	
		<div class="voltar">
			<a href="frmFuncionarioView.jsp">
				<img src="../Assets/voltar.png">			
			</a>
		</div>
</div>	
</div>
</body>
</html>