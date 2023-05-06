<%@page import="br.com.DAO.FuncionariosDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aumento Dez Por Cento</title>
</head>
<body>

	<%
	
		try{
			
			FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
			String redirectURL = "listarFuncionariosTable.jsp";

			funcionariosDAO.aumentarDezPorcentoSalario();
			
			response.sendRedirect(redirectURL);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	%>

</body>
</html>