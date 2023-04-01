public class RadixSort {
    private DoublyLinkedList<Pelicula> list;
    private int comparaciones;
    private int intercambios;
    private long tiempoDeEjecucion;
    private long tiempoInicio;

    /**
     * Este método toma los parametros list y sortAttribute 
     * Utiliza la listaPeliculas y el atributo seleccionado por el usuario para funcionar
     * El atributo es el que usaria para realizar el ordenamiento
     * La lista contiene los valores que se ordenaran
     * Compara sus dígitos del menos al más significativo para ordenarlos en buckets. 
     * Primero se encuentra el valor maximo y con el se determina el número de pasos
     * Comienza a comparar del bit menos significativo el más significativo 
     * Los guarda en buckets de acuerdo a su valor
     * Repite los pasos hasta ordenar la lista
     * @param list
     * @param sortAttribute
     */
    public void radixSort(DoublyLinkedList<Pelicula> list, int sortAttribute) {
        int maxDigits = getMaxDigits(list, sortAttribute);
        for (int i = 0; i < maxDigits; i++) {
            DoublyLinkedList<Pelicula>[] buckets = new DoublyLinkedList[10];
            for (int j = 0; j < 10; j++) {
                buckets[j] = new DoublyLinkedList<>();
            }
            DoublyLink<Pelicula> current = list.getFirst();
            while (current != null) {
                int digit = getDigit(current.getData(), i, sortAttribute);
                buckets[digit].insertLast(current.getData());
                intercambios++;
                current = current.getNext();
            }
            list.deleteAll();
            for (int j = 0; j < 10; j++) {
                DoublyLink<Pelicula> currentBucketNode = buckets[j].getFirst();
                while (currentBucketNode != null) {
                    list.insertLast(currentBucketNode.getData());
                    currentBucketNode = currentBucketNode.getNext();
                    intercambios++;
                }
            }
        }
    }

    /**
     * @param item
     * @param digitIndex
     * @param sortAttribute
     * @return
     */
    private int getDigit(Pelicula item, int digitIndex, int sortAttribute) {
        int itemValue = compare(item, item, sortAttribute) == 0 ? 0 : item.hashCode();
        comparaciones++;
        return (itemValue / (int) Math.pow(10, digitIndex)) % 10;
    }

    /**
     * @param list
     * @param sortAttribute
     * @return maxDigits
     */
    private int getMaxDigits(DoublyLinkedList<Pelicula> list, int sortAttribute) {
        int maxDigits = 0;
        DoublyLink<Pelicula> current = list.getFirst();
        while (current != null) {
            int digits = String.valueOf(compare(current.getData(), current.getData(), sortAttribute)).length();
            comparaciones++;
            if (digits > maxDigits) {
                maxDigits = digits;
            }
            current = current.getNext();
        }
        return maxDigits;
    }

    /**
     * Este método compara los parametros item1 y item2
    * Para saber cual de los dos es más grande o si son iguales
    * Retornando -1 si item2 es mayor, 1 si item1 es mayor o 0 si son iguales
    * Utiliza los atributos de cada pelicula para comparar
    * 
     * @param item
     * @param item2
     * @param sortAttribute
     * @return
     */
    private int compare(Pelicula item, Pelicula item2, int sortAttribute) {
        switch (sortAttribute) {

            case 1:
                if (item.getScore() < item2.getScore()) {
                    return -1;
                } else if (item.getScore() > item2.getScore()) {
                    return 1;
                } else {
                    return 0;
                }
            case 2:
                return item.getName().compareTo(item2.getName());

            case 3:
                if (item.getAño() < item2.getAño()) {
                    return -1;
                } else if (item.getAño() > item2.getAño()) {
                    return 1;
                } else {
                    return 0;
                }

            case 4:
            if (item.getDuracion() < item2.getDuracion()) {
                return -1;
            } else if (item.getDuracion() > item2.getDuracion()) {
                return 1;
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
    public DoublyLinkedList<Pelicula> getList() {
        return list;
    }

    /**
     * Setter de la lista
     * @param list
     */
    public void setList(DoublyLinkedList<Pelicula> list) {
        this.list = list;
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