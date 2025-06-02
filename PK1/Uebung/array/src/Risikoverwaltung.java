public class Risikoverwaltung {
    Risiko[] risiken = new Risiko[10];

    public void aufnehmen(Risiko risiko){
        boolean failed = true;
        for(int i = 0; i < risiken.length; i++){
            if(risiken[i] == null){
                risiken[i] = risiko;
                i = risiken.length;
                failed = false;
            }
        }
        if (failed){
            System.out.println("Risiko konnte nicht aufgenommen werden!");
        }
    }

    public void zeigeRisiken(){
        for(Risiko risiko : risiken){
            if(risiko != null){
                System.out.println("ID : " + risiko.getId() + " Bezeichnung: " + risiko.getBezeichnung() + " Rückstellung: " + risiko.ermittleRueckstellung());
            }
        }
    }

    public void sucheRisikoMitMaxRueckstellung(){
        Risiko highest = null;
        for(Risiko risiko : risiken){
            if(highest == null){
                if(risiko != null){
                    highest = risiko;
                }
            }
            if(risiko != null){
                if(risiko.ermittleRueckstellung() > highest.ermittleRueckstellung()){
                    highest = risiko;
                }
            }
        }
        System.out.println("ID : " + highest.getId() + " Bezeichnung: " + highest.getBezeichnung() + " Rückstellung: " + highest.ermittleRueckstellung());
    }

    public void berechneSummeRueckstellungen(){
        float summeRueckstellung = 0;
        for(Risiko risiko : risiken){
            if(risiko != null){
                summeRueckstellung += risiko.ermittleRueckstellung();
            }
        }
        System.out.println("SummeRueckstellung: " + summeRueckstellung);
    }
}