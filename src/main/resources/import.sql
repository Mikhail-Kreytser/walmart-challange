-- customers data
INSERT INTO customers (id, name) VALUES (1,'Jason Brown');
INSERT INTO customers (id, name) VALUES (2,'Sarah Williams');
INSERT INTO customers (id, name) VALUES (3,'Frank Smith');
INSERT INTO customers (id, name) VALUES (4,'Anthony Jones');
INSERT INTO customers (id, name) VALUES (5,'Maria Miller');

-- orders data
INSERT INTO orders (id, customer_id) VALUES (1,1);
INSERT INTO orders (id, customer_id) VALUES (2,1);
INSERT INTO orders (id, customer_id) VALUES (3,2);
INSERT INTO orders (id, customer_id) VALUES (4,3);
INSERT INTO orders (id, customer_id) VALUES (5,4);
INSERT INTO orders (id, customer_id) VALUES (6,5);
INSERT INTO orders (id, customer_id) VALUES (7,3);
INSERT INTO orders (id, customer_id) VALUES (8,2);

--items data
INSERT INTO items (id, name) VALUES (1,'Great Value Sweet Cream Unsalted Butter, 4 count, 16 oz');
INSERT INTO items (id, name) VALUES (2,'Dove Style + Care Flexible Hold Hairspray, 5.5 oz');
INSERT INTO items (id, name) VALUES (3,'Del Monte Summer Crisp Whole Kernel Golden Sweet Corn, 11 Oz');
INSERT INTO items (id, name) VALUES (4,'Manwich Original Sloppy Joe Sauce, 15 oz');
INSERT INTO items (id, name) VALUES (5,'Campbells Condensed?Healthy Request Tomato Soup, 10.75 oz. Can');
INSERT INTO items (id, name) VALUES (6,'SunChips Harvest Cheddar Flavored Whole Grain Snacks, 7 oz. Bag');
INSERT INTO items (id, name) VALUES (7,'Fresh Strawberries, 2 lb');
INSERT INTO items (id, name) VALUES (8,'Great Value Milk Chocolate Hot Cocoa Mix, Single Serve Cups, 12 Count');
INSERT INTO items (id, name) VALUES (9,'Land O Lakes Light Butter with Canola Oil, 8 oz.');
INSERT INTO items (id, name) VALUES (10,'Kraft Spirals Original Macaroni & Cheese Dinner, 5.5 oz Box');
INSERT INTO items (id, name) VALUES (11,'Simply Orange Pulp Free Orange Juice, 52 fl oz');
INSERT INTO items (id, name) VALUES (12,'Marburger Farm Dairy 2% Reduced Fat Milk, 1 Quart');
INSERT INTO items (id, name) VALUES (13,'Marburger Farm Dairy Fat-Free Unflavored Milk, 1 Gallon');
INSERT INTO items (id, name) VALUES (14,'Schwebel Baking Schwebels  Bread, 20 oz');
INSERT INTO items (id, name) VALUES (15,'Nissin Foods Nissin Top Ramen Bowl Beef');
INSERT INTO items (id, name) VALUES (16,'Great Value 1% Chocolate Milk, Half Gallon');

-- orderLines data
INSERT INTO order_lines (order_id, item_id, qty) VALUES (1,3,3);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (1,5,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (1,7,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (1,16,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,2,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,3,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,4,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,6,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,11,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (2,15,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,1,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,5,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,8,4);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,12,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,13,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,14,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,3,3);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,7,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,9,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (3,10,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,1,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,5,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,7,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,8,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,9,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (4,11,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,3,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,6,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,12,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,14,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,15,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (5,16,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (6,2,4);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (6,5,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (6,7,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (6,13,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (6,16,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,1,3);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,2,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,5,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,7,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,14,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (7,16,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,1,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,2,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,3,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,4,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,6,1);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,8,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,9,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,12,2);
INSERT INTO order_lines (order_id, item_id, qty) VALUES (8,15,2);