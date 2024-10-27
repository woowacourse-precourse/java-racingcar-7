package racingcar.controller;

import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;
import racingcar.service.TrialCounter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * RacingCarController 클래스는 레이싱 게임의 전반적인 흐름을 제어한다.
 * - 게임 초기화, 차량 이동, 결과 출력을 담당한다.
 */
public class RacingCarController {

    private final TrialCounter trialCounter;   // 남은 시도 횟수를 관리하는 객체
    private final NumberGenerator numberGenerator;   // 이동을 결정하는 난수 생성기

    /**
     * 생성자에서 TrialCounter와 RandomNumberGenerator를 초기화한다.
     */
    public RacingCarController() {
        this.trialCounter = new TrialCounter();
        this.numberGenerator = new RandomNumberGenerator();
    }

    /**
     * 레이싱 게임의 주요 흐름을 실행한다.
     */
    public void run() {
        initiation();  // 초기 설정 수행
        while (!trialCounter.isFinish()) {   // 시도 횟수가 남아있을 때까지 반복
            move();   // 차량 이동 수행
        }
        getResult();   // 최종 결과 출력
    }

    /**
     * 게임 시작을 위한 초기 설정을 진행한다.
     */
    private void initiation() {
        setCars();  // 차량 생성 및 초기화
        setTrialCount();   // 시도 횟수 설정
    }

    /**
     * 차량 이름을 입력받고, 예외가 발생하면 애플리케이션 종료하도록 한다.
     */
    private void setCars() {
        String carsInput = InputView.inputCars();   // 사용자로부터 차량 이름 입력 받기
        List<String> carsName = splitCarsInput(carsInput);   // 입력값을 리스트로 변환
        CarRepository.makeCars(carsName);   // 차량 생성
    }

    /**
     * 시도 횟수를 입력받고, 예외가 발생하면 애플리케이션 종료하도록 한다.
     */
    private void setTrialCount() {
        int trialInput = InputView.inputTrialCount();   // 사용자로부터 시도 횟수 입력 받기
        trialCounter.initTrialCount(trialInput);   // 시도 횟수 설정
    }

    /**
     * 차량을 이동시키고, 이동 결과를 출력한다.
     */
    private void move() {
        Map<String, Integer> moveResults = CarRepository.move(numberGenerator);   // 차량 이동 결과
        trialCounter.takeTrial();   // 시도 횟수 감소
        OutputView.printMoveResult(moveResults);   // 이동 결과 출력
    }

    /**
     * 최종 우승자를 계산하고 출력한다.
     */
    private void getResult() {
        List<String> winners = CarRepository.getWinners();   // 우승자 목록 가져오기
        OutputView.printWinners(winners);   // 우승자 출력
    }

    /**
     * 차량 입력 문자열을 쉼표를 기준으로 분할하여 리스트로 변환한다.
     */
    private List<String> splitCarsInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) // 입력된 이름의 앞뒤 공백을 제거
                .filter(name -> !name.isEmpty()) // 빈 문자열 제거
                .collect(Collectors.toUnmodifiableList());
    }
}
