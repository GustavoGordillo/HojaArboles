/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja8;

/**
 *
 * @author Jose
 */
import java.util.Hashtable;

public class hashtable implements WordSet {
    Hashtable<String, String> treeMap = new Hashtable<String, String>();
    public boolean valor;
   
    public void add(Word objeto) {
        treeMap.put(objeto.getWord(),objeto.getType());
    }

    public Word get(Word pal) {
        treeMap.containsValue(pal.getWord());
        valor=treeMap.containsKey(pal.getWord());
        if(valor==true){
            Word palabra=new Word();
            palabra.setWord(pal.getWord());
            palabra.setType(treeMap.get(pal.getWord()));
            return palabra;
        }else{
            return null;
        }
      }
}