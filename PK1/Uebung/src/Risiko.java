import java.time.LocalDate;
import java.util.Objects;

public abstract class Risiko {
    private static int ids = 0;
    private int id;
    private String bezeichnung;
    private float eintrittswahrscheinlichkeit;
    private float kosten_im_schadensfall;
    private LocalDate erstellungsdatum;

    public Risiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall){
        this.id = ids;
        ids++;
        this.erstellungsdatum = LocalDate.now();
        this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
        this.bezeichnung = bezeichnung;
        this.kosten_im_schadensfall = kosten_im_schadensfall;
    }

    public float berechneRisikowert () {
        return this.eintrittswahrscheinlichkeit * this.kosten_im_schadensfall;
    }

    public abstract float ermittleRueckstellung ();
    public abstract void druckeDaten();

    public int getId() {
        return this.id;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public String getErstellungsdatum() {
        return this.erstellungsdatum.getMonthValue() + "/" + this.erstellungsdatum.getYear();
    }

    public int hashCode(){
        return Objects.hash(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, erstellungsdatum);
    }

    public void equals(Risiko x){
        if(this.hashCode() == x.hashCode()){
            System.out.println("Die Objekte mit Id " + this.id + " und Id " + x.id + " sind gleich");
            System.out.println("Die gleichen Objekte haben den Hashcode " + this.hashCode());
        }else{
            System.out.println("Die Objekte mit der Id " + this.id + " und Id " + x.id + " sind nicht gleich");
            System.out.println("Die unterschiedlichen Objekte haben die Hashcodes " + this.hashCode() + " und " + x.hashCode());
        }
    }
}