package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MAX_NAME_LENGTH = 5;
    private final int NUMBER_CAN_GO = 4;

    private String name;
    private int progress;

    public Car(String name) {
        String handledName = checkBlank(name);
        validateName(handledName);
        this.name = handledName;
        this.progress = 0;
    }

    public Car(String name, int progress) {
        String handledName = checkBlank(name);
        validateName(handledName);
        this.name = handledName;
        this.progress = progress;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요");
        }
    }

    private String checkBlank(String name) {
        String result = String.valueOf(name);
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }
        if (name.substring(0, 1).equals(" ") || name.substring(name.length() - 1, name.length()).equals(" ")) {
            result = handleBlank(result);
        }
        return result;
    }

    private String handleBlank(String name) {
        int startIndex = 0;
        int endIndex = name.length();
        for (int i = 0; i < name.length(); i++) {
            if (!name.substring(i, i + 1).equals(" ")) {
                startIndex = i;
                break;
            }
        }
        for (int i = name.length() - 1; i > 0; i--) {
            if (!name.substring(i, i + 1).equals(" ")) {
                endIndex = i;
                break;
            }
        }
        return name.substring(startIndex, endIndex + 1);
    }

    public void randomGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= NUMBER_CAN_GO) {
            this.go();
        }
    }

    private void go() {
        this.progress++;
    }

    public String name() {
        return name;
    }

    public int progress() {
        return progress;
    }
}
