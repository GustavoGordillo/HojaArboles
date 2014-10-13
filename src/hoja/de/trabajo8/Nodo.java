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
public class Nodo {
    
public String palabra;            
        public String tipo;        
        public Nodo izq, der;   

        public Nodo(String palabra, String tipo) {
            this.tipo   = tipo;
            this.palabra = palabra;
        }
		 public String getValor()
		{
		return palabra;
		}	
		 
		
    }

