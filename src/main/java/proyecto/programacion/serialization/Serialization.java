package proyecto.programacion.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que demuestra el uso de Serializable y operaciones con archivos
 */
public class Serialization {

    // Constantes para los nombres de archivos
    private static final String SERIALIZED_FILE = "Datos.ser";
    private static final String TEXT_FILE = "Datos.txt";

    public static void main(String[] args) {
        // Crear y procesar la lista de datos combinados
        List<Interfaz> datos_combinados = new ArrayList<>();
        datos_combinados.addAll(createSamplePeople());
        datos_combinados.addAll(createSampleMaestros());
        datos_combinados.addAll(createSampleEstudiantes());

        try {
            processDatosCombinados(datos_combinados);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Person> createSamplePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan Pérez", 25, "Estilista"));
        people.add(new Person("María García", 30, "Militar"));
        return people;
    }

    private static List<Maestro> createSampleMaestros() {
        List<Maestro> maestros = new ArrayList<>();
        maestros.add(new Maestro("John Beltran", 28, "Economia"));
        maestros.add(new Maestro("Ricardo Duran", 35, "Mecanica de solidos"));
        return maestros;
    }

    private static List<Estudiante> createSampleEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan Gutierrez", 23, "Ingenieria Economica"));
        estudiantes.add(new Estudiante("Natalia Gomez", 21, "Derecho"));
        return estudiantes;
    }

    private static void processDatosCombinados(List<Interfaz> datosCombinados) throws IOException, ClassNotFoundException {
        System.out.println("=== Proceso de Serialización ===");
        serializeObjects(datosCombinados, SERIALIZED_FILE);

        System.out.println("\n=== Proceso de Deserialización ===");
        List<Interfaz> deserialized = deserializeObjects(SERIALIZED_FILE);
        for (Interfaz obj : deserialized) {
            System.out.println(obj);
        }

        System.out.println("\n=== Escritura en Archivo de Texto ===");
        writeToFile(datosCombinados, TEXT_FILE);

        System.out.println("\n=== Lectura desde Archivo de Texto ===");
        readFromFile(TEXT_FILE);
    }

    private static <T extends Serializable> void serializeObjects(List<T> data, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println("Objetos serializados exitosamente en " + filename);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> deserializeObjects(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        }
    }

    private static <T> void writeToFile(List<T> list, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (T item : list) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Archivo de texto creado exitosamente: " + filename);
        }
    }

    private static void readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contenido del archivo:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}