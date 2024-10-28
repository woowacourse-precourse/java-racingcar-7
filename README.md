# java-racingcar-precourse

- 주어진 횟수 동안 n대의 자동차는 전진 혹은 정지한다.
- 각 자동차에 이름을 부여할 수 있다. 차가 전진할 때 이름을 출력한다.
- 이름은 쉼표`,`를 구분으로 하고 5자 이하이다.
- 몇 번 이동할 지 입력할 수 있다.
- 전진 조건은 0~9 사이 무작위 숫자 중 4이상이다.
- 게임 완료 후 우승자를 출력한다. 한 명 이상일 수 있다. 쉼표`,`로 구분하여 출력한다.
- 잘못된 값을 입력한 경우 `IllegalArgumentException`를 발생한 후 종료한다.

---
- Input
  - 
  - inputCarName
    - 자동차의 이름을 받는다.
  - printInputCarNameMessage
    - 이름을 받을 때 메세지를 출력한다.
  - inputTrialNumber
    - 시도할 횟수를 받는다.
  - printInputTrialNumberMessage
    - 횟수를 받을 때 메세지를 출력한다.
- Parser
  - 
  - parseCarName
    - 입력받은 이름을 쉽표`,`를 기준으로 나눈다.
  - parseTrialNumber
    - 입력받은 횟수를 숫자로 변환한다.
- InputValidation
  - 
  - validateNull
    - 입력 값이 `null`인지 검사한다.
  - validateCarName
    - 이름이 5자 이하인지 검사한다.
  - validateTrialNumber
    - 시도 횟수가 숫자인지 검사한다.
- Car
  - 
  - getCarName
    - 차 이름을 반환한다.
  - getDistance
    - 전진한 거리를 반환한다.
  - getRandomNumber
    - 전진하기 위한 조건인 난수를 반환한다.