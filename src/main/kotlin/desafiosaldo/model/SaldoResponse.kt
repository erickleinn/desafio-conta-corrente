package desafiosaldo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SaldoResponse(

    @JsonProperty("id")
    val id: String?,

    @JsonProperty("owner")
    val owner: String?,

    @JsonProperty("balance")
    val balance: String?,

    @JsonProperty("updated_at")
    val updatedAt: String?
)