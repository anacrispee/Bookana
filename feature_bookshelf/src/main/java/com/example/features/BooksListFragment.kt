package com.example.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.model.BookModel
import com.example.domain.model.dummyBooksList

class BooksListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = BookAdapter(dummyBooksList) { selectedBook ->
            val action = BooksListFragmentDirections
                .actionBooksListFragmentToBookDetailsFragment(selectedBook)
            findNavController().navigate(action)
        }
        recyclerView.adapter = adapter
        return view
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book : BookModel) {
            itemView.findViewById<ImageView>(R.id.bookImage).load(book.image)
            itemView.findViewById<TextView>(R.id.bookName).text = book.name
            itemView.findViewById<TextView>(R.id.author).text = book.author
        }
    }

    class BookAdapter(
        private val books: List<BookModel>,
        private val onItemClick: (BookModel) -> Unit
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
            holder.itemView.setOnClickListener {
                onItemClick(book)
            }
        }

        override fun getItemCount(): Int {
            return books.size
        }
    }
}