DELETE FROM book;

INSERT INTO book (id, title, author, price, type) VALUES
                                                (1, 'book', 'Jone', 5, 1),
                                                (2, 'test', 'Jack', 10.5, 1),
                                                (3, 'code','Tom', 20, 2),
                                                (4, 'book1', 'Sandy', 20.1, 1),
                                                (5, 'aa', 'Billie', 20.2, 2);

DELETE FROM shop_cart;

INSERT INTO shop_cart (id, book_id, user_id, title, author, price, qty, amt, type) VALUES
                                                      (1, 1, '1','book', 'Jone', 5, 1, 5, 1);