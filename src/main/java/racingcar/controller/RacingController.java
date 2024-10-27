package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.utils.StringReplacer;
import racingcar.utils.StringSplitter;
import racingcar.validate.RacingcarAttemptValidate;
import racingcar.validate.RacingcarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringReplacer stringReplacer;
    private final StringSplitter stringSplitter;
    private final RacingService racingService;
    private final RacingcarNameValidate racingcarNameValidate;
    private final RacingcarAttemptValidate racingcarAttemptValidate;

    private final StringBuilder middleResult;

    public RacingController(InputView inputView, OutputView outputView, StringSplitter stringSplitter, StringReplacer stringReplacer, RacingService racingService, RacingcarNameValidate racingcarNameValidate, RacingcarAttemptValidate racingcarAttemptValidate, StringBuilder middleResult) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringReplacer = stringReplacer;
        this.stringSplitter = stringSplitter;
        this.racingService = racingService;
        this.racingcarNameValidate = racingcarNameValidate;
        this.racingcarAttemptValidate = racingcarAttemptValidate;
        this.middleResult = middleResult;
    }

    public void run() {
        saveCarName();//자동차 이름 입력

        String attempt = saveAttempt();//시도 횟수 입력

        printMiddleResult(attempt);//차수별 실행 결과 출력

        printFinalResult();//최대 기록과 동일한 자동차 이름 출력
    }

    private void saveCarName() {
        outputView.askCarName();//상수 데이터 출력
        String carNames = inputView.askCarName();//자동차 이름 입력

        racingcarNameValidate.isBlank(carNames);//Null 및 공백 입력 검증

        carNames = stringReplacer.removeSpaces(carNames);//문자열 내부 공백 제거
        List<String> carList = stringSplitter.split(carNames);//구분자 기준으로 문자열 리스트 반환

        racingcarNameValidate.isMoreThanFiveLetters(carList);//5글자 초과 검증
        racingcarNameValidate.isDuplicate(carList);//중복 입력 검증

        racingService.saveCarName(carList);//검증을 마친 자동차 이름 리스트 저장
    }

    private String saveAttempt() {
        outputView.askAttempt();//상수 데이터 출력
        String attempt = inputView.askAttempt();//시도 횟수 입력
        racingcarAttemptValidate.isBlank(attempt);//공백 입력 검증
        racingcarAttemptValidate.isParsable(attempt);//정수로 변환 가능 여부 검증, 자료형 범위 내

        return attempt;
    }

    private void printMiddleResult(String attempt) {
        racingService.makeMiddleResult(attempt, middleResult);//middleResult에 차수별 실행 결과 저장
        outputView.printMiddleResult(middleResult);//차수별 실행 결과 출력
    }

    private void printFinalResult() {
        String finalResult = racingService.makeFinalResult();//우승자 반환
        outputView.printFinalResult(finalResult);//최종 우승자 출력
    }
}
