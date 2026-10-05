package com.example.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.Conexion.DataBaseConnection;
import com.example.Exepciones.ExceptionUser;
import com.example.Objetos.DAOdealership;
import com.example.Objetos.Dealership;

public class App {
    static Scanner sc = new Scanner(System.in);
    static DAOdealership daoDealer;

    public static void main(String[] args) {

        if (Conexion()) {
            String opcion = null;
            do {
                menu();
                System.out.print("Introduce operación: ");
                opcion = sc.nextLine();
                switch (opcion) {
                    case "1":
                        accionAñadir();
                        break;
                    case "2":
                        eliminarDealer();
                        break;
                    case "3":
                        accionListar();
                        break;
                    case "4":
                        actualizarDealer();
                        break;
                    case "5":
                        accionBuscar();
                        break;
                    case "0":
                        System.out.println("Programa cerrado...");
                        break;
                    default:
                        System.out.println("Opción inválida intentelo de nuevo");
                        break;
                }
            } while (!(opcion.equals("0")));
        }
    }

    private static boolean Conexion() {
        while (true) {
            try {
                System.out.print("Introduce usuario: ");
                String user = sc.nextLine();
                System.out.print("Introduce contraseña: ");
                String password = sc.nextLine();
                DataBaseConnection db = new DataBaseConnection(user, password);
                Connection conec = db.getConec();
                daoDealer = new DAOdealership(conec);
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ExceptionUser j) {
                System.out.println(j.getMessage());
            } catch (ClassNotFoundException s) {
                System.out.println(s.getMessage());
            }
        }
    }

    private static void menu() {
        System.out.println("\n=== MENU PRINCIPAL === \n" +
                "1. Añadir Dealership \n" +
                "2. Eliminar Dealership \n" +
                "3. Listar Dealerships \n" +
                "4. Actualizar Dealership \n" +
                "5. Buscar Dealership \n" +
                "0. Salir");
    }

    private static void accionAñadir() {
        String opcion = null;
        String validar = null;
        do {
            System.out.println("\n === MENU AÑADIR ====\n" +
                    "1. Añadir dealership simple \n" +
                    "2. Añadir dealerships complejo\n" +
                    "3. Retroceder al menu principal");
            System.out.print("Introduce la acción: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    añadirDealerSimple();
                    break;
                case "2":
                    añadirDealerComplejo();
                    break;
                case "3":
                    System.out.print("Press 'ENTER' para confirmar o cualquier tecla + ' ENTER ' para retroceder");
                    validar = sc.nextLine();
                    if (!validar.equals("")) {
                        System.out.println("Opción inválida");
                    }
                    break;
                default:
                    System.out.println("Opción inválida, vuelve a intentarlo");
                    break;
            }
        } while (!(opcion.equals("3") && validar.equals("")));
    }

    private static void añadirDealerSimple() {
        try {
            System.out.print("Introduce código Distrinet: ");
            String code = sc.nextLine();

            System.out.print("Introduce nombre del concesionario: ");
            String name = sc.nextLine();

            System.out.print("Introduce Google Calendar ID: ");
            String calendar = sc.nextLine();
            Dealership d = new Dealership(code, name, calendar);
            boolean insertado = daoDealer.añadirDealerShipSimple(d);

            if (insertado) {
                System.out.println("Dealership guardado");
            } else {
                System.out.println("Dealerships ya en la base de datos");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser j) {
            System.out.println(j.getMessage());
        } catch (Exception E) {
            System.out.println("Error inesperado");
        }

    }

    private static void añadirDealerComplejo() {
        System.out.println("\n--- AÑADIR CONCESIONARIO COMPLEJO ---");

        try {
            System.out.print("Introduce código Distrinet (Obligatorio): ");
            String distrinetCode = sc.nextLine();

            System.out.print("Introduce código OR: ");
            String orCode = sc.nextLine();

            System.out.print("Introduce nombre del concesionario (Obligatorio): ");
            String name = sc.nextLine();

            System.out.print("Introduce descripción: ");
            String description = sc.nextLine();

            System.out.print("Introduce Google Calendar ID (Obligatorio): ");
            String deliveryGoogleCalendarId = sc.nextLine();

            System.out.print("Introduce alias: ");
            String alias = sc.nextLine();

            System.out.print("Introduce dirección completa: ");
            String fullAddress = sc.nextLine();

            System.out.print("Introduce ubicación (ciudad/zona): ");
            String location = sc.nextLine();

            System.out.print("Introduce teléfono principal: ");
            String phone = sc.nextLine();

            System.out.print("Introduce URL de Google Maps: ");
            String gmapsUrl = sc.nextLine();

            System.out.print("Introduce horario de apertura 1: ");
            String schedule1 = sc.nextLine();

            System.out.print("Introduce horario de apertura 2: ");
            String schedule2 = sc.nextLine();

            System.out.print("Introduce teléfono de mecánica: ");
            String mechanicsPhone = sc.nextLine();

            System.out.print("Introduce horario de mecánica 1: ");
            String mechanicsSchedule1 = sc.nextLine();

            System.out.print("Introduce horario de mecánica 2: ");
            String mechanicsSchedule2 = sc.nextLine();

            System.out.print("Introduce teléfono de carrocería: ");
            String bodyworkPhone = sc.nextLine();

            System.out.print("Introduce horario de carrocería 1: ");
            String bodyworkSchedule1 = sc.nextLine();

            System.out.print("Introduce horario de carrocería 2: ");
            String bodyworkSchedule2 = sc.nextLine();

            System.out.print("Introduce información de Renault Minute: ");
            String renaultMinute = sc.nextLine();

            System.out.print("Introduce información extra: ");
            String extra = sc.nextLine();

            System.out.print("¿Mostrar información de Emils? (si/no): ");
            String respuestaEmils = sc.nextLine().toLowerCase();
            Boolean isShownEmilsInfo;
            if (respuestaEmils.equalsIgnoreCase("si")) {
                isShownEmilsInfo = true;
            } else if (respuestaEmils.equalsIgnoreCase("no")) {
                isShownEmilsInfo = false;
            } else {
                System.out.println("Opción no válida. Se asignará 'no' por defecto.");
                isShownEmilsInfo = false;
            }

            java.time.LocalDateTime ahora = java.time.LocalDateTime.now();

            Dealership nuevoDealer = new Dealership(
                    distrinetCode, orCode, name, description, deliveryGoogleCalendarId, alias,
                    fullAddress, location, phone, gmapsUrl, schedule1, schedule2, mechanicsPhone,
                    mechanicsSchedule1, mechanicsSchedule2, bodyworkPhone, bodyworkSchedule1, bodyworkSchedule2,
                    renaultMinute, extra, isShownEmilsInfo, ahora, ahora);

            boolean insertado = daoDealer.crearComplejo(nuevoDealer);

            if (insertado) {
                System.out.println("Dealership creado con éxito");
            } else {
                System.out.println("No se pudo añadir el dealership con ese distrinet ya existe");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser j) {
            System.out.println(j.getMessage());
        } catch (Exception E) {
            System.out.println("Error inesperado");
        }
    }

    private static void eliminarDealer() {
        try {
            System.out.print("Introduce el código Distrinet del concesionario a eliminar: ");
            String code = sc.nextLine();

            boolean eliminado = daoDealer.eliminar(code);

            if (eliminado) {
                System.out.println("Concesionario eliminado con éxito");
            } else {
                System.out
                        .println("No se pudo eliminar, el código Distrinet no existe en el sistema.Inténtelo de nuevo");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception E) {
            System.out.println("Error inesperado");
        }
    }

    private static void accionListar() {
        String opcion = null;
        String validar = null;
        do {
            System.out.println("\n === MENU LISTAR ====\n" +
                    "1. Listar dealership simple \n" +
                    "2. Listar dealerships complejo\n" +
                    "3. Retroceder al menu principal");
            System.out.print("Introduce la acción: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    listarDealerSimple();
                    break;
                case "2":
                    listarDealerComplejo();
                    break;
                case "3":
                    System.out.print("Press 'ENTER' para confirmar o cualquier tecla + ' ENTER ' para retroceder");
                    validar = sc.nextLine();
                    if (!validar.equals("")) {
                        System.out.println("Opción inválida");
                    }
                    break;
                default:
                    System.out.println("Opción inválida, vuelve a intentarlo");
                    break;
            }
        } while (!(opcion.equals("3") && validar.equals("")));
    }

    private static void listarDealerSimple() {
        try {
            ArrayList<Dealership> lista = daoDealer.listarSimple();

            if (lista.isEmpty()) {
                System.out.println("No hay ningún dealerships registrado en la Base de Datos");
            } else {
                System.out.println("Se han encontrado " + lista.size() + " concesionarios:\n");

                for (Dealership d : lista) {
                    System.out.println(d.toSimpleString());
                    System.out.println("------------------------------------------------");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    private static void listarDealerComplejo() {
        try {

            ArrayList<Dealership> lista = daoDealer.listarComplejo();

            if (lista.isEmpty()) {
                System.out.println(" No hay ningún concesionario registrado en la Base de Datos.");
            } else {
                System.out.println("Se han encontrado " + lista.size() + " dealerships:\n");

                for (Dealership d : lista) {
                    System.out.println(d.toString());
                    System.out.println("--------------------------------------------------------");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    private static void actualizarDealer() {
        try {
            System.out.print("Introduce el código Distrinet del dealera modificar: ");
            String code = sc.nextLine();

            Dealership dActual = daoDealer.buscarDealerComplejo(code);

            if (dActual == null) {
                System.out.println("Este dealership o existe");
            } else {
                System.out.println("Si pulsas ENTER sin escribir nada, se conservará el valor antiguo\n");

                System.out.print("Antiguo OrCode: " + dActual.getOrCode() + ", Nuevo: ");
                String orCode = sc.nextLine();
                if (orCode.trim().isEmpty())
                    orCode = dActual.getOrCode();

                System.out.print("Antiguo Nombre: " + dActual.getName() + ", Nuevo: ");
                String name = sc.nextLine();
                if (name.trim().isEmpty())
                    name = dActual.getName();

                System.out.print("Antigua Descripción: " + dActual.getDescription() + ", Nuevo: ");
                String desc = sc.nextLine();
                if (desc.trim().isEmpty())
                    desc = dActual.getDescription();

                System.out.print("Antiguo ID Google Calendar: " + dActual.getDeliveryGoogleCalendarId() + ", Nuevo: ");
                String calendarId = sc.nextLine();
                if (calendarId.trim().isEmpty())
                    calendarId = dActual.getDeliveryGoogleCalendarId();

                System.out.print("Antiguo Alias: " + dActual.getAlias() + ", Nuevo: ");
                String alias = sc.nextLine();
                if (alias.trim().isEmpty())
                    alias = dActual.getAlias();

                System.out.print("Antigua Dirección Completa: " + dActual.getFullAddress() + ", Nuevo: ");
                String address = sc.nextLine();
                if (address.trim().isEmpty())
                    address = dActual.getFullAddress();

                System.out.print("Antigua Ubicación: " + dActual.getLocation() + ", Nuevo: ");
                String loc = sc.nextLine();
                if (loc.trim().isEmpty())
                    loc = dActual.getLocation();

                System.out.print("Antiguo Teléfono: " + dActual.getPhone() + ", Nuevo: ");
                String phone = sc.nextLine();
                if (phone.trim().isEmpty())
                    phone = dActual.getPhone();

                System.out.print("Antigua URL Google Maps: " + dActual.getGmapsUrl() + ", Nuevo: ");
                String gmaps = sc.nextLine();
                if (gmaps.trim().isEmpty())
                    gmaps = dActual.getGmapsUrl();

                System.out.print("Antiguo Horario 1: " + dActual.getSchedule1() + ", Nuevo: ");
                String sch1 = sc.nextLine();
                if (sch1.trim().isEmpty())
                    sch1 = dActual.getSchedule1();

                System.out.print("Antiguo Horario 2: " + dActual.getSchedule2() + ", Nuevo: ");
                String sch2 = sc.nextLine();
                if (sch2.trim().isEmpty())
                    sch2 = dActual.getSchedule2();

                System.out.print("Antiguo Teléfono Mecánica: " + dActual.getMechanicsPhone() + ", Nuevo: ");
                String mPhone = sc.nextLine();
                if (mPhone.trim().isEmpty())
                    mPhone = dActual.getMechanicsPhone();

                System.out.print("Antiguo Horario Mecánica 1: " + dActual.getMechanicsSchedule1() + ", Nuevo: ");
                String mSch1 = sc.nextLine();
                if (mSch1.trim().isEmpty())
                    mSch1 = dActual.getMechanicsSchedule1();

                System.out.print("Antiguo Horario Mecánica 2: " + dActual.getMechanicsSchedule2() + ", Nuevo: ");
                String mSch2 = sc.nextLine();
                if (mSch2.trim().isEmpty())
                    mSch2 = dActual.getMechanicsSchedule2();

                System.out.print("Antiguo Teléfono Carrocería: " + dActual.getBodyworkPhone() + ", Nuevo: ");
                String bPhone = sc.nextLine();
                if (bPhone.trim().isEmpty())
                    bPhone = dActual.getBodyworkPhone();

                System.out.print("Antiguo Horario Carrocería 1: " + dActual.getBodyworkSchedule1() + ", Nuevo: ");
                String bSch1 = sc.nextLine();
                if (bSch1.trim().isEmpty())
                    bSch1 = dActual.getBodyworkSchedule1();

                System.out.print("Antiguo Horario Carrocería 2: " + dActual.getBodyworkSchedule2() + ", Nuevo: ");
                String bSch2 = sc.nextLine();
                if (bSch2.trim().isEmpty())
                    bSch2 = dActual.getBodyworkSchedule2();

                System.out.print("Antiguo Renault Minute: " + dActual.getRenaultMinute() + ", Nuevo: ");
                String rMinute = sc.nextLine();
                if (rMinute.trim().isEmpty())
                    rMinute = dActual.getRenaultMinute();

                System.out.print("Antigua Información Extra: " + dActual.getExtra() + ", Nuevo: ");
                String extra = sc.nextLine();
                if (extra.trim().isEmpty())
                    extra = dActual.getExtra();

                System.out.print("Antiguo Mostrar Info Emils: " + (dActual.getIsShownEmilsInfo() ? "Si" : "No")
                        + ", Nuevo (Si/No): ");
                String emilsInput = sc.nextLine().trim();

                boolean emilsInfo = dActual.getIsShownEmilsInfo();
                if (emilsInput.equalsIgnoreCase("Si"))
                    emilsInfo = true;
                if (emilsInput.equalsIgnoreCase("No"))
                    emilsInfo = false;

                Dealership dModificado = new Dealership(
                        code, orCode, name, desc, calendarId, alias, address, loc, phone, gmaps,
                        sch1, sch2, mPhone, mSch1, mSch2, bPhone, bSch1, bSch2, rMinute, extra,
                        emilsInfo, dActual.getCreatedAt(), java.time.LocalDateTime.now());

                boolean actualizado = daoDealer.modificarComplejo(dModificado);

                if (actualizado) {
                    System.out.println("\nConcesionario actualizado correctamente.");
                } else {
                    System.out.println("\nNo se pudo actualizar el concesionario.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    private static void accionBuscar() {
        String opcion = null;
        String validar = null;
        do {
            System.out.println("\n === MENU BUSCAR ====\n" +
                    "1. Buscar dealership simple \n" +
                    "2. Buscar dealerships complejo\n" +
                    "3. Retroceder al menu principal");
            System.out.print("Introduce la acción: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    buscarDealerSimple();
                    break;
                case "2":
                    buscarDealerComplejo();
                    break;
                case "3":
                    System.out.print("Press 'ENTER' para confirmar o cualquier tecla + ' ENTER ' para retroceder");
                    validar = sc.nextLine();
                    if (!validar.equals("")) {
                        System.out.println("Opción inválida");
                    }
                    break;
                default:
                    System.out.println("Opción inválida, vuelve a intentarlo");
                    break;
            }
        } while (!(opcion.equals("3") && validar.equals("")));
    }

    private static void buscarDealerSimple() {
        Dealership d = null;
        try {
            System.out.print("Introduce el código Distrinet del concesionario a buscar: ");
            String code = sc.nextLine();
            d = daoDealer.buscarDealerSimple(code);
            if (d == null) {
                System.out.println("Dealer no encontrado");
            } else {
                System.out.println(d.toSimpleString());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(" Error inesperado");
        }

    }

    private static void buscarDealerComplejo() {
        Dealership d = null;
        try {
            System.out.print("Introduce el código Distrinet del concesionario a buscar (Modo Completo): ");
            String code = sc.nextLine();

            d = daoDealer.buscarDealerComplejo(code);
            if (d == null) {
                System.out.println("Dealer no encontrado");
            } else {
                System.out.println("\n"+d.toString());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExceptionUser e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

}
