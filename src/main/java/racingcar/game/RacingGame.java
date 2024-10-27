package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.input.InputDTO;
import racingcar.domain.Car;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars = new ArrayList<>();
    private final int round;

    /**
     * RacingGame 생성자
     * @param inputDTO 게임 입력 데이터 DTO, 자동차 이름 리스트와 라운드 수를 포함
     */
    public RacingGame(InputDTO inputDTO) {
        createCar(inputDTO.carNames());
        this.round = inputDTO.round();
    }

    /**
     * 자동차를 생성하여 리스트에 추가합니다.
     * @param carNames 자동차 이름 리스트
     */
    private void createCar(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new RacingCar(carName)));
    }

    /**
     * 게임을 시작합니다.
     */
    public void startGame() {
        for (int i = 0; i < round; i++) {
            playRound();
            printRoundResult();
        }
        printGameResult();
    }

    /**
     * 한 라운드를 플레이합니다.
     */
    private void playRound() {
        cars.forEach(car -> {
            if (shouldMove()) {
                car.forward();
            }
            car.stop();
        });
    }

    /**
     * 자동차가 이동할지 여부를 결정합니다.
     * @return 이동 여부
     */
    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    /**
     * 현재 라운드의 결과를 출력합니다.
     */
    private void printRoundResult() {
        System.out.println("실행 결과");

        cars.forEach(car -> {
            CarDTO carDTO = car.toDTO();
            System.out.print(carDTO.carName() + " : ");
            System.out.print("-".repeat(carDTO.currentPosition())+"\n");
        });
    }

    /**
     * 최종 우승자를 출력합니다.
     */
    private void printGameResult() {
        List<CarDTO> winners = findWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream()
                .map(CarDTO::carName)
                .toList()));
    }

    /**
     * 우승자를 찾습니다.
     * @return 우승자 DTO 리스트
     */
    private List<CarDTO> findWinners() {
        List<CarDTO> carDTOs = cars.stream()
                .map(Car::toDTO)
                .toList();

        int maxPosition = carDTOs.stream()
                .mapToInt(CarDTO::currentPosition)
                .max()
                .orElse(0);

        return carDTOs.stream()
                .filter(carDTO -> carDTO.currentPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}
