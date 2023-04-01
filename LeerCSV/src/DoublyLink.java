public class DoublyLink<T> {
    public T dData; 
    public DoublyLink<T> next; 
    public DoublyLink<T> previous; 

    public DoublyLink(T d) { 
        dData = d; 
    }

    public void displayLink() { 
        System.out.println(dData + ","); 
    }

    public T getData() {
        return dData;
    }

    public void setData(T data) {
        this.dData = data;
    }

    public DoublyLink<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }

    public DoublyLink<T> getNext() {
        return next;
    }

    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

} 