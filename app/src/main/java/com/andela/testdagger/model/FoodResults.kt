package com.andela.testdagger.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.provider.BaseColumns
import com.google.gson.annotations.SerializedName

@Entity(tableName = "foodArticles")
data class FoodResults (
        var id: Long? = null,

        var columnId: String? = BaseColumns._ID,

        @SerializedName("per_facet") val perFacet: List<Any?>? = null,

        @SerializedName("subsection") val subsection: String? = null,

        @SerializedName("item_type") val itemType: String? = null,

         @SerializedName("org_facet") val orgFacet: List<String?>? = null,

        @SerializedName("section") var section: String? = null,

        @SerializedName("newsType") var newsType: String? = null,

        @SerializedName("abstract") val jsonMemberAbstract: String? = null,

         @SerializedName("title") var title: String? = null,

        @SerializedName("des_facet") val desFacet: List<String?>? = null,

         @SerializedName("url") var url: String? = null,

        @SerializedName("short_url") val shortUrl: String? = null,

        @SerializedName("material_type_facet") val materialTypeFacet: String? = null,

         @SerializedName("multimedia") var multimedia: List<MultimediaItem?>? = null,

        @SerializedName("geo_facet") val geoFacet: List<Any?>? = null,

         @SerializedName("updated_date") var updatedDate: String? = null,

         @SerializedName("created_date") var createdDate: String? = null,

         @SerializedName("byline") val byline: String? = null,

         @SerializedName("published_date") var publishedDate: String? = null,

        @SerializedName("kicker") val kicker: String? = null
)