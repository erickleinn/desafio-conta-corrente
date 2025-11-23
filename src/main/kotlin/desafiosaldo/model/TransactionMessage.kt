package desafiosaldo.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.util.UUID

data class TransactionMessage(
    @JsonProperty("transaction")
    var transaction: Transaction,
    @JsonProperty("account")
    var account: Account
)

data class Transaction(
    @JsonProperty("id")
    var id: UUID?,
    @JsonProperty("type")
    var type: String?,
    @JsonProperty("amount")
    var amount: BigDecimal?,
    @JsonProperty("currency")
    var currency: String?,
    @JsonProperty("status")
    var status: String?,
    @JsonProperty("timestamp")
    var timestamp: String?
)

data class Account(
    @JsonProperty("id")
    var id: UUID?,
    @JsonProperty("owner")
    var owner: UUID?,
    @JsonProperty("created_at")
    var createdAt: String?,
    @JsonProperty("status")
    var status: String?,
    @JsonProperty("balance")
    var balance: Balance?
)

data class Balance(
    @JsonProperty("amount")
    val amount: BigDecimal,
    @JsonProperty("currency")
    val currency: String?
)