package stas.batura.guardianapi.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.news_list_rss_view.view.*
import stas.batura.guardianapi.R

class NewsListAdapter (private val data : List<Int>)
    : RecyclerView.Adapter<NewsListAdapter.RssViewHolder>() {

    class RssViewHolder(val view: View) : RecyclerView.ViewHolder(view) , LayoutContainer{

        fun bind(item: Int) {
            view.item_title.text = item.toString()
        }

        override val containerView: View?
            get() = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_rss_view,parent,false)
        return RssViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        holder.bind(data.get(position))
    }
}