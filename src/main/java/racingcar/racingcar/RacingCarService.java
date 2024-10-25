package racingcar.racingcar;

import static racingcar.constant.Integers.CAR_NAME_MAX_LENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {
    private static final RacingCarService RACING_CAR_SERVICE = new RacingCarService();
    private final RacingCarValidator racingCarValidator = RacingCarValidator.getInstance();

    private RacingCarService() {

    }

    public static RacingCarService getInstance() {
        return RACING_CAR_SERVICE;
    }

    public List<RacingCar> makeRacingCarList(String joinedCarNames) {
        List<String> carNames = splitCarName(joinedCarNames);
        carNames = removeBlank(carNames);
        validNameCheck(carNames);
        return getRacingCarList(carNames);
    }

    private List<String> removeBlank(List<String> carNames) {
        return carNames.stream().
                filter(it->!it.isBlank())
                .toList();
    }

    //이 메서드 이름 바꾸고 싶음. #######################################
    private List<RacingCar> getRacingCarList(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }

    /**
     * 입력 받은 이름을 ,를 기준으로 나누고 나눠진 이름에 앞, 뒤 공백을 제거한다. 이름 사이의 공백은 인정한다. ex)cho g,ch og,i i i,i   i
     *
     * @param joinedCarNames ,로 구분된 문자열
     * @return ,를 기준으로 분리된 앞 뒤 공백이 제거된 List 를 리턴
     */

    private List<String> splitCarName(String joinedCarNames) {
        racingCarValidator.existCheck(joinedCarNames);
        return Arrays.stream(joinedCarNames.split(","))
                .map(String::trim)
                .toList();
    }

    private void validNameCheck(List<String> carNames) {
        racingCarValidator.existCheck(carNames);
        racingCarValidator.sameNameCheck(carNames);
        racingCarValidator.lengthCheck(carNames, CAR_NAME_MAX_LENGTH.getNumber());
    }
}
