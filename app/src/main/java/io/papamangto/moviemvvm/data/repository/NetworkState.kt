package io.papamangto.moviemvvm.data.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

/**
 * Created by seongtaek on 23 Jul, 2020
 */
class NetworkState(val status: Status, val msg: String) {

    companion object {

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "Success")

            LOADING = NetworkState(Status.RUNNING, "Running")

            ERROR = NetworkState(Status.FAILED, "Something went wrong")
        }
    }

}