package pt.rikmartins.clubemg.clubemgandroid.data.local

data class DataLink(val link: String, val obtained: Boolean) {
    constructor(link: String) : this(link, false)

    companion object {
        fun fabricateFromLink(link: String?): DataLink? {
            return if (link != null) DataLink(link) else null
        }
    }
}