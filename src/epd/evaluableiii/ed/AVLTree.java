package epd.evaluableiii.ed;

public class AVLTree implements IAvlTree{

    private NodoAVL raiz;//nodo raiz 
    private int size;//size

    //contructor
    public AVLTree(NodoAVL raiz) {//incializamos las variables de arbol
        raiz = null;
        size = 0;
    }

    @Override
    public NodoAVL getRaiz() {//obtenemos la raiz
        return raiz;
    }

    @Override
    public int getSize() {//obtener el numero de nodos en el arbol
        return size;
    }

    @Override
    public void subirAltura(NodoAVL nodo) {// aumentar la altura del nodo introducido 
        nodo.setAltura(1 + Math.max(this.altura(nodo.getIzquierda()), this.altura(nodo.getDerecha())));//coge el maximo de la altura de sus hijos y le suma uno
    }

    @Override
    public int altura(NodoAVL nodo) {//mira la altura del nodo 
        return ((nodo == null) ? -1 : nodo.getAltura());// si nodo es null devuelve menos 1 si no coge su altura 
    }

    //obtener factor de equilibrio
    @Override
    public int getFe(NodoAVL node) {// se obtiene el factor del equilibrio
        return ((node == null) ? 0 : altura(node.getDerecha()) - altura(node.getIzquierda()));// el fe se obtiene si el nodo es null su fe es 0, sino el la altura del hijo derecho menos la altura del hijo izq
    }

    //buscar un elemento del arbol
    @Override
    public NodoAVL find(String hashtag, NodoAVL r) {// en este metodo buscamos un nodo en el arbol

        if (r == null) {// si r es null retornamos null
            return null;
        } else {
            int comparacion = r.getHashtag().compareToIgnoreCase(hashtag);//comparamos los hashtag del nodo del arbol con el que estamos buscando
            if (comparacion == 0) {//si esta a 0 retornamos el nodo
                return r;
            } else if (comparacion < 0) {//si en la comparacion el nodo es menor que el hastag 
                return find(hashtag, r.getDerecha());// hacemos recursividad con el hijo derecho ya que el hastag a buscar es mas grande 
            } else {
                return find(hashtag, r.getIzquierda());//// hacemos recursividad con el hijo derecho ya que el hastag a buscar es mas pequeño 
            }

        }
    }

    //isEmpty
    @Override
    public boolean isEmpty() {//decimos si el arbol esta vacio
        return size == 0;
    }

    //obtener el valor minimo del arbol
    @Override
    public NodoAVL findMin(NodoAVL r) {//buscar el minimo, lo que hacemos el recorrer el arbol al maximo que haya en la izq

        if (raiz == null) {//si raiz es nula no hay arbol portanto null
            return null;
        } else if (r.getIzquierda() != null) {// si tiene izquierda miramos a la izq
            return findMin(r.getIzquierda());//retornamos el minimo
        } else {
            return r;// si no hay mas a la izq retornamos el introducido
        }
    }

    //obtener el valor maximo del arbol
    @Override
    public NodoAVL findMax(NodoAVL r) {// se comporta igual que el anterior pero buscando el maximo a la derecha ya que seria el mayor

        if (raiz == null) {
            return null;
        } else if (r.getDerecha() != null) {
            return findMax(r.getDerecha());
        } else {
            return r;
        }
    }

    //rotacion Simple derecha
    @Override
    public NodoAVL rotacionDerecha(NodoAVL c) {
        NodoAVL aux = c.getIzquierda();//cogemos el aux el hijo izquierdo del nodo introducido
        NodoAVL d = aux.getDerecha();//nodo d el cual es el hijo derecho del hijo izquierdo del nodo introducido
        aux.setDerecha(c);//a la derecha de del nodo aux guardamos c
        c.setIzquierda(d);//a la izquierda de c guardamos el nodo d
        subirAltura(c);// subimos la altura de c
        subirAltura(aux);//subimos la altura de aux
        return aux;//retornamos el auxiliar
    }

    //rotacion Simple izquierda
    @Override
    public NodoAVL rotacionIzquierda(NodoAVL c) {
        NodoAVL aux = c.getDerecha();//cogemos el aux el hijo derecho del nodo introducido
        NodoAVL z = aux.getIzquierda();//nodo d el cual es el hijo izquierdo del hijo derecho del nodo introducido
        aux.setIzquierda(c);//a la izquierda de del nodo aux guardamos c
        c.setDerecha(z);//a la derecha de c guardamos el nodo d
        subirAltura(c);// subimos la altura de c
        subirAltura(aux);//subimos la altura de aux
        return aux;//retornamos el auxiliar
    }

    // Rotacion derecha-izquierda
    @Override
    public NodoAVL rotacion_derecha_izquierda(NodoAVL c) {
        c.setDerecha(rotacionDerecha(c.getDerecha()));//rotamos a la derecha el hijo derecho del nodo introducido
        c = rotacionIzquierda(c);//rotamos a la izquierda el nodo introducido
        return c;//devolvemos c
    }

    // Rotacion doble a la izquierda
    @Override
    public NodoAVL rotacion_izquierda_derecha(NodoAVL c) {
        c.setIzquierda(rotacionIzquierda(c.getIzquierda()));//rotamos a la derecha el hijo derecho del nodo introducido
        c = rotacionDerecha(c);//rotamos a la izquierda el nodo introducido
        return c;//devolvemos c
    }

    @Override
    public void addElement(String hashtag) {//añadir un elemento
        raiz = this.helperAddElement(raiz, hashtag);//iniciamos el añadir un elemento con el hastag introducido
    }

    @Override
    public NodoAVL helperAddElement(NodoAVL node, String hashtag) {//añadir un elemento rebalanceando el arbol tras ello 
        if (node == null) {//si el nodo es  null
            this.size++;//sumamos uno al numero de elementos en el nodo
            return (new NodoAVL(hashtag));//devolvemos el nuevo nodo creado con el hastag
        } else if (node.getHashtag().compareTo(hashtag) > 0) {//en estos if comparamos con cada uno de los elementos, y elegimos si va a la derecha o a la izquierda
            node.setIzquierda(helperAddElement(node.getIzquierda(), hashtag));
        } else if (node.getHashtag().compareTo(hashtag) < 0) {
            node.setDerecha(helperAddElement(node.getDerecha(), hashtag));
        } else if (node.getHashtag().compareTo(hashtag) == 0) {//si son iguales claramente no se hace nada y se dice que esta repetido
            System.out.println("El hashtag " + hashtag + " está repetido.");
        }
        return rebalance(node);// se rebalancea el arbol 
    }

    @Override
    public NodoAVL rebalance(NodoAVL nodo) {// rebalanceo del arbol
        subirAltura(nodo);//subimos la altura del nodo introducido
        int balance = getFe(nodo);// obtenemos el fe del nodo
        if (balance > 1) {// si el balance es mayor que uno
            if (altura(nodo.getDerecha().getDerecha()) > altura(nodo.getDerecha().getIzquierda())) {//si la altura del hijo derecho del hijo derecho del nodo es mayor que la del hijo izquierdo del hijo derecho
                nodo = rotacionIzquierda(nodo);//rotacion izquierda
            } else {
                nodo = rotacion_derecha_izquierda(nodo);//sino doble rotacion
            }
        } else if (balance < -1) {//si el balance es menor que 1
            if (altura(nodo.getIzquierda().getIzquierda()) > altura(nodo.getIzquierda().getDerecha())) {//si la altura del hijo izquierdo  del hijo izquierdo del nodo es mayor que la del hijo derecho del hijo izquierdo
                nodo = rotacionDerecha(nodo);//rotacion a la derecha
            } else {
                nodo = rotacion_izquierda_derecha(nodo);//sino doble rotacion
            }
        }
        return nodo;//devolvemos el nodo
    }

    @Override
    public void removeElement(String hashtag) {// comenzamos el eliminar un elemento
        raiz = helperRemoveElement(raiz, hashtag);
    }

    @Override
    public NodoAVL helperRemoveElement(NodoAVL nodo, String hashtag) {
        if (nodo == null) {// si el nodo es null
            size--;//restamos uno
            return nodo;//devolvemos el nodo null
        } else if (nodo.getHashtag().compareTo(hashtag) > 0) {// lo primero que realizamos es una busqueda del nodo que debemos eliminar
            nodo.setIzquierda(this.helperRemoveElement(nodo.getIzquierda(), hashtag));
        } else if (nodo.getHashtag().compareTo(hashtag) < 0) {
            nodo.setDerecha(this.helperRemoveElement(nodo.getDerecha(), hashtag));
        } else {// una vez encontramos el nodo a cambiar
            if (nodo.getIzquierda() == null || nodo.getDerecha() == null) {// si no teniene hijo izq o derecho
                nodo = (nodo.getIzquierda() == null) ? nodo.getDerecha() : nodo.getIzquierda();//si no tiene hijo izquierdo nodo= hijo derecho sino nodo= hijo izquierdo
            } else { 
                NodoAVL masizq = recorridoizq(nodo.getDerecha());// si encontramos el nodo,cogemos el hijo derecho y recogorros su subarbol izquierdo
                nodo.setHashtag(masizq.getHashtag());//introducimos en el nodo el hastag del hijo izquierdo, su substituto
                nodo.setDerecha(helperRemoveElement(nodo.getDerecha(), nodo.getHashtag()));// introducimos a la derecha del nodo 
            }
        }
        if (nodo != null) {// si el nodo no es null
            nodo = this.rebalance(nodo);//rebalanceamos el arbol
        }
        return nodo;// devolvemos el nodo
    }

    @Override
    public boolean contains(String hashtag) {// este metodo busca un hastag dentro del arbol
        NodoAVL nodo = raiz;//comenzamos a buscar desde la raiz
        while (nodo != null) {
            if (nodo.getHashtag().compareTo(hashtag) == 0) {// si es igual return true
                return true;
            }
            nodo = (nodo.getHashtag().compareTo(hashtag) > 0) ? nodo.getDerecha() : nodo.getIzquierda();// si es mayor o menor coge el hijo correspondiente
        }
        return false;// devuelve falso si no lo encuentra 
    }

    @Override
    public void removeMin() {//buscamos el min del arbol y lo eliminamos 
        removeElement(findMin(raiz).getHashtag());
    }

    @Override
    public void removeMax() {//buscamos el max y lo eliminamos
        removeElement(findMax(raiz).getHashtag());
    }

    @Override
    public void removeAllElements() {//eliminamos todo el arbol, eliminamos la raiz en bucle hasta que no haya raiz
        removeElement(raiz.getHashtag());
        if (raiz != null) {
            removeAllElements();
        }
    }

    @Override
    public NodoAVL recorridoizq(NodoAVL inicio) {// recorrido a la izq usado en el remove para llegar al minimo del hijo derecho del elemento a eliminar
        if (inicio.getIzquierda() != null) {//si no es null el hijo izquierdo nos movemos a la izq
            return recorridoizq(inicio.getIzquierda());
        } else {
            return inicio;
        }
    }

    @Override
    public String toString() {//parte que mas me costo junto al remove
        String s = "";
        s = imprimirBucle(raiz);

        return s;
    }

    @Override
    public String imprimirBucle(NodoAVL raiz) {// imprimimos con un bucle el arbol sin tener atriburo padre
        String s = "";
        if (raiz == null) {
            s = "arbol vacio";
        } else {
            if (raiz == this.raiz) {
                s = raiz.getHashtag() + "\n";
                s += "Padre= null" + "\n";
                if (raiz.getIzquierda() != null) {
                    s += "Hijo Izquierdo =" + raiz.getIzquierda().getHashtag() + "\n";
                } else {
                    s += "Hijo Izquierdo = null\n";
                }
                if (raiz.getDerecha() != null) {
                    s += "Hijo derecho =" + raiz.getDerecha().getHashtag() + "\n";
                } else {
                    s += "Hijo derecho = null\n";
                }
                s += "factor equilibrio= " + getFe(raiz) + "\n\n";

            }
            if (raiz.getIzquierda() != null) {
                s += raiz.getIzquierda().getHashtag() + "\n";
                s += "Padre= " + raiz.getHashtag() + "\n";
                if (raiz.getIzquierda().getIzquierda() != null) {
                    s += "Hijo Izquierdo =" + raiz.getIzquierda().getIzquierda().getHashtag() + "\n";
                } else {
                    s += "Hijo Izquierdo = null \n";
                }
                if (raiz.getIzquierda().getDerecha() != null) {
                    s += "Hijo derecho =" + raiz.getIzquierda().getDerecha().getHashtag() + "\n";
                } else {
                    s += "Hijo derecho = null \n";
                }
                s += "factor equilibrio= " + getFe(raiz.getIzquierda()) + "\n\n";
            }
            if (raiz.getDerecha() != null) {
                s += raiz.getDerecha().getHashtag() + "\n";
                s += "Padre= " + raiz.getHashtag() + "\n";
                if (raiz.getDerecha().getIzquierda() != null) {
                    s += "Hijo Izquierdo =" + raiz.getDerecha().getIzquierda().getHashtag() + "\n";
                } else {
                    s += "Hijo Izquierdo = null\n";
                }
                if (raiz.getDerecha().getDerecha() != null) {
                    s += "Hijo derecho =" + raiz.getDerecha().getDerecha().getHashtag() + "\n";
                } else {
                    s += "Hijo derecho = null\n";
                }
                s += "factor equilibrio= " + getFe(raiz.getDerecha()) + "\n\n";

            }
            if (raiz.getIzquierda() != null) {
                s += imprimirBucle(raiz.getIzquierda());
            }
            if (raiz.getDerecha() != null) {
                s += imprimirBucle(raiz.getDerecha());
            }
        }
        return s;

    }
}
