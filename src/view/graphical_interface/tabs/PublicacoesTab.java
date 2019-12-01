package view.graphical_interface.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Publicacao;
import view.API;
import view.graphical_interface.popups.InsertMonografia;

public class PublicacoesTab extends GenericTab{
	
	public PublicacoesTab(JFrame frame) {
		super(frame);
	}
	
	public static JTable configResultadosTable() {
			
		JTable table = new JTable(
			new DefaultTableModel(
			new Object[]{"id_pub", "local_pub", "tipo_publicacao", "titulo_publicacao", "tema_publicacao"}, 0
			)
		);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	
	
	public static JTable configResultadosTable(Object[] rows) {
		
		JTable table = new JTable(
			new DefaultTableModel(
			rows, 0
			)
		);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	

	public void configBtnListarPublicacoes(JButton btnListarPublicacoes, JTable resultados_table) {
		btnListarPublicacoes.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   List<Publicacao> publicacoes = API.listarPublicacoes();
			   DefaultTableModel model = (DefaultTableModel) resultados_table.getModel();
			   model.setRowCount(0);
			   
			   for(Publicacao pub : publicacoes) {
				 
				   model.addRow(new Object[]{
						   pub.getId_pub(), 
						   pub.getLocal_publicacao(), 
						   pub.getTipo_publicacao(),
						   pub.getTema_publicacao(),
						   pub.getTitulo_publicacao()
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}

	public void configBtnListarPublicacoesAutor(JButton btnListarPublicacoesAutores, JTable resultados_table) {
		btnListarPublicacoesAutores.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				configResultadosTable(new Object[]{"id_pub", "local_pub", "tipo_publicacao", "titulo_publicacao", "tema_publicacao", "nome_autor", "id_autor"});
			   List<Publicacao> publicacoes = API.listarPublicacoesAutores();
			   DefaultTableModel model = (DefaultTableModel) resultados_table.getModel();
			   model.setRowCount(0);
			   
			   for(Publicacao pub : publicacoes) {
				 
				   model.addRow(new Object[]{
						   pub.getId_pub(), 
						   pub.getLocal_publicacao(), 
						   pub.getTipo_publicacao(),
						   pub.getTema_publicacao(),
						   pub.getTitulo_publicacao(),
						   pub.getNome_autor(),
						   pub.getId_autor()
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}
	
	public void configBtnInserirPublicacao(JButton btnListarPublicacoes) {
		btnListarPublicacoes.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  InsertMonografia.executar();			   
			  }
			}
		);
	}

}
