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
public class SplayTre implements WordSet {

    private Nodo root;   // root of the BST

    public Word get(Word word) {
        root = splay(root, word.getWord());
        long valor = toAscii(word.getWord());
		long valor1 = toAscii(root.getValor());
        long cmp = valor1-valor;
        if (cmp == 0) 
        {
            return word;
        }
        else          return null;
    }    
	
    public void add (Word wordObject) {
        // splay key to root
        if (root == null) {
            root = new Nodo(wordObject.getWord(),wordObject.getType());
            return;
        }
        
        root = splay(root, wordObject.getWord());

		long valor = toAscii(wordObject.getWord());
		long valor1 = toAscii(root.getValor());
        long cmp = valor1-valor;
        
        // Insert new node at root
        if (cmp < 0) {
            Nodo n = new Nodo(wordObject.getWord(),wordObject.getType());
            n.izq = root.izq;
            n.der = root;
            root.izq = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Nodo n = new Nodo(wordObject.getWord(),wordObject.getType());
            n.der = root.der;
            n.izq = root;
            root.der = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the palabra
        else if (cmp == 0) {
            root.palabra = root.palabra;
        }

    }
    
    
   
    private Nodo splay(Nodo h, String word) {
        if (h == null) return null;

		long valor = toAscii(word);
		long valor1 = toAscii(h.getValor());
        long cmp1 = valor1-valor;
		
        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.izq == null) {
                return h;
            }
            valor = toAscii(word);
		valor1 = toAscii(h.izq.getValor());
		long cmp2 = valor1-valor;
			
            if (cmp2 < 0) {
                h.izq.izq = splay(h.izq.izq, word);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.izq.der = splay(h.izq.der, word);
                if (h.izq.der != null)
                    h.izq = rotateLeft(h.izq);
            }
            
            if (h.izq == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // key not in tree, so we're done
            if (h.der == null) {
                return h;
            }

			 valor = toAscii(word);
			 valor1 = toAscii(h.der.getValor());
			long cmp2 = valor1-valor;
			
            if (cmp2 < 0) {
                h.der.izq  = splay(h.der.izq, word);
                if (h.der.izq != null)
                    h.izq = rotateRight(h.der);
            }
            else if (cmp2 > 0) {
                h.der.der = splay(h.der.der, word);
                h = rotateLeft(h);
            }
            
            if (h.der == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }



    
    // right rotate
    private Nodo rotateRight(Nodo h) {
        Nodo x = h.izq;
        h.izq = x.der;
        x.der = h;
        return x;
    }

    // left rotate
    private Nodo rotateLeft(Nodo h) {
        Nodo x = h.der;
        h.der = x.izq;
        x.izq = h;
        return x;
    }

	public int toAscii(String s){
        
        int total=0;
        int ascii;
        int largo=s.length();
        for(int i=0;i< largo;i++)
        {
        ascii = s.toCharArray()[i];
        total=total+ascii;
        }
        return total;

    }

}
