package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Periodicitá;

import java.util.Random;

public class Rivista extends Catalogo {
    Random random = new Random();
    private Periodicitá periodicitá;

    public Rivista(String titolo, Periodicitá periodicitá) {
        super(titolo);

        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicitá periodicitá) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicitá = periodicitá;
        this.numeroPagine = random.nextInt(20, 100);
    }

    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.numeroPagine = random.nextInt(20, 100);
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "random=" + random +
                ", periodicitá=" + periodicitá +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

}
