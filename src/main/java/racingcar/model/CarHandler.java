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

    public List<String> checkWinner() {
        int maxpos = -1;
        List<String> winnerlist = new ArrayList<>();
        for(Car c : carlist) {
            if(c.pos > maxpos) {
                maxpos = c.pos;
                winnerlist = new ArrayList<>();
                winnerlist.add(c.name);
            }
            else if(c.pos == maxpos) {
                winnerlist.add(c.name);
            }
        }

        return winnerlist;
    }
}
