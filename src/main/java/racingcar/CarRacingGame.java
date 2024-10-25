package racingcar;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarRacingGame {
    private List<Car> carList;
    private int numberOfAttempts;
    private final String carNameRegex = "^[ㄱ-ㅎ가-힣a-zA-Z]{1,5}";
    private final Pattern CAR_NAME_PATTERN = Pattern.compile(carNameRegex);

    public CarRacingGame() {
        carList = new ArrayList<>();
    }

    public void run() {
        String carNames = InputView.inputCarNames();
        createCarsFromNames(carNames);
        String numberOfAttempts = InputView.inputNumberOfAttempts();
    }

    private void createCarsFromNames(String carNameInput) {
        if(carNameInput==null || carNameInput.isEmpty()) { // 빈문자열 처리
            throw new IllegalArgumentException("빈 문자열 입니다.");
        }
        List<String> carNames = splitCarNames(carNameInput);
        List<String> uniqueCarNames = addIdentifierToDuplicates(carNames);
        carList = uniqueCarNames.stream().map(Car::new).toList();
    }
    private List<String> splitCarNames(String carNameInput) {
        String[] carNames = carNameInput.split(",");
        if(carNames.length==1)
            throw new IllegalArgumentException("경주에 필요한 최소 자동차 개수는 2대입니다.");
        return Arrays.stream(carNames).peek(this::validateCarName).collect(Collectors.toList());
    }

    private List<String> addIdentifierToDuplicates(List<String> carNames) {
        Map<String,Integer> nameCounts = new HashMap<>();
        return carNames.stream().peek(carName -> {
            int count = nameCounts.getOrDefault(carName,0);
            nameCounts.put(carName,count+1);
            if(count!=0)
                carName = carName + "(" + count + ")";
        }).toList();
    }

    private void validateCarName(String carName) {
        if(!CAR_NAME_PATTERN.matcher(carName).matches()) {
            throw new IllegalArgumentException("자동차 이름 형식이 일치하지 않습니다.");
        }
    }

    private void validateNumberOfAttempts(String numberOfAttempts) {


    }


}
