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
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(50)  NOT NULL,
    url          VARCHAR(250) NOT NULL,
    parsingXPath VARCHAR(250) NOT NULL
);

INSERT INTO pages
values (1, 'Советы по садводству', 'https://sad.com', 'nice_path'),
       (2, 'Voyti v It', 'https://it.journal.com', 'bad_path'):

CREATE TABLE subscriptions
(
    id      BIGINT PRIMARY KEY,
    page_id BIGINT,
    user_id VARCHAR(50)
);

INSERT INTO subscriptions
values (1, 1, 'IvIv'),
       (2, 1, 'Iiiiiigor'),
       (3, 2, 'DGiba');

CREATE TABLE parsing_results
(
    id              BIGINT PRIMARY KEY,
    page_id         BIGINT,
    parsingDateTime TIMESTAMP,
    result          VARCHAR(50),
    sent            BOOLEAN
);

INSERT INTO parsing_results
values (1, 1, null, 'text 1', true),
       (2, 1, null, 'text 2', false),
       (3, 2, null, 'text 3', false);