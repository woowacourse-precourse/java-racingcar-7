package racingcar;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) { // 자기 역할에 충실하는 객체
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

    // 객체는 한가지 일만 해야한다.
    // 함수는 한가지 일만 해야한다.
    // 패키지는 무엇인가?
    // 자바 패키지는 파일 시스템과 무엇이 다른가?
    // 폴더와 자바의 패키지의 차이
    // 접근 제어자의 각각의 범위에 대해서 자세히 알아보기
    // 특히 protected

    protected String getValue() {
        return name;
    }
}
