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

                try {
                    userSelection = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Input non valido. Devi inserire un numero.");
                    continue;
                }

                {
                    switch (userSelection) {
                        case 1:
                            System.out.println("Hai scelto l'opzione 1.(aggiungere un elemento)");
                            System.out.println("Scrivi L per aggiungere un libro o R per aggiungere una rivista");
                            String userInput = input.nextLine();
                            try {
                                if (userInput.equalsIgnoreCase("L")) {
                                    System.out.println("Inserisci il titolo del libro");
                                    String bookTitle = input.nextLine();
                                    System.out.println("Inserisci l'autore del libro");
                                    String bookAuthor = input.nextLine();
                                    System.out.println("Inserisci il genere del libro");
                                    String bookGenre = input.nextLine();
                                    System.out.println("Inserisci il codice ISBN del libro");
                                    long bookISBN = Long.parseLong(input.nextLine());
                                    System.out.println("Inserisci l'anno di pubblicazione del libro");
                                    int bookYear = Integer.parseInt(input.nextLine());

                                    boolean validBookYear = false;
                                    while (!validBookYear) {
                                        try {
                                            if (bookYear < 0 || bookYear > 2023) {
                                                System.err.println("L'anno di pubblicazione non può essere negativo.");
                                            } else {
                                                validBookYear = true;
                                            }

                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico.");
                                        }
                                    }

                                    System.out.println("Inserisci il numero di pagine del libro");
                                    int bookPages = Integer.parseInt(input.nextLine());

                                    boolean validBookPages = false;
                                    while (!validBookPages) {

                                        try {
                                            if (bookPages < 1) {
                                                System.err.println("Il numero di pagine deve essere maggiore di zero. Riprova.");
                                            } else {
                                                validBookPages = true;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico. Riprova.");
                                        }
                                    }


                                    Libro libro = new Libro(bookISBN, bookTitle, bookYear, bookPages, bookAuthor, bookGenre);
                                    catalogo.add(libro);
                                    System.out.println("Hai inserito questo libro");
                                    System.out.println(libro);
                                    System.out.println();

                                } else if (userInput.equalsIgnoreCase("R")) {
                                    System.out.println("Inserisci il titolo della rivista");
                                    String magazineTitle = input.nextLine();
                                    System.out.println("Inserisci il codice ISBN della rivista");
                                    long magazineISBN = Long.parseLong(input.nextLine());
                                    System.out.println("Inserisci l'anno di pubblicazione della rivista");
                                    int magazineYear = Integer.parseInt(input.nextLine());

                                    boolean validMagazineYear = false;
                                    while (!validMagazineYear) {
                                        try {
                                            if (magazineYear < 0 || magazineYear > 2023) {
                                                System.err.println("L'anno di pubblicazione non può essere negativo.");
                                            } else {
                                                validMagazineYear = true;
                                            }

                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico.");
                                        }
                                    }

                                    System.out.println("Inserisci il numero di pagine della rivista");
                                    int magazinePages = Integer.parseInt(input.nextLine());

                                    boolean validMagazinePages = false;
                                    while (!validMagazinePages) {

                                        try {
                                            if (magazinePages < 1) {
                                                System.err.println("Il numero di pagine deve essere maggiore di zero. Riprova.");
                                            } else {
                                                validMagazinePages = true;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico. Riprova.");
                                        }
                                    }

                                    System.out.println("Inserisci SET se é un settimanale, MEN se é un mensile, SEM se é un semestrale");
                                    Periodicitá magazinePeriodicity = null;
                                    boolean validPeriodicity = false;
                                    String magInput;

                                    while (!validPeriodicity) {
                                        magInput = input.nextLine();
                                        if (magInput.equalsIgnoreCase("SET")) {
                                            magazinePeriodicity = Periodicitá.SETTIMANALE;
                                            validPeriodicity = true;
                                        } else if (magInput.equalsIgnoreCase("MEN")) {
                                            magazinePeriodicity = Periodicitá.MENSILE;
                                            validPeriodicity = true;
                                        } else if (magInput.equalsIgnoreCase("SEM")) {
                                            magazinePeriodicity = Periodicitá.SEMESTRALE;
                                            validPeriodicity = true;
                                        } else {
                                            System.err.println("Inserisci un valore valido.");
                                        }
                                    }


                                    Rivista rivista = new Rivista(magazineISBN, magazineTitle, magazineYear, magazinePages, magazinePeriodicity);
                                    catalogo.add(rivista);
                                    System.out.println("Hai inserito questa rivista");
                                    System.out.println(rivista);
                                    System.out.println();

                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Hai inserito un valore non numerico " + e);
                            } catch (Exception e) {
                                System.err.println(e);
                            }

                            break;
                        case 2:
                            System.out.println("Hai scelto l'opzione 2.(rimuovere un elemento tramite ISBN)");
                            System.out.println("Inserisci il codice ISBN dell'elemento che desideri rimuovere:");
                            long isbnToRemove = Long.parseLong(input.nextLine());

                            List<Catalogo> removedItem = catalogo.stream().filter(elemento -> elemento != null && elemento.getISBN() == isbnToRemove).toList();
                            if (!removedItem.isEmpty()) {
                                catalogo.removeIf(elemento -> elemento.getISBN() == isbnToRemove);
                                System.out.println("Elemento rimosso con successo");
                                System.out.println(removedItem);
                                System.out.println();
                                System.out.println("Questo è il catalogo modificato");
                                System.out.println();
                                catalogo.forEach(System.out::println);
                            } else {
                                System.err.println("Nessun elemento trovato con il codice ISBN specificato.");
                            }
                            break;

                        case 3:
                            System.out.println("Hai scelto l'opzione 3.(cercare un elemento tramite ISBN)");
                            System.out.println("Inserisci il codice ISBN dell'elemento che desideri cercare:");
                            long findElByISBN = Long.parseLong(input.nextLine());
                            catalogo.stream()
                                    .filter(el -> el.getISBN() == findElByISBN).findFirst();

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
            System.err.println("Hai inserito un valore non numerico " + e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            input.close();
        }

    }
}
