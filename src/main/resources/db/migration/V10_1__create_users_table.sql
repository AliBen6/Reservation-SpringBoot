CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(60) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  `email` varchar(255) NOT NULL,
  `langue` varchar(2) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY(id)
);
