create table Account (  id identity,
						username varchar (50) unique,
						password varchar (50) not null,
						firstName varchar (50) not null, 
						lastName varchar (50) not null,
						email varchar (50) not null);