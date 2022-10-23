CREATE
DATABASE ShopCafe

CREATE TABLE Categories
(
    Id   int IDENTITY PRIMARY KEY,
    Name NVARCHAR(100) not NULL
)

CREATE TABLE Products
(
    Id          int IDENTITY PRIMARY KEY,
    Name        NVARCHAR(100) not null,
    Price       float not NULL,
    CreateDate  DATE  NOT NULL,
    Available   bit   NOT NULL,
    Description NVARCHAR( max)
)

CREATE TABLE ImageDescribes
(
    Id        int IDENTITY PRIMARY KEY,
    Image     NVARCHAR(500) not NULL,
    ProductId int not NULL,
    FOREIGN KEY (ProductId) REFERENCES Products (id)
)

create TABLE CategoriesInProduct
(
    Id           int IDENTITY PRIMARY KEY,
    ProductId    int not null,
    CategoriesId int not NULL,
    FOREIGN KEY (ProductId) REFERENCES Products (id),
    FOREIGN KEY (CategoriesId) REFERENCES Categories (Id)
)

CREATE TABLE Roles
(
    Id   VARCHAR(10) PRIMARY KEY,
    Name NVARCHAR(50) not NULL
)

create TABLE Accounts
(
    Username   VARCHAR(50) PRIMARY KEY,
    Password   NVARCHAR(100) not NULL,
    Fullname   NVARCHAR(50) not NULL,
    Email      NVARCHAR(100) not NULL,
    Photo      NVARCHAR(100) not NULL,
    Address    NVARCHAR( max) not NULL,
    CreateDate date not NULL
)

create TABLE Authorities
(
    Id       int IDENTITY PRIMARY KEY,
    Username VARCHAR(50) not null,
    RoleId   VARCHAR(10) not NULL,
    FOREIGN KEY (Username) REFERENCES Accounts (Username),
    FOREIGN KEY (RoleId) REFERENCES Roles (Id)
)

CREATE TABLE Orders
(
    Id         int IDENTITY PRIMARY key,
    Username   VARCHAR(50) not null,
    CreateDate DATE        not NULL,
    Address    NVARCHAR(100) not null,
    FOREIGN KEY (Username) REFERENCES Accounts (Username)
)

CREATE TABLE OrderDetails
(
    Id        int IDENTITY PRIMARY KEY,
    OrderId   int   not NULL,
    ProductId int   not null,
    Price     float not null,
    Quantity  int   not NULL,
    FOREIGN KEY (OrderId) REFERENCES Orders (Id),
    FOREIGN KEY (ProductId) REFERENCES Products (Id)
)

CREATE TABLE Favorite
(
    Id        int PRIMARY KEY IDENTITY(1000, 1),
    ProductId int FOREIGN KEY REFERENCES Products(id),
    Username  VARCHAR(50) not null,
    FOREIGN KEY (Username) REFERENCES Accounts (Username)
)

CREATE TABLE Comment
(
    Id         int PRIMARY KEY IDENTITY(1000, 1),
    ProductId  int FOREIGN KEY REFERENCES Products(id),
    AccountId  VARCHAR(50) FOREIGN KEY REFERENCES Accounts(username),
    Content    nvarchar( max),
    CreateDate date,
    Title      NVARCHAR(100),
    Image      NVARCHAR(200)
)

CREATE TABLE FavoriteComment
(
    Id        int PRIMARY KEY IDENTITY(1000, 1),
    CommentId int FOREIGN KEY REFERENCES Comment(id),
    Username  VARCHAR(50) not null,
    FOREIGN KEY (Username) REFERENCES Accounts (Username)
)

CREATE TABLE Rate
(
    Id       int PRIMARY KEY IDENTITY(1000, 1),
    Rate     int         not NULL,
    Username VARCHAR(50) not null,
    ProductId int not null ,

    FOREIGN KEY (Username) REFERENCES Accounts (Username)
)

ALTER TABLE Rate 
add FOREIGN KEY (ProductId) REFERENCES Products (Id)

