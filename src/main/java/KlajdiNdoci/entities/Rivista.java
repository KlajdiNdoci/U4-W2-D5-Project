package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Periodicitá;

public class Rivista extends Catalogo {
    private Periodicitá periodicitá;

    public Rivista(String titolo, Periodicitá periodicitá) {
        super(titolo);
        this.periodicitá = periodicitá;
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
    }
}
