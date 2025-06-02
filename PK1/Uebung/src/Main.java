public class Main {
    public static void main(String[] args) {
        AkzeptablesRisiko ar = new AkzeptablesRisiko("Lizenzkosten der IDE steigt",100,40);
        ExtremesRisiko er = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 1, 50000, "Versicherung abschließen", 50000);
        InakzeptablesRisiko ir = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 50, 320,  "Ersatz bei Dienstleister reservieren");
        ar.druckeDaten();
        er.druckeDaten();
        ir.druckeDaten();
        ar.equals(er);
    }
}