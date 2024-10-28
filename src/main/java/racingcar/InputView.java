package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class InputView {

    public LinkedHashMap<String, Car> getCarMap() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return convertInputToMap(Console.readLine());
    }

    protected LinkedHashMap<String, Car> convertInputToMap(String input) {
        LinkedHashMap<String, Car> carMap = new LinkedHashMap<>();

        String[] carNames = input.split(",");
        for (String str : carNames) {
            if(str.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (!isCarListInputValid(carMap, str)) {
                throw new IllegalArgumentException();
            }
            carMap.put(str, new Car(str));
        }

        isCarMapEmpty(carMap);

        return carMap;
    }

    protected void isCarMapEmpty(LinkedHashMap<String, Car> carMap) {
        if(carMap.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    protected boolean isCarListInputValid(LinkedHashMap<String, Car> map, String str) {
        if (map.containsKey(str)) {
            return false;
        }

        if (str.length() > 5) {
            return false;
        }

        return true;
    }

    public Long getRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return convertInputToLong(Console.readLine());
    }

    protected Long convertInputToLong(String input) {
        if (!isRoundNumberValid(input)) {
            throw new IllegalArgumentException();
        }
        return Long.parseLong(input);
    }

    protected boolean isRoundNumberValid(String input) {
        try {
            Long num = Long.parseLong(input);
            if (num < 1L) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
