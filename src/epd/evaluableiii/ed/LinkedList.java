package epd.evaluableiii.ed;

public class LinkedList<E> implements ILinkedList<E> {

    private Node<E> firstNode;//se crea el primer nodo de la pila
    private Node<E> lastNode;// se crea ultimo nodo de la pila
    private int size;// numero de nodos en la linked list

    public LinkedList() {// inicializo las variables
        this.size = 0;
        firstNode = null;
        lastNode = null;
    }

     @Override
    public void add(E newElement, int index) throws IndexOutOfBoundsException {

        if (index <= (size - 1)) {// añade un elemento en el index seleccionado
            int cont = 0;//contador para encontrar el elemento en dicho indice
            Node<E> newNode = new Node<E>();//nodo nuevo
            Node<E> antNode =new Node<>();//anterio nodo
            newNode = firstNode;//el nuevo nodo es igual al primer elemento
            while (cont < index) {// este while se encarga de encontrar el nodo indicado
                antNode=newNode;
                newNode = newNode.getNext();
                cont++;
            }
            Node<E> newNodeElement = new Node<E>();// se crea un nuevo nodo
            newNodeElement.setElement(newElement);// se introduce el elemento nuevo en el nod
            antNode.setNext(newNodeElement);//el anterior al index mete como nuevo el elemento nuevo
            newNodeElement.setNext(newNode);//el elemento siguiente sera el nodo que habia en ese index
            
            
            } else {
                throw new IndexOutOfBoundsException();
            }

        }

    

      @Override
    public void addEnd(E newElement) {// esta clase inserta un elemento al final de la lista
        if (newElement != null) {//si el nuevo elemento a insertar es distinto de null
            Node<E> newNode = new Node<E>();//nuevo nodo para introducir el elemento en la lista
            newNode.setElement(newElement);//se introduce el nuevo elemento en el nodo
            if (lastNode != null) {//si el ultimo elemento es distinto de  null
                lastNode.setNext(newNode);// el ultimo elemento tiene el nuevo como siguiente 
                lastNode = newNode;// el nuevo elemento sera el ultimo de la lista

            } else {
                newNode.setNext(null);// el nuevo nodo tiene el siguiente elemento como null
                lastNode = newNode;// el nuevo nodo se convierte en el primero y en el ultimo
                firstNode = newNode;
            }
            size++;// se suma uno al size
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean addFront(E newElement) {
         if (newElement != null) {// nuevo elemento distinto de null
            Node<E> newNode = new Node<E>();// nodo nuevo 
            newNode.setElement(newElement);// se introduce el elemento en el nodo
            if (firstNode != null) {// si el primer elemento es distinto de null
                newNode.setNext(firstNode);// nuevo elemento selecciona como siguiente al que habia primero
                firstNode = newNode;// el primer nodo se convierte en el nuevo nodo
                

            } else {
                newNode.setNext(null);// siguiente nodo null
                lastNode = newNode;// se inicializa el ultimo y el primer nodo como el nuevo
                firstNode = newNode;
            }
         size++;// se suma uno al size
        return true;// si se suma retorna true
        }
        else{
            return false;//sino false
        }
       
    }

    @Override
    public E getElement(int index) throws IndexOutOfBoundsException {// conger el elemento en un index exacto
        if (index <= (size - 1)) {// si el index es menos igual a size menos 1
            int cont = 0;// se inicializa un contador
            Node<E> newNode = new Node<E>();// se crea un nuevo nodo
            newNode = firstNode; //se pone el primer nodo en el nuevo 
            while (cont < index) {// se busca el nodo en el index seleccionado
                newNode = newNode.getNext();
                cont++;
            }
            return  newNode.getElement();// se retorna el nodo
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

   @Override
    public boolean isEmpty() {// este metodo nos dice si esta vacia la linkedlist
       return size==0;// si es cero retorna true, sino false
    }

    @Override
    public void remove(Object index) throws IndexOutOfBoundsException {// eliminar un nodo en un index
        if(firstNode !=null){//si el primer nodo es distinto de null
           Node<E> newNode = new Node<E>();//nuevo nodo
        newNode = firstNode;// nuevo nodo igual que el primero
        boolean encontrado = false;//encontrado
        if (newNode.getElement() == index) {// si el elemento a eliminar es igual al del nodo
            encontrado = true;//encontrado true
        }
        while (encontrado == false && newNode.getNext() != null) {//si el siguiente elemento es distinto de null y el siguiente nodo tambien es distinto null
            if (newNode.getNext().getElement() == index) {// si el siguiente elemento es igual al introducido
                encontrado = true;// encontrado true
            }
        }
            if(encontrado == true){// si encontrado true
            Node<E> nextnewNode = newNode.getNext().getNext();// siguiente de next node
            Node<E> Node = newNode.getNext();//nodo igual al siguiente 
            newNode.setNext(nextnewNode);//nodo sigueinte al newnode es nextnewnodw
            Node.setNext(null);//siguiente nodo a node es null
            size--;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

     @Override
    public void removeEnd() {//elimiar el ultimo nodo
         if (lastNode != null) {//si el ultimo nodo es distinto de null
            Node<E> aux = firstNode;//aux igual al primer nodo
            for (int i = 1; i < size - 1; i++) {//for para llegar al penultimo elemento
                aux = aux.getNext();
            }
            aux.setNext(null);//sioguiente elemento al siguiente 
            lastNode = aux;//lastnode es el aux ahora
            this.size--;//size menos 1
    }}

     @Override
    public void removeFront() {
        Node<E> newNode = new Node<E>();//nodo para  capturar el primero
        Node<E> nextnewNode = new Node<E>();//nodo para capturar el segundo
        newNode = firstNode;//newnode = primer elemento
        nextnewNode = newNode.getNext();//next igual al segundo elemento
        firstNode.setNext(null);// primer nodo ya no tiene siguiente
        firstNode = nextnewNode;// el primer nodo pasa a ser el que habia segundo
    }

    @Override
    public int size() {//retorna la cantidad de elementos que hay en la lista
        return size;
    }

 

    @Override
    public boolean find(E element) {// buscar un elemento en la lista
        Node<E> newNode = new Node<E>();//nodo para recorrer la lista
        newNode = firstNode;// primer elemento se capta en el nodo creado
        boolean encontrado = false;// booleano encontrado
        if(newNode != null){// si el nodo es distinto de null
        if (newNode.getElement() == element) {// miramos si el elemento del nodo es igual al que buscamos
            encontrado = true;// si lo es encontrado a true
        }
        while (encontrado == false && newNode.getNext() != null) {//si no se ha encontrado el elemento y hay un siguiente nodo en la lista
            if (newNode.getNext().getElement() == element) {//si el siguiente nodo es igual al elemento 
                encontrado = true;//encontrado true
            }
            newNode = newNode.getNext();// sino pues miramos el siguiente 
        }
        }
        return encontrado;// retorna el booleano
    }
   @Override
    public String toString() {// imprime toda la lista
        Node<E> newNode = new Node<E>();// nodo para recorrer lista
        newNode = firstNode;//ponemos el nodo en el primer elemento
        String s = newNode.toString();//imprimimos el primer elemento
        while (newNode.getNext() != null) {//si tiene siguiente 
            s += newNode.getNext().toString();// imprimimos el siguiente elemento
            newNode = newNode.getNext();//cogemos el siguiente elemento
        }
        return s;//retorna el string 
    }

      @Override
    public Node<E> getFirstNode() {//metodo para captar el primer nodo
        return firstNode;
    }
    

}
