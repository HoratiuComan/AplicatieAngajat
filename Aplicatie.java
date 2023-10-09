import java.util.Scanner;

class Angajat {
    public String Nume;
    public String Prenume;
    public String Departament;
    public int Salariu;

    public Angajat(String Nume, String Prenume, String Departament, int Salariu) {
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Departament = Departament;
        this.Salariu = Salariu;
    }
}

public class AplicatieAngajat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cate angajati doriti sa introduceti? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Angajat[] angajati = new Angajat[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti informatiile pentru angajatul " + (i + 1) + ":");
            System.out.print("Nume: ");
            String nume = scanner.next();
            System.out.print("Prenume: ");
            String prenume = scanner.next();
            System.out.print("Departament: ");
            String departament = scanner.next();
            System.out.print("Salariu: ");
            int salariu = scanner.nextInt();

            angajati[i] = new Angajat(nume, prenume, departament, salariu);
        }

        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Afisati toti angajatii ");
            System.out.println("2. Numarul angajatiilor de la departamentul x");
            System.out.println("3. Suma salariilor");
            System.out.println("0. Iesiti din aplicatie");
            System.out.print("Alegeti o optiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1: // Afisam datele fiecarui angajat
                    for (int i = 0; i < n; i++) {
                        System.out.println("Informatii despre angajatul " + (i + 1) + ":");
                        System.out.println("Nume: " + angajati[i].Nume);
                        System.out.println("Prenume: " + angajati[i].Prenume);
                        System.out.println("Departament: " + angajati[i].Departament);
                        System.out.println("Salariu: " + angajati[i].Salariu);
                        System.out.println("------------");
                    }
                    break;
                case 2: // Calculam numarul angajatilor care lucreaza la departamentul introdus de utilizator
                    System.out.print("Introduceti numele departamentului pentru care doriti sa aflati numarul de angajati: ");
                    String depCautat = scanner.nextLine();

                    int nrAngajatiDep = 0;
                    for (int i = 0; i < n; i++) {
                        if (angajati[i].Departament.equals(depCautat)) {
                            nrAngajatiDep++;
                        }
                    }

                    System.out.println("In departamentul " + depCautat + " lucreaza " + nrAngajatiDep + " angajati.");
                    break;
                case 3: // Suma salariilor tuturor angajatilor
                    int sumaSalarii = 0;
                    for (int i = 0; i < n; i++) {
                        sumaSalarii += angajati[i].Salariu;
                    }
                    System.out.println("Suma salariilor tuturor angajatilor este: " + sumaSalarii);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
        }
    }
}