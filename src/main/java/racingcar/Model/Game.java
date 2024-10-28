package racingcar.Model;

import java.util.ArrayList;

public class Game {
    private int count;
    private ArrayList<Car> cars;
    public Game(int count,ArrayList<Car> cars) {
        this.count =count;
        this.cars = cars;
    }
    public int getCount(){return count;}
    public ArrayList<Car> getCars(){return cars;}
}
