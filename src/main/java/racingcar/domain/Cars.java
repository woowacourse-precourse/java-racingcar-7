package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.RaceException;
import racingcar.utility.StringUtility;

public class Cars {

    private final static String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private final static String MOVE_HISTORY_FORMAT = "%s : %s";
    public final List<Car> cars;

    public Cars(String raceCarNames){
        List<String> carNameList = StringUtility.splitStringToList(raceCarNames);
        if(StringUtility.isDuplicateStrExists(carNameList)){
            throw new RaceException(DUPLICATE_CAR_NAME_MESSAGE);
        }

        cars = new ArrayList<>();
        for(String carName : carNameList){
            cars.add(new Car(carName));
        }
    }

    public int getCarCount(){
        return cars.size();
    }

    public void move() {
        for (Car car : cars){
            car.move();
        }
    }

    public String getMoveHistory(){
        StringBuilder moveHistoryStringBuilder = new StringBuilder();
        for(Car car : cars){
            moveHistoryStringBuilder.append(String.format(MOVE_HISTORY_FORMAT,car.getName(),car.getMoveHistory()))
                    .append("\n");
        }
        return moveHistoryStringBuilder.toString();
    }

    public List<String> getWinners() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(-1);

        if(maxMoveCount == 0){
            return Collections.emptyList();
        }

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
