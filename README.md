# java-racingcar-precourse

## 구현 방향
- 객체지향의 원칙을 최대한 지키며 작성
- MVC 모델을 사용하여 구현
- 단위 테스트 및 통합 테스트 작성
- 코드 인벤션에 위배되지 않도록 작성

## 객체 구성도

![제목 없는 다이어그램 drawio](https://github.com/user-attachments/assets/783afb44-49b5-41ee-826b-e299d3b5a6e7)

## 기능 요구 사항

### View

- ReaderHelper
    - [X] 입력을 받아 쉼표(,)를 기준으로 선수 이름을 반환
    - [X] 입력을 받아 게임을 진행할 횟수를 반환
- PrintHelper
    - [X] 플레이어 객체 리스트를 받아 게임 상황 출력
    - [X] 우승자 리스트를 받아 출력

### Model

- RacingGame
    - [X] 출전 선수 이름 리스트를 받아 플레이어 세팅
    - [X] 게임을 진행시킴
    - [X] 우승자 리스트를 반환
- Car
    - [X] 출전 선수 이름을 받아 플레이어 생성
    - [X] 출전 선수 점수 반환
    - [X] 출전 선수 이름 반환
    - [X] 전진 시도

### Controller

- GameController
    - [X] 전체 흐름 관리
    - [X] 선수 이름과 게임 진행 횟수 설정
    - [X] 게임 진행
    - [X] 게임 마무리

### Validate

- Validator
    - [X] 출전 선수 이름이 5자를 초과할 시 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - [X] 출전 선수 이름이 공백일 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - [X] 출전 선수 이름 중복될 시 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - [X] 출전 선수 이름이 영어가 아닌 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - [X] 게임을 진행할 횟수를 입력 받을때 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

### Factory

- CarRacingFactory
    - [X] 출전 선수 생성
    - [X] 게임 생성