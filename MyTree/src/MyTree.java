import java.util.Scanner;

// Αρχικά φτιάχνουμε την κλάση node, στην οποία δημιουργούμε την τιμή του κόμβου ώς value και
// τους δείκτες στα δεξιά και αριστερά παιδιά του κόμβου
class Node {
    int value; // Η τιμή του κόμβου
    Node left, right; // Οι δείκτες στα αριστερά και δεξιά παιδιά του κόμβου

    // Μετά δημιουργούμε τον κατασκευαστής που αρχικοποιεί την τιμή του κόμβου και ορίζει τα παιδιά ως null
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}
// Έπειτα η κλάση BinaryTree θα εμπεριέχει τη ρίζα του δέντρου, τη μέθοδο εισαγωγής τιμών,
// την αναδρομική μέθοδο εισαγωγής τιμών, όπως και την προδιατεταγμένη μορφή (preorder), την
// ενδοδιατεταγμένη μορφή (inorder) και τη μεταδιατεταγμένη (postorder).
class BinaryTree {
    Node root; // Η ρίζα του δέντρου

    // Μέθοδος για εισαγωγή τιμών στο δυαδικό δέντρο αναζήτησης
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Αναδρομική μέθοδος εισαγωγής τιμών
    private Node insertRecursive(Node current, int value) {
        // Αν ο τρέχων κόμβος είναι null, δημιουργούμε νέο κόμβο
        if (current == null) {
            return new Node(value); // Δημιουργεί νέο κόμβο αν ο τρέχων κόμβος είναι κενός
        }
        // Αν η τιμή είναι μικρότερη από την τιμή του τρέχοντος κόμβου,
        // εισάγεται στο αριστερό υποδέντρο
        if (value < current.value) {
            current.left = insertRecursive(current.left, value); // Εισαγωγή στο αριστερό υποδέντρο
        }
        // Αν η τιμή είναι μεγαλύτερη από την τιμή του τρέχοντος κόμβου,
        // εισάγεται στο δεξί υποδέντρο
        else if (value > current.value) {
            current.right = insertRecursive(current.right, value); // Εισαγωγή στο δεξί υποδέντρο
        }
        // Επιστρέφει τον τρέχοντα κόμβο (με τις αλλαγές)
        return current;
    }

    // Προδιάταξη (Preorder): Επισκέπτεται πρώτα τη ρίζα, μετά το αριστερό υποδέντρο, και τέλος το δεξί υποδέντρο
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " "); // Επισκέπτεται τη ρίζα
            preorder(node.left); // Αναδρομή στο αριστερό υποδέντρο
            preorder(node.right); // Αναδρομή στο δεξί υποδέντρο
        }
    }

    // Ενδοδιάταξη (Inorder): Επισκέπτεται πρώτα το αριστερό υποδέντρο, μετά τη ρίζα, και τέλος το δεξί υποδέντρο
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left); // Αναδρομή στο αριστερό υποδέντρο
            System.out.print(node.value + " "); // Επισκέπτεται τη ρίζα
            inorder(node.right); // Αναδρομή στο δεξί υποδέντρο
        }
    }

    // Μεταδιάταξη (Postorder): Επισκέπτεται πρώτα το αριστερό υποδέντρο, μετά το δεξί υποδέντρο, και τέλος τη ρίζα
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left); // Αναδρομή στο αριστερό υποδέντρο
            postorder(node.right); // Αναδρομή στο δεξί υποδέντρο
            System.out.print(node.value + " "); // Επισκέπτεται τη ρίζα
        }
    }
}

public class MyTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // Δημιουργούμε ένα νέο δυαδικό δέντρο
        Scanner keyb= new Scanner(System.in);

        // Οι αριθμοί που θα εισαχθούν στο δέντρο
        int[] values = {6, 4, 3, 5, 8, 7, 9};

        // Εισάγουμε κάθε τιμή στο δέντρο
        for (int value : values) {
            tree.insert(value);
        }

        int choice;
        do{     // Επιλογές εμφάνισης
            System.out.println("\n------------------------------------");
            System.out.println("-    Καλώς ήρθατε στο δυαδικό δέντρο      -");
            System.out.println("------------------------------------");
            System.out.println("1. Για Προδιάταξη (Preorder)");
            System.out.println("2. Για Ενδοδιάταξη (Inorder)");
            System.out.println("3. Για Μεταδιάταξη (Postorder)");
            System.out.println("4. Exit");
            System.out.println();
            choice=keyb.nextInt();
            switch(choice){    //  Μέθοδοι επιλογής
                case 1:
                    // Εμφάνιση της προδιάταξης (Preorder)
                    System.out.print("Προδιάταξη (Preorder): ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;
                case 2:
                    // Εμφάνιση της ενδοδιάταξης (Inorder)
                    System.out.print("Ενδοδιάταξη (Inorder): ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 3:
                    // Εμφάνιση της μεταδιάταξης (Postorder)
                    System.out.print("Μεταδιάταξη (Postorder): ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("(Wrong number)");   //Για αριθμό εκτός ορίου
                    break;
            }
        }while (choice!=4);     // Περιορισμός!

    }
}
