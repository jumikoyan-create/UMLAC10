package co.edu.poli.contexto3.vista;

import co.edu.poli.contexto3.modelo.*;
import co.edu.poli.contexto3.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto3.servicios.Quimico;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

       // Cientifico c1 = new Cientifico();
        //Cientifico c2 = new Cientifico("Ana", "C01", "F");

        //Quimico q1 = new Quimico("Luis", "Q01", "M");
        //try {
          //  q1.setEspecializacion("Quimica espacial");
        //} catch (IllegalArgumentException e) {
          //  System.out.println("Error especialización: " + e.getMessage());
      //  }

        //try {
          //  Cientifico.setSueldo(5000);
        //} catch (IllegalArgumentException e) {
          //  System.out.println("Error sueldo: " + e.getMessage());
        //}

//        Cientifico cientifico1 = new Cientifico("Carlos", "C02", "M");
  //      Cientifico cientifico2 = new Cientifico("Maria", "C03", "F");

    //    try {
      //      Quimico.setUniforme("Blanco");
        //} catch (IllegalArgumentException e) {
          //  System.out.println("Error uniforme: " + e.getMessage());
        //}

        //Quimico q2 = new Quimico("Ana", "Q02", "F");

        //Muestra muestra1 = new Muestra("M01", "Roca lunar");
        //Muestra muestra2 = new Muestra("M02", "Polvo marciano");

       // Persona[] personaa = new Persona[5];
        //personaa[0] = new Cientifico("carlos", "c01", "F");
        //personaa[1] = new Quimico("ana", "Q02", "F");
        //personaa[2] = new Astronauta("Juan", "J01", "F");
        //personaa[3] = new Cientifico("Maria", "C03", "F");
        //personaa[4] = new Quimico("Luis", "Q01", "M");
        //for (Persona p : personaa) {
          //  if (p != null) {
            //}
        //}

       // Persona nueva = crearPersona();

        Scanner sc = new Scanner(System.in);
        ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
        int opcion;

        do {
            System.out.println("\n------ MENU -----");
            System.out.println("1. CREAR");
            System.out.println("2. LISTAR");
            System.out.println("3. ACTUALIZAR");
            System.out.println("4. ELIMINAR");
            System.out.println("5. BUSCAR");
            System.out.println("6. GUARDAR (serializar)");
            System.out.println("7. CARGAR (Deserializar)");
            System.out.println("8. SALIR");
            System.out.println("Opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido");
                opcion = 0;
            }
            switch (opcion) {
                case 1: {
                    try {
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("sexo:(M/F) ");
                        String sexo = sc.nextLine();
                        crud.crear(new Cientifico(nombre, id, sexo));
                    } catch (Exception e) {
                        System.out.println("Error al crear: " + e.getMessage());
                    }
                    break;
                }

                case 2:
                    try {
                        crud.listar();
                    } catch (Exception e) {
                        System.out.println("Error al listar: " + e.getMessage());
                    }
                    break;

                case 3: {
                    try {
                        System.out.print("Id a actualizar: ");
                        String id = sc.nextLine();
                        System.out.println("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Nuevo genero: (M/F)");
                        String sexo = sc.nextLine();
                        crud.actualizar(id, new Cientifico(nombre, id, sexo));
                    } catch (Exception e) {
                        System.out.println("Error al actualizar: " + e.getMessage());
                    }
                    break;
                }

                case 4: {
                    try {
                        System.out.print("ID a eliminar: ");
                        String id = sc.nextLine();
                        crud.eliminar(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar: " + e.getMessage());
                    }
                    break;
                }

                case 5: {
                    try {
                        System.out.print("ID a buscar: ");
                        String id = sc.nextLine();
                        System.out.print(crud.leer(id));
                    } catch (Exception e) {
                        System.out.println("Error al buscar: " + e.getMessage());
                    }
                    break;
                }

                case 6: {
                    try {
                        System.out.println(crud.serializar(crud.getPersonas(), "", "personas.dat"));
                    } catch (Exception e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                    break;
                }

                case 7: {
                    try {
                        Persona[] datos = crud.deserializar("", "personas.dat");
                        if (datos != null) {
                            crud.setPersonas(datos);
                            System.out.println("datos cargados completamente");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al cargar: " + e.getMessage());
                    }
                    break;
                }

                case 8:
                    System.out.println("saliendo...");
                    break;

                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (opcion != 8);
        sc.close();
    }

   // public static void mostrarPersona(Persona p) {
     //   System.out.println("Persona recibida" + p);
    //}

    //public static Persona crearPersona() {
      //  return new Quimico("Carlos", "c01", "F");
    //}
}