package com.mustafo.a4picture1word.fragments

import com.mustafo.a4picture1word.controller.extensions
import com.mustafo.a4picture1word.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {
    override fun onViewCreated() {
        binding.btnBackSettings.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }
    }
}