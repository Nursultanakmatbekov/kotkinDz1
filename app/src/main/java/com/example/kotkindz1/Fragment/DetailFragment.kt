package com.example.kotkindz1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kotkindz1.OnePieceModel
import com.example.kotkindz1.R
import java.lang.String

class DetailFragment : Fragment() {

    private var ivFullScreen: ImageView? = null
    private var tvName: TextView? = null
    private var tvAge: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivFullScreen = view.findViewById(R.id.iv_fullscreen)
        tvName = view.findViewById(R.id.tv_name)
        tvAge = view.findViewById(R.id.tv_age)
        getData()
    }

    private fun getData() {
        val arguments = arguments
        if (arguments != null) {
            val model = arguments.getSerializable("name") as OnePieceModel?
            Glide.with(ivFullScreen!!.context).load(model!!.getImageUrl()).into(ivFullScreen!!)
            tvName!!.text = model.getName()
            tvAge!!.text = String.valueOf(model.getAge())
        }
    }
}