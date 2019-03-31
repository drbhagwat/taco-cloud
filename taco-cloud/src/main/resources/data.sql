delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

/*
INSERT INTO users(username, password, enabled) values('dinesh', '{noop}bhagwat', true);
INSERT INTO authorities(id, username, authority) values(1, 'dinesh', 'ROLE_ADMIN');
*/

insert into Ingredient (id, name, type)
 values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
 values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
 values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
 values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
 values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
 values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
 values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
 values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
 values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
 values ('SRCR', 'Sour Cream', 'SAUCE');