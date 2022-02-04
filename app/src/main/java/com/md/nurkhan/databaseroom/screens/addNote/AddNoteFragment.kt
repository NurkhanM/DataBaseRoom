package com.md.nurkhan.databaseroom.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.md.nurkhan.databaseroom.APP
import com.md.nurkhan.databaseroom.R
import com.md.nurkhan.databaseroom.databinding.FragmentAddNoteBinding
import com.md.nurkhan.databaseroom.databinding.FragmentStartBinding
import com.md.nurkhan.databaseroom.models.NoteModel
import com.md.nurkhan.databaseroom.screens.start.StartViewModel


class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.edtAddTitle.text.toString()
            val description = binding.edtDescTitle.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }


    }

}