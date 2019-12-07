package view.graphical_interface.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.API;
import model.Anais_conferencia;
import view.graphical_interface.popups.InsertAnal;

public class AnaisTab extends GenericTab {
	
	JTable anaisTable;

	public AnaisTab (JFrame frame, JTable table) { 
		super(frame);
		this.anaisTable = table;
	}
	
	public JTable configResultadosTable() {
		
		anaisTable.setModel(new DefaultTableModel(
			new Object[]{"id", "local da publicacao", "tipo da publicacao", "titulo", "tema", "volume", "numero", "data do anal"}, 0
		));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(anaisTable.getModel());
		anaisTable.setRowSorter(sorter);

 		return anaisTable;
	}

	public void configBtnListaAnais(JButton btnListarAnais) {
		btnListarAnais.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Anais_conferencia> anais = API.listarAnaisDeConferencia();
			   DefaultTableModel model = (DefaultTableModel) anaisTable.getModel();
			   model.setRowCount(0);
			   
			   for(Anais_conferencia anal : anais) {
				 
				   model.addRow(new Object[]{
						   // Atributos Publicacao
						   anal.getId_pub(), 
						   anal.getLocal_publicacao(), 
						   anal.getTipo_publicacao(),
						   anal.getTitulo_publicacao(),
						   anal.getTema_publicacao(),
						   
						   // Atributos Anais
						   anal.getVolume(),
						   anal.getNumero(),
						   new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(anal.getData().getTime()))
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}

	public void configBtnInserirAnal(JButton btnInserirAnal) {
		btnInserirAnal.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertAnal.executar();			   
			  }
			}
		);
	}
	
	
}
