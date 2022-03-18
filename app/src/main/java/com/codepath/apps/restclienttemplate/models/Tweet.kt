package com.codepath.apps.restclienttemplate.models

import org.json.JSONArray
import org.json.JSONObject
import TimeFormatter

class Tweet {
    var body: String = ""
    var createdAt: String = ""
    var user: User? = null

    companion object {
        fun fromJson(jsonObject: JSONObject): Tweet {
            val tweet = Tweet()
            tweet.body = jsonObject.getString("text")
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"))

            fun getFormattedTimeStamp(): String {
                return TimeFormatter.getTimeDifference(jsonObject.getString("created_at"));
            }

            tweet.createdAt = getFormattedTimeStamp()

            return tweet
        }

        fun fromJsonArray(jsonArray: JSONArray): List<Tweet>{
            val tweets = ArrayList<Tweet>()
            for(i in 0 until jsonArray.length()){
                tweets.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return tweets
        }
    }
}