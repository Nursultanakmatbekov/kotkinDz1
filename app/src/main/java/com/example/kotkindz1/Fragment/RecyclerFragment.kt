package com.example.kotkindz1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kotkindz1.OnItemClickListener
import com.example.kotkindz1.OnePieceAdapter
import com.example.kotkindz1.OnePieceModel
import com.example.kotkindz1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerFragment : Fragment(), OnItemClickListener {

    private val repository = RecyclerFragment()
    private val adapter = OnePieceAdapter(this)
    private var rvListOfName: RecyclerView? = null
    private var buttomAdd: FloatingActionButton? = null
    private var edUrl: EditText? = null
    private var edName: EditText? = null
    private var edAge: EditText? = null
    private var model: OnePieceModel? = null
    private var list: ArrayList<OnePieceModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvListOfName = view.findViewById(R.id.rv_list_of_name)
        buttomAdd = view.findViewById(R.id.btn_add)
        list = repository.getListOfCharacters()
        edUrl = view.findViewById(R.id.ed_url)
        edName = view.findViewById(R.id.ed_name)
        edAge = view.findViewById(R.id.ed_age)
        setUpListeners()
        onAdd()
    }

    override fun onClick(model: OnePieceModel) {
        val bundle = Bundle()
        bundle.putSerializable("name", model)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DetailFragment::class.java, bundle)
            .addToBackStack("RecyclerFragment")
            .commit()
    }

    private fun setUpListeners() {
        buttomAdd?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ThirdFragment())
                .addToBackStack("RecyclerFragment")
                .commit()
        }
    }

    private fun onAdd() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "bundle", viewLifecycleOwner) { requestKey, result ->
            if (requestKey == "bundle") {
                model = result.getSerializable("serializable") as OnePieceModel?
                list!!.add(model!!)
                adapter.setData(list)
            }
        }
    }
}