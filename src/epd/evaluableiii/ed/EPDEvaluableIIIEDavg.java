package epd.evaluableiii.ed;

import java.io.*;

public class EPDEvaluableIIIEDavg {

    public static void main(String[] args) {
        AVLTree arbolTwitter = new AVLTree(null);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("D:\\GIISI\\Segundo\\ED\\EPD\\hashtag.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {// introduce todos los hastag en el arbol 
                arbolTwitter.addElement(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(arbolTwitter.toString());

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("D:\\GIISI\\Segundo\\ED\\EPD\\tweets.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                int indice1 = 0;
                int indice2 = 0;
                String hashtag;
                int salto = linea.length();
                int inicio = 0;
                while ((indice2 < salto+1) && indice1 != -1) {//bucle buscando los hastag 
                    indice1 = linea.indexOf("#", inicio);
                    if( indice1 != -1){
                    indice2 = linea.indexOf(" ", indice1);
                    if (indice2 == -1 ) {
                        indice2 = salto;
                    }
                    hashtag = linea.substring(indice1, indice2);
                    NodoAVL nodo = arbolTwitter.find(hashtag, arbolTwitter.getRaiz());//buscamos el hastag en el arbol
                    if (nodo != null) {// si encontramos el hastag 
                        nodo.addTweets(linea);// añadimos el tweet 
                    }
                    }
                    inicio = indice2;
                    indice2++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        arbolTwitter.find("#navidad", arbolTwitter.getRaiz()).getTweets();
        arbolTwitter.find("#giisi", arbolTwitter.getRaiz()).getTweets();
        arbolTwitter.find("#trabajo", arbolTwitter.getRaiz()).getTweets();

    }

}
