public class metricas {
    private long tiempoDeEjecucion;
    private int comparaciones;
    private int intercambios;
    private String metodo;

    /**
     * Constructor de la clase metricas
     * @param tiempoDeEjecucion
     * @param comparaciones
     * @param intercambios
     * @param metodo
     */
    public metricas(long tiempoDeEjecucion, int comparaciones, int intercambios, String metodo) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.metodo = metodo;
    }

    /**
     * Setter de la variable tiempoDeEjecucion
     * @param tiempoDeEjecucion
     */
    public void setTiempoDeEjecucion(long tiempoDeEjecucion) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
    }

    /**
     * Getter de la variable tiempoDeEjecucion
     * @return tiempoDeEjecucion
     */
    public long getTiempoDeEjecucion() {
        return tiempoDeEjecucion;
    }

    /**
     * Setter de la variable comparaciones
     * @param comparaciones
     */
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }

    /**
     * Getter de la variable comparaciones
     * @return comparaciones
     */
    public int getComparaciones() {
        return comparaciones;
    }

    /**
     * Setter de la variable intercambios
     * @param intercambios
     */
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }

    /**
     * Getter de la variable intercambios
     * @return intercambios
     */
    public int getIntercambios() {
        return intercambios;
    }

    /**
     * Setter de la variable metodo
     * @param metodo
     */
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    /**
     * Getter de la variable metodo
     * @return metodo
     */
    public String getMetodo() {
        return metodo;
    }
    
    
    
}
