CREATE TABLE users
(
    login       VARCHAR(50) PRIMARY KEY,
    password    VARCHAR(50)  NOT NULL,
    first_name  VARCHAR(250) NOT NULL,
    last_name   VARCHAR(250) NOT NULL,
    telegram_id VARCHAR(250) NOT NULL
);

INSERT INTO users
values ('DGiba', '12345', 'Дмитрий', 'Гиба', 'zuzler'),
       ('Iiiiiigor', '5555', 'Игорь', 'Князь', 'knyaz228'),
       ('IvIv', '54321', 'Иваныч', 'Иванов', '78686');

CREATE TABLE pages
(
    id             BIGINT PRIMARY KEY,
    name           VARCHAR(50)  NOT NULL,
    url            VARCHAR(250) NOT NULL,
    parsing_x_path VARCHAR(250) NOT NULL
);

CREATE SEQUENCE sq_pages_id START WITH 1 INCREMENT BY 1;

INSERT INTO pages
values (1, 'Советы по садоводству', 'https://www.cbr.ru/', '//div[@class=''main-indicator_rate''][2]/div[contains(@class,''mono-num'')][2]/text()'),
       (2, 'Voyti v It', 'https://www.cbr.ru/', '//div[@class=''main-indicator_rate''][2]/div[contains(@class,''mono-num'')][2]/text()');

/*
https://www.cbr.ru/

//div[@class='main-indicator_rate'][2]/div[contains(@class,'mono-num')][2]/text()
*/
CREATE TABLE subscriptions
(
    id      BIGINT PRIMARY KEY,
    page_id BIGINT,
    user_id VARCHAR(50)
);

CREATE SEQUENCE sq_subscription_id START WITH 1 INCREMENT BY 1;

INSERT INTO subscriptions
values (1, 1, 'IvIv'),
       (2, 1, 'Iiiiiigor'),
       (3, 2, 'DGiba');

CREATE TABLE parsing_results
(
    id                BIGINT PRIMARY KEY,
    page_id           BIGINT,
    parsing_date_time TIMESTAMP,
    result            VARCHAR(50),
    sent              BOOLEAN
);

CREATE SEQUENCE sq_parsing_results_id START WITH 1 INCREMENT BY 1;

INSERT INTO parsing_results
values (1, 1, '2021-09-17 18:47:52.069', 'text 1', true),
       (2, 1, '2021-09-20 18:47:52.069', 'text 2', false),
       (3, 2, '2021-09-21 18:47:52.069', 'text 3', false);