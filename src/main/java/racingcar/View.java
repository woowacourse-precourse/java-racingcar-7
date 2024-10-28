package racingcar;
import java.util.ArrayList;

public class View {
    private ArrayList<Car> cars;

    public View( ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }


}
