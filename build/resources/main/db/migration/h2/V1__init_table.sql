/* account 스키마 */
CREATE TABLE account (
    account_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(127),
    password VARCHAR(255),
    member_type VARCHAR(10),
    email VARCHAR(255),
    phoneNo VARCHAR(127),
    member_status VARCHAR(10),
    nickname VARCHAR(127),
    business_no VARCHAR(127),
    createDt DATE,
    modifyDt DATE,
    token_weight BIGINT,
    activated BOOLEAN
);

/* authority 스키마 */
CREATE TABLE authority (
    authority_name VARCHAR(127) NOT NULL PRIMARY KEY
);

/* 다대다표현 account_authority 스키마 */
CREATE TABLE account_authority (
    account_id BIGINT NOT NULL,
    authority_name VARCHAR(127) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account (account_id),
    FOREIGN KEY (authority_name) REFERENCES authority (authority_name)
);

/* 초기 필수 권한 */
INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_INDIVIDUAL');
INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_CORP');
INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_ADMIN');

-- INSERT INTO USER (USER_ID, USERNAME, PASSWORD, NICKNAME, ACTIVATED) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1);
-- INSERT INTO USER (USER_ID, USERNAME, PASSWORD, NICKNAME, ACTIVATED) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1);
