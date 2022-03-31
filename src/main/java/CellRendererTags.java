import javax.swing.*;
import java.awt.*;

public class CellRendererTags implements ListCellRenderer {
    private JLabel label;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        label = new JLabel();
        label.setText(value.toString());
        label.setFont(new Font("ARIAL",Font.BOLD,25));
        label.setOpaque(true);
        label.setBackground(isSelected ? Color.green : list.getBackground());

        return label;
    }
}
