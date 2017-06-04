SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DELETE FROM DisciplineZNO;
INSERT INTO DisciplineZNO (discipline_id, nazva) VALUES (1, 'Англійська мова'), (6, 'Біологія'),(7, 'Географія'),(11, 'Іспанська мова'),(5, 'Історія України'),(2, 'Математика'),(9, 'Німецька мова'),(3, 'Українська мова та література'),(4, 'Фізика'),(10, 'Французька мова'),(8, 'Хімія');

DELETE FROM Stat;
INSERT INTO Stat (stat_id, nazva_stati) VALUES (2, 'жінка'), (1, 'чоловік');

DELETE FROM ViyskoveZvanya;
INSERT INTO ViyskoveZvanya (zvanya_id, zvanya) VALUES (12, 'головний корабельний старшина'), (10, 'головний старшина'),(2, 'матрос'),(14, 'мічман'),(5, 'молодший сержант'),(13, 'прапорщик'),(7, 'сержант'),(1, 'солдат'),(4, 'старший матрос'),(16, 'старший мічман'),(15, 'старший прапорщик'),(9, 'старший сержант'),(3, 'старший солдат'),(11, 'старшина'),(8, 'старшина 1 статті'),(6, 'старшина 2 статті');

DELETE FROM FormaNavchannya;
INSERT INTO FormaNavchannya (froma_navch_id, tip) VALUES (1, 'Денна форма навчання'), (2, 'Заочна форма навчання');

DELETE FROM Specialnist;
INSERT INTO Specialnist (specialnist_id, abriviatura, specialnist) VALUES (1, 'КН', 'Комп’ютерні науки'),(2, 'КБ', 'Кібербезпека'),(3, 'ІСТ', 'Інформаційні системи та технології'),(4, 'ТР', 'Телекомунікації та радіотехніка'),(5, 'ВР', 'Військове управління (за видами збройних сил)'),(6, 'ОВТ', 'Озброєння та військова техніка');

DELETE FROM PilgiDocument;
INSERT INTO PilgiDocument (document_name, document_short) VALUES ('Посвідчення участника бойових дій', 'УБД');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
