create table if not exists line(
  id integer not null primary key auto_increment,
  gameId integer not null,
  player varchar(255) not null,
  pins integer not null,

  constraint game_id_fk foreign key (gameId) references game(id)
);