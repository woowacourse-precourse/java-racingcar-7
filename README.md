# java-racingcar-precourse

## 1주차 피드백 반영

---
> 1주차 과제를 진행하면서 코드리뷰를 통해 많은 피드백을 받았습니다. (도와주신 모든 분들 감사합니다!!)
> 2주차 과제에서 해당 피드백들을 최대한 반영하려고 합니다. 아래는 피드백 내용입니다!

- [ ] 상수는 상수 클래스를 별도로 관리한다.
- [ ] 원시배열이 아닌 컬렉션을 사용한다.
- [ ] 에러 메시지를 구체적으로 작성한다.
- [ ] 서비스 클래스로 분리한다.
- [ ] 입력받는 부분을 분리한다.

## 요구사항 정리

---

> **학습목표**
>
> - 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
> - 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 동작하는지 테스트한다.
> - 1주차 공통 피드백을 **최대한** 반영한다. (1주차에서 반영 안된 사항)
    >   - Java에서 제공하는 API를 적극 활용한다.
>   - 배열 대신 컬렉션을 사용한다.

### 기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.
> - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
> - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
> - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
> - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
> - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
> - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
> - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
> - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
- 입력
    - 경주할 자동차 이름(이름은 쉼표 기준으로 구분)
      ```text
      pobi,woni,jun
      ```
    - 시도할 회수
      ```text
      5
      ```

<br>

- 출력
    - 차수별 실행 결과
      ```text
      pobi : --
      woni : ----
      jun : ---
      ```
    - 단독 우승자 안내 문구
      ```text
      최종 우승자 : pobi
      ```

    - 공동 우승자 안내 문구
      ```text
      최종 우승자 : pobi, jun
      ```

### 프로그래밍 요구 사항
- indent depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


## 과제 분석

---
> 1주차 과제는 `왜?`라는 질문으로 문제에 대해 필요한 요소들을 하나하나씩 확인해서 정리했습니다.
> 이번 과제에서는 사용자의 관점, 개발자의 관점에을 나눠서 과제를 분석했습니다.

### 사용자 관점
- 프로그램 동작 과정
    1. 게임을 시작한다.
    2. 사용자는 경주할 자동차를 입력한다.
    3. 사용자는 시도할 횟수를 입력한다.
    4. 차수별 실행 결과를 출력한다.
    5. 최종 우승자를 출력한다.
    6. 게임을 종료한다.


### 개발자 관점
- 프로그램 동작 과정
    1. 사용자가 입력한 자동차의 이름들을 저장한다.
    2. 사용자가 입력한 횟수를 저장한다.
    3. 횟수만큼 게임을 진행한다.
        - 각 차수마다 자동차들은 랜덤으로 이동한다.
        - 이동 결과를 화면에 출력한다.
    4. 마지막 차수에서 가장 많이 전진한 자동차를 우승자로 정한다.
        - 우승자는 한 명 이상일 수 있다.
    5. 최종 우승자를 화면에 출력한다.

### 예외
- 입력값
    - 입력한 이름이 공백일 경우
    - 입력한 이름이 중복일 경우
    - 입력한 이름이 5자 초과할 경우


## 기능 설계

---

### 고민 사항
#### 데이터를 어디에 저장할까?
- 생각해보기
  - 게임 진행 횟수 
  - 자동차의 이름
  - 각 자동차의 이동
  - 우승자 이름


- 나누기
  - 게임
    - 횟수
    - 자동차 리스트
    - 우승자 리스트
    
  - 자동차
    - 이름
    - 이동

  