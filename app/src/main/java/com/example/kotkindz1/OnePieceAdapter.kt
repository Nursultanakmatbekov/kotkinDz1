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
import com.google.android.material.card.MaterialCardView
import java.lang.String
import kotlin.Int


class OnePieceAdapter(onItemClickListener: RecyclerFragment) :
    RecyclerView.Adapter<OnePieceAdapter.CharacterViewHolder>(), View.OnClickListener {
    private var listCharacters: List<OnePieceModel>? = null
    private val onItemClickListener: OnItemClickListener

    init {
        this.onItemClickListener = onItemClickListener
    }

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
        holder.onBind(listCharacters!![position])
    }

    override fun getItemCount(): Int {
        return listCharacters!!.size
    }

    override fun onClick(view: View) {
        onItemClickListener.onClick((view.tag as OnePieceModel))
    }

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mainContainer: MaterialCardView
        private val ivImage: ImageView
        private val tvName: TextView
        private val tvAge: TextView

        init {
            ivImage = view.findViewById(R.id.iv_image)
            tvName = view.findViewById(R.id.tv_name)
            tvAge = view.findViewById(R.id.tv_age)
            mainContainer = view.findViewById(R.id.main_container)
        }

        fun onBind(character: OnePieceModel) {
            Glide.with(ivImage.context).load(character.image).into(ivImage)
            tvName.text = character.name
            tvAge.setText(String.valueOf(character.age))
            mainContainer.setCardBackgroundColor(Color.parseColor(character.color))
            itemView.tag = character
        }
    }
}


