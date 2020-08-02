package io.papamangto.moviemvvm.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.oxcoding.moviemvvm.data.vo.Movie
import io.papamangto.moviemvvm.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by seongtaek on 02 Aug, 2020
 */
class MainActivityViewModel(private val movieRepository: MoviePagedListRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val moviePagedList: LiveData<PagedList<Movie>> by lazy {
        movieRepository.fetchLiveMoviePagedList(compositeDisposable)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getNetworkState()
    }

    fun listIsEmpty(): Boolean {
        return moviePagedList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}