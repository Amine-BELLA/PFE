create table utilisateur(
	id BIGINT NOT NULL,

first_name VARCHAR(50),
	
last_name VARCHAR(50),
	
email VARCHAR(50),
	
birth_date DATE
PRIMARY KEY (id)

);

CREATE TABLE Posts (
    id BIGINT NOT NULL ,
    postDetail VARCHAR(100),
    user_id BIGINT,
    PRIMARY KEY ( id )
);

ALTER TABLE Posts
ADD CONSTRAINT FKmw13yfsjypiiq0i1osdkaeqpg
FOREIGN KEY (user_id) REFERENCES utilisateur;

