package racingcar.service;

import static racingcar.constant.RacingCarConstants.MOVING_FORWARD;
import static racingcar.constant.RacingCarConstants.STOP;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.controller.OutputController;
import racingcar.repository.RacingCarRepository;
import racingcar.validator.Validator;

public class RacingCarService {

    RacingCarRepository racingCarRepository = new RacingCarRepository();
    OutputController outputController = new OutputController();
    Validator validator = new Validator();

    public void makeCarMap(String[] cars, Map<String, String> carMoveMap) {
        for(String car : cars) {
            car = car.trim(); //앞 뒤 공백 제거

            validator.carNameAllBlankValidate(car);
            validator.carNameWhiteSpaceValidate(car);
            validator.carNameLengthValidate(car);
            validator.delimiterValidate(car);

            carMoveMap.put(car, "");
        }
    }

    public void moveController(String[] cars, Map<String, String> carMoveMap) {

        int randomNum;
        for (String car: cars) {
            randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= MOVING_FORWARD) {
                carMoveMap.put(car, carMoveMap.get(car) + '-');
            } else if (randomNum <= STOP) {
                continue;
            }
        }
    }

    public void executeRaceRounds(String[] cars, Map<String, String> carMoveMap, int attempts) {

        int trial = 0;
        while (trial < attempts) { //리팩토링
            trial++;
            moveController(cars, carMoveMap);
            outputController.printPerAttempt(carMoveMap);
        }
    }

    public ArrayList<String> findWinners(Map<String, String> carMoveMap) {

        ArrayList<String> winners = new ArrayList<>();
        int winnerPosition = 0;

        for (Entry<String, String> items : carMoveMap.entrySet()) {
            int position = items.getValue().length();

            if (position > winnerPosition) {
                winnerPosition = position;
                winners.clear();
                winners.add(items.getKey());
            } else if (position == winnerPosition) {
                winners.add(items.getKey());
            } else {
                continue;
            }
        }

        return winners;
    }

    public Map<String, String> getCarMoveMap() {
        return racingCarRepository.getCarMoveMap();
    }
}
