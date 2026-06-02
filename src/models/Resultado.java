package models;

public class Resultado {
    private String algoritmo;
    private String escenario;
    private int sample;
    private double tiempoNano;
    private double tiempoMillis;

    public Resultado() {
    }

    public Resultado(String algoritmo, String escenario, int sample, double tiempoNano) {
        this.algoritmo = algoritmo;
        this.escenario = escenario;
        this.sample = sample;
        this.tiempoNano = tiempoNano;
        this.tiempoMillis = tiempoNano / 1_000_000.0;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getEscenario() {
        return escenario;
    }

    public int getSample() {
        return sample;
    }

    public double getTiempoNano() {
        return tiempoNano;
    }

    public double getTiempoMillis() {
        return tiempoMillis;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    public void setTiempoNano(double tiempoNano) {
        this.tiempoNano = tiempoNano;
    }

    public void setTiempoMillis(double tiempoMillis) {
        this.tiempoMillis = tiempoMillis;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "%s | %s | %d | %.2f ms", escenario, algoritmo, sample, tiempoMillis);
    }
}



    

