package stas.batura.guardianapi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import stas.batura.guardianapi.R

class HomeFragment : MvpAppCompatFragment() , HomeUiView{

    @InjectPresenter lateinit var homePresenter: HomePresenter

    lateinit var recyclerView : RecyclerView
    lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewManager = LinearLayoutManager(parentFragment!!.requireContext())

        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rss_list_recycler_view.apply {
            layoutManager = viewManager
        }

//        rss_list_recycler_view.adapter =

    }

    override fun getListData(adapter: NewsListAdapter) {
        rss_list_recycler_view.adapter = adapter
    }
}