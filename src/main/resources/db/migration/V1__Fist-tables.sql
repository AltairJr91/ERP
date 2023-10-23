CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name  TEXT,
    value FLOAT,
    quantity INTEGER,
    description TEXT,
    category    TEXT
);