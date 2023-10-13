package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Periodicitá;

import java.util.Random;

public class Rivista extends Catalogo {

    private Periodicitá periodicitá;

    public Rivista(String titolo, Periodicitá periodicitá) {
        super(titolo);
        Random random = new Random();
        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicitá periodicitá) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        Random random = new Random();
        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        Random random = new Random();
        this.numeroPagine = random.nextInt(20, 100);
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicitá=" + periodicitá +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

}
