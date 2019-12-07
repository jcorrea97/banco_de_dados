package view.graphical_interface.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.API;
import model.Artigo;
import model.Autor;
import model.Editora;
import model.Pessoa;
import view.graphical_interface.popups.InsertAutor;
import view.graphical_interface.popups.InsertEditora;
import view.graphical_interface.popups.InsertMonografia;
import view.graphical_interface.popups.InsertPessoa;

public class PessoasTab extends GenericTab {
	
	JTable table;
	
	public PessoasTab(JFrame frame, JTable table) {
		super(frame);
		this.table = table;
	}
	
	public JTable configResultadosTable() {
		
		table.setModel(
				new DefaultTableModel(
				new Object[]{
						"cpf/cnpj", 
						"nome",
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	public void configBtnListarPessoas(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Pessoa> pessoas = API.listarPessoas();
			   DefaultTableModel model = (DefaultTableModel) table.getModel();
			   model.setRowCount(0);
			   
			   for(Pessoa pes: pessoas) {
				   model.addRow(new Object[]{
						   pes.getCpf_cnpj_pessoa(),
						   pes.getNome_pessoa()
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}
	
	public void configBtnInserirPessoa(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertPessoa.executar();			   
			  }
			}
		);		
	}

}
