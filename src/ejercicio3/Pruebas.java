
package ejercicio3;
        
import ejercicio3.Token.Tipos; //impotacion del enum Tipo
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pruebas {
    
    public static void main(String[] args) {
        
       lexicoUI interfazLexico = new lexicoUI();
        
       interfazLexico.setVisible(true);

        
        String entrada = "11 + 22 - w - 33 * x - pi * e % A";
        
        ArrayList<Token> tokens = lex(entrada);
        
        Token enumerador = new Token();
        
        
        int Numeros = 0;
        int Operador = 0;
        int cons = 0;
        int var = 0;
        int desc = 0;
 
        
        for (Token token : tokens) {
            System.out.println(token.getTipo()+ " : " + token.getValor());
           
            
            if (token.getTipo() == enumerador.tipo.NUMERO) {
                Numeros++;
            }else if (token.getTipo() == enumerador.tipo.OPERADOR) {
                Operador++;
            }else if (token.getTipo() == enumerador.tipo.CONSTANTE) {
                cons++;
            }else if (token.getTipo() == enumerador.tipo.VARIABLE) {
                var++;
            }else if (token.getTipo() == enumerador.tipo.DESCONOCIDO) {
                desc++;
            }
           
        }
        
        System.out.println(" \n" 
                + Numeros + " NUMEROS\n" 
                + Operador +" OPERADORES\n"
                + cons + " CONSTANTE\n" 
                + var +" VARIABLES\n"
                + desc +" DESCONOCIDOS\n");
        
    }
    
    public static ArrayList<Token> lex(String entrada){
    
        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(entrada );
        
        while (st.hasMoreTokens()) {  
            String palabra = st.nextToken();
            boolean bandera = false;
            
            for (Tipos tokenTipo : Tipos.values()) {// se llama a enum para compararla con token
                Pattern patron = Pattern.compile(tokenTipo.patron);//aqui solo se le asigna el aptron a seguir y por el cual se debe guiar  
                Matcher busqueda = patron.matcher(palabra);
                
         if (busqueda.find()) {
         Token token = new Token();
                    
         token.setTipo(tokenTipo);
         token.setValor(palabra);
         tokens.add(token);
         bandera = true;
                    
         }//Cierra la llave del if
                
        }// Cierra la llave del for
        if (!bandera) {
        throw new RuntimeException("Token Invalido");
        }
        }// Cierra la llave del while
        
        return tokens;
    }//cierra la llave del ArrayList
            
    
}