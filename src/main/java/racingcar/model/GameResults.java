package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GameResults {
    public static String getCarStatesPerTrial(List<RacingCar> cars) {
        StringBuilder result = new StringBuilder();

        for(RacingCar car : cars){
            result.append(car.getCarName())
                    .append(" : ")
                    .append(car.getPosition())
                    .append("\n");
        }

        return result.toString();
    }

    public static String getResultOfGame(List<RacingCar> cars) {
        StringBuilder result = new StringBuilder();

        result.append("최종 우승자 : ");

        List<RacingCar> winners = new ArrayList<>();
        RacingCar winner = cars.get(0);

        for(RacingCar car : cars){
            if(car.getPosition().length() > winner.getPosition().length()){
                winner = car;
                winners.clear();
                winners.add(car);
            } else if (car.getPosition().length() == winner.getPosition().length()) {
                winners.add(car);
            }
        }

        StringJoiner joiner = new StringJoiner(", ");
        for(RacingCar car : winners){
            joiner.add(car.getCarName());
        }

        result.append(joiner.toString());

        return result.toString();
    }
}
