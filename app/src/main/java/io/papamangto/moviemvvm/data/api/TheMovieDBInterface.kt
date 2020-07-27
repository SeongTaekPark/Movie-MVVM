package io.papamangto.moviemvvm.data.api

import com.oxcoding.moviemvvm.data.vo.MovieResponse
import io.papamangto.moviemvvm.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=e8dbcd82366648ccdea9585a068fd5eb&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=e8dbcd82366648ccdea9585a068fd5eb
    // https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}