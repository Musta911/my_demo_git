import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;

public class Prova extends JFrame{
    private JPanel menuPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JLabel lbNewCategory;
    private JPanel mainPanel;
    private JLabel lbHome;
    private JLabel lbStats;
    private JLabel lbSettings;
    private JList list1;
    private JScrollPane scrollPane;
    private JPanel containerPanel;
    private JButton btnNewCategory;
    private JButton btnSearch;
    private JButton btnFilter;
    private JTextField searchBar;
    private JPanel homeTopPanel;

    private CategoryPane categoryPane;

    ImageIcon img;

    private DefaultListModel<String> dm;
    private ArrayList<String> categorie;

    public Prova() {
        topPanel.setLayout(new CardLayout());
        centerPanel.setLayout(new CardLayout());

        img = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\test.jpg");
        ImageIcon icHome = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\home.png");
        ImageIcon icPlus = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\plus.png");
        ImageIcon icSettings = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\settings.png");
        ImageIcon icStats = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\stats.png");
        ImageIcon icSearch = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\search.png");
        ImageIcon icFilter = new ImageIcon("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\icons\\filter.png");

        btnNewCategory.setIcon(resizeImage(icPlus));
        btnFilter.setIcon(resizeImage(icFilter));
        btnSearch.setIcon(resizeImage(icSearch));
        lbHome.setIcon(resizeImage(icHome));
        lbNewCategory.setIcon(resizeImage(icPlus));
        lbSettings.setIcon(resizeImage(icSettings));
        lbStats.setIcon(resizeImage(icStats));

        btnFilter.setBorder(BorderFactory.createMatteBorder(2,2,2,2, btnFilter.getBackground()));
        btnNewCategory.setBorder(BorderFactory.createMatteBorder(2,2,2,2, btnFilter.getBackground()));
        btnSearch.setBorder(BorderFactory.createMatteBorder(2,2,2,2, btnFilter.getBackground()));

        categorie = new ArrayList<>();
        dm = new DefaultListModel<>();
        for (int i = 0; i <= 25; i++) {
            categorie.add("Categoria#" + i);
        }
        for (String s : categorie) {
            dm.addElement(s);
        }

        list1.setModel(dm);
        list1.setCellRenderer(new ProvaCellRenderer());
        list1.setBorder(new EmptyBorder(5,5,5,5));

        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(list1.getSelectedValue().toString());
                openCategoryPane();
                openCategoryMenuPane();
            }
        });





        getContentPane().add(mainPanel);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color color = btnNewCategory.getBackground();

        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                super.mouseEntered(e);
                JButton button = (JButton) e.getSource();
                button.setBackground(button.getBackground().brighter());
                System.out.println("MOUSE ENTERED");
            }

            @Override
            public void mouseExited(MouseEvent e) {

                super.mouseExited(e);
                JButton button = (JButton) e.getSource();
                button.setBackground(color);
                System.out.println("MOUSE EXITED");

            }
        };
        btnNewCategory.addMouseListener(listener);
        btnSearch.addMouseListener(listener);
        btnFilter.addMouseListener(listener);
    }

    private ImageIcon resizeImage(ImageIcon imgIcon) {
         // load the image to a imageIcon
        Image image = imgIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imgIcon = new ImageIcon(newimg);
        return imgIcon;// transform it back
    }

    private void filter() {
        String filter = searchBar.getText();
        for (String s : categorie) {
            if (!s.toLowerCase().contains(filter.toLowerCase())) {
                if (dm.contains(s)) {
                    dm.removeElement(s);
                }
            } else {
                if (!dm.contains(s)) {
                    dm.addElement(s);
                }
            }
        }
    }
    private void openCategoryMenuPane() {
        topPanel.removeAll();
        topPanel.repaint();
        topPanel.revalidate();
        CategoryMenuPane categoryMenuPane = new CategoryMenuPane();
        categoryMenuPane.getBtnBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
        categoryMenuPane.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryPane.setEditable(true);
            }
        });
        categoryMenuPane.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryPane.setEditable(false);
                JOptionPane.showMessageDialog(null,"Modifiche salvate con successo!");
            }
        });
        categoryMenuPane.getBtnOenCuriosities().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCuriositiesPane();
            }
        });
        topPanel.add(categoryMenuPane.getPanel2());
        topPanel.repaint();
        topPanel.revalidate();
    }

    private void goBack() {
        centerPanel.removeAll();
        centerPanel.repaint();
        centerPanel.revalidate();
        centerPanel.add(scrollPane);
        centerPanel.repaint();
        centerPanel.revalidate();
        topPanel.removeAll();
        topPanel.repaint();
        topPanel.revalidate();
        topPanel.add(homeTopPanel);
        topPanel.repaint();
        topPanel.revalidate();
    }

    private void openCuriositiesPane() {
        centerPanel.removeAll();
        centerPanel.repaint();
        centerPanel.revalidate();
        CuriositiesTagsPane curiositiesTagsPane = new CuriositiesTagsPane();
        centerPanel.add(curiositiesTagsPane.getPanel3());
        centerPanel.repaint();
        centerPanel.revalidate();
    }


    private void openCategoryPane() {
        centerPanel.removeAll();
        centerPanel.repaint();
        centerPanel.revalidate();
        String value = list1.getSelectedValue().toString();
        categoryPane = new CategoryPane(value, "Description della category " + value, img, "ID della cat " + value, "254K");
        centerPanel.add(categoryPane.getPanel1());
        centerPanel.repaint();
        centerPanel.revalidate();
    }
}