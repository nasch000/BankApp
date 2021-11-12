create table project.users (
	userID int primary key,
	userFullname varchar(255) unique not null,
	userEmail varchar(255) unique not null,
	phoneNumber varchar(255),
	homeAddress varchar(255)
);

create table project.accounts (
	userFullname varchar(255) references project.users(userFullname),
	accountType varchar(255),
	accountValue decimal(65, 2)
);

create table project.login (
	userID int references project.users(userID),
	username varchar(255),
	userEmail varchar(255) references project.users(userEmail),
	userPass varchar(255)
);

insert into project.users (userID, userFullname, userEmail, phoneNumber, homeAddress)
	values (12345678, 'Adam Smith', 'aSmith@hotmail.com', '1-512-635-9236', '8252 Rockwood Drive'),
			(87654321, 'Jane Smith', 'janeS@hotmail.com', '1-512-825-5825', '8252 Rockwood Drive');

insert into project.accounts (userFullname, accountType, accountValue)
	values ('Adam Smith', 'Savings', 23858.08),
			('Jane Smith', 'Savings', 19276.98);

insert into project.login (userID, username, userEmail, userPass)
	values (12345678, 'adamSmith', 'aSmith@hotmail.com', 'Smithsonian1963'),
			(87654321, 'janeSmith', 'janeS@hotmail.com', 'amberjane00300');
		


