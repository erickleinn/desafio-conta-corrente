package desafiosaldo.web

import desafiosaldo.model.SaldoResponse
import desafiosaldo.services.SaldoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/balances")
class SaldoController(
    val saldoService: SaldoService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): SaldoResponse {
       return saldoService.getById(id)
    }
}