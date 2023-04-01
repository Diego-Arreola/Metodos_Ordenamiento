public class DoublyLinkedList<T> {
    private DoublyLink<T> first; 
    private DoublyLink<T> last; 
    
    public DoublyLinkedList() {
        first = null; 
        last = null;
    }

    public boolean isEmpty() { 
        return first==null; 
    }
    
    public void insertFirst(T dd){
        DoublyLink<T> newLink = new DoublyLink<>(dd); 
        if( isEmpty() ) 
            last = newLink; 
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

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

    public int sizeList(){
        int cont = 0;
        DoublyLink<T> current = first;
        while(current != null){
            cont++;
            current = current.next;
        }
        return cont;
    }

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

    public DoublyLink<T> deleteFirst() { 
        DoublyLink<T> temp = first;
        if(first.next == null) 
            last = null;
        else
            first.next.previous = null;
        first = first.next; 
        return temp;
    }

    public DoublyLink<T> deleteLast(){
        DoublyLink<T> temp = last;
        if(first.next == null) 
            first = null; 
        else
            last.previous.next = null; 
        last = last.previous; 
        return temp;
    }
    
   
    
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

    public DoublyLink<T> deleteAll(){
        DoublyLink<T> temp = null;
        while(first != null){
            temp = first;
            first = first.next;
        }
        return temp;
    }

    public void displayForward() {
        DoublyLink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.next; 
        }
        System.out.println("");
    }

    public void displayBackward() {
        DoublyLink<T> current = last;
        while(current != null) {
            current.displayLink(); 
            current = current.previous; 
        }
        System.out.println("");
    }

    public DoublyLink<T> getFirst() {
        return first;
    }

    public DoublyLink<T> getLast() {
        return last;
    }

    public void set(int index, T dato) {
        DoublyLink<T> current = find(index);
        if (current != null) {
            current.dData = dato;
        }
    }

    /*public DoublyLink<T> find(T key) {
        DoublyLink<T> current = first;
    
        while (current != null && !current.dData.equals(key)) {
            current = current.next;
        }
    
        return current;
    }*/

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

    /*public void insertFirst(DoublyLink<T> link) {
        if (isEmpty()) {
            last = link;
        } else {
            first.previous = link;
        }
        link.next = first;
        first = link;
    }
    
    public void insertLast(DoublyLink<T> link) {
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
            link.previous = last;
        }
        last = link;
    }*/

    /**
     * Retorna el valor contenido en el nodo en la posicion dada
     * 
     * @param position La posicion en la lista de la cual se requiere obtener el
     *                 valor del nodo
     * @return Objeto contenido en el nodo
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