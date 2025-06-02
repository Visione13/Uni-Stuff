public class ExtremesRisiko extends InakzeptablesRisiko{
    private float versicherungsbeitrag;

    public ExtremesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall, String massnahme, float versicherungsbeitrag) {
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, massnahme);
        this.versicherungsbeitrag = versicherungsbeitrag;
    }

    public float ermittleRueckstellung(){
        return this.versicherungsbeitrag * this.versicherungsbeitrag;
    }

    public void druckeDaten(){
        System.out.println("Id " + this.getId() +  " Extremes Risiko " + this.getBezeichnung() + " aus " + this.getErstellungsdatum() + "; Versicherungsbeitrag " + this.versicherungsbeitrag + "; Maßnahme " + this.getMassnahme());
    }
}