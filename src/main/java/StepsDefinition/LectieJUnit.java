package stepsDefinition.bazele;

public class Lectia25si26 {

    //----Functii statice----------------------------------------------------------------------
    // cele care nu returneaza nimic

    public static void tiparireInt(int tiparireNumar){ // tiparireNumar = 34 // tiparireNumar = 67 / ....... / tiparireNumar = 90
        System.out.println(tiparireNumar); // 34 // 67 // ...... // 90
    }

    public static void tiparireString(String tiparireString){
        System.out.println(tiparireString);
    }

    //----Functii dinamice----------------------------------------------------------------------
    // cele care returneaza valori
    // cu un parametru

    public int maxim(int[] multimeNumere){
        int maxim=0;
        for(int i=0; i < multimeNumere.length; i++){
            if (multimeNumere[i]>maxim) {
                maxim = multimeNumere[i];
            }
        }
        tiparireInt(maxim);
        return maxim;
    }

    // cu mai multi parametri
    public static int repetareCuvinte(String[] sirDeCaractere, String cuvantCautat){
        int x = 0;
        for (String i : sirDeCaractere){
            if (i.contains(cuvantCautat)){
                x++;
            }
        }
        tiparireInt(x);
        return(x);
    }

    public static String concatenare (String[] sirDeCaractere){
        String sirConcatenat = "";
        for (String i : sirDeCaractere){
            sirConcatenat=sirConcatenat.concat(i);
        }
        tiparireString(sirConcatenat);
        return sirConcatenat;
    }

    //-------------------------------------------------------------------------
    public int sumaNumere(int a, int b){
        tiparireInt(a+b);
        return(a+b);
    }


    public void main(String[] args) {

        int[] exercitiulUnu = {34, 67, 45, 3, 10, 2, 90};
        String[] primavara = {"Astazi incepe primavara!", "Astazi este 1 martie", "Astazi este miercuri"};

        for (int i : exercitiulUnu) {  // exercitiulUnu[0] = 34 // exercitiulUnu[1] = 67 // ....... // exercitiulUnu[6] = 90
            //System.out.println(exercitiulUnu[i]);
            tiparireInt(i); // tiparireInt(34) // tiparireInt(67) // ......// tiparireInt(90)
        }

        for (String i : primavara){
            tiparireString(i);
        }

        //-------- alternativa gasire maxim ------------------------------------------------------------------
        int maxim=0;
        for(int i=0; i < exercitiulUnu.length; i++){
            if (exercitiulUnu[i]>maxim) {
                maxim = exercitiulUnu[i];
            }
        }
        //System.out.println("Valoarea maxima a sirului este: " + maxim);
        tiparireInt(maxim);

        //------- optimizare -------------------------------------------------------------------
        maxim(exercitiulUnu);

        //-------- daca se repeta un cuvant ------------------------------------------------------------------

        int x = 0;
        for (String i : primavara){
            if (i.contains("Astazi")){
                x++;
            }
        }
        tiparireInt(x);

        //--------- optimizare repetare cuvant -----------------------------------------------------------------
        repetareCuvinte(primavara, "Astazi");

        //--------------------------------------------------------------------------
        //---- alte functii ----------------------------------------------------------------------

        sumaNumere(2, 3);

        concatenare(primavara);
    }
}
