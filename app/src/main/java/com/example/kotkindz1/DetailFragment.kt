package com.example.kotkindz1
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    var model: OnePieceModel? = null
    private var ivFullScreen: ImageView? = null
    private var tvName: TextView? = null
    private var tvAge: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivFullScreen = view.findViewById(R.id.iv_fullscreen)
        tvName = view.findViewById(R.id.tv_name)
        tvAge = view.findViewById(R.id.tv_age)
        data
    }

    private val data: Unit
        private get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable("name") as OnePieceModel?
                ivFullScreen?.let {
                    it.context?.let { it1 ->
                        Glide.with(it1).load(model?.image).into(ivFullScreen!!)
                    }
                }
                tvName?.text = model?.name
                tvAge?.text = model?.age.toString()
            }
        }
}
