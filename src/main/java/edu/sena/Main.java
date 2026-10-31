package edu.sena;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.net.httpserver.HttpServer;
import edu.sena.util.Respuestas;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * API Droguería Las Rebajas.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV03
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),
                0
        );

        /*
         * API Usuarios
         */

        server.createContext(
                "/usuarios",
                exchange -> {

                    String respuesta =
                            Respuestas.USUARIO;

                    exchange.sendResponseHeaders(
                            200,
                            respuesta.length()
                    );

                    exchange.getResponseBody()
                            .write(respuesta.getBytes());

                    exchange.close();

                }
        );

        /*
         * API Productos
         */

        server.createContext(
                "/productos",
                exchange -> {

                    String respuesta =
                            Respuestas.PRODUCTO;

                    exchange.sendResponseHeaders(
                            200,
                            respuesta.length()
                    );

                    exchange.getResponseBody()
                            .write(respuesta.getBytes());

                    exchange.close();

                }
        );

        /*
         * API Ventas
         */

        server.createContext(
                "/ventas",
                exchange -> {

                    String respuesta =
                            Respuestas.VENTA;

                    exchange.sendResponseHeaders(
                            200,
                            respuesta.length()
                    );

                    exchange.getResponseBody()
                            .write(respuesta.getBytes());

                    exchange.close();

                }
        );

        server.start();

        System.out.println(
                "API Droguería Las Rebajas iniciada en puerto 8080"
        );

    }

}