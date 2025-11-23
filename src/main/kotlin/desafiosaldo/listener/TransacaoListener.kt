package desafiosaldo.listener

import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TransacaoListener {

    val log = LoggerFactory.getLogger(TransacaoListener::class.java.name)

    //@SqsListener(value = ["\${message.sqs.transacoes}"])
    fun listen(message: String){
        log.info("mensagem da fila: $message")
    }
}