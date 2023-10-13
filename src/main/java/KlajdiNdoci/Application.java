package KlajdiNdoci;

import KlajdiNdoci.entities.Catalogo;
import KlajdiNdoci.entities.Libro;
import KlajdiNdoci.entities.Rivista;
import KlajdiNdoci.enums.Periodicitá;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            Faker faker = new Faker();
            List<Catalogo> catalogo = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                Libro libro = new Libro(faker.book().title(), faker.book().author(), faker.book().genre());
                catalogo.add(libro);
            }


            for (int i = 0; i < 2; i++) {
                Rivista rivistaSettimanale = new Rivista(faker.book().title(), Periodicitá.SETTIMANALE);
                Rivista rivistaMensile = new Rivista(faker.book().title(), Periodicitá.MENSILE);
                Rivista rivistaSemestrale = new Rivista(faker.book().title(), Periodicitá.SEMESTRALE);

                catalogo.add(rivistaSettimanale);
                catalogo.add(rivistaMensile);
                catalogo.add(rivistaSemestrale);

            }

            catalogo.forEach(System.out::println);
            System.out.println();


            int userSelection = -1;
            while (userSelection != 0) {
                System.out.println("Inserisci 1 per aggiungere un elemento");
                System.out.println("Inserisci 2 per rimuovere un elemento tramite ISBN");
                System.out.println("Inserisci 3 per cercare un elemento tramite ISBN");
                System.out.println("Inserisci 4 per ricercare tramite anno di pubblicazione");
                System.out.println("Inserisci 5 per ricercare tramite autore");
                System.out.println("Inserisci 6 per salvare i dati su disco");
                System.out.println("Inserisci 7 per caricare i dati dal disco");
                System.out.println("Inserisci 0 per uscire");
                System.out.println();

                try {
                    userSelection = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Input non valido. Devi inserire un numero.");
                    continue;
                }

                {
                    switch (userSelection) {
                        case 1:
                            System.out.println("Hai scelto l'opzione 1.");

                            break;
                        case 2:
                            System.out.println("Hai scelto l'opzione 2.");

                            break;
                        case 3:
                            System.out.println("Hai scelto l'opzione 3.");
                            break;
                        case 4:
                            System.out.println("Hai scelto l'opzione 4.");
                            break;
                        case 5:
                            System.out.println("Hai scelto l'opzione 5.");
                            break;
                        case 6:
                            System.out.println("Hai scelto l'opzione 6.");

                            break;
                        case 7:
                            System.out.println("Hai scelto l'opzione 7.");

                            break;
                        case 0:
                            System.out.println("Stai uscendo dal programma.");
                            break;

                        default:
                            System.err.println("Scelta non valida. Devi inserire un numero da 1 a 7.");

                            break;
                    }
                }
            }

        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            input.close();
        }

    }
}
