# 2주차 자동차 경주

## 📌 구현할 기능 목록

- [ ] 자동차 객체 구현

- [ ] 자동차 리스트 및 실행 횟수 입력

- [ ] 전진 여부 결정 메서드

- [ ] 이동 결과 출력 메서드

- [ ] 게임 진행

- [ ] 게임 결과 계산

- [ ] 게임 결과 출력

<br>

---

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

<br>

---

## 입출력 및 예외 처리 요구사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

- 시도할 횟수

### 출력

- 차수별 실행 결과

- 단독 우승자 안내 문구 또는 공동 우승자 안내 문구

### 예외

- 잘못된 입력은 `IllegalArgumentException`을 반환

  - 자동차 목록에 대한 잘못된 입력은 `잘못된 입력입니다.`, 이름에 대한 잘못된 입력은 `자동차 이름은 5자 이하만 가능합니다.`로 에러메시지를 반환한다.

  - 시도 횟수에 대한 잘못된 입력은 `잘못된 입력입니다. 경주를 시도할 횟수를 입력해주세요.`로 에러메시지를 반환한다.

<br>

---

## 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는`Randoms` lc `Console` API를 사용하여 구현해야 한다.

    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

        ```java
            Randoms.pickNumberInRange(0, 9);
        ```
  
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.