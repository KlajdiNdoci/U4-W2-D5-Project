package KlajdiNdoci.entities;

public class Libro extends Catalogo {
    private String autore;
    private String genere;

    public Libro(String titolo) {
        super(titolo);
    }

    public Libro(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
    }
}
