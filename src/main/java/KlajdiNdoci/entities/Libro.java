package KlajdiNdoci.entities;

public class Libro extends Catalogo {

    private String autore;
    private String genere;


    public Libro(String titolo, String autore, String genere) {
        super(titolo);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }


}
