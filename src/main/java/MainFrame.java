import com.google.cloud.firestore.Firestore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

public class MainFrame extends JFrame {
    private JPanel panel1;
    private JPanel leftJPanel;
    public JPanel rightJPanel;
    private TestPanel1 testPanel1;
    private TestPanel2 testPanel2;


    public MainFrame(Firestore db) throws ExecutionException, InterruptedException {

        testPanel2 = new TestPanel2();
        testPanel2.btnOpenTestPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                goBack();
            }
        });

        testPanel1 = new TestPanel1(db);
        testPanel1.btnOpenTestPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switchPane((Category) testPanel1.list1.getSelectedValue());
            }
        });

        testPanel1.list1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                Category category = (Category)list.getSelectedValue();
                switchPane(category);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setResizable(false);
        rightJPanel.add(testPanel1.testpanel1);
        setContentPane(panel1);

    }
    public void switchPane(Category category) {
        testPanel2.titleLabel.setText(category.getTitle());

        rightJPanel.removeAll();
        rightJPanel.repaint();
        rightJPanel.revalidate();
        rightJPanel.add(testPanel2.testpanel2);
        rightJPanel.repaint();
        rightJPanel.revalidate();
    }

    public void goBack() {
        rightJPanel.removeAll();
        rightJPanel.repaint();
        rightJPanel.revalidate();
        rightJPanel.add(testPanel1.testpanel1);
        rightJPanel.repaint();
        rightJPanel.revalidate();
    }

}
