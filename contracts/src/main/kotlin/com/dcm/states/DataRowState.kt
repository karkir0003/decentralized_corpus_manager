package com.dcm.states

import com.dcm.contract.DataRowContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import java.util.*

/*********
@Dev: The DataRow State object represents the a comma delimited data string. Each
 comma separates a new attribute of a machine learning model. You can think of them
 as columns in a pandas dataframe.
 @param dataRow The data string.
 @param
*********/
@BelongsToContract(DataRowContract::class)
data class DataRowState(val dataRow: String,
                        val parentModel : ModelState,
                        override val participants: List<AbstractParty> = listOf(),
                        override val linearId: UniqueIdentifier = UniqueIdentifier()) : LinearState{
 fun updateDataRow(newDataRow: String) = copy(dataRow =  newDataRow)
 fun changeParentModel(newParentModel : ModelState) = copy(parentModel = newParentModel)
}