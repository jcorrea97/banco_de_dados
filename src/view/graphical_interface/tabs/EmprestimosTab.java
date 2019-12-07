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
import model.Artigo;
import model.Editora;
import model.Emprestimo;
import view.graphical_interface.popups.FazEmprestimo;
import view.graphical_interface.popups.InsertEditora;
import view.graphical_interface.popups.InsertMonografia;

public class EmprestimosTab extends GenericTab {
	
	JTable table;
	
	public EmprestimosTab(JFrame frame, JTable table) {
		super(frame);
		this.table = table;
	}
	
	public JTable configResultadosTable() {
		
		table.setModel(
				new DefaultTableModel(
				new Object[]{
						"ID do emprestimo", 
						"ID da publicacao",
						"cpf/cnpj da pessoa",
						"data de emprestimo",
						"data de devolucao",
						},0
				));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

 		return table;
	}
	
	public void configBtnListarEmprestimos(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			   configResultadosTable();
			   List<Emprestimo> emps = API.listarEmprestimos();
			   DefaultTableModel model = (DefaultTableModel) table.getModel();
			   model.setRowCount(0);
			   
			   for(Emprestimo emp: emps) {
				 
				   model.addRow(new Object[]{
						   	emp.getId_emprestimo(),
						   	emp.getId_pub(),		            			
						   	emp.getCpf_cnpj_pessoa(),		            			
							new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(emp.getData_emprestimo().getTime())),
							new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(emp.getData_devolucao().getTime()))
						   }
				   );
				   
			   }
			   
			  }
			}
		);
	}
	
	public void configBtnFazerEmprestimo(JButton btn) {
		btn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  FazEmprestimo.executar();			   
			  }
			}
		);
	}

}
