public class AkzeptablesRisiko extends Risiko {

    public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
    }

    public float ermittleRueckstellung(){
        return 0;
    }
    public void druckeDaten(){
        System.out.println("Id " + this.getId() + " Akzeptables Risiko " + this.getBezeichnung() + " aus " + this.getErstellungsdatum()+ "; Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung());
    }
}
