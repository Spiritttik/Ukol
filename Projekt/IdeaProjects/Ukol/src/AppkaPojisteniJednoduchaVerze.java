import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppkaPojisteniJednoduchaVerze {
    private List<Pojisteny> pojisteni;

    public AppkaPojisteniJednoduchaVerze() {
        this.pojisteni = new ArrayList<>();
    }

    public void pridejPojisteneho(String jmeno, String prijmeni, int vek, String telefon) {
        Pojisteny novyPojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        pojisteni.add(novyPojisteny);
        System.out.println("Pojištěný byl úspěšně přidán.");
    }

    public void zobrazSeznamPojistenych() {
        if (pojisteni.isEmpty()) {
            System.out.println("V seznamu pojištěných není žádný záznam.");
        } else {
            System.out.println("Seznam pojištěných:");
            for (Pojisteny poisteny : pojisteni) {
                System.out.println(poisteny);
            }
        }
    }

    public void vyhledejPojisteneho(String jmeno, String prijmeni) {
        for (Pojisteny poisteny : pojisteni) {
            if (poisteny.getJmeno().equalsIgnoreCase(jmeno) && poisteny.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println("Vyhledaný pojištěný:");
                System.out.println(poisteny);
                return;
            }
        }
        System.out.println("Pojištěný s tímto jménem a příjmením nebyl nalezen.");
    }

    public static void main(String[] args) {
        AppkaPojisteniJednoduchaVerze aplikace = new AppkaPojisteniJednoduchaVerze();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("Aplikace pro evidenci pojištěných");
        System.out.println("==========================");
        while (true) {
            System.out.println();
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit seznam pojištěných");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("0 - Konec");

            System.out.print("Vyberte možnost: ");
            int volba = scanner.nextInt();

            switch (volba) {
                case 0:
                    System.out.println("Ukončuji aplikaci.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Zadejte jméno: ");
                    String jmeno = scanner.next();
                    System.out.print("Zadejte příjmení: ");
                    String prijmeni = scanner.next();
                    System.out.print("Zadejte věk: ");
                    int vek = scanner.nextInt();
                    System.out.print("Zadejte telefonní číslo: ");
                    String telefon = scanner.next();
                    aplikace.pridejPojisteneho(jmeno, prijmeni, vek, telefon);
                    break;
                case 2:
                    aplikace.zobrazSeznamPojistenych();
                    break;
                case 3:
                    System.out.print("Zadejte jméno: ");
                    String hledaneJmeno = scanner.next();
                    System.out.print("Zadejte příjmení: ");
                    String hledanePrijmeni = scanner.next();
                    aplikace.vyhledejPojisteneho(hledaneJmeno, hledanePrijmeni);
                    break;
                default:
                    System.out.println("Neplatná volba. Zkuste to znovu.");
            }
        }
    }
}