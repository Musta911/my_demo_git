import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProvaCellRenderer implements ListCellRenderer {
    private Font font;
    private JPanel jPanel;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        font = new Font("ARIAL", Font.BOLD, 20);
        jPanel = new JPanel();
        jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15); //Border corners arcs {width,height}, change this to whatever you want
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded panel with borders.
                graphics.setColor(isSelected ? Color.MAGENTA : Color.WHITE);
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        jPanel.setLayout(new BorderLayout());
        JLabel name;
        JLabel image;
        JLabel id;

        name = new JLabel();
        name.setText(value.toString());


        image = new JLabel();
        ImageIcon img = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\test.jpg");
        image.setIcon(resizeImage(img));
        id = new JLabel("O8RJO212E8was2");

        name.setFont(font);
        id.setFont(font);

        name.setPreferredSize(new Dimension(-1,50));
        id.setPreferredSize(new Dimension(-1,50));

        name.setVerticalAlignment(JLabel.BOTTOM);
        image.setVerticalAlignment(JLabel.CENTER);
        id.setVerticalAlignment(JLabel.TOP);

        name.setHorizontalAlignment(JLabel.CENTER);
        image.setHorizontalAlignment(JLabel.CENTER);
        id.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(name, BorderLayout.NORTH);
        jPanel.add(image, BorderLayout.CENTER);
        jPanel.add(id, BorderLayout.SOUTH);


        jPanel.setBorder(BorderFactory.createMatteBorder(5,5,5,5, list.getBackground()));

        jPanel.setPreferredSize(new Dimension(-1,-1));
        jPanel.setBackground(list.getBackground());

        return jPanel;
    }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
        // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }


}
