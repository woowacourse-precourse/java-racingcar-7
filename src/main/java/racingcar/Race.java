package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    List<Car> cars = new ArrayList<>();
    Input input = new Input();
    public Race(){
        String str = input.nameInput();
        String[] carNames = str.split(",");
        try {
            for(String name : carNames){
                name = name.trim();
                cars.add(new Car(name));
            }
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
