# SELECT DISTINCT main.name, city.city from hotel AS main, city  WHERE main.city = city.id AND city.city = 'Рим';
# INSERT INTO types
# SELECT hotel.id, COUNT(city.id) FROM hotel, city WHERE hotel.id=1 GROUP BY hotel.id
SELECT city.id, COUNT(hotel.id) FROM city LEFT JOIN hotel ON hotel.city = city.id WHERE 1 = 1 AND city.country='Англия'  GROUP BY city.id