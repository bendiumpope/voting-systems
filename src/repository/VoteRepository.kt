package com.voting_system.repository

import com.voting_system.model.*
import com.voting_system.model.Users.id
import com.voting_system.repository.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*
import java.lang.IllegalArgumentException

class VoteRepository : Repository  {

    //USER
    override suspend fun user(userId: String, hash: String?): User? {
        val user = dbQuery {
            Users.select {
                (Users.id eq userId)
            }.mapNotNull { toUser(it) }
                .singleOrNull()
        }
        return when {
            user == null -> null
            hash == null -> user
            user.passwordHash == hash -> user
            else -> null
        }
    }


    override suspend fun users(): List<User> = dbQuery {
        Users.selectAll().map { toUser(it) }
    }

    override suspend fun removeuser(id: String): Boolean  {
        if (user(id, null) == null) {
            throw IllegalArgumentException("No User found for id $id.")
        }
        return dbQuery {
            Users.deleteWhere { Users.id eq id } > 0
        }
    }

    override suspend fun createUser(user: User) = dbQuery {
        Users.insert {
            it[id] = user.userId
            it[firstname] = user.firstname
            it[lastname] = user.lastname
            it[address] = user.address
            it[role] = user.role
            it[password] = user.password
            it[passwordHash] = user.passwordHash
        }
        Unit
    }

    override suspend fun updateuser(
        userId: String,
        newFirstname: String,
        newLastname: String,
        newAddress: String,
        newRole: String,
        newPassword: String,
        newPasswordHash: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun addcompleted(userId: String, votedVaulue: String)= dbQuery {
        val insertStatement = Completeds.insert {
            it[user] = userId
            it[voted] = votedVaulue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toCompleted(result)
        } else {
            null
        }
    }

    override suspend fun completed(userId: String): Completed? = dbQuery {
        Completeds.select {
            (Completeds.user eq userId)
        }.mapNotNull { toCompleted(it) }
            .singleOrNull()
    }

    //ASSISTANT FINANCIAL SECRETARY
    override suspend fun addassistfinsec(userId: String, voted_assist_fin_secValue: String) = dbQuery {
        val insertStatement = AssistFinSecs.insert {
            it[user] = userId
            it[voted_assist_fin_sec] = voted_assist_fin_secValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toAssistFinSec(result)
        } else {
            null
        }
    }


    override suspend fun assistfinsec(id: Int): AssistFinSec? = dbQuery {
        AssistFinSecs.select {
            (AssistFinSecs.id eq id)
        }.mapNotNull { toAssistFinSec(it) }
            .singleOrNull()
    }

    override suspend fun assistfinsec(voted_assist_fin_sec: String): List<AssistFinSec> = dbQuery {
        AssistFinSecs.select {
            (AssistFinSecs.voted_assist_fin_sec eq voted_assist_fin_sec)
        }.map { toAssistFinSec(it) }
    }

    override suspend fun assistfinsec(): List<AssistFinSec> = dbQuery {
        AssistFinSecs.selectAll().map { toAssistFinSec(it) }
    }


    override suspend fun updateassistfinsec(id: Int, newvoted_assist_fin_sec: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeassistfinsec(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removeassistfinsec(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //DIASPORAL AFRICA
    override suspend fun adddiasporalafrica(userId: String, voted_diasporal_africaValue: String)= dbQuery {
        val insertStatement = DiasporalAfricas.insert {
            it[user] = userId
            it[voted_diasporal_africa] = voted_diasporal_africaValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toDiasporalAfrica(result)
        } else {
            null
        }
    }

    override suspend fun diasporalafrica(id: Int): DiasporalAfrica? = dbQuery {
        DiasporalAfricas.select {
            (DiasporalAfricas.id eq id)
        }.mapNotNull { toDiasporalAfrica(it) }
            .singleOrNull()
    }

    override suspend fun diasporalafrica(voted_diasporal_africa: String): List<DiasporalAfrica> = dbQuery {
        DiasporalAfricas.select {
            (DiasporalAfricas.voted_diasporal_africa eq voted_diasporal_africa)
        }.map { toDiasporalAfrica(it) }
    }

    override suspend fun diasporalafrica(): List<DiasporalAfrica> = dbQuery {
        DiasporalAfricas.selectAll().map { toDiasporalAfrica(it) }
    }

    override suspend fun updatediasporalafrica(id: Int, newvoted_diasporal_africa: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalafrica(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalafrica(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //DIASPORAL AMERICA
    override suspend fun adddiasporalamerica(userId: String, voted_diasporal_americaValue: String) = dbQuery {
        val insertStatement = DiasporalAmericas.insert {
            it[user] = userId
            it[voted_diasporal_america] = voted_diasporal_americaValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toDiasporalAmerica(result)
        } else {
            null
        }
    }

    override suspend fun diasporalamerica(id: Int): DiasporalAmerica?  = dbQuery {
        DiasporalAmericas.select {
            (DiasporalAmericas.id eq id)
        }.mapNotNull { toDiasporalAmerica(it) }
            .singleOrNull()
    }

    override suspend fun diasporalamerica(voted_diasporal_america: String): List<DiasporalAmerica>  = dbQuery {
        DiasporalAmericas.select {
            (DiasporalAmericas.voted_diasporal_america eq voted_diasporal_america)
        }.map { toDiasporalAmerica(it) }
    }

    override suspend fun diasporalamerica(): List<DiasporalAmerica> = dbQuery {
            DiasporalAmericas.selectAll().map { toDiasporalAmerica(it) }
    }

    override suspend fun updatediasporalamerica(id: Int, newvoted_diasporal_america: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalamerica(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalamerica(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //DIASPORAL ASIA
    override suspend fun adddiasporalasia(userId: String, voted_diasporal_asiaValue: String) = dbQuery {
        val insertStatement = DiasporalAsias.insert {
            it[user] = userId
            it[voted_diasporal_asia] = voted_diasporal_asiaValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toDiasporalAsia(result)
        } else {
            null
        }
    }

    override suspend fun diasporalasia(id: Int): DiasporalAsia? = dbQuery {
        DiasporalAsias.select {
            (DiasporalAsias.id eq id)
        }.mapNotNull { toDiasporalAsia(it) }
            .singleOrNull()
    }

    override suspend fun diasporalasia(voted_diasporal_asia: String): List<DiasporalAsia> = dbQuery {
        DiasporalAsias.select {
            (DiasporalAsias.voted_diasporal_asia eq voted_diasporal_asia)
        }.map { toDiasporalAsia(it) }
    }

    override suspend fun diasporalasia(): List<DiasporalAsia> = dbQuery {
        DiasporalAsias.selectAll().map { toDiasporalAsia(it) }
    }

    override suspend fun updatediasporalasia(id: Int, newvoted_diasporal_asia: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalasia(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporalasia(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //DIASPORAL EUROP
    override suspend fun adddiasporaleurop(userId: String, voted_diasporal_europValue: String): DiasporalEurop?  = dbQuery {
        val insertStatement = DiasporalEurops.insert {
            it[user] = userId
            it[voted_diasporal_europ] = voted_diasporal_europValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toDiasporalEurop(result)
        } else {
            null
        }
    }

    override suspend fun diasporaleurop(id: Int): DiasporalEurop? = dbQuery {
        DiasporalEurops.select {
            (DiasporalEurops.id eq id)
        }.mapNotNull { toDiasporalEurop(it) }
            .singleOrNull()
    }

    override suspend fun diasporaleurop(voted_diasporal_europ: String): List<DiasporalEurop> = dbQuery {
        DiasporalEurops.select {
            (DiasporalEurops.voted_diasporal_europ eq voted_diasporal_europ)
        }.map { toDiasporalEurop(it) }
    }

    override suspend fun diasporaleurop(): List<DiasporalEurop> = dbQuery {
        DiasporalEurops.selectAll().map { toDiasporalEurop(it) }
    }

    override suspend fun updatediasporaleurop(id: Int, newvoted_diasporal_europ: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporaleurop(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporaleurop(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //DIASPORAL UK
    override suspend fun adddiasporaluk(userId: String, voted_diasporal_ukValue: String): DiasporalUK? = dbQuery {
        val insertStatement = DiasporalUks.insert {
            it[user] = userId
            it[voted_diasporal_uk] = voted_diasporal_ukValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toDiasporalUK(result)
        } else {
            null
        }
    }

    override suspend fun diasporaluk(id: Int): DiasporalUK? = dbQuery {
        DiasporalUks.select {
            (DiasporalUks.id eq id)
        }.mapNotNull { toDiasporalUK(it) }
            .singleOrNull()
    }

    override suspend fun diasporaluk(voted_diasporal_uk: String): List<DiasporalUK> = dbQuery {
        DiasporalUks.select {
            (DiasporalUks.voted_diasporal_uk eq voted_diasporal_uk)
        }.map { toDiasporalUK(it) }
    }

    override suspend fun diasporaluk(): List<DiasporalUK> = dbQuery {
        DiasporalUks.selectAll().map { toDiasporalUK(it) }
    }

    override suspend fun updatediasporaluk(id: Int, newvoted_diasporal_uk: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporaluk(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removediasporaluk(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //FINANCIAL SECRETARY
    override suspend fun addfinancialsec(userId: String, voted_financial_secValue: String): FinancialSec?  = dbQuery {
        val insertStatement = FinancialSecs.insert {
            it[user] = userId
            it[voted_financial_sec] = voted_financial_secValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toFinancialSec(result)
        } else {
            null
        }
    }


    override suspend fun financialsec(id: Int): FinancialSec? = dbQuery {
        FinancialSecs.select {
            (FinancialSecs.id eq id)
        }.mapNotNull { toFinancialSec(it) }
            .singleOrNull()
    }

    override suspend fun financialsec(voted_financial_sec: String): List<FinancialSec> = dbQuery {
        FinancialSecs.select {
            (FinancialSecs.voted_financial_sec eq voted_financial_sec)
        }.map { toFinancialSec(it) }
    }

    override suspend fun financialsec(): List<FinancialSec> = dbQuery {
        FinancialSecs.selectAll().map { toFinancialSec(it) }
    }
    override suspend fun updatefinancialsec(id: Int, newvoted_financial_sec: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removefinancialsec(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removefinancialsec(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //GENERAL SECRETARY
    override suspend fun addgeneralsec(userId: String, voted_general_secValue: String): GeneralSec? = dbQuery {
        val insertStatement = GeneralSecs.insert {
            it[user] = userId
            it[voted_general_sec] = voted_general_secValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toGeneralSec(result)
        } else {
            null
        }
    }

    override suspend fun generalsec(id: Int): GeneralSec? = dbQuery {
        GeneralSecs.select {
            (GeneralSecs.id eq id)
        }.mapNotNull { toGeneralSec(it) }
            .singleOrNull()
    }

    override suspend fun generalsec(voted_general_sec: String): List<GeneralSec> = dbQuery {
        GeneralSecs.select {
            (GeneralSecs.voted_general_sec eq voted_general_sec)
        }.map { toGeneralSec(it) }
    }

    override suspend fun generalsec(): List<GeneralSec> = dbQuery {
        GeneralSecs.selectAll().map { toGeneralSec(it) }
    }

    override suspend fun updategeneralsec(id: Int, newvoted_general_sec: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removegeneralsec(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removegeneralsec(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //PRESIDENT
    override suspend fun addpresident(userId: String, voted_presidentValue: String): President? = dbQuery {
        val insertStatement = Presidents.insert {
            it[user] = userId
            it[voted_president] = voted_presidentValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toPresident(result)
        } else {
            null
        }
    }

    override suspend fun president(id: Int): President? = dbQuery {
        Presidents.select {
            (Presidents.id eq id)
        }.mapNotNull { toPresident(it) }
            .singleOrNull()
    }

    override suspend fun president(voted_president: String): List<President> = dbQuery {
        Presidents.select {
            (Presidents.voted_president eq voted_president)
        }.map { toPresident(it) }
    }

    override suspend fun fetchpresident(username: String): List<President> = dbQuery{
        Presidents.select{
            (Presidents.user eq username)
        }.map { toPresident(it) }
    }

    override suspend fun president(): List<President> = dbQuery {
        Presidents.selectAll().map { toPresident(it) }
    }


    override suspend fun updatepresident(id: Int, newvoted_president: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removepresident(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removepresident(id: String): Boolean {
        TODO("Not yet implemented")
    }


        //ADD PROVOST
    override suspend fun addprovost(userId: String, voted_provostValue: String): Provost? = dbQuery {
            val insertStatement = Provosts.insert {
                it[user] = userId
                it[voted_provost] = voted_provostValue
            }
            val result = insertStatement.resultedValues?.get(0)
            if (result != null) {
                toProvost(result)
            } else {
                null
            }
        }

    override suspend fun provost(id: Int): Provost? = dbQuery {
        Provosts.select {
            (Provosts.id eq id)
        }.mapNotNull { toProvost(it) }
            .singleOrNull()
    }

    override suspend fun provost(voted_provost: String): List<Provost> = dbQuery {
        Provosts.select {
            (Provosts.voted_provost eq voted_provost)
        }.map { toProvost(it) }
    }

    override suspend fun provost(): List<Provost> = dbQuery {
        Provosts.selectAll().map { toProvost(it) }
    }

    override suspend fun updateprovost(id: Int, newvoted_provost: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeprovost(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removeprovost(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //SOCIAL PUBLIC OFFICER
    override suspend fun addsocialpub(userId: String, voted_social_pubValue: String): SocialPub? = dbQuery {
        val insertStatement = SocialPubs.insert {
            it[user] = userId
            it[voted_social_pub] = voted_social_pubValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toSocialPub(result)
        } else {
            null
        }
    }

    override suspend fun socialpub(id: Int): SocialPub? = dbQuery {
        SocialPubs.select {
            (SocialPubs.id eq id)
        }.mapNotNull { toSocialPub(it) }
            .singleOrNull()
    }

    override suspend fun socialpub(voted_social_pub: String): List<SocialPub> = dbQuery {
        SocialPubs.select {
            (SocialPubs.voted_social_pub eq voted_social_pub)
        }.map { toSocialPub(it) }
    }

    override suspend fun socialpub(): List<SocialPub> = dbQuery {
        SocialPubs.selectAll().map { toSocialPub(it) }
    }

    override suspend fun updatesocialpub(id: Int, newvoted_social_pub: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removesocialpub(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removesocialpub(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //TREASURER
    override suspend fun addtreasurer(userId: String, voted_treasurerValue: String): Treasurer? = dbQuery {
        val insertStatement = Treasurers.insert {
            it[user] = userId
            it[voted_treasurer] = voted_treasurerValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toTreasurer(result)
        } else {
            null
        }
    }

    override suspend fun treasurer(id: Int): Treasurer? = dbQuery {
        Treasurers.select {
            (Treasurers.id eq id)
        }.mapNotNull { toTreasurer(it) }
            .singleOrNull()
    }

    override suspend fun treasurer(voted_treasurer: String): List<Treasurer> = dbQuery {
        Treasurers.select {
            (Treasurers.voted_treasurer eq voted_treasurer)
        }.map { toTreasurer(it) }
    }

    override suspend fun treasurer(): List<Treasurer> = dbQuery {
        Treasurers.selectAll().map { toTreasurer(it) }
    }

    override suspend fun updatetreasurer(id: Int, newvoted_treasurer: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removetreasurer(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removetreasurer(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //VICE PRESIDENT
    override suspend fun addvicepresident(userId: String, voted_vice_presidentValue: String): VicePresident? = dbQuery {
        val insertStatement = VicePresidents.insert {
            it[user] = userId
            it[voted_vice_president] = voted_vice_presidentValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toVicePresident(result)
        } else {
            null
        }
    }

    override suspend fun vicepresident(id: Int): VicePresident? = dbQuery {
        VicePresidents.select {
            (VicePresidents.id eq id)
        }.mapNotNull { toVicePresident(it) }
            .singleOrNull()
    }

    override suspend fun vicepresident(voted_vice_president: String): List<VicePresident> = dbQuery {
        VicePresidents.select {
            (VicePresidents.voted_vice_president eq voted_vice_president)
        }.map { toVicePresident(it) }
    }
    override suspend fun vicepresident(): List<VicePresident> = dbQuery {
        VicePresidents.selectAll().map { toVicePresident(it) }
    }

    override suspend fun updatevicepresident(id: Int, newvoted_vice_president: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removevicepresident(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removevicepresident(id: String): Boolean {
        TODO("Not yet implemented")
    }

    //RESULT

    override suspend fun addresult(
        nameValue: String,
        officeValue: String,
        votes_gottenValue: Int,
        total_votersValue: Int,
        total_non_votersValue: Int
    ): Result?  = dbQuery {
        val insertStatement = Results.insert {
            it[name] = nameValue
            it[office] = officeValue
            it[votes_gotten] = votes_gottenValue
            it[total_voters] = total_votersValue
            it[total_non_voters] = total_non_votersValue
        }
        val result = insertStatement.resultedValues?.get(0)
        if (result != null) {
            toResult(result)
        } else {
            null
        }
    }

    override suspend fun result(id: Int): Result? = dbQuery {
        Results.select {
            (Results.id eq id)
        }.mapNotNull { toResult(it) }
            .singleOrNull()
    }

    override suspend fun result(office: String): List<Result> = dbQuery {
        Results.select {
            (Results.office eq office)
        }.map { toResult(it) }
    }

    override suspend fun results(): List<Result> = dbQuery {
        Results.selectAll().map { toResult(it) }
    }


    override suspend fun updateresult(
        id: Int,
        newname: String,
        newoffice: String,
        newvotes_gotten: String,
        newtotal_voters: String,
        newtotal_non_voters: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun removeresult(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun removeresult(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun clear(): Int = dbQuery{
        Users.deleteAll()
        AssistFinSecs.deleteAll()
        Completeds.deleteAll()
        DiasporalAfricas.deleteAll()
        DiasporalAmericas.deleteAll()
        DiasporalAsias.deleteAll()
        DiasporalEurops.deleteAll()
        DiasporalUks.deleteAll()
        FinancialSecs.deleteAll()
        GeneralSecs.deleteAll()
        Presidents.deleteAll()
        Provosts.deleteAll()
        SocialPubs.deleteAll()
        Treasurers.deleteAll()
        VicePresidents.deleteAll()
        Results.deleteAll()

    }

    private fun toUser(row: ResultRow): User =
        User(
            userId = row[Users.id],
            firstname = row[Users.firstname],
            lastname = row[Users.lastname],
            address = row[Users.address],
            role = row[Users.role],
            password = row[Users.password],
            passwordHash = row[Users.passwordHash]

        )

    private fun toAssistFinSec(row: ResultRow): AssistFinSec =
        AssistFinSec(
            id = row[AssistFinSecs.id].value,
            userId = row[AssistFinSecs.user],
            voted_assist_fin_sec = row[AssistFinSecs.voted_assist_fin_sec]
        )

    private fun toDiasporalAfrica(row: ResultRow): DiasporalAfrica =
        DiasporalAfrica(
            id = row[DiasporalAfricas.id].value,
            userId = row[DiasporalAfricas.user],
            voted_diasporal_africa = row[DiasporalAfricas.voted_diasporal_africa]
        )

    private fun toDiasporalAmerica(row: ResultRow): DiasporalAmerica =
        DiasporalAmerica(
            id = row[DiasporalAmericas.id].value,
            userId = row[DiasporalAmericas.user],
            voted_diasporal_america = row[DiasporalAmericas.voted_diasporal_america]
        )

    private fun toDiasporalAsia(row: ResultRow): DiasporalAsia =
        DiasporalAsia(
            id = row[DiasporalAsias.id].value,
            userId = row[DiasporalAsias.user],
            voted_diasporal_asia = row[DiasporalAsias.voted_diasporal_asia]
        )

    private fun toDiasporalEurop(row: ResultRow): DiasporalEurop =
        DiasporalEurop(
            id = row[DiasporalEurops.id].value,
            userId = row[DiasporalEurops.user],
            voted_diasporal_europ = row[DiasporalEurops.voted_diasporal_europ]
        )

    private fun toDiasporalUK(row: ResultRow): DiasporalUK =
        DiasporalUK(
            id = row[DiasporalUks.id].value,
            userId = row[DiasporalUks.user],
            voted_diasporal_uk = row[DiasporalUks.voted_diasporal_uk]
        )

    private fun toFinancialSec(row: ResultRow): FinancialSec =
        FinancialSec(
            id = row[FinancialSecs.id].value,
            userId = row[FinancialSecs.user],
            voted_financial_sec = row[FinancialSecs.voted_financial_sec]
        )

    private fun toGeneralSec(row: ResultRow): GeneralSec =
        GeneralSec(
            id = row[GeneralSecs.id].value,
            userId = row[GeneralSecs.user],
            voted_general_sec = row[GeneralSecs.voted_general_sec]
        )

    private fun toPresident(row: ResultRow): President =
        President(
            id = row[Presidents.id].value,
            userId = row[Presidents.user],
            voted_president = row[Presidents.voted_president]
        )

    private fun toProvost(row: ResultRow): Provost =
        Provost(
            id = row[Provosts.id].value,
            userId = row[Provosts.user],
            voted_provost = row[Provosts.voted_provost]
        )

    private fun toSocialPub(row: ResultRow): SocialPub =
        SocialPub(
            id = row[SocialPubs.id].value,
            userId = row[SocialPubs.user],
            voted_social_pub = row[SocialPubs.voted_social_pub]
        )

    private fun toTreasurer(row: ResultRow): Treasurer =
        Treasurer(
            id = row[Treasurers.id].value,
            userId = row[Treasurers.user],
            voted_treasurer = row[Treasurers.voted_treasurer]
        )

    private fun toVicePresident(row: ResultRow): VicePresident =
        VicePresident(
            id = row[VicePresidents.id].value,
            userId = row[VicePresidents.user],
            voted_vice_president = row[VicePresidents.voted_vice_president]
        )

    private fun toResult(row: ResultRow): Result =
        Result(
            id = row[Results.id].value,
            name = row[Results.name],
            office = row[Results.office],
            votes_gotten = row[Results.votes_gotten],
            total_voters = row[Results.total_voters],
            total_non_voters = row[Results.total_non_voters]
        )

    private fun toCompleted(row: ResultRow): Completed =
        Completed(
            id = row[Completeds.id].value,
            userId = row[Completeds.user],
            voted = row[Completeds.voted]
        )
}