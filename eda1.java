
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class eda1{
  public static void main(String args[]){
    Stack<String> tablero=new Stack<String>(); 
  
    int[] punMov= jugar(tablero);
    System.out.println("Puntos: "+punMov[0]);
    System.out.println("Tablero (de abajo-arriba): "+tablero.toString());
    System.out.println("Movimientos: "+punMov[1]);//
 
  }
  public static Stack<String> inviertePila(Stack<String> pilaNormal){
		
		Stack<String> pilaInvertida= new Stack<String> ();
		
		while(!pilaNormal.isEmpty()){
			
			pilaInvertida.push(pilaNormal.pop());
		}
		
		return pilaInvertida;
		
	}

  private static int [] jugar(Stack<String> tablero){
	    Scanner scan=null;
	    boolean seguir=true;
	    String forma,linea;
	    String color="";
	    String formaTab="";
	    int puntos=0;
	    int movimientos=0;

	    try {
	      File f=new File("p1.txt");
	      scan=new Scanner(f);
	    } catch (FileNotFoundException e) {
	      System.out.println("Fichero no encontrado");
	      seguir=false;
	    }
	    if(seguir) {
	    while(scan.hasNext()) {
	      linea=scan.next();
	      StringTokenizer token = new StringTokenizer (linea,";");
	      forma=token.nextToken();
	      if(token.hasMoreTokens()) {
	      color=token.nextToken();
	      }
	      
	     
	      if(forma.equals("square")) {
	    	  if(tablero.isEmpty()) {
	    	  
	    	  
	    		  tablero.push(color);
		          ++movimientos;
		         
	    	  }else {
	    		  formaTab=tablero.peek();
	    		  
	    	  if(color.equals(formaTab)) {
	    		  
	    		  switch(color) {
	    		  case "red":
	    			  puntos+=2;
	    			  break;
	    		  case "blue":
	    			  puntos+=4;
	    			  break;
	    		  case "green":
	    			  puntos+=6;
	    			  break;
	    		  case "yellow":
	    			  puntos+=8;
	    			  break;
	    		  case "pink":
	    			  puntos+=10;
	    			  break;
	    		  }
	              tablero.pop();
	              ++movimientos;
	            } else {
	            	
	              tablero.push(color);
	              ++movimientos;
	          }
	    	    
	    	  }
	      }else {
	    	  if(color.equals("star")){
		    	  inviertePila(tablero);
		    	  ++movimientos;
		    	  
		      }
	      }
	      
	      }
	    }
	  
	 int [] punMov = {puntos,movimientos}; 
	    return punMov;
	  }
 
}
