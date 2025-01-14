INSERT INTO users (name, email, password, roles) VALUES
  ('test1', 'test1@example.com', '$2a$10$fL1TVgS7vfdSk35igtHwretsW0LS7VNuWgZnqA6XcV/WLttVsqouS', 'user'), -- password1
  ('test2', 'test2@example.com', '$2a$10$Eb8qUo5NggsvlHe/Qnai..vYCUFNj7DoZXAy5KspjFaBM.DIoTiCy', 'user'), -- password2
  ('test3', 'test3@example.com', '$2a$10$4efMrgrCzK5lukGT/QcerOQvRg70VVxVqkoJtjz/hRlkgOaNQqo3K', 'user'); -- password3

INSERT INTO theaters (name, area, access) VALUES
  ('映画館1', 1, '住所1'),
  ('映画館2', 2, '住所2'),
  ('映画館3', 3, '住所3');

INSERT INTO rooms (theater_id, seats_count, seats) VALUES
  ((SELECT id FROM theaters LIMIT 1), 1, '{ "A": "b4s8b1s8b1s3", "B": "s3b1s8b1s8b1s3" }'),
  ((SELECT id FROM theaters LIMIT 1 OFFSET 1), 2, '{ "A": "b4s8b1s8b1s3", "B": "s3b1s8b1s8b1s3" }'),
  ((SELECT id FROM theaters LIMIT 1 OFFSET 2), 3, '{ "A": "b4s8b1s8b1s3", "B": "s3b1s8b1s8b1s3" }');

INSERT INTO movies (title, genre, period_start, period_end) VALUES
  ('映画1', 1, TIMESTAMP '2025-01-01', TIMESTAMP '2025-04-01'),
  ('映画2', 2, TIMESTAMP '2025-01-01', TIMESTAMP '2025-04-01'),
  ('映画3', 3, TIMESTAMP '2025-01-01', TIMESTAMP '2025-04-01');

INSERT INTO schedules (movie_id, room_id, start_at, end_at) VALUES
  ((SELECT id FROM movies LIMIT 1), (SELECT id FROM rooms LIMIT 1), TIMESTAMP '2025-01-01 13:00', TIMESTAMP '2025-01-01 14:30'),
  ((SELECT id FROM movies LIMIT 1 OFFSET 1), (SELECT id FROM rooms LIMIT 1 OFFSET 1), TIMESTAMP '2025-01-02 13:00', TIMESTAMP '2025-01-02 14:30'),
  ((SELECT id FROM movies LIMIT 1 OFFSET 2), (SELECT id FROM rooms LIMIT 1 OFFSET 2), TIMESTAMP '2025-01-03 13:00', TIMESTAMP '2025-01-03 14:30');

INSERT INTO reservations (user_id, schedule_id, seat_column, seat_row) VALUES
  ((SELECT id FROM users LIMIT 1), (SELECT id FROM schedules LIMIT 1), 'B', 1),
  ((SELECT id FROM users LIMIT 1), (SELECT id FROM schedules LIMIT 1 OFFSET 1), 'B', 1),
  ((SELECT id FROM users LIMIT 1), (SELECT id FROM schedules LIMIT 1 OFFSET 2), 'B', 1);

INSERT INTO news (title, text) VALUES
  ('ニュース1', '本文'),
  ('ニュース2', '本文'),
  ('ニュース3', '本文');

INSERT INTO notifications (user_id, text, checked) VALUES
  ((SELECT id FROM users LIMIT 1), '通知1', TRUE),
  ((SELECT id FROM users LIMIT 1), '通知2', TRUE),
  ((SELECT id FROM users LIMIT 1), '通知3', FALSE);
