public class DoublyLinkedList<T> {
    private DoublyLink<T> first; 
    private DoublyLink<T> last; 
    
    /**
     * Constructor de la clase DoublyLinkedList
     */
    public DoublyLinkedList() {
        first = null; 
        last = null;
    }

    /**
     * Este método verifica si la lista es vacia
     * @return true / false
     */
    public boolean isEmpty() { 
        return first==null; 
    }
    

    /**
     * Este método inserta al inicio de la lista
     * @param dd
     */
    public void insertFirst(T dd){
        DoublyLink<T> newLink = new DoublyLink<>(dd); 
        if( isEmpty() ) 
            last = newLink; 
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    /**
     * Este método inserta al final de la lista
     * @param dd
     */
    public void insertLast(T dd) {
        DoublyLink<T> newLink = new DoublyLink<>(dd); 
        if( isEmpty() ) 
            first = newLink; 
        else {
            last.next = newLink; 
            newLink.previous = last; 
        }
        last = newLink; 
    }

    /**
     * Este método inserta en una posicion especifica
     * @param key
     * @param dd
     * @return true / false
     */
    public boolean insertAfter(T key, T dd) { 
        DoublyLink<T> current = first; 
        while(current.dData != key) {
            current = current.next; 
            if(current == null)
                return false; 
        }
        DoublyLink<T> newLink = new DoublyLink<>(dd);
        if(current==last) {
            newLink.next = null; 
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current; 
        current.next = newLink; 
        return true; 
    }

    /**
     * Este método muestra el primer elemento de la lista
     * @return current (Nodo actual)
     */
    public DoublyLink<T> showFirst(){
        if(!isEmpty()){
            System.out.print("First DoublyLink --> ");
            DoublyLink<T> current = first;
            current.displayLink();
            System.out.println("");
            return current; 
        }
        return null;
    }

    /**
     * Este método mustra el ultimo elemento de la lista
     * @return current (Nodo actual)
     */
    public DoublyLink<T> showLast(){
        if(!isEmpty()){
            System.out.print("Last DoublyLink --> ");
            DoublyLink<T> current = last;
            current.displayLink();
            System.out.println("");

            return current;
        }
        return null;
    }

    /**
     * Este método imprime el tamaño de la lista
     * @return cont
     */
    public int sizeList(){
        int cont = 0;
        DoublyLink<T> current = first;
        while(current != null){
            cont++;
            current = current.next;
        }
        return cont;
    }


    /**
     * Este método imprime un elemento de la lista en una posicion especifica
     * @param dato
     * @return cont / -1
     */
    public int searchItem(T dato){
        int cont = 0;
        DoublyLink<T> current = first;
        while (current != null) {
            if(current.dData.equals(dato)){
                System.out.println("Position--> "+ cont);
                current = null;
                return cont;
            }else{
                current = current.next;
                cont++;
            }
           
        }
        System.out.println("Elemento no encontrado, -1");
        return -1;
    }

    /**
     * Este método borra el primer elemento de la lista
     * @return temp
     */
    public DoublyLink<T> deleteFirst() { 
        DoublyLink<T> temp = first;
        if(first.next == null) 
            last = null;
        else
            first.next.previous = null;
        first = first.next; 
        return temp;
    }

    /**
     * Este método borra el ultimo elemento de la lista
     * @return temp
     */
    public DoublyLink<T> deleteLast(){
        DoublyLink<T> temp = last;
        if(first.next == null) 
            first = null; 
        else
            last.previous.next = null; 
        last = last.previous; 
        return temp;
    }
 
    /**
     * Este método borra un elemento en una posicion especifica
     * @param key
     * @return current
     */
    public DoublyLink<T> deleteKey(T key) { 
        DoublyLink<T> current = first; 
        while(current.dData != key) {
            current = current.next; 
            if(current == null)
            return null;
        }
        if(current==first)
            first = current.next;
        else
            current.previous.next = current.next;
        if(current==last) 
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    /**
     * Este método borra todos los elementos de la lista
     * @return temp
     */
    public DoublyLink<T> deleteAll(){
        DoublyLink<T> temp = null;
        while(first != null){
            temp = first;
            first = first.next;
        }
        return temp;
    }

    /**
     * Este método imprime la lista de izquierda a derecha
     */
    public void displayForward() {
        DoublyLink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.next; 
        }
        System.out.println("");
    }

    /**
     * Este método imprime la lista de derecha a izquierda
     */
    public void displayBackward() {
        DoublyLink<T> current = last;
        while(current != null) {
            current.displayLink(); 
            current = current.previous; 
        }
        System.out.println("");
    }

    /** 
     * Getter del primer elemento
     * @return first
     */
    public DoublyLink<T> getFirst() {
        return first;
    }

    /** 
     * Getter del ultimo elemento
     * @return last
     */
    public DoublyLink<T> getLast() {
        return last;
    }

    /**
     * Setter del Nodo
     * @param index
     * @param dato
     */
    public void set(int index, T dato) {
        DoublyLink<T> current = find(index);
        if (current != null) {
            current.dData = dato;
        }
    }

    /**
     * Este método retorna un nodo en una posicion especifica
     * @param index
     * @return current
     */
    public DoublyLink<T> find(int index) {
        DoublyLink<T> current;
        int middleIndex = sizeList() / 2; 
        
        if (index <= middleIndex) { 
            current = first;
            for (int i = 0; i < index; i++) { 
                current = current.next;
            }
        } else { 
            current = last;
            for (int i = sizeList() - 1; i > index; i--) { 
                current = current.previous;
            }
        }
        
        return current; 
    }

    /**
     * Este método retorna el valor de un nodo en una posicio dada
     * @param position
     * @return data
     */
    public T searchItemPosition(int position) {
        T data = null;

        if (!isEmpty()) {
            if (position > this.sizeList() && position < 0) {
                System.out.println("La posicion sobrepasa el tamanio de la lista");
            } else {
                int counter = 0;
                DoublyLink<T> current = this.first;

                while (current != null) {
                    if (counter == position) {
                        data = current.getData();
                        break;
                    } else {
                        counter++;
                        current = current.getNext();
                    }
                }
            }
        }
        return data;
    }

} 