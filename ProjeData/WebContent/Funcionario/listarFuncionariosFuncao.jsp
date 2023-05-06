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

<title>Listar Por Função</title>
</head>
<body>
<div align="center">
	<div class="input-group">
		<form action="listarFuncionariosFuncao2.jsp">
				<div class="input-group">
					<label for="funcao">Função</label>
                    <select name="funcao" id="funcao" required>
						<option value="Operador">Operador</option>
						<option value="Coordenador">Coordenador</option>
						<option value="Diretor">Diretor</option>
						<option value="Recepcionista">Recepcionista</option>
						<option value="Contador">Contador</option>
						<option value="Gerente">Gerente</option>
						<option value="Eletricista">Eletricista</option>
					</select>					
					<div class="input-group">
                    	<button type="submit">Listar Função</button>
                	</div>		                    
                </div>
	            <div class="voltar">
				<a href="frmFuncionarioView.jsp">
					<img src="../Assets/voltar.png">			
				</a>
				</div>
		</form>				
</div>	           
</body>
</html>