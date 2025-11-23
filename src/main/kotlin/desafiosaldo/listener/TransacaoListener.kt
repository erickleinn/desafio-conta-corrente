package desafiosaldo.listener

import com.fasterxml.jackson.databind.ObjectMapper
import desafiosaldo.infra.repository.AccountsRepository
import desafiosaldo.infra.repository.TransactionsRepository
import desafiosaldo.model.TransactionMessage
import desafiosaldo.model.mapper.TransactionsMapper
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class TransacaoListener(
    val transactionsRepository: TransactionsRepository,
    val accountsRepository: AccountsRepository,
    val transactionsMapper: TransactionsMapper
) {

    val log = LoggerFactory.getLogger(TransacaoListener::class.java.name)

    @SqsListener(value = ["\${message.sqs.transacoes}"])
    fun listen(data: String){
        log.info("mensagem da fila: $data")
        val message = ObjectMapper().readValue(data, TransactionMessage::class.java)
        transactionsRepository.save(
            transactionsMapper.fromMessageToTransactionEntity(message)
        )
        accountsRepository.save(
            transactionsMapper.fromMessageToAccountEntity(message)
        )
    }
}