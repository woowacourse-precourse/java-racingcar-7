package racingcar;

import java.util.List;
import java.util.TreeMap;

public class Application {
    public static void main(String[] args) {

            MessagePrinter messagePrinter = new MessagePrinter();
            InputReader inputReader = new InputReader();
            InputExtractor inputExtractor = new InputExtractor();
            MapBuilder mapBuilder = new MapBuilder();
            RandomPicker randomPicker = new RandomPicker();
            WinnerSorter winnerSorter = new WinnerSorter();

        try{
            System.out.println(messagePrinter.carNameGuideMessage);
            String userInputCar = inputReader.getUserInput();

            List<String> carNames = inputExtractor.extractCarNames(userInputCar);
            int carCount = inputExtractor.countCars(carNames);

            System.out.println(messagePrinter.roundNumGuideMessage);
            String userInputRound = inputReader.getUserInput();
            int totalRounds = inputExtractor.extractRound(userInputRound);

            // 자동차 이름과 전진횟수를 매핑
            mapBuilder.mapCarNamesToForwardCounts(carNames);
            // 자동차 이름과 출력할 라인 문자열을 매핑
            mapBuilder.mapCarNamesToStringForwardLines(carNames);

            System.out.println(messagePrinter.resultGuideMessage);
            // 입력된 라운드 횟수만큼 랜덤라운드 1회를 반복
            List<String> totalRoundResultList = randomPicker.runRandomRounds(carNames, totalRounds);
            System.out.println(messagePrinter.getTotalRoundResultMessage(totalRoundResultList));

            //우승자 목록 도출하기
            TreeMap<String, Integer> forwardCounter= mapBuilder.getCarNameAndForwardCount();
            List<String> winnerList = winnerSorter.getJointWinners(forwardCounter);

            System.out.println(messagePrinter.getWinnerMessage(winnerList));

        } catch(IllegalArgumentException e) {
            throw e;
        }
    }
}