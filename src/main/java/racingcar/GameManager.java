package racingcar;

import java.util.ArrayList;

public class GameManager {

    ArrayList<Car> cars = new ArrayList<>();
    int count;

    //우승자 반환
    public String[] startGame(String[] car_list, int count){
        setCarList(car_list);
        setTryCount(count);

        for(int i = 0; i < count; i++){
            game();
        }

        return car_list;
    }

    private void setCarList(String[] car_list) {
        for (String s : car_list) {
            cars.add(new Car(s));
        }
    }

    private void setTryCount(int count) {
        this.count = count;
    }

    private void game(){
        for (Car car : cars) {
            car.move();
            car.printCurrentDistance();
        }
    }
}
