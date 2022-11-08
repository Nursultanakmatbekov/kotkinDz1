package com.example.kotkindz1

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotkindz1.Fragment.RecyclerFragment
import com.google.android.material.card.MaterialCardView
import java.lang.String
import kotlin.Int

class OnePieceAdapter(onItemClickListener: RecyclerFragment) :
    RecyclerView.Adapter<OnePieceAdapter.CharacterViewHolder>(), View.OnClickListener {

    private var listCharacters: List<OnePieceModel>? = null
    private val onItemClickListener: OnItemClickListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listCharacters: List<OnePieceModel>?) {
        this.listCharacters = listCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(listCharacters!![position])    }

    override fun getItemCount(): Int {
        return listCharacters!!.size
    }

    override fun onClick(view: View) {
        onItemClickListener!!.onClick((view.tag as OnePieceModel)!!)
    }

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var mainContainer: MaterialCardView? = null
        private var ivImage: ImageView? = null
        private var tvName: TextView? = null
        private var tvAge: TextView? = null

        fun onBind(character: OnePieceModel) {
            Glide.with(ivImage!!.context).load(character.getImageUrl()).into(ivImage!!)
            tvName!!.text = character.getName()
            tvAge!!.text = String.valueOf(character.getAge())
            mainContainer!!.setCardBackgroundColor(Color.parseColor(character.getColor()))
            itemView.tag = character
        }
    }
}


