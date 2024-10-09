package java_basics;

public class Quest6 {
    public Integer fibonacci(Integer n) {

        int value = 0;
            if (n == 0) {
                return 0;
            }
            else if (n == 1) {
                return 1;
            }
            else {
                int a = 0; // kaksi sijaa sitten
                int b = 1; // edellinen sija
                for (int i = 2; i <= n; i++) {
                    System.out.println("Entered loop");
                    System.out.println("i = " +i);
                    value = a + b; // n:nnännen sijan arvo
                    System.out.println("Current index value a + b = " +value); 
                    a = b; // shiftataan kaksi sijaa sitten olevaa muuttujaa yksi eteenpäin, jotta seuraavalla loopilla voidaan laskea seuraava arvo
                    System.out.println("Updating a value (into old b value) = " +a);
                    b = value; // shiftataan edellistä sijaa yksi eteenpäin nykyiseen resultiin, jotta seuraavalla loopilla voidaan laskea seuraava arvo
                    System.out.println("Updating b value (into old index value) = " +b);
                }
            }

        return value;
    }
}

/* 
    eli siis esim jos etsitään 8. sijaa fibonacci-sarjassa:
    kun i = 7:
	•	7:s sija = value = a + b = 5 + 8 = 13
	•	ennakkopäivitä a: a = b = 8
	•	ennakkopäivitä b: b = value = 13
	•	nyt arvot valmiina seuraavaa kierrosta varten: a = 8, b = 13
    •   i++ -> i = 8
	kun i = 8:
	•	8:s sija = value = a + b = 8 + 13 = 21
	•	ennakkopäivitä a: a = b = 13
	•	ennakkopäivitä b: b = value = 21
	•	nyt arvot valmiina seuraavaa kierrosta varten: a = 13, b = 21
    •   i++ -> i = 9 => silmukka katkeaa koska i ylitti 8:n
*/