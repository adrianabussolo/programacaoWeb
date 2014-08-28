package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import controle.MatriculaControle;

import modelo.Matricula;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfCpf;
	private JTextField tfEndereco;
	private JComboBox cbCurso;
	private JLabel lblNomeDoAluno;
	private JLabel lblCurso;
	private JLabel lblDataDeNascimento;
	private JLabel lblCpf;
	private JLabel lblEndereo;
	
	private Matricula matricula = new Matricula();
	private MatriculaControle controle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastro de Matr\u00EDcula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomeDoAluno = new JLabel("Nome do Aluno:");
		lblNomeDoAluno.setBounds(10, 11, 118, 14);
		contentPane.add(lblNomeDoAluno);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 36, 118, 14);
		contentPane.add(lblCurso);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 61, 118, 14);
		contentPane.add(lblDataDeNascimento);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 86, 118, 14);
		contentPane.add(lblCpf);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 111, 118, 14);
		contentPane.add(lblEndereo);
		
		tfNome = new JTextField();
		tfNome.setBounds(138, 8, 286, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tfDataNascimento = new JFormattedTextField(maskData);
		tfDataNascimento.setBounds(138, 58, 286, 20);
		contentPane.add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		MaskFormatter maskCpf = null;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tfCpf = new JFormattedTextField(maskCpf);
		tfCpf.setBounds(138, 83, 286, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(138, 108, 286, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		cbCurso = new JComboBox();
		cbCurso.setModel(new DefaultComboBoxModel(new String[] {"T\u00E9cnico em Inform\u00E1tica", "T\u00E9cnico em Inform\u00E1tica para Internet", "T\u00E9cnico em Automa\u00E7\u00E3o Industrial", "T\u00E9cnico em Jogos Digitais"}));
		cbCurso.setBounds(138, 33, 286, 20);
		contentPane.add(cbCurso);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				matricula.setCurso(lblCurso.getText());
				matricula.setEndereco(tfEndereco.getText());
				//matricula.setDataNascimento(tfDataNascimento.getText());
				matricula.setCpf(Integer.parseInt(lblCpf.getText()));
			
				
				try {
					controle.salvar(matricula);
					limpar();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
				
				
			}

			private void limpar() {
				// TODO Auto-generated method stub
				
			}
		});
		btnSalvar.setBounds(335, 139, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpar();
				
				
				
			}
		});
		btnLimpar.setBounds(236, 139, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(137, 139, 89, 23);
		contentPane.add(btnVoltar);
	}
	
	
public void limpar(){
		
	    tfEndereco.setText("");
	    tfDataNascimento.setText("");
		cbCurso.setToolTipText("");
		tfNome.setText("");
		tfCpf.setText("");
					
	}
	public void carregarMatricula(Matricula matricula){
		this.matricula = matricula;
		
		tfNome.setText(matricula.getCurso());
		tfEndereco.setText(matricula.getEndereco());
		//tfCpf.setText(matricula.getCpf());
		cbCurso.setToolTipText(matricula.getCurso());
		//tfDataNascimento.setText(matricula.getDataNascimento());
		
				
		
		
	}
	
	

}
