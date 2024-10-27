# java-racingcar-precourse

### 기능 요구사항

기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 기능 목록

- [x] 입력한 문자열에서 자동차 추출 및 5자 초과시 에러 처리
    - readCars 함수를 통해 사용자로부터 자동차 이름을 입력받아 리스트로 반환
    - 자동차 이름을 하나도 입력하지 않았을 경우, IllegalArgumentException을 반환
    - 자동차 이름이 5자 이하인지 검증하는 함수를 통해 모든 차량이 5자 이하일 경우 해당 값을 반환, 아닐 경우 IllegalArgumentException을 반환

```java
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
```


- [x] 횟수 입력 처리
    - 시도 횟수를 입력받아 반환하는 함수를 통해 시도 횟수를 반환
    - 시도 횟수가 숫자가 아닐 경우 IllegalArgumentException을 반환

```java
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
```

- [x] 랜덤 값 생성 및 전진 조건 만족 시 전진 처리
    - goToForward 함수 내부에서 랜덤값을 통해 0 또는 1을 반환하여 전진 또는 정지를 결정
    - updatePositions 함수를 통해 자동차 위치를 업데이트하여 반환
    - printCars 함수를 통해 자동차들의 현재 위치를 출력
    - runRound 함수를 통해 시도 횟수만큼 라운드를 실행하고 최종 라운드 자동차 위치 리스트를 반환

```java
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
     * @param times 시도 횟수
     * @param carNames 자동차 이름 리스트
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

```

- [x] 우승자 출력
    - 최종 우승자를 출력하는 함수를 통해 최종 우승자를 출력
    - 최종 우승자가 여러명일 경우 쉼표(,)로 구분하여 출력

```java
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
```
