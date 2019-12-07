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
import view.graphical_interface.popups.InsertAutor;
import view.graphical_interface.popups.InsertEditora;
import view.graphical_interface.popups.InsertMonografia;

public class AutoresTab extends GenericTab {
	
	JTable table;
	
	public AutoresTab(JFrame frame, JTable table) {
		super(frame);
		this.table = table;
	}
	
	public JTable configResultadosTable() {
		
		table.setModel(
				new DefaultTableModel(
				new Object[]{
						"id", 
						"autor",
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	public void configBtnListarAutores(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Autor> autores = API.listarAutores();
			   DefaultTableModel model = (DefaultTableModel) table.getModel();
			   model.setRowCount(0);
			   
			   for(Autor aut: autores) {
				 
				   model.addRow(new Object[]{
						   aut.getId_autor(),
						   aut.getNome_autor()
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}
	
	public void configBtnInserirAutor(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertAutor.executar();			   
			  }
			}
		);		
	}

}
