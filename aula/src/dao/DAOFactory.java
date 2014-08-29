package dao;





	public abstract class DAOFactory {

		private static MatriculaDAO matriculaDAO;

		public static MatriculaDAO getMatriculaDAO() {
			if (matriculaDAO == null) {
				matriculaDAO = new MatriculaDAOImp();
			}

			if (matriculaDAO.isConnectionClose()) {
				matriculaDAO.openConnection();
			}

			return matriculaDAO;
		}
	}


