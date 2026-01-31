import java.util.Scanner;

public class App {

    static int seleccion;
    static Scanner sc = new Scanner(System.in);
    static String nombreProducto;
    static double precioUnitario;
    static int cantidadInventario;
    public static void main(String[] args) throws Exception {
        mostrarMenu();

        seleccion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        if(seleccion ==1){
            registrarProducto();
        }else if(seleccion ==2){
            mostrarInfoProducto();}
        
        System.out.println("Gracias por usar el sistema de gestión de productos.");

        sc.close();

    }
    



    static void mostrarMenu() {
        var opciones = """
            --- Sistema de Gestión de Productos ---

            1. Registrar nuevo producto
            2. Mostrar información del producto actual
            3. Calcular valor total del inventario
            4. Mostrar resumen completo del producto
            5. Limpiar datos del producto actual
            0. Salir
            Ingrese su opción:
                """;

        System.out.print(opciones);
    }

    static void registrarProducto() {// Lógica para registrar un nuevo producto
        if (nombreProducto != null) {
            System.out.println("Ya hay un producto registrado. Por favor, limpie los datos antes de registrar uno nuevo.");
        }
        System.out.print("Ingrese el nombre del producto: ");
        nombreProducto = sc.nextLine();
        if (nombreProducto.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío. Por favor, ingrese un nombre válido.");
            nombreProducto = sc.nextLine();
        }
        System.out.print("Ingrese el precio unitario del producto: ");
        precioUnitario = sc.nextDouble();
        if(precioUnitario < 0){
            System.out.println("El precio unitario no puede ser negativo. Por favor, ingrese un valor válido.");
            precioUnitario = sc.nextDouble();
        }
        System.out.print("Ingrese la cantidad en inventario del producto: ");
        cantidadInventario = sc.nextInt();
        if(cantidadInventario < 0){
            System.out.println("La cantidad en inventario no puede ser negativa. Por favor, ingrese un valor válido.");
            cantidadInventario = sc.nextInt();
        }
        sc.nextLine(); // Limpiar el buffer
    }


    static void mostrarInfoProducto() {
        if (nombreProducto == null) {
            System.out.println("No hay ningún producto registrado.");
        } else {
            System.out.println("Nombre del producto: " + nombreProducto);
            System.out.println("Precio unitario: " + precioUnitario);
            System.out.println("Cantidad en inventario: " + cantidadInventario);
        }
    }

    
}
