create table modules(
    id serial primary key,
    module_name varchar(255),
    PSB_id int
);

create table PSB(
    id serial primary key,
    PSB_name varchar(255),
    module_id int
);

create table PSB_Modules(
    id serial primary key,
    PSB_id int references PSB(id),
    module_id int references modules(id)
);

create table technologies(
    id serial primary key,
    technology_name varchar(255)
);


create table components(
    id serial primary key,
    comp_name varchar(255),
    technology_id int references technologies(id)
);

create table comp_to_module(
    id serial primary key,
    module_id int references modules(id),
    component_id int references components(id)
);