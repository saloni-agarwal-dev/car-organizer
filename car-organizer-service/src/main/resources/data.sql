INSERT INTO Manufacturer (id,name,city) VALUES ('1' ,'BMW','Munich');
INSERT INTO Manufacturer (id,name,city) VALUES ('2' ,'Audi','Ingolstadt');


INSERT INTO Model (id,name,base_cost,manufacturer_id) VALUES ('1' ,'i3','40000',1);
INSERT INTO Model (id,name,base_cost,manufacturer_id) VALUES ('2' ,'i4','50000',1);
INSERT INTO Model (id,name,base_cost,manufacturer_id) VALUES ('3' ,'i5','60000',2);



INSERT INTO Features (id,name,cost) VALUES ('1' ,'Climate Control','600');

INSERT INTO Model_Features (model_id,feature_id) VALUES (1 ,1);
