/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionalex;

import java.util.Scanner;

/**
 *
 * @author anshenoy
 */
public class WatchMovie {

    public static void main(String args[]) {
        
        Scanner s=new Scanner(System.in);
        System.out.println("Digite el precio");
        int precio=s.nextInt();
        System.out.println("Digite la calificación de la película.");
        int clasificacion=s.nextInt();
        
        String resultado= precio>=12 && clasificacion==5 ?"Me interesa ver la película.":"No me interesa ver la película.";
        System.out.println(resultado);
        /*
        if(precio>=12 && clasificacion==5){
            System.out.println("Me interesa ver la película.");
        }else{
            System.out.println("No me interesa ver la película.");
        }*/

    }
}
