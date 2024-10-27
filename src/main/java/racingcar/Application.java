package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        MessagePrinter messagePrinter = new MessagePrinter();
        InputReader inputReader = new InputReader();
        InputExtractor inputExtractor = new InputExtractor();
        NumCounter numCounter = new NumCounter();
        MapBuilder mapBuilder = new MapBuilder();
        RandomPicker randomPicker = new RandomPicker();

        System.out.println(messagePrinter.carNameGuideMessage);
        String userInputCar = inputReader.getUserInput();

        List<String> carNames = inputExtractor.extractCarNames(userInputCar);
        int carCount = numCounter.countCars(carNames);
        numCounter.validateCarCount(carCount);
        numCounter.validateCarNames(carNames);

        System.out.println(messagePrinter.roundNumGuideMessage);
        String userInputRound = inputReader.getUserInput();
        int totalRounds = inputExtractor.extractRound(userInputRound);

        // 자동차 이름과 전진횟수를 매핑
        mapBuilder.mapCarNamesToForwardCounts(carNames);
        // 자동차 이름과 출력할 라인 문자열을 매핑
        mapBuilder.mapCarNamesToStringForwardLines(carNames);

        System.out.println(messagePrinter.resultGuideMessage);
        // 입력된 라운드 횟수만큼 랜덤라운드 1회를 반복
        for(int i = 0; i < totalRounds; i++){
            randomPicker.runSingleRandomRound(carNames);
            mapBuilder.mapSingleRandomRoundResult(i);
        }
        System.out.println(messagePrinter.totalRandomResultMessage());


    }
}