use s185140;
INSERT INTO recipe VALUES (2, "Minor Health potion", '1955-2-23', true);
INSERT INTO commodity VALUES (5, "Fairy wings", true);
INSERT INTO ingredient VALUES (3, 5, 2, '1912-7-21');

select * FROM commodity;

insert into production_batch VALUES (3, 1, 200, '2019-01-12');

select * from get_all_recipes where id_recipe = 2 ORDER BY id_recipe, time_stamp, id_com;


CREATE VIEW get_commodity_batches AS
SELECT id_com_batch, commodity_batch.id_com, name, amount, is_remainder
FROM commodity_batch JOIN commodity ON commodity_batch.id_com = commodity.id_com;

CREATE VIEW get_production_batch AS
SELECT id_production_batch, production_batch.id_recipe, name AS recipe, batch_size, production_batch.time_stamp 
FROM production_batch LEFT JOIN recipe ON production_batch.id_recipe = recipe.id_recipe;

CREATE VIEW get_all_recipes AS
SELECT recipe.id_recipe, recipe.name, recipe.is_in_use, recipe.time_stamp, ingredient.id_com, commodity.name AS commodity, ingredient.amount 
FROM recipe 
	LEFT JOIN ingredient 
		ON recipe.id_recipe = ingredient.id_recipe AND recipe.time_stamp = ingredient.time_stamp
        LEFT JOIN commodity 
		ON ingredient.id_com = commodity.id_com
GROUP BY id_recipe, time_stamp, recipe.name, is_in_use, id_com;

ALTER TABLE commodity_batch ADD COLUMN time_stamp date;

ALTER VIEW get_commodity_batches AS 
SELECT id_com_batch, commodity_batch.id_com, name, amount, commodity_batch.time_stamp, is_remainder
FROM commodity_batch JOIN commodity ON commodity_batch.id_com = commodity.id_com;

select * from user;
delete from user;