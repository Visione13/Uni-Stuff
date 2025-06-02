public class InakzeptablesRisiko extends Risiko{
    private String massnahme;

    public InakzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall, String massnahme) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
        this.massnahme = massnahme;
    }

    public float ermittleRueckstellung(){
        return this.berechneRisikowert();
    }
    public void druckeDaten(){
        System.out.println("Id " + this.getId() + " Inakzeptables Risiko " + getBezeichnung() + " aus " + getErstellungsdatum() + "; Risikowert " + this.berechneRisikowert() + "; Rückstellung " + this.ermittleRueckstellung() + "; Maßnahme " + this.getMassnahme());
    }

    public String getMassnahme(){
        return this.massnahme;
    }
}