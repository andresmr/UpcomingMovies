package upcomingmovies.andresmr.com.upcomingmovies.ui.adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_movies.view.*
import upcomingmovies.andresmr.com.upcomingmovies.R
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result

class UpcomingMoviesListAdapter(val moviesList:List<Result>, val listener: (Result) -> Unit) :
        RecyclerView.Adapter<UpcomingMoviesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_movies, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int){
        holder?.bind(moviesList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Result, listener: (Result) -> Unit) = with(itemView) {
            tvName.text = item.title
            setOnClickListener { listener(item) }
        }
    }
}