package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.constant.BusinessConst;
import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    public void play(CarList carList, GameResult gameResult, int count) {
        if (count == 0) return;

        playRound(carList);
        saveRoundResult(carList, gameResult);

        this.play(carList, gameResult, count - 1);
    }

    public void determineWinner(CarList carList, GameResult result) {
        int mostFurtherCarPosition = carList.getFurthestPosition();
        String winners = carList.getCarList()
                .stream()
                .filter(car -> car.getPosition() == mostFurtherCarPosition)
                .map(Car::getName)
                .collect(Collectors.joining(BusinessConst.DEFAULT_JOIN_DELIMITER));

        result.saveWinner(winners);
    }

    private void playRound(CarList carList) {
        carList.getCarList()
                .forEach(this::drawAndMove);
    }

    private void drawAndMove(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= BusinessConst.WIN_CONDITION) {
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