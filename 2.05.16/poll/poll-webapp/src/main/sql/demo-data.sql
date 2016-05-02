INSERT INTO POLL (ID, TITLE) VALUES
  (1, 'На каком курсе вы учитесь?'),
  (2, 'На какой кафедре вы учитесь?');

INSERT INTO POLL_CHOICE (ID, CHOICE_TEXT, VOTES, POLL_ID) VALUES
  (1, 'На 1', 0, 1),
  (2, 'На 2', 0, 1),
  (3, 'На 3', 0, 1),
  (4, 'На 4', 0, 1),
  (5, 'ИТИС', 0, 2),
  (6, 'ВМК',  0, 2);
