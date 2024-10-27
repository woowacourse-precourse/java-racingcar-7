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


---

### 학습 목표
여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
1주 차 공통 피드백을 최대한 반영한다.

### 회고
아래 질문에 대한 중간 회고를 진행하고 소감에 구체적인 결과를 작성한다. 소감은 텍스트로 작성해야 하며 외부 링크는 허용하지 않는다.

1. 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?

<aside>
 지금까지의 진행 상황을 보면, 목표의 기초적인 부분을 충분히 달성하고 있다고 생각합니다. 특히 자바의 기본 문법과 구조적인 프로그래밍에 대한 이해가 많이 향상되었습니다. 이를 통해 간단한 애플리케이션을 구현하면서 백엔드의 핵심 개념을 명확히 이해하는 데 많은 도움이 되었습니다. 예를 들어, 이번 자동차 경주 게임을 구현하면서 객체지향 프로그래밍의 기초 개념인 클래스와 메서드의 역할 분리를 직접적으로 경험할 수 있었습니다. 또한, 예외 처리와 같은 에러 핸들링을 적용해 보며 안정적인 코드를 작성하는 연습을 하고 있습니다.
</aside>

2. 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?

<aside>
현재 목표를 변경할 필요는 없다고 생각합니다. 다만, 자바의 기초적인 개념을 더 잘 이해하기 위해 객체지향 설계 원칙을 추가로 공부하고 싶습니다. 또한, 프로젝트 진행 중에 경험한 예외 처리와 테스트 코드 작성의 중요성을 느껴 TDD에 대한 학습 목표를 추가하고자 합니다. 이는 단순히 동작하는 코드를 넘어서서 신뢰성 있는 코드를 작성할 수 있는 역량을 키우기 위함입니다.
</aside>

3. 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

<aside>
프리코스를 통해 가장 큰 깨달음은 객체지향 프로그래밍의 중요성입니다. 자바의 기본 문법을 배우면서 단순히 코드를 작성하는 것이 아니라, 역할에 맞게 클래스를 분리하고 메서드를 구성하는 방식이 얼마나 중요한지 깨닫게 되었습니다. 또한, 에러가 발생할 수 있는 상황에 대해 미리 고려하고 예외 처리를 하는 것이 프로그램의 안정성을 높이는 데 큰 도움이 된다는 것을 느꼈습니다.

이번 과정을 통해 자바의 기초 개념을 탄탄히 쌓아가는 것이 목표였으며, 이러한 목표를 차근차근 달성해 나가고 있습니다. 앞으로도 코드 품질과 유지보수성을 고려한 깨끗한 코드 작성에 중점을 두고 학습을 이어갈 계획입니다.
</aside>

---
