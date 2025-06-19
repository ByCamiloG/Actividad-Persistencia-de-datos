/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto.programacion.serialization;
import java.io.Serializable;

/**
 * Interfaz común para objetos que pueden ser serializados y mostrados
 */
public interface Interfaz extends Serializable {
    @Override
    String toString(); // Cada clase ya tiene su propio toString
}