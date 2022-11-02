--Select
--ANSII
Select ContactName, CompanyName, City from Customers

--Where
Select * from Customers where City = 'Berlin'

--case insensitive
Select * from Products where categoryId = 1 or categoryId = 3
Select * from Products where categoryId = 1 and categoryId >= 6

--Order By
--Sıralama
Select * from Products order by ProductName
--Her kategoriID'sinin kendi içinde ProductName'ini alfabetik sırala.
Select * from Products order by CategoryID, ProductName

--Ascending(ASC)-Descending(DESC)
Select * from Products order by UnitPrice asc  --artan
Select * from Products order by UnitPrice desc --azalan
--İlk CategoryId 1'leri getir. Sonra UnitPrice'ları artan sırada yazdır.
Select * from Products where categoryId = 1 order by UnitPrice asc 

--Count(Adet)
select count(*) from Products
--categoryId'si 2 olan ürünlerin miktarını yazdır.
select count(*) from Products where CategoryID = 2

--Group by
Select categoryID from Products group by CategoryID
Select categoryID,count(*) from Products group by CategoryID

--Having
--Having, count(*),sum vs. gibi kümülatiflere uygularız.
Select categoryID,count(*) from Products group by CategoryID having count(*)<10

--Example
--UnitPrice'ı 20 den büyük olanları filtrele. CategoryID'ye göre grupla. Miktarı
--10'dan az olanları sırala.
Select categoryID,count(*) from Products where UnitPrice>20
group by CategoryID having count(*)>10

--Inner Joın/on
Select Products.ProductID, Products.ProductName, Products.UnitPrice,
Categories.CategoryName from Products inner join Categories
on Products.CategoryID = Categories.CategoryID

Select Products.ProductID, Products.ProductName, Products.UnitPrice,
Categories.CategoryName from Products inner join Categories
on Products.CategoryID = Categories.CategoryID where Products.UnitPrice>10


--DTO(Data Transformation object

Select * from Products p left join [Order Details] od
on p.ProductID = o.ProductID

--Left Joın
--Solda olup sağda olmayan verileri ekrana getirir.

--Example:
--Sadece solda olup sağda olmayan(null) verileri ekrana getir.
Select * from Customers c left join Orders o 
on c.CustomerID = o.CustomerID
where o.CustomerID is null

--Right Joun
--Sağda olup solda olmayan verileri ekrana getirir.
