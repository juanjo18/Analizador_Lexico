package code;
import java.util.*;
import java.io.*;

public class Reserved_Words 
{
    private Hashtable<String, String> reservedWords = new Hashtable<String, String>();

    public Reserved_Words()
    {
        this.init();
    }

    /**
     * Separa las lineas por ","
     * @param word es la line que va a separar
     */
    private void split(String line) 
    {
        String words[];
        line = line.replaceAll("\\s","");
        words = line.split(",");
        reservedWords.put(words[0], words[1]);
    }
    

    /**
     * Lee el archivo de las palabras, pero para cargar el archivo tienes que cambiar
     * la variable ruta, por la ruta de tu computadora
     */
    public void init() 
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String ruta = "C:/Users/Juanjo Hernandez/Documents/Compiladores/Analizador_Lexico/src/code/words.txt";
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null)
            {
                split(linea);
                //System.out.println(linea);
            }            
                

        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    /**
     * Verifica si la palabra esta en la tabla
     * @param word es la palabra que se buscara 
     * @return verdadero si esta la palabra y falso en otro caso
     */
    public boolean checkReservedWord(String word) 
    {
        return ((reservedWords.containsValue(word)));
    }

    /**
     * Solo muestra los valores de la tabla
     * si se desea ver las llaves, se cambia elements() por keys()
     */
    public void showReservedWords() 
    {
        if(!reservedWords.isEmpty()){
            Enumeration<String> data = reservedWords.elements();
            while (data.hasMoreElements()) {
                System.out.println("" + "hashtable valores: " + data.nextElement());
            }
        }
        else
        System.out.println("No hay palabras reservadas");
        
    }

    public Hashtable<String, String> getReservedWord(){ return this.reservedWords;}

    public static void main(String[] args) 
    {
        Reserved_Words pw = new Reserved_Words();
        System.out.println(pw.checkReservedWord("juan"));
    }
}
