public class DoublyLink<T> {
    public T dData; 
    public DoublyLink<T> next; 
    public DoublyLink<T> previous; 

    /**
     * Constructor de la clase DoublyLink
     * Inicializa la variable dData con el valor de data
     * @param data
     */
    public DoublyLink(T data) { 
        dData = data; 
    }

    /**
     * Este método imprime la data de cada nodo
     */
    public void displayLink() { 
        System.out.println(dData + ","); 
    }
    
    /**
     * Setter de la variable dData
     * @param data
     */
    public void setData(T data) {
        this.dData = data;
    }

    /**
     * Getter de la variable dData
     * @return dData
     */
    public T getData() {
        return dData;
    }
 
    /**
     * Setter de la variable previous
     * @param previous
     */
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }

    /**
     * Getter de la variable previous
     * @return previous
     */
    public DoublyLink<T> getPrevious() {
        return previous;
    }

    /**
     * Setter de la variable next
     * @param next
     */
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

    /**
     * Getter de la variable next
     * @return net
     */
    public DoublyLink<T> getNext() {
        return next;
    }
} 