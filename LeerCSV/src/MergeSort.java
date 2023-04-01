
public class MergeSort<T extends Comparable<T>>{
private DoublyLinkedList<T> listaPelis;
private int intercambios;
private int comparaciones;
private long tiempoDeEjecucion;
private long tiempoInicio;

public DoublyLinkedList<T> mergeSort(DoublyLinkedList<T> listaPelis, int sortAtribute){
    if (listaPelis.sizeList() <= 1) {
        return listaPelis;
    }

    DoublyLinkedList<T> leftList = new DoublyLinkedList<>();
    DoublyLinkedList<T> rightList = new DoublyLinkedList<>();
    int middle = listaPelis.sizeList() / 2;

    DoublyLink<T> current = listaPelis.getFirst();
    int index = 0;
 
    while (current != null) {
        if (index < middle) {
            leftList.insertLast(current.getData());
        } else { 
            rightList.insertLast(current.getData());
        }

        index++;
        current = current.getNext();
    }

    leftList = mergeSort(leftList, sortAtribute);
    rightList = mergeSort(rightList, sortAtribute);

    return merge(leftList, rightList, sortAtribute);
}

private DoublyLinkedList<T> merge(DoublyLinkedList<T> left, DoublyLinkedList<T> right, int sortAtribute){
    DoublyLinkedList<T> result = new DoublyLinkedList<>();
    DoublyLink<T> leftNode = left.getFirst();
    DoublyLink<T> rightNode = right.getFirst();

    while ((leftNode != null) && (rightNode != null)) {
        if (compare(leftNode.getData(), rightNode.getData(), sortAtribute) <= 0) {
            result.insertLast(leftNode.getData());
            leftNode = leftNode.getNext();
        } else {
            result.insertLast(rightNode.getData());
            rightNode = rightNode.getNext();
        }
        comparaciones++;
        intercambios++;
    }

    while (leftNode != null) {
        result.insertLast(leftNode.getData());
        leftNode = leftNode.getNext();
    }

    while (rightNode != null) {
        result.insertLast(rightNode.getData());
        rightNode = rightNode.getNext();
    }

    return result;
}

public DoublyLinkedList<T> sort(int sortAttribute) {
    DoublyLinkedList<T> theResult = mergeSort(this.listaPelis, sortAttribute);
    return theResult;
}

private int compare(T a, T b, int sortAttribute) {
        
    Pelicula peliculaA = (Pelicula) a;
    Pelicula peliculaB = (Pelicula) b;
    switch(sortAttribute){
       
        case 1:
             
            if (peliculaA.getScore() < peliculaB.getScore()) {
                  return 1;
              } else if (peliculaA.getScore() > peliculaB.getScore()) {
                  return -1;
              } else {
                  return 0;
              }
          case 2: return peliculaA.getName().compareTo(peliculaB.getName());

          case 3: if (peliculaA.getAño() < peliculaB.getAño()) {
              return 1;
          } else if (peliculaA.getAño() > peliculaB.getAño()) {
              return -1;
          } else {
              return 0;
          }

          case 4:   if (peliculaA.getDuracion() < peliculaB.getDuracion()) {
            return 1;
        } else if (peliculaA.getDuracion() > peliculaB.getDuracion()) {
            return -1;
        } else {
            return 0;
        }
          
          default:
              return 0;
      }

}

public DoublyLinkedList<T> getListaPelis() {
    return listaPelis;
}

public void setListaPelis(DoublyLinkedList<T> listaPelis) {
    this.listaPelis = listaPelis;
}

public int getIntercambios() {
    return intercambios;
}

public void setIntercambios(int intercambios) {
    this.intercambios = intercambios;
}

public int getComparaciones() {
    return comparaciones;
}

public void setComparaciones(int comparaciones) {
    this.comparaciones = comparaciones;
}

public long getTiempoDeEjecucion() {
    return tiempoDeEjecucion;
}

public void setTiempoDeEjecucion(long tiempoDeEjecucion) {
    this.tiempoDeEjecucion = tiempoDeEjecucion;
}

public long getTiempoInicio() {
    return tiempoInicio;
}

public void setTiempoInicio(long tiempoInicio) {
    this.tiempoInicio = tiempoInicio;
}



}