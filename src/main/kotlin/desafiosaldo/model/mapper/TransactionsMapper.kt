package desafiosaldo.model.mapper

import desafiosaldo.model.AccountEntity
import desafiosaldo.model.SaldoResponse
import desafiosaldo.model.TransactionMessage
import desafiosaldo.model.TransactionEntity
import org.springframework.stereotype.Component

@Component
class TransactionsMapper {
    fun fromMessageToTransactionEntity(message: TransactionMessage): TransactionEntity {
        return  TransactionEntity(
            id = message.transaction.id,
            type = message.transaction.type,
            amount = message.transaction.amount,
            currency = message.transaction.currency,
            status = message.transaction.status,
            timestamp = message.transaction.timestamp
        )
    }

    fun fromMessageToAccountEntity(message: TransactionMessage): AccountEntity {
        return AccountEntity(
            id = message.account.id,
            owner = message.account.owner,
            createdAt = message.account.createdAt,
            status = message.account.status,
            balance = message.account.balance.toString()
        )
    }

    fun fromAccountEntityToSaldoResponse(accountEntity: AccountEntity): SaldoResponse{
        return SaldoResponse(
            id = accountEntity.id.toString(),
            owner = accountEntity.owner.toString(),
            balance = accountEntity.balance,
            updatedAt = accountEntity.createdAt
        )
    }
}