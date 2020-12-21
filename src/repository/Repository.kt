package com.voting_system.repository

import com.voting_system.model.*

interface Repository {

    //USER
    suspend fun user(userId: String, hash:String? = null): User?
    suspend fun users(): List<User>
    suspend fun removeuser(id:String): Boolean
    suspend fun createUser(user: User)
    suspend fun updateuser(userId: String, newFirstname: String, newLastname: String, newAddress:String,
                           newRole:String, newPassword: String, newPasswordHash: String)
    //Completed
    suspend fun addcompleted(userId: String, votedValue: String): Completed?
    suspend fun completed(userId: String): Completed?

    //ASSIST FINANCIAL SEC
    suspend fun addassistfinsec(userId: String, voted_assist_fin_secValue: String): AssistFinSec?
    suspend fun assistfinsec(id:Int): AssistFinSec?
    suspend fun assistfinsec(voted_assist_fin_sec:String): List<AssistFinSec>
    suspend fun assistfinsec(): List<AssistFinSec>
    suspend fun updateassistfinsec(id:Int, newvoted_assist_fin_sec: String )
    suspend fun removeassistfinsec(id:Int):Boolean
    suspend fun removeassistfinsec(id:String):Boolean

    //DIASPORAL AFRICA
    suspend fun adddiasporalafrica(userId: String, voted_diasporal_africaValue: String): DiasporalAfrica?
    suspend fun diasporalafrica(id:Int): DiasporalAfrica?
    suspend fun  diasporalafrica(voted_diasporal_africa: String): List<DiasporalAfrica>
    suspend fun diasporalafrica(): List<DiasporalAfrica>
    suspend fun updatediasporalafrica(id:Int, newvoted_diasporal_africa: String )
    suspend fun removediasporalafrica(id:Int):Boolean
    suspend fun removediasporalafrica(id:String):Boolean

    //DIASPORAL AMERICA
    suspend fun adddiasporalamerica(userId: String, voted_diasporal_americaValue: String): DiasporalAmerica?
    suspend fun diasporalamerica(id:Int): DiasporalAmerica?
    suspend fun  diasporalamerica(voted_diasporal_america: String): List<DiasporalAmerica>
    suspend fun diasporalamerica(): List<DiasporalAmerica>
    suspend fun updatediasporalamerica(id:Int, newvoted_diasporal_america: String )
    suspend fun removediasporalamerica(id:Int):Boolean
    suspend fun removediasporalamerica(id:String):Boolean


    //DIASPORAL ASIA
    suspend fun adddiasporalasia(userId: String, voted_diasporal_asiaValue: String): DiasporalAsia?
    suspend fun diasporalasia(id:Int): DiasporalAsia?
    suspend fun  diasporalasia(voted_diasporal_asia: String): List<DiasporalAsia>
    suspend fun diasporalasia(): List<DiasporalAsia>
    suspend fun updatediasporalasia(id:Int, newvoted_diasporal_asia: String )
    suspend fun removediasporalasia(id:Int):Boolean
    suspend fun removediasporalasia(id:String):Boolean

    //DIASPORAL EUROP
    suspend fun adddiasporaleurop(userId: String, voted_diasporal_europValue: String): DiasporalEurop?
    suspend fun diasporaleurop(id:Int): DiasporalEurop?
    suspend fun  diasporaleurop(voted_diasporal_europ: String): List<DiasporalEurop>
    suspend fun diasporaleurop(): List<DiasporalEurop>
    suspend fun updatediasporaleurop(id:Int, newvoted_diasporal_europ: String )
    suspend fun removediasporaleurop(id:Int):Boolean
    suspend fun removediasporaleurop(id:String):Boolean

    //DIASPORAL UK
    suspend fun adddiasporaluk(userId: String, voted_diasporal_ukValue: String): DiasporalUK?
    suspend fun diasporaluk(id:Int): DiasporalUK?
    suspend fun  diasporaluk(voted_diasporal_uk: String): List<DiasporalUK>
    suspend fun diasporaluk(): List<DiasporalUK>
    suspend fun updatediasporaluk(id:Int, newvoted_diasporal_uk: String)
    suspend fun removediasporaluk(id:Int):Boolean
    suspend fun removediasporaluk(id:String):Boolean

    //FINANCIAL SECRETARY
    suspend fun addfinancialsec(userId: String, voted_financial_secValue: String): FinancialSec?
    suspend fun financialsec(id:Int): FinancialSec?
    suspend fun  financialsec(voted_financial_sec: String): List<FinancialSec>
    suspend fun financialsec(): List<FinancialSec>
    suspend fun updatefinancialsec(id:Int, newvoted_financial_sec: String)
    suspend fun removefinancialsec(id:Int):Boolean
    suspend fun removefinancialsec(id:String):Boolean

    //GENERAL SECRETARY
    suspend fun addgeneralsec(userId: String, voted_general_secValue: String): GeneralSec?
    suspend fun generalsec(id:Int): GeneralSec?
    suspend fun  generalsec(voted_general_sec: String): List<GeneralSec>
    suspend fun generalsec(): List<GeneralSec>
    suspend fun updategeneralsec(id:Int, newvoted_general_sec: String)
    suspend fun removegeneralsec(id:Int):Boolean
    suspend fun removegeneralsec(id:String):Boolean

    //PRESIDENT SECRETARY
    suspend fun addpresident(userId: String, voted_presidentValue: String): President?
    suspend fun president(id:Int): President?
    suspend fun president(voted_president: String): List<President>
    suspend fun president(): List<President>
    suspend fun updatepresident(id:Int, newvoted_president: String)
    suspend fun removepresident(id:Int):Boolean
    suspend fun removepresident(id:String):Boolean

    //PROVOST
    suspend fun addprovost(userId: String, voted_provostValue: String): Provost?
    suspend fun provost(id:Int): Provost?
    suspend fun provost(voted_provost: String): List<Provost>
    suspend fun provost(): List<Provost>
    suspend fun updateprovost(id:Int, newvoted_provost: String)
    suspend fun removeprovost(id:Int):Boolean
    suspend fun removeprovost(id:String):Boolean

    //SOCIAL PUBLIC OFFICER
    suspend fun addsocialpub(userId: String, voted_social_pubValue: String): SocialPub?
    suspend fun socialpub(id:Int): SocialPub?
    suspend fun socialpub(voted_social_pub: String): List<SocialPub>
    suspend fun socialpub(): List<SocialPub>
    suspend fun updatesocialpub(id:Int, newvoted_social_pub: String)
    suspend fun removesocialpub(id:Int):Boolean
    suspend fun removesocialpub(id:String):Boolean

    //TREASURER
    suspend fun addtreasurer(userId: String, voted_treasurerValue: String): Treasurer?
    suspend fun treasurer(id:Int): Treasurer?
    suspend fun treasurer(voted_treasurer: String): List<Treasurer>
    suspend fun treasurer(): List<Treasurer>
    suspend fun updatetreasurer(id:Int, newvoted_treasurer: String)
    suspend fun removetreasurer(id:Int):Boolean
    suspend fun removetreasurer(id:String):Boolean

    //VICE PRESIDENT
    suspend fun addvicepresident(userId: String, voted_vice_presidentValue: String): VicePresident?
    suspend fun vicepresident(id:Int): VicePresident?
    suspend fun vicepresident(voted_vice_president: String): List<VicePresident>
    suspend fun vicepresident(): List<VicePresident>
    suspend fun updatevicepresident(id:Int, newvoted_vice_president: String)
    suspend fun removevicepresident(id:Int):Boolean
    suspend fun removevicepresident(id:String):Boolean

    //RESULTS
    suspend fun addresult(nameValue: String, officeValue: String, votes_gottenValue: Int, total_votersValue: Int,
                          total_non_votersValue: Int): Result?
    suspend fun result(id:Int): Result?
    suspend fun result(office:String): List<Result>
    suspend fun results(): List<Result>
    suspend fun updateresult(id:Int, newname: String, newoffice: String, newvotes_gotten: String, newtotal_voters: String, newtotal_non_voters: String)
    suspend fun removeresult(id:Int):Boolean
    suspend fun removeresult(id:String):Boolean

    suspend fun clear():Int
}