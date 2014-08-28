
	
package controle;

import java.util.List;

import modelo.Matricula;
import dao.DAOFactory;
import dao.MatriculaDAO;




public class MatriculaControle {
	
	private static final String String = null;


	public void salvar(Matricula matricula) throws Exception {
		if (matricula.getNome() == null || matricula.getNome().trim().isEmpty()) {
			throw new Exception("A matricula é obrigatória!");
		}
		
		if (matricula.getCurso() == null || matricula.getCurso().trim().isEmpty()) {
			throw new Exception("O curso é obrigatório!");
		}
		
			
		MatriculaDAO matriculaDao = DAOFactory.getMatriculaDAO();
		
		if (matricula.getIdmatricula() == 0) {
			matriculaDao.salvar(matricula);

		} else {
		 matriculaDao.alterar(matricula);
		}
		
		
		
	}
	
	
	public List<Matricula> listar() {
		MatriculaDAO matriculaDao = DAOFactory.getMatriculaDAO();
		return matriculaDao.findAll();

	}

	public void excluir(Matricula matricula) throws Exception {

		if (matricula == null) {

			throw new Exception("É obrigatorio selecionar uma matricula");
		}
		MatriculaDAO matriculaDao = DAOFactory.getMatriculaDAO();
		matriculaDao.deletar(matricula);
	}
	
	public List<Matricula> buscarPorNomeCurso(String nome) throws Exception{
		if (nome.trim().isEmpty()) {
			throw new Exception("É obrigatorio digitar um nome do curso");
						 
		}
		
		MatriculaDAO matriculaDao = DAOFactory.getMatriculaDAO();
		List<Matricula> matriculas = matriculaDao.buscarPorNomeCurso(nome);
				if (matriculas.isEmpty()) {
					throw new Exception("Matricula não cadastrada!");
				}else{
					return matriculas;
					
				}
	}
	
				
		
	}
	

