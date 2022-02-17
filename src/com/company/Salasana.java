package com.company;
import java.util.Scanner;

public class Salasana {
    public String sana;

    public Salasana(String sana) {
        this.sana = sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public boolean kelpaa(String sana) {
        boolean pituus = false;
        boolean isot = false;
        boolean pienet = false;
        boolean numerot = false;
        boolean erikoismerkit = false;

        if (sana.length() >= 15)
            pituus = true;
        for (int i = 0; i < sana.length(); i++) {
            if (Character.isUpperCase(sana.charAt(i)))
                isot = true;
            if (Character.isLowerCase(sana.charAt(i)))
                pienet = true;
            if (Character.isDigit(sana.charAt(i)))
                numerot = true;
            if (!((Character.isLetter(sana.charAt(i))) || Character.isDigit(sana.charAt(i))))
                erikoismerkit = true;

        }
        if (pituus && isot && pienet && numerot && erikoismerkit)
            return true;
        else
            return false;

    }
}

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hei! Tällä ohjelmalla testataan salasanoja. Salasanan vaatimukset ovat seuraavat: -Vähintään 15 merkkiä -Ainakin yksi iso kirjain -Ainakin yksi pieni kirjain -Ainakin yksi numero -Ainakin yksi erikoismerkki");
        System.out.println("Ole hyvä ja anna salasana testattavaksi: ");
        Salasana testattava = new Salasana(input.nextLine());
        if (testattava.kelpaa(testattava.sana)) {
            System.out.println("Salasana kelpaa!");
        } else {
            while (!testattava.kelpaa(testattava.sana)) {
                System.out.println("Salasana on puutteellinen, syötä salasana joka täyttää vaatimukset: ");
                testattava.setSana(input.nextLine());
                if (testattava.kelpaa(testattava.sana)) {
                    System.out.println("Salasana kelpaa!");
                    break;
                }
            }

        }

    }

}
