public class metricas {
    private long tiempoDeEjecucion;
    private int comparaciones;
    private int intercambios;
    private String metodo;

    public metricas(long tiempoDeEjecucion, int comparaciones, int intercambios, String metodo) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.metodo = metodo;
    }
    public long getTiempoDeEjecucion() {
        return tiempoDeEjecucion;
    }
    public void setTiempoDeEjecucion(long tiempoDeEjecucion) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
    }
    public int getComparaciones() {
        return comparaciones;
    }
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
    public int getIntercambios() {
        return intercambios;
    }
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }
    public String getMetodo() {
        return metodo;
    }
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    
}
