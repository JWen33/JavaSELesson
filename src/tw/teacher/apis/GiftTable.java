package tw.teacher.apis;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable {
	private GiftDB db;
	
	
	public GiftTable() { // 建構是直接建立出一個GiftModel，建立彼此關係，可以參考API中的HOW TO USE
		
		try { // 有連線才會繼續執行
			db = new GiftDB();
			db.query();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		GiftModel model = new GiftModel();
		model.setColumnIdentifiers(db.getFiledName());
		setModel(model);

	}
	
	public void delRow() {
		System.out.println(getSelectedRow());
		try {
			db.delData(getSelectedRow());
			repaint();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	private class GiftModel extends DefaultTableModel { // 不是抽象類別也沒有抽象方法，可以直接延伸使用

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}
		
		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData((String)aValue, row, column);;
		}
		

		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0; // 不為0才可以改寫，因為第0個是id，不應該可以修改
		}

		
	}
}
