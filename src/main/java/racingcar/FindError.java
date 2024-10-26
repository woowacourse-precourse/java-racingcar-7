package racingcar;

public class FindError {
    public static String[] carNamesError(String cars){
        if (!cars.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }

        String[] carNames = cars.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }
            for (int j = i + 1; j < carNames.length; j++) {//중복 체크
                if (carNames[i].equals(carNames[j])) {
                    throw new IllegalArgumentException("자동차 이름이 중복되었습니다 Name : " + carNames[i]);
                }
            }

        }
        return carNames;
    }

    public static Integer tryCountError(String input) {
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
            if (tryCount <= 0) { // 시도 횟수가 0 이하인 경우 예외 처리
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {//숫자가 아닌 경우 예외 처리
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        return tryCount;
    }


}

