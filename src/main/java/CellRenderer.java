import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CellRenderer implements ListCellRenderer<Category> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Category> list, Category value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setBorder(new EmptyBorder(50,50,50,50));
        JLabel labelTitle = new JLabel(value.getTitle());
        labelTitle.setFont(new Font("ARIAL", Font.BOLD, 10));
        labelTitle.setForeground(Color.BLUE);
        JLabel labelDesc = new JLabel();
        String id = value.getId().toString();
        labelDesc.setText(value.getDescription());
        JTextField idk = new JTextField(id);
        idk.setBackground(panel.getBackground());
        idk.setColumns(20);
        idk.setEditable(false);
        labelDesc.setForeground(Color.BLACK);
        panel.add(labelTitle, BorderLayout.NORTH);
        panel.add(idk, BorderLayout.SOUTH);
        panel.add(labelDesc, BorderLayout.CENTER);
        panel.setBackground(isSelected ? Color.GRAY : Color.WHITE);
        return panel;
    }



}
