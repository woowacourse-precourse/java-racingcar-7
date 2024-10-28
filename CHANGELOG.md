commit 742a80318ef7f525feaf8f78606376cf2107ddd1
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 20:48:33 2024 +0900

    test(application): 단위테스트 추가

commit 3b12e2cec93e67643973b3d2ca4c1268a900d08d
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 20:48:16 2024 +0900

    fix(util): InputSplitter에 공백 제거 추가
    
    - split 된 문자열의 공백을 제거하여 "name"과 " name"이 다른 이름으로 인식되는 오류 해결

commit 6e1921a596405579e50756664664408d3a65ddf5
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 17:32:49 2024 +0900

    test(service): 고정된 생성기와 이동 전략을 사용하여 RacingService 테스트 추가
    
    - RacingService의 초기화 및 playRound 기능에 대한 테스트 추가
    - FixedGenerator ThresholdMoveStrategy를 사용하여 자동차 이동 조건 검증

commit 64b33a0da0e33a76c57de402930575181c672154
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 17:08:37 2024 +0900

    test(validator): ErrorMessages 상수를 사용하여 ValidatorFacade 테스트 추가
    
    - ValidatorFacade에 대한 테스트 케이스 추가, 자동차 이름, 라운드, 자동차 개수 검증 포함
    - 테스트 코드에서 예외 메시지 검증 시 ErrorMessages 상수를 사용하여 메시지 일관성 확보

commit 1efadb1dd4db6558b7db62a5d325a82b0a74e9cd
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 16:08:55 2024 +0900

    feat(validator): 검증 메시지 관리를 위한 enum 추가

commit ef554a4535415dd2270ecc1e2d9d4457dcbd0854
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 15:42:20 2024 +0900

    feat(validator): 이름 중복 검증 추가 및 제네릭 타입 CarNames로 변경
    
    - validateUniqueNames 메서드 추가로 이름 중복 검증 로직 추가
    - Validator 제네릭 타입을 String에서 CarNames로 변경하여 전체 이름 목록 검증

commit d4701d291fc566cd69ca77096d6112945c4538e5
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 15:12:16 2024 +0900

    feat(factory): Car와 Cars 객체 생성을 위한 Factory 클래스 추가
    
    - CarFactory와 CarsFactory를 통해 Car 및 Cars 객체 생성 로직 분리
    - RacingService에서 객체 생성 책임을 분리

commit a0838a68279ea539fa712dfd9861821f2c56ab71
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 15:01:50 2024 +0900

    refactor(util, generator): generator 패키지 분리 및 InputSplitter 유틸성 클래스화
    
    - generator 관련 파일을 util 패키지에서 분리하여 독립된 패키지로 이동
    - InputSplitter를 유틸리티 클래스로 변경하고 static 메서드로 구조 개선
    - InputParser 인터페이스 삭제

commit a211d74ac66041f5e867d76ae122e0f65412aebf
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:43:18 2024 +0900

    refactor(view): ViewFacade를 추가하여 InputView와 OutputView 통합 관리
    
    - InputView와 OutputView를 ViewFacade에서 통합 관리하여 의존성 주입 간소화
    - 싱글톤 인스턴스를 직접 접근하던 방식에서 ViewFacade를 통해 접근하도록 구조 변경

commit 9ddbbcff56e98c0177a2764ed13869ea43b62907
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:28:28 2024 +0900

    refactor(validator): ValidatorFacade가 인터페이스에 의존하도록 수정
    
    - ValidatorFacade에서 구체적인 검증 클래스 대신 Validator 인터페이스 사용

commit 9bfc173131df508da6ce557c7b83d757084c9918
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:24:03 2024 +0900

    refactor(Controller): ValidatorFacade와 RacingService를 통한 의존성 간소화
    
    - CarController에서 개별 검증 및 자동차 초기화 로직을 ValidatorFacade와 RacingService로 분리

commit b05b650c6b05774801f9b75b6b3b0a7b47122b74
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:22:55 2024 +0900

    refactor(service): 자동차 초기화 및 이동 로직을 RacingService로 분리
    
    - 자동차 초기화 로직과 매 라운드 이동 로직을 Controller에서 RacingService로 이동
    - Controller의 역할을 간소화하고 서비스 계층에서 비즈니스 로직을 처리하도록 개선

commit 0753ec6bc29186ad2c577bc1857d61eb864e6bd3
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:22:06 2024 +0900

    feat(validator): 검증 로직 통합을 위한 ValidatorFacade 클래스 추가
    
    - CarNameValidator, RoundValidator, CarCountValidator를 하나의 인터페이스로 통합
    - 자동차 이름, 라운드 수, 자동차 개수에 대한 검증 로직을 단일 진입점에서 호출 가능

commit e7a03c44a44f49dcae7dd7debb7d0673cea2bb1f
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:21:23 2024 +0900

    refactor(view): OutputView의 출력 로직 리팩토링
    
    - showWinners 메서드에서 StringBuilder 대신 Stream API 활용으로 코드 간결화

commit 3a3aa358c96e1e5a5f583dccae78e5dd77f7d21e
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:19:44 2024 +0900

    refactor(model): getWinners 메서드를 스트림과 람다로 리팩토링
    
    - 정렬 대신 스트림을 이용해 최대 위치 값을 구하고, 해당 위치와 동일한 자동차 필터링

commit ef0512f4fe8fc11e089fcb9c18c244be93147f99
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:15:15 2024 +0900

    feat(validator): RoundValidator 구현체 생성
    
    - 정수가 아닌 입력이 들어올 시 예외처리
    - int의 범위를 넘는 정수가 들어왔을 시 예외처리
    - 1 미만의 정수가 입력됐을 시 예외처리

commit 0226f3dc1c9615371208f2ae77d0d72366249ce5
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:14:14 2024 +0900

    feat(validator): CarNameValidator 구현체 생성
    
    - 차 이름이 공백일 시 예외처리
    - 차 이름이 5자를 초과할 시 예외처리

commit c1fa0461a6a2598d7328735ff73d72af30494112
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:13:24 2024 +0900

    feat(validator): CarCountValidator 구현체 생성
    
    - 차의 개수가 1개 이하라면 예외처리

commit 47ef011478a68be690391051b985097770409143
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:10:57 2024 +0900

    feat(validator): 입력 검증을 위한 Validator 인터페이스 추가
    
    - 제네릭 타입 <T>을 이용해 다양한 입력 타입에 대한 유효성 검사 지원

commit 99ab25620e2bb642ee4837a43d838741e66f362c
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:09:02 2024 +0900

    feat(exception): 차 이름 및 라운드 예외 처리를 위한 exception 클래스 추가
    
    - InvalidCarNameException: 잘못된 자동차 이름 입력 예외 처리
    - InvalidRoundException: 잘못된 라운드 수 입력 예외 처리
    - InvalidCarCountException: 자동차 수가 1개 이하일 때 발생하는 예외 처리

commit e2516df39299d806cbac6f354f16a2a6527d1abd
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Mon Oct 28 14:03:39 2024 +0900

    refactor(strategy): MoveStrategy와 CarMoveStrategy를 strategy 패키지로 이동

commit bbfa084b31c21e8a4cbab57a514755215ae97e9d
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sun Oct 27 18:20:55 2024 +0900

    refactor(model): 자동차 이름 관리를 위한 CarNames 일급 컬렉션 도입
    
    - CarNames 일급 컬렉션을 추가하여 자동차 이름 목록을 관리하고 관련 로직을 캡슐화
    - String[] 대신 CarNames를 사용하도록 CarController와 InputParser 구조 개선

commit 148baba7500f9a6593529b5157109190a92f46bc
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sun Oct 27 18:04:47 2024 +0900

    refactor(parser): InputParser 인터페이스 도입
    
    - InputSplitter를 InputParser 인터페이스 기반으로 리팩토링
    - CarController와 Application에서 InputParser 인터페이스를 사용해 의존성 주입

commit 76154dc0dd8b69ae9436f6bb94d34bf6f99b268b
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sun Oct 27 17:53:57 2024 +0900

    refactor(util): Generator<T> 인터페이스 도입
    
    - RandomNumberGenerator를 Generator<T> 인터페이스 기반으로 리팩토링하여 IntegerGenerator로 구현
    - CarController와 Application에서 Generator<Integer> 인터페이스를 사용해 의존성 주입

commit 8401903a237d42c9ce65e9d937cf93f297f6e2c8
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sun Oct 27 17:04:47 2024 +0900

    refactor(util, movement): MoveStrategy 인터페이스 도입 및 service 구조를 util로 개선
    
    - CarMoveManager를 MoveStrategy 인터페이스 기반으로 리팩토링하고 CarMoveStrategy로 구현
    - CarController와 Application에서 MoveStrategy 인터페이스를 사용해 의존성 주입
    - 기존 service 패키지의 클래스를 util 패키지 내로 재구성
    - 이동 전략 변경 시 유연성과 확장성을 확보

commit 23bc63bf2912aa03a8e15c79cfd1bbd97875eb6b
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sun Oct 27 16:45:45 2024 +0900

    refactor(view): InputView와 OutputView에 싱글톤 패턴 적용
    
    - InputView와 OutputView를 싱글톤 패턴으로 변경하여 애플리케이션 전반에서 단일 인스턴스만 생성되도록 수정
    - CarController와 Application에서 InputView와 OutputView의 싱글톤 인스턴스를 사용하도록 업데이트

commit 3a435ebff74be298725cbd9733d0f87b4964d18f
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:17:42 2024 +0900

    chore: Application 클래스에 게임 실행을 위한 구성 요소 추가
    - CarController와 필요한 서비스 및 뷰 객체 생성 및 초기화
    - main 메서드에서 자동차 경주 게임 실행 시작

commit 1c97009e9c3dd94d9d9c8d5f9655adf9c1347bde
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:17:10 2024 +0900

    feat(controller): CarController 클래스 생성 및 게임 진행 로직 구현
    - 사용자 입력을 받아 자동차 경주 게임을 시작하고 결과를 출력
    - CarMoveManager, InputSplitter, RandomNumberGenerator 등의 서비스 및 뷰와 연동
    - 각 라운드마다 결과를 출력하고 최종 우승자를 표시

commit a3cc6925709f8df90a5028a4ef5e21f41ad471e8
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:16:24 2024 +0900

    feat(service): RandomNumberGenerator 클래스 생성 및 난수 생성 기능 추가
    - MIN_NUMBER와 MAX_NUMBER 범위 내에서 난수를 생성하는 gernerateRandomNumber 메서드 구현

commit 53c5a0d8d83457ac1db95ddc8b048cf1616d5d3a
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:16:04 2024 +0900

    feat(service): InputSplitter 클래스 생성 및 입력 분리 기능 추가
    - 입력 문자열을 ',' 구분자로 분리하여 자동차 이름 배열 반환

commit 5de795c4bdc92a563721e570cbcc3ff05eebb8ed
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:12:55 2024 +0900

    feat(service): CarMoveManager 서비스 클래스 생성 및 이동 여부 판단 로직 추가
    - 자동차가 이동할 수 있는지 판단하는 canMove 메서드 구현
    - MOVE_THRESHOLD 상수를 사용하여 이동 기준값 설정

commit dc4a8d1b25012551bd434295ee895d77bff099a6
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:11:32 2024 +0900

    feat(view): OutputView 출력 클래스 생성 및 게임 결과 출력 기능 추가
    - Cars와 Car 객체의 상태를 콘솔에 출력하여 게임 진행 상황 표시
    - 각 라운드 결과와 최종 우승자 출력 기능 구현
    - showRoundResult와 showWinners 메서드 추가

commit 8d310552f7e060ab6e5fb69cfc1ea0307baa5f68
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:10:39 2024 +0900

    feat(view): InputView 입력 클래스 생성
    - 자동차 이름과 시도 횟수를 입력받기 위한 메시지 출력 및 입력 기능 구현
    - CAR_NAME_INPUT_MESSAGE와 TRY_COUNT_INPUT_MESSAGE 상수를 통해 메시지 관리

commit ded9f451893a038361e609356e3476fa49895297
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:08:41 2024 +0900

    feat(model): Cars wrapper 클래스 생성
    - Car 객체 목록을 관리하는 Cars Wrapper 클래스 생성
    - Car를 위치에 따라 내림차순 정렬하는 함수 구현
    - 우승자 리스트 반환 함수 구현

commit d4ce3c058487fb36139efe74f1da48798b644834
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 18:06:11 2024 +0900

    feat(model): Car 클래스 생성
    - 이름과 위치 필드 추가
    - 이름와 위치의 get 메소드 구현
    - move 함수를 통해 위치 변경

commit 861fb9a1f15912d40851c21a40fbbce5dc35dfcf
Author: Jinwoo Kim <99790907+jinu0328@users.noreply.github.com>
Date:   Sat Oct 26 14:29:04 2024 +0900

    docs(readme): 기능 요구사항 정리

commit 5ec134471d4ad7798af498020b4179d887b21a52
Author: woowabrie <buyong.jo@woowahan.com>
Date:   Tue Oct 22 14:26:38 2024 +0900

    feat: setup project
