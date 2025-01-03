-- Insert 10 sample companies
INSERT INTO Company (name, address, phone, email, website, description, stockCode, pic, sector, charterCapital, establishmentInfo, marketCap) VALUES
('Company 1', 'Address 1', 'Phone 1', 'email1@example.com', 'http://website1.com', 'Description 1', 'VNM', 'Pic1', 'Sector1', 1000000, 'Establishment Info 1', 5000000),
('Company 2', 'Address 2', 'Phone 2', 'email2@example.com', 'http://website2.com', 'Description 2', 'FPT', 'Pic2', 'Sector2', 2000000, 'Establishment Info 2', 6000000),
('Company 3', 'Address 3', 'Phone 3', 'email3@example.com', 'http://website3.com', 'Description 3', 'StockCode3', 'Pic3', 'Sector3', 3000000, 'Establishment Info 3', 7000000),
('Company 4', 'Address 4', 'Phone 4', 'email4@example.com', 'http://website4.com', 'Description 4', 'StockCode4', 'Pic4', 'Sector4', 4000000, 'Establishment Info 4', 8000000),
('Company 5', 'Address 5', 'Phone 5', 'email5@example.com', 'http://website5.com', 'Description 5', 'StockCode5', 'Pic5', 'Sector5', 5000000, 'Establishment Info 5', 9000000),
('Company 6', 'Address 6', 'Phone 6', 'email6@example.com', 'http://website6.com', 'Description 6', 'StockCode6', 'Pic6', 'Sector6', 6000000, 'Establishment Info 6', 10000000),
('Company 7', 'Address 7', 'Phone 7', 'email7@example.com', 'http://website7.com', 'Description 7', 'StockCode7', 'Pic7', 'Sector7', 7000000, 'Establishment Info 7', 11000000),
('Company 8', 'Address 8', 'Phone 8', 'email8@example.com', 'http://website8.com', 'Description 8', 'StockCode8', 'Pic8', 'Sector8', 8000000, 'Establishment Info 8', 12000000),
('Company 9', 'Address 9', 'Phone 9', 'email9@example.com', 'http://website9.com', 'Description 9', 'StockCode9', 'Pic9', 'Sector9', 9000000, 'Establishment Info 9', 13000000),
('Company 10', 'Address 10', 'Phone 10', 'email10@example.com', 'http://website10.com', 'Description 10', 'StockCode10', 'Pic10', 'Sector10', 10000000, 'Establishment Info 10', 14000000);

-- Insert 3 sample events for each company
INSERT INTO Event (name, date, description, company_id) VALUES
('Event 1 for Company 1', '2023-01-01', 'Description for Event 1 of Company 1', 1),
('Event 2 for Company 1', '2023-02-01', 'Description for Event 2 of Company 1', 1),
('Event 3 for Company 1', '2023-03-01', 'Description for Event 3 of Company 1', 1),
('Event 1 for Company 2', '2023-01-01', 'Description for Event 1 of Company 2', 2),
('Event 2 for Company 2', '2023-02-01', 'Description for Event 2 of Company 2', 2),
('Event 3 for Company 2', '2023-03-01', 'Description for Event 3 of Company 2', 2),
('Event 1 for Company 3', '2023-01-01', 'Description for Event 1 of Company 3', 3),
('Event 2 for Company 3', '2023-02-01', 'Description for Event 2 of Company 3', 3),
('Event 3 for Company 3', '2023-03-01', 'Description for Event 3 of Company 3', 3),
('Event 1 for Company 4', '2023-01-01', 'Description for Event 1 of Company 4', 4),
('Event 2 for Company 4', '2023-02-01', 'Description for Event 2 of Company 4', 4),
('Event 3 for Company 4', '2023-03-01', 'Description for Event 3 of Company 4', 4),
('Event 1 for Company 5', '2023-01-01', 'Description for Event 1 of Company 5', 5),
('Event 2 for Company 5', '2023-02-01', 'Description for Event 2 of Company 5', 5),
('Event 3 for Company 5', '2023-03-01', 'Description for Event 3 of Company 5', 5),
('Event 1 for Company 6', '2023-01-01', 'Description for Event 1 of Company 6', 6),
('Event 2 for Company 6', '2023-02-01', 'Description for Event 2 of Company 6', 6),
('Event 3 for Company 6', '2023-03-01', 'Description for Event 3 of Company 6', 6),
('Event 1 for Company 7', '2023-01-01', 'Description for Event 1 of Company 7', 7),
('Event 2 for Company 7', '2023-02-01', 'Description for Event 2 of Company 7', 7),
('Event 3 for Company 7', '2023-03-01', 'Description for Event 3 of Company 7', 7),
('Event 1 for Company 8', '2023-01-01', 'Description for Event 1 of Company 8', 8),
('Event 2 for Company 8', '2023-02-01', 'Description for Event 2 of Company 8', 8),
('Event 3 for Company 8', '2023-03-01', 'Description for Event 3 of Company 8', 8),
('Event 1 for Company 9', '2023-01-01', 'Description for Event 1 of Company 9', 9),
('Event 2 for Company 9', '2023-02-01', 'Description for Event 2 of Company 9', 9),
('Event 3 for Company 9', '2023-03-01', 'Description for Event 3 of Company 9', 9),
('Event 1 for Company 10', '2023-01-01', 'Description for Event 1 of Company 10', 10),
('Event 2 for Company 10', '2023-02-01', 'Description for Event 2 of Company 10', 10),
('Event 3 for Company 10', '2023-03-01', 'Description for Event 3 of Company 10', 10);