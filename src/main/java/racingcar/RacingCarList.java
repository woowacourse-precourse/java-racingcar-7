package racingcar;

import java.util.HashSet;
import java.util.List;

public class RacingCarList {
    private List<RacingCar> racingCarList;

    public RacingCarList(String input) {
        List<String> carNameList = getCarNameList(input);
        validateCarNames(carNameList);
        this.racingCarList = convertRacingCarListFromNameList(carNameList);
    }

    public List<String> getCarNameList(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("경주에 참가할 자동차를 입력해주세요");
        }
        return List.of(input.split(","));
    }

    private List<RacingCar> convertRacingCarListFromNameList(List<String> carNameList) {
        return carNameList.stream()
                .map(name -> new RacingCar(name, ""))
                .toList();
    }

    private void validateCarNames(List<String> carNameList) {
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException("경주에는 두 대 이상의 자동차가 필요합니다");
        }
        if (carNameList.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException("자동차 이름에는 공백이 포함 불가합니다.");
        }
        if (carNameList.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해야합니다.");
        }
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되게 지어서는 안됩니다.");
        }
        if (carNameList.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("구분자 중복 사용하여 자동차 이름이 공백 처리 되었습니다.");
        }
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
