package com.example.learnrecyclerview2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CardAdapter()
        val WordData = arrayListOf(
            Card("A",24),
            Card("B",100),
            Card("fbfd",50),
            Card("rtgb",24),
            Card("bf",24)
        )
        adapter.data = WordData
        view.findViewById<RecyclerView>(R.id.card_recyclerview).adapter = adapter




    }
}

data class Card(
    var word:String,
    var progress:Int)

class CardAdapter : RecyclerView.Adapter<CardViewHolder>(){
    var data = ArrayList<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = data[position]
        holder.word.text = item.word
        holder.progress.progress = item.progress
    }

    override fun getItemCount() = data.size


}

class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val word: TextView = itemView.findViewById(R.id.word)
    val progress: ProgressBar = itemView.findViewById(R.id.progressBar)
}




