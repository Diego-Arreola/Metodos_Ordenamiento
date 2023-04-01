public class RadixSort {
    private DoublyLinkedList<Pelicula> list;
    private int comparaciones;
    private int intercambios;
    private long tiempoDeEjecucion;
    private long tiempoInicio;

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

    private int getDigit(Pelicula item, int digitIndex, int sortAttribute) {
        int itemValue = compare(item, item, sortAttribute) == 0 ? 0 : item.hashCode();
        comparaciones++;
        return (itemValue / (int) Math.pow(10, digitIndex)) % 10;
    }

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

    public DoublyLinkedList<Pelicula> getList() {
        return list;
    }

    public void setList(DoublyLinkedList<Pelicula> list) {
        this.list = list;
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