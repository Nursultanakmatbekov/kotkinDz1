package com.example.kotkindz1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ThirdFragment : Fragment() {

    private var edUrl: EditText? = null
    private var edName: EditText? = null
    private var edAge: EditText? = null
    private var btAdd: MaterialButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edUrl = view.findViewById(R.id.add_url)
        edName = view.findViewById(R.id.add_name)
        edAge = view.findViewById(R.id.add_age)
        btAdd = view.findViewById(R.id.bt_add)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btAdd!!.setOnClickListener { view: View? ->
            val edURL = edUrl!!.text.toString().trim { it <= ' ' }
            val edNAME = edName!!.text.toString().trim { it <= ' ' }
            val edAGE = edAge!!.text.toString().trim { it <= ' ' }
            if (edURL.isEmpty() && edNAME.isEmpty() && edAGE.isEmpty()) {
                edUrl!!.error = "error"
                edName!!.error = "error"
                edAge!!.error = "error"
            } else if (edURL.isEmpty()) {
                edUrl!!.error = "error"
            } else if (edNAME.isEmpty()) {
                edName!!.error = "error"
            } else if (edAGE.isEmpty()) {
                edAge!!.error = "error"
            } else {
                val bundle = Bundle()
                val model = OnePieceModel(edURL, edNAME, edAGE.toInt(), "#36D375")
                bundle.putSerializable("serializable", model)
                parentFragmentManager.setFragmentResult("bundle", bundle)
                parentFragmentManager.popBackStack()
            }
        }
    }
}