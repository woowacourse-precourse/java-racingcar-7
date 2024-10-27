package racingcar;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 메소드 호출 후 반환값 저장
        String[] carNames = CarNameInput.settingCarName();

        // Car 객체 배열 생성
        Car[] cars = new Car[carNames.length];

        // 각 자동차 이름으로 Car 객체 생성
        for (int i=0; i < carNames.length; i++ ) {
            cars[i] = new Car(carNames[i]);
        }

        // 시도 횟수 입력 메소드 호출 후 반환값 저장
        int trialNum = TrialNumInput.settingTrialNum();

        // 시도 횟수 만큼 게임 실행
        System.out.println("실행 결과");
        for (int gameTrial=0; gameTrial < trialNum; gameTrial++) {
            Play.play(cars);
        }
        
        // 최종결과 출력 메소드 호출
        ResultPrinter.printWinner(cars);
    }
}