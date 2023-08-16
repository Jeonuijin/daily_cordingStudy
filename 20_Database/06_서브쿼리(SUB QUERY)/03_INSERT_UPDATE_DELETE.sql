-- INSERT, UPDATE, DELETE 내에서의 서브쿼리 사용
/*
■ INSERT 문
INSERT INTO 테이블명
       (컬럼명1, 컬럼명2, ..., 컬럼명n)
VALUES (값1, 값2, ... , 값n);  

■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]

■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
===================================*/

/*
■ INSERT 문
INSERT INTO 테이블명
       (컬럼명1, 컬럼명2, ..., 컬럼명n)
VALUES (값1, 값2, ... , 값n);  
*************/
SELECT * FROM BOOK;
INSERT INTO BOOK
        (BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (30, '자바란 무엇인가?', 'ITBOOK', 30000);
COMMIT;
INSERT INTO BOOK
        (BOOKID, PUBLISHER, BOOKNAME, PRICE)
 VALUES (31, 'ITBOOK', '자바란 무엇인가(개정)', 35000);
COMMIT;
----
SELECT * FROM BOOK ORDER BY BOOKID DESC;

INSERT INTO BOOK
VALUES (32, '자바란 무엇인가(개정3)', 'ITBOOK', 35000);
COMMIT;

INSERT INTO BOOK
VALUES (33, '자바란 무엇인가(개정4)', '', 35000);
COMMIT;

INSERT INTO BOOK
        (BOOKID, BOOKNAME, PRICE)
VALUES (34, '자바란 무엇인가(개정5)', 35000);
COMMIT;

SELECT MAX(BOOKID) FROM BOOK;    --만약 데이터값이 NULL 일경우 NVL(MAX(BOOKID),설정값)을 사용하면 설정값으로 값이 나오게된다.
INSERT INTO BOOK
        (BOOKID, BOOKNAME, PRICE)
VALUES (34, '자바란 무엇인가(개정5)', 35000);
COMMIT;
------------------  
--일괄입력 : 테이블의 데이터를 이용해서 데이터를 한번에 입력처리
----IMPORTED_BOOK ====> BOOK 일괄입력
INSERT INTO BOOK
SELECT * FROM IMPORTED_BOOK;

/*■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]
***************/
SELECT * FROM CUSTOMER;
--박세리 주소 수정 : 대한민국 대전 --> 대한민국 부산
SELECT * FROM CUSTOMER WHERE NAME = '박세리';
UPDATE CUSTOMER
    SET ADDRESS = '대한민국 부산' 
  WHERE NAME = '박세리'
;
--박세리 주소, 전화번호 : '대전', '010-1111-1111'
UPDATE CUSTOMER
    SET ADDRESS = '대전', PHONE = '010-1111-1111'
  WHERE NAME = '박세리'
;
-------------------
--박세리 주소 수정 : 김연아와 동일하게 변경
SELECT ADDRESS FROM CUSTOMER WHERE NAME = '김연아';

UPDATE CUSTOMER
   SET ADDRESS = (SELECT ADDRESS FROM CUSTOMER WHERE NAME = '추신수'),  --데이터가 두개이상 오면 안된다.(있거나 없거나)
        PHONE = (SELECT PHONE FROM CUSTOMER WHERE NAME = '추신수')  
 WHERE NAME = '박세리'
;
SELECT * FROM CUSTOMER WHERE NAME = '박세리';
/*
■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
*********************/
-- 책 제목이 자바로 시작하고 출판사가 ITBOOK인 데이터 삭제
SELECT * FROM BOOK WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK';
DELETE FROM BOOK WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK';
-- 책 ID가 30보다 크거나 같은 데이터 삭제
SELECT * FROM BOOK WHERE BOOKID >= 30;
/* --혹시 모를 상황에 대비해서 DELETE기능 사용 후 주석처리하는것이 좋음
DELETE FROM BOOK 
WHERE BOOKID >= 30;
*/

