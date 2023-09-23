package com.example.menuexc

import android.content.Context
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import java.lang.Exception

class Custom {

    fun showMenu(context: Context, view: View) {
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu)

        pop.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.edit -> {
                    Toast.makeText(context, "Clicked Edit", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.delet -> {
                    Toast.makeText(context, "Clicked Delete", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.share -> {
                    Toast.makeText(context, "Clicked Share", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }

        try {
            val fieldMpopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMpopup.isAccessible = true
            val mPopup = fieldMpopup.get(pop)

            val popupClass = Class.forName("android.widget.PopupMenu")
            val setForceShowIcon = popupClass.getDeclaredField("mSetForceShowIcon")
            setForceShowIcon.isAccessible = true
            setForceShowIcon.set(mPopup, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        pop.show()
    }
}
