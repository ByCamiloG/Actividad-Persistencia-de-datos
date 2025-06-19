/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.programacion.serialization;
import java.io.Serializable;

/**
 * Clase Person que implementa la interfaz Serializable
 * Esta clase demuestra cómo hacer que un objeto sea serializable en Java
 */
public class Maestro implements Interfaz {
    // SerialVersionUID para control de versiones
    private static final long serialVersionUID = 1L;
    
    // Atributos de la clase
    private String name;
    private int age;
    private String materia; //Materia que dicta el maestro
    
    /**
     * Constructor de la clase Person
     * @param name Nombre de la persona
     * @param age Edad de la persona
     * @param materia Dirección de la persona
     */
    public Maestro(String name, int age, String materia) {
        this.name = name;
        this.age = age;
        this.materia = materia;
    }
    
    // Getters y Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getMateria() {
        return materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    /**
     * Método toString para mostrar la información de la persona
     */
    @Override
    public String toString() {
       return getClass().getSimpleName() +
                " Nombre = '" + name +  '\'' +
                ", Edad = " + age +
                ", Materia Dictada = '" + materia + '\'' +
                '}';
    }
}  