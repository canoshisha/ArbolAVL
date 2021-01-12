
package epd.evaluableiii.ed;

public class NodoAVL implements INodoAVL{
private String hashtag;//hastag
private int altura;//altura
private NodoAVL izquierda;//hijo izq
private NodoAVL Derecha;//hijo derecha
private LinkedList<String> tweets;//lista de tweets

    public NodoAVL(String hashtag) {//inicializamos los atributos
        this.hashtag = hashtag;
        this.altura=0;
        this.izquierda = null;
        this.Derecha = null;
        this.tweets = new LinkedList<>();
        
    }
   
@Override
    public String getHashtag() {//obtenemos el hastag
        return hashtag;
    }

@Override
    public void setHashtag(String hashtag) {//introducimos el hastag
        this.hashtag = hashtag;
    }

@Override
    public int getAltura() {//obtenemos la altura
        return altura;
    }

@Override
    public void setAltura(int altura) {//introducimos la altura
        this.altura = altura;
    }

@Override
    public NodoAVL getIzquierda() {//obtenemos hijo izq
        return izquierda;
    }

@Override
    public void setIzquierda(NodoAVL izquierda) {//introducimos hijo izq
        this.izquierda = izquierda;
    }

@Override
    public NodoAVL getDerecha() {//obtenemos hijo derecha
        return Derecha;
    }

@Override
    public void setDerecha(NodoAVL Derecha) {//introducimos hijo derecho
        this.Derecha = Derecha;
    }

@Override
    public void getTweets() {// imprimimos la lista de tweets
         if(tweets.size() == 0) {
            System.out.println("No hay ningún tweets con este Hashtag");
        } else {
             System.out.println("Hashtag = " + hashtag);
            for (int i = 0; i < tweets.size(); i++) {
                System.out.println(tweets.getElement(i));
            }
             System.out.println("\n");
        }
    }

@Override
    public boolean addTweets(String tweet) {//añadir tweet a la lista
        return tweets.addFront(tweet);
    }

}
