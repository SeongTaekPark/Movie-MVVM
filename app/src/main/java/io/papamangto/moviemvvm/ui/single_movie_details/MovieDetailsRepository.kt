package io.papamangto.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import io.papamangto.moviemvvm.data.api.TheMovieDBInterface
import io.papamangto.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import io.papamangto.moviemvvm.data.repository.NetworkState
import io.papamangto.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by seongtaek on 25 Jul, 2020
 */
class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    // git-flow 설명 테스트

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}