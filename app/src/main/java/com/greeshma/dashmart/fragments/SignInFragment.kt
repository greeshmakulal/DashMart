package com.greeshma.dashmart.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greeshma.dashmart.R
import com.greeshma.dashmart.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    var binding: FragmentSignInBinding? = null
    var input:String= ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater)
        setStatusBarColor()
        return binding?.root
    }

    private fun setStatusBarColor()
    {
        activity?.window?.apply {
            val statusBarColors = ContextCompat.getColor(requireContext(), R.color.yellow)
            statusBarColor = statusBarColors
            navigationBarColor = ContextCompat.getColor(requireContext(), R.color.white)
//            navigationBarColor = statusBarColors
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
            {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

        }
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }
    private fun initViews()
    {
        binding?.signIn?.setOnClickListener {
            if(binding?.textInput?.text?.isNotEmpty()==true)
            {
                if(binding?.textInput?.text?.length!! <= 10)
                {
                    input = binding?.textInput?.text.toString()
                    val bundle = Bundle()
                    bundle.putString("phoneNumber",input)
                    findNavController().navigate(R.id.action_signInFragment_to_otpFragment,bundle)
                }
            }
        }
    }
}