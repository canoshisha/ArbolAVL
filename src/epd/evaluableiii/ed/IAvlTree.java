
package epd.evaluableiii.ed;

public interface IAvlTree {

    public NodoAVL getRaiz();

    public int getSize();

    public void subirAltura(NodoAVL nodo);

    public int altura(NodoAVL nodo);

    //obtener factor de equilibrio
    public int getFe(NodoAVL node);

    //buscar un elemento del arbol
    public NodoAVL find(String hashtag, NodoAVL r);

    //isEmpty
    public boolean isEmpty();

    //obtener el valor minimo del arbol
    public NodoAVL findMin(NodoAVL r);

    //obtener el valor maximo del arbol
    public NodoAVL findMax(NodoAVL r);

    //rotacion Simple derecha
    public NodoAVL rotacionDerecha(NodoAVL c);

    //rotacion Simple izquierda
    public NodoAVL rotacionIzquierda(NodoAVL c);

    // Rotacion derecha-izquierda
    public NodoAVL rotacion_derecha_izquierda(NodoAVL c);

    // Rotacion doble a la izquierda
    public NodoAVL rotacion_izquierda_derecha(NodoAVL c);

    public void addElement(String hashtag);

    public NodoAVL helperAddElement(NodoAVL node, String hashtag);

    public NodoAVL rebalance(NodoAVL nodo);

    public void removeElement(String hashtag);

    public NodoAVL helperRemoveElement(NodoAVL nodo, String hashtag);

    public boolean contains(String hashtag);

    public void removeMin();

    public void removeMax();

    public void removeAllElements();

    public NodoAVL recorridoizq(NodoAVL inicio);

    @Override
    public String toString();

    public String imprimirBucle(NodoAVL raiz);
}
