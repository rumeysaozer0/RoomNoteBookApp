package com.rumeysaozer.roomnotebook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.roomnotebook.R
import com.rumeysaozer.roomnotebook.databinding.FragmentNoteAddBinding
import com.rumeysaozer.roomnotebook.model.Note
import com.rumeysaozer.roomnotebook.viewmodel.NoteListViewModel


class NoteAddFragment : Fragment() {
    private var _binding: FragmentNoteAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NoteListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteAddBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoteListViewModel::class.java)
        binding.kaydet.setOnClickListener {
            val note = Note(0,binding.baslK.text.toString(),binding.text.text.toString())
            viewModel.addNote(note)
            findNavController().navigate(R.id.action_noteAddFragment2_to_noteListFragment2)
        }
    }


}