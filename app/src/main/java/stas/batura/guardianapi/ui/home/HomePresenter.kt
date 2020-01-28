package stas.batura.guardianapi.ui.home

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import stas.batura.vkapitest.repository.net.RetrofitClient
import java.lang.Exception


@InjectViewState
class HomePresenter : MvpPresenter<HomeUiView>() {

    private val TAG = javaClass.simpleName

    private lateinit var listData : List<Int>

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun attachView(view: HomeUiView?) {
        super.attachView(view)
        Log.d(TAG, "create")

        listData = listOf(1,2,3,4)
        val adapter = NewsListAdapter(listData)
        viewState.getListData(adapter)

//        coroutineScope.launch {
//            val defered = RetrofitClient.netApi.retrofitServise.asyncGetFeed()
//            try {
//                val channel =defered.await().channel
//                Log.d(TAG, channel.toString())
//                listData = channel.item
//                listData.filter { item -> item.title.equals("Python") }
//                val adapter = NewsListAdapter(listData)
//
//                viewState.getListData(adapter)
//            } catch (e:Exception) {
//                Log.d(TAG,"error loading")
//            }
//        }

    }


}