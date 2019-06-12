package com.treehouse.showif.network

import com.treehouse.showif.model.PhotoData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoServices {
    @GET(END_POINT)

    fun getPhotoDetails(@Query("users/mojombo") users:String ): Observable<List<PhotoData>>
}

