package com.example.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import com.example.domain.utils.replaceWithEllipsis

class BookDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_details_fragment, container, false)
        val bundle = arguments

        val args = BookDetailsFragmentArgs.fromBundle(bundle!!)

        view.findViewById<ImageView>(R.id.bookImage).load(args.book.information?.cover)
        view.findViewById<TextView>(R.id.bookName).text = args.book.information?.title
        view.findViewById<TextView>(R.id.author).text = args.book.information?.authors?.firstOrNull()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookNameAsToolbarTitle()
    }

    private fun setBookNameAsToolbarTitle() {
        val args = BookDetailsFragmentArgs.fromBundle(requireArguments())
        val bookName = args.book.information?.title?.replaceWithEllipsis()

        (requireActivity() as AppCompatActivity).supportActionBar?.title = bookName
    }
}