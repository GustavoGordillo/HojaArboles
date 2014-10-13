/*
UVG
Algoritmos y Estructuras de Datos - 2011
Hoja de trabajo 7 
Autor: Eduardo Castellanos

Descripci�n: WordSetFactory. Clase  utilizada para instanciar los diferentes tipos de sets. 
*/
package hoja8;

class WordSetFactory implements WordSet{
	
	// Metodo que genera un objeto que implementa WordSet
	// parametro tipo: 1 = SimpleSet
	//                         2 = implementado con Red black tree
	//                         3 = implementado con Splay Tree
	//                         4 = implementado con Hash Table
	//                         5 = implementado con TreeMap (de Java Collection Framework)
	
	public static WordSet generateSet(int tipo)
	{
	    if (tipo == 1)
		    return new SimpleSet();
		else
                
                // aqui se regresara el set empleando sus implementaciones:
			// if tipo == 2 cree una instancia para un Wordset implementao con Red Black Tree
			// if tipo == 3 cree una instancia para un Wordset implementado con Splay Tree
			// if tipo == 4 cree una instancia para un Wordset implementado con Hash table
			// if tipo == 5 cree una instancia para un Wordset implementado con TreeMap
                
                    if(tipo == 2){
                        return new Blackredtree(); // modificarlo para que regrese la implementacion seleccionada
                    }
                    if(tipo == 3){
                        return new SplayTre(); // modificarlo para que regrese la implementacion seleccionada
                    }
                    if(tipo == 4){
                        return new hashtable(); // modificarlo para que regrese la implementacion seleccionada
                    }
                    if(tipo == 5){
                        return new MapadeArbol(); // modificarlo para que regrese la implementacion seleccionada
                    }
		    
			
		return null; // modificarlo para que regrese la implementacion seleccionada	
	}

    @Override
    public void add(Word wordObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Word get(Word word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
}