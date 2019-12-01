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

import model.Artigo;
import model.Monografia;
import view.API;

public class ArtigosTab extends GenericTab {
	
	JTable artigosTable;
	
	public ArtigosTab(JFrame frame, JTable table) {
		super(frame);
		this.artigosTable = table;
	}
	
	
	public JTable configResultadosTable() {
		
		artigosTable.setModel(
				new DefaultTableModel(
				new Object[]{
						"id_artigo", 
						"titulo_artigo",
						"tema_artigo",
						"local_publicacao"
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(artigosTable.getModel());
		artigosTable.setRowSorter(sorter);

 		return artigosTable;
	}


	public void configBtnListarArtigos(JButton btnListarArtigos) {
		btnListarArtigos.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Artigo> artigos = API.listarArtigos();
			   DefaultTableModel model = (DefaultTableModel) artigosTable.getModel();
			   model.setRowCount(0);
			   
			   for(Artigo art: artigos) {
				 
				   model.addRow(new Object[]{
						   art.getId_pub(), 
						   art.getTitulo_publicacao(),
						   art.getTema_publicacao(),
						   art.getLocal_publicacao(),
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}

	public void configBtnInserirArtigo(JButton btnInserirArtigo) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
