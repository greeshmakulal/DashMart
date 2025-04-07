package com.greeshma.dashmart.fragments

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.greeshma.dashmart.R
import com.greeshma.dashmart.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    var binding: FragmentSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater)
        setStatusBarColor()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
        },2000)

        return binding?.root
    }

    private fun setStatusBarColor()
    {
        activity?.window?.apply {
            val statusBarColors = ContextCompat.getColor(requireContext(), R.color.yellow)
            statusBarColor = statusBarColors
            navigationBarColor = statusBarColors
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
            {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Light icons for navigation bar (only on Android 8.0+)
                decorView.systemUiVisibility = decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
    }

}