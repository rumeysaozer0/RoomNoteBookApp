package com.rumeysaozer.roomnotebook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.roomnotebook.adapter.NoteAdapter
import com.rumeysaozer.roomnotebook.databinding.FragmentNoteListBinding
import com.rumeysaozer.roomnotebook.viewmodel.NoteListViewModel


class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NoteListViewModel
    private lateinit var adapter : NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoteListViewModel::class.java)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        observeLiveData()
        binding.floatingActionButton.setOnClickListener {
            val action = NoteListFragmentDirections.actionNoteListFragment2ToNoteAddFragment2()
            findNavController().navigate(action)
        }
    }
   private fun observeLiveData(){
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { note->
            note?.let{
                adapter.setData(it)
            }

        })
    }

}