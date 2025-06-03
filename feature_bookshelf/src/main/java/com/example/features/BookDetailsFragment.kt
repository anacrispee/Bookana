package com.example.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load

class BookDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_details_fragment, container, false)
        val bundle = arguments

        val args = BookDetailsFragmentArgs.fromBundle(bundle!!)

        view.findViewById<ImageView>(R.id.bookImage).load(args.book.cover)
        view.findViewById<TextView>(R.id.bookName).text = args.book.title
        view.findViewById<TextView>(R.id.author).text = args.book.author.firstOrNull()

        return view.rootView
    }
}