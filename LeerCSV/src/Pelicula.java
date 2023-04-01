public class Pelicula implements Comparable<Pelicula>{
    private int rank;
    private String Name;
    private float score;
    private int duracion;
    private int año;
    //private int opcion;
    

    public Pelicula(int rank, String name, int año, float score, int duracion){
        this.rank = rank;
        this.Name = name;
        this.año = año;
        this.score = score;
        this.duracion = duracion;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

      

    @Override
    public String toString() {
        return Name + ',' + score +  "," + duracion + "," + año;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    @Override
    public int compareTo(Pelicula o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}    



