package com.ilovefish.caviarapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilovefish.caviarmvvm.ext.util.logd
import com.ilovefish.caviarapp.databinding.FragmentDongFangHangKongMotionlayoutBinding

class FragmentDongFangHangKongMotionlayout : Fragment() {


    companion object {
        fun newInstance() = FragmentDongFangHangKongMotionlayout()
    }

    private var _binding: FragmentDongFangHangKongMotionlayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel2::class.java)

        _binding = FragmentDongFangHangKongMotionlayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome

        binding.mlLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                ("startId:" + startId + ",endId:" + endId + ",progress:" + progress).logd()
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        textView.setOnClickListener {
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}