package racingcar.global.Exception;

public class CarNameException extends IllegalArgumentException {
    public CarNameException(String message) {
        super(message);
    }

    public static class EmptyCarNameException extends CarNameException {
        public EmptyCarNameException() {
            super("자동차 이름으로 공백은 불가능합니다.");
        }
    }

    public static class InsufficientCarNamesException extends CarNameException {
        public InsufficientCarNamesException() {
            super("자동차 이름을 2개 이상 입력해야합니다.");
        }
    }

    public static class LongCarNameException extends CarNameException {
        public LongCarNameException(String name) {
            super("자동차 이름은 5자 이하이어야 합니다: " + name);
        }
    }

    public static class DuplicatedCarNameException extends CarNameException {
        public DuplicatedCarNameException() {
            super("자동차 이름은 중복될 수 없습니다.");
        }
    }
}

