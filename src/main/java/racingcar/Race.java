package racingcar;

public class Race {

    public void raceStart(String[] names, String count) {
        int tryCount = Integer.parseInt(count);
        checkInput(names, tryCount);
    }

    // ============= 편의 메서드 =============

    private void checkInput(String[] names, int count) {
        for (String name : names) {
            checkIfLengthExceed(name);
        }

        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수를 알맞게 입력해 주세요.");
        }
    }

    private void checkIfLengthExceed(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("각 이름은 최대 5자 이하여야 합니다.");
        }
    }
}
