import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableRenderer implements TableCellRenderer {
    private JPanel panel;
    private final Font font = new Font("ARIAL",Font.BOLD,25);
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        panel = new JPanel();

        ImageIcon img = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\test.jpg");

        panel.setBackground(isSelected ? Color.green : Color.CYAN);
        panel.setOpaque(true);
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        panel.setLayout(layout);
        JTextArea text = new JTextArea(value.toString());

        panel.add(text);
        JLabel image = new JLabel();
        image.setIcon(resizeImage(img));
        panel.add(image);
        JButton btn = new JButton("PRESS HERE");
        btn.setEnabled(true);
        panel.add(btn);

        return panel;
    }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
        // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }

}
