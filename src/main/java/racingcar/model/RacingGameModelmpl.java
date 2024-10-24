package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingGameModelmpl implements RacingGameModel{
    @Override
    public String play(String carNames, String trialNum) {
        List<RacingCar> cars = parseAndGenerateCars(carNames);
        int trial = generateTrial(trialNum);

        String result = "\n실행 결과\n";
        // 실행 결과 저장
        result += resultThroughCarsAndTrial(cars, trial);

        return result;
    }

    private String resultThroughCarsAndTrial(List<RacingCar> cars, int trial) {
        StringBuilder result = new StringBuilder();

        // 반복 시도 마다 저장
        for(int i = 0; i < trial; i++){
            moveCars(cars);
            result.append(getCarStatesPerTrial(cars));
        }

        result.append(getResultOfGame(cars));

        return result.toString();
    }

    private String getResultOfGame(List<RacingCar> cars) {
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

    private String getCarStatesPerTrial(List<RacingCar> cars) {
        StringBuilder result = new StringBuilder();

        for(RacingCar car : cars){
            result.append(car.getCarName())
                    .append(" : ")
                    .append(car.getPosition())
                    .append("\n");
        }

        return result.toString();
    }

    private void moveCars(List<RacingCar> cars) {
        for(RacingCar car : cars){
            car.move(isMovable());
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private List<RacingCar> parseAndGenerateCars(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }

        String[] carNames = input.split(",");

        return Arrays.stream(carNames)
                .map(carName -> {
                    carName = carName.trim();

                    if(carName.length() > 5){
                        throw new IllegalArgumentException();
                    }

                    return new RacingCar(carName, "");
                })
                .toList();
    }

    private int generateTrial(String input) {
        int trial;

        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }

        try{
            trial = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(trial <= 0){
            throw new IllegalArgumentException();
        }

        return trial;
    }


}
