insert into roles(role_name) values ('admin');
insert into roles(role_name) values ('user');
insert into roles(role_name) values ('superuser');

insert into users(user_name, role_id) values ('Ivan', 1);
insert into users(user_name, role_id) values ('Dmitiriy', 2);
insert into users(user_name, role_id) values ('Roman', 2);

insert into rules(rule_name) values ('CREATE ITEM');
insert into rules(rule_name) values ('DELETE ITEM');
insert into rules(rule_name) values ('UPGRADE ITEM');
insert into rules(rule_name) values ('READ ITEMLIST');

insert into rules_to_roles(role_id, rule_id) values (1, 1);
insert into rules_to_roles(role_id, rule_id) values (1, 2);
insert into rules_to_roles(role_id, rule_id) values (1, 3);
insert into rules_to_roles(role_id, rule_id) values (1, 4);

insert into rules_to_roles(role_id, rule_id) values (2, 1);
insert into rules_to_roles(role_id, rule_id) values (2, 4);

insert into rules_to_roles(role_id, rule_id) values (3, 1);
insert into rules_to_roles(role_id, rule_id) values (3, 3);
insert into rules_to_roles(role_id, rule_id) values (3, 4);

insert into category(category_name) values ('sell');
insert into category(category_name) values ('buy');

insert into states(state_name) values ('in process');
insert into states(state_name) values ('created');
insert into states(state_name) values ('completed');
insert into states(state_name) values ('closed');
insert into states(state_name) values ('deleted');

insert into items(item_name, user_id, category_id, state_id) values 
('buy teapot', 2, 1, 3);
insert into items(item_name, user_id, category_id, state_id) values 
('sell teapot', 3, 2, 3);
insert into items(item_name, user_id, category_id, state_id) values 
('buy mikrowave', 1, 1, 2);

insert into comms(comm_name, item_id) values ('buy teapot', 1);
insert into comms(comm_name, item_id) values ('here photo of teapot, i whish!', 1);
insert into comms(comm_name, item_id) values ('sell my old teapot', 2);
insert into comms(comm_name, item_id) values ('need microwave', 3);
insert into comms(comm_name, item_id) values ('urgently!', 3);
insert into comms(comm_name, item_id) values ('urgently needs microwave', 3);

insert into attaches(attach_name, item_id) values ('http://some-url.com', 1);
