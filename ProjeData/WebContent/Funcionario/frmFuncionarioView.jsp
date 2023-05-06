<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="style.css">
    <title>Funcionários</title>
</head>
<body>
    <div class="box">
        <div class="img-box">
            <img src="../Assets/img-formulario.png">
        </div>
        <div class="form-box">
            <h2>Cadastro de Funcionário</h2>
            <form action="inserirFuncionario.jsp" method="POST">
                <div class="input-group">
                    <label for="nome"> Nome Completo</label>
                    <input type="text" name= "nome" id="nome" placeholder="Digite nome do funcionário" required>
                </div>

				<div class="input-group">
					<label for="dataNascimento">Data de Nascimento</label>
					<input type="date" name="dataNascimento" id="dataNascimento" placeholder="Data de Nascimento" required>
				</div>   

                <div class="input-group">
                    <label for="salario">Salário</label>
                    <input type="text" name="salario" id="salario" placeholder="Digite o salário do funcionário" required>
                </div>
				
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
							                    
                </div>

                <div class="input-group">
                    <button type="submit">Cadastrar</button>
                </div>
            </form>
			
			<a href="listarFuncionariosTable.jsp">
				<div class="btn-Listar">
					<button>Listar Funcionarios</button>
				</div>
			</a>
			
			<a href="listarFuncionariosOrdAlfab.jsp">
				<div class="btn-Listar">
					<button>Listar por Ordem Alfabética</button>
				</div>
			</a>
			<a href="listarFuncionariosMaisVelhos.jsp">
				<div class="btn-Listar">
					<button>Listar por Idade</button>
				</div>
			</a>
			<a href="listarFuncionariosMes10e12.jsp">
				<div class="btn-Listar">
					<button>Listar Aniversário 10 e 12</button>
				</div>
			</a>
			<a href="listarFuncionariosFuncao.jsp">
				<div class="btn-Listar">
					<button>Listar Funcionario Funcao</button>
				</div>
			</a>
        </div>
    </div>
</body>
</html>