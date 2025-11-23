package desafiosaldo.infra.repository

import desafiosaldo.model.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AccountsRepository: JpaRepository<AccountEntity, UUID> {
}