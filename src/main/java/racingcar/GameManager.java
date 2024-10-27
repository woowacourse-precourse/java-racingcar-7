package racingcar;

import java.util.ArrayList;

public class GameManager {

    ArrayList<Car> cars = new ArrayList<>();
    int count;

    //우승자 반환
    public String[] StartGame(String[] car_list, int count){
        SetCars(car_list);
        SetTryCount(count);

        for(int i = 0; i < count; i++){
            Game();
        }

        return car_list;
    }

    private void SetCars(String[] car_list) {

    }

    private void SetTryCount(int count) {

    }

    private void Game(){
        for (Car car : cars) {
            car.Move();
        }
    }

    private void PrintGame(){

    }
}
