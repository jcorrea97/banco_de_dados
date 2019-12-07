package view.graphical_interface.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.API;
import model.Publicacao;
import view.graphical_interface.popups.InsertMonografia;
import view.graphical_interface.popups.LinkAutorPublicacao;

public class PublicacoesTab extends GenericTab{
	
	JTable pubTable;
	
	public PublicacoesTab(JFrame frame, JTable pubTable) {
		super(frame);
		this.pubTable = pubTable;
	}
	
	public JTable configResultadosTable() {
			
		pubTable.setModel(new DefaultTableModel(
			new Object[]{"id", "local da publicacao", "tipo da publicacao", "titulo", "tema"}, 0
		));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(pubTable.getModel());
		pubTable.setRowSorter(sorter);

 		return pubTable;
	}
	
	
	
	public JTable configResultadosTable(Object[] rows) {
		
		pubTable.setModel(new DefaultTableModel(
			rows, 0
			));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(pubTable.getModel());
		pubTable.setRowSorter(sorter);

 		return pubTable;
	}
	
	
	

	public void configBtnListarPublicacoes(JButton btnListarPublicacoes) {
		btnListarPublicacoes.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Publicacao> publicacoes = API.listarPublicacoes();
			   DefaultTableModel model = (DefaultTableModel) pubTable.getModel();
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

	public void configBtnListarPublicacoesAutor(JButton btnListarPublicacoesAutores) {
		btnListarPublicacoesAutores.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable(new Object[]{"id_pub", "local_pub", "tipo_publicacao", "titulo_publicacao", "tema_publicacao", "nome_autor", "id_autor"});
			   List<Publicacao> publicacoes = API.listarPublicacoesAutores();
			   DefaultTableModel model = (DefaultTableModel) pubTable.getModel();
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
	
	public void configBtnListarPublicacoesEmprestadas(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   ResultSet rs = API.listarPubsEmprestadas();
			   List<Object> cols = setCols(rs);
			  
				 
			   DefaultTableModel model = (DefaultTableModel) pubTable.getModel();
			   model.setRowCount(0);
			   		   
			  	
				  try {
					while(rs.next()) {
						  List<Object> row = new ArrayList<Object>();
						  for(Object col : cols) {
							  row.add(rs.getObject(col.toString()));
						  }
						  model.addRow(row.toArray());
						  
					  }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				  
			   
			   
			  }

			private List<Object> setCols(ResultSet rs) {
				try {
					   ResultSetMetaData rsmd = rs.getMetaData();
					   int columnCount = rsmd.getColumnCount();
					   List<Object> rows = new ArrayList<Object>();
					   // The column count starts from 1
					   for (int i = 1; i <= columnCount; i++ ) {
					     String row = rsmd.getColumnName(i);
					     rows.add(row);
					     // Do stuff with name
					   } 
					  configResultadosTable(rows.toArray());
					  return rows;
				   } catch (Exception ex) {
					   ex.printStackTrace();
					   throw new RuntimeException(ex);
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
				  LinkAutorPublicacao.executar();			   
			  }
			}
		);
	}

}
