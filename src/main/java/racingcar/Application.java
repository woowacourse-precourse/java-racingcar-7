package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> cars = readCars();
        List<Integer> positions = cars.stream()
                .map(car -> 0)
                .toList();
        System.out.println();
        int times = readTimes();
        positions = runRound(times, cars, positions);
        printWinners(cars, positions);
    }

    /**
     * 자동차 이름이 5자 이하인지 검증하는 함수
     *
     * @param carName 자동차 이름
     * @throws IllegalArgumentException 자동차 이름이 5자 초과일 경우
     */
    private static void carNameValidCheck(String carName) throws IllegalArgumentException {
        if (carName.length() <= 5) return;
        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
    }

    /**
     * 자동차 이름을 입력받아 배열로 반환하는 함수
     * 자동차 이름은 쉼표(,)로 구분 및 carNameValidCheck 메소드로 검증
     *
     * @return 자동차 이름 리스트
     */
    private static List<String> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Stream.of(Console.readLine()
                        .replaceAll(" ", "")
                        .split(","))
                .toList();
        if (cars.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        cars.forEach(Application::carNameValidCheck);
        return cars;
    }

    /**
     * 시도 횟수를 입력받아 반환하는 함수
     *
     * @return 시도 횟수
     * @throws IllegalArgumentException 시도 횟수가 숫자가 아닐 경우
     */
    private static int readTimes() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    /**
     * 0 또는 1을 반환하여 전진 또는 정지를 결정하는 함수
     *
     * @return 1: 전진, 0: 정지
     */
    private static int goToForward() {
        int rand = Randoms.pickNumberInRange(0, 9);
        if (rand >= 4) return 1;
        return 0;
    }

    /**
     * 자동차 위치를 업데이트하여 반환하는 함수
     *
     * @param carPositions 자동차 위치 리스트
     * @param updater      위치를 업데이트하는 함수
     * @return 업데이트된 자동차 위치 리스트
     */
    private static List<Integer> updatePositions(List<Integer> carPositions,
                                                 Function<Integer, Integer> updater) {
        return carPositions.stream()
                .map(updater)
                .toList();
    }

    /**
     * 자동차들의 현재 위치를 출력하는 함수
     *
     * @param carNames     자동차 이름 리스트
     * @param carPositions 자동차 위치 리스트
     */
    private static void printCars(List<String> carNames, List<Integer> carPositions) {
        IntStream.range(0, carNames.size())
                .forEach(i -> System.out.printf("%s : %s\n", carNames.get(i), "-".repeat(carPositions.get(i))));
        System.out.println();
    }

    /**
     * 시도 횟수만큼 라운드를 실행하는 함수
     *
     * @param times        시도 횟수
     * @param carNames     자동차 이름 리스트
     * @param carPositions 자동차 위치 리스트
     * @return 최종 라운드 자동차 위치 리스트
     */
    private static List<Integer> runRound(int times,
                                          List<String> carNames,
                                          List<Integer> carPositions) {
        System.out.println("실행 결과");

        List<Integer> updatedCarPositions = carPositions;
        for (int i = 0; i < times; i++) {
            updatedCarPositions = updatePositions(updatedCarPositions,
                    position -> position + goToForward());
            printCars(carNames, updatedCarPositions);
        }

        return updatedCarPositions;
    }

    /**
     * 최종 우승자를 출력하는 함수
     *
     * @param carNames     자동차 이름 리스트
     * @param carPositions 자동차 위치 리스트
     */
    private static void printWinners(List<String> carNames, List<Integer> carPositions) {
        int maxPosition = carPositions.stream()
                .max(Integer::compare)
                .orElseThrow(IllegalArgumentException::new);
        String[] winners = IntStream.range(0, carNames.size())
                .filter(i -> carPositions.get(i) == maxPosition)
                .mapToObj(carNames::get)
                .toArray(String[]::new);
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winners));
    }

}
