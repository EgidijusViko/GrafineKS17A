public class Pirkejas {

    private double pinigai;
    private String vardas;

    public double getPinigai() {
        return pinigai;
    }

    public void setPinigai(double pinigai) {
        this.pinigai = pinigai;
    }

    public String getVardas() {
        return vardas;
    }

    @Override
    public String toString() {
        return "Pirkejas{" +
                "pinigai=" + pinigai +
                ", vardas='" + vardas + '\'' +
                '}';
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Pirkejas(double pinigai, String vardas) {
        this.pinigai = pinigai;
        this.vardas = vardas;
    }
}
