-- SQL 에서 한 줄 주석 부호(--)
-- HTTP 포트 변경 : 8080 -> 8090
SELECT DBMS_XDB.getHttpPort() FROM  dual;
SELECT DBMS_XDB.GETHTTPPORT() FROM  DUAL; --대소문자구분X

--HTTP 포트 8090 으로 변경
exec dbms_xdb.setHttpPort(8090);