package desafiosaldo.services

import desafiosaldo.model.SaldoResponse

interface SaldoService {
    fun getById(id: String): SaldoResponse
}