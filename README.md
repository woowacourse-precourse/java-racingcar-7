# Java Racing Car Precourse

# 기능 요구 사항

---
> 초간단 자동차 경주 게임을 구현합니다.

- 여러 대의 자동차가 주어진 횟수 동안 전진 또는 멈춥니다.
- 각 자동차는 이름을 가지며, 경주가 진행될 때 이름이 함께 출력됩니다.
- 자동차 이름은 쉼표(,)로 구분하며 5자 이하여야 합니다.
- 사용자는 자동차가 몇 번 이동할지 횟수를 입력할 수 있습니다.
- 0부터 9 사이의 무작위 값이 4 이상일 때만 전진합니다.
- 경주가 종료되면 우승자를 표시하며, 우승자는 여러 명일 수 있습니다.
- 여러 명이 우승할 경우 이름을 쉼표(,)로 구분하여 출력합니다.
- 잘못된 입력 값이 주어질 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료합니다.

# 도메인 설계

---
## 상위 수준 설계
![상위 수준 설계](https://github.com/user-attachments/assets/c78e9534-2f6b-444c-b850-52e264b472df)

## 개별 객체 설계
![개별 객체 설계](https://github.com/user-attachments/assets/cdc2d579-754d-4b4c-a1fa-65000d33595c)

## 애그리거트 단위
![애그리거트 단위](https://github.com/user-attachments/assets/62cf88cd-a2d9-4ae9-a859-fcaa03685972)

# 객체 요청 흐름
![객체 요청 흐름](https://github.com/user-attachments/assets/c00fe434-42d8-4321-9dbd-f5b13ae7d7a1)

# 구현 계획

---
## Member
- **name** : `String`  
  각 자동차의 이름을 관리합니다.

## Car
- **member** : `Member`
- **racingDistance** : `Long`  
  자동차와 이동 거리를 관리합니다.

## Race
- **cars** : `List<Cars>`
- _`getSortedRaceResults`_ : `List<Car>`  
  이동 거리가 많은 순서대로 결과를 반환합니다.

## RaceResult
- **raceResult** : `List<Race>`
- _`performAllRaces`_ : `List<Race>`  
  경주를 횟수만큼 실행하고 각 결과를 리스트로 반환합니다.
- _`getRaceWinnerList`_ : `List<Car>`  
  경주 결과에서 1등을 리스트 형태로 반환합니다.

---
## RaceController
사용자의 입력/출력 기반으로 **Service**를 호출합니다.
- _`executeRace()`_  
  경주 로직을 실행하고 결과를 반환합니다.

## Parser
사용자의 **Input**을 사용 가능한 구조로 변경합니다.

## ConsoleInputHandler
- _`getRaceRequest()`_

  사용자의 입력을 받아서 `reqeustDTO`를 제작합니다.

## ConsoleOutputHandler
- _`displayResults()`_

  `race`결과를 **console**로 출력합니다.

## RaceResultFormatter
- `convertRaceProgressToString()`
- `convertWinnersToString()`

  각 시행 횟수 마다 경기 결과를 출력하고, 우승자를 출력하기 위한 `String`을 생성합니다.

## Validator
- _`validateNameList()`_
- _`validateNameList()`_

  사용자 입력 값의 유효성을 검사하며, 유효하지 않은 경우 `IllegalArgumentException`을 발생시킵니다.

---
## Service
- _`runAllRaces()`_  
  도메인 로직을 실행하고 우승자를 DTO 형태로 반환합니다.

## RaceEngine
- _`performRace()`_

  레이스를 수행 횟수에 맞게 실행시켜 결과를 `RaceResult`로 반환합니다.

## CarFactory
- `getCarList()`

  `List<String>`을 바탕으로 List<Car>를 제작해 반환합니다.

---
## Util
도메인 로직에서 **난수 생성** 로직을 수행합니다.
- **RaceRandomGenerator (interface)**
    - _`getRandomValue(default)`_  
      0~9 사이의 난수를 반환합니다.
- **RaceRandomGeneratorImpl (singleton)**
    - _`getInstance()`_  
      Singleton 인스턴스를 반환합니다.
    - _`canMoveForward()`_  
      난수를 통해 4 이상이 나오면 전진할 수 있다고 판단합니다.
---
## DTO
컨트롤러와 서비스 간의 데이터를 전달하고 변환합니다.
- _`RaceRequestDTO`_  
  이름과 횟수를 컨트롤러에서 서비스로 전달합니다.

- _`RaceResponseDTO`_  
  `RaceResult`의 데이터를 컨트롤러에 전달합니다.


# 예외 처리 항목

---
1. 이름, 횟수 입력이 공백인 경우
2. 각 이름의 길이가 6이상인 경우
3. 이름이 중복된 경우
4. 횟수 입력이 양의 정수가 아닌 경우
5. 횟수 입력이 long의 범위를 벗어나는 경우