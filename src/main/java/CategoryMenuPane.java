import javax.swing.*;
import java.awt.*;

public class CategoryMenuPane extends JPanel{
    private JButton btnBack;
    private JButton btnOenCuriosities;
    private JButton btnEdit;
    private JButton btnSave;
    private JPanel panel2;

    public CategoryMenuPane() {
        add(panel2);

        btnBack.setBorder(BorderFactory.createMatteBorder(3,3,3,3, btnBack.getBackground()));
        btnEdit.setBorder(BorderFactory.createMatteBorder(3,3,3,3, btnBack.getBackground()));
        btnSave.setBorder(BorderFactory.createMatteBorder(3,3,3,3, btnBack.getBackground()));
        btnOenCuriosities.setBorder(BorderFactory.createMatteBorder(3,3,3,3, btnBack.getBackground()));

        ImageIcon imgBack = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\backArrow.png");
        ImageIcon imgSave = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\save.png");
        ImageIcon imgEdit = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\edit.png");
        btnEdit.setIcon(resizeImage(imgEdit));
        btnBack.setIcon(resizeImage(imgBack));
        btnSave.setIcon(resizeImage(imgSave));


    }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
        // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }

    public JPanel getPanel2() { return panel2; }

    public JButton getBtnBack() { return btnBack; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnOenCuriosities() { return btnOenCuriosities; }
    public JButton getBtnSave() { return btnSave; }
}
