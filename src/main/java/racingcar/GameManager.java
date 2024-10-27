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

        return findWinners();
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
        System.out.println("실행 결과");
        for (Car car : cars) {
            car.move();
            car.printCurrentDistance();
        }
        System.out.println();
    }

    private String[] findWinners(){
        ArrayList<String> winners = new ArrayList<String>();
        int maxDistance = 0;

        for(Car car : cars){
            maxDistance = Math.max(maxDistance, car.distance);
        }
        for(Car car : cars){
            if(car.distance == maxDistance){
                winners.add(car.name);
            }
        }

        return winners.toArray(new String[winners.size()]);
    }
}
