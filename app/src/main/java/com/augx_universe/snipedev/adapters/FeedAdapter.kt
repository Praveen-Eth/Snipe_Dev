package com.augx_universe.snipedev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.entities.CodeCompetitionItem
import com.augx_universe.snipedev.entities.CodeSnippetItem
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
                3 -> { }
               else -> option1TextView.text = "poll option error"
            }

            //TODO("need to write a function to calculate the percent from its entity")
            poleOption1.onPercentBasedWidth(poleOption1,0.2f)
            poleOption2.onPercentBasedWidth(poleOption2,0.8f)
           // poleOption3.onPercentBasedWidth(poleOption3,0.4f)
            poleOptionOther.onPercentBasedWidth(poleOptionOther,1.2f)

            //TODO("need to write the Impl of textView Percentage on below")


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            POLL_ITEM_VIEW_TYPE -> {
                val pollView = LayoutInflater.from(parent.context).inflate(R.layout.poll_item_layout,parent,false)
                return PoleViewHolder(pollView)
            }

            else -> throw java.lang.IllegalArgumentException("Invalid View Type in Line 77")
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        return when(holder.itemViewType){
            POLL_ITEM_VIEW_TYPE -> {
                val pollVH = holder as PoleViewHolder
                pollVH.bind(item as PollItems)
            }

            else -> {throw IllegalArgumentException("error on onBindVH")}
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when(item) {
            is PollItems -> POLL_ITEM_VIEW_TYPE
            is CodeCompetitionItem -> CODE_COMPETETITON_ITEM_VIEW_TYPE
            is CodeSnippetItem -> CODE_SNIPPET_ITEM_VIEW_TYPE
            else -> throw java.lang.IllegalArgumentException("invalid Item View")
        }
    }

}

fun View.onPercentBasedWidth(view:View,percent: Float):View{
    var renderedViewWidth = view.width

    var desiredWidth = (renderedViewWidth * percent).toInt()
    System.out.println(desiredWidth)
    val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
    layoutParams.width = desiredWidth
    view.layoutParams = layoutParams
    return view
}
