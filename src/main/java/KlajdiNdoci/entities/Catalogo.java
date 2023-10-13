package KlajdiNdoci.entities;

import java.util.Random;

public abstract class Catalogo {
    protected long ISBN;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public Catalogo(String titolo) {
        Random random = new Random();
        this.ISBN = Math.abs(random.nextLong());
        this.titolo = titolo;
        this.annoPubblicazione = random.nextInt(1800, 2023);
        this.numeroPagine = random.nextInt(100, 800);
    }

    public Catalogo(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
