import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;


import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main (String [] args) throws IOException, ExecutionException, InterruptedException, FirebaseAuthException {

        /* HOW TO INSERT DATA
        HashMap<String , String> quote = new HashMap();
        quote.put("name", "GARRIX");
        ApiFuture<WriteResult> future = db.collection("sample").document("prova").set(quote);
        System.out.println("Updated at " + future.get().getUpdateTime());

           HOW TO READ DATA
        DocumentReference docRef = db.collection("users").document("8unK2KrDAGgvOL27bcBdEnS7Yiq1");
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            User user = document.toObject(User.class);
            assert user != null;
            System.out.println(user.getUsername());
            System.out.println(user.getEmail());
            System.out.println(user.getId());
        } else {
            System.out.println("no such document!");
        }


        System.out.println("PRIMO METODO" + auth.getUser("8unK2KrDAGgvOL27bcBdEnS7Yiq1").getEmail());
        ApiFuture<UserRecord> future = auth.getUserAsync("zopnTKYkN8S0fYZ84BGGmp8aty72");
        UserRecord user = future.get();
        System.out.println("SECONDO METODO ->" + user.getEmail());

         */



        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\musta\\IdeaProjects\\LearnConnectFirebase\\src\\main\\resources\\key.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        Firestore db = FirestoreClient.getFirestore();

        DocumentReference doc = db.collection("CATEGORIES").document("Science");
        ApiFuture<DocumentSnapshot> future = doc.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            String s1 = (String) document.get("First name");
            String s2 = (String) document.get("Last name");
            System.out.println("First name > " + s1);
            System.out.println("Last name > " + s2);
        } else {
            System.out.println("No such document :(");
        }
        //MainFrame mainFrame = new MainFrame(db);
        //mainFrame.setVisible(true);

        //Prova prova = new Prova();
        //prova.setVisible(true);

        /*for (Category cat : categories) {
            System.out.println("ID > " + cat.getId() + " TITLE > " + cat.getTitle() + " TAGS > " + cat.getTags().toString());
        }

         */


        /* ADDDING CATEGORIES
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tags.add("tag"+i);
        }
        for (int i = 1; i<=10; i++) {
            String id = db.collection("categories").document().getId();
            Category category = new Category("Categoria" + 1, "Descrizione categoria" + i, "urlImmagine categoria" + i, tags, id);
            ApiFuture<WriteResult> future = db.collection("categories").document(id).set(category);
            System.out.println("Updated at " + future.get().getUpdateTime());
        }
         */

        /* FOLLOW CATEGORY
        HashMap<String,Object> map = new HashMap<>();
        map.put("id", "6NDQE9wIkzCsg5jx2p60");
        map.put("tags", new ArrayList<String>());
        ApiFuture<WriteResult> future = db.collection("users").document("zopnTKYkN8S0fYZ84BGGmp8aty72").collection("followedCategories")
                                        .document("6NDQE9wIkzCsg5jx2p60").set(map);
        System.out.println("Updated at " + future.get().getUpdateTime());
         */


        /* GET RANDOM CAT
        CollectionReference doc =  db.collection("users").document("zopnTKYkN8S0fYZ84BGGmp8aty72").collection("followedCategories");
        ApiFuture<QuerySnapshot> future = doc.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        System.out.println(documents);
        Random random = new Random();
        int j = random.nextInt(documents.size());
        QueryDocumentSnapshot randomCat = documents.get(j);
        DocumentReference categ = db.collection("categories").document(randomCat.get("id").toString());

         */

        /* ADDING CURIOSITIES
        Random random = new Random();
        ArrayList<Curiosity> curiosities = new ArrayList<>();
        for (int i = 1; i <=5; i++) {
            String id = db.collection("categories").document().getId();
            Curiosity curiosity = new Curiosity("testo curiosita " + i, null, "tag" + random.nextInt(10), id );
            curiosities.add(curiosity);
        }
        for (Curiosity c : curiosities) {
            ApiFuture<WriteResult> future = db.collection("categories").document("4g2TzZStI2uJQtEOwHEB").collection("curiosities").document(c.getId()).set(c);
            System.out.println(future.get().getUpdateTime());
        }

         */



        /*


        //1) MI PESCA UNA CATEGORIA A CASO TRA QUELLE SEGUITE DALL'UTENTE CON ID = id
        String id = "zopnTKYkN8S0fYZ84BGGmp8aty72";
        CollectionReference doc =  db.collection("users").document(id).collection("followedCategories");
        ApiFuture<QuerySnapshot> future = doc.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        System.out.println(documents);
        Random random = new Random();
        int j = random.nextInt(documents.size());
        QueryDocumentSnapshot randomCat = documents.get(j);
        System.out.println("Categoria pescata -> " + randomCat.get("id").toString());

        //2) MI PESCA UN TAG A CASO TRA I TAG SCELTI DALL'UTENTE PER LA CATEGORIA SOPRA
        ArrayList<String> hisTags = (ArrayList<String>) randomCat.get("tags");
        String newTag = hisTags.get(random.nextInt(hisTags.size()));
        System.out.println("Tag pescato ->" + newTag);

        //3) MI TROVA LA CATEGORIA DEL PUNTO 1 NELLA COLLECTION CATEGORIES
        DocumentReference categ = db.collection("categories").document(randomCat.get("id").toString());
        ApiFuture<DocumentSnapshot> snapshot = categ.get();
        DocumentSnapshot boh = snapshot.get();
        System.out.println("Nome categoria pescata ->" + boh.getData());

        //4) MI PESCA TUTTE LE CURIOSITA CON TAG = AL TAG DEL PUNTO 2
        ApiFuture<QuerySnapshot> idk = db.collection("categories").document(boh.get("id").toString()).collection("curiosities").whereEqualTo("tag", newTag.toString()).get();
        List<QueryDocumentSnapshot> fut = idk.get().getDocuments();

        //5) MI PESCA UNA CURIOSITA A CASO TRA QUELLE DEL PUNTO 4
        QueryDocumentSnapshot qds = fut.get(random.nextInt(fut.size()));
        System.out.println("Curiosità pescata -> " + qds.getData());


         */
























    }

}
