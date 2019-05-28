//import ventanas.listas;
import ventanas.principal;



public class main {

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    public static void main(String[] args) {
        String cadena = "14:48";
        String [] datos = new String[5];
        int minutos = 0;
        int segundos = 0;
        
        for(int i=0; i<=cadena.length(); i++) {
            datos[i] = "sa";
            System.out.println("El valor es " + datos[i]);
        
        } 
        System.out.println("El string tiene " + cadena.length() + " caracterres");
        
        int numero;

        if (isNumeric(cadena) == true) {
            numero = Integer.parseInt(cadena);
            System.out.println("Numero: " + numero);
        } else {
            System.out.println("No es un numero");
        }
        
        //principal princ = new principal();
        //princ.setVisible(true);
        //princ.setLocationRelativeTo(null);
    }
    
}
