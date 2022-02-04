package com.md.nurkhan.databaseroom.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.md.nurkhan.databaseroom.APP
import com.md.nurkhan.databaseroom.R
import com.md.nurkhan.databaseroom.databinding.FragmentDetailBinding
import com.md.nurkhan.databaseroom.databinding.FragmentStartBinding
import com.md.nurkhan.databaseroom.models.NoteModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var cottentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDetailBinding.inflate(layoutInflater, container, false)
        cottentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.txtTitleDetail.text = cottentNote.title
        binding.txtDescDetail.text = cottentNote.description

        binding.btnDelete.setOnClickListener {
            viewModel.delete(cottentNote) {}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }


        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

        }
    }

}