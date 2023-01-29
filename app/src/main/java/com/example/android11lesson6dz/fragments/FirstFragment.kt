package com.example.android11lesson6dz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android11lesson6dz.TextAdapter
import com.example.android11lesson6dz.`interface`.OnItemTextListener
import com.example.android11lesson6dz.data.TextModel
import com.example.android11lesson6dz.repository.TextRepository
import com.example.android1lesson6dz.R
import com.example.android1lesson6dz.databinding.FragmentFirstBinding
import org.w3c.dom.Text

class FirstFragment : Fragment(), OnItemTextListener{
    private var binding: FragmentFirstBinding? = null
    private val textList = ArrayList<TextModel>()
    private val adapter = TextAdapter(textList, this)
    private var repo = TextRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getData()
    }

    private fun initialize() {
        binding?.recycler?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        textList.addAll(repo.getListOfText())
        binding?.recycler?.adapter = adapter
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(TextModel(text.toString()))
        }
    }


    override fun onClick(model: TextModel) {
        val bundle = Bundle()
        bundle.putString("cat", model.text)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SecondFragment::class.java, bundle)
            .addToBackStack("NamesFragment")
            .commit()


    }

    override fun onLongClick(model: TextModel): Boolean {
        TODO("Not yet implemented")
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}
