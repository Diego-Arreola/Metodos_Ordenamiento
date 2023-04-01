public class BinaryInsertionSort<T extends Comparable<T>> {
    private int comparaciones;
    private int intercambios;
    private long tiempoInicio;
    private long tiempoDeEjecucion;


    /**
     * Este método toma los parametros list y sortAttribute 
     * Utiliza la listaPeliculas y el atributo seleccionado por el usuario para funcionar
     * El atributo es el que usaria para realizar el ordenamiento
     * La lista contiene los valores que se ordenaran
     * Lo que hace el método es ordenarlos dependiendo del orden y el atributo seleccionado por el usuario
     * @param list
     * @param sortAttribute
     */
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

    /**
     * Este método hace una busqueda binaria para poder ordenar los valores de la lista
     * Comienza con el segundo elemento de la lista comparando con los elementos posteriores para encontrar el lugar en donde se pondran
     * @param list
     * @param last
     * @param key
     * @param sortAttribute
     * @return
     */
    private int binarySearch(DoublyLinkedList<T> list, DoublyLink<T> last, T key, int sortAttribute) {
        int left = 0;
        int right = list.sizeList()-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            T midVal = list.find(mid).dData;
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
     * Este método compara los parametros data1 y data2
     * Para saber cual de los dos es más grande o si son iguales
     * Retornando -1 si data2 es mayor, 1 si data1 es mayor o 0 si son iguales
     * Utiliza los atributos de cada pelicula para comparar
     * 
     * @param data1
     * @param data2
     * @param sortAttribute 
     * @return Valor resultante de la comparacion
     */
    private int compare(T data1, T data2, int sortAttribute) {
        Pelicula peliculaA = (Pelicula) data1;
        Pelicula peliculaB = (Pelicula) data2;
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

    /**
     * Getter de la variable comparaciones
     * @return comparaciones
     */
    public int getComparaciones() {
        return comparaciones;
    }

    /**
     * Setter de la variable comparaciones
     * @param comparaciones
     */
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }

    /**
     * Getter de la variable intercambios
     * @return intercambios
     */
    public int getIntercambios() {
        return intercambios;
    }

    /**
     * Setter de la variable intercambios
     * @param intercambios
     */
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }

    /**
     * Getter de la variable tiempoInicio
     * @return tiempoInicio
     */
    public long getTiempoInicio() {
        return tiempoInicio;
    }

    /**
     * Setter de la variable tiempoInicio
     * @param tiempoInicio
     */
    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    /**
     * Getter de la variable tiempoDeEjecucion
     * @return tiempoDeEjecucion
     */
    public long getTiempoDeEjecucion() {
        return tiempoDeEjecucion;
    }

    /**
     * Setter de la variable tiempoDeEjecucion
     * @param tiempoDeEjecucion
     */
    public void setTiempoDeEjecucion(long tiempoDeEjecucion) {
        this.tiempoDeEjecucion = tiempoDeEjecucion;
    }
    
}