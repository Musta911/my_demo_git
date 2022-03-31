import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellRendererCurs implements ListCellRenderer {
    private JPanel jPanel;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        jPanel = new JPanel();
        jPanel.setEnabled(true);
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
                graphics.setColor(isSelected ? Color.MAGENTA : Color.YELLOW);
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };

        ImageIcon img = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\test.jpg");

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        jPanel.setLayout(layout);


        JTextArea text = new JTextArea(value.toString());
        text.setPreferredSize(new Dimension(500,150));
        text.setBackground(Color.green);

        JLabel image = new JLabel();
        image.setIcon(resizeImage(img));

        JButton options = new JButton("OPTIONS");
        JPopupMenu menu = new JPopupMenu();
        menu.add("EDIT");
        menu.add("DELETE");
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                menu.setVisible(true);
            }
        });

        jPanel.add(text);
        jPanel.add(image);
        jPanel.add(options);

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
