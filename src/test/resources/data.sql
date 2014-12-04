
SET FILES LOG FALSE;
INSERT INTO Election (id, subject) VALUES ((1, 'JQuery'), (2, 'Test'), (4, 'Spring'));

INSERT INTO Book (isbn, name) VALUES (
  ('9781430240952', 'Pro jQuery'),
  ('9780980576856', 'jQuery: Novice to Ninja'),

  ('9781449356378', 'JavaScript Testing With Jasmine'),
  ('9781849518307', 'Selenium 2 Testing Tools: Beginner''s Guide'),
  ('9780321503626', 'Growing Object-Oriented Software, Guided by Tests'),
  ('9780321146533', 'Test Driven Development: By Example'),

  ('9781849510561', 'Spring Persistence With Hibernate'),
  ('9781935182351', 'Spring in Action'),
  ('9780764574832', 'Professional Java Development With the Spring Framework')
);

INSERT INTO ELECTION_CANDIDATE_BOOKS VALUES (
  (1, '9781430240952'),
  (1, '9780980576856'),

  (2, '9781449356378'),
  (2, '9781849518307'),
  (2, '9780321503626'),
  (2, '9780321146533'),

  (4, '9781849510561'),
  (4, '9781935182351'),
  (4, '9780764574832')
);

SET FILES LOG TRUE;