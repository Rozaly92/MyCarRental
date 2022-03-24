insert into fuel(fuel_id, fuel)
values(1,"diesel");
insert into fuel(fuel_id, fuel)
values(2,"benzin");
insert into fuel(fuel_id, fuel)
values(3,"gasoline");
insert into fuel(fuel_id, fuel)
values(4,"hibrid");

insert into body(body_id, body)
values(1, "hatchback");
insert into body(body_id, body)
values(2, "minivan");
insert into body(body_id, body)
values(3, "universal");
insert into body(body_id, body)
values(4, "sedan");


insert into gearbox(gear_id, gear_box)
values(1, "automatic");
insert into gearbox(gear_id, gear_box)
values(2, "manual");


insert into employee(empl_id, empl_name, location)
values(1, "Ivan", "Chisinau");
insert into employee(empl_id, empl_name, location)
values(2, "Eugen", "Chisinau");
insert into employee(empl_id, empl_name, location)
values(3, "Denis", "Chisinau");
insert into employee(empl_id, empl_name, location)
values(4, "Tatiana", "Chisinau");
insert into employee(empl_id, empl_name, location)
values(5, "Oxana", "Chisinau");



insert into customer(cus_id, card_num, cus_name, phone_num)
values(1, 3575, "Pavel", "060586478");
insert into customer(cus_id, card_num, cus_name, phone_num)
values(2, 4875, "Serghei", "060586478");
insert into customer(cus_id, card_num, cus_name, phone_num)
values(3, 3442, "Lilian", "078562415");
insert into customer(cus_id, card_num, cus_name, phone_num)
values(4, 5678, "Emil", "067859641");



insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(1, "bmw", "abs", 125, 2015, 1, 2, 1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(2, "opel", "abs", 105, 2010, 2,1,1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(3, "ford", "abs", 124, 2016, 4,3, 2);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(4, "toyota", "abs", 142, 2019, 3, 2, 1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(5, "honda", "abs", 132, 2018, 1,2,1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(6, "dacia", "abs", 103, 2011, 4,3,1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(7, "audi", "abs", 145, 2018, 4, 4, 1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(8, "nissan", "abs", 176, 2021, 3,2,2);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(9, "volvo", "abs", 152, 2019, 2,3, 2);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(10, "mitsubishi", "abs",234 , 2022, 2, 1, 1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(11, "peugeot", "abs", 128, 2018, 1,2,1);
insert into cars(car_id, car_model, equipment, price_per_day, year, body_id, fuel_id, gear_id)
values(12, "volkswagen", "abs", 115, 2017, 1,3,2);


insert into orders(order_id, arend_time, car_id, cus_id, empl_id)
values(1, 2, 2, 3, 2);
insert into orders(order_id, arend_time, car_id, cus_id, empl_id)
values(2, 3, 6, 1, 1);
insert into orders(order_id, arend_time, car_id, cus_id, empl_id)
values(3, 1, 3, 2, 4);
