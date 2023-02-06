package com.neugelb.movies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.neugelb.core.model.MovieUIModel
import com.neugelb.core.util.setSafeOnClickListener
import com.neugelb.feature.latestmovies.databinding.SingleItemMovieBinding

/**
 * Created By Rafiqul Hasan
 */
class LatestMoviesAdapter(val onItemClicked: (MovieUIModel) -> Unit?) :
	PagingDataAdapter<MovieUIModel, LatestMoviesAdapter.ImageViewHolder>(ImageComparator) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
		return ImageViewHolder(
			SingleItemMovieBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
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

	inner class ImageViewHolder(val binding: SingleItemMovieBinding) :
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