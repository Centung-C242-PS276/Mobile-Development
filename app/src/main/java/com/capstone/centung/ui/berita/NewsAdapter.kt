package com.capstone.centung.ui.berita

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.centung.R

class NewsAdapter(private val newsList: List<LocalNews>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val image: ImageView = itemView.findViewById(R.id.imgNews)
        val sourceDate: TextView = itemView.findViewById(R.id.tvSourceDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = newsList[position]
        holder.title.text = article.title
        holder.description.text = article.description
        holder.sourceDate.text = "${article.source} | ${article.publishedAt}"
        val imageResId = holder.itemView.context.resources.getIdentifier(article.image, "drawable", holder.itemView.context.packageName)
        if (imageResId != 0) {
            holder.image.setImageResource(imageResId)
        } else {
            Glide.with(holder.itemView.context).load(article.image).into(holder.image)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = newsList.size
}