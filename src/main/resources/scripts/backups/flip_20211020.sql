-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: flip
-- ------------------------------------------------------
-- Server version	8.0.11

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
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'Did you get any breakfast?','Ты завтракал?',4,'HEALTH'),(7,'Physical activity can help kids and teens build strong bone.','Физическая активность может помочь детям и подросткам построить крепкие кости.',7,'HEALTH'),(10,'Muscles tend to shorten and weaken with age.','Мышцы с возрастом укорачиваются и ослабевают.',5,'HEALTH'),(11,'And stretching improves your posture and balance.','А растяжка улучшает осанку и равновесие.',2,'HEALTH'),(12,'Exercise benefits every part of the body, including the mind','Упражнения приносят пользу каждой части тела, включая разум.',7,'HEALTH'),(13,'Exercise can help people sleep better.','Физические упражнения могут помочь людям лучше спать.',5,'HEALTH'),(14,'It can also help some people who have mild depression.','Это также может помочь некоторым людям с легкой депрессией.',5,'HEALTH'),(17,'Then there are other elements to add to the list.','Затем есть другие элементы, которые нужно добавить в список.',4,'HEALTH'),(20,'Eat consistently throughout the day and relax.','Ешьте регулярно в течение дня и расслабляйтесь.',2,'HEALTH'),(21,'Exercise has health benefits.','Упражнения полезны для здоровья.',3,'HEALTH'),(23,'Exercise can help improve the mind.','Упражнения помогают улучшить ум.',0,'HEALTH'),(24,'Exercise can help make people feel better.','Упражнения помогают людям чувствовать себя лучше.',4,'HEALTH'),(28,'Total cancer incidence is up.','Общая заболеваемость раком растет.',1,'HEALTH'),(29,'Intractable problems like joint and skeletal problems can occur.','Могут возникнуть трудноизлечимые проблемы, такие как проблемы с суставами и скелетом.',6,'HEALTH'),(31,'Practice healthy eating and drinking.','Практикуйте здоровое питание и питье.',2,'HEALTH'),(32,'Regular exercise may slow down the aging of cells','Регулярные физические упражнения могут замедлить старение клеток.',6,'HEALTH'),(34,'Exercise is great for your mind and body.','Физические упражнения отлично подходят для вашего ума и тела.',2,'HEALTH'),(35,'It can also help you deal with stress.','It can also help you deal with stress.',7,'HEALTH'),(38,'Exercise, may help kids and teens build strong bones.','Физические упражнения могут помочь детям и подросткам укрепить кости.',0,'HEALTH'),(40,'The following steps will help you feel better.','Следующие шаги помогут вам почувствовать себя лучше.',7,'HEALTH'),(41,'This is your daily diet.','Это твоя повседневная диета.',3,'HEALTH'),(42,'However, a number of problems constrain their work.','Однако ряд проблем сдерживает их работу.',5,'HEALTH'),(43,'This is in addition to my regular tobacco use.','Это в дополнение к тому, что я регулярно употребляю табак.',6,'HEALTH'),(45,'Maybe you use drugs.','Может ты употребляешь наркотики.',0,'HEALTH'),(46,'In such circumstances, we can learn new things very easily','В таких обстоятельствах мы можем очень легко узнавать новое.',2,'TRAVEL'),(47,'Everything seems beautiful and sterling in a different place','Все кажется красивым и чистым в другом месте',8,'TRAVEL'),(48,'It is really amazing for someone of our culture','Это действительно потрясающе для представителя нашей культуры',2,'TRAVEL'),(49,'Even exploring the world and meeting amazing people','Даже исследовать мир и встречаться с удивительными людьми',5,'TRAVEL'),(50,'I suggest everyone do it','Я предлагаю всем сделать это',1,'TRAVEL'),(51,'It will really improve their academic and social outlook','Это действительно улучшит их академическое и социальное мировоззрение.',8,'TRAVEL'),(52,'Even the banks of the River Thames are blooming','Цветут даже берега Темзы',2,'TRAVEL'),(53,'This opportunity is traveling from one place to another','Эта возможность путешествовать из одного места в другое',1,'TRAVEL'),(54,'This is called traveling from one to another university','Это называется путешествием из одного университета в другой.',8,'TRAVEL'),(55,'There is lots of practicality and effectiveness behind traveling','За путешествиями стоит много практичности и эффективности.',7,'TRAVEL'),(56,'Business people go to foreign places for business purposes','Деловые люди едут за границу по делам.',4,'TRAVEL'),(59,'This is the most interesting part of traveling.','Это самая интересная часть путешествия.',7,'TRAVEL'),(60,'People travel for different purposes.','Люди путешествуют с разными целями.',1,'TRAVEL'),(61,'Also, you can learn geography through researching their places.','Кроме того, вы можете изучать географию, исследуя их места.',6,'TRAVEL'),(63,'Travelling is very useful for us especially for the learners.','Путешествия очень полезны для нас, особенно для учащихся.',6,'TRAVEL'),(65,'Travelling by ship is very popular now.','Путешествия на корабле сейчас очень популярны.',6,'TRAVEL'),(67,'Traveling is very pleasant.','Путешествовать очень приятно.',0,'TRAVEL'),(68,'Everything seems beautiful and smooth in the sun.','На солнце все кажется красивым и гладким.',2,'TRAVEL'),(69,'Everywhere you look is beautiful.','Куда бы вы ни посмотрели, везде красиво',4,'TRAVEL');
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
  KEY `record_to_card_fk` (`card_id`),
  CONSTRAINT `record_to_card_fk` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress`
--

LOCK TABLES `progress` WRITE;
/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
INSERT INTO `progress` VALUES (1,1,1.00),(2,10,0.05);
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

-- Dump completed on 2021-10-20 21:18:29
