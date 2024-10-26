package racingcar.domain.racing;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.RacingCarConstant;
import racingcar.domain.error.ErrorMessage;

public class Racing {

    private List<RacingCar> racingCars = new ArrayList<>();
    private int tryCnt;


    public void doRacing() {
        setRacingCars();
        setTryCount();
    }

    private void setRacingCars() {
        System.out.println(RacingConstant.INPUT_CAR_NAMES_MESSAGE);

        String inputTextForRacingCars;
        try {
            inputTextForRacingCars = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

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

        racingCars.stream().forEach(r -> System.out.println(r.getName()));
    }

    private void setTryCount() {
        System.out.println(RacingConstant.INPUT_TRY_COUNT_MESSAGE);
        try {
            tryCnt = Integer.parseInt(Console.readLine());
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

    private boolean isInvalidTryCount() {
        if (1 <= tryCnt && tryCnt <= 10) {
            return false;
        }
        return true;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
