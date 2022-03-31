import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestPanel1 {
    public JPanel testpanel1;
    public JButton btnOpenTestPanel2;
    public JList list1;
    private DefaultListModel<Category> dm;
    private JScrollPane jScroll;

    public TestPanel1(Firestore db) throws ExecutionException, InterruptedException {

                dm = new DefaultListModel<>();
                ArrayList<Category> categories = new ArrayList<>();
                CollectionReference doc =  db.collection("categories");
                ApiFuture<QuerySnapshot> future = doc.get();
                List<QueryDocumentSnapshot> documents = future.get().getDocuments();


                for (QueryDocumentSnapshot documentSnapshot : documents) {
                    String title = documentSnapshot.getString("title");
                    //String title = "TItOLOO421";
                    String id = documentSnapshot.getString("id");
                    //String id = "IDIasAasO21241";
                    String boh = "ID > ";
                    String desc = documentSnapshot.getString("description");
                    String imageUrl = documentSnapshot.getString("imageUrl");
                    java.util.List<String> list =(List<String>) documentSnapshot.get("tags");
                    assert title != null;
                    assert id != null;
                    Category newCat = new Category(title,desc,imageUrl,list,id);
                    categories.add(newCat);
                }
                for (Category cat : categories) {
                    System.out.println(cat.getId());
                    dm.addElement(cat);
                }


        list1.setModel(dm);
        list1.setBorder(new EmptyBorder(10,10,10,10));
        list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list1.setFixedCellHeight(250);
        list1.setFixedCellWidth(200);
        list1.setVisibleRowCount(-1);
        list1.setCellRenderer(new CellRenderer());
        list1.setOpaque(false);

        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScroll.setViewportView(list1);


    }

    public void removeAt(int i) {
        dm.remove(i);
    }

}
