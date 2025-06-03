import java.util.ArrayList;
import java.util.List;

public class Risikoverwaltung {
    List<Risiko> risiken = new ArrayList<Risiko>();

    public void aufnehmen(Risiko risiko){
        risiken.add(risiko);
    }

    public void zeigeRisiken(){
        for(Risiko risiko : risiken){
            System.out.println("ID: " + risiko.getId() + " Bezeichnung: " + risiko.getBezeichnung() + " Rückstellung: " + risiko.ermittleRueckstellung());
        }
    }

    public void sucheRisikoMitMaxRueckstellung(){
        float max = 0;
        Risiko maxRisiko = null;
        for (Risiko risiko : risiken) {
            if(risiko.ermittleRueckstellung() > max){
                max = risiko.ermittleRueckstellung();
                maxRisiko = risiko;
            }
        }
        if(maxRisiko != null){
            System.out.println("ID: " + maxRisiko.getId() + " Bezeichnung: " + maxRisiko.getBezeichnung() + " Rückstellung: " + maxRisiko.ermittleRueckstellung());
        }
    }

    public void berechneSummeRueckstellungen(){
        float sum = 0;
        for (Risiko risiko : risiken) {
            sum += risiko.ermittleRueckstellung();
        }
        System.out.println("Summe: " + sum);
    }
}