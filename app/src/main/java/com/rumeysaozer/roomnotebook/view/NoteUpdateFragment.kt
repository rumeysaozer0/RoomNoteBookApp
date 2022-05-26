package com.rumeysaozer.roomnotebook.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rumeysaozer.roomnotebook.R
import com.rumeysaozer.roomnotebook.databinding.FragmentNoteUpdateBinding
import com.rumeysaozer.roomnotebook.model.Note
import com.rumeysaozer.roomnotebook.viewmodel.NoteListViewModel


class NoteUpdateFragment : Fragment() {
    private var _binding: FragmentNoteUpdateBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : NoteListViewModel
    private val args by navArgs<NoteUpdateFragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteUpdateBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoteListViewModel::class.java)
        binding.ubaslK.setText(args.note.baslik)
        binding.utext.setText(args.note.note)
        binding.ukaydet.setOnClickListener {
            val updateNote = Note(args.note.id, binding.ubaslK.text.toString(), binding.utext.text.toString())
            viewModel.updateNote(updateNote)
            findNavController().navigate(R.id.action_noteUpdateFragment_to_noteListFragment2)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete){
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("${args.note.baslik} will delete")
            builder.setMessage("are you sure you want to delete?")
            builder.setPositiveButton("yes"){_, _->
                viewModel.deleteNote(args.note)
                findNavController().navigate(R.id.action_noteUpdateFragment_to_noteListFragment2)
            }
            builder.setNegativeButton("no"){_,_->}
            builder.create().show()
        }
        return super.onOptionsItemSelected(item)


    }


}