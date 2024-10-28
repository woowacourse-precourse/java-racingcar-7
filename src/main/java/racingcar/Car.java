package racingcar;

public class Car {
    // 자동차 이름과 이동횟수, 랜덤 값으로 전진 여부 결정
    private final String name;
    private int count;

    Car(String name) {
        checkName(name);    // 이름 조건 확인
        this.name = name;
        this.count = 0;
    }
    private void checkName(String name) {
        // 자동차 이름 (5글자 이하 확인)
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
        }
    }

    void point() {
        // 랜덤 값으로 자동차 전진 결정
        int randomScore = Randoms.pickNumberInRange(0, 9);
        if (randomScore >= 4) {
            count++;
        }
    }

    String getName() {
        // 자동차 이름
        return name;
    }

    int getCount() {
        // 자동차 이동 횟수
        return count;
    }
}
