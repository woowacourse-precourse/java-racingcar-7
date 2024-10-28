package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarNameInput {
    public List<String> getCarNames() {
        Optional<List<String>> carList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String carNameInput = readLine();

            // 유효성 검증을 통해 5글자 이상인 경우 예외 발생
            carList = validateAndParseCarNames(carNameInput);
        } while (carList.isEmpty());

        return carList.get();
    }

    // 입력된 문자열을 리스트로 변환하고 유효성 검사
    private Optional<List<String>> validateAndParseCarNames(String carNameInput) {

        List<String> carNames = Arrays.stream(carNameInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        boolean allNamesValid = carNames.stream().allMatch(name -> name.length() <= 5);
        if (!allNamesValid) {
            throw new IllegalArgumentException("이름은 5글자 이하로 설정해야 합니다.");  // 예외 발생
        }
        return Optional.of(carNames);
    }
}
