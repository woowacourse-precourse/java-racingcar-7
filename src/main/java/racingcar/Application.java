package racingcar;

import racingcar.domain.Cars;
import racingcar.endpoint.InputInterface;
import racingcar.endpoint.OutputInterface;
import racingcar.service.CarFactory;

public class Application {
    public static void main(String[] args) {
        String firstLine;
        String secondLine;
        try (InputInterface inputInterface=new InputInterface()) {
            OutputInterface.printMessage(OutputInterface.ENTER_PLAYER_NAME);
            firstLine = inputInterface.readLine();
            OutputInterface.printMessage(OutputInterface.ENTER_NUMBER_OF_TRIALS);
            secondLine = inputInterface.readLine();
        }
        CarFactory carFactory = new CarFactory();
        Cars cars=carFactory.createCars(firstLine);
        //TODO 2024 10 24 22:38:46 : 선수들을 주입받는 경주 서비스 만들기
        //TODO 2024 10 24 22:39:12 : 시행 횟수만큼 경주를 실행
        //TODO 2024 10 24 22:39:25 : 각 시행마다 거리 출력
        //TODO 2024 10 24 22:42:24 : 경기가 끝나면 우승자 출력
    }
}
