package com.example.feature_explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookAdapter

    private val viewModel : ExploreViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.explore_fragment, container, false)
        recyclerView = view.findViewById(R.id.gridRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = BookAdapter(emptyList())
        recyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchBooksByName()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.books.collectLatest { books ->
                adapter.updateBooks(books)
            }
        }
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book : BookModel) {
            itemView.findViewById<ImageView>(R.id.bookImage).load(book.cover)
            itemView.findViewById<TextView>(R.id.bookName).text = book.title
            itemView.findViewById<TextView>(R.id.author).text = book.author.firstOrNull()
        }
    }

    class BookAdapter(
        private var books: List<BookModel>
    ) : RecyclerView.Adapter<BookViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BookViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
            return BookViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: BookViewHolder,
            position: Int
        ) {
            val book = books[position]
            holder.bind(book)
        }

        override fun getItemCount(): Int {
            return books.size
        }

        fun updateBooks(newBooks: List<BookModel>) {
            books = newBooks
            notifyDataSetChanged()
        }
    }
}