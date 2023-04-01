public class QuickSort<T extends Comparable<T>> {
    private int comparaciones;
    private int intercambios;
    private long tiempoInicio;
    private long tiempoDeEjecucion;

    /**
     * Llama al método quicksort mandadole el primer y el ultimo valor de la lista y el atributo base
     * @param list
     * @param sortingAttribute
     */
    public void sort(DoublyLinkedList<T> list,int sortingAttribute) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quicksort(list.getFirst(), list.getLast(), sortingAttribute);
    }

    /**
     * Divide la lista en 2 
     * Se ordenan esas listas de forma recursiva tomando un elemento como pivote
     * Mueve los elementos menores a la izquierda y los mayores a la izquierda
     * @param left
     * @param right
     * @param sortingAttribute
     */
    private void quicksort(DoublyLink<T> left, DoublyLink<T> right,int sortingAttribute) {
        if (left == null || right == null || left == right || left.previous == right) {
            return;
        }

        DoublyLink<T> pivot = partition(left, right, sortingAttribute);
        quicksort(left, pivot.previous, sortingAttribute);
        quicksort(pivot.next, right, sortingAttribute);
    }

    /**
     * @param left
     * @param right
     * @param sortingAttribute
     * @return
     */
    private DoublyLink<T> partition(DoublyLink<T> left, DoublyLink<T> right,int sortingAttribute) {
        DoublyLink<T> pivot = right;
        DoublyLink<T> i = left.previous;

        for (DoublyLink<T> j = left; j != right; j = j.next) {
            if (compare(j.dData,pivot.dData, sortingAttribute) > 0) {
                i = (i == null) ? left : i.next;
                swap(i, j);
            }
            comparaciones++;
        }

        i = (i == null) ? left : i.next;
        swap(i, right);
        return i;
    }

    /**
     * @param a
     * @param b
     */
    private void swap(DoublyLink<T> a, DoublyLink<T> b) {
        T temp = a.dData;
        a.dData = b.dData;
        b.dData = temp;
        intercambios++;
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
              case 2: return peliculaA.getName().compareTo(peliculaB.getName());
  
              case 3: if (peliculaA.getAño() < peliculaB.getAño()) {
                  return -1;
              } else if (peliculaA.getAño() > peliculaB.getAño()) {
                  return 1;
              } else {
                  return 0;
              }
  
              case 4:   if (peliculaA.getDuracion() < peliculaB.getDuracion()) {
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
