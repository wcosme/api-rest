CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `funcionario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
