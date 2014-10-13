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
public class Nodo2 {
    
public String palabra;            
        public String tipo;        
        public Nodo2 izq, der;   
        public boolean color;
        public Nodo2(String palabra, String tipo,boolean color) {
            this.tipo   = tipo;
            this.color=color;
            this.palabra = palabra;
        }
		 public String getValor()
		{
		return palabra;
		}	
		 
		
    }
