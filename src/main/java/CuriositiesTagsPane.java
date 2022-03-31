import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.util.ArrayList;

public class CuriositiesTagsPane extends JPanel {
    private JPanel panel3;
    private JButton btnAddTag;
    private JButton btnAddCuriosity;
    private JList listTags;
    private JList listCuriosities;
    private JTextField textField1;
    private JTextField textField2;
    private JTable table1;
    private DefaultListModel<String> tags;
    private DefaultListModel<String> curiosities;

    public CuriositiesTagsPane() {

        add(panel3);

        ImageIcon imgAdd = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\plus.png");
        ImageIcon resizedImg = resizeImage(imgAdd);
        /*btnAddCuriosity.setIcon(resizedImg);
        btnAddCuriosity.setBorder(new EmptyBorder(2,2,2,2));
        btnAddTag.setIcon(resizedImg);
        btnAddTag.setBorder(new EmptyBorder(2,2,2,2));
         */

        listTags.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(e.getFirstIndex());
            }
        });

        tags = new DefaultListModel<>();
        for (int i = 0; i <= 20; i++) {
            tags.addElement("#tag" + i);
        }
        listTags.setModel(tags);
        listTags.setCellRenderer(new CellRendererTags());

        curiosities = new DefaultListModel<>();
        for (int i = 0; i<=20;i++) {
            curiosities.addElement("Questo è il testo delle curiosità#" + i + ".Bella a tutti raga lo sapevate che l'Italia si trova in europa?</br>" +
                    "Se lo sapevi buon per te altrimenti sei messo male...");
        }

        listCuriosities.setModel(curiosities);
        listCuriosities.setCellRenderer(new CellRendererCurs());
        listCuriosities.setFixedCellWidth(listCuriosities.getWidth());
        listCuriosities.setFixedCellHeight(160);

        //fillLists(20);
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        Object [] boh = {"das","r21jro1i2","iufbakdad","9daosidja","fhaiudfahk"};
        model.addColumn("idk", boh);
        model.isCellEditable(-1,0);
        table1.setModel(model);
        table1.setRowHeight(170);
        table1.getColumnModel().getColumn(0).setCellRenderer(new TableRenderer());
    }

    public JPanel getPanel3() { return panel3; }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
        // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }

    private void fillLists(int n) {
        tags = new DefaultListModel<>();
        for (int i = 0; i <= n-1; i++) {
            tags.addElement("#tag" + i);
        }
        listTags.setModel(tags);
        listTags.setCellRenderer(new CellRendererTags());

    }

}
