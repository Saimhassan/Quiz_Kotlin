package com.example.quizkotlin.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizkotlin.Interface.IOnRecyclerViewItemClickListener
import com.example.quizkotlin.Model.Category
import com.example.quizkotlin.R

class CategoryAdapter(internal var context: Context,
                      internal var categoryList: List<Category>):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        internal var txt_category_name : TextView
        internal var card_category:CardView
        internal lateinit var iOnRecyclerViewItemClickListener:IOnRecyclerViewItemClickListener
        fun setiOnRecyclerViewItemClickListener(iOnRecyclerViewItemClickListener: IOnRecyclerViewItemClickListener){
            this.iOnRecyclerViewItemClickListener = iOnRecyclerViewItemClickListener
        }

        init {
            txt_category_name = itemView.findViewById(R.id.txt_category_name) as TextView
            card_category = itemView.findViewById(R.id.card_category) as CardView

            itemView.setOnClickListener(this)

        }


        override fun onClick(view: View?) {
            iOnRecyclerViewItemClickListener.onClick(view,adapterPosition)
        }

    }

}