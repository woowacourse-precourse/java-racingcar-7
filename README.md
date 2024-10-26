# java-racingcar-precourse

## ⛳️ 요구 사항

### 🎯 프로그래밍 요구 사항

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)
    를 원칙으로 한다.

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 🚀 기능 요구 사항

> [!IMPORTANT]
> 
> 초간단 자동차 경주 게임을 구현한다.

1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다
8. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 🖨️ 입출력 요구 사항

**입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

  ```bash
  pobi,woni,jun
  ```

- 시도할 횟수

  ```bash
  5
  ```

**출력**

- 차수별 실행 결과

  ```bash
  pobi : --
  woni : ----
  jun : ---
  ```

- 단독 우승자 안내 문구

  ```bash
  최종 우승자 : pobi
  ```

- 공동 우승자 안내 문구

  ```bash
  최종 우승자 : pobi, jun
  ```

**실행 결과 예시**

```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## ✏️ 구현할 기능

### 1. IoC(Inverse of Control), DI(Dependency Injection) 기능을 구현한다.

> [!NOTE]
> 
> [Java Calculator](https://github.com/himitery/java-calculator-7/tree/himitery)에서 아쉬웠던 부분과 부족하다고 느꼈던 부분에 대해 단계적으로 리팩터링을 진행한다.

- [x] `ApplicationContext`와 `ComponentScanner`의 역할과 기능에 대해 다시 고민해본다.
- [x] `ApplicationContext`에서 빈이 생성되고 등록되는 시점에 대해 다시 고민해본다.
  - 기존에는 `ApplicationContext`가 생성되는 시점에서 빈이 생성되지만, 만약 사용되지 않는 클래스가 있다면 같이 생성된다.
- [x] `@Component` 어노테이션 뿐만 아니라, `@Handler`, `@Service`와 같은 어노테이션의 추가를 고려한다.

### 2. 테스트를 설계하고 작성한다.

> [!NOTE]
> 
> TDD(Test Driven Development)를 실현하기 위해 도전한다.

- [x] 비즈니스 요구사항를 반영하여 테스트 범위를 설정하고 테스트 케이스를 설계한다.
- [x] 테스트를 작성하기 이전에 인터페이스를 구현하고, 1번 단계의 구현체로부터 인터페이스를 주입받는다.
- [x] 테스트를 위한 API에 대해 조사하고, 이를 활용하여 테스트를 작성한다.
  - `camp.nextstep.edu.missionutils.test`에서 제공하는 `Assertions`를 활용한다.
  - `AssertJ`를 사용하여 데이터를 검증한다.

### 3. 비즈니스 로직을 구현한다.

**3-1. 사용자로부터 입력을 받고 입력 값을 검증한다.**

- [x] `amp.nextstep.edu.missionutils`에서 제공하는 `Console`를 활용한다.
- [x] 사용자의 입력 값이 비즈니스 요구사항에 부합한지 검증한다.
  - 검증을 위한 별도의 클래스를 생성하고, 전역에서 공통 사용될 수 있도록 고민한다.

**3-2. 레이싱을 시작한다.**

- [x] 사용자가 입력한 조건에 맞게 레이싱을 시작한다.
  - [x] 자동차 클래스를 만들고, 자동차의 이름과 진행 거리를 기록하고 관리한다.
  - [x] 레이싱 클래스를 만들고, 레이싱의 실행과 기록을 관리한다.
  - [x] 자동차의 전진 여부는 랜덤하게 정해진다.
    - `amp.nextstep.edu.missionutils`에서 제공하는 `Randoms`를 활용하여 랜덤 값을 생성한다.

**3-3. 레이싱 결과를 출력한다.**

- [x] 레이싱 라운드마다 기록을 출력한다.
  - 각 자동차마다 이름과 이동 거리를 표시한다.
- [x] 최종 우승자를 출력한다.
  - 단일 우승자 혹은 다수의 우승자가 출력된다. 
