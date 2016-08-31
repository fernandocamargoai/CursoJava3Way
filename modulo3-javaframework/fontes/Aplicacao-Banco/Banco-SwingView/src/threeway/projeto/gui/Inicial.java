package threeway.projeto.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.AgenciaService;
import threeway.projeto.service.ClienteService;
import threeway.projeto.service.ContaService;

public class Inicial {

	private ClienteService clienteService = new ClienteService();

	private ContaService contaService = new ContaService();

	private JFrame frmGereciamentoDeBanco;

	private JDesktopPane panelInterno;

	private JInternalFrame frameInterno;

	private JLabel lblBancoResult;

	private JLabel lblAgenciaResult;

	private JButton btnManterClientes;

	private static JButton btnOperaesBancarias;

	private static Cliente clienteSelecionado;

	/**
	 * Método responsável por iniciar a aplicação
	 * 
	 * @author Wilker Machado
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Inicial window = new Inicial();

					window.frmGereciamentoDeBanco.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Método responsável por inicializar todos os componentes swing deste frame
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void initialize() {

		frmGereciamentoDeBanco = new JFrame();
		frmGereciamentoDeBanco.setResizable(false);
		frmGereciamentoDeBanco.setTitle("Sistema de Gereciamento de Banco");
		frmGereciamentoDeBanco.setBounds(100, 100, 800, 600);
		frmGereciamentoDeBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGereciamentoDeBanco.getContentPane().setLayout(null);
		frmGereciamentoDeBanco.setLocationRelativeTo(null);

		JLabel lblBanco = new JLabel("Banco:");
		lblBanco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBanco.setBounds(10, 11, 74, 23);
		frmGereciamentoDeBanco.getContentPane().add(lblBanco);

		JLabel lblAgencia = new JLabel("Agência:");
		lblAgencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgencia.setBounds(10, 45, 74, 23);
		frmGereciamentoDeBanco.getContentPane().add(lblAgencia);

		btnManterClientes = new JButton("Manter Clientes");
		btnManterClientes.setBounds(10, 89, 170, 37);
		frmGereciamentoDeBanco.getContentPane().add(btnManterClientes);

		btnOperaesBancarias = new JButton("Operações Bancarias");
		btnOperaesBancarias.setBounds(190, 89, 170, 37);
		btnOperaesBancarias.setEnabled(Boolean.FALSE);
		frmGereciamentoDeBanco.getContentPane().add(btnOperaesBancarias);

		lblBancoResult = new JLabel("...");
		lblBancoResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBancoResult.setBounds(94, 11, 480, 20);
		frmGereciamentoDeBanco.getContentPane().add(lblBancoResult);

		lblAgenciaResult = new JLabel("...");
		lblAgenciaResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgenciaResult.setBounds(94, 45, 480, 20);
		frmGereciamentoDeBanco.getContentPane().add(lblAgenciaResult);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 764, 11);
		frmGereciamentoDeBanco.getContentPane().add(separator);

		panelInterno = new JDesktopPane();
		panelInterno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelInterno.setBounds(10, 137, 764, 414);
		frmGereciamentoDeBanco.getContentPane().add(panelInterno);
		panelInterno.setLayout(null);

		frameInterno = new JInternalFrame("New JInternalFrame");
		frameInterno.setBounds(10, 11, 744, 392);
		panelInterno.add(frameInterno);
		frameInterno.setVisible(false);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Inicial() {

		initialize();

		lblAgenciaResult.setText(AgenciaService.agenciaSistema().getNome());

		lblBancoResult.setText(AgenciaService.agenciaSistema().getBanco().getNome());

		eventoDosBotoes();
	}

	/**
	 * Método responsável por adicionar evento aos botões
	 *
	 * @author Wilker Machado
	 *
	 */
	public void eventoDosBotoes() {

		btnOperaesBancarias.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mostraTelaOperacoesBancarias();
			}
		});

		btnManterClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mostraTelaManterClientes();
			}
		});
	}

	/**
	 * Método responsável por instanciar e mostrar a tela de Manter Clientes
	 *
	 * @author Wilker Machado
	 *
	 */
	public void mostraTelaManterClientes() {

		try {

			JInternalFrame newFrame = new ManterCliente(clienteService);

			newFrame.setBounds(frameInterno.getBounds());

			panelInterno.add(newFrame);

			newFrame.show();

		} catch (ParseException e1) {

			e1.printStackTrace();

		}
	}

	/**
	 * Método responsável por instanciar e mostrar a tela de Operações Bancarias
	 *
	 * @author Wilker Machado
	 *
	 */
	public void mostraTelaOperacoesBancarias() {

		JInternalFrame newFrame = new OperacoesBanco(this.contaService, clienteSelecionado);

		newFrame.setBounds(frameInterno.getBounds());

		panelInterno.add(newFrame);

		newFrame.show();

	}

	/**
	 * Método responsável por habilitar o botão de operações bancarias e setar cliente selecionado
	 *
	 * @author Wilker Machado
	 *
	 * @param flag
	 * 
	 * @param cliente
	 */
	public static void modificaBotaoOperacoes(Boolean flag, Cliente cliente) {

		btnOperaesBancarias.setEnabled(flag);

		clienteSelecionado = cliente;
	}
}
