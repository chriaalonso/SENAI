package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Banco {
	
	//1 passo abrir conexao
	public Connection getConexao() {

		Connection conexao = null;
		try {
			//Instalando o .jar no projeto
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!" + e);
		}

		try {
			String url = "jdbc:mysql://localhost:3306/db_vagas";
			String user = "root";
			String password = "";

			conexao = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("Driver não encontrado!" + e);
		}

		return conexao;

	}
	
	
	//Listar os dados - listar aberta, fechada ou todas
	// 0 fechada , 1 aberta , * todas
	public String listar(int aberta) {
		
		String linha="";
		try {
			Connection conn = getConexao();

			
			String sql = "SELECT * FROM vagas";
			
			if(aberta==1)
				sql = sql + " where aberta=1";
			else if(aberta==0)
				sql = sql + " where aberta=0";
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				long idaux = rs.getInt(1);
				String tituloaux = rs.getString(2);
				String abertaaux = rs.getString(3);
				String remuneracaoaux = rs.getString(4);
				String localDeTrabalhoaux = rs.getString(5);
				String requisitosObrigatoriosaux = rs.getString(6);
				String requisitosDesejaveisaux = rs.getString(7);
				String beneficiosaux = rs.getString(8);
				String descricaoaux = rs.getString(9);
				
				
				linha = linha + 
						"<div class='card bg-light mb-3'>" +
							"<div class='card-header'>"+ tituloaux + "</div>" +
							"<div class='card-body'>" +
								"<br>"+ 
								"<div class='font-w'>Código:</div>" + idaux + "<br>" +
								"<div class='font-w'>Aberta:</div>" + abertaaux+ "<br>" +
								"<div class='font-w'>Remuneração:</div>" + remuneracaoaux + "<br>" +
								"<div class='font-w'>Local de Trabalho:</div>" + localDeTrabalhoaux + "<br>" +
								"<div class='font-w'>Requisitos Obrigatorios:</div>" + requisitosObrigatoriosaux + "<br>" +
								"<div class='font-w'>Requisitos Desejaveis:</div>" + requisitosDesejaveisaux + "<br>" +
								"<div class='font-w'>Beneficios:</div>" + beneficiosaux + "<br>" +
								"<div class='font-w'>Descrição:</div>" + descricaoaux + "<br>" +
								"<a href='./excluir.jsp?id="+idaux+"' class='btn btn-success me-5 mt-5'>Excluir</a>"+
								"<a href='./editar.jsp?id="+idaux+"' class='btn btn-success mt-5'>Editar</a>" +
							"</div>" +
						"</div>";
			}

		} catch (Exception e) {
			System.out.println("Erro em Listar:" + e);
		}
		
		return linha;
	}
	
	//Inseri dados
	public void inserir(Vagas vg)
	{
		try {
			Connection conn = getConexao();

			String sql = 
					"Insert into vagas ("			
					+"titulo, aberta, remuneracao, localDeTrabalho,"
					+"requisitosObrigatorios, requisitosDesejaveis,"
					+ "beneficios, descricao"
					+ ") values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, vg.getTitulo());
			ps.setInt(2, vg.getAberta());
			ps.setString(3, vg.getRemuneracao());
			ps.setString(4, vg.getLocalDeTrabalho());
			ps.setString(5, vg.getRequisitosObrigatorios()); 
			ps.setString(6, vg.getRequisitosDesejaveis());
			ps.setString(7, vg.getBeneficios());
			ps.setString(8, vg.getDescricao());
						
			ps.execute();		

		} catch (Exception e) {
			System.out.println("Erro ao Inserir :" + e);
		}
		
	}
	
	
	//Excluir dados
	public void excluir(int idaux)
	{
		try {
			Connection conn = getConexao();

			 String query = "delete from vagas where id ="+idaux;
		      PreparedStatement ps = conn.prepareStatement(query);
		         
		      ps.execute();

		} catch (Exception e) {
			System.out.println("Erro ao Excluir:" + e);
		}	
	}
	
	
	//Editar parte 1 - buscar dados no Banco
public Vagas buscar(int idaux) {
		
		Vagas vg=new Vagas();
		try {
			Connection conn = getConexao();

			
			String sql = "SELECT * FROM vagas where id="+idaux;
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, idaux);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vg.setId(rs.getInt(1));
				vg.setTitulo(rs.getString(2));
				vg.setAberta(rs.getInt(3));
				vg.setRemuneracao(rs.getString(4));
				vg.setLocalDeTrabalho(rs.getString(5));
				vg. setRequisitosObrigatorios(rs.getString(6)); 
				vg.setRequisitosDesejaveis(rs.getString(7));
				vg.setBeneficios(rs.getString(8));
				vg.setDescricao(rs.getString(9));
			}

		} catch (Exception e) {
			System.out.println("Erro em Listar:" + e);
		}
		
		return vg;
	}


//Editar parte 2

public void editar(Vagas vg)
{
	try {
		Connection conn = getConexao();
		
		String sql = 
				"Update vagas set "	
				+ "titulo=?,"
				+ "aberta=?,"
				+ "remuneracao=?,"
				+ "localDeTrabalho=?,"
				+ "requisitosObrigatorios=?,"
				+ "requisitosDesejaveis=?,"
				+ "beneficios=?,"
				+ "descricao=?,"
				+ " where id=? ;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, vg.getId());
		ps.setString(2, vg.getTitulo());
		ps.setInt(3, vg.getAberta());
		ps.setString(4, vg.getRemuneracao());
		ps.setString(5, vg.getLocalDeTrabalho());
		ps.setString(6, vg.getRequisitosObrigatorios()); 
		ps.setString(7, vg.getRequisitosDesejaveis());
		ps.setString(8, vg.getBeneficios());
		ps.setString(9, vg.getDescricao());
		
		 ps.execute();	

	} catch (Exception e) {
		System.out.println("Erro ao Editar:" + e);
	}
	
}
}
