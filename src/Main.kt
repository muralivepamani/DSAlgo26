import practice.LRUCache

fun main() {

  val cache = LRUCache(2)

  cache.put(1, 100)
  cache.put(2, 200)

  println(cache.get(1))

  cache.put(3, 300)

  println(cache.get(1))
  println(cache.get(2))
  println(cache.get(3))
}