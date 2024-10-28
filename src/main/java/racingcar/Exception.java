package racingcar;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Exception {
    public void except1(String[] strings) {
        if (strings.length==0){
            throw new IllegalArgumentException("Car name cannot be empty or whitespace");
        }
        Set<String> nameSet = new HashSet<>();
        for (String str : strings) {
            if (str == null || str.trim().isEmpty()) {
                throw new IllegalArgumentException("Car name cannot be empty or whitespace");
            }
            if (str.length() > 5) {
                throw new IllegalArgumentException("String length exceeds 5 characters: " + str);
            }
            if (!nameSet.add(str)) {
                throw new IllegalArgumentException("Duplicate car name found: " + str);
            }
        }
    }
    public void except2(String[] strings){
        if (strings.length==1){
            throw new IllegalArgumentException("Cannot race with just one car");
        }
    }

    public void except3(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Count cannot be empty or whitespace");
        }

        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw new IllegalArgumentException("Count cannot be less than 1");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Count must be a numeric value", e);
        }
    }
}
