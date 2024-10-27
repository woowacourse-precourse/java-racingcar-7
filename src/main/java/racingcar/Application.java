package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static class View {
        // 사용자로 부터 자동차 이름들을 입력 받음
        // 사용자로 부터 자동차 이동 횟수를 입력 받음

        // 경주할 자동차 입력에 대한 출력
        // 시도할 이동 횟수 입력에 대한 출력
        // 자동차들의 이동 상황(차수별 실행 결과)에 대한 출력
        // 우승자 출력(단독 우승자)
        // 우승자 출력(공동 우승자)
    }

    public static class Validator {
        // 자동차 이름 입력 형식 을 검증 (쉼표로 구분)
        // 자동차 이름이 5자 이내인지 검증
        // 이동 횟수 입력을 검증
    }

    public static class Car {
        private String name;
        private int position;

        public void moveForward() {
            //일단은 구현체로 전진 구현
        }
    }

    public static class business {
        // 전진하는 로직 구현(랜덤으로 0~9까지 숫자 뽑아서 4 이상이면 60%의 확률로 전진)
        // 우승자를 정함
    }
}
