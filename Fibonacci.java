public class Fibonacci{


    public static int fibonacciCola(int n){
        return fibonacciColaAux(n,0,1);
    }
       // Versión recursiva de la cola de Fibonacci
    public static int fibonacciColaAux(int n, int primero, int segundo){
        if(n == 0) {
            return primero;
        }else{
            return fibonacciColaAux(n-1, segundo, primero + segundo);
        }
    }

    public static int fibonacciRecursivo(int n){
        if(n<2){return n;}
        else return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }

    public static void main(String args[]){
        System.out.println("Recursiion normal");
        for(int i = 0; i < 100; i++){
            long t2 = System.currentTimeMillis();
             fibonacciRecursivo(i);
            long t = System.currentTimeMillis()-t2;
            System.out.println(t);
        }
        System.out.println("Recursion de cola");
        for(int i = 0; i < 100; i++){
            long t2 = System.currentTimeMillis();
             fibonacciCola(i);
            long t = System.currentTimeMillis()-t2;
            System.out.println(t);
        }
    }
}