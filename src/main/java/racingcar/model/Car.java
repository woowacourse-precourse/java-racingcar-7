package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern VALID_CAR_NAME_REGEXP = Pattern.compile("[a-zA-Z가-힣0-9]+");
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MIN_FORWARD_NUM = 4;
    private static final String PROGRESS_BAR = "-";

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        checkCarNameIsValid(carName);
        this.carName = carName;
        this.forwardCount = 0;
    }

    public String moveAndFormatProgress() {
        if (isForwardable()) {
            this.forwardCount++;
        }

        return formatCarProgress();
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private String formatCarProgress() {
        return carName + " : " + PROGRESS_BAR.repeat(forwardCount);
    }

    private void checkCarNameIsValid(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_INVALID_LENGTH.getErrorMessage());
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_INCLUDE_BLANK.getErrorMessage());
        }

        if (!isMatchesCarNamePattern(carName)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_INCLUDE_INVALID_STRING.getErrorMessage());
        }
    }

    private boolean isForwardable() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM) >= MIN_FORWARD_NUM;
    }

    private boolean isMatchesCarNamePattern(String carName) {
        Matcher matcher = VALID_CAR_NAME_REGEXP.matcher(carName);
        return matcher.matches();
    }
}
