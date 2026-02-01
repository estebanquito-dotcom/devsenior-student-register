import java.util.Scanner;

public class App {

    //variables declaradas de forma global.
    static int seleccion;
    static Scanner sc = new Scanner(System.in);
    static String nombreProducto;
    static double precioUnitario;
    static int cantidadInventario;
    static double costeInventario;
    static String estadoproducto;

    //funcion principal control de flujo del programa.
    public static void main(String[] args) throws Exception {
        //mostra menu de opciones.

        do {
            mostrarMenu(args);
            seleccion = sc.nextInt();
            sc.nextLine(); //limpiar buffer

            switch (seleccion) {
                case 1 -> registrarProducto();
                case 2 -> mostrarInfo();
                case 3 -> valorInventario();
                case 4 -> resumenCompleto();
                case 5 -> limpiarDatos();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> {System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
                }
            }

            
        } while (seleccion != 0);


        sc.close();  

    }


    //funcion mostrar el menu de opciones.
    public static void mostrarMenu(String[] args) {

        var opciones = """

            --- Sistema de Gestión de Productos ---

            1. Registrar nuevo producto
            2. Mostrar información del producto actual
            3. Calcular valor total del inventario
            4. Mostrar resumen completo del producto
            5. Limpiar datos del producto actual
            0. Salir

            Ingrese su opción:""";

        System.out.println(opciones);
        
    }
    //funcion registrar un nuevo producto.
    public static void registrarProducto() {

        //verificar si ya existe un producto registrado.
        if(nombreProducto != null) {
            System.out.println("Ya existe un producto registrado. Por favor, desea sobreescribirlo? (s/n)");
            String respuesta = sc.nextLine();
            if(!respuesta.equalsIgnoreCase("s")) {
                return; //salir de la funcion sin registrar un nuevo producto.
            }
        }
        //si no hay un producto leido, solicitar datos del producto.
        do{System.out.println("Ingrese el nombre del producto:");
        nombreProducto = sc.nextLine();
        //validar nombre del producto
        }while(!validarnombre(nombreProducto));

        do{System.out.println("Ingrese el precio unitario del producto:");
        precioUnitario = sc.nextDouble();
        }while(!validarPrecio(precioUnitario));


        do{System.out.println("Ingrese la cantidad en inventario:");
        cantidadInventario = sc.nextInt();

        sc.nextLine(); //limpiar buffer

        }while(!validarCantidad(cantidadInventario));



            
        

    }
    //funcion mostrar informacion del producto registrado.
    public static void mostrarInfo(){

        if(nombreProducto == null) {
            System.out.println("No hay datos de producto registrado.");
            return;
        }

        var info = """
            --- Información del Producto ---

            Nombre del producto: %s
            Precio unitario: %.2f
            Cantidad en inventario: %d
            """.formatted(nombreProducto, precioUnitario, cantidadInventario);
        System.out.println(info);
    }
    //funcion calcular valor total del inventario.
    public static double valorInventario(){
        if (nombreProducto == null) {
            System.out.println("No hay datos de producto registrados.");
            return 0;
        }
        costeInventario = precioUnitario * cantidadInventario;
        return costeInventario;
    }
    //funcion mostrar resumen completo del producto.
    public static void resumenCompleto(){
        if (nombreProducto==null) {
            System.out.println("No hay datos de producto registrado.");
            return;
        }
        
        if (cantidadInventario < 5) {
            estadoproducto = "Stock Bajo";
        } else if (cantidadInventario >= 20) {
            estadoproducto = "Stock Alto";
        } else 
            estadoproducto = "Stock suficiente";
        


        var resumen = """
            --- Resumen Completo del Producto ---

            Nombre del producto: %s
            Precio unitario: %.2f
            Cantidad en inventario: %d
            Estado del producto: %s
            Valor total del inventario: %.2f
            """.formatted(nombreProducto, precioUnitario, cantidadInventario, estadoproducto, valorInventario() );
            System.out.println(resumen);
    }  
    //funcion limpiar datos del producto actual.
    public static void limpiarDatos(){
        nombreProducto = null;
        precioUnitario = 0;
        cantidadInventario = 0;
        costeInventario = 0;
        estadoproducto = null;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }
    //funciones de validacion de datos.
    public static boolean validarPrecio(double precio) {
        if (precio < 0) {
            System.out.println("El precio unitario no puede ser negativo. Por favor, ingrese un valor válido.");
            return false;
        }
        return true;
    }
    public static boolean validarCantidad(int cantidad) {
        if (cantidad < 0) {
            System.out.println("La cantidad en inventario no puede ser negativa. Por favor, ingrese un valor válido.");
            return false;
        }
        return true;
    }
    public static boolean validarnombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío. Por favor, ingrese un valor válido.");
            return false;
        }
        return true;
  
    }

}
    


