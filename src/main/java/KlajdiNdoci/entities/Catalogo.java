package KlajdiNdoci.entities;

import java.util.Random;

public abstract class Catalogo {
    private long ISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Catalogo(String titolo) {
        Random random = new Random();
        this.ISBN = random.nextLong();
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
}
