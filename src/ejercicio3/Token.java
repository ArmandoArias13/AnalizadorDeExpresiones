/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;
public class Token {
    
    public String valor;
    public Tipos tipo;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    enum Tipos{
        NUMERO ("[0-9]+"),
        OPERADOR ("[*|/|+|-]"),
        CONSTANTE("[pi|e]"),
        VARIABLE("[wxyz]"),
        DESCONOCIDO ("[^0-9|[pi|e]|wxyz|[*|/|+|-])]+");
        
        public final String patron;
        
        Tipos(String s){
            this.patron = s;
        
        }//Cierra constructor Tipos
    }//Cierra enum Tipos
    
}
