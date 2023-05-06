<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="style.css">

<title>Alterar Usuário</title>
</head>
<body>
<div align="center">
	<div class="input-group">
		<form action="alterarFuncionario.jsp" method="POST">	
				<input type="hidden" name="id"
					   value="<%=request.getParameter("id")%>">
					
			<div class="input-group">
            	<label for="nome"> Nome Funcionário</label>
            	<input 
            		type="text" name= "nome" id="nome" 
            		value="<%=request.getParameter("nome")%>">
            </div>		
			<div class="input-group">
				<label for="dataNascimento"> Data de Nascimento: </label>  
				<input
					type="text" name="dataNascimento" id="dataNascimento"
					value="<%=request.getParameter("dataNascimento")%>">
			</div>
			<div class="input-group">
			<label for="salario"> Salário: </label> 
				<input
					type="text" name="salario" id="salario"
					value="<%=request.getParameter("salario")%>">
			</div>
			<div class="input-group">
			<label for="funcao"> Função: </label> 
				<input
					type="text" name="funcao" id="funcao"
					value="<%=request.getParameter("funcao")%>" disabled="disabled">
			</div>
			<div class="input-group">
				<select name="funcao">
					<option value="operador">Operador</option>
					<option value="coordenador">Coordenador</option>
					<option value="diretor">Diretor</option>
					<option value="recepcionista">Recepcionista</option>
					<option value="contador">Contador</option>
					<option value="gerente">Gerente</option>
					<option value="eletricista">Eletricista</option>
				</select>				
			</div>	
	
			<button type="submit">Alterar</button>
		</form>
		
		<div class="input-group">
	
			<div class="voltarAlter" align="center">
				<a href="listarFuncionariosTable.jsp">
					<img src="../Assets/voltar.png">			
				</a>
			</div>	
		
		</div>
</div>	
</body>
</html>