package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import controle.MatriculaControle;

import modelo.Matricula;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfCurso;
	private JButton btnListar;
	private JComboBox cbMatriculas;
	private JButton btnBuscarPorCurso;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnNovo;
	private MatriculaControle controle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setTitle("Tela Inicial de Matr\u00EDculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbMatriculas = new JComboBox();
		cbMatriculas.setBounds(10, 163, 370, 20);
		contentPane.add(cbMatriculas);
		
		tfCurso = new JTextField();
		tfCurso.setBounds(10, 128, 370, 20);
		contentPane.add(tfCurso);
		tfCurso.setColumns(10);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cbMatriculas.removeAllItems();
				for (Matricula re : controle.listar()) {
					cbMatriculas.addItem(re);
				}
				
				
			}
				
		});
		btnListar.setBounds(390, 162, 151, 23);
		contentPane.add(btnListar);
		
		btnBuscarPorCurso = new JButton("Buscar por Curso");
		btnBuscarPorCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				cbMatriculas.removeAllItems();
				try {
					List<Matricula> matriculas = controle.buscarPorNomeCurso( tfCurso.getText());
					for (Matricula re : matriculas) {
						cbMatriculas.addItem(re);
					}
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

					ex.printStackTrace();
				}
				
				
			}
		});
		btnBuscarPorCurso.setBounds(390, 127, 151, 23);
		contentPane.add(btnBuscarPorCurso);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);

				dispose();
				
				
			}
		});
		btnNovo.setBounds(291, 194, 89, 23);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matricula matricula = (Matricula) cbMatriculas.getSelectedItem();
				Cadastro cadastro = new Cadastro();
				cadastro.carregarMatricula(matricula);
				cadastro.setVisible(true);
				dispose();
					
			}
		});
		btnAlterar.setBounds(192, 194, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Matricula matricula = (Matricula) cbMatriculas.getSelectedItem();
              
				
				try {
					controle.excluir(matricula);
					cbMatriculas.removeItem(matricula);
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
				
				
				
			}
		});
				
				
			
		btnExcluir.setBounds(93, 194, 89, 23);
		contentPane.add(btnExcluir);
	}

}
