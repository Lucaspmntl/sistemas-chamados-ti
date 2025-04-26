-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_chamados
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chamado`
--

DROP TABLE IF EXISTS `chamado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chamado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_abertura` datetime(6) DEFAULT NULL,
  `data_fechamento` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `status` enum('ABERTO','CANCELADO','CONCLUIDO','EM_ANDAMENTO') DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `categoria_id` bigint DEFAULT NULL,
  `tecnico_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKntefhv75gc9w2hdkoq6e5d35h` (`categoria_id`),
  KEY `FKjiq335b82j7r725un4yk0vy6j` (`tecnico_id`),
  KEY `FK8bc0ospjmkj8qk0lve9pppwyu` (`usuario_id`),
  CONSTRAINT `FK8bc0ospjmkj8qk0lve9pppwyu` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKjiq335b82j7r725un4yk0vy6j` FOREIGN KEY (`tecnico_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKntefhv75gc9w2hdkoq6e5d35h` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chamado`
--

LOCK TABLES `chamado` WRITE;
/*!40000 ALTER TABLE `chamado` DISABLE KEYS */;
INSERT INTO `chamado` VALUES (1,'2025-04-26 13:16:25.000000','2025-04-26 13:20:17.651131','A impressora começou a imprimir páginas em branco.','CONCLUIDO','Problema na impressora do RH',1,NULL,NULL),(2,'2025-04-26 13:16:36.000000',NULL,'Monitor do setor contábil está com a tela tremendo.','CANCELADO','Monitor piscando',2,NULL,NULL),(3,'2025-04-26 13:16:38.000000','2025-04-26 13:20:05.973917','A tecla \"A\" está digitando \"S\", e vice-versa.','CONCLUIDO','Teclado com teclas trocadas',2,NULL,NULL),(4,'2025-04-26 13:16:41.000000',NULL,'Um ruído que lembra miado de gato começou a sair do gabinete.','EM_ANDAMENTO','Computador fazendo barulho estranho',1,NULL,NULL),(5,'2025-04-26 13:16:42.000000',NULL,'Encontraram um gato dentro da sala dos servidores. Ninguém sabe como entrou.','EM_ANDAMENTO','Gato encontrado no servidor',3,NULL,NULL),(6,'2025-04-26 13:16:44.000000','2025-04-26 13:19:37.121479','O sistema caiu logo após um miado alto ser ouvido vindo da TI.','CONCLUIDO','Sistema fora do ar após miado misterioso',4,NULL,NULL),(7,'2025-04-26 13:16:45.000000',NULL,'Alguém tentou dar leite para o \"gato do servidor\", e o leite caiu no teclado.','EM_ANDAMENTO','Teclado molhado',2,NULL,NULL),(8,'2025-04-26 13:16:47.000000',NULL,'Agora a sala está com cheiro de atum e ninguém quer entrar.','EM_ANDAMENTO','Cheiro estranho na TI',3,NULL,NULL),(9,'2025-04-26 13:16:48.000000',NULL,'Durante uma videoconferência, o gato apareceu e desligou o projetor com a pata.','EM_ANDAMENTO','Reunião invadida por gato',4,NULL,NULL),(10,'2025-04-26 13:16:50.000000','2025-04-26 13:18:24.632683','O sistema trava ao tentar gerar relatórios financeiros.','CONCLUIDO','Sistema ERP travando',4,NULL,NULL),(11,'2025-04-26 13:16:52.000000',NULL,'Usuário não consegue abrir o webmail, diz que a senha está incorreta.','ABERTO','Erro ao acessar e-mail',4,NULL,NULL),(12,'2025-04-26 13:16:54.000000',NULL,'A máquina reinicia do nada ao abrir o navegador.','ABERTO','Computador reiniciando sozinho',1,NULL,NULL),(13,'2025-04-26 13:16:55.000000',NULL,'Mouse com delay e movimento irregular.','ABERTO','Mouse travando',2,NULL,NULL),(14,'2025-04-26 13:16:56.000000','2025-04-26 13:18:19.475532','Usuário bloqueado após a última atualização do sistema.','CONCLUIDO','Login bloqueado após atualização',4,NULL,NULL),(15,'2025-04-26 13:16:58.000000','2025-04-26 13:18:10.488464','O gato foi adotado, ganhou crachá e agora se chama \"Byte\".','CONCLUIDO','Novo mascote oficial do setor de TI',3,NULL,NULL),(16,'2025-04-26 13:17:00.000000',NULL,'Nosso novo \"colaborador\" gosta de deitar no nobreak e desligou tudo sem querer.','EM_ANDAMENTO','Byte dormindo no nobreak',1,NULL,NULL),(17,'2025-04-26 13:17:01.000000',NULL,'O gato Byte subiu no teclado e postou \"ssssssssssssdffff\" no canal geral.','EM_ANDAMENTO','Byte postou no Slack',4,NULL,NULL),(18,'2025-04-26 13:17:03.000000','2025-04-26 13:18:14.877286','O sinal está oscilando bastante e perdendo conexão.','CONCLUIDO','Wi-Fi instável no andar 2',3,NULL,NULL),(19,'2025-04-26 13:17:04.000000',NULL,'O antivírus não atualiza desde ontem.','ABERTO','Atualização de antivírus falhou',4,NULL,NULL),(20,'2025-04-26 13:17:05.000000',NULL,'O celular fornecido pela empresa parou de funcionar.','ABERTO','Celular corporativo não liga',2,NULL,NULL),(21,'2025-04-26 13:17:07.000000',NULL,'Projetor da sala de reunião liga, mas não projeta nada.','CANCELADO','Projetor sem imagem',3,NULL,NULL),(22,'2025-04-26 13:17:08.000000',NULL,'Após resolver acidentalmente um bug ao pisar no teclado, Byte foi promovido a Chefe de TI.','EM_ANDAMENTO','Byte virou chefe da TI',4,NULL,NULL),(23,'2025-04-26 13:17:09.000000','2025-04-26 13:19:58.860706','Relógio de ponto não está registrando as entradas corretamente.','CONCLUIDO','Erro no sistema de ponto eletrônico',4,NULL,NULL),(24,'2025-04-26 13:17:11.000000','2025-04-26 13:19:52.666474','Scanner não reconhece o computador.','CONCLUIDO','Problema no scanner da recepção',1,NULL,NULL),(25,'2025-04-26 13:17:12.000000',NULL,'Cabo de rede solto causando tropeço.','ABERTO','Cabeamento exposto no andar 3',3,NULL,NULL),(26,'2025-04-26 13:17:13.000000',NULL,'Conexão VPN cai após 5 minutos.','CANCELADO','Erro no acesso à VPN',4,NULL,NULL),(27,'2025-04-26 13:17:15.000000',NULL,'Telefone do suporte não emite som de discagem.','ABERTO','Telefone IP mudo',2,NULL,NULL),(28,'2025-04-26 13:17:16.000000',NULL,'Usuário não consegue acessar após expiração de senha.','ABERTO','Senha expirada do sistema financeiro',4,NULL,NULL),(29,'2025-04-26 13:40:50.368345',NULL,'Precisamos de computadores novos para o setor 4!','EM_ANDAMENTO','Computador novo',1,NULL,NULL),(30,'2025-04-26 15:02:38.950148','2025-04-26 15:02:52.781131','teste 1','CONCLUIDO','Teste 1',6,NULL,NULL);
/*!40000 ALTER TABLE `chamado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26 15:15:17
