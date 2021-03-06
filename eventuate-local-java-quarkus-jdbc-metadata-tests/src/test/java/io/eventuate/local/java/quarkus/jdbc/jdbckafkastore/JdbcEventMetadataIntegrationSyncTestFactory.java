package io.eventuate.local.java.quarkus.jdbc.jdbckafkastore;

import io.eventuate.example.banking.domain.Account;
import io.eventuate.example.banking.domain.AccountCommand;
import io.eventuate.local.java.jdbckafkastore.AccountMetadataEventHandler;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStoreCrud;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class JdbcEventMetadataIntegrationSyncTestFactory {

  @Singleton
  public AggregateRepository<Account, AccountCommand> syncAccountRepository(@Named("syncEventuateAggregateStoreCrud") EventuateAggregateStoreCrud aggregateStore) {
    return new AggregateRepository<>(Account.class, aggregateStore);
  }

  @Singleton
  public AccountMetadataEventHandler accountMetadataEventHandler() {
    return new AccountMetadataEventHandler();
  }
}
