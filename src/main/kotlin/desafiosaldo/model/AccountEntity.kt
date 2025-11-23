package desafiosaldo.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class AccountEntity(

    @Id
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "owner")
    val owner: UUID? = null,

    @Column(name = "created_at")
    val createdAt: String? = null,

    @Column(name = "status")
    val status: String? = null,

    @Column(name = "balance")
    val balance: String? = null
)