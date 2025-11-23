package desafiosaldo.model

import java.math.BigDecimal
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class Accounts(

    @Id
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "owner")
    val owner: UUID? = null,

    @Column(name = "created_at")
    val createAt: String? = null,

    @Column(name = "status")
    val status: String? = null,

    @Column(name = "balance")
    val balance: String? = null
)