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

import model.Monografia;
import model.Publicacao;
import view.API;
import view.graphical_interface.popups.InsertMonografia;

public class MonografiasTab extends GenericTab {

	public MonografiasTab(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}
	
	public static JTable configResultadosTable() {
		
		JTable table = new JTable(
			new DefaultTableModel(
			new Object[]{
					"id_monografia", 
					"titulo_publicacao",
					"numero_monog", 
					"tema_publicacao",
					"nome_instituicao",
					"local_publicacao"
					},0
			)
		);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}



	public void configBtnListarMonografias(JButton btnListarMonografias, JTable resultadosTable) {		// TODO Auto-generated method stub
		btnListarMonografias.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   List<Monografia> monografias = API.listarMonografias();
			   DefaultTableModel model = (DefaultTableModel) resultadosTable.getModel();
			   model.setRowCount(0);
			   
			   for(Monografia mon: monografias) {
				 
				   model.addRow(new Object[]{
						   mon.getId(), 
						   mon.getTitulo_publicacao(),
						   mon.getNumero_monog(), 
						   mon.getTema_publicacao(),
						   mon.getNome_instituicao(),
						   mon.getLocal_publicacao(),
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}

	public void configBtnInserirMonografia(JButton btnInserirMonografia) {
		
		btnInserirMonografia.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertMonografia.executar();			   
			  }
			}
		);
		
	}

}
