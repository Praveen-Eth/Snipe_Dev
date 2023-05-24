package com.augx_universe.snipedev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.entities.FeedDataClass
import com.augx_universe.snipedev.entities.PollItems
import java.util.zip.Inflater

class FeedAdapter(private val items: List<FeedDataClass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        val POLL_ITEM_VIEW_TYPE = 0
        val CODE_SNIPPET_ITEM_VIEW_TYPE = 1
        val CODE_COMPETETITON_ITEM_VIEW_TYPE = 2

    }

    inner class PoleViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleView: TextView = view.findViewById(R.id.poll_title)
         val poleOption1: CardView = view.findViewById(R.id.option1)
        val poleOption2: CardView = view.findViewById(R.id.option2)
        val poleOption3: CardView = view.findViewById(R.id.option3)
        val poleOptionOther: CardView = view.findViewById(R.id.otherOption)

        val option1TextView: TextView = view.findViewById(R.id.tv_option1)

        val option2TextView: TextView = view.findViewById(R.id.tv_option2)
        val option3TextView: TextView = view.findViewById(R.id.tv_option3)
        val optionOtherTextView: TextView = view.findViewById(R.id.tv_option_other)
        var numberOfPoleOptions: Int = 0

        fun bind(pollItems: PollItems){
            titleView.text = pollItems.question
            numberOfPoleOptions = pollItems.options.size
            option1TextView.text = " ${pollItems.options[0] } % ${pollItems.numberOfVotePerOption[0]}"
            when (numberOfPoleOptions){
                1 -> {

                    poleOption2.visibility = View.GONE
                    poleOption3.visibility = View.GONE

                }
                2 -> {
                    poleOption3.visibility = View.GONE
                }
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            POLL_ITEM_VIEW_TYPE -> LayoutInflater.from(parent.context).inflate(R.layout.poll_item_layout,parent,false)

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}
