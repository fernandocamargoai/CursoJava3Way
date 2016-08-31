package threeway.projeto.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.enums.EnumTipoConta;
import threeway.projeto.modelo.util.UtilData;
import threeway.projeto.service.AgenciaService;
import threeway.projeto.service.ContaService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

public class DialogAbrirConta extends JDialog {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 9182533829425658821L;

	private ContaService service;

	private Cliente clienteSelecionado;

	private Conta conta;

	private JTextField tfDtAbertura;

	private JTextField tfSaldo;

	private JComboBox<EnumTipoConta> comboTipoConta;

	private JTextField tfNumero;

	private JButton btnCancelar;

	private JButton btnSalvar;

	private JLabel lblCamposObrigatrios;

	/**
	 * Método responsável por inicializar componentes da tela
	 * 
	 * @author Wilker Machado
	 * 
	 * @throws ParseException
	 */
	private void initialize() throws ParseException {

		setModal(true);
		this.setLocationRelativeTo(null);

		setTitle("Abertura de Conta");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(null);

		JLabel lblNumero = new JLabel("Numero *:");
		lblNumero.setBounds(10, 39, 80, 14);
		getContentPane().add(lblNumero);

		JLabel lblDataDeAbertura = new JLabel("Abertura:");
		lblDataDeAbertura.setBounds(10, 11, 80, 14);
		getContentPane().add(lblDataDeAbertura);

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setBounds(10, 67, 80, 14);
		getContentPane().add(lblSaldoInicial);

		JLabel lblTipoDeConta = new JLabel("Tipo de Conta *:");
		lblTipoDeConta.setBounds(10, 95, 80, 14);
		getContentPane().add(lblTipoDeConta);

		tfDtAbertura = new JTextField();
		tfDtAbertura.setEditable(false);
		tfDtAbertura.setBounds(110, 8, 164, 20);
		getContentPane().add(tfDtAbertura);
		tfDtAbertura.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(175, 166, 99, 35);
		getContentPane().add(btnCancelar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(55, 166, 99, 35);
		getContentPane().add(btnSalvar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 153, 264, 2);
		getContentPane().add(separator);

		comboTipoConta = new JComboBox<EnumTipoConta>();
		comboTipoConta.setBounds(110, 92, 164, 20);
		getContentPane().add(comboTipoConta);

		tfNumero = new JTextField();
		tfNumero.setBounds(110, 36, 75, 20);
		getContentPane().add(tfNumero);

		tfSaldo = new JTextField();
		tfSaldo.setBounds(110, 64, 75, 20);
		getContentPane().add(tfSaldo);
		tfSaldo.setColumns(10);

		lblCamposObrigatrios = new JLabel("(*) Campos Obrigatórios");
		lblCamposObrigatrios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCamposObrigatrios.setBounds(138, 120, 136, 24);
		getContentPane().add(lblCamposObrigatrios);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param service
	 * 
	 * @param cliente
	 * 
	 * @throws ParseException
	 */
	public DialogAbrirConta( ContaService service, Cliente cliente ) throws ParseException {

		this.service = service;

		this.clienteSelecionado = cliente;
		
		this.conta = new Conta();

		initialize();

		tfDtAbertura.setText(UtilData.formataData(new Date()));

		tfSaldo.setText("0");

		caregaComboTiposConta();

		acaoBotaoCancelar();

		acaoBotaoSalvar();
	}

	/**
	 * Método responsável por adicionar evento ao botão salvar
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void acaoBotaoSalvar() {

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					montaObjetoConta();

					service.salvar(conta);

					JOptionPane.showMessageDialog(null, "Abertura de conta realizada com sucesso!");

					OperacoesBanco.recuperaContaCliente();

					OperacoesBanco.mudaStatusContaCriada(Boolean.TRUE);

					OperacoesBanco.defineEnabledBotoes();

					setVisible(Boolean.FALSE);

				} catch (CamposObrigatoriosException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage());

				} catch (Exception ex1) {

					JOptionPane.showMessageDialog(null, "Algum campo pode ter sido preenchido inválido. Verifique e tente novamente!");
				}

			}

		});
	}

	/**
	 * Método responsável por adicionar evento ao botão cancelar
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
	 * Método responsável por carregar combo com o EnumTiposConta
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void caregaComboTiposConta() {

		for (EnumTipoConta tipoConta : EnumTipoConta.values()) {

			comboTipoConta.addItem(tipoConta);

		}

	}

	/**
	 * Método responsável por montar objeto conta de acordo com os dados que o usuario informar
	 * 
	 * @author Wilker Machado
	 * 
	 * @throws Exception
	 */
	public void montaObjetoConta() throws Exception {

		EnumTipoConta tipoConta = (EnumTipoConta) comboTipoConta.getSelectedItem();

		this.conta = new Conta(this.clienteSelecionado, Integer.parseInt(tfNumero.getText()), tipoConta);

		this.conta.setSaldo(Double.parseDouble(tfSaldo.getText()));
		
		this.conta.setAgencia(AgenciaService.agenciaSistema());

	}

}
