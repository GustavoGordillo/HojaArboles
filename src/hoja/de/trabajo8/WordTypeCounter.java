/*
UVG
Algoritmos y Estructuras de Datos - 2011
Hoja de trabajo 7
Autor: Eduardo Castellanos

Descripci�n: Programa principal. 
*/

package hoja8;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class WordTypeCounter {
	public static void main(String[] args) throws Exception
	{
		if(5 > 1)
		{
			// Declaraci�n e inicializaci�n de variables.
                        int implementacion = 0;
			// el primer parametro indica el nombre del archivo con las definiciones de las palabras
			File wordFile = new File("words.txt");
			
			// el segundo parametro indica el nombre del archivo que tiene el texto a analizar
			File textFile = new File("text.txt");
			
			// el tercer parametro sirve para seleccionar la implementacion que se usara para
			// guardar el conjunto de palabras. Use el valor 1 para indicar que se empleara
			// la implementacion SimpleSet que acompa�a esta tarea.
			// Para el resto de implementaciones: 
			//  2 Red Black Tree
			//  3 Splay Tree
			//  4 Hash Table
			//  5 TreeMap (de java collection framework)
                        String menu = "1. SimpleSet\n2. Black Red Tree\n3. SplayTree\n4. HashTable\n5. TreeMap\n6. Salir";
                        Scanner scan = new Scanner(System.in);
                        int opc = 0;
                                                
                        while (opc != 6){
                            System.out.println(menu + "\nOpción: ");
                            opc = scan.nextInt();
                            switch (opc){
                                case 1:
                                    implementacion = Integer.parseInt("1");
                                    break;
                                case 2: //BubbleSort
                                     implementacion = Integer.parseInt("2");
                                    break;
                                case 3:
                                     implementacion = Integer.parseInt("3");
                                    break;
                                case 4:
                                     implementacion = Integer.parseInt("4");
                                    break;
                                case 5:
                                     implementacion = Integer.parseInt("5");
                                    break;                                
                                    
                            }
                            
                        if(opc != 6){
                            
                        
			
			
			BufferedReader wordreader;
			BufferedReader textreader;
			
			int verbs=0;
			int nouns=0;
			int adjectives=0;
			int adverbs=0;
			int gerunds=0;
			
			long starttime;
			long endtime;
			
			// Verificar que los dos parámetros que se pasaron sean archivos que existen
			if(wordFile.isFile() && textFile.isFile()) {
				// Leer archivos
				try
				{
					wordreader = new BufferedReader(new FileReader(wordFile));
					textreader = new BufferedReader(new FileReader(textFile));
				}
				catch (Exception ex)
				{
					System.out.println("Error al leer!");
					return;
				}

				// Crear un WordSet para almacenar la lista de palabras
				// se selecciona la implementacion de acuerdo al tercer parametro pasado en la linea
				// de comando
				// =====================================================
				WordSet words =  WordSetFactory.generateSet(implementacion);
				// =====================================================
				
				String line = null;
				String[] wordParts;
				
				// leer el archivo que contiene las palabras y cargarlo al WordSet.
				starttime = System.currentTimeMillis();
				line = wordreader.readLine();
				while(line!=null)
				{
					wordParts = line.split("\\.");  // lo que esta entre comillas es una expresión regular.
					if(wordParts.length == 2)
					{
						words.add(new Word(wordParts[0].trim(),wordParts[1].trim()));
					}
					line = wordreader.readLine();
				}
				wordreader.close();
				endtime = System.currentTimeMillis();
				
				System.out.println("Palabras cargadas en " + (endtime-starttime) + " ms.");
				
				// Procesar archivo de texto
				starttime = System.currentTimeMillis();
				line = textreader.readLine();
				String[] textParts;
				Word currentword;
				Word lookupword = new Word();
				
				while(line!=null)
				{
					// Separar todas las palabras en la línea.
					textParts = line.split("[^\\w-]+"); // utilizar de separador cualquier caracter que no sea una letra, número o guión.
					
					// Revisar cada palabra y verificar de que tipo es. 
					for(int i=0;i<textParts.length;i++)
					{
						lookupword.setWord(textParts[i].trim().toLowerCase());
						currentword = words.get(lookupword);
						if(currentword != null)
						{
							if(currentword.getType().equals("v-d") || currentword.getType().equals("v") || currentword.getType().equals("q"))
								verbs++;
							else if(currentword.getType().equals("g") )
								gerunds++;
							else if(currentword.getType().equals("a-s") || currentword.getType().equals("a-c") || currentword.getType().equals("a"))
								adjectives++;
							else if(currentword.getType().equals("e"))
								adverbs++;
							else 
								nouns++;
						}
					}
					
					line = textreader.readLine();
				}
				textreader.close();
				endtime = System.currentTimeMillis();
				System.out.println("Texto analizado en " + (endtime-starttime) + " ms.");
				
				// Presentar estadísticas
				System.out.println("El texto tiene:");
				System.out.println(verbs + " verbos");
				System.out.println(nouns + " sustantivos");
				System.out.println(adjectives + " adjetivos");
				System.out.println(adverbs + " adverbios");
				System.out.println(gerunds + " gerundios");
				
			}
			else
			{
				System.out.println("No encuentro los archivos :'( ");
			}
                 }
               }
            }   
      }
}