create table t_user(
  id serial PRIMARY KEY,
  name varchar,
  age int);

insert into t_user (name, age) values 
  ('kojiro', 20)
  ,('yotaro', 25)
  ,('sakugoro', 30);
