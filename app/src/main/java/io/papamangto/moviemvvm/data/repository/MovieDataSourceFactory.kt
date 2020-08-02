package io.papamangto.moviemvvm.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.oxcoding.moviemvvm.data.vo.Movie
import io.papamangto.moviemvvm.data.api.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by seongtaek on 01 Aug, 2020
 */
class MovieDataSourceFactory(private val apiService: TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}