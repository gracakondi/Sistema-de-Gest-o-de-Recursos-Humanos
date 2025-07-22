/*------------------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: Analise.java
Data: 20.05.2024
-------------------------------------------------


1. Objectivo: O projecto tem o objectivo primordial de:
	- Registrar dados de Funcionarios;
	- Registrar dados dos Departamentos; 
	- Registrar Contratos;


2. Visao [Interfaces Graficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipalVisao
- FuncionarioVisao
- DepartamentoVisao
- ContratoVisao
- FolhaPagamentoVisao
- EditarFuncionarioVisao
- EditarDepartamentoVisao
- EditarContratoVisao
- EliminarFuncionarioVisao
- EliminarDepartamentoVisao
- EliminarContratoVisao
- PesquisarFuncionarioVisao
- PesquisarDepartamentoVisao
- PesquisarContratoVisao
- NovoFuncionarioVisao
- NovoDepartamentoVisao
- NovoContratoVisao


3. Entidades Fortes e Seus Atributos (Modelo)
- FuncionarioModelo
  	String id
  	String nome
  	String data_nascimento
  	String morada
  	String email
  	String contacto
  	String estadoCivil
  	String nacionalidade
  	String municipio
  	String bairro
  	Boolean status
  
- DepartamentoModelo
  	String - nome
  	String - id
  	int - nmembros
  	String - gerente
  	Boolean - status

  	
 - ContratoModelo
 	int id;
 	string Salario;
 	String departamento;
 	String cargo;
 	String horario;
 	String dataContrato;
 	String dataExpirar;
  	String banco
  	double contaBancario		
  	String horario
  	Boolean - status

  
- FolhaPagamentoModelo
	DataModelo dataInicio
	DataModelo dataFim
	String horaExtra
	int faltas
	double - salariobruto
	double - salariofinal

	
4. Ficheiro
- FuncionarioFile.dat
- DepartamentoFile.dat
- ContratoFile.dat
- FolhaPagamento.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Nacionalidades.tab
- Provincis.tab
- Municipio.tab
- Bairro.tab
- Departamento.tab
- Gerente.atb
- EstadoCivil.tab
- Nome.tab
- ContratoTipo.tab 


6. Diversos
6.1 - Implementação: Java Swing
6.2 - IDE: Bloco de Notas/Terminal

*/
