create table public.adresses (
                                 id integer primary key not null,
                                 street text not null,
                                 house_number integer not null,
                                 city text not null,
                                 country text not null
);

create table public.contacts (
                                 id bigint primary key not null,
                                 phone character varying(15) not null,
                                 email text not null
);

create table public.persons (
                                id bigint primary key not null,
                                adress_id bigint,
                                first_name text not null,
                                second_name text not null,
                                gender_id integer not null,
                                contatcs_id bigint,
                                foreign key (adress_id) references public.adresses (id)
                                    match simple on update no action on delete no action,
                                foreign key (contatcs_id) references public.contacts (id)
                                    match simple on update no action on delete no action
);
create unique index persons_pk2 on persons using btree (contatcs_id);

create table public.persons_works (
                                      person_id bigint not null,
                                      works_id bigint not null,
                                      foreign key (person_id) references public.persons (id)
                                          match simple on update no action on delete no action,
                                      foreign key (works_id) references public.works (id)
                                          match simple on update no action on delete no action
);

create table public.works (
                              id integer primary key not null,
                              company text not null
);

