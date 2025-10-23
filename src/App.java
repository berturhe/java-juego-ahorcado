import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);
        
        String entrada = "";
        int numeroMaxValidacion = 3;

        int limite = 4;

        String palabraElegida = "";
        String palabraOculta ="";
        String letrasAcumuladas = "";

        String[] palabras = {"manzana","lapicero","cuaderno","camioneta","impresora"};
        

        if(palabraElegida.length() == 0){
            palabraElegida = palabras[(int)(Math.random()*(palabras.length))];
            palabraOculta = palabraElegida.replaceAll("[^ ]", "-");
        }
       
        System.out.println("¡Bienvenido al juego del ahorcado!");
        System.out.printf("Palabra oculta: %s (%d letras)%n%n", palabraOculta, palabraElegida.length());

        while(limite>0){ 
            while(numeroMaxValidacion>0){
                System.out.print("ingrese una letra: ");

                entrada = (scanner.nextLine()).toLowerCase();
                if(entrada.length() == 1){
                    numeroMaxValidacion = 3;
                    break;
                }else{
                    numeroMaxValidacion--;
                    if(numeroMaxValidacion>0){                        
                        System.out.printf("Advertencia: Debe ingresar una sola letra. Intentos restantes: %d%n", numeroMaxValidacion);
                    }else{
                        System.out.println("Error: Se agotaron los intentos de validación. Fin del juego.");
                        System.exit(0);
                    }                  
                }
            }

            if(!palabraElegida.contains(entrada)){
                limite--;
                System.out.println("letra ingresada Incorrecta");
            }else{
                System.out.println("✓ Letra correcta");
                System.out.println("Letras acertadas: " + entrada);
                letrasAcumuladas+=entrada;        
                palabraOculta = palabraElegida.replaceAll("[^"+letrasAcumuladas+"]", "-");
            }
            
            System.out.printf("Intentos restantes: %d%n", limite);
            System.out.println("palabraOculta: "+palabraOculta+"\n");
            if(!palabraOculta.contains("-")){
                break;
            } 
       }

       System.out.println(limite > 0 ? "¡Felicidades! Ganaste 🎉" : "Perdiste 😞");
       System.out.println("La palabra era: " + palabraElegida);
       
       scanner.close();

    }
}
