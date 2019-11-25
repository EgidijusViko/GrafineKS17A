
public class masina {

    private String marke;
    private String modelis;
    private String kaina;

    @Override
    public String toString() {
        return "masina{" +
                "marke='" + marke + '\'' +
                ", modelis='" + modelis + '\'' +
                ", kaina='" + kaina + '\'' +
                '}';
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public String getKaina() {
        return kaina;
    }

    public void setKaina(String kaina) {
        this.kaina = kaina;
    }

    public masina(String marke, String modelis, String kaina) {
        this.marke = marke;
        this.modelis = modelis;
        this.kaina = kaina;
    }
}