<%@page import="br.com.DAO.FuncionariosDAO"%>
<%@page import="br.com.DTO.FuncionariosDTO"%>
<%@page import="br.com.DTO.PessoaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excluir</title>
</head>
<body>

<%
		try {

			
			FuncionariosDTO funcionariosDto = new FuncionariosDTO();
			FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
			
			String requestUrl = "listarFuncionariosTable.jsp";
			
			funcionariosDto.setIdFuncionario(Integer.parseInt(request.getParameter("id")));
			funcionariosDto.setIdPessoa(Integer.parseInt(request.getParameter("id")));
			
			funcionariosDAO.deletarFuncionario(funcionariosDto);
			response.sendRedirect(requestUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	%>

</body>
</html>