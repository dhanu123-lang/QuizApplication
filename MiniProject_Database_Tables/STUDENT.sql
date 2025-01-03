--------------------------------------------------------
--  File created - Sunday-December-22-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."STUDENT" 
   (	"STUDENT_ID" NUMBER(10,0), 
	"FIRST_NAME" VARCHAR2(50 BYTE), 
	"LAST_NAME" VARCHAR2(50 BYTE), 
	"CITY" VARCHAR2(50 BYTE), 
	"MAIL_ID" VARCHAR2(100 BYTE), 
	"MOBILE_NUMBER" VARCHAR2(20 BYTE), 
	"USER_NAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.STUDENT
SET DEFINE OFF;
Insert into SYSTEM.STUDENT (STUDENT_ID,FIRST_NAME,LAST_NAME,CITY,MAIL_ID,MOBILE_NUMBER,USER_NAME,PASSWORD) values (25,'Aniket','Joshi','Pune','aniket@gmail.com','7621462445','aniket','123');
Insert into SYSTEM.STUDENT (STUDENT_ID,FIRST_NAME,LAST_NAME,CITY,MAIL_ID,MOBILE_NUMBER,USER_NAME,PASSWORD) values (22,'Dhanshri','Sapkale','Jalgaon','dhanu@123','7384655462','dhanu123','123456');
--------------------------------------------------------
--  DDL for Index SYS_C007054
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007054" ON "SYSTEM"."STUDENT" ("STUDENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger STUDENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."STUDENT_TRG" 
BEFORE INSERT ON STUDENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.STUDENT_ID IS NULL THEN
      SELECT STUDENT_SEQ1.NEXTVAL INTO :NEW.STUDENT_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."STUDENT_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STUDENT" ADD PRIMARY KEY ("STUDENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
