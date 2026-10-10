/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
  

    public class bin {

        public static void proyectoFinal() {

            Scanner consola = new Scanner(System.in);
            //Ventas finales    
            int totalVentas = 0;
            //Total de productos que se vendieron 
            int totalProductosVendidos = 0;
            //Cantidad total de dinero que se adquirio al final de la venta realizada
            double dineroTotalVendido = 0.0;
            int ventasEfectivo = 0;
            int ventasTarjeta = 0;
            int ventasTransferencia = 0;
            double dineroEfectivo = 0;
            double dineroTarjeta = 0;
            double dineroTransferencia = 0;
            double ventaMayor = 0;
            double ventaMenor = 0;
            int opcionMenu = 0;
            double abonoFaltante = 0;

            do {

                System.out.println("====================================================================================================================================================================================");
                System.out.println("                                                                ==============================================");
                System.out.println("                                                                |                  WELCOME                   |");
                System.out.println("                                                                ==============================================");
                System.out.println("                                                                |               MENU PRINCIPAL               |");
                System.out.println("                                                                ______________________________________________");
                System.out.println(" ");
                System.out.println("                                                                            Selecione una opcion: ");
                System.out.println(" ");
                System.out.println("                                                                |==========1. Registrar una venta ===========|");
                System.out.println("                                                                |============= 2. Consultar caja ============|");
                System.out.println("                                                                |========= 3. Mostrar estadisticas ==========|");
                System.out.println("                                                                |================= 4. Salir =================|");
                opcionMenu = consola.nextInt();

                //System.out.print(String.format("\033[2J"));
                //    System.out.flush();  
                switch (opcionMenu) {

                    case 1:

                    
                        System.out.println("\n Ha seleccionado Registrar una venta");

                        int productosC = 0;

                        while (productosC <= 0) {

                            System.out.println("\n Ingrese la cantidad de productos a registrar: ");
                            productosC = consola.nextInt();
                            consola.nextLine();

                            if (productosC <= 0) {

                                System.out.println("La cantidad debe ser mayor a cero");

                            }

                        }
                        
                        double subtotalVentaActual = 0.0;
                        int totalProductosVentaActual = 0;

                        for (int i = 0; i < productosC; i++) {
                            System.out.println("\n Producto No. " + (i + 1));
                        

                        System.out.print("Ingrese el codigo del producto: ");
                        String codigo = consola.nextLine(); 

                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreProducto = consola.nextLine();

                        double precio = 0.0;
                        
                        while (precio <= 0) {
                            System.out.print("Ingrese el precio del producto Q. ");
                            precio = consola.nextDouble();
                            if (precio <= 0) {
                                System.out.println("No valido, el precio debe ser mayor a 0");
                            }
                        }
                        

                        int cantidad = 0;
                        while (cantidad <= 0) {
                            System.out.print("Ingrese la cantidad del producto: ");
                            cantidad = consola.nextInt();
                            if (cantidad <= 0) {
                                System.out.println("No valido, la cantidad debe ser mayor a cero.");
                            }
                        }
                        consola.nextLine();

                       double subtotalProducto = precio * cantidad;
                         
                        subtotalVentaActual += subtotalProducto;
                        totalProductosVentaActual += cantidad;
                        
                        
                        
                        }

                double porcentajeDescuento = 0.0;
                if (subtotalVentaActual < 200) {
                         porcentajeDescuento = 0.0;
                    } else if (subtotalVentaActual >= 200 && subtotalVentaActual <= 499.99) {
                         porcentajeDescuento = 0.05;
                    } else if (subtotalVentaActual >= 500 && subtotalVentaActual <= 999.99) {
                         porcentajeDescuento = 0.08;
                    } else if (subtotalVentaActual >= 1000) {
                         porcentajeDescuento = 0.10;
                }

                double montoDescuento = subtotalVentaActual * porcentajeDescuento;
                double montoConDescuento = subtotalVentaActual - montoDescuento;
                double iva = montoConDescuento * 0.12;
                double totalFactura = montoConDescuento + iva;
                 
                        
                System.out.println("\n El subtotal es de:  Q. " + subtotalVentaActual);
                System.out.println(" El total es de :      Q. " + totalFactura);
                
                int formaPago = 0;
                while (formaPago < 1 || formaPago > 3) {
                    System.out.println("\nFormas de pago disponibles:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Transferencia");
                    System.out.print("Seleccione la forma de pago: ");
                    formaPago = consola.nextInt();
                    if (formaPago < 1 || formaPago > 3) {
                        System.out.println("No valido, opcion de pago no disponible.");
                    }
                }
                consola.nextLine();

                double efectivoRecibido = 0.0;
                double cambio = 0.0;
                String textoFormaPago = "";

                switch (formaPago) {
                    case 1:
                        textoFormaPago = "Efectivo";
  
                        while (efectivoRecibido < totalFactura) {
                            
                            System.out.print("Monto a pagar: Q. " + totalFactura );
                            System.out.println("\n Ingrese el efectivo recibido: Q. ");
                            efectivoRecibido = consola.nextDouble();
                            
                            while (efectivoRecibido < totalFactura) {
                                System.out.println("Cantidad de efectivo insuficiente, aun queda un saldo restante de : Q" + (totalFactura - efectivoRecibido));
                                abonoFaltante = consola.nextDouble();
                                
                                efectivoRecibido = efectivoRecibido + abonoFaltante;
                            }
                        }
                        consola.nextLine();
                        cambio = efectivoRecibido - totalFactura;

                        ventasEfectivo++;
                        dineroEfectivo += totalFactura;
                        break;

                    case 2:
                        textoFormaPago = "Tarjeta";
                        ventasTarjeta++;
                        dineroTarjeta += totalFactura;
                        break;

                    case 3:
                        textoFormaPago = "Transferencia";
                        ventasTransferencia++;
                        dineroTransferencia += totalFactura;
                        break;
                }

        
                System.out.println("\n          Resumen de la compra            ");
                
                System.out.println("Cantidad de productos: " + totalProductosVentaActual);
                System.out.printf("Subtotal:               Q%.2f\n", subtotalVentaActual);
                System.out.printf("Descuento aplicado:     Q%.2f (%.0f%%)\n", montoDescuento, (porcentajeDescuento * 100));
                System.out.printf("IVA :                   Q%.2f\n", iva);
                        System.out.println(" ");
                System.out.printf("Total:                  Q%.2f\n", totalFactura);
                System.out.println("Forma de pago:            " + textoFormaPago);
                if (formaPago == 1) {
                    System.out.printf("Efectivo recibido:  Q%.2f\n", efectivoRecibido);
                    System.out.printf("Cambio:             Q%.2f\n", cambio);
                }
                

                totalVentas++;
                totalProductosVendidos += totalProductosVentaActual;
                dineroTotalVendido += totalFactura;

                if (totalVentas == 1) {
                    ventaMayor = totalFactura;
                    ventaMenor = totalFactura;
                } else {
                    if (totalFactura > ventaMayor) {
                        ventaMayor = totalFactura;
                    }
                    if (totalFactura < ventaMenor) {
                        ventaMenor = totalFactura;
                    }
                }
                break;

                                case 2: 
                    
                    
                    System.out.println("\n           Consultar caja            ");
              
                    System.out.println(" Ventas realizadas: " + totalVentas);
                    System.out.println(" Productos vendidos: " + totalProductosVendidos);
                    System.out.printf(" Total vendido en caja: Q.%.2f ", dineroTotalVendido);
                   
                    System.out.printf("\n Ventas en Efectivo:      %d (Q%.2f)\n", ventasEfectivo, dineroEfectivo);
                    System.out.printf(" Ventas con Tarjeta:       %d (Q%.2f)\n", ventasTarjeta, dineroTarjeta);
                    System.out.printf(" Ventas por Transferencia: %d (Q%.2f)\n", ventasTransferencia, dineroTransferencia);
                    
           
                    break;
                    
                case 3:
                    System.out.println("\n");
                    System.out.println("             Estadisticas               ");
                  
                    
                    if (totalVentas == 0) {
                        
                        System.out.println("No existen ventas registradas.");
                        
                    } else {
                        
                        double promedioDinero = dineroTotalVendido / totalVentas;
                        System.out.println("\n Numero total de ventas: " + totalVentas);
                        System.out.println(" Total de productos vendidos:\n " + totalProductosVendidos);
                        System.out.printf(" Total de dinero vendido: Q.%.2f\n ", dineroTotalVendido);
                        System.out.printf(" Promedio de dinero por venta: Q.%.2f\n ", promedioDinero);
                        System.out.println(" Cantidad de ventas por cada forma de pago:\n");
                        System.out.println("    - Efectivo: " + ventasEfectivo);
                        System.out.println("    - Tarjeta: " + ventasTarjeta);
                        System.out.println("    - Transferencia: " + ventasTransferencia);
                        System.out.printf(" Venta mayor: Q%.2f \n", ventaMayor);
                        System.out.printf(" Venta menor: Q%.2f ", ventaMenor);
                    }
                    
                    break;
               
                
            case 4:    
         
            
              System.out.flush();
                System.out.println("Saliendo...");

                
                        
            default:
                
                System.out.println("Opcion no valida");
                
                    
                }
                }while(opcionMenu != 4);
                    
                }
                   
                }
    
        
    








