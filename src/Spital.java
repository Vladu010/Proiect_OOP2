
import java.util.ArrayList;

public class Spital {
    private static int nextId = 0;
    private String numeSpital;
    private String adresaSpital;
    private String emailSpital;
    private String telefonSpital;
    public ArrayList<Pacient> pacientList;
    private int id;

    public Spital(String numeSpital, String adresaSpital, String emailSpital, String telefonSpital) {

        this.adresaSpital = adresaSpital;
        this.numeSpital = numeSpital;
        this.emailSpital = emailSpital;
        this.telefonSpital = telefonSpital;
        this.pacientList = new ArrayList<>();
        this.id = nextId;
        nextId++;
    }

    public void addPacient(Pacient pacient) {
        pacientList.add(pacient);
    }

    public void removePacient(Pacient pacient) {
        pacientList.remove(pacient);
    }

    public void removePacientByIndex(int index) {
        pacientList.remove(index);
    }

    public Pacient getPacient(int index) {
        if (index >= 0 && index < pacientList.size()) {
            return pacientList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Pacientul nu este in baza de date a spitalului");
        }
    }

    public int getNumPacients() {
        return pacientList.size();
    }

    public String getNumeSpital()
    {
        return numeSpital;
    }
    public String getAdresaSpital()
    {
        return adresaSpital;
    }
    public String getEmailSpital(){ return emailSpital;}
    public String getTelefonSpital(){return telefonSpital;}

    //public Pacient getPacient(){
    //    Pacient tmp = pacientList.get(id);
    //    return tmp;
    //}

    public int getId(){
        return id;
    }

    public String toString()
    {
        return "ID-ul: " + id + ": Spitalul " + numeSpital + " " + "cu adresa: " + adresaSpital + ", e-mail: " +
                emailSpital + ", telefon: "+telefonSpital;

    }


}
