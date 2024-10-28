package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 경주하는 차를 받아오는 기능-> 단 이떄 이름은 5자 이하만 가능하다.
        // 전진하는 기능 -> 숫자가 0~9중에서 뽑는데 4이상일 경우에 한 칸 전진한다
        // 우승자를 고르는 기능 -> 우승자가 여러명인 경우 ,로 구분
        // 자동차 이름을 받아오기
        ActionManager actionManager = new ActionManager();
        actionManager.run();
    }
}