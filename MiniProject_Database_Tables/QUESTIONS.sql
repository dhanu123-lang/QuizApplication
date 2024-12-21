--------------------------------------------------------
--  File created - Sunday-December-22-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table QUESTIONS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."QUESTIONS" 
   (	"QUESTION_ID" NUMBER(10,0), 
	"QUESTION_TEXT" VARCHAR2(4000 BYTE), 
	"OPTION_1" VARCHAR2(4000 BYTE), 
	"OPTION_2" VARCHAR2(4000 BYTE), 
	"OPTION_3" VARCHAR2(4000 BYTE), 
	"OPTION_4" VARCHAR2(4000 BYTE), 
	"CORRECT_CHOICE" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.QUESTIONS
SET DEFINE OFF;
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (1,'Which of the following option leads to the portability and security of Java?','a.Bytecode is executed by JVM','b.The applet makes the Java code secure and portable','c.Use of exception handling','d.Dynamic binding between objects','a');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (2,'Which of the following is not a Java features?','a.Dynamic','b.Architecture Neutral','c.Use of pointers','d.Object-oriented','c');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (3,'_____ is used to find and fix bugs in the Java programs?','a.JVM','b.JRE','c.JDK','d.JDB','d');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (4,'Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?','a.javap tool','b.javaw command','c.Javadoc tool','d.javah command','c');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (5,'What is the return type of the hashCode() method in the Object class?','a.Object','b.int','c.long','d.void','b');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (6,'Which of the following creates a List of 3 visible items and multiple selections abled?','a.new List(false,3)','b.new List(3,true)','c.new List(true,3)','d.new List(3,false)','b');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (7,'Which option is false about the final keyword?','a.A final method cannot be overridden in its subclasses','b.A final class cannot be extended','c.A final class cannot extend other classes','d.A final method can be inherited','c');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (8,'Which of the following is true about the anonymous inner class?','a.It has only methods','b.Objects cant be created','c.It has a fixed class name','d.It has no class name','d');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (9,'Which package contains the Random class?','a.java.util package','b.java.lang package','c.java.awt package','d.java.io package','a');
Insert into SYSTEM.QUESTIONS (QUESTION_ID,QUESTION_TEXT,OPTION_1,OPTION_2,OPTION_3,OPTION_4,CORRECT_CHOICE) values (10,'An interface with no fields or methods is known as a ______.','a.Runnable Interface','b.Marker Interface','c.Abstract Interface','d.CharSequence Interface','b');
--------------------------------------------------------
--  DDL for Index SYS_C007061
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007061" ON "SYSTEM"."QUESTIONS" ("QUESTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger QUESTIONS_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."QUESTIONS_TRG1" 
BEFORE INSERT ON QUESTIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.QUESTION_TEXT IS NULL THEN
      SELECT QUESTIONS_SEQ4.NEXTVAL INTO :NEW.QUESTION_TEXT FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."QUESTIONS_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger QUESTIONS_TRG2
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."QUESTIONS_TRG2" 
BEFORE INSERT ON QUESTIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."QUESTIONS_TRG2" ENABLE;
--------------------------------------------------------
--  DDL for Trigger QUESTIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."QUESTIONS_TRG" 
BEFORE INSERT ON QUESTIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."QUESTIONS_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table QUESTIONS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."QUESTIONS" ADD PRIMARY KEY ("QUESTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
