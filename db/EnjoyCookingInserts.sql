use enjoycooking;
insert into enjoycooking.classification (name) values ("Leafy Vegetables");
insert into enjoycooking.classification (name) values ("Root Vegetables");
insert into enjoycooking.classification (name) values ("Bulb Vegetables");
insert into enjoycooking.classification (name) values ("Inflorescent Vegetables");
select * from classification;
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Arugula", 1000, 2, 1);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Cabbage", 1000, 4, 1);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Spinach", 200, 2, 1);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Carrots", 3000, 8, 2);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Celeriac", 1500, 10, 2);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Radish", 500, 3, 2);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Onion", 700, 6, 3);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Leek", 1800, 12, 3);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Broccoli", 400, 5, 4);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Cauliflower", 900, 16, 4);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Artichoke", 300, 1, 4);
insert into enjoycooking.vegetables (name, weight, kcalPer100g, classification_id) values ("Scallion", 800, 3, 3);
select * from vegetables;
insert into  enjoycooking.recipes (kcal, weight, description) values (14, 400, "Spring salad");
select * from recipes;
insert into enjoycooking.recipes_has_vegetables (recipes_id, vegetables_id, quantity) values (1, 1, 50);
insert into enjoycooking.recipes_has_vegetables (recipes_id, vegetables_id, quantity) values (1, 2, 250);
insert into enjoycooking.recipes_has_vegetables (recipes_id, vegetables_id, quantity) values (1, 3, 50);
insert into enjoycooking.recipes_has_vegetables (recipes_id, vegetables_id, quantity) values (1, 12, 50);
select * from recipes_has_vegetables;





SELECT name FROM classification WHERE id = 2;