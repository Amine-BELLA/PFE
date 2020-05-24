INSERT INTO reseau (id, res_id, coordonneegps, number_voie, reseau_num, province, region,route, reseau_serial_num)VALUES (3, 'resId1', 'N 11° W00°', 2, 1230, 'province1', 'region1', 'route1', 1);


INSERT INTO equipement (id, fournisseur, mode, model, num_serie, reseau_id)VALUES (4, 'fournisseur1', 'CB', 'model1', 'serie1',3);;

INSERT INTO equipement (id, fournisseur, mode, model, num_serie, reseau_id)VALUES (5, 'fournisseur2', 'CB', 'model2', 'serie2',3);


INSERT INTO voie (id, numero, sens, reseau_id)VALUES (6, 1, 'AB', 3);

INSERT INTO voie (id, numero, sens, reseau_id)VALUES (7, 2, 'AB', 3);

INSERT INTO voie (id, numero, sens, reseau_id)VALUES (8, 3, 'BA', 3);

INSERT INTO voie (id, numero, sens, reseau_id)VALUES (9, 4, 'BA', 3);


INSERT INTO vehicule (id, longueur, num_essieu, silouhette)VALUES(15, 240, 2, 'siloh1');

INSERT INTO vehicule (id, longueur, num_essieu, silouhette)VALUES(10, 330, 3, 'siloh2');

INSERT INTO vehicule (id, longueur, num_essieu, silouhette)VALUES(11, 280, 2, 'siloh3');


INSERT INTO distance_essieu (id, sp, vehicule_id)VALUES (12, 140, 15);

INSERT INTO distance_essieu (id, sp, vehicule_id)VALUES (13, 130, 10);


INSERT INTO passage (id, classe_vehicule, date, gap, gross, headway, overloaded, speed_kmh, timestamp, time, type_poids, equip_id , voie_id, vehicule_id)Values(1, 'EU13-1', '2020-01-20', 120, 3500, 200, 'N', 90,'2020-01-20 12:12:11' ,'12:12:11', 'PL', 4, 6, 15);

INSERT INTO passage (id, classe_vehicule, date, gap, gross, headway, overloaded, speed_kmh,timestamp, time, type_poids, equip_id , voie_id, vehicule_id)Values(2, 'EU13-3', '2020-02-20', 120, 4000, 210, 'N', 90,'2020-02-20 02:12:11', '02:12:11', 'PL', 4, 7, 10);

INSERT INTO passage (id, classe_vehicule, date, gap, gross, headway, overloaded, speed_kmh,timestamp, time, type_poids, equip_id , voie_id, vehicule_id)Values(20, 'EU13-1', '2020-01-20', 120, 300, 200, 'N', 90,'2020-01-20 02:12:11' ,'02:12:11', 'VL', 4, 6, 11);