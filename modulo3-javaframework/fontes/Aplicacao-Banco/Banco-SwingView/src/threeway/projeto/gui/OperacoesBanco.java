package threeway.projeto.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.Transacao;
import threeway.projeto.modelo.enums.EnumTipoTransacao;
import threeway.projeto.modelo.util.UtilData;
import threeway.projeto.service.ContaService;
import threeway.projeto.service.TransacaoService;
import threeway.projeto.service.excecoes.SaldoInsuficienteException;

public class OperacoesBanco extends JInternalFrame {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 4708970015459501227L;

	private static Cliente clienteSelecionado;

	private static ContaService contaService;

	private static TransacaoService transacaoService;

	private static Conta contaCliente;

	private static JPanel panelDadosConta;

	private static JTextField tfNumeroConta;

	private static JTextField tfDtAbertura;

	private static JTextField tfSaldo;

	private static JButton btnAbrirConta;

	private static JButton btnSaque;

	private static JButton btnDeposito;

	private static JButton btnTransferencia;

	private static Boolean contaCriada = Boolean.FALSE;

	private DialogAbrirConta dialogAbrirConta;

	private DialogTransferencia dialogTransferencia;

	private static JTable tableTransacoes;

	private JPanel panelTransacoes;

	/**
	 * Método responsável por inicializar componentes da tela
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void initialize() {

		setClosable(true);
		setBounds(100, 100, 750, 375);

		setTitle("Operações Bancarias");
		getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(13, 25, 46, 23);
		getContentPane().add(lblCliente);

		JLabel lblNomeCliente = new JLabel(clienteSelecionado.getNome());
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeCliente.setBounds(69, 25, 155, 23);
		getContentPane().add(lblNomeCliente);

		panelDadosConta = new JPanel();
		panelDadosConta.setBorder(new TitledBorder(null, "Dados da Conta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosConta.setBounds(234, 11, 490, 53);
		getContentPane().add(panelDadosConta);
		panelDadosConta.setLayout(null);

		JLabel lblNumero = new JLabel("Nº :");
		lblNumero.setBounds(10, 20, 25, 14);
		panelDadosConta.add(lblNumero);

		tfNumeroConta = new JTextField();
		tfNumeroConta.setEditable(false);
		tfNumeroConta.setBounds(45, 17, 42, 20);
		panelDadosConta.add(tfNumeroConta);
		tfNumeroConta.setColumns(10);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(361, 20, 36, 14);
		panelDadosConta.add(lblSaldo);

		JLabel lblDataDeAbertura = new JLabel("Data de Abertura:");
		lblDataDeAbertura.setBounds(110, 20, 101, 14);
		panelDadosConta.add(lblDataDeAbertura);

		tfDtAbertura = new JTextField();
		tfDtAbertura.setEditable(false);
		tfDtAbertura.setBounds(221, 17, 125, 20);
		panelDadosConta.add(tfDtAbertura);
		tfDtAbertura.setColumns(10);

		tfSaldo = new JTextField();
		tfSaldo.setEditable(false);
		tfSaldo.setBounds(394, 17, 86, 20);
		panelDadosConta.add(tfSaldo);
		tfSaldo.setColumns(10);

		btnAbrirConta = new JButton("Abrir Conta");
		btnAbrirConta.setBounds(293, 80, 101, 37);
		getContentPane().add(btnAbrirConta);

		btnSaque = new JButton("Saque");
		btnSaque.setBounds(504, 80, 90, 37);
		getContentPane().add(btnSaque);

		btnDeposito = new JButton("Deposito");
		btnDeposito.setBounds(404, 80, 90, 37);
		getContentPane().add(btnDeposito);

		btnTransferencia = new JButton("Transferência");
		btnTransferencia.setBounds(604, 81, 120, 36);
		getContentPane().add(btnTransferencia);

		JSeparator separator = new JSeparator();
		separator.setBounds(13, 70, 711, 10);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(13, 128, 711, 10);
		getContentPane().add(separator_1);

		panelTransacoes = new JPanel();
		panelTransacoes.setBorder(new TitledBorder(null, "Historico de Transa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTransacoes.setBounds(13, 149, 711, 186);
		getContentPane().add(panelTransacoes);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param serviceConta
	 * 
	 * @param cliente
	 */
	public OperacoesBanco( ContaService serviceConta, Cliente cliente ) {

		clienteSelecionado = cliente;

		contaService = serviceConta;

		transacaoService = new TransacaoService();

		initialize();

		verificaExistenciaDeContaParaCliente();

		iniciaJTable();

		atualizaDadosTabela();

		acaoBotaoAbrirConta();

		acaoBotaoDeposito();

		acaoBotaoSaque();

		acaoBotaoTransferencia();

	}

	/**
	 * Método responsável por verificar se ja existe conta para o cliente selecionado
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void verificaExistenciaDeContaParaCliente() {

		Conta conta = contaService.buscaContaPorCliente(clienteSelecionado);

		if (conta != null) {

			mudaStatusContaCriada(Boolean.TRUE);

			contaCliente = conta;

		} else {

			mudaStatusContaCriada(Boolean.FALSE);

		}

		defineEnabledBotoes();

		preenchePanelDescricaoConta();

	}

	/**
	 * Método responsável por adicionar evento ao botão de transferencia, este que chamara o DialogTransferencia[JDialog]
	 * 
	 * @author Wilker Machado
	 * 
	 */
	@SuppressWarnings("deprecation")
	private void acaoBotaoTransferencia() {

		btnTransferencia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dialogTransferencia = new DialogTransferencia(contaService, contaCliente);

				dialogTransferencia.setLocationRelativeTo(null);

				dialogTransferencia.show();

			}
		});

	}

	/**
	 * Método responsável por adicionar evento ao botão de saque, este que chamará um JOptionPane para informar o valor do saque
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void acaoBotaoSaque() {

		btnSaque.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para saque. (formato x00.00)", "Saque em conta bancária", JOptionPane.QUESTION_MESSAGE));

					contaService.sacar(contaCliente, valorDeposito);

					JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");

					preenchePanelDescricaoConta();

				} catch (SaldoInsuficienteException ex1) {

					JOptionPane.showMessageDialog(null, ex1.getMessage());

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Algum campo pode ter sido preenchido inválido. Verifique e tente novamente!");

				} finally {

					atualizaDadosTabela();
				}
			}
		});
	}

	/**
	 * Método responsável por adicionar evento ao botão deposito, este que chamará um JOptionPane para informar o valor do deposito
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void acaoBotaoDeposito() {

		btnDeposito.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor para deposito. (formato x00.00)", "Depósito em conta bancária", JOptionPane.QUESTION_MESSAGE));

					contaService.depositar(contaCliente, valorDeposito);

					JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");

					preenchePanelDescricaoConta();

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Algum campo pode ter sido preenchido inválido. Verifique e tente novamente!");

				} finally {

					atualizaDadosTabela();
				}
			}
		});
	}

	/**
	 * Método responsável por adicionar evento ao botão de abrir conta, este que chamara o DialogAbrirConta[JDialog]
	 * 
	 * @author Wilker Machado
	 * 
	 */
	@SuppressWarnings("deprecation")
	private void acaoBotaoAbrirConta() {

		btnAbrirConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					dialogAbrirConta = new DialogAbrirConta(contaService, clienteSelecionado);

					dialogAbrirConta.setLocationRelativeTo(null);

					dialogAbrirConta.show();

				} catch (ParseException e1) {

					e1.printStackTrace();

				}
			}

		});
	}

	/**
	 * Método responsável por inicializar JTable
	 * 
	 * @author Wilker Machado
	 * 
	 */
	private void iniciaJTable() {

		tableTransacoes = new JTable();

		tableTransacoes.setModel(new DefaultTableModel(new Object[][] {}, retornaNomeColunas()));

		tableTransacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableTransacoes.setBounds(703, 24, -690, 140);

		tableTransacoes.getTableHeader().setReorderingAllowed(false);

		panelTransacoes.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(tableTransacoes);

		scrollPane.setViewportView(tableTransacoes);

		scrollPane.setBounds(10, 21, 691, 154);

		panelTransacoes.add(scrollPane);

	}

	/**
	 * Método responsável por retornar nome das colunas da JTable
	 * 
	 * @author Wilker Machado
	 * 
	 * @return String[]
	 */
	private static String[] retornaNomeColunas() {

		String[] columnNames = new String[5];

		columnNames[0] = ( "Tipo Transação" );

		columnNames[1] = ( "Titular/Conta Crédito" );

		columnNames[2] = ( "Titular/Conta Debito" );

		columnNames[3] = ( "Data" );

		columnNames[4] = ( "Valor" );

		return columnNames;
	}

	/**
	 * Método responsável por Atualizar dados da tabela de transaões sempre que alguma transação e feita esse metodo e chamado
	 * 
	 * @author Wilker Machado
	 * 
	 */
	public static void atualizaDadosTabela() {

		tableTransacoes.setModel(new DefaultTableModel(new Object[][] {}, retornaNomeColunas()));

		tableTransacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableModel dtm = (DefaultTableModel) tableTransacoes.getModel();

		ArrayList<Transacao> listaTransacoes = new ArrayList<Transacao>();

		if (contaCliente != null) {

			listaTransacoes = new ArrayList<Transacao>(transacaoService.listarTransacoesPorConta(contaCliente.getIdentificador()));
		}

		Collections.sort(listaTransacoes);

		Iterator<Transacao> it = listaTransacoes.iterator();

		while (it.hasNext()) {

			Transacao tr = it.next();

			if (tr.getTipoTransacao() == EnumTipoTransacao.TRANSFERENCIA) {

				dtm.addRow(new Object[] { tr.getTipoTransacao(), tr.getContaCredito().getTitular().getNome() + "/" + tr.getContaCredito().getNumero(),

				tr.getContaDebito().getTitular().getNome() + "/" + tr.getContaDebito().getNumero(), UtilData.DDMMAAAAHHMM(tr.getData()), String.format("%15.15s", tr.getValor()) });

			} else {

				dtm.addRow(new Object[] { tr.getTipoTransacao(), tr.getContaCredito().getTitular().getNome() + "/" + tr.getContaCredito().getNumero(),

				"--", UtilData.DDMMAAAAHHMM(tr.getData()), String.format("%15.15s", tr.getValor()) });

			}
		}

	}

	/**
	 * Método responsável por definir se os botões abaixo definidos estarão habilitados ou não
	 * 
	 * @author Wilker Machado
	 * 
	 */
	public static void defineEnabledBotoes() {

		btnAbrirConta.setEnabled(!contaCriada);

		btnSaque.setEnabled(contaCriada);

		btnDeposito.setEnabled(contaCriada);

		btnTransferencia.setEnabled(contaCriada);

		panelDadosConta.setVisible(contaCriada);

	}

	/**
	 * Método responsável por mudar flag de contaCriada de acordo com a função executada no sistema
	 * 
	 * @author Wilker Machado
	 * 
	 * @param flag
	 */
	public static void mudaStatusContaCriada(Boolean flag) {

		contaCriada = flag;
	}

	/**
	 * Método responsável por recuperar conta de um determinado cliente selecionado
	 * 
	 * @author Wilker Machado
	 * 
	 */
	public static void recuperaContaCliente() {

		contaCliente = contaService.buscaContaPorCliente(clienteSelecionado);

		preenchePanelDescricaoConta();

	}

	/**
	 * Método responsável por preencher JTextField com os dados do cliente selecionado
	 * 
	 * @author Wilker Machado
	 * 
	 */
	public static void preenchePanelDescricaoConta() {

		if (contaCliente != null) {

			tfDtAbertura.setText(UtilData.formataData(contaCliente.getDataAbertura()));

			tfNumeroConta.setText(contaCliente.getNumero().toString());

			tfSaldo.setText(contaCliente.getSaldo().toString());
		}
	}
}
