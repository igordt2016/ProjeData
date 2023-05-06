<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="br.com.DAO.FuncionariosDAO"%>
<%@page import="br.com.DTO.PessoaDTO"%>
<%@page import="br.com.DTO.FuncionariosDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Funcionário</title>
</head>
<body>

	<%
		try {

			PessoaDTO pessoaDto = new PessoaDTO();
			FuncionariosDTO funcionariosDto = new FuncionariosDTO();
			FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
			
			String redirectURL = "frmFuncionarioView.jsp";
			     
			
			Date data = null;
			double salario = 0.0;
			
			data = funcionariosDAO.converteData(request.getParameter("dataNascimento"));
			
			salario = funcionariosDAO.converteSalario(request.getParameter("salario"));
			
			pessoaDto.setNome(request.getParameter("nome"));
			pessoaDto.setDataNascimento(data);
			funcionariosDto.setSalario(salario);
			funcionariosDto.setFuncao(request.getParameter("funcao"));

			
			funcionariosDAO.cadastrarUsuario(pessoaDto, funcionariosDto);

			response.sendRedirect(redirectURL);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

</body>
</html>