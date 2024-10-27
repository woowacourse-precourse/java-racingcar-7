package racingcar;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    // 생성자: 자동차 이름을 받고 유효성 검사 후 설정
    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // 이름 유효성 검사 메서드
    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    // 자동차 이름 반환
    public String getName() {
        return name;
    }

    // 자동차 현재 위치 반환
    public int getPosition() {
        return position;
    }

    // 자동차의 이동 메서드: 전진할지 여부에 따라 위치 증가
    public void move(boolean isForward) {
        if (isForward) {
            position++;  // 전진 시 위치 1 증가
        }
    }
}
