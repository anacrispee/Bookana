package com.example.feature_explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.model.BookModel

class BookAdapter(
    private var books: List<BookModel>
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookModel) {
            itemView.findViewById<ImageView>(R.id.bookImage).load(book.information?.cover)
            itemView.findViewById<TextView>(R.id.bookName).text = book.information?.title
            itemView.findViewById<TextView>(R.id.author).text =
                book.information?.authors?.firstOrNull()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
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