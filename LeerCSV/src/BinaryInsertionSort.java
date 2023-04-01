public class BinaryInsertionSort<T extends Comparable<T>> {
    private int comparaciones;
    private int intercambios;
    private long tiempoInicio;
    private long tiempoDeEjecucion;

    void binaryInsertSort(DoublyLinkedList<T> list, int sortAttribute)
    {
        if(list.isEmpty()){
            return;
        }

        DoublyLink<T> current = list.getFirst().next;
        while(current != null){
            int pos = binarySearch(list, current.previous, current.dData, sortAttribute);
            if (pos != -1) {
                DoublyLink<T> temp = current;
                T tempData = temp.dData;
                while (temp.previous != null && compare(tempData, temp.previous.dData, sortAttribute) >= 0) {
                    temp.dData = temp.previous.dData;
                    temp = temp.previous;
                    comparaciones++;
                    intercambios++;
                }
                temp.dData = tempData;
            }
            current = current.next;
        }
    }

    private int binarySearch(DoublyLinkedList<T> list, DoublyLink<T> last, T key, int sortAttribute) {
        int left = 0;
        int right = list.sizeList()-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            T midVal = list.find(mid).dData;
            //T midVal = list.searchItemPosition(mid);
            int comparation = compare(key, midVal, sortAttribute);
            comparaciones++;
            if (comparation == 0) {
                return mid;
            } else if (comparation < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    /**
     * Realiza una comparacion entre el tipo de dato {@code a} y el tipo de dato
     * {@code b},
     * en funcion de conocer cual de ellos es mas grande o si fuera el caso, conocer
     * si los datos
     * son iguales, para ellos obtendremos que, si el tipo de dato {@code a} es
     * menor al tipo de
     * dato {@code b} se regresa {@code -1}, si fuera el caso se regresa un
     * {@code 1}, y si ambos
     * datos son iguales entonces se regresa un {@code 0}
     * 
     * @param a             Primer dato, se comparara con el segundo dato
     * @param b             Segundo dato, se comparara con el primer dato
     * @param sortAttribute Selecciona el atributo por el cual se realizara
     *                      comparacion entre los nodos
     * @return El valor resultante de la comparacion
     */
    private int compare(T a, T b, int sortAttribute) {
        Pelicula peliculaA = (Pelicula) a;
        Pelicula peliculaB = (Pelicula) b;
        switch(sortAttribute){
            case 1:
                if (peliculaA.getScore() < peliculaB.getScore()) {
                      return -1;
                  } else if (peliculaA.getScore() > peliculaB.getScore()) {
                      return 1;
                  } else {
                      return 0;
                  }
            case 2: 
                return peliculaA.getName().compareTo(peliculaB.getName());

            case 3: 
                if (peliculaA.getAño() < peliculaB.getAño()) {
                    return -1;
                } else if (peliculaA.getAño() > peliculaB.getAño()) {
                    return 1;
                } else {
                    return 0;
                }

            case 4:   
                if (peliculaA.getDuracion() < peliculaB.getDuracion()) {
                    return -1;
                } else if (peliculaA.getDuracion() > peliculaB.getDuracion()) {
                    return 1;
                } else {
                    return 0;
                }
              
            default:
                return 0;
        }
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

    public long getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public long getTiempoDeEjecucion() {
        return tiempoDeEjecucion;
    }

    public void setTiempoDeEjecucion(long tiempoDeEjecucion) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
    }

    
}