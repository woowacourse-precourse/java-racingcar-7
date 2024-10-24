# java-racingcar-precourse

## 💪 프로젝트 개요

초간단 자동차 경주 게임을 구현한다.

- 자동차에는 각자의 이름이 존재한다. 이름은 "," 를 기준으로 구분한다.
- 사용자가 입력한 횟수 동안 자동차들은 전진 또는 멈춘다.
- 전진 판단 기준은 0 부터 9까지 무작위 수 중에 4 이상이 나온 경우 해당 자동차는 전진한다.
- 각 시도 횟수 마다 결과를 출력해야한다.
- 시도 횟수가 완료되면 최종 우승자를 출력한다. 이때 최종 우승자는 한 명 이상이다.
- 만약 우승자가 여러 명일 경우에는 ","를 이용해서 구분한다.
- 잘못된 값 입력 시 IllegalArgumentException 발생 후 애플리케이션은 종료된다.

---

## 🖌️구현할 기능 목록

### 입력 관련 기능

- [X] 사용자에게 입력 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

#### - 자동차 이름 입력 기능

- [X] 자동차 입력 메시지를 출력한다.
- [X] 자동차 이름은 쉼표(,)로 구분한다.
- [X] 자동차 이름의 양 끝에 공백이 있는 경우는 지운다.
- [X] 각 이름은 5자 이하만 가능하다.
- [X] 자동차는 2대 이상이여야한다.
- [X] 중복되는 차 이름에 대해 검증해야한다.

#### - 시도할 횟수 입력 기능

- [ ] 시도할 횟수 입력 메시지를 출력한다.
- [ ] 시도할 횟수는 1번 이상이여야한다.(1 이상 허용)
- [ ] 숫자만은 입력받아야한다.

### 출력 관련 기능

#### - 시도 결과 출력 기능

- [ ] 실행 결과는 시도한 횟수마다 출력한다.
- [ ] 각 시도 마다 자동차들의 상태를 출력한다.(toString 활용)

#### - 자동차 경주 결과 출력 기능

- [ ] 최종 우승 메시지를 출력한다.
- [ ] 우승자를 알려준다. 이때 우승자는 2명 이상일 수 있다.
- [ ] 2명 이상인 경우 쉼표(,)를 통해 구분한다.

### 자동차 경주 관련 기능

- [ ] 자동차 객체에는 자동차 이름과 현재 전진한 칸 수를 저장한다.
- [ ] 모든 자동차는 0부터 9 사이의 무작위 값을 각 시도 때 할당받는다.
    - [ ] 랜덤 숫자를 생성 시에 camp.nextstep.edu.missionutils Randoms의 pickNumberInRange()를 활용한다.
- [ ] 그 값이 4 이상이면 전진한다.(객체의 상태를 변경한다.)

---

## ⭐ 이번 주차 요구 사항 및 목표

### 주차 요구 사항

- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
- indent(들여쓰기) depth는 3이 넘지 않도록 한다. 2까지만 허용한다.
- 3항 연산자는 쓰지 않는다.
- 함수가 한 가지 일만 하도록 최대한 작게 만들어라
- JUnit 5와 AsserJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트한다.

### 목표

- 메서드의 역할이 정확히 알 수 있게 구성하고 메서드의 이름과 파라미터도 신경 쓴다.
- 스트림을 사용할 상황이 생기면 적극적으로 사용한다.
- "좋은 코드, 나쁜 코드" 책을 참고하여 클린 코드 작성하기 위해 노력한다.
- 1주차 피드백을 반영하자
    - 메서드와 클래스에 너무 많은 역할을 부여하지 말자. 특히 메서드는 한가지 일만 하도록 한다.
    - 메서드와 클래스에 중복 역할이 있지 않게 설계하자.
    - 상수 관리를 무조건 enum으로 한다고 생각하지 말고 상황에 따라 선택하자.
    - 의존성 주입을 활용하자
    - 테스트 추가 기능 공부한 것을 적용하자.
    - 예외를 던질때 메시지를 포함하여 어떤 예외가 발생했는지 개발자가 구별 가능하게 하자.
    - api로 제공되는 기능을 적극 활용하자!(직접 구현하여 정확성을 낮추고 해석하기 힘든 코드를 작성하는거 금지!)



