INSERT INTO public.address(	id_address, city, country, post_code, region, street_name, street_number)
VALUES 
(nextval('address_id_address_seq'), 'Marseille', 'France', 13016, 'PACA',	'Impasse Henry', NULL),
(nextval('address_id_address_seq'), 'Aix-en-Provence', 'France', 13100, 'PACA', 'Cour mirabeau', NULL),
(nextval('address_id_address_seq'), 'Perpignan', 'France', 66000, 'PYRENEES-ORIENTALES', 'boulevard de la libération', NULL),
(nextval('address_id_address_seq'),	'Toulon', 'France',	83000, 'PACA', 'Vallon des mayans', NULL),
(nextval('address_id_address_seq'),	'Chambery',	'France',	73000, 'AUVERGNE-RHONE-ALPES', 'Chemin des mimosas', NULL),
(nextval('address_id_address_seq'),	'Annecy',	'France',	74000,'AUVERGNE-RHONE-ALPES', 'chemin du lac', NULL);

 INSERT INTO public.role(code, label)
 VALUES 
 (1, 'utilisateur'),
 (2, 'adherent');

INSERT INTO public.user_account(id_user, email, lastname, login, name, password, code)
VALUES
 (nextval('user_account_id_user_seq'), 'florent.r@gmail.com', 'Florent', 'flodu13', 'Petit', 'jux9SV/jYFAKFKPY/u+lgA==', 1),
 (nextval('user_account_id_user_seq'), 'philippe@gmail.com', 'Yves', 'phil', 'Costaud', 'jux9SV/jYFAKFKPY/u+lgA==', 1),
 (nextval('user_account_id_user_seq'), 'eric@gmail.com', 'Eric', 'admin', 'Grand', 'jux9SV/jYFAKFKPY/u+lgA==', 2);


INSERT INTO public.spot(id_spot,  niveau_difficulte, name,  nombre_voie, tag, id_address)
VALUES
(nextval('spot_id_spot_seq'),	'1a à  4c','Calanques',25 ,	TRUE,	1),
(nextval('spot_id_spot_seq'),	'2b à  5a','Sainte Victoire', 15, TRUE, 2),
(nextval('spot_id_spot_seq'),	 '1a à  2a','Catal', 17, TRUE,	3),
(nextval('spot_id_spot_seq'),	 '3d à  6a','Massif des maures', 34, TRUE, 4),
(nextval('spot_id_spot_seq'),	 '3c à  5a','Massif de la chartreuse', 16, NULL, 5),
(nextval('spot_id_spot_seq'),	 '4b à  6c','Massif du lac', 32, NULL, 6);


INSERT INTO public.sector(id_sector, name, path_number, id_spot)
VALUES
 (nextval('sector_id_sector_seq'), 'Calan', 15, 2),
 (nextval('sector_id_sector_seq'), 'Vic', 1, 2),
 (nextval('sector_id_sector_seq'), 'Soleil', 9, 2),
 (nextval('sector_id_sector_seq'), 'Massif', 5, 2),
 (nextval('sector_id_sector_seq'), 'Chart', 7, 2),
 (nextval('sector_id_sector_seq'), 'Nature', 3, 2);

 	
INSERT INTO public.path(id_path, cotation, height, name, lenght_number, point_number, id_sector)
VALUES 
(nextval('path_id_path_seq'), '7a', 120, 'Le grand didre jaune', 3, 0, 1),
(nextval('path_id_path_seq'), '5b', 130, 'Le lezard rouge', 5, 20, 1),
(nextval('path_id_path_seq'), '6a', 120, 'Le chien qui aboie', 7, 35, 1),
(nextval('path_id_path_seq'), '4c', 150, 'Les Moussaillons', 5, 0, 1),
(nextval('path_id_path_seq'), '5c', 400, 'Le grand parcours', 13, 0, 2),
(nextval('path_id_path_seq'), '5a', 80, 'Le manchot excit', 5, 20, 3);


INSERT INTO public.topo(id_topo, available, description, location, name, publication_date, id_user)
VALUES 
(nextval('topo_id_topo_seq'), TRUE, 'Topo pour les spots calanques', 'PACA', 'Topos région Marseille', '2021/01/09', 1),
(nextval('topo_id_topo_seq'), TRUE, 'Topo pour les spots région Aixoise', 'PACA', 'Topos région Aixoise', '2020/03/09', 1),
(nextval('topo_id_topo_seq'), FALSE, 'Topo pour les spots de la région Pyrenné', 'PYRENEES-ORIENTALES', 'Topos région Pyrenné', '2020/12/01', 2),
(nextval('topo_id_topo_seq'), TRUE, 'Vous trouverez les topos pour les sites de Marocaz Et Gittaz', 'AUVERGNE-RHONE-ALPES', 'La Savoie', '2020/12/08', 2);


 INSERT INTO public.reservation_inquiry(id_inquiry, lend_date, statut, id_topo, id_user, message)
VALUES 
(nextval('reservation_inquiry_id_inquiry_seq'), '2021-01-03 09:40:26.704', 'en cours', 3, 1, 'Bonjour,  je suis grandement intéressé par ce topo');