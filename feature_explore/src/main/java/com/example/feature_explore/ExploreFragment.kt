package com.example.feature_explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utils.isNetworkAvailable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookAdapter

    private val viewModel: ExploreViewModel by viewModel()

    private lateinit var progressBar: ProgressBar
    private lateinit var emptyStateView: View
    private lateinit var networkErrorView: View
    private lateinit var tryAgainButton: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.explore_fragment, container, false)

        recyclerView = view.findViewById(R.id.gridRecyclerView)
        progressBar = view.findViewById(R.id.progressBar)
        emptyStateView = view.findViewById(R.id.emptyStateLayout)
        networkErrorView = view.findViewById(R.id.networkErrorLayout)
        tryAgainButton = view.findViewById(R.id.tryAgainButton)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = BookAdapter(emptyList())
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkNetworkAndLoadData()
        networkErrorButtonListener()
    }

    private fun checkNetworkAndLoadData() {
        val currentContext = context

        currentContext?.let {
            if (isNetworkAvailable(it).not()) {
                showNetworkErrorState()
            } else {
                networkErrorView.visibility = View.GONE
                viewModel.searchBooksByName()

                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.uiState.collectLatest { state ->
                        when (state) {
                            is UiState.Loading -> showLoadingState()
                            is UiState.Success -> {
                                adapter.updateBooks(state.data)
                                showContent()
                            }
                            is UiState.Empty -> showEmptyState()
                            is UiState.Error -> {} //showErrorState()
                        }
                    }
                }
            }
        }
    }

    private fun showNetworkErrorState() {
        networkErrorView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        emptyStateView.visibility = View.GONE
        progressBar.visibility = View.GONE
    }

    private fun showLoadingState() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        emptyStateView.visibility = View.GONE
        networkErrorView.visibility = View.GONE
    }

    private fun showEmptyState() {
        emptyStateView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.GONE
        networkErrorView.visibility = View.GONE
    }

    private fun showContent() {
        recyclerView.visibility = View.VISIBLE
        emptyStateView.visibility = View.GONE
        progressBar.visibility = View.GONE
        networkErrorView.visibility = View.GONE
    }

    private fun networkErrorButtonListener() {
        tryAgainButton.setOnClickListener {
            showLoadingState()
            checkNetworkAndLoadData()
        }
    }
}