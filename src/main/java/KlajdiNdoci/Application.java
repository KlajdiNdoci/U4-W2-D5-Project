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


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            input.close();
        }

    }
}
