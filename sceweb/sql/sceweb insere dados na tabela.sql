select * from empresa; 
insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values("81965361000174","03/05/2016", "15/05/2016");
insert into convenio (empresa_cnpj, dataInicio, dataFim) values("81965361000174","03/05/2016", "15/05/2016");
delete from convenio where empresa_cnpj = "81965361000174";
delete from empresa where cnpj = "81965361000174";
select * from convenio;
