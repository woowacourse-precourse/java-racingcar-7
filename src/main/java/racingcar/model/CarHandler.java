package racingcar.model;

import java.util.*;

public class CarHandler {
    public List<Car> carlist;

    public CarHandler() {
        this.carlist = new ArrayList<>();
    }

    public void addCar(String name) {
        carlist.add(new Car(name));
    }

    public void goCar() {
        for(Car c : carlist) {
            c.go();
        }
    }

    public void printPos() {
        for(Car c : carlist) {
            System.out.print(c.name + " : ");
            for(int i=0; i<c.pos; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
