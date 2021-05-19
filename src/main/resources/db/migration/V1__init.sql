CREATE TABLE users
(
    login       VARCHAR(50) PRIMARY KEY,
    password    VARCHAR(50)  NOT NULL,
    first_name  VARCHAR(250) NOT NULL,
    last_name   VARCHAR(250) NOT NULL,
    telegram_id VARCHAR(250) NOT NULL
);

INSERT INTO users
values ('DGiba', '12345', 'Дмитрий', 'Гиба', 'zuzler');

CREATE TABLE pages
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(50)  NOT NULL,
    url          VARCHAR(250) NOT NULL,
    parsingXPath VARCHAR(250) NOT NULL
);

CREATE TABLE subscriptions
(
    id      BIGINT PRIMARY KEY,
    page_id BIGINT,
    user_id VARCHAR(50)
);

CREATE TABLE parsing_results
(
    id              BIGINT PRIMARY KEY,
    page_id         BIGINT,
    parsingDateTime TIMESTAMP,
    result          VARCHAR(50),
    sent            BOOLEAN
);