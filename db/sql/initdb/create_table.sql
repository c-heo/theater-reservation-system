-- 更新日時の自動更新設定
CREATE FUNCTION set_updated_at() RETURNS TRIGGER AS $$
BEGIN
  IF (TG_OP = 'UPDATE') THEN
    NEW.updated_at := now();
    return NEW;
  END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE users (
  id UUID DEFAULT gen_random_uuid(),
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  points INTEGER DEFAULT 0,
  password BYTEA NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_users_updated_at BEFORE UPDATE ON users FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE theaters (
  id UUID DEFAULT gen_random_uuid(),
  name VARCHAR(100)  NOT NULL,
  area VARCHAR(100) NOT NULL,
  access VARCHAR(100) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_theaters_updated_at BEFORE UPDATE ON theaters FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE rooms (
  id UUID DEFAULT gen_random_uuid(),
  theater_id UUID NOT NULL,
  seats_count INTEGER NOT NULL,
  seats JSON NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_rooms_updated_at BEFORE UPDATE ON rooms FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE movies (
  id UUID DEFAULT gen_random_uuid(),
  title VARCHAR(100) NOT NULL,
  genre VARCHAR(100) NOT NULL,
  period_start TIMESTAMP NOT NULL,
  period_end TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_movies_updated_at BEFORE UPDATE ON movies FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE schedules (
  id UUID DEFAULT gen_random_uuid(),
  movie_id UUID NOT NULL,
  room_id UUID NOT NULL,
  start_at TIMESTAMP NOT NULL,
  end_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_schedules_updated_at BEFORE UPDATE ON schedules FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE reservations (
  id UUID DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL,
  schedule_id UUID NOT NULL,
  seat_column VARCHAR(4) NOT NULL,
  seat_row INTEGER NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_reservations_updated_at BEFORE UPDATE ON reservations FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE news (
  id UUID DEFAULT gen_random_uuid(),
  title VARCHAR(100) NOT NULL,
  text TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_news_updated_at BEFORE UPDATE ON news FOR EACH ROW EXECUTE PROCEDURE set_updated_at();

CREATE TABLE notifications (
  id UUID DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL,
  text TEXT NOT NULL,
  checked BOOLEAN NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
CREATE TRIGGER trg_notifications_updated_at BEFORE UPDATE ON notifications FOR EACH ROW EXECUTE PROCEDURE set_updated_at();
