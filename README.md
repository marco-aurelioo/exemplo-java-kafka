# Projeto de exemplo 

### Objetivo:
Testar implementação de serviços ligados por eventos.

- [x] Java 8
- [x] Spring boot
- [x] Spring boot kafka
- [x] docker
- [x] kafka
- [x] Redis 
- [x] postgres

### Escopo do teste
Em um serviço de logistica temos um serviço que disponibiliza para lojas metoristas para retirada e entrega de encomendas.4
Para isso temos as seguintes funcionalidades:
- [x] Cadastro de loja.
- [x] Cadastro de motoristas.
- [x] Atualizacao posicao motorista.
- [ ] Busca por motorista mais proximo.
- [ ] Aceite de transporte.
- [ ] Acompanhamento movimentação do motorista para retirada.
- [ ] Acompanhamento movimentação do motorista para entrega.

#### Help commands:
iniciar docker:
```
 docker-compose rm
 docker-compose up
```

verificar mensagens na fila:

```
 docker ps
 docker exec -it docker_kafka_1 /bin/bash
 kafka-run-class kafka.tools.GetOffsetShell --broker-list kafka:29092 --topic car-position --time -1
 
```
deletar topico:

```
 kafka-topics --delete --bootstrap-server localhost:2181 --topic car-position

```
