package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Model getResultModel(){
        return new Model(carRepository.getMap(), getWinner());
    }

    private List<String> getWinner() {

        Map<String, ArrayList<Integer>> carMap = carRepository.getMap();

        int maxValue = carMap.values().stream()
                .filter(values -> !values.isEmpty())  // 빈 리스트 제외
                .mapToInt(values -> values.get(values.size() - 1))
                .max()
                .orElse(Integer.MIN_VALUE);


        return carMap.entrySet().stream()
                .filter(entry -> {
                    ArrayList<Integer> values = entry.getValue();
                    return !values.isEmpty() && values.get(values.size() - 1) == maxValue;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
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
