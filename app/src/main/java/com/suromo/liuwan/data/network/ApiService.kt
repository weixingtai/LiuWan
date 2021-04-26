package com.suromo.liuwan.data.network

import com.suromo.liuwan.data.model.ArticleList
import com.suromo.liuwan.data.model.Response
import com.suromo.liuwan.data.model.User
import retrofit2.http.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 网络请求接口
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): Response<ArticleList>

    //
//    @GET("/banner/json")
//    suspend fun getBanner(): WanResponse<List<Banner>>
//
//    @GET("/tree/json")
//    suspend fun getSystemType(): WanResponse<List<SystemParent>>
//
//    @GET("/article/list/{page}/json")
//    suspend fun getSystemTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): WanResponse<ArticleList>
//
//    @GET("/navi/json")
//    suspend fun getNavigation(): WanResponse<List<Navigation>>
//
//    @GET("/project/tree/json")
//    suspend fun getProjectType(): WanResponse<List<SystemParent>>
//
//    @GET("/wxarticle/chapters/json")
//    suspend fun getBlogType(): WanResponse<List<SystemParent>>
//
//    @GET("/wxarticle/list/{id}/{page}/json")
//    fun getBlogArticle(@Path("id") id: Int, @Path("page") page: Int): WanResponse<ArticleList>
//
//    @GET("/project/list/{page}/json")
//    suspend fun getProjectTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): WanResponse<ArticleList>
//
//    @GET("/article/listproject/{page}/json")
//    suspend fun getLastedProject(@Path("page") page: Int): WanResponse<ArticleList>
//
//    @GET("/friend/json")
//    suspend fun getWebsites(): WanResponse<List<Hot>>
//
//    @GET("/hotkey/json")
//    suspend fun getHot(): WanResponse<List<Hot>>
//
//    @FormUrlEncoded
//    @POST("/article/query/{page}/json")
//    suspend fun searchHot(@Path("page") page: Int, @Field("k") key: String): WanResponse<ArticleList>
//
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") passWord: String
    ): Response<User>

    //
//    @GET("/user/logout/json")
//    suspend fun logOut(): WanResponse<Any>
//
    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(
        @Field("username") userName: String,
        @Field("password") passWord: String,
        @Field("repassword") rePassWord: String
    ): Response<User>
//
//    @GET("/lg/collect/list/{page}/json")
//    suspend fun getCollectArticles(@Path("page") page: Int): WanResponse<ArticleList>
//
//    @POST("/lg/collect/{id}/json")
//    suspend fun collectArticle(@Path("id") id: Int): WanResponse<ArticleList>
//
//    @POST("/lg/uncollect_originId/{id}/json")
//    suspend fun cancelCollectArticle(@Path("id") id: Int): WanResponse<ArticleList>
//
//    @GET("/user_article/list/{page}/json")
//    suspend fun getSquareArticleList(@Path("page") page: Int): WanResponse<ArticleList>

//    @FormUrlEncoded
//    @POST("/lg/user_article/add/json")
//    suspend fun shareArticle(@Field("title") title: String, @Field("link") url: String): WanResponse<String>

}