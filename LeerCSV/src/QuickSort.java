public class QuickSort<T extends Comparable<T>> {
    private int comparaciones;
    private int intercambios;
    private long tiempoInicio;
    private long tiempoDeEjecucion;

    public void sort(DoublyLinkedList<T> list,int sortingAttribute) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quicksort(list.getFirst(), list.getLast(), sortingAttribute);
    }

    private void quicksort(DoublyLink<T> left, DoublyLink<T> right,int sortingAttribute) {
        if (left == null || right == null || left == right || left.previous == right) {
            return;
        }

        DoublyLink<T> pivot = partition(left, right, sortingAttribute);
        quicksort(left, pivot.previous, sortingAttribute);
        quicksort(pivot.next, right, sortingAttribute);
    }

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

    private void swap(DoublyLink<T> a, DoublyLink<T> b) {
        T temp = a.dData;
        a.dData = b.dData;
        b.dData = temp;
        intercambios++;
    }

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
