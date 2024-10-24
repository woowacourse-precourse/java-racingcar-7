# java-racingcar-precourse

### 자동차 경주

## 📚 구현 기능 목록

### 📌 자동차 생성

- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며, 5자 이하로 입력한다.
- [ ] 경주를 시도할 횟수를 입력한다.
- [ ] 사용자가 입력하는 값은 ``camp.nextstep.edu.missionutils.Console``의 ``readLine()``을 활용한다.

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5
```

#### 🚫 예외처리

- [x] 구분자가 쉼표(,)가 아닐 경우(공백 포함), ``IllegalArgumentException``을 발생시킨다. (전체 테스트)
- [x] 입력의 시작이 쉼표(,)일 경우, ``IllegalArgumentException``을 발생시킨다. (전체 테스트)
- [x] 입력의 마지막이 쉼표(,)일 경우, ``IllegalArgumentException``을 발생시킨다. (전체 테스트)
- [x] 아무런 값도 입력하지 않은 경우("", " "), ``IllegalArgumentException``을 발생시킨다. (전체 테스트)

- [x] 자동차 이름 5글자를 초과할 경우, ``IllegalArgumentException``을 발생시킨다. (자동차 별 테스트)
- [x] 중복된 이름의 자동차를 입력할 경우, ``IllegalArgumentException``을 발생시킨다. (자동차 별 테스트, 자동차 비교)
- [x] 아무런 값을 입력하지 않았을 경우, ``IllegalArgumentException``을 발생시킨다. (자동차 별 테스트)
- [x] 경주에 참가하는 자동차가 2대 이상이 아닐 경우, ``IllegalArgumentException``을 발생시킨다. (자동차 별 테스트, 자동차 수)
- [x] 자동차 이름에 공백을 허용하되, 영어 대소문자, 숫자, 한글을 제외한 나머지 문자를 입력할 경우, - [ ] 입력의 마지막이 쉼표(,)일 경우, ``IllegalArgumentException``을
  발생시킨다. (자동차 별 테스트)
  ex) ``po bi, 우니, Ju nn``

- [x] 경주를 시도할 횟수에 1보다 작은 수를 입력한 경우, ``IllegalArgumentException``을 발생시킨다.
- [x] 경주를 시도할 횟수를 입력하지 않은 경우(공백 입력), ``IllegalArgumentException``을 발생시킨다.
- [ ] 경주를 시도할 횟수에 숫자가 아닌 값을 입력한 경우, ``IllegalArgumentException``을 발생시킨다.

### 📌 자동차 경주 게임 진행

- [ ] 입력한 경주 시도 횟수 동안 n대의 자동차는 전진 또는 정지할 수 있다.
    - [ ] 0에서 9 사이의 무작위 값이 4 이상일 경우 전진한다.
    - [ ] 0에서 9 사이의 무작위 값이 4 미만일 경우 정지한다.
    - [ ] Random 값 추출은 ``camp.nextstep.edu.missionutils.Randoms``의 ``pickNumberInRange()``를 활용한다.
- [ ] 경주 게임 진행 횟수에 따라 각각의 자동차들이 움직인 횟수를 ``-``로 출력한다.
- [ ] 각 실행 결과들은 ``\n``으로 띄워서 출력한다.

```text
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
```

### 📌 우승자 결정

- [ ] 경주 시도 횟수에 도달하면, 각각의 자동차들 중 가장 많이 이동한 자동차(``-``가 가장 많은 자동차)의 이름을 출력한다. (우승자는 한 명 이상일 수 있다)
    - [ ] 우승자가 한 명일 경우, 해당 우승자만 출력한다.
      ```text
      최종 우승자 : pobi
      ```
    - [ ] 우승자가 두 명 이상일 경우, 쉼표와 공백(, )으로 구분하여 우승자를 출력한다.
      ```text
      최종 우승자 : pobi, jun
      ```
