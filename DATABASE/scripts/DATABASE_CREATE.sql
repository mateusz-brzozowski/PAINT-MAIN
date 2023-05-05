create table languages
(
    language_id serial
        primary key,
    code        varchar(3) not null,
    name        varchar(50),
    flag_url    varchar(255)
);

alter table languages
    owner to postgres;

create table words
(
    word_id     bigserial
        primary key,
    language_id integer      not null
        constraint words_language_fk
            references languages,
    word_length integer      not null,
    word_number integer      not null,
    word        varchar(255) not null
);

alter table words
    owner to postgres;

create table users
(
    user_id serial not null
        primary key
);

alter table users
    owner to postgres;

create table sessions
(
    session_id   bigserial
        primary key,
    user_id      integer   not null
        constraint sessions_user_fk
            references users,
    language_id  integer   not null
        constraint sessions_language_fk
            references languages,
    word_length  integer   not null,
    word_number  integer   not null,
    created_date timestamp not null
);

alter table sessions
    owner to postgres;

create table guesses
(
    guess_id     serial
        primary key,
    session_id   bigint    not null
        constraint guesses_session_fk
            references sessions,
    guess_number integer   not null,
    guess        text      not null,
    created_date timestamp not null
);

alter table guesses
    owner to postgres;

