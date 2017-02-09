package nl.ensignprojects.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private List<String> options = new ArrayList<>();
    
    public void of(String... items) {
        options.addAll(Arrays.asList(items));
    }
}
