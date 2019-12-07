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
import model.Monografia;
import view.graphical_interface.popups.InsertMonografia;

public class MonografiasTab extends GenericTab {
	
	private JTable monTable;

	public MonografiasTab(JFrame frame, JTable monTable) {
		super(frame);
		this.monTable = monTable;
		// TODO Auto-generated constructor stub
	}
	
	public JTable configResultadosTable() {
		
		monTable.setModel(
				new DefaultTableModel(
				new Object[]{
						"id", 
						"titulo",
						"numero da monografia", 
						"tema",
						"nome da instituicao",
						"local da publicacao"
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(monTable.getModel());
		monTable.setRowSorter(sorter);

 		return monTable;
	}



	public void configBtnListarMonografias(JButton btnListarMonografias) {		// TODO Auto-generated method stub
		btnListarMonografias.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Monografia> monografias = API.listarMonografias();
			   DefaultTableModel model = (DefaultTableModel) monTable.getModel();
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
