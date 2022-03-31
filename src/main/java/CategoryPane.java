import javax.swing.*;
import java.awt.*;

public class CategoryPane extends JPanel {
    private JPanel panel1;
    private JTextField tfTitle;
    private JTextArea textDescription;
    private JLabel lbID;
    private JLabel lbAuthor;
    private JLabel lbFollowers;
    private JLabel lbImage;

    public CategoryPane(String title, String description, ImageIcon imageIcon, String id, String followers) {

        tfTitle.setBorder(BorderFactory.createMatteBorder(3,3,3,3,panel1.getBackground()));
        tfTitle.setText(title);
        textDescription.setText(description);
        lbID.setText(id);
        lbAuthor.setText("Made by " + "Author@" + title);
        lbFollowers.setText(followers);
        lbImage.setIcon(resizeImage(imageIcon));


    }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
        // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }

    public JPanel getPanel1() {
        return panel1;
    }
    public JTextField getTfTitle() { return tfTitle; }
    public JTextArea getTextDescription() { return textDescription; }

    public void setEditable(Boolean value) {
        tfTitle.setEditable(value);
        tfTitle.setOpaque(value);
        textDescription.setEditable(value);
        textDescription.setOpaque(value);

    }
}
