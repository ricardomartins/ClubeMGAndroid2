package pt.rikmartins.clubemg.clubemgandroid.data

sealed class DataOperation
sealed class MapOperation<out K, out D>: DataOperation()
sealed class CollectionOperation<out D>: DataOperation()
data class MapAdd<out K, out D>(val key: K, val data: D): MapOperation<K, D>()
data class MapRemove<out K, out D>(val key: K): MapOperation<K, D>()
data class CollectionAdd<out D>(val data: D) : CollectionOperation<D>()
data class CollectionRemove<out D>(val data: D) : CollectionOperation<D>()
