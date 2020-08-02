package io.papamangto.moviemvvm.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.oxcoding.moviemvvm.data.vo.Movie
import io.papamangto.moviemvvm.data.api.POST_PER_PAGE
import io.papamangto.moviemvvm.data.api.TheMovieDBInterface
import io.papamangto.moviemvvm.data.repository.MovieDataSource
import io.papamangto.moviemvvm.data.repository.MovieDataSourceFactory
import io.papamangto.moviemvvm.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by seongtaek on 02 Aug, 2020
 */
class MoviePagedListRepository(private val apiService: TheMovieDBInterface) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var movieDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        movieDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(movieDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap(movieDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)
    }
}