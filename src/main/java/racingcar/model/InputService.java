package racingcar.model;

import racingcar.view.InputView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {
    private List<String> carNameList;

    public List<String> carNamesValidation(String carNames) throws IllegalArgumentException {
        if (carNames.isEmpty()) {
            String request = InputView.request(InputView.CAR_NAME);
            carNamesValidation(request);
        }

        splitCarNames(carNames);

        return this.carNameLengthCheck();
    }


    public int gameRoundsValidation(String gameRounds) {
        if (isAllNumeric(gameRounds)) {
            return overflowCheck(parseInt(gameRounds));
        }

        return gameRoundsRequest();
    }


    private void splitCarNames(String carNames) {
        this.carNameList = Arrays.stream(carNames.split(",", -1))
                                 .map(String::trim)
                                 .collect(Collectors.toCollection(LinkedList::new));
    }


    private List<String> carNameLengthCheck() throws IllegalArgumentException {
        carNameList.forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자가 넘었습니다.");
            }
        });
        return carNameList;
    }


    private int parseInt(String str) {
        return Integer.parseInt(str);
    }


    private Boolean isAllNumeric(String gameRounds) {
        return gameRounds.matches("\\d+");
    }


    private int gameRoundsRequest() {
        String request = InputView.request("1 ~ 5000 정수 입력만 가능합니다." + InputView.ROUNDS);
        return gameRoundsValidation(request);
    }


    private int overflowCheck(int gameRounds) {
        if (gameRounds < 1 || gameRounds > 5000) {
            return gameRoundsRequest();
        }
        return gameRounds;
    }


}



