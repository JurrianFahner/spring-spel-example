package nl.ensignprojects.model;

import lombok.Data;

/**
 * @author jurrian
 */
@Data
public class Car {
    private String brand;
    private int numberOfWheels;
    private int numberOfDoors;
    private String color;
}
