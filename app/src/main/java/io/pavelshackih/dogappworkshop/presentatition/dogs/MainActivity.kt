package io.pavelshackih.dogappworkshop.presentatition.dogs

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import io.pavelshackih.dogappworkshop.R
import io.pavelshackih.dogappworkshop.domain.Breed

class MainActivity : MvpAppCompatActivity(), DogsView {

    @InjectPresenter
    lateinit var presenter: DogsPresenter

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun setDogs(list: List<Breed>) {
        val adapter: DogAdapter
        if (recyclerView.adapter == null) {
            adapter = DogAdapter()
            adapter.list = list
            recyclerView.adapter = adapter
        } else {
            adapter = recyclerView.adapter as DogAdapter
            adapter.list = list
        }
        adapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    class DogViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val imageView: CircleImageView = item.findViewById(R.id.image_view)
        private val textView: TextView = item.findViewById(R.id.text_view)

        fun bind(breed: Breed) {
            textView.text = breed.name
            Glide.with(itemView)
                    .load(breed.image)
                    .into(imageView)
        }
    }

    class DogAdapter : RecyclerView.Adapter<DogViewHolder>() {

        var list: List<Breed> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return DogViewHolder(inflater.inflate(R.layout.view_holder, parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
            holder.bind(list[position])
        }
    }
}
