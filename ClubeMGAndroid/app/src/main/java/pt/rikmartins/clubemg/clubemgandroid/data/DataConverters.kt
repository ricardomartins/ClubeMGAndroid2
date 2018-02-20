package pt.rikmartins.clubemg.clubemgandroid.data

import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiEvent
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiPost
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiTaxonomy
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Event
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Post
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Taxonomy

abstract class Converter<A, L> {
    abstract fun apiToLocal(apiModel: A): L
    abstract fun localToApi(localModel: L): A

    fun apiToLocalList(aIterable: Iterable<A>) : List<L> = aIterable.map { apiToLocal(it) }
    fun localToApiList(lIterable: Iterable<L>) : List<A> = lIterable.map { localToApi(it) }
}

class PostConverter : Converter<ApiPost, Post>() {
    override fun apiToLocal(apiModel: ApiPost): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun localToApi(localModel: Post): ApiPost {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class EventConverter : Converter<ApiEvent, Event>() {
    override fun apiToLocal(apiModel: ApiEvent): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun localToApi(localModel: Event): ApiEvent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class TaxonomyConverter : Converter<ApiTaxonomy, Taxonomy>() {
    override fun apiToLocal(apiModel: ApiTaxonomy): Taxonomy {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun localToApi(localModel: Taxonomy): ApiTaxonomy {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

