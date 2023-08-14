--조인(JOIN, INNER JOIN, 내부조인) : 조인테이블 모두에 존재하는 데이터 검색
--외부조인(OUTER JOIN) : 어느 한 쪽에만 존재하는 데이터 검색
--------------------
CREATE TABLE DEPT (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT VALUES ('10', '총무부');
INSERT INTO DEPT VALUES ('20', '급여부');
INSERT INTO DEPT VALUES ('30', 'IT부');

CREATE TABLE DEPT1 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT1 VALUES ('10', '총무부');
INSERT INTO DEPT1 VALUES ('20', '급여부');

CREATE TABLE DEPT2 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);

INSERT INTO DEPT2 VALUES ('20', '급여부');
INSERT INTO DEPT2 VALUES ('30', 'IT부');
--=================================
SELECT * FROM DEPT;
SELECT * FROM DEPT1;
SELECT * FROM DEPT2;
--LEFT OUTER JOIN : 좌측 테이블 기준(모두표시)
SELECT *
    FROM DEPT D, DEPT1 D1
   WHERE D.ID = D1.ID(+)
;
--RIGHT OUTER JOIN : 우측 테이블 기준(우측 테이블 데이터 모두표시)
SELECT *
    FROM DEPT2 D2, DEPT D
   WHERE D2.ID(+) = D.ID
;
-- FULL OUTER JOIN(표준SQL 밖에안됨)
SELECT *
    FROM DEPT1 D1 FULL OUTER JOIN DEPT2 D2
       ON D1.ID = D2.ID
ORDER BY D1.ID
;
---------------------------------------------
--(실습) DEPT1, DEPT2 테이블 사용해서
--1. DEPT1 에는 있고, DEPT2에는 없는 데이터 찾기(LEFT OUTER JOIN)
--2. DEPT2 에는 있고, DEPT1에는 없는 데이터 찾기(RIGHT OUTER JOIN)
--1번문제
SELECT D1.* --어자피 NULL인 값은 필요 없기 때문에 D1의 값만 출력
    FROM DEPT1 D1, DEPT2 D2 --조인테이블
   WHERE D1.ID = D2.ID(+) --조인조건(좌측기준)
    AND D2.ID IS NULL --찾을조건
;
--1번문제(표준SQL)
SELECT D1.*  
    FROM DEPT1 D1 LEFT OUTER JOIN DEPT2 D2 --조인테이블 + 조인방식(좌측기준)
      ON D1.ID = D2.ID --조인조건
    WHERE D2.ID IS NULL --찾을조건
;
--2번문제
SELECT D2.*
    FROM DEPT2 D2, DEPT1 D1
   WHERE D1.ID(+) = D2.ID
    AND D1.ID IS NULL
;
--2번문제(표준SQL)
SELECT D2.*
    FROM DEPT1 D1 RIGHT OUTER JOIN DEPT2 D2
      ON D1.ID = D2.ID
    WHERE D1.ID IS NULL
;