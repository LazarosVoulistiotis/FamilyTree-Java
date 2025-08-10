// =========================================================================================================================
// Ο κύριος σκοπός αυτού του προγράμματος είναι να βρεθεί η οικογενειακή σχέση μεταξύ δύο ανθρώπων.
// Το πρόγραμμα διαβάζει δεδομένα από ένα αρχείο csv και τα αποθηκεύει σε μια λίστα αντικειμένων Tree.
// Στη συνέχεια, το πρόγραμμα ζητά από το χρήστη να εισάγει τα ονόματα δύο ατόμων και ελέγχει αν τα ονόματα είναι έγκυρα.
// Αν τα ονόματα είναι έγκυρα, το πρόγραμμα βρίσκει την οικογενειακή σχέση μεταξύ των δύο ατόμων και την εμφανίζει.
// Αν τα ονόματα είναι άκυρα, το πρόγραμμα εμφανίζει ένα μήνυμα σφάλματος και ζητά από το χρήστη να εισάγει ξανά τα ονόματα.
// =========================================================================================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Αυτή η κλάση δημιουργεί ένα αντικείμενο Person με ένα όνομα και ένα φύλο.
//Έχει επίσης getter μεθόδους για πρόσβαση στο όνομα και το φύλο.
import classes.Person;

// Αυτή η κλάση δημιουργεί ένα αντικείμενο Tree με όνομα, σχέση και μια λίστα από αντικείμενα Person.
// Περιλαμβάνει μεθόδους setter για τον καθορισμό του ονόματος και της σχέσης, καθώς και μια μέθοδο
// για την προσθήκη αντικειμένων Person στη λίστα.
// Επίσης, διαθέτει μεθόδους getter για την πρόσβαση στο όνομα, τη σχέση και τη λίστα των αντικειμένων Person.
import classes.Tree;

public class FamilyTree {

    static String inputName1;
    static String inputName2;

    static String filePath = "input.csv";

    public static void main(String[] args) {
        menu();
    }

    // Αυτός ο κώδικας δημιουργεί ένα μενού που επιτρέπει στο χρήστη να επιλέξει από διάφορες επιλογές.
    // Οι επιλογές περιλαμβάνουν την εύρεση της οικογενειακής σχέσης μεταξύ δύο ατόμων,
    // την ταξινόμηση των ατόμων με λεξικογραφική σειρά και την εγγραφή σε ένα αρχείο, την εκκαθάριση της
    // οθόνη της κονσόλας, και έξοδος από το πρόγραμμα. Ο κώδικας χρησιμοποιεί ένα βρόχο while και μία
    // δήλωση if-else για να ελέγχει την επιλογή του χρήστη και να εκτελεί την αντίστοιχη
    // ενέργεια. Ο χρήστης μπορεί να επιλέξει μια επιλογή πληκτρολογώντας έναν αριθμό μεταξύ 1-3 ή με
    // πληκτρολογώντας 'exit'. Εάν ο χρήστης εισάγει μια μη έγκυρη επιλογή, ο κώδικας θα εμφανίσει ένα
    // μήνυμα σφάλματος. Ο βρόχος θα συνεχιστεί μέχρι ο χρήστης να επιλέξει την έξοδο από το
    // πρόγραμμα.
    public static void menu() {
        boolean menu = false;
        while (!menu) {
            System.out.println("\n----------------------------------------");
            System.out.println("-    Καλώς ήρθατε στο κύριο μενού      -");
            System.out.println("----------------------------------------\n");
            System.out.println("Επιλογές: \n");
            System.out.println("1. Εμφάνιση όλων των ατόμων από το αρχείο.");
            System.out.println("2. Βρείτε την οικογενειακή σχέση μεταξύ δύο ατόμων.");
            System.out.println("3. Για να σταματήσετε το πρόγραμμα.");
            System.out.print("\nΔιαλέξτε μια επιλογή: ");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();



            if (choice.equals("1")) {
                displayPeople();
            } else if (choice.equals("2")) {
                System.out.println("\nΑυτή η επιλογή σας επιτρέπει να βρείτε την οικογενειακή σχέση μεταξύ δύο ατόμων.");
                System.out .println("Παρακαλούμε εισάγετε τα ονόματα των δύο ατόμων που θέλετε να βρείτε τη σχέση μεταξύ τους.");
                System.out.print("Εισάγετε το πρώτο όνομα: ");
                inputName1 = input.nextLine().trim();
                System.out.print("Εισάγετε το δεύτερο όνομα: ");
                inputName2 = input.nextLine().trim();
                while (inputName1.equals("") || inputName2.equals("")) {
                    System.out.println("Μη έγκυρη εισαγωγή. Παρακαλώ εισάγετε τα ονόματα ξανά.");
                    System.out.print("Εισάγετε το πρώτο όνομα: ");
                    inputName1 = input.nextLine().trim();
                    System.out.print("Εισάγετε το δεύτερο όνομα: ");
                    inputName2 = input.nextLine().trim();
                }
                readData();
            } else if (choice.equals("3")) {
                System.out.println("\nΣας ευχαριστώ που χρησιμοποιήσατε τον οίκο των δέντρων!!\n");
                System.exit(0); // With System.exit we exit the programm.
                menu = true;
            }
            else {
                System.out.println("Μή έγκυρη επιλογή");
            }
        }
    }

    // Αυτός ο κώδικας δημιουργεί μια μέθοδο που επιτρέπει στο χρήστη να αποφασίσει αν θέλει
    // να συνεχίσει να χρησιμοποιεί το πρόγραμμα ή να το εγκαταλείψει. Η μέθοδος ζητάει από το χρήστη με μια
    // ερώτηση που τον ρωτά αν θέλει να συνεχίσει (Y/N). Η επιλογή του χρήστη καταγράφεται
    // από έναν σαρωτή και αποθηκεύεται στη μεταβλητή «choice». Ο κώδικας στη συνέχεια χρησιμοποιεί ένα
    // if-else για να ελέγξει την επιλογή του χρήστη. Εάν ο χρήστης επιλέξει «Y»,
    // η μέθοδος main καλείται ξανά, επιτρέποντας στο χρήστη να συνεχίσει να χρησιμοποιεί το πρόγραμμα.
    // Αν ο χρήστης επιλέξει 'N', το πρόγραμμα εξέρχεται και εμφανίζει ένα μήνυμα «Αντίο!».
    // Εάν ο χρήστης εισάγει μια μη έγκυρη επιλογή, εμφανίζεται ένα μήνυμα σφάλματος και
    // καλείται ξανά η μέθοδος.
    public static void wantContinue() {
        System.out.print("\n~> Θέλετε να συνεχίσετε? (Y/N): ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        if (choice.toLowerCase().equals("y")) {
            main(null); // call main method
        } else if (choice.toLowerCase().equals("n")) {
            System.out.println("\nΣας ευχαριστώ που χρησιμοπιοήσατε τον οίκο των δέντρων!!\n");
            System.exit(0); // exit program
        } else {
            System.out.println("Μη έγκυρη επιλογή. Προσπαθήστε ξανά."); // print error message
            wantContinue(); // call method again
        }
    }

    // Ο κώδικας διαβάζει το περιεχόμενο ενός αρχείου CSV και το αποθηκεύει σε μια μεταβλητή String.
    // Χρησιμοποιεί ένα μπλοκ try-catch για τον χειρισμό τυχόν σφαλμάτων που μπορεί να προκύψουν
    // κατά την ανάγνωση του αρχείου. Επίσης, παραλείπει τις κενές γραμμές. Εάν δεν υπάρχει σφάλμα, ο κώδικας
    // επιστρέφει το περιεχόμενο του αρχείου ως αλφαριθμητικό. Εάν παρουσιαστεί σφάλμα, ο κώδικας
    // εκτυπώνει ένα μήνυμα σφάλματος και επιστρέφει null.
    private static String csvFile() {
        String fileName = filePath; // αυτό είναι το όνομα του αρχείου που θα διαβαστεί
        String fileContent = ""; // αυτή είναι η μεταβλητή που θα αποθηκεύει το περιεχόμενο του αρχείου
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; // αυτή είναι η μεταβλητή που θα αποθηκεύει την τρέχουσα γραμμή
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                fileContent += line + "\n";
            }
            return fileContent;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    // Αυτός ο κώδικας διαβάζει και επεξεργάζεται το περιεχόμενο ενός αρχείου CSV, δημιουργεί ένα Map και μία
    // λίστα για την αποθήκευση των δεδομένων και καλεί τη μέθοδο «findRelation» για την εύρεση της σχέσης
    // μεταξύ δύο ονομάτων που καθορίζονται από τον χρήστη. Εάν βρεθεί μια σχέση
    // θα εμφανιστεί, διαφορετικά θα εμφανιστεί η ένδειξη «no relation». Καλεί τη μέθοδο
    // «wantContinue» για να ρωτήσει τον χρήστη αν θέλει να συνεχίσει να χρησιμοποιεί το πρόγραμμα. Εάν
    // προκύψει σφάλμα, θα εκτυπώσει το σφάλμα.
    public static void readData() {
        csvFile();
        String csvFile = "input.csv";
        String line = "";
        String csvSplitBy = ",";
        Map<String, List<Tree>> relationMap = new HashMap<>();
        List<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] parts = line.split(csvSplitBy);
                if (parts.length == 2) {
                    Person person = new Person(parts[0].toLowerCase().trim(), parts[1].toLowerCase().trim());
                    personList.add(person);
                } else if (parts.length == 3) {
                    Tree tree = new Tree();
                    tree.setName(parts[0].trim());
                    tree.setRelation(parts[1].trim());
                    tree.addPerson(new Person(parts[2].toLowerCase().trim(), null));
                    if (relationMap.containsKey(parts[0].toLowerCase().trim())) relationMap.get(parts[0].toLowerCase().trim()).add(tree);
                    else {
                        List<Tree> trees = new ArrayList<>();
                        trees.add(tree);
                        relationMap.put(parts[0].toLowerCase().trim(), trees);
                    }
                }
            }

            String relation = findRelation(inputName1.toLowerCase(), inputName2.toLowerCase(), relationMap, personList);
            if (relation != null) {
                if (relation == "PERSON_NOT_FOUND") System.out.println(inputName1 + " or " + inputName2 + " not found in the database.");
                else if (relation == "SAME_PERSON") System.out.println("Ίδιο Πρόσωπο.");
                else System.out.println("Η σχέση μεταξύ " + inputName1 + " και " + inputName2 + " ειναι " + relation);
            } else System.out.println("Δεν βρέθηκε καμία σχέση.");

            wantContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Αυτή η μέθοδος διαβάζει το περιεχόμενο ενός αρχείου CSV και εμφανίζει
    // στην κονσόλα τα ονόματα και τα φύλα των ατόμων που περιέχονται στο αρχείο.
    // Λειτουργία:
    // 1. Διαβάζει το αρχείο χρησιμοποιώντας τη μέθοδο csvFile().
    // 2. Διαχωρίζει τις γραμμές με βάση το σύμβολο κόμμα (",") και επεξεργάζεται
    //    μόνο γραμμές που περιέχουν δύο πεδία (όνομα και φύλο).
    // 3. Εμφανίζει τα δεδομένα στην κονσόλα, αγνοώντας γραμμές που περιέχουν
    //    πληροφορίες σχέσεων ή δεν είναι έγκυρες.
    // Χρήση:
    // - Η μέθοδος είναι χρήσιμη για την προβολή των βασικών στοιχείων (όνομα και φύλο)
    //   των ατόμων που περιέχονται στο γενεαλογικό δέντρο.
    // - Επιτρέπει την επαλήθευση της σωστής ανάγνωσης του αρχείου.
    public static void displayPeople() {
        // Διαβάζει το περιεχόμενο του CSV αρχείου
        String fileContent = csvFile();
        if (fileContent == null || fileContent.isEmpty()) {
            System.out.println("Το αρχείο είναι κενό ή δεν μπόρεσε να διαβαστεί.");
            return;
        }

        // Διαχωρίζει τις γραμμές του αρχείου
        String[] lines = fileContent.split("\n");
        System.out.println("\n--- Ονόματα και Φύλα από το αρχείο ---\n");

        // Επεξεργάζεται κάθε γραμμή και εμφανίζει όνομα και φύλο
        for (String line : lines) {
            String[] parts = line.split(", "); // Χωρισμός δεδομένων με βάση το κόμμα
            if (parts.length == 2) {
                // Εμφάνιση μόνο για γραμμές με δύο στοιχεία (όνομα, φύλο)
                String name = parts[0].trim();
                String gender = parts[1].trim();
                System.out.println("Όνομα: " + name + ", Φύλο: " + gender);
            }
        }
    }


    // Οι ιδιωτικές στατικές κλάσεις ελέγχουν τις συγγενικές σχέσεις μεταξύ των ατόμων
    // χρησιμοποιώντας δομές δεδομένων, όπως χάρτες και λίστες, και μεθόδους όπως looping και
    // σύγκριση ονομάτων για τον προσδιορισμό σχέσεων όπως πατέρας-γιός, μητέρα-κόρη,
    // παππούδες - εγγόνια, κ.λπ. Βοηθούν στην παρακολούθηση και κατανόηση των οικογενειακών
    // σχέσεων.
    private static String findFather(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        String father = null;
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    if (tree.getRelation().equals("father")) {
                        for (Person person2 : tree.getPersons()) {
                            if (person2.getName().equals(name)) father = person.getName();
                        }
                    }
                }
            }
        }
        return father;
    }

    private static String findMother(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        String mother = null;
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    if (tree.getRelation().equals("mother")) {
                        for (Person person2 : tree.getPersons()) {
                            if (person2.getName().equals(name))  mother = person.getName();
                        }
                    }
                }
            }
        }
        return mother;
    }

    private static String getGender(List<Person> personList, String name) {
        for (Person person : personList) {
            if (person.getName().equals(name))  return person.getGender();
        }
        return null;
    }

    private static String isFather(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                if (tree.getRelation().equals("father")) {
                    for (Person person : tree.getPersons()) {
                        if (person.getName().equals(name2)) return "Πατέρας";
                    }
                }
            }
        }
        return null;
    }

    private static String isMother(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                if (tree.getRelation().equals("mother")) {
                    for (Person person : tree.getPersons()) {
                        if (person.getName().equals(name2)) return "Μητέρα";
                    }
                }
            }
        }
        return null;
    }

    private static String isChild(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = isFather(relationMap, personList, name2, name1);
        String motherOfName1 = isMother(relationMap, personList, name2, name1);
        String gender = getGender(personList, name1);

        if (fatherOfName1 != null || motherOfName1 != null) return gender.equals("male") ? "Γιος" : "Κόρη";

        return null;
    }

    private static String isSibling(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (fatherOfName1 != null && fatherOfName2 != null) {
            if (fatherOfName1.equals(fatherOfName2)) {
                String genderOfName1 = getGender(personList, name1);
                return genderOfName1.equals("male") ? "Αδερφός" : "Αδερφή";
            }
        }

        if (motherOfName1 != null && motherOfName2 != null) {
            if (motherOfName1.equals(motherOfName2)) {
                String genderOfName1 = getGender(personList, name1);
                return genderOfName1.equals("male") ? "Αδερφός" : "Αδερφή";
            }
        }

        return null;
    }

    private static String isCousin(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (isSibling(relationMap, personList, fatherOfName1, fatherOfName2) != null || isSibling(relationMap, personList, motherOfName1, motherOfName2) != null) return "Ξαδέρφια";
        return null;
    }

    private static String isSpouse(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                for (Person person : tree.getPersons()) {
                    if (person.getName().equals(name2)) {
                        if (tree.getRelation().equals("spouse")) {
                            return "σύζυγος";
                        }
                    }
                }
            }
        }

        return null;
    }

    private static String findSpouse(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    for (Person person2 : tree.getPersons()) {
                        if (person2.getName().equals(name)) {
                            if (tree.getRelation().equals("spouse")) return person.getName();
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String isGrandParent(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        List<Tree> trees = relationMap.get(name1);
        if (trees == null) return null;
        for (Tree tree : trees) {
            if (tree.getRelation().equals("father") || tree.getRelation().equals("mother")) {
                List<Tree> trees2 = relationMap.get(tree.getPersons().get(0).getName());
                if (trees2 == null) continue;
                for (Tree tree2 : trees2) {
                    if (tree2.getRelation().equals("father")) {
                        for (Person person2 : tree2.getPersons()) {
                            if (person2.getName().equals(name2)) return tree.getRelation().equals("mother") ? "Γιαγιά" : "Παππούς";
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String isGrandChild(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String fatherOfFatherName1 = findFather(relationMap, personList, fatherOfName1);
        String motherOfFatherName1 = findMother(relationMap, personList, fatherOfName1);

        if ((fatherOfName1 != null && fatherOfFatherName1 != null && motherOfFatherName1 != null) || (motherOfName1 != null && motherOfFatherName1 != null && fatherOfFatherName1 != null)) {
            if (fatherOfFatherName1.equals(name2) || motherOfFatherName1.equals(name2)) {
                String gender = getGender(personList, name1);
                return gender.equals("male") ? "Εγγονός" : "Εγγονή";
            }
        }

        return null;
    }

    private static String isNephew(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        if (isSibling(relationMap, personList, fatherOfName1, name2) != null || isSibling(relationMap, personList, motherOfName1, name2) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("male") ? "Ανιψιός" : "Ανιψιά";
        }
        return null;
    }

    private static String isNiece(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isSibling(relationMap, personList, fatherOfName1, spouseOfName2) != null || isSibling(relationMap, personList, motherOfName1, spouseOfName2) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("male") ? "Ανιψιός" : "Ανιψιά";
        }
        return null;
    }

    private static String isUncle(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (isSibling(relationMap, personList, name1, fatherOfName2) != null || isSibling(relationMap, personList, name1, motherOfName2) != null) {
            String gender = getGender(personList, name1);
            if (gender.equals("male")) return "Θείος";
        }

        return null;
    }

    private static String isAunt(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        if (isSibling(relationMap, personList, spouseOfName1, fatherOfName2) != null || isSibling(relationMap, personList, spouseOfName1, motherOfName2) != null) return "Θεία";

        return null;
    }

    private static String isFatherInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1,
                                        String name2) {
        String gender = getGender(personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isFather(relationMap, personList, name1, spouseOfName2) != null) return gender.equals("male") ? "Πατριός" : "Μητριά";
        return null;
    }

    private static String isMotherInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String gender = getGender(personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isMother(relationMap, personList, name1, spouseOfName2) != null) return gender.equals("male") ? "Πατριός" : "Μητριά";
        return null;
    }

    private static String isSonInLawOrDaughterInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        if (isFather(relationMap, personList, name2, spouseOfName1) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("male") ? "γαμπρός" : "νύφη";
        }
        return null;
    }

    private static String isBrotherInLawOrSisterInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (spouseOfName1 == null || spouseOfName2 == null) return null;
        if (isSibling(relationMap, personList, spouseOfName1, spouseOfName2) != null || isSibling(relationMap, personList, name1, spouseOfName2) != null || isSibling(relationMap, personList, name2, spouseOfName1) != null) {
            return getGender(personList, name1).equals("malemale") ? "κουνιάδος" : "κουνιάδα";
        }
        return null;
    }

    // Οι μέθοδοι που αναφέρονται παρακάτω χρησιμοποιούνται για τον προσδιορισμό της σύνδεσης μεταξύ δύο
    // ανθρώπων. Κάθε μέθοδος αξιολογείται με τη σειρά και όταν βρεθεί μια αντιστοιχία,
    // επιστρέφεται η σχετική σχέση.
    public static String findRelation(String name1, String name2, Map<String, List<Tree>> relationMap, List<Person> personList) {
        if (personList.stream().filter(p -> p.getName().equals(name1)).count() == 0 || personList.stream().filter(p -> p.getName().equals(name2)).count() == 0) {
            return "PERSON_NOT_FOUND";
        }

        if (name1 == name2) return "SAME_PERSON";

        String[] relationshipArray = {
                isFather(relationMap, personList, name1, name2),
                isMother(relationMap, personList, name1, name2),
                isChild(relationMap, personList, name1, name2),
                isSibling(relationMap, personList, name1, name2),
                isCousin(relationMap, personList, name1, name2),
                isSpouse(relationMap, personList, name1, name2),
                isGrandParent(relationMap, personList, name1, name2),
                isGrandChild(relationMap, personList, name1, name2),
                isNephew(relationMap, personList, name1, name2),
                isNiece(relationMap, personList, name1, name2),
                isUncle(relationMap, personList, name1, name2),
                isAunt(relationMap, personList, name1, name2),
                isFatherInLaw(relationMap, personList, name1, name2),
                isMotherInLaw(relationMap, personList, name1, name2),
                isSonInLawOrDaughterInLaw(relationMap, personList, name1, name2),
                isBrotherInLawOrSisterInLaw(relationMap, personList, name1, name2)
        };

        for (String relationship : relationshipArray) {
            if (relationship != null) return relationship;
        }

        return null;
    }
}