public class Pelicula implements Comparable<Pelicula>{
    private int rank;
    private String Name;
    private float score;
    private int duracion;
    private int año;
    
    /**
     * Constructor de la clase Pelicula
     * @param rank
     * @param name
     * @param año
     * @param score
     * @param duracion
     */
    public Pelicula(int rank, String name, int año, float score, int duracion){
        this.rank = rank;
        this.Name = name;
        this.año = año;
        this.score = score;
        this.duracion = duracion;
    }

    /**
     * Setter de la variable rank
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Getter de la variable rank
     * @return rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Setter de la variable Name
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Getter de la variable Name
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter de la variable score
     * @param score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * Getter de la variable score
     * @return score
     */
    public float getScore() {
        return score;
    }

    /**
     * Setter de la variable duracion
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Getter de la variable duracion
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }
    
    /**
     * Setter de la variable año
     * @param año
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Getter de la variable año
     * @return año
     */
    public int getAño() {
        return año;
    }
    
    
    /**
     * Este método devuelve todas los atributos de Pelicula  al mismo tiempo
     * @return Name + ',' + score +  "," + duracion + "," + año
     */
    @Override
    public String toString() {
        return Name + ',' + score +  "," + duracion + "," + año;
    }

    /**
     * Este método sirve como un comparador
    */
    @Override
    public int compareTo(Pelicula o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}    



