create table if not exists game(
  id integer not null primary key auto_increment,
  createdAt timestamp not null default now()
);