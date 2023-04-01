
public class MergeSort<T extends Comparable<T>>{
private DoublyLinkedList<T> listaPelis;
private int intercambios;
private int comparaciones;
private long tiempoDeEjecucion;
private long tiempoInicio;

/**
 * Este método toma los parametros listaPelis y sortAttribute 
* Utiliza la listaPelis y el atributo seleccionado por el usuario para funcionar
* El atributo es el que usaria para realizar el ordenamiento
* La lista contiene los valores que se ordenaran
 * Realiza la partición de la lista en 2 mitades y las ordena recursovamente
 * Finalmente merge combina las 2 listas en una
 * @param listaPelis
 * @param sortAtribute
 * @return
 */
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

/**
*
 * @param left
 * @param right
 * @param sortAtribute
 * @return result
 */
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

/**
 * Envia al método mergeSort el atributo seleccionado por el usuario y las lista a ordenar
 * Le devuelve una lista ordenada
 * @param sortAttribute
 * @return result
 */
public DoublyLinkedList<T> sort(int sortAttribute) {
    DoublyLinkedList<T> theResult = mergeSort(this.listaPelis, sortAttribute);
    return theResult;
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

/**
     * Getters de la lista
     * @return list
     */
public DoublyLinkedList<T> getListaPelis() {
    return listaPelis;
}

 /**
     * Setter de la lista
     * @param list
     */
public void setListaPelis(DoublyLinkedList<T> listaPelis) {
    this.listaPelis = listaPelis;
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