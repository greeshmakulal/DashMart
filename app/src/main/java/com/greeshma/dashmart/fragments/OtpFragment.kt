package com.greeshma.dashmart.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greeshma.dashmart.R
import com.greeshma.dashmart.databinding.FragmentOtpBinding

class OtpFragment : Fragment() {
    var binding: FragmentOtpBinding? = null
    var phoneNumber:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\
        binding = FragmentOtpBinding.inflate(inflater)
        arguments?.apply {
            phoneNumber = getString("phoneNumber","")
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }
    @SuppressLint("SetTextI18n")
    fun initViews()
    {
        binding?.tvNumber?.text ="+91$phoneNumber"

        val editTexts = arrayOf(binding?.et1,binding?.et2,binding?.et3,binding?.et4,binding?.et5,binding?.et6)
        // Loop through all EditText fields for OTP input
        for(i in editTexts.indices) {
            // Add text change listener to each EditText
            editTexts[i]?.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // Not needed for this implementation
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Not needed for this implementation
                }

                override fun afterTextChanged(s: Editable?) {
                    when(s?.length) {
                        // When a digit is entered, move focus to next field if available
                        1 -> {
                            if (i < editTexts.size-1) {
                                editTexts[i+1]?.requestFocus()
                            }
                        }
                        // When digit is deleted, move focus back to previous field if available
                        0 -> {
                            if(i > 0) {
                                editTexts[i-1]?.requestFocus()
                            }
                        }
                    }
                }
            })
        }

        binding?.ivBack?.setOnClickListener {
            findNavController().navigate(R.id.action_otpFragment_to_signInFragment)
            Log.d("OtpFragment", "Navigated back to sign in fragment using popBackStack()")
        }
    }
}