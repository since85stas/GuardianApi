package stas.batura.guardianapi.ui.home

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HomeUiView : MvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun getListData(adapter: NewsListAdapter)


}