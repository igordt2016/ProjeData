<!DOCTYPE html>
<%@page import="br.com.DTO.FuncionariosDTO"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="UTF-8">
<title>Excluir Funcionario</title>
</head>
<body>

<div align="center">

	<div class="input-group">
		<form action="excluirFuncionario.jsp" method="POST">	
			<input class="input-group" type="hidden" name="id" id="id"
				   value="<%=request.getParameter("id")%>">
			<div class="input-group">			
			<label class="input-group" for="nome"> Nome Funcionário: </label> 
			<input class="input-group"
				type="text" name="nome" id="nome"
				value="<%=request.getParameter("nome")%>" disabled="disabled">
			</div>
			<button type="submit">Confirmar Exclusão</button>					
		</form>
	
	</div>
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