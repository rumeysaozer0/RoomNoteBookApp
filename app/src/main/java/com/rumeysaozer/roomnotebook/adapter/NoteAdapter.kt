package com.rumeysaozer.roomnotebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.roomnotebook.R
import com.rumeysaozer.roomnotebook.model.Note
import com.rumeysaozer.roomnotebook.view.NoteListFragmentDirections

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var noteList = emptyList<Note>()
    class NoteViewHolder(var view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
      holder.view.findViewById<TextView>(R.id.a).text = noteList[position].baslik

        holder.itemView.setOnClickListener {
            val action = NoteListFragmentDirections.actionNoteListFragment2ToNoteUpdateFragment(noteList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return noteList.size
    }
    fun setData(notelist: List<Note>){
        this.noteList = notelist
        notifyDataSetChanged()
    }
}