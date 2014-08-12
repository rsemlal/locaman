package net.locaman.api.data.core

object ObjectRef {
  def unapply(o: ObjectRef) = Some((o.uri))

}

trait ObjectRef {
  def uri = s"$domain/$path"
  def path: String = s"${parents.map(_.path).mkString("/")}/$directory/$id"

  def domain:String
  def parents: Seq[ObjectRef]
  def directory: String
  def id: String
}