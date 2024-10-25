# java-racingcar-precourse

# 구현 요소 및 기능
## Model
### Car
**필드**
- name
- position

**메서드**
- getter()
- moveForward() : 자동차 전진
- printPosition() : 자동차 현재 위치 출력

### OriginInput
**필드**
- carNames
- raceRounds

**메서드**
- getter
- inputCarNames() : 자동차 이름 입력 받기
- inputRaceRounds() : 시도할 횟수 입력 받기

### ProcessedInput
**필드**
- carList
- raceRounds

**메서드**
- getter

### Winner
**필드**
- winnerList

**메서드**
- getter
- printWinner() : 최종 우승자 출력

## Util
### Splitter
**필드**
- carNames

**메서드**
- splitSeparator() : 자동차 이름 문자열 -> 자동차 리스트
- trimCarNames() : 구분자로 분리된 자동차 이름 리스트 -> 공백 제거
- removeEmpty() : 공백 제거 후 자동차 이름 리스트 내 빈 문자열 제거
- createCarList() : 자동차 이름 리스트 -> 자동차 리스트

### Validator
**메서드**
- validBlank() : 비어있는지 검증
- validNumber() : 수로 변환 가능한지 검증
- validNameLength() : 자동차 이름 길이 검증

---


## 입력
### readline() 통해 자동차 이름 입력 받기
**예외 처리**
- 비어있는 값

### readline() 통해 시도 횟수 입력 받기
**예외 처리**
- 비어있는 값
- 숫자 여부(BigInteger 사용해 오버플로우 고려X)

### 구분자 통해 자동차 이름 분리
- ,(콤마) 기준으로 자동차 이름 분리
- 자동차 이름 앞, 뒤에 나오는 공백 삭제
- 공백 만으로 이루어진 자동차 제외
- 이름 길이 : 5자 이하

## 메인 로직
### 시도 횟수 만큼 각 자동차 이동 수행
- random() 통해 무작위 값 도출
- 무작위 값이 4 이상이면 자동차 위치 +1
- 자동차 별 위치 출력

### 자동차 경주 종료시 우승 자동차 도출
- 자동차 별 위치 비교해 가장 앞선 차 우승 자동차 리스트에 add

### 최종 결과 출력
- 우승 자동차 출력, 동률일 경우 ,(콤마)로 구분해 출력