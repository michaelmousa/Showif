package com.treehouse.showif.home

import com.treehouse.showif.model.PhotoData


interface HomeContract{

    interface View {
        fun showResults(result: List<PhotoData>)
        fun showError(message: String)
    }
    interface Presenter{
        fun getPhotoDetails(users: String)
    }
}