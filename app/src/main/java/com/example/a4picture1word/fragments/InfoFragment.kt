package com.example.a4picture1word.fragments

import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {
    override fun onViewCreated() {
        binding.btnBackSettings.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }
    }
}