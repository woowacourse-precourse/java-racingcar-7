package mvc.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

/* TODO
- 중복이름 예방 로직 고려하기
-
**/
public class CarModel {
    private final List<Car> carRepository;

    public CarModel(){

        this.carRepository = new ArrayList<>();
    }

    public List<Car> findAll(){
        return new ArrayList<Car>(this.carRepository);
    }

    public Car findCarByName(String name){

        return this.carRepository.stream()
                .filter(car -> car.getName().equals(name))
                .findAny()
                .orElse(null);

    }

    public Car findCarByObject(Car target){

        int idx = this.carRepository.indexOf(target);
        if(idx == -1){
            return null;
        }

        return this.carRepository.get(idx);
    }

    public List<Car> findCarsByMove(int move){
        List<Car> ret = new ArrayList<Car>();
        this.carRepository.stream()
                .filter(car -> car.getMove()==move)
                .forEach(ret::add);

        return ret;
    }

    public Car createCar(String name){
        return new Car(name);
    }

    public void insertCar(Car car){
        this.carRepository.add(car);
    }

    public void tryMoveAllCars(){
        List<Car> carList = this.findAll();
        carList.forEach(car -> {
            this.tryMoveCar(car);
        });
    }

    private void tryMoveCar(Car car) {
        int currentMove = car.getMove();

        if (isMoveSuccess()) {
            car.setMove(currentMove + 1);
        }

    }

    private boolean isMoveSuccess(){

        int val = Randoms.pickNumberInRange(0,9);

        if(val>=4){
            return true;
        }

        return false;
    }

    public List<Car> findWinner(int totalStage){

        if(totalStage < 0){
            return null;
        }

        List<Car> winner = this.findCarsByMove(totalStage);

        if(winner.isEmpty()){
            return findWinner(totalStage - 1);
        }

        return winner;
    }

}
