
-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
  id INT NOT NULL,
  name VARCHAR(255) DEFAULT NULL,
  address VARCHAR(255) DEFAULT NULL,
  status VARCHAR(255) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for Professor
-- ----------------------------
DROP TABLE IF EXISTS Professor;
CREATE TABLE Professor (
  id INT NOT NULL,
  name VARCHAR(255) DEFAULT NULL,
  deptId VARCHAR(255) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS Course;
CREATE TABLE Course (
  crsCode VARCHAR(255) NOT NULL,
  deptId VARCHAR(255) DEFAULT NULL,
  crsName VARCHAR(255) DEFAULT NULL,
  descr VARCHAR(255) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for Teaching
-- ----------------------------
DROP TABLE IF EXISTS Teaching;
CREATE TABLE Teaching (
  crsCode VARCHAR(255) NOT NULL,
  semester VARCHAR(255) NOT NULL,
  profId INT NOT NULL,
  PRIMARY KEY (crsCode, semester)
);

-- ----------------------------
-- Table structure for Transcript
-- ----------------------------
DROP TABLE IF EXISTS Transcript;
CREATE TABLE Transcript (
  studId INT NOT NULL,
  crsCode VARCHAR(255) NOT NULL,
  semester VARCHAR(255) NOT NULL,
  grade VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (studId,crsCode, semester)
);
