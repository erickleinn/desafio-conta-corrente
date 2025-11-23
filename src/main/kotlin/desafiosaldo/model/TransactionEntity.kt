package desafiosaldo.model

import java.math.BigDecimal
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "transactions")
data class TransactionEntity(

    @Id
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "type")
    val type: String? = null,

    @Column(name = "amount")
    val amount: BigDecimal? = null,

    @Column(name = "currency")
    val currency: String? = null,

    @Column(name = "status")
    val status: String? = null,

    @Column(name = "timestamp")
    val timestamp: String? = null
)
