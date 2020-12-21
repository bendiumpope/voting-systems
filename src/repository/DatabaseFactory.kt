package com.voting_system.repository

import com.voting_system.model.*
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(){
        Database.connect(hikari())

        transaction {
            SchemaUtils.create(Users)
            SchemaUtils.create(Completeds)
            SchemaUtils.create(AssistFinSecs)
            SchemaUtils.create(DiasporalAfricas)
            SchemaUtils.create(DiasporalAmericas)
            SchemaUtils.create(DiasporalAsias)
            SchemaUtils.create(DiasporalEurops)
            SchemaUtils.create(DiasporalUks)
            SchemaUtils.create(FinancialSecs)
            SchemaUtils.create(GeneralSecs)
            SchemaUtils.create(Presidents)
            SchemaUtils.create(Provosts)
            SchemaUtils.create(SocialPubs)
            SchemaUtils.create(Treasurers)
            SchemaUtils.create(VicePresidents)
            SchemaUtils.create(Results)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = System.getenv("JDBC_DATABASE_URL")
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)

    }

    suspend fun <T> dbQuery(
        block: () -> T): T =
        withContext(Dispatchers.IO){
            transaction {block()}
        }
}