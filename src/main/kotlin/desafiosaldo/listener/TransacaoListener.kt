package desafiosaldo.listener

import com.fasterxml.jackson.databind.ObjectMapper
import desafiosaldo.infra.repository.AccountsRepository
import desafiosaldo.infra.repository.TransactionsRepository
import desafiosaldo.model.Accounts
import desafiosaldo.model.TransactionMessage
import desafiosaldo.model.Transactions
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class TransacaoListener(
    val transactionsRepository: TransactionsRepository,
    val accountsRepository: AccountsRepository
) {

    val log = LoggerFactory.getLogger(TransacaoListener::class.java.name)

    @SqsListener(value = ["\${message.sqs.transacoes}"])
    fun listen(data: String){
        log.info("mensagem da fila: $data")
        val message = ObjectMapper().readValue(data, TransactionMessage::class.java)
        transactionsRepository.save(
            Transactions(
                id = message.transaction.id,
                type = message.transaction.type,
                amount = message.transaction.amount,
                currency = message.transaction.currency,
                status = message.transaction.status,
                timestamp = message.transaction.timestamp
            )
        )
        accountsRepository.save(
            Accounts(
                id = message.account.id,
                owner = message.account.owner,
                createAt = message.account.createdAt,
                status = message.account.status,
                balance = message.account.balance.toString()
            )
        )
    }
}