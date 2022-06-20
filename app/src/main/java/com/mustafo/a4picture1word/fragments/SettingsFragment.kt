package com.mustafo.a4picture1word.fragments

import com.mustafo.a4picture1word.controller.extensions
import com.mustafo.a4picture1word.databinding.FragmentSettingsBinding
import com.mustafo.a4picture1word.shared.Shared


class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    private val shared by lazy {
        Shared(requireContext())
    }

    override fun onViewCreated() {
        binding.btnBackSettings.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }

        binding.mute.isChecked = shared.getSwitch()

        var d = false

        binding.mute.setOnClickListener {
            if (!d){
                d = true
                binding.mute.isChecked = d
                shared.setSwitch(d)
            }else{
                d = false
                shared.setSwitch(d)
                binding.mute.isChecked = d
            }
        }
    }
}