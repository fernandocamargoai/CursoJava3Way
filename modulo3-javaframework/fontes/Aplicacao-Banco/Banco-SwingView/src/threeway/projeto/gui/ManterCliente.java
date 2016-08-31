package threeway.projeto.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.ClienteService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

public class ManterCliente extends JInternalFrame {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 3462729790298454529L;

	private ClienteService service;

	private JTextField tfNome;

	private JTextField tfEndereco;

	private JTextField tfRg;

	private JFormattedTextField ftfCpf;

	private JFormattedTextField ftfTelefone;

	private JTable tableClientes;

	private JButton btnSalvar;

	private JButton btnAtualizar;

	private JButton btnExcluir;

	private JButton btnLimpar;

	private JPanel panelLista;

	private Boolean clienteSelecionado = Boolean.FALSE;

	private Cliente cliente = new Cliente();

	/**
	 * Método responsável por inicializar componentes da tela
	 *
	 * @author Wilker Machado
	 *
	 * @throws ParseException
	 */
	private void initialize() throws ParseException {

		setClosable(true);
		setTitle("Manter Clientes");

		setBounds(100, 100, 750, 375);
		getContentPane().setLayout(null);

		JPanel panelCad = new JPanel();
		panelCad.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastrar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCad.setBounds(10, 11, 714, 142);
		getContentPane().add(panelCad);
		panelCad.setLayout(null);

		JLabel lblNome = new JLabel("Nome *:");
		lblNome.setBounds(10, 24, 91, 14);
		panelCad.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(444, 24, 62, 14);
		panelCad.add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(10, 52, 91, 14);
		panelCad.add(lblEndereo);

		JLabel lblRegistroGeral = new JLabel("Registro Geral:");
		lblRegistroGeral.setBounds(10, 80, 91, 14);
		panelCad.add(lblRegistroGeral);

		JLabel lblCpf = new JLabel("CPF *:");
		lblCpf.setBounds(400, 80, 34, 14);
		panelCad.add(lblCpf);

		tfNome = new JTextField();
		tfNome.setBounds(111, 21, 311, 20);
		panelCad.add(tfNome);
		tfNome.setColumns(10);

		ftfTelefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		ftfTelefone.setBounds(516, 21, 188, 20);
		panelCad.add(ftfTelefone);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(111, 49, 593, 20);
		panelCad.add(tfEndereco);
		tfEndereco.setColumns(10);

		tfRg = new JTextField();
		tfRg.setBounds(111, 77, 202, 20);
		panelCad.add(tfRg);
		tfRg.setColumns(10);

		ftfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		ftfCpf.setBounds(444, 77, 260, 20);
		panelCad.add(ftfCpf);
		ftfCpf.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(417, 108, 89, 23);
		panelCad.add(btnSalvar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(516, 108, 89, 23);
		panelCad.add(btnAtualizar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(615, 108, 89, 23);
		panelCad.add(btnExcluir);

		JLabel lblCamposObrigatrios = new JLabel("(*) Campos Obrigatórios");
		lblCamposObrigatrios.setBounds(10, 117, 174, 14);
		panelCad.add(lblCamposObrigatrios);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(318, 108, 89, 23);
		panelCad.add(btnLimpar);

		panelLista = new JPanel();
		panelLista.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes Cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLista.setBounds(10, 164, 714, 175);
		getContentPane().add(panelLista);
		panelLista.setLayout(null);

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param service
	 * 
	 * @throws ParseException
	 */
	public ManterCliente( ClienteService service ) throws ParseException {

		this.service = service;

		initialize();

		defineEnabledBotoes();

		iniciaJTable();

		atualizaDadosTabela();

		addEventoMouseListenerTabela();

		acaoBotaoSalvar();

		acaoBotaoLimpar();

		acaoBotaoExcluir();

		acaoBotaoAtualizar();
	}

	/**
	 * Método responsável por definir quando os botoes estarão habilitados
	 *
	 * @author Wilker Machado
	 *
	 */
	private void defineEnabledBotoes() {

		btnExcluir.setEnabled(clienteSelecionado);

		btnAtualizar.setEnabled(clienteSelecionado);

		btnSalvar.setEnabled(!clienteSelecionado);

		ftfCpf.setEditable(!clienteSelecionado);
		
		Inicial.modificaBotaoOperacoes(clienteSelecionado, cliente);

	}

	/**
	 * Método responsável por adicionar evento de click na tabela de clientes
	 *
	 * @author Wilker Machado
	 *
	 */
	private void addEventoMouseListenerTabela() {

		tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {

				int l = tableClientes.getSelectedRow();
				
				String cpf = (String) tableClientes.getValueAt(l, 4);
				
				cliente = service.buscarClientePorCPF(cpf);

				carregarValores(cliente);

			}

		});

	}

	/**
	 * Método responsável por carregar os valores de cliente
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 */
	public void carregarValores(Cliente cliente) {

		ftfCpf.setText(cliente.getCpf());

		ftfTelefone.setText(cliente.getTelefone());

		tfEndereco.setText(cliente.getEndereco());

		tfNome.setText(cliente.getNome());

		tfRg.setText(cliente.getRg());

		this.clienteSelecionado = Boolean.TRUE;

		defineEnabledBotoes();

	}

	/**
	 * Método responsável por inicializar componente JTable
	 *
	 * @author Wilker Machado
	 *
	 */
	private void iniciaJTable() {

		tableClientes = new JTable();

		tableClientes.setModel(new DefaultTableModel(new Object[][] {}, retornaNomeColunas()));

		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableClientes.setBounds(703, 24, -690, 140);

		tableClientes.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tableClientes);

		scrollPane.setViewportView(tableClientes);

		scrollPane.setBounds(10, 24, 694, 140);

		panelLista.add(scrollPane);

	}

	/**
	 * Método responsável por atualizar dados da JTable
	 *
	 * @author Wilker Machado
	 *
	 */
	private void atualizaDadosTabela() {
		
		tableClientes.setModel(new DefaultTableModel(new Object[][] {}, retornaNomeColunas()));

		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableModel dtm = (DefaultTableModel) tableClientes.getModel();
		
		Cliente cli = new Cliente();

		ArrayList<Cliente> listaCliente = service.listarTodosClientes();

		Collections.sort(listaCliente);

		Iterator<Cliente> it = listaCliente.iterator();

		while (it.hasNext()) {

			cli = it.next();

			dtm.addRow(new Object[] { cli.getNome(), cli.getEndereco(), cli.getTelefone(), cli.getRg(), cli.getCpf() });

		}

	}

	/**
	 * Método responsável por retornaqr o nome das colunas da tabela clientes
	 *
	 * @author Wilker Machado
	 *
	 * @return String[]
	 */
	private String[] retornaNomeColunas() {

		String[] columnNames = new String[5];

		columnNames[0] = ( "Nome" );

		columnNames[1] = ( "Endereço" );

		columnNames[2] = ( "Telefone" );

		columnNames[3] = ( "RG" );

		columnNames[4] = ( "CPF" );

		return columnNames;
	}

	/**
	 * Método responsável por adicionar ação ao botão limpar
	 *
	 * @author Wilker Machado
	 *
	 */
	private void acaoBotaoLimpar() {

		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				limpar();

				clienteSelecionado = Boolean.FALSE;

				defineEnabledBotoes();

			}
		});
	}

	/**
	 * Método responsável por adicionar ação ao botão salvar
	 *
	 * @author Wilker Machado
	 *
	 */
	private void acaoBotaoSalvar() {

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					preencheClienteComCampos();

					service.salvar(cliente);

					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");

					limpar();

				} catch (CamposObrigatoriosException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage());

				} finally {

					atualizaDadosTabela();
				}

			}

		});

	}

	/**
	 * Método responsável por adicionar ação ao botão excluir
	 *
	 * @author Wilker Machado
	 *
	 */
	private void acaoBotaoExcluir() {

		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				service.excluir(cliente);

				limpar();

				clienteSelecionado = Boolean.FALSE;

				defineEnabledBotoes();

				atualizaDadosTabela();

				JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
			}
		});
	}
	
	/**
	 * Método responsável por adicionar ação ao botão atualizar
	 *
	 * @author Wilker Machado
	 *
	 */
	private void acaoBotaoAtualizar() {

		btnAtualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					preencheClienteComCampos();

					service.atualizar(cliente);

					limpar();

					clienteSelecionado = Boolean.FALSE;

					defineEnabledBotoes();

					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");

				} catch (CamposObrigatoriosException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage());

				} finally {

					atualizaDadosTabela();
				}

			}
		});
	}

	/**
	 * Método responsável por recuperar dados do JTextField e setar em cliente
	 *
	 * @author Wilker Machado
	 *
	 */
	public void preencheClienteComCampos() {

		cliente.setNome(tfNome.getText());

		cliente.setEndereco(tfEndereco.getText());

		cliente.setCpf(ftfCpf.getText());

		cliente.setRg(tfRg.getText());

		cliente.setTelefone(ftfTelefone.getText());

	}

	/**
	 * Método responsável por limpar campos JTextField
	 *
	 * @author Wilker Machado
	 *
	 */
	public void limpar() {

		ftfCpf.setText("");

		ftfTelefone.setText("");

		tfEndereco.setText("");

		tfNome.setText("");

		tfRg.setText("");

		cliente = new Cliente();

	}
}
