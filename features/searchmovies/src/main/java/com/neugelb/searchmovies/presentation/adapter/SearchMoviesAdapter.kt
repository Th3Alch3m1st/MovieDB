package com.neugelb.searchmovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.neugelb.core.model.MovieUIModel
import com.neugelb.core.util.setSafeOnClickListener
import com.neugelb.feature.searchmovies.databinding.SingleItemMovieSearchBinding

/**
 * Created By Rafiqul Hasan
 */
class SearchMoviesAdapter(val onItemClicked: (MovieUIModel) -> Unit?) :
	PagingDataAdapter<MovieUIModel, SearchMoviesAdapter.MovieViewHolder>(ImageComparator) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
		return MovieViewHolder(
			SingleItemMovieSearchBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
		val imageItem = getItem(position)
		imageItem?.let { item ->
			holder.bind(item)
		}

		holder.binding.cardView.setSafeOnClickListener {
			imageItem?.let {
				onItemClicked(imageItem)
			}
		}
	}

	inner class MovieViewHolder(val binding: SingleItemMovieSearchBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(imageUIModel: MovieUIModel) = with(binding) {
			movieInfo = imageUIModel
		}
	}

	private object ImageComparator : DiffUtil.ItemCallback<MovieUIModel>() {
		override fun areItemsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel) =
			oldItem.id == newItem.id

		override fun areContentsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel) =
			oldItem == newItem
	}
}