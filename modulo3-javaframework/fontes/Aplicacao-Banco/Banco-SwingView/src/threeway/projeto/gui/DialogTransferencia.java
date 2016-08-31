package threeway.projeto.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.util.UtilData;
import threeway.projeto.service.ContaService;
import threeway.projeto.service.excecoes.ContaNaoExisteException;
import threeway.projeto.service.excecoes.SaldoInsuficienteException;

public class DialogTransferencia extends JDialog {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -3779467378111612965L;

	private ContaService service;

	private Conta contaCliente;

	private JPanel panelDadosConta;

	private JTextField tfNumeroConta;

	private JTextField tfDtAbertura;

	private JTextField tfSaldo;

	private JTextField tfTitularConta;

	private JTextField tfNContaDestino;

	private JTextField tfValorTranferencia;

	private JButton btnCancelar;

	private JButton btnRealizarTransfercia;

	private JLabel lblCamposObrigatrios;

	/**
	 * Método responsável por inicializar componentes da tela
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void initialize() {

		setModal(true);
		this.setLocationRelativeTo(null);

		setTitle("Transferência entre contas");
		getContentPane().setLayout(null);

		setBounds(100, 100, 520, 270);

		panelDadosConta = new JPanel();
		panelDadosConta.setBorder(new TitledBorder(null, "Dados da Conta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosConta.setBounds(10, 11, 484, 77);
		getContentPane().add(panelDadosConta);
		panelDadosConta.setLayout(null);

		JLabel lblNumero = new JLabel("Nº :");
		lblNumero.setBounds(10, 20, 25, 14);
		panelDadosConta.add(lblNumero);

		tfNumeroConta = new JTextField();
		tfNumeroConta.setEditable(false);
		tfNumeroConta.setBounds(34, 17, 42, 20);
		panelDadosConta.add(tfNumeroConta);
		tfNumeroConta.setColumns(10);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(343, 20, 36, 14);
		panelDadosConta.add(lblSaldo);

		JLabel lblDataDeAbertura = new JLabel("Data de Abertura:");
		lblDataDeAbertura.setBounds(97, 20, 101, 14);
		panelDadosConta.add(lblDataDeAbertura);

		tfDtAbertura = new JTextField();
		tfDtAbertura.setEditable(false);
		tfDtAbertura.setBounds(208, 17, 125, 20);
		panelDadosConta.add(tfDtAbertura);
		tfDtAbertura.setColumns(10);

		tfSaldo = new JTextField();
		tfSaldo.setEditable(false);
		tfSaldo.setBounds(388, 17, 86, 20);
		panelDadosConta.add(tfSaldo);
		tfSaldo.setColumns(10);

		JLabel lblTitularDaConta = new JLabel("Titular da Conta:");
		lblTitularDaConta.setBounds(10, 48, 101, 14);
		panelDadosConta.add(lblTitularDaConta);

		tfTitularConta = new JTextField();
		tfTitularConta.setEditable(false);
		tfTitularConta.setBounds(121, 45, 353, 20);
		panelDadosConta.add(tfTitularConta);
		tfTitularConta.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados para Transfer\u00EAncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 99, 484, 77);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNContaDestino = new JLabel("N° Conta Destino *:");
		lblNContaDestino.setBounds(10, 24, 140, 14);
		panel.add(lblNContaDestino);

		JLabel lblValorDaTransferencia = new JLabel("Valor da Transferência *:");
		lblValorDaTransferencia.setBounds(10, 49, 149, 14);
		panel.add(lblValorDaTransferencia);

		tfNContaDestino = new JTextField();
		tfNContaDestino.setBounds(160, 21, 86, 20);
		panel.add(tfNContaDestino);
		tfNContaDestino.setColumns(10);

		tfValorTranferencia = new JTextField();
		tfValorTranferencia.setBounds(160, 46, 86, 20);
		panel.add(tfValorTranferencia);
		tfValorTranferencia.setColumns(10);

		lblCamposObrigatrios = new JLabel("(*) Campos Obrigatórios");
		lblCamposObrigatrios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObrigatrios.setBounds(315, 49, 159, 14);
		panel.add(lblCamposObrigatrios);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(343, 187, 151, 33);
		getContentPane().add(btnCancelar);

		btnRealizarTransfercia = new JButton("Realizar Transferêcia");
		btnRealizarTransfercia.setBounds(172, 187, 161, 33);
		getContentPane().add(btnRealizarTransfercia);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param contaService
	 * 
	 * @param contaCliente
	 */
	public DialogTransferencia( ContaService contaService, Conta contaCliente ) {

		this.service = contaService;

		this.contaCliente = contaCliente;

		initialize();

		preenchePanelDescricaoConta();

		acaoBotaoCancelar();

		acaoBotaoRealizarTransferencia();

	}

	/**
	 * Método responsável por adicionar evento ao botão de realizar transferencia
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void acaoBotaoRealizarTransferencia() {

		btnRealizarTransfercia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					int numeroConta = Integer.parseInt(tfNContaDestino.getText());

					Conta contaDestino = service.buscaContaPorNumero(numeroConta);

					double valorTransferemcia = Double.parseDouble(tfValorTranferencia.getText());

					service.transferir(contaCliente, valorTransferemcia, contaDestino);

					OperacoesBanco.atualizaDadosTabela();

					OperacoesBanco.preenchePanelDescricaoConta();

					JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");

					setVisible(Boolean.FALSE);

				} catch (ContaNaoExisteException exConta) {

					JOptionPane.showMessageDialog(null, exConta.getMessage());

				} catch (SaldoInsuficienteException ex1) {

					JOptionPane.showMessageDialog(null, ex1.getMessage());

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Algum campo pode não ter sido preenchido ou preenchido inválido. Verifique e tente novamente!");
				}

			}
		});
	}

	/**
	 * Método responsável por adicionar evento ao botão de cancelar
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void acaoBotaoCancelar() {

		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setVisible(Boolean.FALSE);
			}
		});

	}

	/**
	 * Método responsável por preencher JPanel com as informações da contaCliente
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void preenchePanelDescricaoConta() {

		if (contaCliente != null) {

			tfDtAbertura.setText(UtilData.formataData(contaCliente.getDataAbertura()));

			tfNumeroConta.setText(contaCliente.getNumero().toString());

			tfSaldo.setText(contaCliente.getSaldo().toString());

			tfTitularConta.setText(contaCliente.getTitular().getNome());
		}
	}
}
