package Lab3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Schodek
 */

public class Main {

  
    public static void main(String[] args) {
      
        //Set<String> zbiorDni = new HashSet<>();
        Set<String> zbiorDni = new TreeSet<>();
        String linia;
        String[] pola;
        List<Product> produkty = new ArrayList<>();
        Map<Integer, Product > mapaProduktowId = new HashMap<>();
        Map<String, List<Product> > mapaProduktowCategory = new HashMap<>(); 
        

        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        
        zbiorDni.add("wtorek");
        System.out.println(zbiorDni);
        
        /*
            Różnica między HashSet a TreeSet jest taka, że HashSet "wypluwa" wyniki
            w różnej koleności, natomiast TreeSet wypisuje nam wyniki w kolejności alfabetycznej. 
        
            HashSet należy użyc w momencie jeżeli szukamy konkretnego elementu
            TreeSet możnaby było użyc w przypadku, jeżeli zależy nam na posiadaniu posgeregowengo
            zbioru wartości
        
            Żadne zmiany nie były wymagane, wystarczyło zmienić klasę.
        */
        
        Map<String, Teacher> prowadzacy = new HashMap<>();

        Teacher T1 = new Teacher("Jan", "Kowalski", "jan@fake.org", "programowanie obiektowe");
        Teacher T2 = new Teacher("Pawel", "Kowal", "pawel@fake.org", "programowanie skryptowe");
        Teacher T3 = new Teacher("Andrzej", "Gruszka", "Andri@fake.org", "programowanie webowe");
        Teacher T4 = new Teacher("Hubert", "Nowak", "Hubcio@fake.org", "programowanie obiektowe");

        
        prowadzacy.put("programowanie obiektowe", T1);        
        prowadzacy.put("programowanie skryptowe", T2);        
        prowadzacy.put("programowanie webowe", T3);
        
        
        
        Teacher kto = prowadzacy.get("programowanie obiektowe");
        System.out.println("\nProgramowanie obiektowe prowadzi: " + kto);
        
        
        Student Jan = new Student("Jan", "Nazwisko1", "mail1@wi.zut.edu.pl", "32A");
        Student Hubert = new Student("Hubert", "Nazwisko2", "mail2@wi.zut.edu.pl", "32A");
        Student Zosia = new Student("Zosia", "Nazwisko3", "mail3@wi.zut.edu.pl", "32A");
        Student Paulina = new Student("Paulina", "Nazwisko4", "mail4@wi.zut.edu.pl", "32A");
        Student Lidia = new Student("Lidia", "Nazwisko5", "mail5@wi.zut.edu.pl", "32A");
        Student Maciek = new Student("Maciek", "Nazwisko6", "mail6@wi.zut.edu.pl", "32A");
        Student Pawel = new Student("Pawel", "Nazwisko7", "mail7@wi.zut.edu.pl", "32A");
        Student Andrzej = new Student("Andrzej", "Nazwisko8", "mail8@wi.zut.edu.pl", "32A");
        
        List<Student> grupa1 = new ArrayList<>();
        List<Student> grupa2 = new ArrayList<>();
        List<Student> grupa3 = new ArrayList<>();
        List<Student> grupa32 = new ArrayList<>();
        
        grupa1.add(Jan);
        grupa1.add(Hubert);
        grupa2.add(Zosia);
        grupa2.add(Paulina);
        grupa3.add(Lidia);
        grupa3.add(Maciek);
        grupa32.add(Pawel);
        grupa32.add(Andrzej);
        
        Map<Integer, List<Student> > Przynaleznosc = new HashMap<>();
        
        Przynaleznosc.put(1, grupa1);
        Przynaleznosc.put(2, grupa2);
        Przynaleznosc.put(3, grupa3);
        Przynaleznosc.put(32, grupa32);
        
        List<Student> Lista_studentow = Przynaleznosc.get(32);
        
        System.out.println("\nLista studentów należąca do grupy 32:");
        for(Student osoba : Lista_studentow) {
            System.out.println(osoba);
        }
        System.out.println("\n\n");
        
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String product = in.readLine();

            while(product!=null) {
                
                linia = product; //id -> name -> category -> price
                pola = linia.split(";");
                Integer id = parseInt(pola[0]);
                String name = pola[1];
                String category = pola[2];
                Double price = Double.parseDouble(pola[3]);
                
                Product produkt = new Product(id, name, category, price);
                               
                mapaProduktowId.put(id, produkt);
                
                
                produkty.add(produkt);                
                product = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
              
        
        
        
        for( int i = 0 ; i<produkty.size();i++){
        
            String kategoria = produkty.get(i).getCategory();

            if(!mapaProduktowCategory.containsKey(kategoria)) {

                mapaProduktowCategory.put(kategoria,new ArrayList());
            }
        
            mapaProduktowCategory.get(kategoria).add(produkty.get(i));
        }
       
        System.out.println("Wyszukiwanie po id");
        System.out.println(mapaProduktowId.get(101));
        System.out.println("\nWyszukiwanie za pomocą kategorii");
        System.out.println(mapaProduktowCategory.get("słodycze"));
        
    }
    
}
