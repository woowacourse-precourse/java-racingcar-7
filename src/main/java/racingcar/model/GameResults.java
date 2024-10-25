package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GameResults {

    private final List<RacingCar> cars;
    private final int trial;

    public GameResults(List<RacingCar> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public String getResults() {
        return getCarStatesPerTrial() + getResultOfGame();
    }

    private void moveCars(List<RacingCar> cars) {
        for(RacingCar car : cars){
            car.move(isMovable());
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private String getCarStatesPerTrial() {
        StringBuilder result = new StringBuilder();

        result.append("\n실행 결과\n");

        // 반복 시도 마다 저장
        for(int i = 0; i < trial; i++){
            moveCars(cars);

            for(RacingCar car : cars){
                result.append(car.getCarName())
                        .append(" : ")
                        .append(car.getPosition())
                        .append("\n");
            }
        }


        return result.toString();
    }

    private String getResultOfGame() {
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
