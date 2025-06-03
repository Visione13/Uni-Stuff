import java.util.ArrayList;

public class Risikoverwaltung {
    ArrayList risiken = new ArrayList();

    public void aufnehmen(Risiko risiko){
        risiken.add(risiko);
    }

    public void zeigeRisiken(){
        for (int i = 0; i < risiken.size(); i++){
            Risiko risiko = (Risiko) risiken.get(i);
            System.out.println("ID: " + risiko.getId() + " Bezeichnung: " + risiko.getBezeichnung() + " Rückstellung: " + risiko.ermittleRueckstellung());
        }
    }

    public void sucheRisikoMitMaxRueckstellung(){
        float max = 0;
        Risiko maximal = null;
        for (int i = 0; i < risiken.size(); i++){
            Risiko risiko = (Risiko) risiken.get(i);
            if (risiko.ermittleRueckstellung() > max){
                max = risiko.ermittleRueckstellung();
                maximal = risiko;
            }
        }
        if(maximal != null){
            System.out.println("ID: " + maximal.getId() + " Bezeichnung: " + maximal.getBezeichnung() + " Rückstellung: " + maximal.ermittleRueckstellung());
        }
    }

    public void berechneSummeRueckstellungen(){
        float sum = 0;
        for (int i = 0; i < risiken.size(); i++){
            Risiko risiko = (Risiko) risiken.get(i);
            sum += risiko.ermittleRueckstellung();
        }
        System.out.println("Summe: " + sum);
    }
}