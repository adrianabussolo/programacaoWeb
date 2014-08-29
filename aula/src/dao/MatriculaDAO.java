package dao;



import java.util.List;

import modelo.Matricula;



	
	public interface MatriculaDAO extends DAO<Matricula>{

		List<Matricula> buscarPorNomeCurso(String curso) ;
		
		
	}


