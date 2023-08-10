--테이블 조인(JOIN) : 2개 이상의 테이블 데이터를 연결해서 1개의 테이블인것처럼 사용
SELECT * FROM CUTOMER WHERE CUSTID = 1; --  박지성
SELECT * FROM ORDERS WHERE CUSTID = 1;

--CUSTOMER, ORDERS 테이블 데이터 동시조회(검색)
--(주의)SELECT절에 동일 컬럼명 2개가 올 수 없다.(별칭사용해서 다른이름으로 변경처리)
SELECT *
FROM CUSTOMER, ORDERS--조인 대상 테이블(별칭 사용 안한 경우)
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID -- 조인조건
 AND CUSTOMER.NAME = '박지성' --선택조건(찾을조건)
;
---------------------------
--테이블별칭(alias) 사용 : 테이블명을 간단하게 사용하기
--(주의) 테이블 별칭 사용시 테이블명 대신 반드시 별칭을 사용해야 한다./별칭생성 후 테이블명사용 ->오류남
SELECT *
FROM CUSTOMER C, ORDERS O --조인테이블에 대한 별칭(alias) 사용
WHERE C.CUSTID = O.CUSTID
AND C.NAME = '추신수'
;
--------------------
--표준 조인 쿼리문
SELECT *
FROM CUSTOMER C INNER JOIN ORDERS O --조인테이블 정의(INNER는 생략가능)
    ON C.CUSTID = O.CUSTID -- 조인조건
    WHERE C.NAME = '박지성' --선택조건(찾을조건)
;
--------------------
--판매된 책 목록 확인(BOOK,ORDERS)
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
--출판한 책중 판매된 책 목록(미디어로 끝나는 출판사)
SELECT O.ORDERID, O.BOOKID,  --보고싶은 컬럼을 선택하기
       B.BOOKID AS B_BOOKID,  --BOOKID이름바꾸기,(주의)동일한 컬럼명이 두번 선택될수X
       B.BOOKNAME, B.PUBLISHER, B.PRICE, o.saleprice, O.ORDERDATE
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID
AND b.publisher LIKE '%미디어'
--AND B.PUBLISHER = '굿스포츠'
ORDER BY b.publisher, B.BOOKNAME
;
--============================
--(문제해결) 테이블 조인을 통해서 요청한 데이터 찾기

--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
------
SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID
AND B.BOOKNAME ='야구를 부탁해'
;
SELECT COUNT(*)
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID
AND B.BOOKNAME IN ('야구를 부탁해')
;
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
--실습 : '추신수'가 구입한 합계금액을 확인
--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 구입(판매)금액, 구입(판매)일자)
SELECT O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME ='추신수'
;
SELECT SUM(O.SALEPRICE) --, AS NAME   --그룹함수는 결과데이터가 1개만 나오기 때문에 결과값이 여러개나오는 함수와 함께 쓸 수 없다.
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME IN ('추신수')
;
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME IN ('추신수', '박지성') -- AND (C.NAME = '박지성' OR C.NAME = '추신수') ->이 방식도 가능
;
-- 결과가 맞는지 비교하기
SELECT *
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID;
-----------------
-->>표준SQL방식

--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 구입(판매)금액, 구입(판매)일자)
SELECT NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C INNER JOIN ORDERS O
  ON C.CUSTID = O.CUSTID
WHERE C.NAME IN ('추신수','박지성');

--실습 : '추신수'가 구입한 합계금액을 확인
SELECT SUM(O.SALEPRICE)AS 추신수구입금액
FROM CUSTOMER C INNER JOIN ORDERS O
  ON C.CUSTID = O.CUSTID
WHERE C.NAME IN ('추신수');
--==================================================================
-- 3개 테이블 조인하기 : COUSTOMER, BOOK, ORDERS
-- 고객명, 책제목, 판매가격, 판매일자, 출판사명
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE, PUBLISHER   --중복되지만 않으면 B.BOOKNAME 이런식으로 굳이 쓰지 않아도된다.(하지만 써주는게 더 좋다.)
 FROM ORDERS O, BOOK B, CUSTOMER C       --조인대상 테이블
WHERE O.BOOKID = B.BOOKID  --조인조건       --N개를 조인한다면 조인조건은 N-1개이다.
  AND O.CUSTID = C.CUSTID  --조인조건
;
----
SELECT *
  FROM ORDERS O INNER JOIN BOOK B --조인테이블
       ON O.BOOKID = B.BOOKID --조인조건
       INNER JOIN CUSTOMER C --조인테이블
       ON O.CUSTID = C.CUSTID --조인조건
 WHERE C.NAME = '추신수' --찾을조건
;
--------------------------------------
--(실습) BOOK, CUSTOMER, ORDERS 테이블 데이터를 조회
--1.장미란이 구입한 책제목, 출판사, 구입가격, 구입일자
--2.장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
--3.'야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
--4.추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
--5.추신수가 구입한 책갯수, 합계금액, 평균값, 가장 큰금액, 가장 작은금액

SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

--1.장미란이 구입한 책제목, 출판사, 구입가격, 구입일자
SELECT  B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
  AND O.BOOKID = B.BOOKID
  AND C.NAME = '장미란';
      
--2.장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
SELECT  B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
  AND O.BOOKID = B.BOOKID
  AND C.NAME = '장미란' 
  AND O.ORDERDATE BETWEEN 
  (TO_DATE('2014-01-01','YYYY/MM/DD')) AND (TO_DATE('2014-07-08','YYYY/MM/DD')); --날짜VS날짜타입 비교
    --가능한 날짜타입으로 바꿔서 비교하기
    
--ORDERDATE에 시간이 있는지 확인해보기
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS')
FROM ORDERS;

--3.'야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
SELECT  C.NAME, O.ORDERDATE
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
  AND O.BOOKID = B.BOOKID
  AND B.BOOKNAME = '야구를 부탁해';
  
--4.추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
SELECT  C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
  AND O.BOOKID = B.BOOKID
  AND C.NAME IN('장미란','추신수') ORDER BY C.NAME, O.ORDERDATE;
  
--5.추신수가 구입한 책갯수, 합계금액, 평균값, 가장 큰금액, 가장 작은금액
SELECT  '추신수' AS NAME,
        COUNT(*) AS CNT,
        SUM(O.SALEPRICE)SUM_PRICE,
        AVG(O.SALEPRICE)AVG_PRICE,
        MAX(O.SALEPRICE)MAX_PRICE,
        MIN(O.SALEPRICE)MIN_PRICE
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
  AND C.NAME ='추신수';
  
-------------------------