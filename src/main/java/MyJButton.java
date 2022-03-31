import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJButton extends JButton implements MouseListener {
    private Color background = Color.BLUE;

    public MyJButton() {
        this.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(15,15); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        //Draws the rounded panel with borders.
        graphics.setColor(background);
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(background.brighter());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(background.brighter());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(background);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
