package KlajdiNdoci;

import KlajdiNdoci.entities.Catalogo;
import KlajdiNdoci.entities.Libro;
import KlajdiNdoci.entities.Rivista;
import KlajdiNdoci.enums.Periodicitá;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        try {

            String filePath = "src/output.txt";
            List<Catalogo> catalogo = readFromDisk(filePath);
            catalogo.forEach(System.out::println);
            if (catalogo.isEmpty()) {
                generateItems(catalogo);
            }


            int userSelection = -1;
            while (userSelection != 0) {
                Thread.sleep(1000);
                System.out.println("Inserisci 1 per aggiungere un elemento");
                System.out.println("Inserisci 2 per rimuovere un elemento tramite ISBN");
                System.out.println("Inserisci 3 per cercare un elemento tramite ISBN");
                System.out.println("Inserisci 4 per ricercare tramite anno di pubblicazione");
                System.out.println("Inserisci 5 per ricercare tramite autore");
                System.out.println("Inserisci 6 per salvare i dati su disco");
                System.out.println("Inserisci 7 per caricare i dati dal disco");
                System.out.println("Inserisci 0 per uscire e salvare");

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
                            Thread.sleep(500);
                            System.out.println("Scrivi L per aggiungere un libro o R per aggiungere una rivista");
                            String userInput = input.nextLine();
                            try {
                                if (userInput.equalsIgnoreCase("L")) {
                                    String bookTitle = "";
                                    while (bookTitle.isEmpty()) {
                                        System.out.println("Inserisci il titolo del libro:");
                                        bookTitle = input.nextLine().trim();

                                        if (bookTitle.isEmpty()) {
                                            System.err.println("Il titolo del libro non può essere vuoto. Riprova.");
                                        }
                                    }

                                    String bookAuthor = "";
                                    while (bookAuthor.isEmpty()) {
                                        System.out.println("Inserisci l'autore del libro");
                                        bookAuthor = input.nextLine().trim();

                                        if (bookAuthor.isEmpty()) {
                                            System.err.println("L'autore del libro non può essere vuoto. Riprova.");
                                        }
                                    }

                                    String bookGenre = "";
                                    while (bookGenre.isEmpty()) {
                                        System.out.println("Inserisci il genere del libro");
                                        bookGenre = input.nextLine().trim();

                                        if (bookGenre.isEmpty()) {
                                            System.err.println("Il genere del libro non può essere vuoto. Riprova.");
                                        }
                                    }
                                    long bookISBN = 0;
                                    boolean validBookISBN = false;
                                    while (!validBookISBN) {
                                        try {
                                            System.out.println("Inserisci il codice ISBN del libro");
                                            bookISBN = Long.parseLong(input.nextLine());
                                            validBookISBN = true;
                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico.");
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    }
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
                                        } catch (Exception e) {
                                            System.err.println(e);
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
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    }


                                    Libro libro = new Libro(bookISBN, bookTitle, bookYear, bookPages, bookAuthor, bookGenre);
                                    catalogo.add(libro);
                                    Thread.sleep(1000);
                                    System.out.println("Hai inserito questo libro");
                                    System.out.println(libro);
                                    System.out.println();

                                } else if (userInput.equalsIgnoreCase("R")) {
                                    String magazineTitle = "";
                                    while (magazineTitle.isEmpty()) {
                                        System.out.println("Inserisci il titolo della rivista");
                                        magazineTitle = input.nextLine().trim();

                                        if (magazineTitle.isEmpty()) {
                                            System.err.println("L'autore del libro non può essere vuoto. Riprova.");
                                        }
                                    }
                                    long magazineISBN = 0;
                                    boolean validMagazineISBN = false;
                                    while (!validMagazineISBN) {
                                        try {
                                            System.out.println("Inserisci il codice ISBN della rivista");
                                            magazineISBN = Long.parseLong(input.nextLine());
                                            validMagazineISBN = true;
                                        } catch (NumberFormatException e) {
                                            System.err.println("Hai inserito un valore non numerico.");
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    }

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
                                    Thread.sleep(1000);
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
                            Thread.sleep(500);
                            System.out.println("Inserisci il codice ISBN dell'elemento che desideri rimuovere:");
                            long isbnToRemove = Long.parseLong(input.nextLine());

                            List<Catalogo> removedItem = catalogo.stream().filter(elemento -> elemento != null && elemento.getISBN() == isbnToRemove).toList();
                            if (!removedItem.isEmpty()) {
                                catalogo.removeIf(elemento -> elemento.getISBN() == isbnToRemove);
                                System.out.println("Elemento rimosso con successo");
                                System.out.println(removedItem);
                                System.out.println();
                                Thread.sleep(2000);
                                System.out.println("Questo è il catalogo modificato");
                                System.out.println();
                                catalogo.forEach(System.out::println);
                                System.out.println();
                            } else {
                                System.err.println("Nessun elemento trovato con il codice ISBN specificato.");
                            }
                            break;

                        case 3:
                            System.out.println("Hai scelto l'opzione 3.(cercare un elemento tramite ISBN)");
                            Thread.sleep(500);
                            System.out.println("Inserisci il codice ISBN dell'elemento che desideri cercare:");
                            long findElByISBN = Long.parseLong(input.nextLine());
                            List<Catalogo> searchedItemByISBN = catalogo.stream()
                                    .filter(elemento -> elemento != null && elemento.getISBN() == findElByISBN)
                                    .toList();

                            if (!searchedItemByISBN.isEmpty()) {
                                System.out.println();
                                System.out.println("Questo é l'elemento cercato");
                                System.out.println(searchedItemByISBN);
                                System.out.println();
                            } else {
                                System.err.println("Nessun elemento trovato con il codice ISBN specificato.");
                            }
                            break;

                        case 4:
                            System.out.println("Hai scelto l'opzione 4.");
                            Thread.sleep(500);
                            System.out.println("Inserisci l'anno dell'elemento che desideri cercare:");
                            long findByYear = Long.parseLong(input.nextLine());
                            List<Catalogo> searchedItemsByYear = catalogo.stream()
                                    .filter(elemento -> elemento != null && elemento.getAnnoPubblicazione() == findByYear)
                                    .toList();

                            if (!searchedItemsByYear.isEmpty()) {
                                System.out.println();
                                System.out.println("Questo é il risultato della ricerca tramite anno di pubblicazione");
                                searchedItemsByYear.forEach(System.out::println);
                                System.out.println();
                            } else {
                                System.err.println("Nessun elemento trovato con l'anno specificato.");
                            }

                            break;
                        case 5:
                            System.out.println("Hai scelto l'opzione 5.");
                            Thread.sleep(500);
                            System.out.println("Inserisci l'autore che desideri cercare:");
                            String findByAuthor = input.nextLine();
                            List<Catalogo> searchedItemsByAuthor = catalogo.stream()
                                    .filter(elemento -> elemento instanceof Libro && ((Libro) elemento).getAutore().equalsIgnoreCase(findByAuthor))
                                    .toList();

                            if (!searchedItemsByAuthor.isEmpty()) {
                                System.out.println();
                                System.out.println("Questo é il risultato della ricerca tramite autore");
                                searchedItemsByAuthor.forEach(System.out::println);
                                System.out.println();
                            } else {
                                System.err.println("Nessun elemento trovato con l'autore specificato.");
                            }

                            break;
                        case 6:
                            System.out.println("Hai scelto l'opzione 6.");
                            Thread.sleep(500);

                            break;
                        case 7:
                            System.out.println("Hai scelto l'opzione 7.");
                            Thread.sleep(500);

                            break;
                        case 0:
                            System.out.println("Stai uscendo dal programma.");
                            Thread.sleep(500);
                            saveToDisk(catalogo);
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

    public static void saveToDisk(List<Catalogo> catalogo) {
        String toWrite = "";


        for (Catalogo item : catalogo) {
            if (item instanceof Libro) {
                toWrite += item.getISBN() + "@" + item.getTitolo() + "@" + item.getAnnoPubblicazione() + "@" + item.getNumeroPagine() + "@" + ((Libro) item).getAutore() + "@" + ((Libro) item).getGenere() + "#";
            } else if (item instanceof Rivista) {
                toWrite += (item.getISBN() + "@" + item.getTitolo() + "@" + item.getAnnoPubblicazione() + "@" + item.getNumeroPagine() + "@" + ((Rivista) item).getPeriodicitá()) + "#";
            }
        }

        File file = new File("src/output.txt");
        try {

            FileUtils.writeStringToFile(file, "", StandardCharsets.UTF_8, false);
            FileUtils.writeStringToFile(file, toWrite + System.lineSeparator(), StandardCharsets.UTF_8, true);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Catalogo> readFromDisk(String filePath) {
        List<Catalogo> catalogo = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");

                for (String part : parts) {
                    String[] attributes = part.split("@");

                    if (attributes.length == 6) {
                        Libro libro = new Libro(Long.parseLong(attributes[0]), attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), attributes[4], attributes[5]);
                        catalogo.add(libro);
                    } else if (attributes.length == 5) {
                        Rivista rivista = new Rivista(Long.parseLong(attributes[0]), attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Periodicitá.valueOf(attributes[4].toUpperCase()));
                        catalogo.add(rivista);

                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return catalogo;
    }

    public static void generateItems(List<Catalogo> catalogo) {
        Faker faker = new Faker();

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
    }

}
