package com.example.retrofit_demo.model

data class UserModel(
    val avatar_url: String? = "",
    val bio: String? = "",
    val blog: String? = "",
    val company: String? = "",
    val created_at: String? = "",
    val email: Any? = Any(),
    val events_url: String? = "",
    val followers: Int? = 0,
    val followers_url: String? = "",
    val following: Int? = 0, // 3
    val following_url: String? = "",
    val gists_url: String? = "",
    val gravatar_id: String? = "",
    val hireable: Any? = Any(),
    val html_url: String? = "",
    val id: Int? = 0,
    val location: Any? = Any(),
    val login: String? = "",
    val name: String? = "",
    val node_id: String? = "",
    val organizations_url: String? = "",
    val public_gists: Int? = 0, // 1
    val public_repos: Int? = 0, // 40
    val received_events_url: String? = "",
    val repos_url: String? = "",
    val site_admin: Boolean? = false,
    val starred_url: String? = "",
    val subscriptions_url: String? = "",
    val twitter_username: Any? = Any(),
    val type: String? = "",
    val updated_at: String? = "",
    val url: String? = ""
)