package aplicativo.swing.table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellAction extends DefaultCellEditor {

    private ModelAction data;

    public TableCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelAction) o;
        Action cell = new Action(data); 
        cell.setAlignmentX(Component.CENTER_ALIGNMENT);
        cell.setAlignmentY(Component.CENTER_ALIGNMENT);
        return cell;
    }

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
    
    public static class CenteredRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Aseguramos que el texto esté centrado horizontal y verticalmente
            if (comp instanceof DefaultTableCellRenderer) {
                ((DefaultTableCellRenderer) comp).setHorizontalAlignment(SwingConstants.CENTER);
                ((DefaultTableCellRenderer) comp).setVerticalAlignment(SwingConstants.CENTER);
            }
            
            return comp;
        }
    }
}
