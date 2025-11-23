package desafiosaldo.services

import desafiosaldo.infra.repository.AccountsRepository
import desafiosaldo.model.SaldoResponse
import desafiosaldo.model.mapper.TransactionsMapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class SaldoServiceImpl(
    val accountsRepository: AccountsRepository,
    val transactionsMapper: TransactionsMapper
): SaldoService {
    override fun getById(id: String): SaldoResponse {
        val res = accountsRepository.findById(UUID.fromString(id))
        return transactionsMapper.fromAccountEntityToSaldoResponse(res.get())
    }
}