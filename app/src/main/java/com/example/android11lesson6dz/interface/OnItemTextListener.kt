package com.example.android11lesson6dz.`interface`

import android.provider.ContactsContract.DeletedContacts
import com.example.android11lesson6dz.data.TextModel
import com.google.android.material.chip.ChipDrawable.Delegate

interface OnItemTextListener {
    fun onClick(model : TextModel )
    fun onLongClick (model : TextModel ): Boolean
}