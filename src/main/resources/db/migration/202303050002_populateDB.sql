INSERT INTO categories (id, name, description)
VALUES (1, '18', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, ut! Veritatis dolorum accusantium dolore velit iusto ipsa quam pariatur?'),
       (2, 'Younger than 18', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, ut! Veritatis dolorum accusantium dolore velit iusto ipsa quam pariatur?'),
       (3, 'Older than 50', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, ut! Veritatis dolorum accusantium dolore velit iusto ipsa quam pariatur?'),
       (4, 'Funny', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, ut! Veritatis dolorum accusantium dolore velit iusto ipsa quam pariatur?'),
       (5, 'Sad', 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, ut! Veritatis dolorum accusantium dolore velit iusto ipsa quam pariatur?');

INSERT INTO gifts (id, name, description)
VALUES (1, 'Lego Set', 'Build your own masterpiece with this Lego set!'),
       (2, 'Board Game', 'Get the family together for game night with this classic board game!'),
       (3, 'Coloring Book', 'Take a break and relax with this adult coloring book!'),
       (4, 'Stuffed Animal', 'Cuddle up with this soft and cuddly stuffed animal!'),
       (5, 'Knitting Kit', 'Get crafty with this knitting kit and create your own scarf!'),
       (6, 'Massage Gift Card', 'Treat yourself to a relaxing massage with this gift card!'),
       (7, 'Gag Gift', 'Make someone laugh with this hilarious gag gift!'),
       (8, 'Comedy Movie', 'Watch a comedy and laugh until you cry with this DVD!'),
       (9, 'Tissue Box', 'Dry your tears with this adorable tissue box!'),
       (10, 'Sad Movie', 'Watch a tearjerker and let the emotions flow with this DVD!');

INSERT INTO gift_categories (gift_id, category_id) VALUES (1, 2);
INSERT INTO gift_categories (gift_id, category_id) VALUES (1, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (2, 2);
INSERT INTO gift_categories (gift_id, category_id) VALUES (2, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (3, 1);
INSERT INTO gift_categories (gift_id, category_id) VALUES (3, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (4, 1);
INSERT INTO gift_categories (gift_id, category_id) VALUES (4, 5);
INSERT INTO gift_categories (gift_id, category_id) VALUES (5, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (5, 5);
INSERT INTO gift_categories (gift_id, category_id) VALUES (6, 3);
INSERT INTO gift_categories (gift_id, category_id) VALUES (7, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (8, 4);
INSERT INTO gift_categories (gift_id, category_id) VALUES (8, 5);
INSERT INTO gift_categories (gift_id, category_id) VALUES (9, 5);
INSERT INTO gift_categories (gift_id, category_id) VALUES (10, 5);