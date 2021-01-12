
package epd.evaluableiii.ed;

public class Node<E> {
    private E element ;//elemento dentro del nodo
    private Node<E> next ;//siguiente nodo
    
    public Node() {//constructor para inicializar nodo
        element =null;
        next =null;
    }
    
    public E getElement(){//obtener elemento en el nodo
        return element;
    }
    public void setElement(E element){//introducir el elemento en el nodo
        this.element=element;
    }

    public Node<E> getNext() {//siguiente nodo
        return next;
    }

    public void setNext(Node<E> next) {//introducir els siguiente nodo
        this.next = next;
    }

     @Override
    public String toString() {//imprimir el elemento dentro del nodo
        if(element !=null)
            return "" + element.toString();
        else
            return "null";
    }
    

   
    
}
