package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Aluno;

public class CrudDAO {

	//crud C- Create R- Read U- Update D- Delete
	
	//Create (inserir DADOS)
	public void create(Aluno aluno) {
		String sql = "INSERT INTO alunos(nome, idade) VALUES (?,?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = 	Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO: " + e);
			
		} finally {
			try {
				if(p != null);
				p.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}//fim CREATE
	
	//metodo U - update
	public void update(Aluno aluno) {
		String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null; //link do barco
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.setInt(2, aluno.getIdade());
			p.setInt(3, aluno.getRa());
			p.execute(); //executa inst para gravar dados no banco
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			System.out.println("dados atualizados com sucesso!");
			
			
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO: " + e);
				
			}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e ) {
					e.printStackTrace();
				}
			}
	}//fim update
	
	//R - read
	public List<Aluno> read(){
		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			resultado = p.executeQuery(); //mostra os dados da cuonsulta aql
			while(resultado.next()) {
				Aluno ver_aluno = new Aluno();
				//recuperar RA
				ver_aluno.setRa(resultado.getInt("ra"));
				//recuperar o nome
				ver_aluno.setNome(resultado.getString("nome"));
				//recuperar idade
				ver_aluno.setIdade(resultado.getInt("idade"));
				//adicionar na lista
				alunos.add(ver_aluno);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		return alunos;
	}//fim read
	
	//D - Delete
	public boolean delete(int ra) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setInt(1, ra);
			p.execute();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			System.out.println("dados excluidos com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		return false;
		}//fim delete
	
	
	
	
	
}//fim classe
