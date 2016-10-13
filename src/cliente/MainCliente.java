package cliente;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainCliente {

    public static void main(String args[]) throws IOException {

        String host;
        int puerto;

        System.out.println("CLIENTE DE CHAT POR CONSOLA:\n");

        System.out.println("Ingrese la IP o Nombre del Servidor a conectarse: ");

        Scanner scCliente = new Scanner(new InputStreamReader(System.in));
        host = scCliente.nextLine();
        
        System.out.println("Ingrese el puerto del servidor a conectar: ");

        scCliente = new Scanner(new InputStreamReader(System.in));
        puerto = scCliente.nextInt();
       

        Cliente cliente = new Cliente(host, puerto);

        System.out.println("Ingrese su nombre de usuario: ");
  
        scCliente = new Scanner(new InputStreamReader(System.in));
        cliente.setNombre(scCliente.nextLine());
        
        System.out.println("\n(Ingrese salir para cerrar la aplicacion)\n");

        HiloCliente threadCliente = new HiloCliente(cliente.getSocket());
        threadCliente.start();
        
        cliente.enviarMensaje();
        cliente.cerrarCliente();
    }
}