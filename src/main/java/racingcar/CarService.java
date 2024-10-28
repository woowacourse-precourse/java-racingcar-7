package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CarService {
    private CarRepository carRepository;
    public void setCars(String[] carNames){
        for(String carName : carNames){
            carRepository.addCar(carName);
        }
    }

    public void doneGame(){
        carRepository.getMap().clear();
    }

    public void doGameTotalSet(String[] carNames, int tryCount){
        for(int i = 0; i < tryCount; i++){
            doGameOneSet(carNames);
        }
    }

    public void getResultModel(){
        Model model = new Model(carRepository.getMap(), getWinner());

    }

    private String getWinner() {

        Map<String, ArrayList<Integer>> carMap = carRepository.getMap();

        return carMap.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .max(Comparator.comparingInt(entry -> entry.getValue().get(entry.getValue().size() - 1)))
                .map(Map.Entry::getKey)
                .orElse("");
    }





    private void doGamePerCar(String car){
        int randomNumber = getRandomNnumber();
        if(isMove(randomNumber))
            moveCar(car);
        else
            renewalCurrentPosition(car);
    }

    private void doGameOneSet(String[] carNames){
        for(String car : carNames){
            doGamePerCar(car);
        }
    }



    private void moveCar(String car){
        ArrayList<Integer> carPosition = carRepository.getCarPosition(car);
        if(carPosition.size() == 0)
            carPosition.add(1);
        else
            carPosition.add(carPosition.get(carPosition.size()-1)+1);
    }

    private void renewalCurrentPosition(String car){
        ArrayList<Integer> carPosition = carRepository.getCarPosition(car);
        if(carPosition.size() == 0)
            carPosition.add(0);
        else
            carPosition.add(carPosition.get(carPosition.size()-1));
    }

    private int getRandomNnumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isMove(int number){
        return number >= 4;
    }

    public CarService(){
        this.carRepository = DependencyInjectionConfig.carRepository();
    }

}
