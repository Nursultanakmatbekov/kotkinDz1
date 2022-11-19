package com.example.kotkindz1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerFragment : Fragment(), OnItemClickListener {

    private val repository = OnePieceRepository()
    private val adapter = OnePieceAdapter(this)
    private var model: OnePieceModel? = null
    private var list: ArrayList<OnePieceModel>? = null
    private var rvListOfName: RecyclerView? = null
    private lateinit var btnAdd: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvListOfName = view.findViewById(R.id.rv_list_of_name)
        btnAdd = view.findViewById(R.id.btn_add)
        list = repository.getListOfCharacters()
        adapter.setData(list)
        initialize()
        setOnClickListener()
        addData()
    }

    private fun initialize() {
        rvListOfName?.adapter = adapter
    }

    private fun setOnClickListener() {
        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ThirdFragment())
                .addToBackStack("RecyclerFragment")
                .commit()
        }
    }

    private fun addData() {
        parentFragmentManager.setFragmentResultListener("bundle", viewLifecycleOwner)
        { requestKey, result ->
            if (requestKey == "bundle") {
                model = result.getSerializable("serializable") as OnePieceModel?
                model?.let { list?.add(it) }
                adapter.setData(list)
            }
        }
    }

    override fun onClick(model: OnePieceModel) {
        val bundle = Bundle()
        bundle.putSerializable("name", model)
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailFragment::class.java, bundle)
            .addToBackStack("RecyclerFragment")
            .commit()
    }
}