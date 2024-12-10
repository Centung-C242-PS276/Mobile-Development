package com.capstone.centung.ui.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.centung.R
import com.capstone.centung.ui.berita.LocalNews
import com.capstone.centung.ui.berita.NewsAdapter
import com.capstone.centung.ui.berita.loadNewsFromJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**.ui.news.NewsFragment
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        val newsList = loadNewsFromJson(requireContext())
        adapter = NewsAdapter(newsList)
        recyclerView.adapter = adapter


        val pageTitle = view.findViewById<TextView>(R.id.tvPageTitle)
        pageTitle.text = "Berita Terkait Stunting"
    }

    fun loadNewsFromJson(context: Context): List<LocalNews> {
        val inputStream = context.resources.openRawResource(R.raw.news_data)
        val json = inputStream.bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<LocalNews>>() {}.type
        return Gson().fromJson(json, type)
    }
}
