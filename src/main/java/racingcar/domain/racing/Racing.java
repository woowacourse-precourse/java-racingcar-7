package racingcar.domain.racing;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCarConstant;
import racingcar.domain.error.ErrorMessage;
import racingcar.domain.io.RacingOutputView;

public class Racing {

    private List<RacingCar> racingCars = new ArrayList<>();
    private int tryCnt;
    private List<RacingCar> winners = new ArrayList<>();

    public void setRacingCars(String inputTextForRacingCars) {
        //빈문자열, 최대 글자수, 비허용 문자 검증
        if (isInvalidInputTextForRacingCars(inputTextForRacingCars)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TEXT);
        }

        String[] racingCarNames = inputTextForRacingCars.split(",");
        Set<String> set = new HashSet<>();
        for (String name : racingCarNames) {

            //중복체크, 5자 체크
            if (set.contains(name)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TEXT);
            } else if (name.length() > RacingCarConstant.RacingCar_MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TEXT);
            }
            set.add(name);
            racingCars.add(new RacingCar(name));
        }
    }

    public void setTryCount(String inputTextForTryCount) {
        try {
            tryCnt = Integer.parseInt(inputTextForTryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT);
        }

        if (isInvalidTryCount()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT);
        }
    }

    private boolean isInvalidInputTextForRacingCars(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return true;
        } else if (inputText.length() > RacingConstant.INPUT_CAR_NAMES_MESSAGE_MAX_LENGTH) {
            return true;
        }

        for (Character ch : inputText.toCharArray()) {
            if (!(Character.isAlphabetic(ch) || ch == ',')) {
                return true;
            }
        }

        return false;
    }

    public void iterateRace() {
        RacingOutputView racingOutputView = new RacingOutputView();
        racingOutputView.printEnter();
        racingOutputView.printIterateRacePrevMessage(RacingConstant.DO_RACING_PREV_MESSAGE);

        for (int i = 0; i < tryCnt; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.forwardCar(Randoms.pickNumberInRange(0, 9));
                String currentResultMessage = racingCar.getCurrentResultMessage();
                racingOutputView.printMessage(currentResultMessage);
            }
            racingOutputView.printEnter();
        }
    }

    public void calculateWinner() {
        int maxScore = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getForwardCount() >= maxScore) {
                if (racingCar.getForwardCount() > maxScore) {
                    winners.clear();
                }
                maxScore = racingCar.getForwardCount();
                winners.add(racingCar);
            }
        }
    }

    private boolean isInvalidTryCount() {
        if (1 <= tryCnt && tryCnt <= 10) {
            return false;
        }
        return true;
    }

    public String getWinnerNames() {
        return String.join(", ", winners.stream().map(r -> r.getName()).toList());
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
