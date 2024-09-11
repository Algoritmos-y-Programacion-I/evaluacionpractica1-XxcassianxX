package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */

    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }
    /**
         * Descripción: Este método solicita al usuario el precio y la cantidad vendida para cada referencia de producto.
        * pre: Los arreglos `precios` y `unidades` deben estar inicializados y tener el tamaño adecuado.
        * pos: Los arreglos `precios` y `unidades` quedan llenos con los valores proporcionados por el usuario.
    */

    public static void solicitarDatos(){
        
        for( int i = 0; i<precios.length; i++){

            System.out.println("Ingrese el precio del producto : ");
            precios[i] = reader.nextDouble();
            System.out.println("Ingrese la cantidad vendida del producto : ");
            unidades[i] = reader.nextInt();

        }
    }
    /**
        * Descripción: Calcula el total de unidades vendidas sumando las cantidades de todas las referencias.
        * pre: El arreglo `unidades` debe estar inicializado y contener las cantidades de productos vendidas.
        * pos: Devuelve la suma total de todas las unidades vendidas en el día.
        * @return El total de unidades vendidas.
    */

    public static int calcularTotalUnidadesVendidas(){

       int TotalVendida = 0;

       for (double  cantidad : unidades){
        TotalVendida += cantidad;
       }

        return TotalVendida;

    }
    /**
        * Descripción: Calcula el precio promedio de las referencias de producto vendidas.
        * pre: El arreglo `precios` debe estar inicializado y contener los precios de las referencias.
        * pos: Devuelve el promedio de los precios de las referencias de productos vendidas.
        * @return El precio promedio de los productos vendidos.
    */

    public static double calcularPrecioPromedio(){

        double sumaPrecios = 0;

        for(double precio : precios){

            sumaPrecios += precio;
        }
        return sumaPrecios/precios.length;

    }
    /**
        * Descripción: Calcula el total de dinero recaudado multiplicando los precios por las cantidades de cada referencia vendida.
        * pre: Los arreglos `precios` y `unidades` deben estar inicializados y tener el mismo tamaño.
        * pos: Devuelve la suma total del dinero recaudado en el día por las ventas.
        * @return El total de ventas en dinero.
     */

    public static double calcularVentasTotales(){

        double VentasTotales = 0;

        for(int i = 0; i<precios.length; i++){

            VentasTotales += precios[i]*unidades[i];

        }
        return VentasTotales;

    }
    
    /**
        * Descripción: Consulta cuántas referencias superan un límite mínimo de ventas proporcionado por el usuario.
        * pre: Los arreglos `precios` y `unidades` deben estar inicializados y tener el mismo tamaño.
        * pre: El parámetro `limite` debe ser mayor o igual a cero.
        * pos: Devuelve el número de referencias cuyos ingresos totales (precio * cantidad) son mayores o iguales al límite.
        * @param limite El límite mínimo de ventas a considerar.
        * @return El número de referencias que superan el límite de ventas.
    */
    public static int consultarReferenciasSobreLimite(double limite){

        int referenciaSobreLimite = 0;

        for(int i = 0; i<precios.length; i++){

            if(precios[i]*unidades[i] >= limite){

                referenciaSobreLimite++;
            }



        }
        return referenciaSobreLimite;

    }

}

