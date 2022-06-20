package com.example.a4picture1word.controller

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class extensions private constructor(
    @IdRes private val container: Int,
    private val fragmentManager: FragmentManager
) {

    fun startMainFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.commit()
    }

    fun replaceFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.addToBackStack(fr.toString())
        transaction.commit()
    }

    fun addFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.addToBackStack(fr.toString())
        transaction.commit()
    }

    fun back() {
        fragmentManager.popBackStack()
    }

    fun getLastFragment(): Fragment {
        return fragmentManager.fragments[fragmentManager.fragments.size - 1]
    }

    companion object {
        var controller: extensions? = null
            private set

        fun init(@IdRes contentId: Int, fm: FragmentManager) {
            controller = extensions(contentId, fm)
        }
    }
}