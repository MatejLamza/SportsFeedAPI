package com.example.sportapitask.view.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapitask.R
import com.example.sportapitask.data.models.domain.AthleteModel
import com.example.sportapitask.view.adapters.AthleteAdapter
import com.example.sportapitask.viewmodels.AthleteViewModel
import com.example.sportapitask.viewmodels.factory.AthleteVMFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_athletes.*
import javax.inject.Inject

class FragmentAthlete : Fragment() {

    @Inject
    lateinit var factory: AthleteVMFactory

    private var athletes: ArrayList<AthleteModel> = arrayListOf()

    private lateinit var athleteVM: AthleteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: GridLayoutManager
    private lateinit var adapter: AthleteAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    //
    override fun onDestroy() {
        recyclerView.adapter = null
        super.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_athletes, container, false)
        initRecyclerView(view)

        athleteVM = ViewModelProvider(this, factory).get(AthleteViewModel::class.java)
        athleteVM.getAthlete()

        athleteVM.liveAthlete.observe(viewLifecycleOwner, Observer {
            athletes.add(it)
            initTestData()
            adapter.loadAthletes(athletes)
            adapter.notifyDataSetChanged()
        })

        return view
    }

    private fun initTestData(){
        val athlete = AthleteModel(23,null,"Test Club",null,"Test Name",null)
        val athlete2 = AthleteModel(23,null,"Test Club",null,"Test Name",null)
        val athlete3 = AthleteModel(23,null,"Test Club",null,"Test Name",null)
        athletes.add(athlete)
        athletes.add(athlete2)
        athletes.add(athlete3)
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.rec_athletes)
        recyclerView.setHasFixedSize(true)

        manager = GridLayoutManager(view.context,2)
        adapter = AthleteAdapter()
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}