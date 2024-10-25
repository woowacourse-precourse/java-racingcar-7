package racingcar.controller;

import racingcar.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.ProcessedInput;
import racingcar.model.OriginInput;
import racingcar.model.Winner;
import racingcar.util.Splitter;
import racingcar.util.Validator;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.List;

public class RacingController {
    public void run() {
        /*
        입력, 레이싱, 최종 우승 자동차 출력 수행
        */
        OriginInput originInput = new OriginInput();

        // 유저 입력 받기
        originInput.inputCarNames();
        originInput.inputRaceRounds();

        Validator validator = new Validator();

        // 아무 값도 입력되지 않은 경우
        if (validator.validBlank(originInput.getCarNames(), originInput.getRaceRound())) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ARG.getMessage());
        }

        Splitter separator = new Splitter(originInput.getCarNames());

        // 시도할 횟수로 수가 아닌 값이 입력된 경우
        if (validator.validNumber(originInput.getRaceRound())) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }

        ProcessedInput processedInput = new ProcessedInput(separator.splitSeparator(), new BigInteger(originInput.getRaceRound()));

        // 자동차 이름 길이가 5보다 큰 경우
        if (validator.validNameLength(processedInput.getCarList())) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }

        // 자동차 경주 수행
        racing(processedInput);

        Winner winner = new Winner();

        // 우승 자동차 찾기
        findWinner(processedInput.getCarList(), winner.getWinner());

        // 최종 우승자 출력
        winner.printWinner();
    }

    // 자동차 경주
    public void racing(ProcessedInput processedInput) {
        System.out.println();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(processedInput.getRaceRounds()) < 0; i = i.add(BigInteger.ONE)) {
            raceSingleRound(processedInput.getCarList());
        }
    }

    // 레이싱 한 라운드 수행
    public void raceSingleRound(List<Car> carList) {
        for (Car car : carList) {
            if (getRandom() > 3) {
                car.moveForward();
            }
            car.printPosition();
        }
        System.out.println();
    }

    // 무작위 수 구하기
    public int getRandom() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void findWinner(List<Car> carList, List<Car> winner) {
        BigInteger maxPosition = BigInteger.ZERO;

        for (Car car : carList) {
            BigInteger curPosition = car.getPosition();

            if (curPosition.compareTo(maxPosition) > 0){
                maxPosition = curPosition;
                winner.clear();
                winner.add(car);
            }
            else if (maxPosition.compareTo(curPosition) == 0) {
                winner.add(car);
            }
        }
    }
}