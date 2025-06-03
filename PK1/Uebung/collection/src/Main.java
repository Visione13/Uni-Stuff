public class Main {
    public static void main(String[] args) {
        AkzeptablesRisiko ar = new AkzeptablesRisiko("Lizenzkosten der IDE steigt",100,40);
        ExtremesRisiko er = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 1, 5000, "Versicherung abschließen", 500);
        InakzeptablesRisiko ir = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 50, 320,  "Ersatz bei Dienstleister reservieren");

        Risikoverwaltung rv = new Risikoverwaltung();
        rv.aufnehmen(ar);
        rv.aufnehmen(er);
        rv.aufnehmen(ir);
        rv.zeigeRisiken();
        rv.sucheRisikoMitMaxRueckstellung();
        rv.berechneSummeRueckstellungen();
    }
}