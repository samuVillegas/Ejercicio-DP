/**
 * Ejercicio realizado por:
 *  Julian Andres Ramirez Jimenez
 *  Samuel David Villegas Bedoya
 * Longest Palindrome
 */
import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;


public class Main{
    static Map<String,Integer> datesCurrent = new HashMap<String,Integer>();

    public static void main(String []args){
        input();
    }

    public static void input(){
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine().split(" ")[0]);
        String[] cases = new String[t];
        
        for(int i = 0;i<t;i++){
            cases[i] = input.nextLine().split(" ")[0];
        }

        for(int i = 0;i<t;i++){
            System.out.println(resolveAux(cases[i], 0, cases[i].length()-1));
            datesCurrent.clear();
        }
        
    }

    public static int resolveAux(String cad, int lim_inf, int lim_sup){
        if(cad.isEmpty() || lim_sup<lim_inf )return 0;
        if(lim_sup==lim_inf) return 1;
        
        String actualCadena = cad.substring(lim_inf,lim_sup+1);
        
       //DP
        if(datesCurrent.containsKey(actualCadena)){
            return datesCurrent.get(actualCadena); 
        }
        
        if(actualCadena.charAt(0)==actualCadena.charAt(actualCadena.length()-1)){
            int res = 2 + resolveAux(cad, lim_inf+1, lim_sup-1);
            datesCurrent.put(actualCadena, res);
            return res;
        } 
        else {
            int res = Math.max(resolveAux(cad, lim_inf+1, lim_sup),resolveAux(cad, lim_inf, lim_sup-1));
            datesCurrent.put(actualCadena, res);
            return res;
        } 
    }
}