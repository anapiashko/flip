-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flip
-- ------------------------------------------------------
-- Server version	8.0.11
use flip;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `en_sentence` varchar(150) NOT NULL,
  `rus_sentence` varchar(150) NOT NULL,
  `missed_word` int(11) NOT NULL,
  `topic` enum('HEALTH','TRAVEL') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'Did you get any breakfast?','Ты завтракал?',4,'HEALTH'),(7,'Physical activity can help kids and teens build strong bone.','Физическая активность может помочь детям и подросткам построить крепкие кости.',7,'HEALTH'),(10,'Muscles tend to shorten and weaken with age.','Мышцы с возрастом укорачиваются и ослабевают.',5,'HEALTH'),(11,'And stretching improves your posture and balance.','А растяжка улучшает осанку и равновесие.',2,'HEALTH'),(12,'Exercise benefits every part of the body, including the mind','Упражнения приносят пользу каждой части тела, включая разум.',7,'HEALTH'),(13,'Exercise can help people sleep better.','Физические упражнения могут помочь людям лучше спать.',5,'HEALTH'),(14,'It can also help some people who have mild depression.','Это также может помочь некоторым людям с легкой депрессией.',5,'HEALTH'),(17,'Then there are other elements to add to the list.','Затем есть другие элементы, которые нужно добавить в список.',4,'HEALTH'),(20,'Eat consistently throughout the day and relax.','Ешьте регулярно в течение дня и расслабляйтесь.',2,'HEALTH'),(21,'Exercise has health benefits.','Упражнения полезны для здоровья.',3,'HEALTH'),(23,'Exercise can help improve the mind.','Упражнения помогают улучшить ум.',0,'HEALTH'),(24,'Exercise can help make people feel better.','Упражнения помогают людям чувствовать себя лучше.',4,'HEALTH'),(28,'Total cancer incidence is up.','Общая заболеваемость раком растет.',1,'HEALTH'),(29,'Intractable problems like joint and skeletal problems can occur.','Могут возникнуть трудноизлечимые проблемы, такие как проблемы с суставами и скелетом.',6,'HEALTH'),(31,'Practice healthy eating and drinking.','Практикуйте здоровое питание и питье.',2,'HEALTH'),(32,'Regular exercise may slow down the aging of cells','Регулярные физические упражнения могут замедлить старение клеток.',6,'HEALTH'),(34,'Exercise is great for your mind and body.','Физические упражнения отлично подходят для вашего ума и тела.',2,'HEALTH'),(35,'It can also help you deal with stress.','Это также может помочь вам справиться со стрессом.',7,'HEALTH'),(38,'Exercise, may help kids and teens build strong bones.','Физические упражнения могут помочь детям и подросткам укрепить кости.',0,'HEALTH'),(40,'The following steps will help you feel better.','Следующие шаги помогут вам почувствовать себя лучше.',7,'HEALTH'),(41,'This is your daily diet.','Это твоя повседневная диета.',3,'HEALTH'),(42,'However, a number of problems constrain their work.','Однако ряд проблем сдерживает их работу.',5,'HEALTH'),(43,'This is in addition to my regular tobacco use.','Это в дополнение к тому, что я регулярно употребляю табак.',6,'HEALTH'),(45,'Maybe you use drugs.','Может ты употребляешь наркотики.',0,'HEALTH'),(46,'In such circumstances, we can learn new things very easily','В таких обстоятельствах мы можем очень легко узнавать новое.',2,'TRAVEL'),(47,'Everything seems beautiful and sterling in a different place','Все кажется красивым и чистым в другом месте',8,'TRAVEL'),(48,'It is really amazing for someone of our culture','Это действительно потрясающе для представителя нашей культуры',2,'TRAVEL'),(49,'Even exploring the world and meeting amazing people','Даже исследовать мир и встречаться с удивительными людьми',5,'TRAVEL'),(50,'I suggest everyone do it','Я предлагаю всем сделать это',1,'TRAVEL'),(51,'It will really improve their academic and social outlook','Это действительно улучшит их академическое и социальное мировоззрение.',8,'TRAVEL'),(52,'Even the banks of the River Thames are blooming','Цветут даже берега Темзы',2,'TRAVEL'),(53,'This opportunity is traveling from one place to another','Эта возможность путешествовать из одного места в другое',1,'TRAVEL'),(54,'This is called traveling from one to another university','Это называется путешествием из одного университета в другой.',8,'TRAVEL'),(55,'There is lots of practicality and effectiveness behind traveling','За путешествиями стоит много практичности и эффективности.',7,'TRAVEL'),(56,'Business people go to foreign places for business purposes','Деловые люди едут за границу по делам.',4,'TRAVEL'),(59,'This is the most interesting part of traveling.','Это самая интересная часть путешествия.',7,'TRAVEL'),(60,'People travel for different purposes.','Люди путешествуют с разными целями.',1,'TRAVEL'),(61,'Also, you can learn geography through researching their places.','Кроме того, вы можете изучать географию, исследуя их места.',6,'TRAVEL'),(63,'Travelling is very useful for us especially for the learners.','Путешествия очень полезны для нас, особенно для учащихся.',6,'TRAVEL'),(65,'Travelling by ship is very popular now.','Путешествия на корабле сейчас очень популярны.',6,'TRAVEL'),(67,'Traveling is very pleasant.','Путешествовать очень приятно.',0,'TRAVEL'),(68,'Everything seems beautiful and smooth in the sun.','На солнце все кажется красивым и гладким.',2,'TRAVEL'),(69,'Everywhere you look is beautiful.','Куда бы вы ни посмотрели, везде красиво',4,'TRAVEL'),(80,'Everyone has their own unique skill set','У каждого свой уникальный набор навыков',4,'TRAVEL'),(81,'New roads, new buildings and, of course, new cities','Новые дороги, новостройки и, конечно же, новые города',3,'TRAVEL'),(82,'You can get this and many other things by traveling','Вы можете получить это и многое другое, путешествуя',6,'TRAVEL'),(83,'People get stuck in long lines or make poor decisions','Люди застревают в длинных очередях или принимают неверные решения',2,'TRAVEL'),(84,'People who travel have become the norm','Люди, которые путешествуют, стали нормой',4,'TRAVEL'),(86,'People are traveling the entire world on a daily basis','Люди ежедневно путешествуют по всему миру',9,'TRAVEL'),(88,'We tell our children to read and to think big','Мы говорим детям читать и мыслить масштабно',8,'TRAVEL'),(90,'We take it as a chance to learn more','Мы используем это как шанс узнать больше',7,'TRAVEL'),(92,'Traveling reveals a whole new and exciting world out there','Путешествие открывает целый новый захватывающий мир',7,'TRAVEL'),(93,'This is how I see traveling','Вот как я вижу путешествия',5,'TRAVEL'),(94,'I travel by way of to India.','Я путешествую через Индию.',6,'TRAVEL'),(96,'It is an effective cancer treatment.','Это эффективное лечение рака.',5,'HEALTH'),(98,'Yoga helps them fix it.','Йога помогает им это исправить.',0,'HEALTH'),(99,'Group activities are also an important part of everyday life.','Групповые занятия также являются важной частью повседневной жизни.',0,'HEALTH'),(101,'Traveling is also a part of education','Путешествия также являются частью образования.',0,'TRAVEL'),(102,'Now travelers are provided with everything they can imagine.','Теперь путешествующим предоставляется все, что он может представить.',1,'TRAVEL'),(106,'Traveling is, however, very possible.','Путешествие, однако, очень возможно.',4,'TRAVEL'),(108,'But it never gives them the real experience.','Но это никогда не дает им настоящего опыта.',7,'TRAVEL'),(109,'Traveling is a beautiful art.','Путешествие - это прекрасное искусство.',3,'TRAVEL'),(110,'Travelling has manifold benefits.','Путешествие имеет множество преимуществ.',2,'TRAVEL'),(111,'It is a part and parcel of our education.','Это неотъемлемая часть нашего образования.',8,'TRAVEL'),(112,'Our education and bookish knowledge remain imperfect without traveling','Наше образование и книжные знания остаются несовершенными без путешествий.',1,'TRAVEL'),(113,'We can learn many things from traveling','Мы можем многому научиться в путешествиях.',2,'TRAVEL');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress`
--

DROP TABLE IF EXISTS `progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `progress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) NOT NULL,
  `probability` decimal(5,2) DEFAULT '1.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_id` (`card_id`),
  KEY `record_to_card_fk` (`card_id`),
  CONSTRAINT `record_to_card_fk` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress`
--

LOCK TABLES `progress` WRITE;
/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
INSERT INTO `progress` VALUES (4,1,0.90),(5,7,0.90),(6,10,0.81),(7,11,0.90),(8,12,0.81),(9,13,0.90),(10,14,0.90),(11,17,0.90),(12,20,0.90),(13,21,0.90),(14,23,1.00),(15,24,1.00),(16,28,1.00),(17,29,1.00),(18,31,1.00),(19,32,1.00),(20,34,1.00),(21,35,1.00),(22,38,1.00),(23,40,1.00),(24,41,1.00),(25,42,1.00),(26,43,1.00),(27,45,1.00),(28,46,1.00),(29,47,1.00),(30,48,1.00),(31,49,1.00),(32,50,1.00),(33,51,1.00),(34,52,1.00),(35,53,1.00),(36,54,1.00),(37,55,1.00),(38,56,1.00),(39,59,1.00),(40,60,1.00),(41,61,1.00),(42,63,1.00),(43,65,1.00),(44,67,1.00),(45,68,1.00),(46,69,1.00),(47,80,1.00),(48,81,1.00),(49,82,1.00),(50,83,1.00),(51,84,1.00),(53,86,1.00),(55,88,1.00),(57,90,1.00),(59,92,1.00),(60,93,1.00),(61,94,1.00),(63,96,1.00),(65,98,1.00),(66,99,1.00),(68,101,1.00),(69,102,1.00),(73,106,1.00),(75,108,1.00),(76,109,1.00),(77,110,1.00),(78,111,1.00),(79,112,1.00),(80,113,1.00);
/*!40000 ALTER TABLE `progress` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-01 23:45:16
