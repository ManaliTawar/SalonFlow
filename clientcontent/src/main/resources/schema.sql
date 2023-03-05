CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email_id VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    occupation VARCHAR(50) NOT NULL,
    checkin TIMESTAMP ,
    checkout TIMESTAMP,
    dob DATE,
    primary key(id)
    );

--INSERT INTO Content(title,desc,status,content_type,date_created)
--VALUES('MY SPRING REST API','ALL ABOUT SPRING DATA JDBC','IDEA','ARTICLE',CURRENT_TIME)