package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.common.constant.BusinessConst.*;

public class CarRacingGame {

    public void play(GameResult gameResult, CarList carList, int count) {
        if (count <= 0) return;

        playRound(carList);
        saveRoundResult(carList, gameResult);

        this.play(gameResult, carList, count - 1);
    }

    public void determineWinner(GameResult result, CarList carList) {
        int mostFurtherCarPosition = carList.getFurthestPosition();
        String winners = carList.getCarList()
                .stream()
                .filter(car -> car.getPosition() == mostFurtherCarPosition)
                .map(Car::getName)
                .collect(Collectors.joining(DEFAULT_JOIN_DELIMITER));

        result.saveWinner(winners);
    }

    private void playRound(CarList carList) {
        carList.getCarList()
                .forEach(this::drawAndMove);
    }

    private void drawAndMove(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= WIN_CONDITION) {
            car.move();
        }
    }

    private void saveRoundResult(CarList carList, GameResult gameResult) {
        List<String> roundResult = carList.getCarList()
                .stream()
                .map(Car::getProgress)
                .toList();
        gameResult.saveRoundResult(
                RoundResult.of(roundResult)
        );
    }
}