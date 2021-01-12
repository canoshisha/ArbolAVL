
package epd.evaluableiii.ed;


public interface INodoAVL {
   public String getHashtag() ;

    public void setHashtag(String hashtag) ;

    public int getAltura() ;

    public void setAltura(int altura) ;

    public NodoAVL getIzquierda() ;

    public void setIzquierda(NodoAVL izquierda);

    public NodoAVL getDerecha();

    public void setDerecha(NodoAVL Derecha);

    public void getTweets();

    public boolean addTweets(String tweet);
}
