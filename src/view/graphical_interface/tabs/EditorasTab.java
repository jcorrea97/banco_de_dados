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
import model.Editora;
import view.graphical_interface.popups.InsertEditora;
import view.graphical_interface.popups.InsertMonografia;

public class EditorasTab extends GenericTab {
	
	JTable table;
	
	public EditorasTab(JFrame frame, JTable table) {
		super(frame);
		this.table = table;
	}
	
	public JTable configResultadosTable() {
		
		table.setModel(
				new DefaultTableModel(
				new Object[]{
						"id", 
						"editora",
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	public void configBtnListarEditoras(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Editora> editoras = API.listarEditoras();
			   DefaultTableModel model = (DefaultTableModel) table.getModel();
			   model.setRowCount(0);
			   
			   for(Editora edit: editoras) {
				 
				   model.addRow(new Object[]{
						   edit.getId_editora(),
						   edit.getEditora()
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}
	
	public void configBtnInserirEditora(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertEditora.executar();			   
			  }
			}
		);
	}

}
