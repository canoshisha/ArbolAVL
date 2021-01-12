package epd.evaluableiii.ed;
public interface ILinkedList<E> {
//añade un elemento en posición index, desplaza los siguientes
void add(E newElement, int index) throws IndexOutOfBoundsException;
//añade un elemento al final
void addEnd(E newElement);
//añade un elemento al principio
boolean addFront(E newElement);
//devuelve el elemento en posición index
E getElement(int index) throws IndexOutOfBoundsException;
boolean isEmpty();
//borra elemento en posición index
void remove(Object index) throws IndexOutOfBoundsException;
//borra último elemento
void removeEnd();
//borra primer elemento
void removeFront();
int size();
//imprime la lista desde el principio
@Override
String toString();
//busca un elemento
boolean find(E element);
 public Node<E> getFirstNode();
}
