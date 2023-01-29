package com.example.android11lesson6dz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android11lesson6dz.data.TextModel
import com.example.android1lesson6dz.R
import com.example.android1lesson6dz.databinding.FragmentFirstBinding
import com.example.android1lesson6dz.databinding.FragmentSecondBinding
import com.example.android1lesson6dz.databinding.ItmeTextBinding


class SecondFragment : Fragment() {
    private  var binding: FragmentSecondBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat")
            binding?.etText?.setText(text)
        }
    }

    private fun onClickListener() {
        binding?.btnVozvrat?.setOnClickListener(View.OnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.etText?.text.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, FirstFragment::class.java, bundle2)
                .addToBackStack("SecondFragment").commit()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}