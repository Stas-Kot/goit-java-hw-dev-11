INSERT INTO client (name) VALUES
('Greg'),
('Roman'),
('Cristofer'),
('Bohdan'),
('Danyl'),
('Petro'),
('Alex'),
('Dany'),
('Luk'),
('Martin');

INSERT INTO planet (id, name) VALUES
('MARS', 'Mars'),
('JUPI', 'Jupiter'),
('SATURN', 'Saturn'),
('VEN', 'Venus'),
('ANDRO', 'Andromedae'),
('KEPLER452', 'Kepler452');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MARS', 'JUPI'),
(2, 'SATURN', 'KEPLER452'),
(3, 'ANDRO', 'KEPLER452'),
(4, 'JUPI', 'MARS'),
(5, 'VEN', 'KEPLER452'),
(6, 'SATURN', 'JUPI'),
(7, 'VEN', 'MARS'),
(8, 'JUPI', 'SATURN'),
(9, 'VEN', 'ANDRO'),
(10, 'SATURN', 'JUPI'),
(1, 'ANDRO', 'SATURN'),
(2, 'SATURN', 'VEN');