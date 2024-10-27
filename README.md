# java-racingcar-precourse

---

### 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

- 전진은 한 칸만 이동한다.

### 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

### 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

- 자동차 이름 구분자 ,
- 5자 이하 1자 이상
- 특수문자 가능
- 공백문자 불가능

### 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

- 한 번의 모든 차 이동은 한 번의 라운드로 취급
- 총 라운드 조건은 0이상 MAX_VALUE까지 이다.

### 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

- Randoms API를 이용해서 무작위 값의 List를 구한다.

### 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

- 우승자 List에 저장

### 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

- output을 관리하는 클래스가 있으면 좋을 듯 하다.

### 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- 입력에서의 값만 검사하면 되니, 따로 Validator를 빼서 입력 값을 초기에 검사한다.
- List<Validator>로 만들어 모든 validator를 검사한다.

---

## `Model`

### 1. Car

- 움직인다.({name} : ---- 의 형태로 String return)
- maxPosition보다 자신의 위치가 더 큰지 확인
- top 랭커에 부합하는지 확인 후 자신 return

### 2. Cars

- 모든 차들에 움직임 요청한다. ("{name} : ----" + \n + "{name} : ----"의 형태의 반환값)
- 우승자를 찾는다.(maxPosition을 찾고, 각 차들의 위치로 우승자를 찾는다.)

### 3. RandomNumbers

- 차들의 갯수만큼 랜덤 숫자를 저장한다.

### 4. OutputFormat

- 각종 출력 형식을 저장

### 5. RacingRoundResultRecorder

- 각 라운드 실행 결과 저장
- 마지막 라운드 이후 TopRanker 저장
- 모두 StringBuilder로 출력 위한 저장

## `Service`

### 1. RandomNumberGenerator

- RandomNumbers를 생성한다.
- Randoms API를 사용

### 2. RacingService

- Cars를 준비
- for문을 통해 모든 라운드를 record 요청

### 3. RacingRound

- 한 라운드를 record

### 4. ValidatorService

- 입력받은 inputNames와 roundCount를 검증(형식, 길이 등)

## `Validator`

**1. InputNameValidator**

- InputNameCountValidator : 이름은 최대 99개까지 입력 가능
- InputNameCharacterValidator : 이름 내 공백문자 검증(공백문자 시 예외처리)
- InputNameDuplicationValidator : 이름 중복 검증(중복 시 예외)
- InputNameLengthValidator : 이름 길이 검증(범위 밖일 시 예외)
- InputNameValidatorsFactory : List<InputNameValidator>로 검증 리스트 객체 생성

**2. InputRoundValidator**

- InputRoundFormatValidator : 시도 횟수 숫자인지 검증
- InputRoundRangeValidator : 시도 횟수 1이상 Integer.MAX_VALUE 이하 인지 검증
- InputRoundValidatorsFactory : List<InputRoundValidator>로 검증 리스트 객체 생성
