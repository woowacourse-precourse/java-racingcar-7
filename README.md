# java-racingcar-precourse

## 기능 목록

추후에 변경되거나 확장될 수 있다고 생각되는 기능은 `(확장가능)` 으로 표기한다.

스스로 판단한 내용은 `(판단)` 으로 표기한다.

### 1. 자동차의 이름을 입력받는 기능

- [x]  자동차의 이름을 입력받기 위한 문자열을 출력한다.
- [x]  자동차의 이름을 입력받는다.
- [x]  자동차 경주 게임의 이동 횟수를 입력받기 위한 문자열을 출력한다.
- [x]  자동차 경주 게임의 이동 횟수를 입력받는다.

### 2. 자동차들의 이름을 분리한다.

> 입력되는 자동차 이름 문자열을 분리하는 기준이 추후에 변경될 수 있다.
>
- [x]  입력으로 들어온 자동차들의 이름을 분리한다. `(확장가능)`
  - [x]  앞뒤 공백은 제거한다. `(판단)`
  - [x]  자동차 이름은 `,` 를 기준으로 분리한다.

### 3. 자동차 이름과 이동 횟수를 검증한다.

> 검증 조건이 추가되거나 변경될 가능성이 있다.
>
- [ ]  입력으로 들어온 자동차 이름과 라운드 수를 검증한다. `(확장가능)`
  - [x]  자동차들의 이름이 1자 미만이라면 `IllegalArgumentException` 을 발생시킨다. `(판단)`
  - [x]  자동차들의 이름이 5자 초과라면 `IllegalArgumentException`을 발생시킨다.
  - [ ]  게임의 라운드 수가 1 미만이라면 `IllegalArgumentException` 을 발생시킨다. `(판단)`
  - [ ]  분리된 자동차들이 없다면 `IllegalArgumentException` 을 발생시킨다. `(판단)`

### 4. 자동차들을 만든다.

- [ ]  이름을 부여한 자동차를 만든다.

### 5. 자동차들을 전진시킨다.

> 추후에 자동차를 전진시키는 조건이 변경될 가능성이 있다.
>
- [ ]  자동차들을 이동 횟수만큼 자동차들을 전진시킨다. `(확장가능)`
  - [ ]  0~9까지의 무작위 값을 추출하여 4 이상이라면 전진하고 3 이하라면 멈춘다.

### 6. 자동차 경주 게임의 우승자를 선정한다.

> 추후에 경주 게임의 우승자를 선정하는 기준이 변경될 수 있다.
>
- [ ]  자동차 경주 게임의 우승자들을 선정한다. `(확장가능)`
  - [ ]  우승자들은 여러명일 수 있다.

### 7. 자동차 경주 게임의 결과를 출력하는 기능

- [ ]  자동차 경주 게임의 결과를 출력한다.
  - [ ]  자동차의 이름과 전진한 길이를 `-` 로 출력한다.
- [ ]  자동차 경주 게임의 우승자들을 출력한다.
  - [ ]  우승자는 여러명일 수 있고 `,` 를 기준으로 구분한다.